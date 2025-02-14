package io.github.sspanak.tt9.ui.tray;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.ui.Vibration;
import io.github.sspanak.tt9.ui.main.ResizableMainView;
import io.github.sspanak.tt9.util.chars.Characters;

public class SuggestionsBar {
	private final String STEM_SUFFIX = "… +";
	private final String STEM_VARIATION_PREFIX = "…";
	private final String STEM_PUNCTUATION_VARIATION_PREFIX = "​";
	@NonNull private String stem = "";

	private int backgroundColor = Color.TRANSPARENT;
	private double lastClickTime = 0;
	protected int selectedIndex = 0;
	private final List<String> suggestions = new ArrayList<>();

	private final ResizableMainView mainView;
	private final Runnable onItemClick;
	@Nullable private final RecyclerView mView;
	private final SettingsStore settings;
	private SuggestionsAdapter mSuggestionsAdapter;
	private Vibration vibration;

	private final Handler alternativeScrollingHandler = new Handler();


	public SuggestionsBar(@NonNull SettingsStore settings, @NonNull ResizableMainView mainView, @NonNull Runnable onItemClick) {
		this.onItemClick = onItemClick;
		this.settings = settings;

		this.mainView = mainView;
		mView = mainView.getView() != null ? mainView.getView().findViewById(R.id.suggestions_bar) : null;
		if (mView != null) {
			Context context = mainView.getView().getContext();

			mView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
			mView.setOnTouchListener(this::onTouch);

			initDataAdapter(context);
			initSeparator(context);
			configureAnimation();
			vibration = new Vibration(settings, mView);
		}
	}


	private void configureAnimation() {
		if (mView == null) {
			return;
		}

		DefaultItemAnimator animator = new DefaultItemAnimator();

		animator.setMoveDuration(SettingsStore.SUGGESTIONS_SELECT_ANIMATION_DURATION);
		animator.setChangeDuration(SettingsStore.SUGGESTIONS_TRANSLATE_ANIMATION_DURATION);
		animator.setAddDuration(SettingsStore.SUGGESTIONS_TRANSLATE_ANIMATION_DURATION);
		animator.setRemoveDuration(SettingsStore.SUGGESTIONS_TRANSLATE_ANIMATION_DURATION);

		mView.setItemAnimator(animator);
	}


	private void initDataAdapter(Context context) {
		if (mView == null) {
			return;
		}

		mSuggestionsAdapter = new SuggestionsAdapter(
			context,
			this::handleItemClick,
			settings.isMainLayoutNumpad() ? R.layout.suggestion_list_numpad : R.layout.suggestion_list,
			R.id.suggestion_list_item,
			suggestions
		);

		mView.setAdapter(mSuggestionsAdapter);

		setDarkTheme();
	}


	private void initSeparator(Context context) {
		if (mView == null) {
			return;
		}

		// Extra XML is required instead of a ColorDrawable object, because setting the highlight color
		// erases the borders defined using the ColorDrawable.
		Drawable separatorDrawable = ContextCompat.getDrawable(context, R.drawable.suggestion_separator);
		if (separatorDrawable == null) {
			return;
		}

		DividerItemDecoration separator = new DividerItemDecoration(mView.getContext(), RecyclerView.HORIZONTAL);
		separator.setDrawable(separatorDrawable);
		mView.addItemDecoration(separator);
	}


	public boolean isEmpty() {
		return suggestions.isEmpty();
	}


	public boolean containsStem() {
		return !stem.isEmpty();
	}


	public int getCurrentIndex() {
		return selectedIndex;
	}


	@NonNull
	public String getSuggestion(int id) {
		if (id < 0 || id >= suggestions.size()) {
			return "";
		}

		String suggestion = suggestions.get(id);

		if (suggestion.endsWith(STEM_SUFFIX)) {
			return stem;
		} else if (suggestion.startsWith(STEM_VARIATION_PREFIX)) {
			return stem + suggestion.substring(STEM_VARIATION_PREFIX.length());
		} else if (suggestion.startsWith(STEM_PUNCTUATION_VARIATION_PREFIX)) {
			return stem + suggestion.substring(STEM_PUNCTUATION_VARIATION_PREFIX.length());
		}

		return switch (suggestion) {
			case Characters.ZWJ_GRAPHIC -> Characters.ZWJ;
			case Characters.ZWNJ_GRAPHIC -> Characters.ZWNJ;
			default -> suggestion.equals(Characters.NEW_LINE) ? "\n" : suggestion;
		};
	}


