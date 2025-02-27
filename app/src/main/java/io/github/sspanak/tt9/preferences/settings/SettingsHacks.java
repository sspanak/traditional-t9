package io.github.sspanak.tt9.preferences.settings;

import android.content.Context;

import io.github.sspanak.tt9.hacks.DeviceInfo;
import io.github.sspanak.tt9.preferences.screens.debug.ItemInputHandlingMode;
import io.github.sspanak.tt9.util.Logger;

class SettingsHacks extends BaseSettings {
	private boolean demoMode = false;

	SettingsHacks(Context context) { super(context); }

	/************* debugging settings *************/

	public boolean getDemoMode() {
		return demoMode;
	}

	public void setDemoMode(boolean demoMode) {
		this.demoMode = demoMode;
	}

	public int getLogLevel() {
		return getStringifiedInt("pref_log_level", Logger.LEVEL);
	}

	public boolean getEnableSystemLogs() {
		return prefs.getBoolean("pref_enable_system_logs", false);
	}

	public int getInputHandlingMode() {
		return getStringifiedInt("pref_input_handling_mode", ItemInputHandlingMode.NORMAL);
	}


	/************* hack settings *************/

	public int getSuggestionScrollingDelay() {
		boolean defaultOn = DeviceInfo.noTouchScreen(context) && !DeviceInfo.AT_LEAST_ANDROID_10;
		return prefs.getBoolean("pref_alternative_suggestion_scrolling", defaultOn) ? 200 : 0;
	}

	public boolean clearInsets() {
		return prefs.getBoolean("pref_clear_insets", DeviceInfo.isSonimGen2(context));
	}

	/**
	 * Protection against faulty devices, that sometimes send two (or more) click events
	 * per a single key press, which absolutely undesirable side effects.
	 * There were reports about this on <a href="https://github.com/sspanak/tt9/issues/117">Kyocera KYF31</a>
	 * and on <a href="https://github.com/sspanak/tt9/issues/399">CAT S22</a>.
	 */

	public int getKeyPadDebounceTime() {
		int defaultTime = DeviceInfo.isCatS22Flip() ? 50 : 0;
		defaultTime = DeviceInfo.isQinF21() ? 20 : defaultTime;
		return getStringifiedInt("pref_key_pad_debounce_time", defaultTime);
	}

	public boolean getSystemLogs() {
		return prefs.getBoolean("pref_enable_system_logs", false);
	}

	public boolean getDonationsVisible() {
		return prefs.getBoolean("pref_show_donations", false);
	}

	public void setDonationsVisible(boolean yes) {
		prefsEditor.putBoolean("pref_show_donations", yes).apply();
	}
}
