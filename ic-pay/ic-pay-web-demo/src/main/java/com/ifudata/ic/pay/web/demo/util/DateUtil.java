package com.ifudata.ic.pay.web.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期处理类
 * Date: 2015年11月30日 <br>
 */
public class DateUtil {
    /**
     * 获取格式化日期
     * @param date
     * @param formatStr
     * @return
     * @ApiDocMethod
     */
	public static String getFormatDate(Date date, String formatStr){
        if(formatStr==null || null==date){
            return "";
        }else{
            return new SimpleDateFormat(formatStr).format(date);
        }
    }
    
}
