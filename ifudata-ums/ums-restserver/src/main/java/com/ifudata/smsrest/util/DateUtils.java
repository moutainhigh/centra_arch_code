package com.ifudata.smsrest.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
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
	
	private static Date getLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
	
	public static String getPrivMonth(){
		Date dt = getLastDate(new Date());
		return format(dt,"yyyyMM");
	}
	
}
