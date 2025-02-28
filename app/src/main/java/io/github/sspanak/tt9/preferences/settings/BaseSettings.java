package io.github.sspanak.tt9.preferences.settings;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

class BaseSettings {
	protected final String LOG_TAG = SettingsInput.class.getSimpleName();

	protected final Context context;
	protected final SharedPreferences prefs;
	protected final SharedPreferences.Editor prefsEditor;


	BaseSettings(Context context) {
		this.context = context;
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
		prefsEditor = prefs.edit();
	}

	protected int getStringifiedInt(String key, int defaultValue) {
		try {
			return Integer.parseInt(prefs.getString(key, String.valueOf(defaultValue)));
		} catch (NumberFormatException ignored) {
			return defaultValue;
		}
	}

	protected float getStringifiedFloat(String key, float defaultValue) {
		try {
			return Float.parseFloat(prefs.getString(key, String.valueOf(defaultValue)));
		} catch (NumberFormatException ignored) {
			return defaultValue;
		}
	}
}
