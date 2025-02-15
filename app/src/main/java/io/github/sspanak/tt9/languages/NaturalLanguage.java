package io.github.sspanak.tt9.languages;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import io.github.sspanak.tt9.languages.exceptions.InvalidLanguageCharactersException;
import io.github.sspanak.tt9.util.Text;
import io.github.sspanak.tt9.util.TextTools;
import io.github.sspanak.tt9.util.chars.Characters;


public class NaturalLanguage extends Language implements Comparable<NaturalLanguage> {
	final public static String SPECIAL_CHAR_KEY = "0";
	final public static String PUNCTUATION_KEY = "1";
	final public static String PREFERRED_CHAR_SEQUENCE = "00";


	protected final ArrayList<ArrayList<String>> layout = new ArrayList<>();
	private final HashMap<Character, String> characterKeyMap = new HashMap<>();


	public static NaturalLanguage fromDefinition(LanguageDefinition definition) throws Exception {
		if (definition.dictionaryFile.isEmpty()) {
			throw new Exception("Invalid definition. Dictionary file must be set.");
		}

		NaturalLanguage lang = new NaturalLanguage();
		lang.abcString = definition.abcString.isEmpty() ? null : definition.abcString;
		lang.dictionaryFile = definition.getDictionaryFile();
		lang.hasSpaceBetweenWords = definition.hasSpaceBetweenWords;
		lang.hasUpperCase = definition.hasUpperCase;
		lang.isSyllabary = definition.isSyllabary;
		lang.name = definition.name.isEmpty() ? lang.name : definition.name;
		lang.setLocale(definition);
		lang.setLayout(definition);

		return lang;
	}


	private void setLocale(LanguageDefinition definition) throws Exception {
		if (definition.locale.isEmpty()) {
			throw new Exception("Invalid definition. Locale cannot be empty.");
		}

		if (definition.locale.equals("en")) {
			locale = Locale.ENGLISH;
		} else {
			String[] parts = definition.locale.split("-", 2);
			if (parts.length == 2) {
				locale = new Locale(parts[0], parts[1]);
			} else if (parts.length == 1) {
				locale = new Locale(parts[0]);
			} else {
				throw new Exception("Unrecognized locale format: '" + definition.locale + "'.");
			}
		}
	}


	private void setLayout(LanguageDefinition definition) {
		for (int key = 0; key <= 9 && key < definition.layout.size(); key++) {
				layout.add(
					key,
					key > 1 ? definition.layout.get(key) : generateSpecialChars(definition.layout.get(key))
				);
		}

		generateCharacterKeyMap();
	}


