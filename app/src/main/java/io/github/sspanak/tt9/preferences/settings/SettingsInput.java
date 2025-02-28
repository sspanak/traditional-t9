package io.github.sspanak.tt9.preferences.settings;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import io.github.sspanak.tt9.languages.LanguageCollection;
import io.github.sspanak.tt9.util.Logger;

class SettingsInput extends SettingsHotkeys {
	SettingsInput(Context context) { super(context); }


	public ArrayList<Integer> getEnabledLanguageIds() {
		Set<String> languagesPref = getEnabledLanguagesIdsAsStrings();

		ArrayList<Integer>languageIds = new ArrayList<>();
		for (String languageId : languagesPref) {
			languageIds.add(Integer.valueOf(languageId));
		}

		return languageIds;
	}


	public void saveEnabledLanguageIds(ArrayList<Integer> languageIds) {
		Set<String> idsAsStrings = new HashSet<>();
		for (int langId : languageIds) {
			idsAsStrings.add(String.valueOf(langId));
		}

		saveEnabledLanguageIds(idsAsStrings);
	}


	public Set<String> getEnabledLanguagesIdsAsStrings() {
		Set<String> defaultLanguages =  new HashSet<>(Collections.singletonList(
			String.valueOf(LanguageCollection.getDefault().getId())
		));

		return new HashSet<>(prefs.getStringSet("pref_languages", defaultLanguages));
	}


	public void saveEnabledLanguageIds(Set<String> languageIds) {
		Set<String> validLanguageIds = new HashSet<>();

		for (String langId : languageIds) {
			if (!Validators.validateInputLanguage(Integer.parseInt(langId), "saveEnabledLanguageIds")){
				continue;
			}

			validLanguageIds.add(langId);
		}

		if (validLanguageIds.isEmpty()) {
			Logger.w(LOG_TAG, "Refusing to save an empty language list");
			return;
		}

		prefsEditor.putStringSet("pref_languages", validLanguageIds);
		prefsEditor.apply();
	}


	public int getInputLanguage() {
		return prefs.getInt("pref_input_language", LanguageCollection.getDefault().getId());
	}


	public void saveInputLanguage(int language) {
		if (Validators.validateInputLanguage(language, "saveInputLanguage")){
			prefsEditor.putInt("pref_input_language", language);
			prefsEditor.apply();
		}
	}


	public int getInputMode() {
		return prefs.getInt("pref_input_mode", Validators.DEFAULT_INPUT_MODE);
	}


	public void saveInputMode(int mode) {
		boolean isModeValid = Validators.validateInputMode(mode, LOG_TAG, "Not saving invalid input mode: " + mode);
		if (isModeValid) {
			prefsEditor.putInt("pref_input_mode", mode);
			prefsEditor.apply();
		}
	}


	public int getTextCase() {
		return prefs.getInt("pref_text_case", Validators.DEFAULT_TEXT_CASE);
	}


	public void saveTextCase(int textCase) {
		boolean isTextCaseValid = Validators.validateTextCase(textCase, LOG_TAG,"Not saving invalid text case: " + textCase);
		if (isTextCaseValid) {
			prefsEditor.putInt("pref_text_case", textCase);
			prefsEditor.apply();
		}
	}
}