	public void setRTL(boolean yes) {
		if (mView != null) {
			mView.setLayoutDirection(yes ? View.LAYOUT_DIRECTION_RTL : View.LAYOUT_DIRECTION_LTR);
		}
	}


	public void setSuggestions(List<String> newSuggestions, int initialSel, boolean containsGenerated) {
		ecoSetBackground(newSuggestions);

		suggestions.clear();
		selectedIndex = newSuggestions == null || newSuggestions.isEmpty() ? 0 : Math.max(initialSel, 0);

		setStem(newSuggestions, containsGenerated);
		addAllSuggestions(newSuggestions);
		selectedIndex = Math.min(selectedIndex, suggestions.size() - 1);
		setSuggestionsOnScreen();
	}


	private void setStem(List<String> newSuggestions, boolean containsGenerated) {
		if (newSuggestions == null || newSuggestions.size() < 2) {
			stem = "";
			return;
		}

		stem = containsGenerated ? newSuggestions.get(0).substring(0, newSuggestions.get(0).length() - 1) : "";

		// Do not modify single letter + punctuation, such as "j'" or "l'". They look better as they are.
		stem = (stem.length() == 1 && newSuggestions.get(0).length() == 2 && !Character.isAlphabetic(newSuggestions.get(0).charAt(1))) ? "" : stem;

		// If no other suggestion contains the stem, it makes no sense to separate them and display:
		// "STEM" + "one-suggestion". It is only useful when there are multiple suggestions with the
		// same stem.
		boolean onlyOneContainsStem = true;
		for (int i = 1; i < newSuggestions.size(); i++) {
			if (newSuggestions.get(i).contains(stem)) {
				onlyOneContainsStem = false;
				break;
			}
		}
		stem = onlyOneContainsStem ? "" : stem;

		if (!stem.isEmpty() && !newSuggestions.contains(stem)) {
			suggestions.add(stem + STEM_SUFFIX);
			selectedIndex++;
		}
	}


	private void addAllSuggestions(List<String> newSuggestions) {
		if (newSuggestions != null) {
			for (String suggestion : newSuggestions) {
				addSuggestion(suggestion);
			}
		}
	}


	private void addSuggestion(@NonNull String suggestion) {
		// shorten the stem variations
		if (!stem.isEmpty() && suggestion.length() == stem.length() + 1 && suggestion.toLowerCase().startsWith(stem.toLowerCase())) {
			String trimmedSuggestion = suggestion.substring(stem.length());
			char firstChar = trimmedSuggestion.charAt(0);

			String prefix = Character.isAlphabetic(firstChar) && !Characters.isCombiningPunctuation(firstChar) ? STEM_VARIATION_PREFIX : STEM_PUNCTUATION_VARIATION_PREFIX;

			// it is a combining character, but since it is a letter, we must include a base character,
			// not to break it, with a "..." prefix
			prefix = Characters.isFathatan(firstChar) ? " " : prefix;

			suggestions.add(prefix + formatUnreadableSuggestion(trimmedSuggestion));
			return;
		}

		suggestions.add(formatUnreadableSuggestion(suggestion));
	}


	private String formatUnreadableSuggestion(String suggestion) {
		return switch (suggestion) {
			case "\n" -> Characters.NEW_LINE;
			case Characters.ZWJ -> Characters.ZWJ_GRAPHIC;
			case Characters.ZWNJ -> Characters.ZWNJ_GRAPHIC;
			default -> suggestion;
		};
	}



	private void setSuggestionsOnScreen() {
		if (mView != null) {
			mSuggestionsAdapter.resetItems(selectedIndex);
			mView.scrollToPosition(selectedIndex);
		}
	}


	public void scrollToSuggestion(int increment) {
		if (suggestions.size() <= 1) {
			return;
		}

		calculateScrollIndex(increment);
		scrollToIndex();
	}


