package io.github.sspanak.tt9.ime.modes.predictions;

import java.util.ArrayList;

import io.github.sspanak.tt9.db.DataStore;
import io.github.sspanak.tt9.ime.helpers.TextField;
import io.github.sspanak.tt9.languages.EmojiLanguage;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.util.TextTools;
import io.github.sspanak.tt9.util.chars.Characters;

public class WordPredictions extends Predictions {
	private final TextField textField;
	private LocaleWordsSorter localeWordsSorter;

	private String inputWord;
	private boolean isStemFuzzy;

	private String lastEnforcedTopWord;


	public WordPredictions(SettingsStore settings, TextField textField) {
		super(settings);
		lastEnforcedTopWord = "";
		localeWordsSorter = new LocaleWordsSorter(null);
		stem = "";
		this.textField = textField;
	}


	@Override
	public Predictions setLanguage(Language language) {
		super.setLanguage(language);
		localeWordsSorter = new LocaleWordsSorter(language);

		return this;
	}


	public WordPredictions setIsStemFuzzy(boolean yes) {
		this.isStemFuzzy = yes;
		return this;
	}


	public WordPredictions setStem(String stem) {
		this.stem = stem;
		return this;
	}


	public WordPredictions setInputWord(String inputWord) {
		this.inputWord = inputWord.toLowerCase(language.getLocale());
		return this;
	}


	private void loadWithoutLeadingPunctuation() {
		DataStore.getWords(
			(dbWords) -> {
				char firstChar = inputWord.isEmpty() ? 0 : inputWord.charAt(0);
				for (int i = 0; firstChar > 0 && i < dbWords.size(); i++) {
					dbWords.set(i, firstChar + dbWords.get(i));
				}
				onDbWords(dbWords, false);
			},
			language,
			digitSequence.substring(1),
			stem.length() > 1 ? stem.substring(1) : "",
			SettingsStore.SUGGESTIONS_MIN,
			SettingsStore.SUGGESTIONS_MAX
		);
	}


	@Override
	protected boolean isRetryAllowed() {
		return !EmojiLanguage.CUSTOM_EMOJI_SEQUENCE.equals(digitSequence);
	}

	/**
	 * dbWordsHandler
	 * Callback for when the database has finished loading words. If there were no matches in the database,
	 * they will be generated based on the "inputWord". After the word list is compiled, it notifies the
	 * external handler it is now possible to use it with "getList()".
	 */
	protected void onDbWords(ArrayList<String> dbWords, boolean isRetryAllowed) {
		// only the first round matters, the second one is just for getting the letters for a given key
		areThereDbWords = !dbWords.isEmpty() && isRetryAllowed;

		// If there were no database words for ",a", try getting the letters only (e.g. "a", "b", "c").
		// We do this to display them in the correct order.
		if (isRetryAllowed && dbWords.isEmpty() && digitSequence.length() == 2 && digitSequence.charAt(0) == '1') {
			loadWithoutLeadingPunctuation();
			return;
		}

		words.clear();
		if (digitSequence.equals(EmojiLanguage.CUSTOM_EMOJI_SEQUENCE)) {
			words.addAll(dbWords);
		} else {
			suggestStem();
			dbWords = localeWordsSorter.shouldSort(stem, digitSequence) ? localeWordsSorter.sort(dbWords) : dbWords;
			dbWords = rearrangeByPairFrequency(dbWords);
			suggestMissingWords(generatePossibleStemVariations(dbWords));
			suggestMissingWords(dbWords.isEmpty() ? generateWordVariations(inputWord) : dbWords);
			words = insertPunctuationCompletions(words);
		}

		onWordsChanged.run();
	}


	/**
	 * suggestStem
	 * Add the current stem filter to the predictions list, when it has length of X and
	 * the user has pressed X keys (otherwise, it makes no sense to add it).
	 */
	private void suggestStem() {
		if (!stem.isEmpty() && stem.length() == digitSequence.length()) {
			words.add(stem);
		}
	}


	/**
	 * generateWordVariations
	 * When there are no matching suggestions after the last key press, generate a list of possible
	 * ones, so that the user can complete a missing word that is completely different from the ones
	 * in the dictionary.
	 * For example, if the word is "missin_" and the last pressed key is "4", the results would be:
	 * | missing | missinh | missini |
	 */
	protected ArrayList<String> generateWordVariations(String baseWord) {
		ArrayList<String> generatedWords = new ArrayList<>();

		// This function is called from async context, so by the time it is executed, the digit sequence
		// might have been deleted. But in this case, it makes no sense to generate suggestions.
		if (digitSequence.isEmpty()) {
			return generatedWords;
		}

		// Make sure the displayed word and the digit sequence, we will be generating suggestions from,
		// have the same length, to prevent visual discrepancies.
		baseWord = (baseWord != null && !baseWord.isEmpty()) ? baseWord.substring(0, Math.min(digitSequence.length() - 1, baseWord.length())) : "";

		// append all letters for the last digit in the sequence (the last pressed key)
		int lastSequenceDigit = digitSequence.charAt(digitSequence.length() - 1) - '0';
		for (String keyLetter : settings.getOrderedKeyChars(language, lastSequenceDigit)) {
			if (Character.isAlphabetic(keyLetter.charAt(0)) || Characters.isCombiningPunctuation(language, keyLetter.charAt(0)) || TextTools.isCombining(keyLetter)) {
				generatedWords.add(baseWord + keyLetter);
			}
		}

		// if there are no letters for this key, just append the number
		if (generatedWords.isEmpty()) {
			generatedWords.add(baseWord + digitSequence.charAt(digitSequence.length() - 1));
		}

		containsGeneratedWords = true;
		return generatedWords;
	}


