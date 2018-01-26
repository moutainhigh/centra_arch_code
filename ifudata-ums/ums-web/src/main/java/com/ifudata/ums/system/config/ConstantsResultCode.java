package com.ifudata.ums.system.config;

/**
 * 调dubbo服务的返回码 Title: ums-CRM <br>
 * Description: <br>
 * Date: 2014年3月5日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author liangmeng
 */
public class ConstantsResultCode {
	public static final String SUCCESS = "000000";
	public static final String NODATA = "000001";//成功，但是无数据
	public static final String NULL = "888888";//参数有null
	public static final String ERROR = "999999";//后场服务系统错误
	public static final String POS_ERROR = "108010";//pos机交易失败
	public static final String CUST_HAVED = "101003";//后场服务系统错误
	public static final String CUST_NOTFOUND = "101000";//客户不存在
	public static final String USER_OWNFEE = "108006";//用户欠费
	
	public static final String SERVERPHONE_NOTFOUND = "102003";
	public static final String CUST_INFO_NOTFOUND = "101001";
	public static final String ACCT_INFO_NOTFOUND = "101010";
	
	public static final String GROUP_NOT_EXISTS = "103045";//群组不存在
	
	public static final String USER_NOT_EXISTS = "102002";//用户不存在
	
	public static final String NOT_GROUP_MEMBER = "103048";//不是群组成员
	
	public static final String MAIN_NUMBER_CANNOT_EXIT = "103049";//主号码不能退出群组
	
	public static final String ALREADY_BE_MEMBER = "103050";//已是群组成员
	public static final String FZR_NO_HAVED = "107001";//发展人不存在
	
	public static final String NOMATRIX="102010";//不符合变更矩阵
	
	public static final String USERINFO_NULL="102026";//妥投用户资料为空
}