	private void calculateScrollIndex(int increment) {
		selectedIndex = selectedIndex + increment;
		if (selectedIndex == suggestions.size()) {
			selectedIndex = containsStem() ? 1 : 0;
		} else if (selectedIndex < 0) {
			selectedIndex = suggestions.size() - 1;
		} else if (selectedIndex == 0 && containsStem()) {
			selectedIndex = suggestions.size() - 1;
		}
	}


	private void scrollToIndex() {
		if (mView == null) {
			return;
		}

		mSuggestionsAdapter.setSelection(selectedIndex);

		if (settings.getSuggestionScrollingDelay() > 0) {
			alternativeScrollingHandler.removeCallbacksAndMessages(null);
			alternativeScrollingHandler.postDelayed(this::scrollView, settings.getSuggestionScrollingDelay());
		} else {
			scrollView();
		}
	}


	/**
	 * Tells the adapter to scroll. Always call scrollToIndex() first,
	 * to set the selected index in the adapter.
	 */
	private void scrollView() {
		if (mView == null) {
			return;
		}

		if (containsStem() && selectedIndex == 1) {
			mView.scrollToPosition(0);
		} else {
			mView.scrollToPosition(selectedIndex);
		}
	}


	/**
	 * setDarkTheme
	 * Changes the suggestion colors according to the theme. Due to the fact we change the colors
	 * dynamically based on the selected index and whether the suggestions are empty or not, we
	 * need to set them manually.
	 */
	public void setDarkTheme() {
		if (mView == null) {
			return;
		}

		Context context = mView.getContext();

		backgroundColor = ContextCompat.getColor(context, R.color.keyboard_background);
		mSuggestionsAdapter.setColorDefault(ContextCompat.getColor(context, R.color.keyboard_text));
		mSuggestionsAdapter.setColorHighlight(ContextCompat.getColor(context, R.color.suggestion_selected_text));
		mSuggestionsAdapter.setBackgroundHighlight(ContextCompat.getColor(context, R.color.suggestion_selected_background));

		setBackground(suggestions);
	}


	/**
	 * setBackground
	 * Makes the background transparent, when there are no suggestions and theme-colored,
	 * when there are suggestions.
	 */
	private void setBackground(List<String> newSuggestions) {
		if (mView == null) {
			return;
		}

		int newSuggestionsSize = newSuggestions != null ? newSuggestions.size() : 0;
		if (newSuggestionsSize == 0) {
			mView.setBackgroundColor(Color.TRANSPARENT);
			return;
		}

		mView.setBackgroundColor(backgroundColor);
	}


	/**
	 * ecoSetBackground
	 * A performance-optimized version of "setBackground().
	 * Determines if the suggestions have changed and only then it changes the background.
	 */
	private void ecoSetBackground(List<String> newSuggestions) {
		int newSuggestionsSize = newSuggestions != null ? newSuggestions.size() : 0;
		if (
			(newSuggestionsSize == 0 && suggestions.isEmpty())
			|| (newSuggestionsSize > 0 && !suggestions.isEmpty())
		) {
			return;
		}

		setBackground(newSuggestions);
	}


	/**
	 * handleItemClick
	 * Passes through suggestion selected using the touchscreen.
	 */
	private void handleItemClick(int position) {
		vibration.vibrate();
		selectedIndex = position;
		onItemClick.run();
	}


	private boolean onTouch(View v, MotionEvent event) {
		if (!isEmpty()) {
			return false;
		}

		int action = event.getAction();

		switch (action) {
			case MotionEvent.ACTION_DOWN:
				mainView.onResizeStart(event.getRawY());
				return true;
			case MotionEvent.ACTION_MOVE:
				mainView.onResizeThrottled(event.getRawY());
				return true;
			case MotionEvent.ACTION_UP:
				long now = System.currentTimeMillis();
				if (now - lastClickTime < SettingsStore.SOFT_KEY_DOUBLE_CLICK_DELAY) {
					mainView.onSnap();
				} else {
					mainView.onResize(event.getRawY());
				}

				lastClickTime = now;

				return true;
		}

		return false;
	}
}
