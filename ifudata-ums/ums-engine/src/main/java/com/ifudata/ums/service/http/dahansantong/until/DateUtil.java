package com.ifudata.ums.service.http.dahansantong.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 2015年6月18日上午10:55:52
 * hongzhenfu
 *
 */
public class DateUtil {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getDateString(null, null));
//		System.out.println(getDateString("yyyy-MM-dd", null));
//		System.out.println();
		System.out.println(getDateString("yyyy-MM-dd HH:mm:ss",getDate("MM", 1)));
	}
	/**
	 * 传入输出类型，和日期
	* @date 2015年6月18日 上午11:12:55 
	* @author hongzhenfu
	* @param @param pattern
	* @param @param date
	* @param @return
	* @return String
	* @throws
	 */
	public static String getDateString(String pattern,Date date){
		if(pattern==null||pattern.length()<1)
			pattern = "YYYYMM";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(date==null)
			date = new Date();
		return sdf.format(date);
	}
	/**
	 * 根据参数来判断对日期的处理
	 * yy	MM	dd	HH	mm	ss	
	* @date 2015年6月18日 下午9:18:28 
	* @author hongzhenfu
	* @param @return
	* @return Date
	* @throws
	 */
	public static Date getDate(String pattern,Integer i){
		if(pattern==null||pattern.length()<1)
			pattern = "MM";
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal.setTime(new Date());
		switch (pattern) {
		case "yy":
			cal.add(Calendar.YEAR, i);
			break;
		case "MM":
			cal.add(Calendar.MONTH, i);
			break;
		case "dd":
			cal.add(Calendar.DATE, i);
			break;
		case "HH":
			cal.add(Calendar.HOUR_OF_DAY, i);
			break;
		case "mm":
			cal.add(Calendar.MINUTE, i);
			break;
		case "ss":
			cal.add(Calendar.SECOND, i);
			break;

		default:
			cal.add(Calendar.DATE, i);
			break;
		}
cal1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return cal.getTime();
	}
}

