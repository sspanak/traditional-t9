package io.github.sspanak.tt9.db.words;

import android.content.Context;
import android.content.res.AssetManager;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import io.github.sspanak.tt9.db.DataStore;
import io.github.sspanak.tt9.db.entities.WordBatch;
import io.github.sspanak.tt9.db.entities.WordFile;
import io.github.sspanak.tt9.db.exceptions.DictionaryImportAbortedException;
import io.github.sspanak.tt9.db.exceptions.DictionaryImportException;
import io.github.sspanak.tt9.db.sqlite.DeleteOps;
import io.github.sspanak.tt9.db.sqlite.InsertOps;
import io.github.sspanak.tt9.db.sqlite.SQLiteOpener;
import io.github.sspanak.tt9.db.sqlite.Tables;
import io.github.sspanak.tt9.languages.EmojiLanguage;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.LanguageKind;
import io.github.sspanak.tt9.languages.exceptions.InvalidLanguageCharactersException;
import io.github.sspanak.tt9.languages.exceptions.InvalidLanguageException;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.notifications.DictionaryLoadingBar;
import io.github.sspanak.tt9.ui.notifications.DictionaryUpdateNotification;
import io.github.sspanak.tt9.util.ConsumerCompat;
import io.github.sspanak.tt9.util.Logger;
import io.github.sspanak.tt9.util.Timer;

public class DictionaryLoader {
	private static final String LOG_TAG = "DictionaryLoader";
	private static DictionaryLoader self;
	private static final String IMPORT_TIMER = "importTime";

	private final AssetManager assets;
	private final SQLiteOpener sqlite;

	private static final Handler asyncHandler = new Handler();
	private ConsumerCompat<Bundle> onStatusChange;
	private Thread loadThread;

	private final HashMap<Integer, Long> lastAutoLoadAttemptTime = new HashMap<>();
	private int currentFile = 0;
	private long lastProgressUpdate = 0;



	public static DictionaryLoader getInstance(Context context) {
		if (self == null) {
			self = new DictionaryLoader(context);
		}

		return self;
	}


	private DictionaryLoader(Context context) {
		assets = context.getAssets();
		sqlite = SQLiteOpener.getInstance(context);
	}


	public void setOnStatusChange(ConsumerCompat<Bundle> callback) {
		onStatusChange = callback;
	}


	public boolean load(Context context, ArrayList<Language> languages) {
		if (isRunning()) {
			return false;
		}

		if (languages == null || languages.isEmpty()) {
			Logger.d(LOG_TAG, "Nothing to do");
			return true;
		}

		loadThread = new Thread(() -> loadSync(context, languages));
		loadThread.start();

		return true;
	}


	private void loadSync(Context context, ArrayList<Language> languages) {
		currentFile = 0;
		Timer.start(IMPORT_TIMER);

		sendStartMessage(languages.size());

		// SQLite does not support parallel queries, so let's import them one by one
		for (Language lang : languages) {
			if (loadThread.isInterrupted()) {
				break;
			}
			importAll(context, lang);
			currentFile++;
		}

		Timer.stop(IMPORT_TIMER);
	}


	public static void load(Context context, Language language) {
		DictionaryLoadingBar progressBar = DictionaryLoadingBar.getInstance(context);
		getInstance(context).setOnStatusChange(progressBar::show);
		self.load(context, new ArrayList<>() {{ add(language); }});
	}


	public static boolean autoLoad(InputMethodService context, Language language) {
		if (getInstance(context).isRunning()) {
			return false;
		}

		Long lastUpdateTime = self.lastAutoLoadAttemptTime.get(language.getId());
		boolean isItTooSoon = lastUpdateTime != null && System.currentTimeMillis() - lastUpdateTime < SettingsStore.DICTIONARY_AUTO_LOAD_COOLDOWN_TIME;
		if (isItTooSoon) {
			return false;
		}

		DataStore.getLastLanguageUpdateTime(
			(hash) -> {
				self.lastAutoLoadAttemptTime.put(language.getId(), System.currentTimeMillis());

				// no words at all, load without confirmation
				if (hash.isEmpty()) {
					load(context, language);
				}
				// or if the database is outdated, compared to the dictionary file, ask for confirmation and load
				else if (!hash.equals(new WordFile(context, language, self.assets).getHash())) {
					new DictionaryUpdateNotification(context, language).show();
				}
			},
			language
		);

		return true;
	}


