package io.github.sspanak.tt9.util.chars;

import android.graphics.Paint;
import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;

class Emoji extends Punctuation {
	final private static ArrayList<String> TextEmoticons = new ArrayList<>(Arrays.asList(
		":)", ":D", ":P", ";)", "\\m/", ":-O", ":|", ":("
	));

	final private static ArrayList<ArrayList<String>> Emoji = new ArrayList<>(Arrays.asList(
		// positive
		new ArrayList<>(Arrays.asList(
			"🙂", "😀", "🤣", "🤓", "😎", "😛", "😉"
		)),
		// negative
		new ArrayList<>(Arrays.asList(
			"🙁", "😢", "😭", "😱", "😲", "😳", "😐", "😠"
		)),
		// hands
		new ArrayList<>(Arrays.asList(
			"👍", "👋", "✌️", "👏", "🖖", "🤘", "🤝", "💪", "👎"
		)),
		// emotions
		new ArrayList<>(Arrays.asList(
			"❤", "🤗", "😍", "😘", "😇", "😈", "🍺", "🎉", "🥱", "🤔", "🥶", "😬"
		))
	));

	public static boolean isGraphic(char ch) {
		return !(ch < 256 || Character.isLetterOrDigit(ch) || Character.isAlphabetic(ch));
	}

	public static boolean noEmojiSupported() {
		return Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
	}

	public static ArrayList<String> getEmoji(int level) {
		if (noEmojiSupported()) {
			return new ArrayList<>(TextEmoticons);
		}

		if (level < 0 || level >= Emoji.size()) {
			return new ArrayList<>();
		}

		Paint paint = new Paint();
		ArrayList<String> availableEmoji = new ArrayList<>();
		for (String emoji : Emoji.get(level)) {
			if (paint.hasGlyph(emoji)) {
				availableEmoji.add(emoji);
			}
		}

		return availableEmoji.isEmpty() ? new ArrayList<>(TextEmoticons) : availableEmoji;
	}

	public static int getMaxEmojiLevel() {
		return Emoji.size();
	}
}
