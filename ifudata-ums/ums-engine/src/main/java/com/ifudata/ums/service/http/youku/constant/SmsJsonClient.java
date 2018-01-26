package com.ifudata.ums.service.http.youku.constant;

import com.ifudata.ums.util.PropertitesFiller;
import java.util.Properties;
import java.lang.Integer;

public class SmsJsonClient {
	public static String url="http://www.";
	public static int BatchCount =100;
	public static int Fault = -1;
	public static int Sucess = 0;
	
	static
	{
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/youku/ucool.properties");
		url = props.getProperty("client.url");

		String sBatchCount  = props.getProperty("BatchCount");
		if(sBatchCount != null && !"".equals(sBatchCount))
		{
			BatchCount = Integer.valueOf(sBatchCount);
		}
	}

}
