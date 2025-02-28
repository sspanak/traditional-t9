package io.github.sspanak.tt9.preferences.settings;

import android.content.Context;
import android.view.KeyEvent;

import java.util.HashMap;

import io.github.sspanak.tt9.preferences.screens.hotkeys.SectionKeymap;
import io.github.sspanak.tt9.util.Logger;

class SettingsHotkeys extends SettingsHacks {
	private static final String HOTKEY_VERSION = "hotkeys_v5";

	SettingsHotkeys(Context context) { super(context); }

	public boolean areHotkeysInitialized() {
		return !prefs.getBoolean(HOTKEY_VERSION, false);
	}

	public void setDefaultKeys(HashMap<String, Integer> defaultKeys) {
		for (String key : defaultKeys.keySet()) {
			prefsEditor.putString(key, String.valueOf(defaultKeys.get(key)));
		}

		prefsEditor.putBoolean(HOTKEY_VERSION, true).apply();
	}


	public int getFunctionKey(String functionName) {
		return getStringifiedInt(functionName, KeyEvent.KEYCODE_UNKNOWN);
	}


	public void setFunctionKey(String functionName, int keyCode) {
		if (isValidFunction(functionName)) {
			Logger.d(LOG_TAG, "Setting hotkey for function: '" + functionName + "' to " + keyCode);
			prefsEditor.putString(functionName, String.valueOf(keyCode)).apply();
		} else {
			Logger.w(LOG_TAG,"Not setting a hotkey for invalid function: '" + functionName + "'");
		}
	}


	public int getKeyAddWord() {
		return getFunctionKey(SectionKeymap.ITEM_ADD_WORD);
	}
	public int getKeyBackspace() {
		return getFunctionKey(SectionKeymap.ITEM_BACKSPACE);
	}
	public int getKeyCommandPalette() {
		return getFunctionKey(SectionKeymap.ITEM_COMMAND_PALETTE);
	}
	public int getKeyEditText() {
		return getFunctionKey(SectionKeymap.ITEM_EDIT_TEXT);
	}
	public int getKeyFilterClear() {
		return getFunctionKey(SectionKeymap.ITEM_FILTER_CLEAR);
	}
	public int getKeyFilterSuggestions() {
		return getFunctionKey(SectionKeymap.ITEM_FILTER_SUGGESTIONS);
	}
	public int getKeyPreviousSuggestion() {
		return getFunctionKey(SectionKeymap.ITEM_PREVIOUS_SUGGESTION);
	}
	public int getKeyNextSuggestion() {
		return getFunctionKey(SectionKeymap.ITEM_NEXT_SUGGESTION);
	}
	public int getKeyNextInputMode() {
		return getFunctionKey(SectionKeymap.ITEM_NEXT_INPUT_MODE);
	}
	public int getKeyNextLanguage() {
		return getFunctionKey(SectionKeymap.ITEM_NEXT_LANGUAGE);
	}
	public int getKeySelectKeyboard() {
		return getFunctionKey(SectionKeymap.ITEM_SELECT_KEYBOARD);
	}
	public int getKeyShift() {
		return getFunctionKey(SectionKeymap.ITEM_SHIFT);
	}
	public int getKeySpaceKorean() {
		return getFunctionKey(SectionKeymap.ITEM_SPACE_KOREAN);
	}
	public int getKeyShowSettings() {
		return getFunctionKey(SectionKeymap.ITEM_SHOW_SETTINGS);
	}
	public int getKeyVoiceInput() {
		return getFunctionKey(SectionKeymap.ITEM_VOICE_INPUT);
	}


	public String getFunction(int keyCode) {
		if (keyCode == KeyEvent.KEYCODE_UNKNOWN) {
			return null;
		}

		for (String key : SectionKeymap.ITEMS) {
			if (keyCode == getFunctionKey(key)) {
				return key;
			}
		}

		return null;
	}


	private boolean isValidFunction(String functionName) {
		for (String validName : SectionKeymap.ITEMS) {
			if (validName.equals(functionName)) {
				return true;
			}
		}
		return false;
	}
}
