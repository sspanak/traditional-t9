package io.github.sspanak.tt9.preferences.screens.appearance;

import androidx.preference.SwitchPreferenceCompat;

import io.github.sspanak.tt9.preferences.settings.SettingsStore;

public class ItemStatusIcon {
	public static final String NAME = "pref_status_icon";

	private final SwitchPreferenceCompat item;
	private final SettingsStore settings;

	public ItemStatusIcon(SwitchPreferenceCompat item, SettingsStore settings) {
		this.item = item;
		this.settings = settings;
	}

	public void populate() {
		if (item != null) {
			item.setChecked(settings.isStatusIconEnabled());
		}
	}
}
