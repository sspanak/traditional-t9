package io.github.sspanak.tt9.util.chars;

import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.sspanak.tt9.hacks.DeviceInfo;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.LanguageKind;

class Punctuation {
	public static final String GR_QUESTION_MARK = ";";
	public static final String NEW_LINE = DeviceInfo.AT_LEAST_ANDROID_6 && new Paint().hasGlyph("⏎") ? "⏎" : "\\n";
	public static final String ZWJ = "\u200D";
	public static final String ZWJ_GRAPHIC = "ZWJ";
	public static final String ZWNJ = "\u200C";
	public static final String ZWNJ_GRAPHIC = "ZWNJ";

	final public static ArrayList<Character> CombiningPunctuation = new ArrayList<>(Arrays.asList(
		',', '-', '\'', ':', ';', '!', '?', '.'
	));

	final public static ArrayList<Character> CombiningPunctuationFarsi = new ArrayList<>(Arrays.asList(
		'،', ZWNJ.charAt(0), '-', '\'', ':', '؛', '!', '؟', '.'
	));

	final private static ArrayList<Character> CombiningPunctuationGujarati = new ArrayList<>(Arrays.asList(
		'્', '઼', 'ઽ', 'ઃ', '।', '॰', '॥' // Indic combining chars look the same, but have different Unicode values
	));

	final private static ArrayList<Character> CombiningPunctuationHindi = new ArrayList<>(Arrays.asList(
		'्', '़', 'ऽ', 'ः', '।', '॰', '॥' // Indic combining chars look the same, but have different Unicode values
	));

	final private static ArrayList<Character> CombiningPunctuationHebrew = new ArrayList<>(Arrays.asList(
		',' , '-', '\'', ':', ';', '!', '?', '.', '"'
	));

	final public static ArrayList<String> PunctuationArabic = new ArrayList<>(Arrays.asList(
		"،", ".", "-", "(", ")", "&", "~", "`", "'", "\"",  "؛", ":", "!", "؟"
	));

	final public static ArrayList<String> PunctuationEnglish = new ArrayList<>(Arrays.asList(
		",", ".", "-", "(", ")", "&", "~", "`", ";", ":", "'", "\"", "!", "?"
	));

	// the same as Arabic + ZWNJ
	final public static ArrayList<String> PunctuationFarsi = new ArrayList<>(Arrays.asList(
		"،", ".", "-", ZWNJ, "(", ")", "&", "~", "`", "'", "\"",  "؛", ":", "!", "؟"
	));

	final public static ArrayList<String> PunctuationFrench = new ArrayList<>(Arrays.asList(
		",", ".", "-", "«", "»", "(", ")", "&", "`", "~", ";", ":", "'", "\"", "!", "?"
	));

	final public static ArrayList<String> PunctuationGerman = new ArrayList<>(Arrays.asList(
		",", ".", "-", "„", "“", "(", ")", "&", "~", "`", "'", "\"", ";", ":", "!", "?"
	));

	final public static ArrayList<String> PunctuationGreek = new ArrayList<>(Arrays.asList(
		",", ".", "-", "«", "»", "(", ")", "&", "~", "`", "'", "\"", "·", ":", "!", GR_QUESTION_MARK
	));

	final public static ArrayList<String> PunctuationIndic = new ArrayList<>(Arrays.asList(
		",", ".", "-", ZWJ, ZWNJ, "(", ")", "।", "॰", "॥", "&", "~", "`", ";", ":", "'", "\"", "!", "?"
	));

	final public static ArrayList<String> PunctuationKorean = new ArrayList<>(Arrays.asList(
		",", ".", "~", "1", "(", ")", "&", "-", "`", ";", ":", "'", "\"", "!", "?"
	));

	public static boolean isCombiningPunctuation(Language language, char ch) {
		return
			CombiningPunctuation.contains(ch)
			|| (LanguageKind.isFarsi(language) && CombiningPunctuationFarsi.contains(ch))
			|| (LanguageKind.isGujarati(language) && CombiningPunctuationGujarati.contains(ch))
			|| (LanguageKind.isHindi(language) && CombiningPunctuationHindi.contains(ch))
			|| (LanguageKind.isHebrew(language) && CombiningPunctuationHebrew.contains(ch));
	}

	public static boolean isCombiningPunctuation(char ch) {
		return
			CombiningPunctuation.contains(ch)
			|| CombiningPunctuationFarsi.contains(ch)
			|| CombiningPunctuationGujarati.contains(ch)
			|| CombiningPunctuationHindi.contains(ch)
			|| CombiningPunctuationHebrew.contains(ch);
	}
}
