package io.github.sspanak.tt9.preferences.screens.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.UI;
import io.github.sspanak.tt9.util.Logger;

public class DonatePreference extends Preference {
	public static final String NAME = "donate_link";


	public DonatePreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public DonatePreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public DonatePreference(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public DonatePreference(@NonNull Context context) {
		super(context);
	}


	@Override
	public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
		super.onBindViewHolder(holder);
		holder.itemView.setOnLongClickListener(this::onLongClick);
	}


	public DonatePreference populate(SettingsStore settings, boolean isTT9On) {
		boolean isVisible = isTT9On && !settings.getDemoMode() && settings.getDonationsVisible();
		Context context = getContext();

		if (isVisible) {
			String appName = context.getString(R.string.app_name_short);
			setSummary(
				context.getString(R.string.donate_summary, appName) + " " + context.getString(R.string.donate_hold_to_open)
			);
		}
		setVisible(isVisible);
		setIconSpaceReserved(false);

		return this;
	}


	@Override
	protected void onClick() {
		super.onClick();
		UI.toastShortSingle(getContext(), R.string.donate_hold_to_open);
	}


	private boolean onLongClick(View v) {
		try {
			getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.donate_url))));
			return true;
		} catch (Exception e) {
			Logger.w(getClass().getSimpleName(), "Cannot navigate to the donation page. " + e.getMessage() + " (do you have a browser?)");
			return false;
		}
	}
}
