package io.github.sspanak.tt9.preferences.screens.deleteWords;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceCategory;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.db.DataStore;
import io.github.sspanak.tt9.languages.LanguageCollection;
import io.github.sspanak.tt9.preferences.custom.ScreenPreference;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.UI;

public class PreferenceDeletableWord extends ScreenPreference {
	private DeletableWordsList parent;
	private String word;


	public PreferenceDeletableWord(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); }
	public PreferenceDeletableWord(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); }
	public PreferenceDeletableWord(@NonNull Context context, @Nullable AttributeSet attrs) { super(context, attrs); }
	public PreferenceDeletableWord(@NonNull Context context) { super(context); }


	@Override protected int getDefaultLayout() { return R.layout.pref_deletable_word; }
	@Override protected int getLargeLayout() { return R.layout.pref_deletable_word_large; }


	void setParent(DeletableWordsList parent) {
		if (parent != null) {
			this.parent = parent;
		}
	}


	void setWord(String word) {
		this.word = word;
		setTitle(word);
	}


	@Override
	protected void onClick() {
		super.onClick();

		Context context = getContext();

		UI.confirm(
			context,
			context.getString(R.string.delete_words_deleted_confirm_deletion_title),
			context.getString(R.string.delete_words_deleted_confirm_deletion_question, word),
			context.getString(R.string.delete_words_delete),
			this::onDeletionConfirmed,
			true,
			null,
			null
		);
	}


	private void onDeletionConfirmed() {
		SettingsStore settings = new SettingsStore(getContext());
		DataStore.deleteCustomWord(
			this::onWordDeleted,
			LanguageCollection.getLanguage(settings.getInputLanguage()),
			word
		);
	}


	private void deleteSelf() {
		if (parent != null) {
			parent.delete(this);
		} else if (getParent() instanceof PreferenceCategory) {
			getParent().removePreference(this);
		}

		UI.toastFromAsync(getContext(), getContext().getString(R.string.delete_words_deleted_x, word));
	}


	private void onWordDeleted() {
		((Activity) getContext()).runOnUiThread(this::deleteSelf);
	}
}
