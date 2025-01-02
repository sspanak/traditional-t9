package io.github.sspanak.tt9.db.words;

import android.content.Context;
import android.os.CancellationSignal;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import io.github.sspanak.tt9.db.BaseSyncStore;
import io.github.sspanak.tt9.db.entities.AddWordResult;
import io.github.sspanak.tt9.db.entities.NormalizationList;
import io.github.sspanak.tt9.db.entities.Word;
import io.github.sspanak.tt9.db.entities.WordList;
import io.github.sspanak.tt9.db.sqlite.DeleteOps;
import io.github.sspanak.tt9.db.sqlite.InsertOps;
import io.github.sspanak.tt9.db.sqlite.ReadOps;
import io.github.sspanak.tt9.db.sqlite.UpdateOps;
import io.github.sspanak.tt9.languages.EmojiLanguage;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.NullLanguage;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.util.Logger;
import io.github.sspanak.tt9.util.Text;
import io.github.sspanak.tt9.util.Timer;


public class WordStore extends BaseSyncStore {
	public static final String FILTER_EXACT_MATCHES_ONLY = "__exact__";
	private final String LOG_TAG = "sqlite.WordStore";
	private final ReadOps readOps;


	public WordStore(@NonNull Context context) {
		super(context);
		readOps = new ReadOps();
	}


	/**
	 * Returns a list of the languages that are already loaded in the database.
	 */
	public ArrayList<Integer> exists(ArrayList<Language> languages) {
		ArrayList<Integer> loadedLanguages = new ArrayList<>();

		if (!checkOrNotify()) {
			return loadedLanguages;
		}

		for (Language language : languages) {
			if (readOps.exists(sqlite.getDb(), language.getId())) {
				loadedLanguages.add(language.getId());
			}
		}

		return loadedLanguages;
	}


	/**
	 * Loads words matching and similar to a given digit sequence
	 * For example: "7655" -> "roll" (exact match), but also: "rolled", "roller", "rolling", ...
	 * and other similar. When "wordFilter" is set to FILTER_EXACT_MATCHES_ONLY, the word list is
	 * constrained only to the words with length equal to the digit sequence length (exact matches).
	 */
	public ArrayList<String> getMany(@NonNull CancellationSignal cancel, Language language, String sequence, String wordFilter, int minimumWords, int maximumWords) {
		if (!checkOrNotify()) {
			return new ArrayList<>();
		}

		if (sequence == null || sequence.isEmpty()) {
			Logger.w(LOG_TAG, "Attempting to get words for an empty sequence.");
			return new ArrayList<>();
		}

		if (language == null || language instanceof NullLanguage) {
			Logger.w(LOG_TAG, "Attempting to get words for NULL language.");
			return new ArrayList<>();
		}

		Timer.start("cache_long_positions");
		readOps.cacheLongPositionsIfMissing(sqlite.getDb(), language);
		long longPositionsTime = Timer.stop("cache_long_positions");

		final int minWords = Math.max(minimumWords, 0);
		final int maxWords = Math.max(maximumWords, minWords);
		final String filter = wordFilter == null ? "" : wordFilter;

		Timer.start("get_positions");
		String positions = readOps.getSimilarWordPositions(sqlite.getDb(), cancel, language, sequence, filter, minWords);
		long positionsTime = Timer.stop("get_positions");

		Timer.start("get_words");
		ArrayList<String> words = readOps.getWords(sqlite.getDb(), cancel, language, positions, filter, maxWords, false).toStringList();
		long wordsTime = Timer.stop("get_words");

		printLoadingSummary(sequence, words, longPositionsTime, positionsTime, wordsTime);
		if (!cancel.isCanceled()) { // do not cache empty results from aborted queries
			SlowQueryStats.add(language, sequence, wordFilter, minWords, (int) (positionsTime + wordsTime), positions);
		}

		return words;
	}


	@NonNull public ArrayList<String> getSimilarCustom(String wordFilter, int maxWords) {
		return checkOrNotify() ? readOps.getCustomWords(sqlite.getDb(), wordFilter, maxWords) : new ArrayList<>();
	}


	public long countCustom() {
		return checkOrNotify() ? readOps.countCustomWords(sqlite.getDb()) : 0;
	}


	@NonNull public String getLanguageFileHash(Language language) {
		return language != null && !(language instanceof NullLanguage) && checkOrNotify() ? readOps.getLanguageFileHash(sqlite.getDb(), language.getId()) : "";
	}


	public void remove(Language language) {
		if (checkOrNotify() && readOps.exists(sqlite.getDb(), language.getId())) {
			DeleteOps.delete(sqlite.getDb(), language.getId());
		}
	}


	public void removeCustomWord(Language language, String word) {
		if (language == null || language instanceof NullLanguage || !checkOrNotify()) {
			return;
		}

		try {
			sqlite.beginTransaction();
			DeleteOps.deleteCustomWord(sqlite.getDb(), language.getId(), word);
			DeleteOps.deleteCustomWord(sqlite.getDb(), new EmojiLanguage().getId(), word);
			sqlite.finishTransaction();
		} catch (Exception e) {
			sqlite.failTransaction();
			Logger.e(LOG_TAG, "Failed deleting custom word: '" + word + "' for language: " + language.getId() + ". " + e.getMessage());
		}
	}


