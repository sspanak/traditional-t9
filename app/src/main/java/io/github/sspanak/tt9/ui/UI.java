package io.github.sspanak.tt9.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.HashMap;

import io.github.sspanak.tt9.hacks.DeviceInfo;
import io.github.sspanak.tt9.preferences.PreferencesActivity;

public class UI {
	private static final HashMap<String, Toast> singleToasts = new HashMap<>();


	public static void showChangeKeyboardDialog(Context context) {
		((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).showInputMethodPicker();
	}


	public static boolean showSystemSpellCheckerSettings(Context context) {
		ComponentName component = new ComponentName(
			"com.android.settings",
			"com.android.settings.Settings$SpellCheckersSettingsActivity"
		);

		Intent intent = new Intent();
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setComponent(component);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		try {
			context.startActivity(intent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public static void showSettingsScreen(InputMethodService ims) {
		Intent prefIntent = new Intent(ims, PreferencesActivity.class);
		prefIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		prefIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		ims.startActivity(prefIntent);
	}


	public static void confirm(@NonNull Context context, String title, String message, String OKLabel, Runnable onOk, boolean cancelLabel, Runnable onCancel, DialogInterface.OnKeyListener onKey) {
		Dialog dialogue;

		if (DeviceInfo.AT_LEAST_ANDROID_12) {
			 dialogue = new MaterialAlertDialogBuilder(context)
				.setMessage(message)
				.setPositiveButton(OKLabel, (dialog, whichButton) -> { if (onOk != null) onOk.run(); })
				.setNegativeButton(cancelLabel ? context.getString(android.R.string.cancel) : null, (dialog, whichButton) -> { if (onCancel != null) onCancel.run(); })
				.show();
		} else {
			dialogue = new AlertDialog.Builder(context)
				.setMessage(message)
				.setPositiveButton(OKLabel, (dialog, whichButton) -> { if (onOk != null) onOk.run(); })
				.setNegativeButton(cancelLabel ? context.getString(android.R.string.cancel) : null, (dialog, whichButton) -> { if (onCancel != null) onCancel.run(); })
				.show();
		}

		dialogue.setTitle(title);
		dialogue.setCancelable(false);
		if (onKey != null) {
			dialogue.setOnKeyListener(onKey);
		}
	}


	public static void toast(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}


	public static void toastFromAsync(Context context, CharSequence msg) {
		if (Looper.myLooper() == null) {
			Looper.prepare();
		}
		toast(context, msg);
	}


	public static void toast(Context context, int resourceId) {
		Toast.makeText(context, resourceId, Toast.LENGTH_SHORT).show();
	}


	public static void toastFromAsync(Context context, int resourceId) {
		if (Looper.myLooper() == null) {
			Looper.prepare();
		}
		toast(context, resourceId);
	}


	public static void toastLong(Context context, int resourceId) {
		Toast.makeText(context, resourceId, Toast.LENGTH_LONG).show();
	}


	public static void toastLong(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}


	public static void toastLongFromAsync(Context context, CharSequence msg) {
		if (Looper.myLooper() == null) {
			Looper.prepare();
		}
		toastLong(context, msg);
	}


	public static void toastSingle(@NonNull Context context, @NonNull String uniqueId, @NonNull String message, boolean isShort) {
		Toast toast = singleToasts.get(uniqueId);

		if (toast != null) {
			toast.cancel();
		}

		// we recreate the toast, because if set new text, when it is fading out, it is ignored
		toast = Toast.makeText(context, message, isShort ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
		toast.show();

		singleToasts.put(uniqueId, toast);
	}


	public static void toastShortSingle(@NonNull Context context, @NonNull String uniqueId, @NonNull String message) {
		toastSingle(context, uniqueId, message, true);
	}


	public static void toastShortSingle(@NonNull Context context, int resourceId) {
		toastSingle(context, String.valueOf(resourceId), context.getString(resourceId), true);
	}
}
