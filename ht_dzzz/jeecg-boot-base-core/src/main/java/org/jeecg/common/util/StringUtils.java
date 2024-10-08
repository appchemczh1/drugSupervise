package org.jeecg.common.util;

/**
 * <p>Created by Raofeicheng on 2024/8/28.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String join(String str1, String str2, String delimiter) {
		return format("%s" + delimiter + "%s", str1, str2);
	}

	public static String format(String format, String str1, String str2) {
		return format(format, str1, str2, false);
	}

	public static String format(String format, String str1, String str2, boolean forceFormat) {
		str1 = trimToEmpty(str1);
		str2 = trimToEmpty(str2);
		if (forceFormat || isNotBlank(str1) && isNotBlank(str2))
			return String.format(format, str1, str2);
		else if (isNotBlank(str1)) return str1;
		else if (isNotBlank(str2)) return str2;
		return EMPTY;
	}

	public static String desensitize(String str) {
		if (isBlank(str)) return str;
		str = trimToEmpty(str);
		String[] array = {"/", "\\", "-", "~", "无", "N/A"};
		if (equalsAnyIgnoreCase(str, array)) return str;
		if (str.matches("^1\\d{10}$")) return left(str, 3) + "****" + right(str, 4);
		if (str.matches("(?i)^\\d{17}[0-9xX]$")) return left(str, 6) + "********" + right(str, 4);
		return left(str, 1) + "*" + right(str, 1);
	}

}
