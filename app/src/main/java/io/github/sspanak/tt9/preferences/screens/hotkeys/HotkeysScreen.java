package io.github.sspanak.tt9.preferences.screens.hotkeys;

import androidx.preference.DropDownPreference;

import java.util.Arrays;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.preferences.PreferencesActivity;
import io.github.sspanak.tt9.preferences.screens.BaseScreenFragment;

public class HotkeysScreen extends BaseScreenFragment {
	final public static String NAME = "Hotkeys";
	public HotkeysScreen() { init(); }
	public HotkeysScreen(PreferencesActivity activity) { init(activity); }

	@Override public String getName() { return NAME; }
	@Override protected int getTitle() { return R.string.pref_category_function_keys; }
	@Override protected int getXml() { return R.xml.prefs_screen_hotkeys; }

	@Override
	public void onCreate() {
		DropDownPreference[] dropDowns = {
//			findPreference(SectionKeymap.ITEM_ADD_WORD),
//			findPreference(SectionKeymap.ITEM_EDIT_TEXT),
		};
		SectionKeymap section = new SectionKeymap(Arrays.asList(dropDowns), activity);
		section.populate().activate();

		// @todo: delete SectionKeymap
		// @todo: delete Hotkeys
		// @todo: prettify the function name when re-assigning

		// @todo: Fix this. Do PreferenceHotkey.setDefault().populate() for each preference
		(new ItemResetKeys(findPreference(ItemResetKeys.NAME), activity, section))
			.enableClickHandler();

		resetFontSize(false);
	}

	@Override
	public int getPreferenceCount() {
		return -1; // prevent scrolling and item selection using the number keys on this screen
	}
}
