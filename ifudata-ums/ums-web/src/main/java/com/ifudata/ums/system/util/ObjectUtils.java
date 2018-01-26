package com.ifudata.ums.system.util;


import com.ifudata.ums.system.exception.BusiException;

public class ObjectUtils {
	/**
	 * 如果对象为空，抛异常
	 */
	public static void nullException(Object o, String msg) {
		if (o == null) {
			throw new BusiException("nullException(null)----" + msg);
		}
	}

	/**
	 * 如果对象为空，抛异常
	 */
	public static void blankException(Object o, String msg) {
		if (o == null) {
			throw new BusiException("blankException(null)----" + msg);
		} else if (o instanceof Long && (Long) o == 0) {
			throw new BusiException("blankException(0)----" + msg);
		}
	}
}
