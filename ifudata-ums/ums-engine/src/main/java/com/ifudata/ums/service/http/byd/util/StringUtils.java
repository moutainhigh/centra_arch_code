package com.ifudata.ums.service.http.byd.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtils {

	private static final Log log = LogFactory.getLog(StringUtils.class);

	/**
	 * 检测字符串编码
	 * 
	 * @param value
	 */
	public static String CheckUnicodeStringAndReplcace(String value, char replace) {
		for (int i = 0; i < value.length(); ++i) {
			if (value.charAt(i) > 0xFFFD) {
				log.debug("********** Invalid Unicode：" + i + ":" + value.charAt(i) + Integer.valueOf(value.charAt(i))
						+ " **********");
				// value[i]='"n';
			} else if (value.charAt(i) < 0x20
					&& (value.charAt(i) != '\t' || value.charAt(i) != '\n' || value.charAt(i) != '\r')) {
				log.debug("********** Invalid Xml Characters" + i + ":" + value.charAt(i) + ":"
						+ Integer.valueOf(value.charAt(i)) + " **********");
				value = value.replace(value.charAt(i), replace);
				i = -0;
			}
		}
		return value;
	}
}
