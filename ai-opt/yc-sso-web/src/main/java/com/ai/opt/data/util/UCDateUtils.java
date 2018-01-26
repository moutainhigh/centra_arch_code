package com.ai.opt.data.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.opt.sdk.util.DateUtil;

public class UCDateUtils {

	private  static final Logger logger = LoggerFactory.getLogger(UCDateUtils.class);
	public static long getSystime(){

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeStart;
		try {
			timeStart = sdf.parse(DateUtil.getCurrentTime()).getTime();
			return timeStart/1000;
		} catch (ParseException e) {

		}
		return 0;
	
	}
	//1478549191-1478549224
	public static void main(String[] args) {
		System.out.println(getSystime());
		
		long c = 1478549191-1478549224;
		System.out.println(c);
	}
	
	/**
	 * 获取当前日期yyyy-MM-dd
	 * @return
	 * @author Gavin
	 * @throws ParseException 
	 * @UCUSER
	 */
	public static long getSystimeDate() {

		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		long timeStart;
		try {
			timeStart = sdf.parse(DateUtil.getCurrentTime()).getTime();
			return timeStart/1000;
		} catch (ParseException e) {

		}
		return 0;
		
	}
	
	/**
	 * 获取当前日期yyyy-MM-dd
	 * @return
	 * @author Gavin
	 * @throws ParseException 
	 * @UCUSER
	 */
	public static Date getDates() throws ParseException {
		
		Date newTime = new Date(); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        Date today = null;
		try {
			String todayStr = format.format(newTime);  
			today = format.parse(todayStr);
			return today; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return today; 
	}
	
	/**
	 * 返回时间的Timestamp实例
	 * @param date
	 * @return
     */
	public static Timestamp toTimeStamp(Date date){
		return date==null?null:new Timestamp(date.getTime());
	}

	public static Timestamp getTimestamp(String str,String pattern) {
		Timestamp result = null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return new Timestamp(formatter.parse(str).getTime());
		} catch (ParseException e) {
			logger.error("" ,e);
		}
		return result;
	}
	
	
}
