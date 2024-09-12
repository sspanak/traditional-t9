package io.github.sspanak.tt9.ime;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.NonNull;

import io.github.sspanak.tt9.db.DataStore;
import io.github.sspanak.tt9.db.words.DictionaryLoader;
import io.github.sspanak.tt9.hacks.InputType;
import io.github.sspanak.tt9.ime.modes.ModePredictive;
import io.github.sspanak.tt9.languages.LanguageCollection;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.UI;
import io.github.sspanak.tt9.ui.dialogs.PopupDialog;
import io.github.sspanak.tt9.util.Logger;
import io.github.sspanak.tt9.util.SystemSettings;

public class TraditionalT9 extends MainViewHandler {
	@NonNull
	private final Handler backgroundTasks = new Handler(Looper.getMainLooper());
	private final Handler zombieDetector = new Handler(Looper.getMainLooper());
	private int zombieChecks = 0;


	@Override
	public boolean onEvaluateInputViewShown() {
		super.onEvaluateInputViewShown();
		if (!SystemSettings.isTT9Active(this)) {
			return false;
		}

		setInputField(getCurrentInputConnection(), getCurrentInputEditorInfo());
		return shouldBeVisible();
	}


	@Override
	public boolean onEvaluateFullscreenMode() {
		return false;
	}


	@Override
	public View onCreateInputView() {
		mainView.forceCreateInputView();
		initTray();
		setDarkTheme();
		statusBar.setText(mInputMode);
		suggestionOps.set(mInputMode.getSuggestions(), mInputMode.containsGeneratedSuggestions());

		return mainView.getView();
	}


	@Override
	public void onComputeInsets(Insets outInsets) {
		super.onComputeInsets(outInsets);
		if (shouldBeVisible() && settings.clearInsets()) {
			// otherwise the MainView wouldn't show up on Sonim XP3900
			// or it expands the application window past the edge of the screen
			outInsets.contentTopInsets = 0;
		}
	}


	@Override
	public void onStartInput(EditorInfo inputField, boolean restarting) {
		Logger.i(
			"KeyPadHandler",
			"===> Start Up; packageName: " + inputField.packageName + " inputType: " + inputField.inputType + " actionId: " + inputField.actionId + " imeOptions: " + inputField.imeOptions + " privateImeOptions: " + inputField.privateImeOptions + " extras: " + inputField.extras
		);
		onStart(getCurrentInputConnection(), inputField);
	}


	@Override
	public void onStartInputView(EditorInfo inputField, boolean restarting) {
		onStart(getCurrentInputConnection(), inputField);
	}


	@Override
	public void onFinishInputView(boolean finishingInput) {
		super.onFinishInputView(finishingInput);
		onFinishTyping();
	}


	@Override
	public void onFinishInput() {
		super.onFinishInput();
		onStop();
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int result = super.onStartCommand(intent, flags, startId);

		String message = intent != null ? intent.getStringExtra(PopupDialog.INTENT_CLOSE) : null;
		if (message != null) {
			forceShowWindow();
			if (!message.isEmpty()) {
				UI.toastLong(this, message);
			}
		}

		return result;
	}

	@Override
	protected void onInit() {
		settings.setDemoMode(false);
		Logger.setLevel(settings.getLogLevel());
		DataStore.init(this);
		super.onInit();
	}


	@Override
	protected boolean onStart(InputConnection connection, EditorInfo field) {
		if (!SystemSettings.isTT9Active(this)) {
			onStop();
			onDeath();
			return false;
		}

		if (!super.onStart(connection, field)) {
			return false;
		}

		Logger.setLevel(settings.getLogLevel());

		if (mInputMode.isPassthrough()) {
			onStop();
		}	else {
			backgroundTasks.removeCallbacksAndMessages(null);
			initUi();
		}

		InputType newInputType = new InputType(connection, field);

		if (newInputType.isText()) {
			DataStore.loadWordPairs(DictionaryLoader.getInstance(this), LanguageCollection.getAll(this, settings.getEnabledLanguageIds()));
		}

		if (newInputType.isNotUs(this)) {
			DictionaryLoader.autoLoad(this, mLanguage);
		}

		return true;
	}


	@Override
	protected void onStop() {
		stopVoiceInput();
		onFinishTyping();
		suggestionOps.clear();
		setStatusIcon(mInputMode);
		statusBar.setText(mInputMode);

		if (isInputViewShown()) {
			updateInputViewShown();
		}

		if (SystemSettings.isTT9Active(this)) {
			backgroundTasks.removeCallbacksAndMessages(null);
			backgroundTasks.postDelayed(this::runBackgroundTasks, SettingsStore.WORD_BACKGROUND_TASKS_DELAY);
		}

		if (zombieChecks == 0) {
			startZombieCheck();
		}
	}


	/**
	 * On Android 11 the IME is sometimes not killed when the user switches to a different one.
	 * Here we attempt to detect if we are disabled, then hide and kill ourselves.
	 */
	private void startZombieCheck() {
		if (!SystemSettings.isTT9Active(this)) {
			onDeath();
			return;
		}

		if (++zombieChecks < SettingsStore.ZOMBIE_CHECK_MAX) {
			zombieDetector.postDelayed(this::startZombieCheck, SettingsStore.ZOMBIE_CHECK_INTERVAL);
		} else {
			Logger.d("startZombieCheck", "Not a zombie after " + zombieChecks + " checks");
			zombieChecks = 0;
		}
	}


	private void onDeath() {
		if (currentInputConnection == null) {
			Logger.w("onDeath", "===> Already dead. Nothing to do.");
			return;
		}

		Logger.w("onDeath", "===> Killing self");
		requestHideSelf(0);
		setInputField(null, null);
		backgroundTasks.removeCallbacksAndMessages(null);
		zombieDetector.removeCallbacksAndMessages(null);
		stopSelf();
	}


	@Override
	public void onDestroy() {
		onDeath();
		super.onDestroy();
	}


	@Override
	protected boolean onNumber(int key, boolean hold, int repeat) {
		if (mInputMode instanceof ModePredictive && DictionaryLoader.autoLoad(this, mLanguage)) {
			return true;
		}
		return super.onNumber(key, hold, repeat);
	}


	@Override
	protected TraditionalT9 getFinalContext() {
		return this;
	}


	private void runBackgroundTasks() {
		DataStore.saveWordPairs();
		if (!DictionaryLoader.getInstance(this).isRunning()) {
			DataStore.normalizeNext();
		}
	}
}
