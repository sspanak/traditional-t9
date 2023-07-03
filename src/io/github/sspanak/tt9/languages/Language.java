package io.github.sspanak.tt9.languages;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class Language {
	private int id;
	protected String name;
	protected Locale locale;
	protected String dictionaryFile;
	protected String abcString;
	protected final ArrayList<ArrayList<String>> layout = new ArrayList<>();
	private final HashMap<Character, String> characterKeyMap = new HashMap<>();

	// settings
	protected boolean hasUpperCase = true;


	public static Language fromDefinition(LanguageDefinition definition) throws Exception {
		if (definition.dictionaryFile.isEmpty()) {
			throw new Exception("Invalid definition. Dictionary file must be set.");
		}

		if (definition.locale.isEmpty()) {
			throw new Exception("Invalid definition. Locale cannot be empty.");
		}

		Locale definitionLocale;
		switch (definition.locale) {
			case "de":
				definitionLocale = Locale.GERMAN;
				break;
			case "en":
				definitionLocale = Locale.ENGLISH;
				break;
			case "fr":
				definitionLocale = Locale.FRENCH;
				break;
			case "it":
				definitionLocale = Locale.ITALIAN;
				break;
			default:
				String[] parts = definition.locale.split("-", 2);
				if (parts.length == 2) {
					definitionLocale = new Locale(parts[0], parts[1]);
				} else if (parts.length == 1) {
					definitionLocale = new Locale(parts[0]);
				} else {
					throw new Exception("Unrecognized locale format: '" + definition.locale + "'.");
				}
		}

		Language lang = new Language();
		lang.abcString = definition.abcString.isEmpty() ? lang.abcString : definition.abcString;
		lang.dictionaryFile = definition.getDictionaryFile();
		lang.hasUpperCase = definition.hasUpperCase;
		lang.locale = definitionLocale;
		lang.name = definition.name.isEmpty() ? lang.name : definition.name;

		for (int key = 0; key <= 9 || key < definition.layout.size(); key++) {
			lang.layout.add(keyCharsFromDefinition(key, definition.layout.get(key)));
		}

		return lang;
	}


	private static ArrayList<String> keyCharsFromDefinition(int key, ArrayList<String> definitionChars) {
		if (key > 1) {
			return definitionChars;
		}

		final String specialCharsPlaceholder = "SPECIAL";
		final String punctuationPlaceholder = "PUNCTUATION";
		final String frenchStylePlaceholder = punctuationPlaceholder + "_FR";
		final String germanStylePlaceholder = punctuationPlaceholder + "_DE";

		ArrayList<String> keyChars = new ArrayList<>();
		for (String defChar : definitionChars) {
			switch (defChar) {
				case specialCharsPlaceholder:
					keyChars.addAll(Characters.Special);
					break;
				case punctuationPlaceholder:
					keyChars.addAll(Characters.PunctuationEnglish);
					break;
				case frenchStylePlaceholder:
					keyChars.addAll(Characters.PunctuationFrench);
					break;
				case germanStylePlaceholder:
					keyChars.addAll(Characters.PunctuationGerman);
					break;
				default:
					keyChars.add(defChar);
					break;
			}
		}

		return keyChars;
	}


	final public int getId() {
		if (id == 0) {
			id = generateId();
		}

		return id;
	}

	final public Locale getLocale() {
		return locale;
	}

	final public String getName() {
		if (name == null) {
			name = locale != null ? capitalize(locale.getDisplayLanguage(locale)) : "";
		}

		return name;
	}

	final public String getDictionaryFile() {
		return dictionaryFile;
	}

	final public String getAbcString() {
		if (abcString == null) {
			ArrayList<String> lettersList = getKeyCharacters(2, false);

			abcString = "";
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lettersList.size() && i < 3; i++) {
				sb.append(lettersList.get(i));
			}

			abcString = sb.toString();
		}

		return abcString;
	}


	public boolean hasUpperCase() {
		return hasUpperCase;
	}


	/* ************ utility ************ */

	/**
	 * generateId
	 * Uses the letters of the Locale to generate an ID for the language.
	 * Each letter is converted to uppercase and used as n 5-bit integer. Then the the 5-bits
	 * are packed to form a 10-bit or a 20-bit integer, depending on the Locale.
	 *
	 * Example (2-letter Locale)
	 * 	"en"
	 * 	-> "E" | "N"
	 * 	-> 5 | 448 (shift the 2nd number by 5 bits, so its bits would not overlap with the 1st one)
	 *	-> 543
	 *
	 * Example (4-letter Locale)
	 * 	"bg-BG"
	 * 	-> "B" | "G" | "B" | "G"
	 * 	-> 2 | 224 | 2048 | 229376 (shift each 5-bit number, not overlap with the previous ones)
	 *	-> 231650
	 */
	private int generateId() {
		String idString = (locale.getLanguage() + locale.getCountry()).toUpperCase();
		int idInt = 0;
		for (int i = 0; i < idString.length(); i++) {
			idInt |= ((idString.charAt(i) & 31) << (i * 5));
		}

		return idInt;
	}

	private void generateCharacterKeyMap() {
		characterKeyMap.clear();
		for (int digit = 0; digit <= 9; digit++) {
			for (String keyChar : getKeyCharacters(digit)) {
				characterKeyMap.put(keyChar.charAt(0), String.valueOf(digit));
			}
		}
	}

	public String capitalize(String word) {
		if (word == null) {
			return null;
		}

		String capitalizedWord = "";

		if (!word.isEmpty()) {
			capitalizedWord += word.substring(0, 1).toUpperCase(locale);
		}

		if (word.length() > 1) {
			capitalizedWord += word.substring(1).toLowerCase(locale);
		}

		return capitalizedWord;
	}

	public boolean isMixedCaseWord(String word) {
		return word != null
			&& (
				(word.length() == 1 && word.toUpperCase(locale).equals(word))
				|| (!word.toLowerCase(locale).equals(word) && !word.toUpperCase(locale).equals(word))
			);
	}

	public ArrayList<String> getKeyCharacters(int key, boolean includeDigit) {
		if (key < 0 || key >= layout.size()) {
			return new ArrayList<>();
		}

		ArrayList<String> chars = new ArrayList<>(layout.get(key));
		if (includeDigit && chars.size() > 0) {
			chars.add(String.valueOf(key));
		}

		return chars;
	}

	public ArrayList<String> getKeyCharacters(int key) {
		return getKeyCharacters(key, true);
	}

	public String getDigitSequenceForWord(String word) throws InvalidLanguageCharactersException {
		StringBuilder sequence = new StringBuilder();
		String lowerCaseWord = word.toLowerCase(locale);

		if (characterKeyMap.isEmpty()) {
			generateCharacterKeyMap();
		}

		for (int i = 0; i < lowerCaseWord.length(); i++) {
			char letter = lowerCaseWord.charAt(i);
			if (!characterKeyMap.containsKey(letter)) {
				throw new InvalidLanguageCharactersException(this, "Failed generating digit sequence for word: '" + word);
			}

			sequence.append(characterKeyMap.get(letter));
		}

		return sequence.toString();
	}

	@NonNull
	@Override
	public String toString() {
		return getName();
	}
}
