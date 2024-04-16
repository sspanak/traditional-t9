package io.github.sspanak.tt9.preferences.screens.debug;

import androidx.preference.Preference;

import io.github.sspanak.tt9.db.exporter.LogcatExporter;
import io.github.sspanak.tt9.preferences.PreferencesActivity;
import io.github.sspanak.tt9.preferences.items.ItemExportAbstract;
import io.github.sspanak.tt9.ui.notifications.DictionaryProgressNotification;

public class ItemExportLogcat extends ItemExportAbstract {
	public static final String NAME = "pref_export_logcat";

	public ItemExportLogcat(Preference item, PreferencesActivity activity) {
		super(item, activity, null, null);
	}

	@Override
	protected LogcatExporter getExporter() {
		return LogcatExporter.getInstance();
	}

	@Override
	protected boolean onStartExporting() {
		return getExporter().setIncludeSystemLogs(activity.getSettings().getEnableSystemLogs()).export(activity);
	}

	@Override
	protected void onFinishExporting(String outputFile) {
		activity.runOnUiThread(() -> {
			DictionaryProgressNotification.getInstance(activity).hide();
			setReadyStatus();

			if (outputFile == null) {
				item.setSummary("Export failed");
			} else {
				item.setSummary("Logs exported to: " + outputFile);
			}
		});
	}
}
