package io.github.sspanak.tt9.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import io.github.sspanak.tt9.Logger;
import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.ime.TraditionalT9;
import io.github.sspanak.tt9.languages.Language;

public class UI {
	public static void showAddWordDialog(TraditionalT9 tt9, int language, String currentWord) {
		Intent awIntent = new Intent(tt9, AddWordAct.class);
		awIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		awIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		awIntent.putExtra("io.github.sspanak.tt9.word", currentWord);
		awIntent.putExtra("io.github.sspanak.tt9.lang", language);
		tt9.startActivity(awIntent);
	}


	public static void showPreferencesScreen(TraditionalT9 tt9) {
		Intent prefIntent = new Intent(tt9, TraditionalT9Settings.class);
		prefIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		prefIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		tt9.hideWindow();
		tt9.startActivity(prefIntent);
	}


	/**
	 * updateStatusIcon
	 * Set the status icon that is appropriate in current mode (based on
	 * openwmm-legacy)
	 */
	public static void updateStatusIcon(TraditionalT9 tt9, Language inputLanguage, int inputMode, int textCase) {
		switch (inputMode) {
			case TraditionalT9.MODE_ABC:
				tt9.showStatusIcon(inputLanguage.getAbcIcon(textCase == TraditionalT9.CASE_LOWER));
				break;
			case TraditionalT9.MODE_PREDICTIVE:
				tt9.showStatusIcon(inputLanguage.getIcon());
				break;
			case TraditionalT9.MODE_123:
				tt9.showStatusIcon(R.drawable.ime_number);
				break;
			default:
				Logger.w("tt9.UI", "Unknown inputMode mode: " + inputMode + ". Hiding status icon.");
				tt9.hideStatusIcon();
				break;
		}
	}

	public static void toast(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void toast(Context context, int resourceId) {
		Toast.makeText(context, resourceId, Toast.LENGTH_SHORT).show();
	}

	public static void toastLong(Context context, int resourceId) {
		Toast.makeText(context, resourceId, Toast.LENGTH_LONG).show();
	}

	public static void toastLong(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}
