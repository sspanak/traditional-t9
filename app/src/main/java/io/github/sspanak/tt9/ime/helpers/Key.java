package io.github.sspanak.tt9.ime.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;

import androidx.annotation.NonNull;

import java.util.HashMap;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.LanguageCollection;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.util.Ternary;
import io.github.sspanak.tt9.util.Text;

public class Key {
	private static final HashMap<Integer, Ternary> handledKeys = new HashMap<>();


	public static void setHandled(int keyCode, Ternary handled) {
		handledKeys.put(keyCode, handled);
	}


	public static boolean setHandled(int keyCode, boolean handled) {
		handledKeys.put(keyCode, handled ? Ternary.TRUE : Ternary.FALSE);
		return handled;
	}


	public static boolean isHandled(int keyCode) {
		return handledKeys.containsKey(keyCode) && handledKeys.get(keyCode) == Ternary.TRUE;
	}


	public static boolean isHandledInSuper(int keyCode) {
		return handledKeys.containsKey(keyCode) && handledKeys.get(keyCode) == Ternary.ALTERNATIVE;
	}


	public static boolean isBackspace(SettingsStore settings, int keyCode) {
		return
			keyCode == KeyEvent.KEYCODE_DEL
			|| keyCode == KeyEvent.KEYCODE_CLEAR
			|| keyCode == settings.getKeyBackspace();
	}


	public static boolean isNumber(int keyCode) {
		return
			(keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9)
			|| (keyCode >= KeyEvent.KEYCODE_NUMPAD_0 && keyCode <= KeyEvent.KEYCODE_NUMPAD_9);
	}


	public static boolean isHotkey(SettingsStore settings, int keyCode) {
		return
			keyCode == settings.getKeyAddWord()
			|| keyCode == settings.getKeyBackspace()
			|| keyCode == settings.getKeyCommandPalette()
			|| keyCode == settings.getKeyEditText()
			|| keyCode == settings.getKeyFilterClear()
			|| keyCode == settings.getKeyFilterSuggestions()
			|| keyCode == settings.getKeyPreviousSuggestion()
			|| keyCode == settings.getKeyNextSuggestion()
			|| keyCode == settings.getKeyNextInputMode()
			|| keyCode == settings.getKeyNextLanguage()
			|| keyCode == settings.getKeySelectKeyboard()
			|| keyCode == settings.getKeyShift()
			|| keyCode == settings.getKeyShowSettings()
			|| keyCode == settings.getKeyVoiceInput();
	}


	public static boolean isBack(int keyCode) {
		return keyCode == KeyEvent.KEYCODE_BACK;
	}


	public static boolean isPoundOrStar(int keyCode) {
		return keyCode == KeyEvent.KEYCODE_POUND || keyCode == KeyEvent.KEYCODE_STAR;
	}


	public static boolean isOK(int keyCode) {
		return
			keyCode == KeyEvent.KEYCODE_DPAD_CENTER
			|| keyCode == KeyEvent.KEYCODE_ENTER
			|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
	}


	public static int codeToNumber(SettingsStore settings, int keyCode) {
		return switch (keyCode) {
			case KeyEvent.KEYCODE_0, KeyEvent.KEYCODE_NUMPAD_0 -> 0;
			case KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_NUMPAD_1 -> settings.getUpsideDownKeys() ? 7 : 1;
			case KeyEvent.KEYCODE_2, KeyEvent.KEYCODE_NUMPAD_2 -> settings.getUpsideDownKeys() ? 8 : 2;
			case KeyEvent.KEYCODE_3, KeyEvent.KEYCODE_NUMPAD_3 -> settings.getUpsideDownKeys() ? 9 : 3;
			case KeyEvent.KEYCODE_4, KeyEvent.KEYCODE_NUMPAD_4 -> 4;
			case KeyEvent.KEYCODE_5, KeyEvent.KEYCODE_NUMPAD_5 -> 5;
			case KeyEvent.KEYCODE_6, KeyEvent.KEYCODE_NUMPAD_6 -> 6;
			case KeyEvent.KEYCODE_7, KeyEvent.KEYCODE_NUMPAD_7 -> settings.getUpsideDownKeys() ? 1 : 7;
			case KeyEvent.KEYCODE_8, KeyEvent.KEYCODE_NUMPAD_8 -> settings.getUpsideDownKeys() ? 2 : 8;
			case KeyEvent.KEYCODE_9, KeyEvent.KEYCODE_NUMPAD_9 -> settings.getUpsideDownKeys() ? 3 : 9;
			default -> -1;
		};
	}

