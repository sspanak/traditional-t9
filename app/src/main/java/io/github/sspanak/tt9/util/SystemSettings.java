package io.github.sspanak.tt9.util;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;

import java.util.Locale;


public class SystemSettings {
	private static InputMethodManager inputManager;
	private static String packageName;

	public static boolean isTT9Enabled(Context context) {
		inputManager = inputManager == null ? (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE) : inputManager;
		packageName = packageName == null ? context.getPackageName() : packageName;

		for (final InputMethodInfo imeInfo : inputManager.getEnabledInputMethodList()) {
			if (packageName.equals(imeInfo.getPackageName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isTT9Active(Context context) {
		String defaultIME = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
		inputManager = inputManager == null ? (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE) : inputManager;
		packageName = packageName == null ? context.getPackageName() : packageName;

		for (final InputMethodInfo imeInfo : inputManager.getEnabledInputMethodList()) {
			if (packageName.equals(imeInfo.getPackageName()) && imeInfo.getId().equals(defaultIME)) {
				return true;
			}
		}
		return false;
	}

	public static String getLocale() {
		Locale locale = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? LocaleList.getDefault().get(0) : Locale.getDefault();
		String country = locale.getCountry();
		String language = locale.getLanguage();

		if (language.equals(Locale.ENGLISH.getLanguage())) {
			country = "";
		}

		return country.isEmpty() ? language : language + "_" + country;
	}

	@Nullable
	public static String getPreviousIME(Context context) {
		inputManager = inputManager == null ? (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE) : inputManager;
		packageName = packageName == null ? context.getPackageName() : packageName;

		for (final InputMethodInfo imeInfo : inputManager.getEnabledInputMethodList()) {
			if (!packageName.equals(imeInfo.getPackageName())) {
				return imeInfo.getId();
			}
		}

		return null;
	}
}
