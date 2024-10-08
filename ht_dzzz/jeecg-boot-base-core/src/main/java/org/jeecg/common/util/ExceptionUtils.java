package org.jeecg.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>Created by Raofeicheng on 2016-10-23.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class ExceptionUtils {

	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Throwable e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e.getMessage(), e);
		}
	}

	public static RuntimeException newRuntimeException(String message) {
		return newRuntimeException(message, null);
	}

	public static RuntimeException newRuntimeException(String message, Throwable throwable) {
		if (null == throwable) return new RuntimeException(message);
		return new RuntimeException(message, throwable);
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String stackTraceToString(Throwable e) {
		if (e == null) {
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	public static void throwIllegalArgument(String msg, Object... params) {
		throw new IllegalArgumentException(String.format(msg, params));
	}

}