	/**
	 * insertPunctuationCompletions
	 * When given: "don'", for example, this inserts all other 1-key alternatives, like:
	 * "don.", "don?", "don!" and so on. The generated words will be inserted after the exact
	 * database matches, as if they were in the database with low frequency. This is to preserve the
	 * sorting by length and frequency.
	 * Finally, based on the discussion in <a href="https://github.com/sspanak/tt9/issues/634">Issue 634</a>,
	 * we skip the fuzzy matches, because it is more convenient to select the last word "don?" using
	 * a single key press, instead of longer words like "don't".
	 */
	private ArrayList<String> insertPunctuationCompletions(ArrayList<String> dbWords) {
		if (!stem.isEmpty() || dbWords.isEmpty() || digitSequence.length() < 2 || !digitSequence.endsWith("1")) {
			return dbWords;
		}

		ArrayList<String> complementedWords = new ArrayList<>();
		int exactMatchLength = digitSequence.length();

		// shortest database words (exact matches)
		for (String w : dbWords) {
			if (w.length() <= exactMatchLength) {
				complementedWords.add(w);
			}
		}

		// generated "exact matches"
		String baseWord = inputWord.length() == digitSequence.length() - 1 ? inputWord : dbWords.get(0);
		for (String w : generateWordVariations(baseWord)) {
			if (!dbWords.contains(w) && !dbWords.contains(w.toLowerCase(language.getLocale()))) {
				complementedWords.add(w);
			}
		}

		// no longer database words (skip the fuzzy matches)

		containsGeneratedWords = true;
		return complementedWords;
	}


	/**
	 * generatePossibleStemVariations
	 * Similar to generatePossibleCompletions(), but uses the current filter as a base word. This is
	 * used to complement the database results with all possible variations for the next key, when
	 * the stem filter is on.
	 * <p>
	 * It will not generate anything if more than one key was pressed after filtering though.
	 * <p>
	 * For example, if the filter is "extr", the current word is "extr_" and the user has pressed "1",
	 * the database would have returned only "extra", but this function would also
	 * generate: "extrb" and "extrc". This is useful for typing an unknown word, that is similar to
	 * the ones in the dictionary.
	 */
	private ArrayList<String> generatePossibleStemVariations(ArrayList<String> dbWords) {
		ArrayList<String> variations = new ArrayList<>();

		if (isStemFuzzy && !stem.isEmpty() && stem.length() == digitSequence.length() - 1) {
			ArrayList<String> allPossibleVariations = generateWordVariations(stem);

			// first add the known words, because it makes more sense to see them first
			for (String variation : allPossibleVariations) {
				if (dbWords.contains(variation)) {
					variations.add(variation);
				}
			}

			// then add the unknown ones, so they can be used as possible beginnings of new words.
			for (String word : allPossibleVariations) {
				if (!dbWords.contains(word)) {
					variations.add(word);
				}
			}
		}

		containsGeneratedWords = !variations.isEmpty();
		return variations;
	}


	/**
	 * onAccept
	 * This stores common word pairs, so they can be used in "rearrangeByPairFrequency()" method.
	 * For example, if the user types "I am an apple", the word "am" will be suggested after "I",
	 * and "an" after "am", even if "am" frequency was boosted right before typing "an". This both
	 * prevents from suggesting the same word twice in row and makes the suggestions more intuitive
	 * when there are many textonyms for a single sequence.
	 */
	public void onAccept(String word, String sequence) {
		if (
			word == null
			// If the word is the first suggestion, we have already guessed it right, and it makes no
			// sense to store it as a popular pair or increase its priority. However, if the stem has been
			// set using word filtering, the user has probably tried to search for a word that has not been
			// displayed at the beginning. In this case, we process it after all.
			|| (!words.isEmpty() && words.get(0).equals(word) && stem.isEmpty())
		) {
			return;
		}

		// Second condition note: If the accepted word is longer than the sequence, it is some different word,
		// not a textonym of the fist suggestion. We don't need to store it.
		if (settings.getPredictWordPairs() && word.length() == digitSequence.length()) {
			DataStore.addWordPair(language, textField.getWordBeforeCursor(language, 1, true), word, sequence);
		}

		// Update the priority only if the user has selected the word, not when we have enforced it
		// because it is in a popular word pair.
		if (!word.equals(lastEnforcedTopWord)) {
			DataStore.makeTopWord(language, word, sequence);
		}
	}


	/**
	 * rearrangeByPairFrequency
	 * Uses the last two words in the text field to rearrange the suggestions, so that the most popular
	 * one in a pair comes first. This is useful for typing phrases, like "I am an apple". Since, in
	 * "onAccept()", we have remembered the "am" comes after "I" and "an" comes after "am", we will
	 * not suggest the textonyms "am" or "an" twice (depending on which has the highest frequency).
	 */
	private ArrayList<String> rearrangeByPairFrequency(ArrayList<String> words) {
		lastEnforcedTopWord = "";

		if (!settings.getPredictWordPairs() || words.size() < 2) {
			return words;
		}

		ArrayList<String> rearrangedWords = new ArrayList<>();
		String penultimateWord = textField.getWordBeforeCursor(language, 1, true);

		String pairWord = DataStore.getWord2(language, penultimateWord, digitSequence);
		int morePopularIndex = TextTools.indexOfIgnoreCase(words, pairWord);
		if (morePopularIndex == -1) {
			return words;
		}

		lastEnforcedTopWord = words.get(morePopularIndex);
		rearrangedWords.add(lastEnforcedTopWord);

		for (int i = 0; i < words.size(); i++) {
			if (i != morePopularIndex) {
				rearrangedWords.add(words.get(i));
			}
		}

		return rearrangedWords;
	}
}