	private ArrayList<String> generateSpecialChars(ArrayList<String> definitionChars) {
		final String SPECIAL_CHARS_PLACEHOLDER = "SPECIAL";
		final String PUNCTUATION_PLACEHOLDER = "PUNCTUATION";

		final Map<String, List<String>> specialChars = new HashMap<>();
		specialChars.put(SPECIAL_CHARS_PLACEHOLDER, Characters.Special);
		specialChars.put(PUNCTUATION_PLACEHOLDER, Characters.PunctuationEnglish);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_AR", Characters.PunctuationArabic);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_FA", Characters.PunctuationFarsi);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_FR", Characters.PunctuationFrench);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_DE", Characters.PunctuationGerman);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_GR", Characters.PunctuationGreek);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_IN", Characters.PunctuationIndic);
		specialChars.put(PUNCTUATION_PLACEHOLDER + "_KR", Characters.PunctuationKorean);

		ArrayList<String> keyChars = new ArrayList<>();
		for (String defChar : definitionChars) {
			List<String> keySpecialChars = specialChars.containsKey(defChar) ? specialChars.get(defChar) : null;
			if (keySpecialChars != null) {
				keyChars.addAll(keySpecialChars);
			} else {
				keyChars.add(defChar);
			}
		}

		return keyChars;
	}


	/**
	 * generateId
	 * Uses the letters of the Locale to generate an ID for the language.
	 * Each letter is converted to uppercase and used as a 5-bit integer. Then the 5-bits
	 * are packed to form a 10-bit or a 20-bit integer, depending on the Locale length.
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
	 *
	 * Minimum ID: "aa" -> 33
	 * Maximum ID: "zz-ZZ" -> 879450
	 */
	@Override
	public int getId() {
		if (id == 0) {
			String idString = new LocaleCompat(locale).toString();
			for (int i = 0; i < idString.length(); i++) {
				id |= (idString.codePointAt(i) & 31) << (i * 5);
			}
		}

		return id;
	}


	private String getSortingId() {
		if ("IN".equals(getLocale().getCountry()) && "en".equals(getLocale().getLanguage())) {
			return "hi";
		}

		return switch (getLocale().getLanguage()) {
			case "fi" -> "su";
			case "sw" -> "ki";
			case "zgh" -> "tam";
			default -> getLocale().toString();
		};
	}


	@NonNull
	@Override
	public String getAbcString() {
		if (abcString == null) {
			ArrayList<String> lettersList = getKeyCharacters(2);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lettersList.size() && i < 3; i++) {
				sb.append(lettersList.get(i));
			}

			abcString = sb.toString();
		}

		return abcString;
	}


	@NonNull
	@Override
	public String getCode() {
		if (code == null) {
			code = new LocaleCompat(locale).getUniqueLanguageCode();
		}

		return code;
	}


	@NonNull
	@Override
	public String getName() {
		if (name == null) {
			name = new Text(this, locale.getDisplayLanguage(locale)).capitalize();
		}

		return name;
	}


	private void generateCharacterKeyMap() {
		characterKeyMap.clear();
		for (int digit = 0; digit <= 9; digit++) {
			for (String keyChar : getKeyCharacters(digit)) {
				characterKeyMap.put(keyChar.charAt(0), String.valueOf(digit));
			}
		}
	}


	@NonNull
	public ArrayList<String> getKeyCharacters(int key, int characterGroup) {
		if (key < 0 || key >= layout.size()) {
			return new ArrayList<>();
		}

		ArrayList<String> chars = layout.get(key);
		if (key == 0) {
			if (characterGroup > 1) {
				chars = new ArrayList<>();
			} else if (characterGroup == 1) {
				chars = new ArrayList<>(Characters.Currency);
			}
		}

		return chars;
	}


	@NonNull
	public String getKeyNumber(int key) {
		return key >= 0 && key < 10 && LanguageKind.isArabic(this) ? Characters.ArabicNumbers.get(key) : super.getKeyNumber(key);
	}


	@NonNull
	public String getDigitSequenceForWord(String word) throws InvalidLanguageCharactersException {
		StringBuilder sequence = new StringBuilder();
		String lowerCaseWord = word.toLowerCase(locale);

		for (int i = 0; i < lowerCaseWord.length(); i++) {
			char letter = lowerCaseWord.charAt(i);
			if (!characterKeyMap.containsKey(letter)) {
				throw new InvalidLanguageCharactersException(this, "Failed generating digit sequence for word: '" + word);
			}

			sequence.append(characterKeyMap.get(letter));
		}

		return sequence.toString();
	}



	public boolean isValidWord(String word) {
		if (
			word == null
			|| word.isEmpty()
			|| (isSyllabary && LanguageKind.isKorean(this) && TextTools.isHangul(word))
			|| (word.length() == 1 && Character.isDigit(word.charAt(0)))
		) {
			return true;
		}

		String lowerCaseWord = word.toLowerCase(locale);

		for (int i = 0; i < lowerCaseWord.length(); i++) {
			if (!characterKeyMap.containsKey(lowerCaseWord.charAt(i))) {
				return false;
			}
		}

		return true;
	}


	@Override
	public int compareTo(NaturalLanguage other) {
		return getSortingId().compareTo(other.getSortingId());
	}
}
