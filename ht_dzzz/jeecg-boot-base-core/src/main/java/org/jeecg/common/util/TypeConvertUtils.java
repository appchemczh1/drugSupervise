package org.jeecg.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * <p>Created by Raofeicheng on 2023/9/22.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@SuppressWarnings({"unchecked"})
public class TypeConvertUtils {

	public static <T> T convert(Object source, Class<T> clazz) {
		if (null == source) return null;
		if (String.class.isAssignableFrom(clazz)) return (T) toString(source);
		else if (Long.class.isAssignableFrom(clazz)) return (T) toLong(source);
		else if (Long.TYPE.isAssignableFrom(clazz)) return (T) toLong(source, 0L);
		else if (Integer.class.isAssignableFrom(clazz)) return (T) toInteger(source);
		else if (Integer.TYPE.isAssignableFrom(clazz)) return (T) toInteger(source, 0);
		else if (Double.class.isAssignableFrom(clazz)) return (T) toDouble(source);
		else if (Double.TYPE.isAssignableFrom(clazz)) return (T) toDouble(source, 0.0);
		else if (BigInteger.class.isAssignableFrom(clazz)) return (T) toBigInteger(source);
		else if (BigDecimal.class.isAssignableFrom(clazz)) return (T) toBigDecimal(source);
		else if (Date.class.isAssignableFrom(clazz)) return (T) toDate(source, (Class<? extends Date>) clazz);
		throw new UnsupportedOperationException(String.format("unsupported form %s(%s) to %s", source.getClass().getName(), source, clazz.getName()));
	}

	public static Long[] toLongs(String... strs) {
		return toLongs(10, strs);
	}

	public static Long[] toLongs(int radix, String... strs) {
		Set<Long> ls = toLongSet(radix, strs);
		return ls.toArray(new Long[0]);
	}

	public static Set<Long> toLongSet(String... strs) {
		return toLongSet(10, strs);
	}

	public static Set<Long> toLongSet(int radix, String... strs) {
		Set<Long> ls = new LinkedHashSet<>();
		if (ArrayUtils.isEmpty(strs)) return ls;
		for (String s : strs) {
			try {
				ls.add(Long.parseLong(s, radix));
			} catch (Exception ignore) {}
		}
		return ls;
	}

	public static Integer[] toIntegers(String... strs) {
		return toIntegers(10, strs);
	}

	public static Integer[] toIntegers(int radix, String... strs) {
		Set<Integer> ls = toIntegerSet(radix, strs);
		return ls.toArray(new Integer[0]);
	}

	public static Set<Integer> toIntegerSet(String... strs) {
		return toIntegerSet(10, strs);
	}

	public static Set<Integer> toIntegerSet(int radix, String... strs) {
		Set<Integer> ls = new LinkedHashSet<>();
		if (ArrayUtils.isEmpty(strs)) return ls;
		for (String s : strs) {
			try {
				ls.add(Integer.parseInt(s, radix));
			} catch (Exception ignore) {}
		}
		return ls;
	}

	public static Integer toInteger(Object val) {
		return toInteger(val, integerDefaultVal);
	}

	public static Integer toInteger(Object val, Integer defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof Integer) return (Integer) val;
		if (val instanceof Number) return ((Number) val).intValue();
		if (val instanceof Date) return (int) ((Date) val).getTime();
		try {
			return Integer.parseInt(toString(val));
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	public static Long toLong(Object val) {
		return toLong(val, longDefaultVal);
	}

	public static Long toLong(Object val, Long defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof Number) return toLong((Number) val, defaultVal);
		else return toLong(val + "", defaultVal);
	}

	public static Long toLong(Number val) {
		return toLong(val, longDefaultVal);
	}

	public static Long toLong(Number val, Long defaultVal) {
		return null != val ? val.longValue() : defaultVal;
	}

	public static Long toLong(String val) {
		return toLong(val, longDefaultVal);
	}

