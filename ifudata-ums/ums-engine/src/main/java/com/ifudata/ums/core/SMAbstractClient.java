package com.ifudata.ums.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于约束各种协议的client的方法接口
 * 
 * @author guofei
 */
public abstract class SMAbstractClient {

	// 根据该标志判断是否第一次使用readMessage()方法
	protected static boolean isFirstRead = true;

	// 暂时存放读取到的短信回执的集合, 然后每次从该集合读取一条回执
	public static final Map<String, Object> tempResultMap = new HashMap<String, Object>();

	/**
	 * @param userNumber
	 *            用户手机号
	 * @param content
	 *            短信内容
	 * @return 包括了发送短信时返回的所有有用信息的map集合
	 */
	public abstract Map<String, Object> writeMessage(String userNumber, String content);

	/**
	 * @return Map,包含三个键值对:sequenceNum(序列号) , resultCode(回执码) ,
	 *         resultContent(回执内容)
	 */
	public abstract Map<String, Object> readMessage();
}
