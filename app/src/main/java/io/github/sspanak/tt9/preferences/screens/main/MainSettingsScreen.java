package io.github.sspanak.tt9.preferences.screens.main;

import androidx.preference.Preference;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.preferences.HelpFile;
import io.github.sspanak.tt9.preferences.PreferencesActivity;
import io.github.sspanak.tt9.preferences.screens.BaseScreenFragment;
import io.github.sspanak.tt9.util.SystemSettings;

public class MainSettingsScreen extends BaseScreenFragment {
	final public static String NAME = "Main";

	public MainSettingsScreen() { init(); }
	public MainSettingsScreen(PreferencesActivity activity) { init(activity); }

	@Override public String getName() { return NAME; }
	@Override protected int getTitle() { return R.string.app_settings;}
	@Override protected int getXml() { return R.xml.prefs; }


	@Override
	public void onCreate() {
		boolean isTT9On = SystemSettings.isTT9Enabled(activity);
		createSettingsSection(isTT9On);
		createAboutSection(isTT9On);
		updateHelpButtonDescription();
		resetFontSize(false);
	}


	@Override
	public void onResume() {
		init(); // changing the theme recreates the PreferencesActivity, making "this.activity" NULL, so we reinitialize it.
		super.onResume();

		boolean isTT9On = SystemSettings.isTT9Enabled(activity);
		createSettingsSection(isTT9On);
		createAboutSection(isTT9On);
		resetFontSize(false);
	}


	private void createAboutSection(boolean isTT9On) {
		(new ItemVersionInfo(findPreference(ItemVersionInfo.NAME), activity)).populate().enableClickHandler();
		DonatePreference donate = findPreference(DonatePreference.NAME);
		if (donate != null) {
			donate.populate(activity.getSettings(), isTT9On);
		}
	}


	private void updateHelpButtonDescription() {
		Preference help = findPreference("screen_help");
		if (help == null) {
			return;
		}

		String systemLanguage = SystemSettings.getLocale().replaceAll("_\\w+$", "");
		help.setSummary(new HelpFile(activity, systemLanguage).exists() ? "" : "English only");
	}


	private void createSettingsSection(boolean isTT9On) {
		Preference gotoSetup = findPreference("screen_setup");
		if (gotoSetup != null) {
			gotoSetup.setSummary(isTT9On ? "" : activity.getString(R.string.setup_click_here_to_enable));
		}

		ArrayList<Preference> screens = new ArrayList<>(Arrays.asList(
			findPreference("screen_appearance"),
			findPreference("screen_keypad"),
			findPreference("screen_languages")
		));

		for (Preference goToScreen : screens) {
			if (goToScreen != null) {
				goToScreen.setEnabled(isTT9On || activity.getSettings().getDemoMode());
			}
		}
	}
}
