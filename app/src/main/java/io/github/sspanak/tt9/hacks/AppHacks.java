package io.github.sspanak.tt9.hacks;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.NonNull;

import io.github.sspanak.tt9.ime.helpers.TextField;
import io.github.sspanak.tt9.ime.modes.InputMode;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;

public class AppHacks {
	private final ConnectedAppInfo appInfo;
	private final InputConnection inputConnection;
	private final SettingsStore settings;
	private final TextField textField;


	public AppHacks(SettingsStore settings, InputConnection inputConnection, EditorInfo inputField, TextField textField) {
		this.inputConnection = inputConnection;
		this.settings = settings;
		this.textField = textField;
		appInfo = new ConnectedAppInfo(inputConnection, inputField);
	}


	public ConnectedAppInfo getAppInfo() {
		return appInfo;
	}

	/**
	 * setComposingTextWithHighlightedStem
	 * A compatibility function for text fields that do not support SpannableString. Effectively disables highlighting.
	 */
	public void setComposingTextWithHighlightedStem(@NonNull String word, InputMode inputMode) {
		if (appInfo.isKindleInvertedTextField()) {
			textField.setComposingText(word);
		} else {
			textField.setComposingTextWithHighlightedStem(word, inputMode);
		}
	}


	/**
	 * onBackspace
	 * Performs extra Backspace operations and returns "false", or completely replaces Backspace and returns "true". When "true" is
	 * returned, you must not attempt to delete text. This function has already done everything necessary.
	 */
	public boolean onBackspace(InputMode inputMode) {
		if (appInfo.isKindleInvertedTextField()) {
			inputMode.clearWordStem();
		} else if (appInfo.isTermux()) {
			return false;
		}

		// When there is no text, allow double function keys to function normally (e.g. "Back" navigates back)
		return inputMode.getSuggestions().isEmpty() && textField.getStringBeforeCursor(1).isEmpty();
	}


	/**
	 * onAction
	 * Runs non-standard actions for certain apps and fields. Use instead of inputConnection.performEditorAction(action).
	 * Returns "true" if the action was handled, "false" otherwise.
	 */
	public boolean onAction(int action) {
		if (appInfo.isSonimSearchField(action)) {
			return sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
		}

		return false;
	}


	/**
	 * onEnter
	 * Tries to guess and send the correct confirmation key code or sequence of key codes,
	 * depending on the connected application and input field. On invalid connection or field,
	 * it does nothing and return "false", signaling the system we have ignored the key press.
	 */
	public boolean onEnter() {
		if (settings.getFbMessengerHack() && appInfo.isMessenger()) {
			return onEnterFbMessenger();
		} else if (settings.getGoogleChatHack() && appInfo.isGoogleChat()) {
			return onEnterGoogleChat();
		} else if (appInfo.isTermux() || appInfo.isMultilineTextInNonSystemApp()) {
			// Termux supports only ENTER, so we convert DPAD_CENTER for it.
			// Any extra installed apps are likely not designed for hardware keypads, so again,
			// we don't want to send DPAD_CENTER to them.
			return sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
		}

		// The rest of the cases are probably system apps or numeric fields, which should
		// now how to handle the incoming OK key code, be it ENTER or DPAD_CENTER.
		// As per the docs, we must return "false", to indicate that we have not "seen" the key press.
		return false;
	}

	/**
	 * onEnterFbMessenger
	 * Messenger responds only to ENTER, but not DPAD_CENTER, so we make sure to send the correct code,
	 * no matter how the hardware key is implemented.
	 */
	private boolean onEnterFbMessenger() {
		if (inputConnection == null || textField == null || textField.isEmpty()) {
			return false;
		}

		sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);

		return true;
	}

	/**
	 * onEnterGoogleChat
	 * Google Chat does not seem to respond consistently to ENTER. So we trick it by selecting
	 * the send button it, then going back to the text field, so that one can continue typing.
	 */
	private boolean onEnterGoogleChat() {
		if (inputConnection == null || textField == null || textField.isEmpty()) {
			return false;
		}

		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB, true);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB, true);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB, true);
		sendDownUpKeyEvents(KeyEvent.KEYCODE_TAB, true);

		return true;
	}


	private boolean sendDownUpKeyEvents(int keyCode) {
		return sendDownUpKeyEvents(keyCode, false);
	}


	private boolean sendDownUpKeyEvents(int keyCode, boolean shift) {
		if (inputConnection != null) {
			KeyEvent downEvent = new KeyEvent(0, 0, KeyEvent.ACTION_DOWN, keyCode, 0, shift ? KeyEvent.META_SHIFT_ON : 0);
			KeyEvent upEvent = new KeyEvent(0, 0, KeyEvent.ACTION_UP, keyCode, 0, shift ? KeyEvent.META_SHIFT_ON : 0);
			return inputConnection.sendKeyEvent(downEvent) && inputConnection.sendKeyEvent(upEvent);
		}

		return false;
	}
}
