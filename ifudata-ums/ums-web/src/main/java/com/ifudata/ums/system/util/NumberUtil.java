package com.ifudata.ums.system.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

import com.alibaba.dubbo.common.utils.StringUtils;
/**
 * 
 * Title: ums-CRM <br>
 * Description:数字工具类 <br>
 * Date: 2014年3月25日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author liangmeng
 */
public class NumberUtil {
    /**
     * 格式化数字为XXXX.XX
     * @param d
     * @return
     * @author liangmeng
     */
    public static String roundNum(Double d) {
        if (d == null) {
            return "0.00";
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        String str = nf.format(d);
        if (str.indexOf(".") == -1) {
            str = str + ".00";
        } else {
            System.out.println(str.substring(str.indexOf(".") + 1));
            int nn = str.substring(str.indexOf(".") + 1).length();
            if (nn == 1) {
                str = str + "0";
            }
            if (nn > 2) {
                Double m = Double.valueOf(str.substring(str.indexOf(".") + 1));
                str = str.substring(0, str.indexOf(".") + 1) + Math.round(m / 10);
            }
        }
        if (str.equals("-0.00"))
            str = "0.00";
        return str;
    }
    
    /**
	 * 输出Long类型
	 * - 参数为空或转换错误返回
	 * @param num
	 * @return
	 */
	public static Long parseLong(Double num){
		if(null==num){
			return null;
		}
		try{
			BigDecimal bnum = new BigDecimal(num);
			return bnum.longValue();	
		}catch(NumberFormatException e){
			return null;
		}					
	}
	
	/**
	 * 输出Long类型
	 * - 参数为空或转换错误返回
	 * @param num
	 * @return
	 */
	 public static Long parseLong(String num){
	    	if(StringUtils.isBlank(num)){
	    		return null;
	    	}else{
	    		try{
	    			BigDecimal bnum = new BigDecimal(num);
	    			return bnum.longValue();	
	    		}catch(NumberFormatException e){
	    			return null;
	    		}
	    	}
	    }
	 
	 /**
	     * 转换成Double
	     * - 参数为空或转换错误返回
	     */
	    public static Double parseDouble(String num){
	    	if(StringUtils.isBlank(num)){
	    		return null;
	    	}else{
	    		try{
	    			BigDecimal bnum = new BigDecimal(num);
	    			return bnum.doubleValue();	
	    		}catch(NumberFormatException e){
	    			return null;
	    		}
	    	}
	    }
	    
	    /**
	     * 转换成Double
	     * - 参数为空或转换错误返回
	     */
	    public static Double parseDouble(long num){
	    		try{
	    			BigDecimal bnum = new BigDecimal(num);
	    			return bnum.doubleValue();	
	    		}catch(NumberFormatException e){
	    			return null;
	    		}
	    }
	    /**
	     * 转换成Double
	     * - 参数为空或转换错误返回
	     */
	    public static Integer parseInt(String num){
	    	if(StringUtils.isBlank(num)){
	    		return null;
	    	}else{
	    		try{
	    			BigDecimal bnum = new BigDecimal(num);
	    			return bnum.intValue();	
	    		}catch(NumberFormatException e){
	    			return null;
	    		}
	    	}
	    }
	    /**
	     * 百分比值 已经使用 使用率
	     */
	    public static String usedNumber(long all,long used){
	    	if (all==0) {
				return "0";
			}else {
				return ""+Math.round(1.0*used/all*100);
			}
	    }
	    /**
	     * 百分比值 已经使用 使用率
	     */
	    public static String usedNumber_spe(long all,long used){
	    	if (all==0) {
				return "0";
			}else {
				long ret=Math.round(1.0*used/all*100);
				if (ret>=100) {
					return "100";
				}else {
					return ret+"";
				}
			}
	    }
	    public static void main(String[] args) {
	    	for (int i = 0; i < 800; i++) {
	    		System.out.println(usedNumber(300, i));
			}
	    	for (int i = 0; i < 800; i++) {
	    		System.out.println(usedNumber_spe(300, i));
			}
		}
}
