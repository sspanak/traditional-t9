package io.github.sspanak.tt9.preferences.screens.hotkeys;

import androidx.preference.DropDownPreference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import io.github.sspanak.tt9.ime.voice.VoiceInputOps;
import io.github.sspanak.tt9.preferences.PreferencesActivity;
import io.github.sspanak.tt9.preferences.helpers.Hotkeys;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.util.Logger;

public class SectionKeymap {
	public static final String ITEM_ADD_WORD = "key_add_word";
	public static final String ITEM_BACKSPACE = "key_backspace";
	public static final String ITEM_COMMAND_PALETTE = "key_command_palette";
	public static final String ITEM_EDIT_TEXT = "key_edit_text";
	public static final String ITEM_FILTER_CLEAR = "key_filter_clear";
	public static final String ITEM_FILTER_SUGGESTIONS = "key_filter_suggestions";
	public static final String ITEM_PREVIOUS_SUGGESTION = "key_previous_suggestion";
	public static final String ITEM_NEXT_SUGGESTION = "key_next_suggestion";
	public static final String ITEM_NEXT_INPUT_MODE = "key_next_input_mode";
	public static final String ITEM_NEXT_LANGUAGE = "key_next_language";
	public static final String ITEM_SELECT_KEYBOARD = "key_select_keyboard";
	public static final String ITEM_SHIFT = "key_shift";
	public static final String ITEM_SPACE_KOREAN = "key_space_korean";
	public static final String ITEM_SHOW_SETTINGS = "key_show_settings";
	public static final String ITEM_VOICE_INPUT = "key_voice_input";

	public static final String[] ITEMS = {
		ITEM_ADD_WORD,
		ITEM_BACKSPACE,
		ITEM_COMMAND_PALETTE,
		ITEM_EDIT_TEXT,
		ITEM_FILTER_CLEAR,
		ITEM_FILTER_SUGGESTIONS,
		ITEM_PREVIOUS_SUGGESTION,
		ITEM_NEXT_SUGGESTION,
		ITEM_NEXT_INPUT_MODE,
		ITEM_NEXT_LANGUAGE,
		ITEM_SELECT_KEYBOARD,
		ITEM_SHIFT,
		ITEM_SPACE_KOREAN,
		ITEM_SHOW_SETTINGS,
		ITEM_VOICE_INPUT,
	};

	private final Hotkeys hotkeys;
	private final Collection<DropDownPreference> items;
	private final SettingsStore settings;
	private final boolean isVoiceInputAvailable;


	public SectionKeymap(Collection<DropDownPreference> dropDowns, PreferencesActivity activity) {
		items = dropDowns;
		hotkeys = new Hotkeys(activity);
		this.settings = activity.getSettings();
		isVoiceInputAvailable = new VoiceInputOps(activity, null, null, null).isAvailable();
	}


	public void reloadSettings() {
		for (DropDownPreference dropDown : items) {
			int keypadKey = settings.getFunctionKey(dropDown.getKey());
			dropDown.setValue(String.valueOf(keypadKey));
		}
		populate();
	}


	public SectionKeymap populate() {
		populateOtherItems(null);
		return this;
	}


	public void activate() {
		for (DropDownPreference item : items) {
			onItemClick(item);
		}
	}


	private void populateOtherItems(DropDownPreference itemToSkip) {
		for (DropDownPreference item : items) {
			if (itemToSkip != null && item != null && Objects.equals(itemToSkip.getKey(), item.getKey())) {
				continue;
			}
			populateItem(item);
			previewCurrentKey(item);
		}
	}


	private void populateItem(DropDownPreference dropDown) {
		if (dropDown == null) {
			Logger.w("SectionKeymap.populateItem", "Cannot populate a NULL item. Ignoring.");
			return;
		}

		ArrayList<String> keys = new ArrayList<>();
		for (String key : hotkeys.getHardwareKeys()) {
			if (
				validateKey(dropDown, String.valueOf(key))
				// backspace works both when pressed short and long,
				// so separate "hold" and "not hold" options for it make no sense
				&& !(dropDown.getKey().equals(ITEM_BACKSPACE) && Integer.parseInt(key) < 0)
			) {
				keys.add(String.valueOf(key));
			}
		}

		ArrayList<String> values = new ArrayList<>();
		for (String key : keys) {
			values.add(hotkeys.getHardwareKeyName(key));
		}

		dropDown.setEntries(values.toArray(new CharSequence[0]));
		dropDown.setEntryValues(keys.toArray(new CharSequence[0]));
	}


	private void onItemClick(DropDownPreference item) {
		if (item == null) {
			Logger.w("SectionKeymap.populateItem", "Cannot set a click listener a NULL item. Ignoring.");
			return;
		}

		item.setOnPreferenceChangeListener((preference, newKey) -> {
			if (!validateKey((DropDownPreference) preference, newKey.toString())) {
				return false;
			}

			try {
				((DropDownPreference) preference).setValue(newKey.toString());
				previewCurrentKey((DropDownPreference) preference, newKey.toString());
				populateOtherItems((DropDownPreference) preference);
				return true;
			} catch (Exception e) {
				Logger.e("SectionKeymap.onItemClick", "Failed setting new hotkey. " + e.getMessage());
				return false;
			}
		});
	}


	private void previewCurrentKey(DropDownPreference dropDown) {
		previewCurrentKey(dropDown, dropDown != null ? dropDown.getValue() : null);
	}


	private void previewCurrentKey(DropDownPreference dropDown, String key) {
		if (dropDown == null) {
			return;
		}

		dropDown.setSummary(hotkeys.getHardwareKeyName(key));

		if (dropDown.getKey().equals(ITEM_VOICE_INPUT)) {
			dropDown.setVisible(isVoiceInputAvailable);
		}
	}


	private boolean validateKey(DropDownPreference dropDown, String key) {
		if (dropDown == null || key == null) {
			return false;
		}

		if (key.equals("0")) {
			return true;
		}

		for (DropDownPreference item : items) {
			if (item == null) {
				continue;
			}

			// "Shift" and "Korean Space" can be the same key. It is properly handled in HotkeyHandler.
			if (
				(
					(dropDown.getKey().equals(ITEM_SHIFT) && item.getKey().equals(ITEM_SPACE_KOREAN))
					|| (dropDown.getKey().equals(ITEM_SPACE_KOREAN) && item.getKey().equals(ITEM_SHIFT))
				)
				&& key.equals(item.getValue())
			) {
				continue;
			}

			if (!dropDown.getKey().equals(item.getKey()) && key.equals(item.getValue())) {
				Logger.i("SectionKeymap.validateKey", "Key: '" + key + "' is already in use for function: " + item.getKey());
				return false;
			}
		}

		return true;
	}
}
