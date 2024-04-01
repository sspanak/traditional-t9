package io.github.sspanak.tt9.db;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import io.github.sspanak.tt9.db.entities.Word;
import io.github.sspanak.tt9.db.entities.WordList;
import io.github.sspanak.tt9.db.sqlite.DeleteOps;
import io.github.sspanak.tt9.db.sqlite.InsertOps;
import io.github.sspanak.tt9.db.sqlite.ReadOps;
import io.github.sspanak.tt9.db.sqlite.SQLiteOpener;
import io.github.sspanak.tt9.db.sqlite.UpdateOps;
import io.github.sspanak.tt9.languages.EmojiLanguage;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.NullLanguage;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.dialogs.AddWordDialog;
import io.github.sspanak.tt9.util.Logger;
import io.github.sspanak.tt9.util.Text;
import io.github.sspanak.tt9.util.Timer;


public class WordStore {
	private final String LOG_TAG = "sqlite.WordStore";
	private static WordStore self;

	private SQLiteOpener sqlite = null;
	private ReadOps readOps = null;


	private WordStore(@NonNull Context context) {
		try {
			sqlite = SQLiteOpener.getInstance(context);
			sqlite.getDb();
			readOps = new ReadOps();
		} catch (Exception e) {
			Logger.w(LOG_TAG, "Database connection failure. All operations will return empty results. " + e.getMessage());
		}
		self = this;
	}


	public static synchronized WordStore getInstance(@NonNull Context context) {
		if (self == null) {
			self = new WordStore(context);
		}

		return self;
	}


	/**
	 * Loads words matching and similar to a given digit sequence
	 * For example: "7655" -> "roll" (exact match), but also: "rolled", "roller", "rolling", ...
	 * and other similar.
	 */
	public ArrayList<String> getSimilar(Language language, String sequence, String wordFilter, int minimumWords, int maximumWords) {
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

		final int minWords = Math.max(minimumWords, 0);
		final int maxWords = Math.max(maximumWords, minWords);
		final String filter = wordFilter == null ? "" : wordFilter;

		Timer.start("get_positions");
		String positions = readOps.getSimilarWordPositions(sqlite.getDb(), language, sequence, filter, minWords);
		long positionsTime = Timer.stop("get_positions");

		Timer.start("get_words");
		ArrayList<String> words = readOps.getWords(sqlite.getDb(), language, positions, filter, maxWords, false).toStringList();
		long wordsTime = Timer.stop("get_words");

		printLoadingSummary(sequence, words, positionsTime, wordsTime);
		SlowQueryStats.add(SlowQueryStats.generateKey(language, sequence, wordFilter, minWords), (int) (positionsTime + wordsTime), positions);

		return words;
	}


	@NonNull public ArrayList<String> getSimilarCustom(Language language, String wordFilter) {
		return language != null && !(language instanceof NullLanguage) && checkOrNotify() ? readOps.getCustomWords(sqlite.getDb(), language, wordFilter) : new ArrayList<>();
	}


	@NonNull public String getLanguageFileHash(Language language) {
		return language != null && !(language instanceof NullLanguage) && checkOrNotify() ? readOps.getLanguageFileHash(sqlite.getDb(), language.getId()) : "";
	}


	public void remove(ArrayList<Integer> languageIds) {
		if (!checkOrNotify()) {
			return;
		}

		Timer.start(LOG_TAG);
		try {
			sqlite.beginTransaction();
			for (int langId : languageIds) {
				if (readOps.exists(sqlite.getDb(), langId)) {
					DeleteOps.delete(sqlite.getDb(), langId);
				}
			}
			sqlite.finishTransaction();

			Logger.d(LOG_TAG, "Deleted " + languageIds.size() + " languages. Time: " + Timer.stop(LOG_TAG) + " ms");
		} catch (Exception e) {
			sqlite.failTransaction();
			Logger.e(LOG_TAG, "Failed deleting languages. " + e.getMessage());
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



	public int put(Language language, String word) {
		if (word == null || word.isEmpty()) {
			return AddWordDialog.CODE_BLANK_WORD;
		}

		if (language == null || language instanceof NullLanguage) {
			return AddWordDialog.CODE_INVALID_LANGUAGE;
		}

		if (!checkOrNotify()) {
			return AddWordDialog.CODE_GENERAL_ERROR;
		}

		language = Text.isGraphic(word) ? new EmojiLanguage() : language;

		try {
			if (readOps.exists(sqlite.getDb(), language, word)) {
				return AddWordDialog.CODE_WORD_EXISTS;
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
			return AddWordDialog.CODE_GENERAL_ERROR;
		}

		return AddWordDialog.CODE_SUCCESS;
	}


	private boolean checkOrNotify() {
		if (sqlite == null || sqlite.getDb() == null) {
			Logger.e(LOG_TAG, "No database connection. Cannot query any data.");
			return false;
		}

		return true;
	}


	public void makeTopWord(@NonNull Language language, @NonNull String word, @NonNull String sequence) {
		if (!checkOrNotify() || word.isEmpty() || sequence.isEmpty() || language instanceof NullLanguage) {
			return;
		}

		try {
			Timer.start(LOG_TAG);

			String topWordPositions = readOps.getWordPositions(sqlite.getDb(), language, sequence, 0, 0, "");
			WordList topWords = readOps.getWords(sqlite.getDb(), language, topWordPositions, "", 9999, true);
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
				scheduleNormalization(language);
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
			int nextLangId = readOps.getNextInNormalizationQueue(sqlite.getDb());
			UpdateOps.normalize(sqlite.getDb(), nextLangId);
			sqlite.finishTransaction();

			String message = nextLangId > 0 ? "Normalized language: " + nextLangId : "No languages to normalize";
			Logger.d(LOG_TAG, message + ". Time: " + Timer.stop(LOG_TAG) + " ms");
		} catch (Exception e) {
			sqlite.failTransaction();
			Logger.e(LOG_TAG, "Normalization failed. " + e.getMessage());
		}
	}


	public void scheduleNormalization(Language language) {
		if (language != null && !(language instanceof NullLanguage) && checkOrNotify()) {
			UpdateOps.scheduleNormalization(sqlite.getDb(), language);
		}
	}


	private void printLoadingSummary(String sequence, ArrayList<String> words, long positionIndexTime, long wordsTime) {
		if (!Logger.isDebugLevel()) {
			return;
		}

		StringBuilder debugText = new StringBuilder("===== Word Loading Summary =====");
		debugText
			.append("\nWord Count: ").append(words.size())
			.append(".\nTime: ").append(positionIndexTime + wordsTime)
			.append(" ms (positions: ").append(positionIndexTime)
			.append(" ms, words: ").append(wordsTime).append(" ms).");

		if (words.isEmpty()) {
			debugText.append(" Sequence: ").append(sequence);
		} else {
			debugText.append("\n").append(words);
		}

		Logger.d(LOG_TAG, debugText.toString());
	}
}