	@NonNull public AddWordResult put(Language language, String word) {
		if (word == null || word.isEmpty()) {
			return new AddWordResult(AddWordResult.CODE_BLANK_WORD, word);
		}

		if (language == null || language instanceof NullLanguage) {
			return new AddWordResult(AddWordResult.CODE_INVALID_LANGUAGE, word);
		}

		if (!checkOrNotify()) {
			return new AddWordResult(AddWordResult.CODE_GENERAL_ERROR, word);
		}

		language = Text.isGraphic(word) ? new EmojiLanguage() : language;

		try {
			if (readOps.exists(sqlite.getDb(), language, word)) {
				return new AddWordResult(AddWordResult.CODE_WORD_EXISTS, word);
			}

			String sequence = language.getDigitSequenceForWord(word);

			if (InsertOps.insertCustomWord(sqlite.getDb(), language, sequence, word)) {
				makeTopWord(language, word, sequence);
			} else {
				throw new Exception("SQLite INSERT failure.");
			}
		} catch (Exception e) {
			String msg = "Failed inserting word: '" + word + "' for language: " + language.getId() + ". " + e.getMessage();
			Logger.e("insertWord", msg);
			return new AddWordResult(AddWordResult.CODE_GENERAL_ERROR, word);
		}

		return new AddWordResult(AddWordResult.CODE_SUCCESS, word);
	}


	public void makeTopWord(@NonNull Language language, @NonNull String word, @NonNull String sequence) {
		if (!checkOrNotify() || word.isEmpty() || sequence.isEmpty() || language instanceof NullLanguage) {
			return;
		}

		try {
			Timer.start(LOG_TAG);

			String topWordPositions = readOps.getWordPositions(sqlite.getDb(), null, language, sequence, 0, 0, "");
			WordList topWords = readOps.getWords(sqlite.getDb(), null, language, topWordPositions, "", 9999, true);
			if (topWords.isEmpty()) {
				throw new Exception("No such word");
			}

			Word topWord = topWords.get(0);
			if (topWord.word.toUpperCase(language.getLocale()).equals(word.toUpperCase(language.getLocale()))) {
				Logger.d(LOG_TAG, "Word '" + word + "' is already the top word. Time: " + Timer.stop(LOG_TAG) + " ms");
				return;
			}

			int wordPosition = 0;
			for (Word tw : topWords) {
				if (tw.word.toUpperCase(language.getLocale()).equals(word.toUpperCase(language.getLocale()))) {
					wordPosition = tw.position;
					break;
				}
			}

			int newTopFrequency = topWord.frequency + 1;
			Text wordFilter = new Text(language, word.length() == 1 ? word : null);
			if (!UpdateOps.changeFrequency(sqlite.getDb(), language, wordFilter, wordPosition, newTopFrequency)) {
				throw new Exception("No such word");
			}

			if (newTopFrequency > SettingsStore.WORD_FREQUENCY_MAX) {
				scheduleNormalization(language, topWordPositions);
			}

			Logger.d(LOG_TAG, "Changed frequency of '" + word + "' to: " + newTopFrequency + ". Time: " + Timer.stop(LOG_TAG) + " ms");
		} catch (Exception e) {
			Logger.e(LOG_TAG,"Frequency change failed. Word: '" + word + "'. " + e.getMessage());
		}
	}


	public void normalizeNext() {
		if (!checkOrNotify()) {
			return;
		}

		Timer.start(LOG_TAG);

		try {
			sqlite.beginTransaction();
			NormalizationList normalizationList = readOps.getNextInNormalizationQueue(sqlite.getDb());
			UpdateOps.normalize(sqlite.getDb(), normalizationList);
			sqlite.finishTransaction();

			String message = normalizationList.langId > 0 ? "Normalized language: " + normalizationList.langId + ", positions: " + normalizationList.positions : "No languages to normalize";
			Logger.d(LOG_TAG, message + ". Time: " + Timer.stop(LOG_TAG) + " ms");
		} catch (Exception e) {
			sqlite.failTransaction();
			Logger.e(LOG_TAG, "Normalization failed. " + e.getMessage());
		}
	}


	public void scheduleNormalization(Language language, String positions) {
		if (language != null && !(language instanceof NullLanguage) && positions != null && !positions.isEmpty() && checkOrNotify()) {
			UpdateOps.scheduleNormalization(sqlite.getDb(), language, positions);
		}
	}


	private void printLoadingSummary(String sequence, ArrayList<String> words, long longPositionsTime, long positionIndexTime, long wordsTime) {
		if (!Logger.isDebugLevel()) {
			return;
		}

		StringBuilder debugText = new StringBuilder("===== Word Loading Summary =====");
		debugText
			.append("\nWord Count: ").append(words.size())
			.append(".\nTime: ").append(positionIndexTime + wordsTime)
			.append(" ms (positions: ").append(positionIndexTime)
			.append(" ms, long positions: ").append(longPositionsTime)
			.append(" ms, words: ").append(wordsTime).append(" ms).");

		if (words.isEmpty()) {
			debugText.append(" Sequence: ").append(sequence);
		} else {
			debugText.append("\n").append(words);
		}

		Logger.d(LOG_TAG, debugText.toString());
	}
}
