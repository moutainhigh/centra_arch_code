package com.ifudata.ums.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

	public static Timestamp toTimeStamp(Date date){
		Timestamp result = null;
		if(date != null){
			result = new Timestamp(date.getTime());
		}
		return result;
	}
	
	public static String format(Date date, String pattern){
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String result = formatter.format(date);
		return result;
	}
	
	public static String getCurrMonth(){

		return format(new Date(),"yyyyMM");
	}
}
