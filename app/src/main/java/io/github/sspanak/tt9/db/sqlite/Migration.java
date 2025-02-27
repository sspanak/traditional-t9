package io.github.sspanak.tt9.db.sqlite;

import io.github.sspanak.tt9.preferences.settings.SettingsStore;

class Migration {
	static final Migration[] LIST = {
		new Migration(
			"ALTER TABLE " + Tables.LANGUAGES_META + " ADD COLUMN fileHash TEXT NOT NULL DEFAULT 0"
		),
		new Migration(
			"ALTER TABLE " + Tables.LANGUAGES_META + " RENAME COLUMN  normalizationPending TO _delete_me_0"
		),
		new Migration(
			"ALTER TABLE " + Tables.LANGUAGES_META + " ADD COLUMN positionsToNormalize TEXT NULL"
		),
		new Migration(
			"ALTER TABLE " + Tables.LANGUAGES_META + " ADD COLUMN maxWordsPerSequence INTEGER NOT NULL DEFAULT -1"
		),
		new Migration(
			"UPDATE " + Tables.LANGUAGES_META +
				" SET maxWordsPerSequence = " + SettingsStore.SUGGESTIONS_POSITIONS_LIMIT +
				", fileHash = '0'",
			832
		),
		new Migration(
			// enforce the new Vietnamese layout
			"DELETE FROM " + Tables.LANGUAGES_META + " WHERE langId = 481590",
			952
		)
	};

	final String query;
	final int oldVersion;

	private Migration(String query) {
		this.oldVersion = Integer.MAX_VALUE;
		this.query = query;
	}

	private Migration(String query, int oldVersion) {
		this.oldVersion = oldVersion;
		this.query = query;
	}
}
