package io.github.sspanak.tt9.preferences.screens.languages;

import java.util.ArrayList;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.db.DictionaryLoader;
import io.github.sspanak.tt9.db.exporter.CustomWordsExporter;
import io.github.sspanak.tt9.db.exporter.DictionaryExporter;
import io.github.sspanak.tt9.preferences.PreferencesActivity;
import io.github.sspanak.tt9.preferences.items.ItemClickable;
import io.github.sspanak.tt9.preferences.screens.BaseScreenFragment;

public class LanguagesScreen extends BaseScreenFragment {
	public static final String NAME = "Languages";

	private final ArrayList<ItemClickable> clickables = new ArrayList<>();

	private ItemLoadDictionary loadItem;
	private ItemExportDictionary exportDictionaryItem;
	private ItemExportCustomWords exportCustomWordsItem;

	public LanguagesScreen() { init(); }
	public LanguagesScreen(PreferencesActivity activity) { init(activity); }

	@Override public String getName() { return NAME; }
	@Override protected int getTitle() { return R.string.pref_choose_languages; }
	@Override protected int getXml() { return R.xml.prefs_screen_languages; }

	@Override
	protected void onCreate() {
		ItemSelectLanguage multiSelect = new ItemSelectLanguage(
			activity,
			findPreference(ItemSelectLanguage.NAME)
		);
		multiSelect.populate().enableValidation();

		loadItem = new ItemLoadDictionary(findPreference(ItemLoadDictionary.NAME),
			activity,
			() -> ItemClickable.disableOthers(clickables, loadItem),
			this::onActionFinish
		);

		exportDictionaryItem = new ItemExportDictionary(findPreference(ItemExportDictionary.NAME),
			activity,
			this::onActionStart,
			this::onActionFinish
		);

		clickables.add(loadItem);
		clickables.add(exportDictionaryItem);

		clickables.add(new ItemTruncateUnselected(
			findPreference(ItemTruncateUnselected.NAME),
			activity,
			this::onActionStart,
			this::onActionFinish
		));

		clickables.add(new ItemTruncateAll(
			findPreference(ItemTruncateAll.NAME),
			activity,
			this::onActionStart,
			this::onActionFinish
		));

		clickables.add(new ItemDeleteCustomWords(findPreference(ItemDeleteCustomWords.NAME)));

		exportCustomWordsItem = new ItemExportCustomWords(
			findPreference(ItemExportCustomWords.NAME),
			activity,
			this::onActionStart,
			this::onActionFinish);

		clickables.add(exportCustomWordsItem);

		ItemClickable.enableAllClickHandlers(clickables);
		refreshItems();
	}

	@Override
	public void onResume() {
		super.onResume();
		refreshItems();
	}


	private void refreshItems() {
		loadItem.refreshStatus();
		exportDictionaryItem.refreshStatus();
		exportCustomWordsItem.refreshStatus();

		if (DictionaryLoader.getInstance(activity).isRunning()) {
			loadItem.refreshStatus();
			ItemClickable.disableOthers(clickables, loadItem);
		} else if (CustomWordsExporter.getInstance().isRunning() || DictionaryExporter.getInstance().isRunning()) {
			onActionStart();
		} else {
			onActionFinish();
		}
	}


	private void onActionStart() {
		ItemClickable.disableAll(clickables);
	}

	private void onActionFinish() {
		ItemClickable.enableAll(clickables);
	}
}
