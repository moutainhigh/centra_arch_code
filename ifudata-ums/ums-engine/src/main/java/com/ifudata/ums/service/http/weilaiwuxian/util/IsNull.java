package com.ifudata.ums.service.http.weilaiwuxian.util;
/**
 * 判断对象是不是为空，对象中的某一个属性是否为空，
 * 2015年6月23日下午5:00:07
 * hongzhenfu
 *
 */
public class IsNull {
	/**
	 * 判断对象是否为空
	 * 没有对异常进行处理，慎用
	* @date 2015年6月23日 下午5:07:27 
	* @author hongzhenfu
	* @param @param o
	* @param @return
	* @return boolean
	* @throws
	 */
	public static boolean ObjectIsNull(Object o){
		if(o!=null)
			return false;
		return true;
	}
	/**
	 * 判断属性是否为空
	 * 没有对异常进行处理，慎用
	* @date 2015年6月23日 下午5:07:41 
	* @author hongzhenfu
	* @param @param o
	* @param @return
	* @return boolean
	* @throws
	 */
	public static boolean FieldIsNull(Object o){
		if(o!=null)
			if(o.toString().length()>0)
				return false;
		return true;
	}
}

