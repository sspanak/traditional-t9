package io.github.sspanak.tt9.ui.main.keys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import java.util.ArrayList;

import io.github.sspanak.tt9.Logger;
import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.ime.helpers.Key;
import io.github.sspanak.tt9.ime.modes.InputMode;
import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.languages.LanguageCollection;

public class SoftNumberKey extends SoftKey {
	public SoftNumberKey(Context context) {
		super(context);
	}

	public SoftNumberKey(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SoftNumberKey(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	protected boolean handlePress(int keyId) {
		if (tt9 == null) {
			Logger.w(getClass().getCanonicalName(), "Traditional T9 handler is not set. Ignoring key press.");
			return false;
		}

		int keyCode = Key.numberToCode(getNumber(keyId));
		if (keyCode < 0) {
			return false;
		}

		tt9.onKeyDown(keyCode, new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
		tt9.onKeyUp(keyCode, new KeyEvent(KeyEvent.ACTION_UP, keyCode));

		return true;
	}

	private int getNumber(int keyId) {
		if (keyId == R.id.soft_key_0) return 0;
		if (keyId == R.id.soft_key_1) return 1;
		if (keyId == R.id.soft_key_2) return 2;
		if (keyId == R.id.soft_key_3) return 3;
		if (keyId == R.id.soft_key_4) return 4;
		if (keyId == R.id.soft_key_5) return 5;
		if (keyId == R.id.soft_key_6) return 6;
		if (keyId == R.id.soft_key_7) return 7;
		if (keyId == R.id.soft_key_8) return 8;
		if (keyId == R.id.soft_key_9) return 9;

		return -1;
	}

	@Override
	protected String getTitle() {
		return String.valueOf(getNumber(getId()));
	}

	@Override
	protected String getSubTitle() {
		if (tt9 == null || tt9.getSettings().getInputMode() == InputMode.MODE_123) {
			return null;
		}

		int number = getNumber(getId());
		int textCase = tt9.getSettings().getTextCase();
		Language language = LanguageCollection.getLanguage(tt9.getSettings().getInputLanguage());

		if (language == null) {
			Logger.d("SoftNumberKey.getLabel", "Cannot generate a label when the language is NULL.");
			return "";
		}

		if (number == 0) {
			COMPLEX_LABEL_SUB_TITLE_SIZE = 1;
			return "␣";
		}

		if (number == 1) {
			return ",:-)";
		}

		StringBuilder sb = new StringBuilder();
		ArrayList<String> chars = language.getKeyCharacters(number, false);
		for (int i = 0; i < 5 && i < chars.size(); i++) {
			sb.append(
				textCase == InputMode.CASE_UPPER ? chars.get(i).toUpperCase(language.getLocale()) : chars.get(i)
			);
		}

		return sb.toString();
	}
}
