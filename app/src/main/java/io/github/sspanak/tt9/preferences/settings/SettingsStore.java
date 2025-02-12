package io.github.sspanak.tt9.preferences.settings;

import android.content.Context;


public class SettingsStore extends SettingsUI {
	public SettingsStore(Context context) { super(context); }

	/************* internal settings *************/
	public static final int BACKSPACE_ACCELERATION_MAX_CHARS = 20;
	public static final int BACKSPACE_ACCELERATION_REPEAT_DEBOUNCE = 5;
	public final static int CLIPBOARD_PREVIEW_LENGTH = 20;
	public final static int CUSTOM_WORDS_IMPORT_MAX_LINES = 250;
	public final static int CUSTOM_WORDS_MAX = 1000;
	public final static int CUSTOM_WORDS_SEARCH_RESULTS_MAX = 50;
	public final static int DICTIONARY_AUTO_LOAD_COOLDOWN_TIME = 1200000; // 20 minutes in ms
	public final static int DICTIONARY_DOWNLOAD_CONNECTION_TIMEOUT = 10000; // ms
	public final static int DICTIONARY_DOWNLOAD_READ_TIMEOUT = 10000; // ms
	public final static int DICTIONARY_IMPORT_BATCH_SIZE = 5000; // words
	public final static int DICTIONARY_IMPORT_PROGRESS_UPDATE_TIME = 250; // ms
	public final static int RESIZE_THROTTLING_TIME = 60; // ms
	public final static byte SLOW_QUERY_TIME = 50; // ms
	public final static int SLOW_QUERY_TIMEOUT = 3000; // ms
	public final static float SOFT_KEY_AMOUNT_OF_KEY_SIZE_FOR_SWIPE = 0.5f; // 1 = full key size
	public final static int SOFT_KEY_DOUBLE_CLICK_DELAY = 500; // ms
	public final static int SOFT_KEY_REPEAT_DELAY = 40; // ms
	public final static float SOFT_KEY_SCALE_SCREEN_COMPENSATION_NORMAL_HEIGHT = 360; // dp
	public final static float SOFT_KEY_SCALE_SCREEN_COMPENSATION_NORMAL_WIDTH = 640; // dp
	public final static float SOFT_KEY_SCALE_SCREEN_COMPENSATION_MAX = 1.4f;
	public final static int SOFT_KEY_TITLE_MAX_CHARS = 5;
	public final static int SOFT_KEY_TITLE_MAX_CHARS_INDIC = 3;
	public final static float SOFT_KEY_V_SHAPE_RATIO_INNER = 1.1f;
	public final static float SOFT_KEY_V_SHAPE_RATIO_OUTER = (float) Math.pow(SOFT_KEY_V_SHAPE_RATIO_INNER, 2);
	public final static int SUGGESTIONS_MAX = 20;
	public final static int SUGGESTIONS_MIN = 8;
	public final static int SUGGESTIONS_POSITIONS_LIMIT = 100;
	public final static int SUGGESTIONS_SELECT_ANIMATION_DURATION = 66;
	public final static int SUGGESTIONS_TRANSLATE_ANIMATION_DURATION = 0;
	public final static int TEXT_INPUT_DEBOUNCE_TIME = 500; // ms
	public final static int TEXT_INPUT_PUNCTUATION_ORDER_DEBOUNCE_TIME = 100; // ms
	public final static int WORD_BACKGROUND_TASKS_DELAY = 15000; // ms
	public final static int WORD_FREQUENCY_MAX = 25500;
	public final static int WORD_FREQUENCY_NORMALIZATION_DIVIDER = 100; // normalized frequency = WORD_FREQUENCY_MAX / WORD_FREQUENCY_NORMALIZATION_DIVIDER
	public final static int WORD_PAIR_MAX = 1000;
	public final static int WORD_PAIR_MAX_WORD_LENGTH = 6;
	public final static int ZOMBIE_CHECK_INTERVAL = 1500; // ms
	public final static int ZOMBIE_CHECK_MAX = 2;

	/************* hacks *************/
	public final static int PREFERENCES_CLICK_DEBOUNCE_TIME = 250; // ms
}
