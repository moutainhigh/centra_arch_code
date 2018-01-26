/**
 * COPYRIGHT (C) 2010 LY. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of 3KW.
 *
 * Created By: zzqiang
 * Created On: 2013-10-17
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.ifudata.ums.service.sgip.constant;

import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.service.sgip.interf.MessageHandler;
import com.ifudata.ums.util.PropertitesFiller;


public class ClientConstant {
	private static final Log log = LogFactory.getLog(SMSender.class);
	public static String COMPANY_CODE = "00000";
	
	public static String AREA_CODE = "0731";
	
	public static String LOGIN_NAME = "";
	
	public static String LOGIN_PWD = "";
	
	public static String SP_NUMBER = "";
	
	public static String SERVER_IP = "222.33.35.50";
	
	public static String SERVER_PORT = "8080";
	
	public static int SGIP_SUBMIT_MAX_USER_NUMBER = 50;
	
	public static int RESPONSE_TIMEOUT = 5;
	
	public static int LOCALHOST_SGIP_PORT = 8801;
	
	private static String SGIP_MESSAGE_HANDLE_CLASS = "com.core.sgip.interf.DefaultMessageHandler";
	
	public static String DEFAULT_SERVICE_TYPE = "defaultype";
	
	public static MessageHandler SGIP_MSG_HANDLER = null;
	
	public static String PERMIT_IP = "110.52.11.6";
	
	public static String IS_NIO = "y";

	public static String USER_PHONE = "";

	public static String SEND_CONTENT = "您好！";

	public static final String SOCKET_INPUT_STREAM = "SOCKET_INPUT_STREAM";
	
	public static final String SOCKET_OUTPUT_STREAM = "SOCKET_OUTPUT_STREAM";
	
	static
	{
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/sgip/sgip.properties");
		if (props!=null){
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys)
			{
				if(key.startsWith("sgip.error"))
				{
					SGIPConstant.ERROR_CODE.put(key.substring("sgip.error".length()+1), props.getProperty(key));
				}
			}
			SP_NUMBER = props.getProperty("client.SPNumber");
			LOGIN_NAME = props.getProperty("client.login.name");
			LOGIN_PWD = props.getProperty("client.login.pwd");
			AREA_CODE = props.getProperty("client.login.areaCode");
			COMPANY_CODE = props.getProperty("client.login.companyCode");
			SERVER_IP = props.getProperty("sgip.server.ip");
			SERVER_PORT = props.getProperty("sgip.server.port");
			USER_PHONE = props.getProperty("user.phone");
			SEND_CONTENT = props.getProperty("send.content");
			String max = props.getProperty("sgip.submit.usernumber.max");
			if(max != null && !"".equals(max))
			{
				SGIP_SUBMIT_MAX_USER_NUMBER = Integer.valueOf(max);
			}
			String timeout = props.getProperty("sgip.receive.response.timeout");
			if(timeout != null && !"".equals(timeout))
			{
				RESPONSE_TIMEOUT = Integer.valueOf(timeout);
			}
			String port = props.getProperty("localhost.sgip.service.port");
			if(port != null && !"".equals(port))
			{
				LOCALHOST_SGIP_PORT = Integer.valueOf(port);
			}
			String serviceType = props.getProperty("sgip.submit.service.type");
			DEFAULT_SERVICE_TYPE = serviceType;
			
			String validIp = props.getProperty("sgip.service.permit.ip");
			PERMIT_IP = validIp;
			
			String isNio = props.getProperty("sgip.client.nio");
			if(isNio != null && !"".equals(isNio))
			{
				IS_NIO = isNio;
			}
			
			String messageHandlerClass = props.getProperty("sgip.message.handle.class");
			if(messageHandlerClass != null && !"".equals(messageHandlerClass))
			{
				SGIP_MESSAGE_HANDLE_CLASS = messageHandlerClass;
			}
			initInstanceOfHandler(SGIP_MESSAGE_HANDLE_CLASS);
		}else{
			log.error("文件【sgip.properties】不存在");
		}
	}
	
	private static void initInstanceOfHandler(String messageHandlerClass)
	{
		try
		{
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(messageHandlerClass);
			SGIP_MSG_HANDLER = (MessageHandler)clazz.newInstance();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