	public static Long toLong(String val, Long defaultVal) {
		if (StringUtils.isBlank(val)) return defaultVal;
		try {
			return Long.parseLong(val);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	public static Double toDouble(Object val) {
		return toDouble(val, doubleDefaultVal);
	}

	public static Double toDouble(Object val, Double defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof Number) return toDouble((Number) val, defaultVal);
		else return toDouble(val + "", defaultVal);
	}

	public static Double toDouble(Number val) {
		return toDouble(val, doubleDefaultVal);
	}

	public static Double toDouble(Number val, Double defaultVal) {
		return null != val ? val.doubleValue() : defaultVal;
	}

	public static Double toDouble(String val) {
		return toDouble(val, doubleDefaultVal);
	}

	public static Double toDouble(String val, Double defaultVal) {
		if (StringUtils.isBlank(val)) return defaultVal;
		try {
			return Double.parseDouble(val);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	public static BigInteger toBigInteger(Object val) {
		return toBigInteger(val, bigIntegerDefaultVal);
	}

	public static BigInteger toBigInteger(Object val, BigInteger defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof Number) return toBigInteger((Number) val, defaultVal);
		else return toBigInteger(val + "", defaultVal);
	}

	public static BigInteger toBigInteger(Number val) {
		return toBigInteger(val, bigIntegerDefaultVal);
	}

	public static BigInteger toBigInteger(Number val, BigInteger defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof BigInteger) return (BigInteger) val;
		if (val instanceof BigDecimal) return ((BigDecimal) val).toBigInteger();
		return toBigInteger(val + "", defaultVal);
	}

	public static BigInteger toBigInteger(String val) {
		return toBigInteger(val, bigIntegerDefaultVal);
	}

	public static BigInteger toBigInteger(String val, BigInteger defaultVal) {
		if (StringUtils.isBlank(val)) return defaultVal;
		return new BigInteger(val);
	}

	public static BigDecimal toBigDecimal(Object val) {
		return toBigDecimal(val, bigDecimalDefaultVal);
	}

	public static BigDecimal toBigDecimal(Object val, BigDecimal defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof Number) return toBigDecimal((Number) val, defaultVal);
		else return toBigDecimal(val + "", defaultVal);
	}

	public static BigDecimal toBigDecimal(Number val) {
		return toBigDecimal(val, bigDecimalDefaultVal);
	}

	public static BigDecimal toBigDecimal(Number val, BigDecimal defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof BigInteger) return new BigDecimal((BigInteger) val);
		if (val instanceof BigDecimal) return (BigDecimal) val;
		return toBigDecimal(val + "", defaultVal);
	}

	public static BigDecimal toBigDecimal(String val) {
		return toBigDecimal(val, bigDecimalDefaultVal);
	}

	public static BigDecimal toBigDecimal(String val, BigDecimal defaultVal) {
		if (StringUtils.isBlank(val)) return defaultVal;
		return new BigDecimal(val);
	}

	public static String toString(Object val) {
		return toString(val, stringDefaultVal);
	}

	public static String toString(Object val, String defaultVal) {
		if (null == val) return defaultVal;
		if (val instanceof String) return (String) val;
		return val.toString();
	}

	/**
	 * 日期格式转换
	 * @param str 源日期字符串
	 */
	public static Date toDate(String str) {
		return toDate(str, "yyyyMMddHHmmss");
	}

	public static Date toDate(String str, String format) {
		try {
			if (StringUtils.isBlank(format)) format = "yyyyMMddHHmmss";
			return DateUtils.parseDate(StringUtils.trimToEmpty(str), new String[]{format, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss.SSS"
				, "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日HH时mm分ss秒"
				, "yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm", "yyyy年MM月dd日HH时mm分"
				, "yyyy-MM-dd HH", "yyyy/MM/dd HH", "yyyy年MM月dd日HH时"
				, "yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日"
				, "yyyy-MM", "yyyy/MM", "yyyy年MM月"
				, "MM-dd", "MM/dd", "MM月dd日"
				, "HH:mm:ss"
				, "HH:mm"});
		} catch (ParseException e) {
			return null;
		}
	}

	public static <T extends Date> T toDate(Object obj, Class<T> targetClass) {
		if (null == obj) {
			return null;
		}
		if (obj instanceof Date) {
			return toDate((Date) obj, targetClass);
		}
		return toDate(toDate(toString(obj)), targetClass);
	}

	/**
	 * 日期格式转换
	 * @param date        源日期
	 * @param targetClass 目标日期类型
	 */
	public static <T extends Date> T toDate(Date date, Class<T> targetClass) {
		if (null == date) {
			return null;
		}
		if (Timestamp.class.isAssignableFrom(targetClass)) {
			return (T) new Timestamp(date.getTime());
		} else if (Time.class.isAssignableFrom(targetClass)) {
			return (T) new Time(date.getTime());
		} else if (java.sql.Date.class.isAssignableFrom(targetClass)) {
			return (T) new java.sql.Date(date.getTime());
		} else if (Date.class.isAssignableFrom(targetClass)) {
			return (T) date;
		}
		return null;
	}

	public static Timestamp toTimestamp(Date date) {
		return null != date ? new Timestamp(date.getTime()) : null;
	}

	public static Boolean toBoolean(Object val) {
		return toBoolean(val, false);
	}

	public static Boolean toBoolean(Object val, Boolean defaultValue) {
		if (null == val) return defaultValue;
		if (val instanceof Boolean) return (Boolean) val;
		else if (val instanceof Number) return ((Number) val).intValue() != 0;
		else if (val instanceof Date) return defaultValue;
		else return defaultValue;
	}

	private static final String stringDefaultVal = "";
	private static final Integer integerDefaultVal = null;
	private static final Long longDefaultVal = null;
	private static final Double doubleDefaultVal = null;
	private static final BigInteger bigIntegerDefaultVal = null;
	private static final BigDecimal bigDecimalDefaultVal = null;

}
