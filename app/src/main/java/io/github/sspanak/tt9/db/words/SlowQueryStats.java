package io.github.sspanak.tt9.db.words;

import java.util.HashMap;

import io.github.sspanak.tt9.languages.Language;
import io.github.sspanak.tt9.preferences.settings.SettingsStore;
import io.github.sspanak.tt9.util.Logger;
import io.github.sspanak.tt9.util.TextTools;

public class SlowQueryStats {
	private static final String LOG_TAG = SlowQueryStats.class.getSimpleName();
	private static long firstQueryTime = -1;
	private static long maxQueryTime = 0;
	private static long totalQueries = 0;
	private static long totalQueryTime = 0;
	private static final HashMap<String, Integer> slowQueries = new HashMap<>();
	private static final HashMap<String, String> resultCache = new HashMap<>();


	public static String generateKey(Language language, String sequence, String wordFilter, int minimumWords) {
		return language.getId() + "_" + sequence + "_" + wordFilter + "_" + minimumWords;
	}

	public static void add(Language language, String sequence, String wordFilter, int minimumWords, int time, String positionsList) {
		if (firstQueryTime == -1) {
			firstQueryTime = System.currentTimeMillis();
		}
		maxQueryTime = Math.max(maxQueryTime, time);
		totalQueries++;
		totalQueryTime += time;
		if (time < SettingsStore.SLOW_QUERY_TIME) {
			return;
		}

		String key = generateKey(language, sequence, wordFilter, minimumWords);
		slowQueries.put(key, time);
		if (!resultCache.containsKey(key)) {
			resultCache.put(key, positionsList.replaceAll("-\\d+,", ""));
		}
	}

	public static String getCachedIfSlow(String key) {
		Integer queryTime = slowQueries.get(key);
		boolean isSlow = queryTime != null && queryTime >= SettingsStore.SLOW_QUERY_TIME;

		if (isSlow) {
			Logger.d(LOG_TAG, "Loading cached positions for query: " + key);
			return resultCache.get(key);
		} else {
			return null;
		}
	}

	public static String getSummary() {
		long slowQueryTotalTime = 0;
		for (int time : slowQueries.values()) {
			slowQueryTotalTime += time;
		}

		long averageTime = totalQueries == 0 ? 0 : totalQueryTime / totalQueries;
		long slowAverageTime = slowQueries.isEmpty() ? 0 : slowQueryTotalTime / slowQueries.size();

		return
			"Queries: " + totalQueries + ". Average time: " + averageTime + " ms." +
			"\nSlow: " + slowQueries.size() + ". Average time: " + slowAverageTime + " ms." +
			"\nSlowest: " + maxQueryTime + " ms." +
			"\nFirst: " + TextTools.unixTimestampToISODate(firstQueryTime);
	}

	public static String getList() {
		StringBuilder sb = new StringBuilder();
		for (String key : slowQueries.keySet()) {
			sb.append(key).append(": ").append(slowQueries.get(key)).append(" ms\n");
		}

		return sb.toString();
	}


	public static void clear() {
		firstQueryTime = -1;
		maxQueryTime = 0;
		totalQueries = 0;
		totalQueryTime = 0;
		slowQueries.clear();
		resultCache.clear();
	}
}