	public static int numberToCode(int number) {
		if (number >= 0 && number <= 9) {
			return KeyEvent.KEYCODE_0 + number;
		} else {
			return -1;
		}
	}

	@SuppressLint("GestureBackNavigation") // we are not handling anything here, the warning makes no sense
	public static String codeToName(@NonNull Context context, int keyCode) {
		return switch (keyCode) {
			case KeyEvent.KEYCODE_UNKNOWN -> context.getString(R.string.key_none);
			case KeyEvent.KEYCODE_POUND -> "#";
			case KeyEvent.KEYCODE_STAR -> "✱";
			case KeyEvent.KEYCODE_BACK -> context.getString(R.string.key_back);
			case KeyEvent.KEYCODE_CALL -> context.getString(R.string.key_call);
			case KeyEvent.KEYCODE_CHANNEL_DOWN -> context.getString(R.string.key_channel_down);
			case KeyEvent.KEYCODE_CHANNEL_UP -> context.getString(R.string.key_channel_up);
			case KeyEvent.KEYCODE_DPAD_UP -> context.getString(R.string.key_dpad_up);
			case KeyEvent.KEYCODE_DPAD_DOWN -> context.getString(R.string.key_dpad_down);
			case KeyEvent.KEYCODE_DPAD_LEFT -> context.getString(R.string.key_dpad_left);
			case KeyEvent.KEYCODE_DPAD_RIGHT -> context.getString(R.string.key_dpad_right);
			case KeyEvent.KEYCODE_MENU -> context.getString(R.string.key_menu);
			case KeyEvent.KEYCODE_NUMPAD_ADD -> "Num +";
			case KeyEvent.KEYCODE_NUMPAD_DIVIDE -> "Num /";
			case KeyEvent.KEYCODE_NUMPAD_DOT -> "Num .";
			case KeyEvent.KEYCODE_NUMPAD_MULTIPLY -> "Num *";
			case KeyEvent.KEYCODE_NUMPAD_SUBTRACT -> "Num -";
			case KeyEvent.KEYCODE_PROG_RED -> context.getString(R.string.key_red);
			case KeyEvent.KEYCODE_PROG_GREEN -> context.getString(R.string.key_green);
			case KeyEvent.KEYCODE_PROG_YELLOW -> context.getString(R.string.key_yellow);
			case KeyEvent.KEYCODE_PROG_BLUE -> context.getString(R.string.key_blue);
			case KeyEvent.KEYCODE_SOFT_LEFT -> context.getString(R.string.key_soft_left);
			case KeyEvent.KEYCODE_SOFT_RIGHT -> context.getString(R.string.key_soft_right);
			case KeyEvent.KEYCODE_VOLUME_MUTE -> context.getString(R.string.key_volume_mute);
			case KeyEvent.KEYCODE_VOLUME_DOWN -> context.getString(R.string.key_volume_down);
			case KeyEvent.KEYCODE_VOLUME_UP -> context.getString(R.string.key_volume_up);
			default -> codeToSystemName(context, keyCode);
		};
	}

	private static String codeToSystemName(@NonNull Context context, int keyCode) {
		String name = KeyEvent.keyCodeToString(keyCode).replace("KEYCODE_", "");

		if (new Text(name).isNumeric()) {
			return context.getString(R.string.key_key) + " #" + name;
		}

		Language english = LanguageCollection.getByLanguageCode("en");
		String[] parts = name.split("_");
		StringBuilder formattedName = new StringBuilder();
		for (int i = 0; i < parts.length; i++) {
			formattedName.append(new Text(english, parts[i].toLowerCase()).capitalize());
			if (i < parts.length - 1) {
				formattedName.append(" ");
			}
		}

		return formattedName.toString();
	}
}
