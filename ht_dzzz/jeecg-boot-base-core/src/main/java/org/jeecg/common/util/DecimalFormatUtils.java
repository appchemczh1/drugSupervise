package org.jeecg.common.util;

import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>Created by Raofeicheng on 2024/9/12.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class DecimalFormatUtils {

	public static String format(Double value, String pattern) {
		return getInstance(pattern).format(value);
	}

	public static DecimalFormat getInstance(String pattern) {
		DecimalFormat res = instanceCache.get(pattern);
		if (null == res) {
			res = new DecimalFormat(pattern);
			DecimalFormat previousValue = instanceCache.putIfAbsent(pattern, res);
			if (previousValue != null) res = previousValue;
		}
		return res;
	}

	private static final ConcurrentMap<String, DecimalFormat> instanceCache = new ConcurrentHashMap<>(7);

}