	public void stop() {
		loadThread.interrupt();
		Timer.stop(IMPORT_TIMER);
	}


	public boolean isRunning() {
		return loadThread != null && loadThread.isAlive();
	}


	private void importAll(Context context, Language language) {
		if (language == null) {
			Logger.e(LOG_TAG, "Failed loading a dictionary for NULL language.");
			sendError(InvalidLanguageException.class.getSimpleName(), -1);
			return;
		}

		try {
			Timer.start();

			float progress = 1;

			sqlite.beginTransaction();

			Tables.dropIndexes(sqlite.getDb(), language);
			sendProgressMessage(language, ++progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Indexes dropped", language, Timer.restart());

			DeleteOps.delete(sqlite.getDb(), language.getId());
			DeleteOps.delete(sqlite.getDb(), new EmojiLanguage().getId());
			sendProgressMessage(language, ++progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Storage cleared", language, Timer.restart());

			int lettersCount = importLetters(language);
			sendProgressMessage(language, ++progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Letters imported", language, Timer.restart());

			importWordFile(context, language, lettersCount, progress, 88);
			progress = 88;
			sendProgressMessage(language, progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Dictionary file imported", language, Timer.restart());

			DeleteOps.purgeCustomWords(sqlite.getDb(), language.getId());
			sendProgressMessage(language, ++progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Removed custom words, which are already in the dictionary", language, Timer.restart());

			InsertOps.restoreCustomWords(sqlite.getDb(), language);
			InsertOps.restoreCustomWords(sqlite.getDb(), new EmojiLanguage());
			sendProgressMessage(language, ++progress, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			logLoadingStep("Custom words restored", language, Timer.restart());

			Tables.createPositionIndex(sqlite.getDb(), language);
			sendProgressMessage(language, progress + (100f - progress) / 2f, 0);
			Tables.createWordIndex(sqlite.getDb(), language);
			sendProgressMessage(language, 100, 0);
			logLoadingStep("Indexes restored", language, Timer.restart());

			sqlite.finishTransaction();
			SlowQueryStats.clear();
		} catch (DictionaryImportAbortedException e) {
			sqlite.failTransaction();
			stop();
			Logger.i(LOG_TAG, e.getMessage() + ". File '" + language.getDictionaryFile() + "' not imported.");
		} catch (DictionaryImportException e) {
			stop();
			sqlite.failTransaction();
			sendImportError(DictionaryImportException.class.getSimpleName(), language.getId(), e.line);

			Logger.e(
				LOG_TAG,
				" Invalid word in dictionary: '" + language.getDictionaryFile() + "'"
				+ " of language '" + language.getName() + "'. "
				+ e.getMessage()
			);
		} catch (Exception | Error e) {
			stop();
			sqlite.failTransaction();
			sendError(e.getClass().getSimpleName(), language.getId());

			Logger.e(
				LOG_TAG,
				"Failed loading dictionary: " + language.getDictionaryFile()
				+ " for language '" + language.getName() + "'. "
				+ e.getMessage()
			);
		}
	}


	private int importLetters(Language language) throws InvalidLanguageCharactersException {
		if (language.isSyllabary()) {
			return 0;
		}

		int lettersCount = 0;
		boolean isEnglish = LanguageKind.isEnglish(language);
		WordBatch letters = new WordBatch(language);

		for (int key = 2; key <= 9; key++) {
			for (String langChar : language.getKeyCharacters(key)) {
				langChar = (isEnglish && langChar.equals("i")) ? langChar.toUpperCase(Locale.ENGLISH) : langChar;
				letters.add(langChar, 0, key);
				lettersCount++;
			}
		}

		saveWordBatch(letters);

		return lettersCount;
	}


	private void importWordFile(Context context, Language language, int positionShift, float minProgress, float maxProgress) throws Exception {
		WordFile wordFile = new WordFile(context, language, assets);
		WordBatch batch = new WordBatch(language, SettingsStore.DICTIONARY_IMPORT_BATCH_SIZE + 1);
		float progressRatio = (maxProgress - minProgress) / wordFile.getWords();
		int wordCount = 0;
		int maxWordsPerSequence = 0;

		try (BufferedReader ignored = wordFile.getReader()) {
			while (wordFile.notEOF()) {
				if (loadThread.isInterrupted()) {
					sendProgressMessage(language, 0, 0);
					throw new DictionaryImportAbortedException();
				}

				try {
					String digitSequence = wordFile.getNextSequence();
					ArrayList<String> words = wordFile.getNextWords(digitSequence);
					batch.add(words, digitSequence, wordCount + positionShift);
					wordCount += words.size();
					maxWordsPerSequence = Math.max(maxWordsPerSequence, words.size());

					if (batch.getWords().size() > SettingsStore.DICTIONARY_IMPORT_BATCH_SIZE) {
						saveWordBatch(batch);
						batch.clear();
					}
				} catch (IOException e) {
					throw new DictionaryImportException(e.getMessage(), wordCount);
				}

				sendProgressMessage(language, minProgress + progressRatio * wordCount, SettingsStore.DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME);
			}
		}

		saveWordBatch(batch);
		InsertOps.replaceLanguageMeta(sqlite.getDb(), language.getId(), wordFile.getHash(), maxWordsPerSequence);
	}


	private void saveWordBatch(WordBatch batch) {
		InsertOps insertOps = new InsertOps(sqlite.getDb(), batch.getLanguage());

		for (int i = 0, end = batch.getWords().size(); i < end; i++) {
			insertOps.insertWord(batch.getWords().get(i));
		}

		for (int i = 0, end = batch.getPositions().size(); i < end; i++) {
			insertOps.insertWordPosition(batch.getPositions().get(i));
		}
	}


	private void sendStartMessage(int fileCount) {
		if (onStatusChange == null) {
			Logger.w(LOG_TAG, "Cannot send file count without a status Handler. Ignoring message.");
			return;
		}

		Bundle progressMsg = new Bundle();
		progressMsg.putInt("fileCount", fileCount);
		progressMsg.putInt("progress", 1);
		asyncHandler.post(() -> onStatusChange.accept(progressMsg));
	}


	private void sendProgressMessage(Language language, float progress, int progressUpdateInterval) {
		if (onStatusChange == null) {
			Logger.w(LOG_TAG, "Cannot send progress without a status Handler. Ignoring message.");
			return;
		}

		long now = System.currentTimeMillis();
		if (now - lastProgressUpdate < progressUpdateInterval) {
			return;
		}

		lastProgressUpdate = now;

		Bundle progressMsg = new Bundle();
		progressMsg.putInt("languageId", language.getId());
		progressMsg.putLong("time", Timer.get(IMPORT_TIMER));
		progressMsg.putInt("progress", Math.round(progress));
		progressMsg.putInt("currentFile", currentFile);
		asyncHandler.post(() -> onStatusChange.accept(progressMsg));
	}


	private void sendError(String message, int langId) {
		if (onStatusChange == null) {
			Logger.w(LOG_TAG, "Cannot send an error without a status Handler. Ignoring message.");
			return;
		}

		Bundle errorMsg = new Bundle();
		errorMsg.putString("error", message);
		errorMsg.putInt("languageId", langId);
		asyncHandler.post(() -> onStatusChange.accept(errorMsg));
	}


	private void sendImportError(String message, int langId, long fileLine) {
		if (onStatusChange == null) {
			Logger.w(LOG_TAG, "Cannot send an import error without a status Handler. Ignoring message.");
			return;
		}

		Bundle errorMsg = new Bundle();
		errorMsg.putString("error", message);
		errorMsg.putLong("fileLine", fileLine + 1);
		errorMsg.putInt("languageId", langId);
		asyncHandler.post(() -> onStatusChange.accept(errorMsg));
	}


	private void logLoadingStep(String message, Language language, long time) {
		if (Logger.isDebugLevel()) {
			Logger.d(LOG_TAG, message + " for language '" + language.getName() + "' (" + language.getId() + ") in: " + time + " ms");
		}
	}
}
