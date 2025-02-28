package io.github.sspanak.tt9.preferences.screens.hotkeys;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.hacks.DeviceInfo;
import io.github.sspanak.tt9.ime.helpers.Key;
import io.github.sspanak.tt9.preferences.custom.ScreenPreference;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.UI;

public class PreferenceHotkey extends ScreenPreference implements DialogInterface.OnKeyListener{
	private static final int CANCEL_KEY = 0;
	private static final int UNASSIGN_KEY = 2;

	private static SettingsStore settings;

	private int lastKeyDownCode = KeyEvent.KEYCODE_UNKNOWN;
	private int lastLongPressCode = KeyEvent.KEYCODE_UNKNOWN;


	public PreferenceHotkey(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); init(context); }
	public PreferenceHotkey(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); init(context); }
	public PreferenceHotkey(@NonNull Context context, @Nullable AttributeSet attrs) { super(context, attrs); init(context); }
	public PreferenceHotkey(@NonNull Context context) { super(context); init(context); }


	private void init(Context context) {
		if (settings == null) {
			settings = new SettingsStore(context);
		}
	}


	@Override
	public void onAttached() {
		super.onAttached();
		populate();
	}


	@Override protected int getLargeLayout() {
		return DeviceInfo.AT_LEAST_ANDROID_12 ? getDefaultLayout() : R.layout.pref_default_large;
	}


	public void populate() {
		int keyCode = settings.getFunctionKey(getKey());

		String holdSuffix = "";
		if (keyCode < 0) {
			holdSuffix = " " + getContext().getString(R.string.key_hold_key);
			keyCode = -keyCode;
		}

		setSummary(Key.codeToName(getContext(), keyCode) + holdSuffix);
	}


	@Override
	protected void onClick() {
		super.onClick();
		UI.confirm(
			getContext(),
			getKey(),
			getContext().getString(R.string.function_assign_instructions),
			null,
			null,
			false,
			null,
			this
		);
	}


	@Override
	public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			onKeyDown(dialog, keyCode);
		}

		if (event.getAction() == KeyEvent.ACTION_UP) {
			onKeyUp(dialog, keyCode);
		}

		// prevent passing the key event to the activity
		return false;
	}


	private void onKeyDown(DialogInterface dialog, int keyCode) {
		if (keyCode == lastKeyDownCode && keyCode != lastLongPressCode && onAssign(dialog, -keyCode)) {
			lastLongPressCode = keyCode;
			dialog.dismiss();
		}

		lastKeyDownCode = keyCode;
	}


	private void onKeyUp(DialogInterface dialog, int keyCode) {
		lastKeyDownCode = KeyEvent.KEYCODE_UNKNOWN;
		lastLongPressCode = KeyEvent.KEYCODE_UNKNOWN;
		if (onIgnore(keyCode)) {
			return;
		}

		if (onCancel(keyCode) || onUnassign(keyCode) || onAssign(dialog, keyCode)) {
			dialog.dismiss();
		}
	}


	private boolean onAssign(DialogInterface dialog, int keyCode) {
		if (Key.isNumber(keyCode)) {
			return false;
		}

		if (onReassign(dialog, keyCode)) {
			return true;
		}

		settings.setFunctionKey(getKey(), keyCode);
		populate();
		return true;
	}


	private boolean onReassign(DialogInterface dialog, int keyCode) {
		String otherFunction = settings.getFunction(keyCode);
		if (otherFunction == null) {
			return false;
		}

		// "Shift" and "Korean Space" can be the same key. It is properly handled in HotkeyHandler.
		if (
			(getKey().equals(SectionKeymap.ITEM_SPACE_KOREAN) && otherFunction.equals(SectionKeymap.ITEM_SHIFT))
			|| (getKey().equals(SectionKeymap.ITEM_SHIFT) && otherFunction.equals(SectionKeymap.ITEM_SPACE_KOREAN))
		) {
			return false;
		}


		dialog.dismiss();

		UI.confirm(
			getContext(),
			getKey(),
			getContext().getString(R.string.function_already_assigned, otherFunction, getTitle()),
			getContext().getString(R.string.function_reassign),
			() -> {
				settings.setFunctionKey(otherFunction, KeyEvent.KEYCODE_UNKNOWN);
				onAssign(dialog, keyCode);
			},
			true,
			null,
			null
		);

		return true;
	}


	private boolean onUnassign(int keyCode) {
		if (Key.codeToNumber(settings, keyCode) != UNASSIGN_KEY) {
			return false;
		}

		settings.setFunctionKey(getKey(), KeyEvent.KEYCODE_UNKNOWN);
		populate();
		return true;
	}


	private boolean onCancel(int keyCode) {
		return
			(DeviceInfo.noKeyboard(getContext()) && Key.isBack(keyCode))
			|| Key.codeToNumber(settings, keyCode) == CANCEL_KEY;
	}


	private boolean onIgnore(int keyCode) {
		return Key.isOK(keyCode);
	}
}
