package com.ifudata.ums.service.http.youku.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.service.http.youku.PackIn;
import com.ifudata.ums.service.http.youku.PackOut;
import com.ifudata.ums.service.http.youku.constant.SmsJsonClient;
import com.ifudata.ums.service.http.youku.util.jsonutil;

/**
 * @ClassName: ucoolclient
 * @Description: 实现短信发送客户端的连接，发送和接受
 * @author：lvsj
 * @date 2015年5月31日 下午11:49:24
 */

public class YKClient extends SMAbstractClient {
	private static final Logger logger = Logger.getLogger(YKClient.class);
	private static HttpURLConnection myconnection = null;

	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {
		try {
			logger.debug("********url********"+ SmsJsonClient.url);
			myconnection = jsonutil.UrlisConnect(SmsJsonClient.url);
			if (myconnection == null) {
				logger.error("********连接失败，结束发送********"+ SmsJsonClient.url);
				return null;
			}
			Map<String, Object> ret = new HashMap<String, Object>();
			PackOut msg = new PackOut(userNumber, content);

			DataOutputStream out = new DataOutputStream(
					myconnection.getOutputStream());

			JSONObject obj = msg.getMsgData();

			out.writeBytes(obj.toString());
			out.flush();
			out.close();
			logger.debug("**发送信息"+ obj.toString());
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					myconnection.getInputStream()));

			String lines;
			StringBuffer sb = new StringBuffer("");

			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			logger.debug("**接受信息"+sb.toString());
			if ((sb.length() >= 0)&&!"".equals(sb.toString())){
				PackIn msgin = new PackIn(sb.toString());
			    logger.debug("**接受信息msgin"+msgin.getMsgData().toString());
			    tempResultMap.put(msgin.getTransId(), msgin.getReturnCode());
				ret.put(msgin.getTransId(), msgin) ;
			}
			return ret;
		} catch (Exception e) {
			logger.error("Error", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> readMessage() {

		Map<String, Object> recMap = new HashMap<String, Object>();
		if(YKClient.tempResultMap != null && YKClient.tempResultMap.size() > 0){
			for(Entry<String, Object> entry : YKClient.tempResultMap.entrySet()){
				recMap.put(Constant.SEQUENCE_NUM, entry.getKey());
				recMap.put(Constant.RESULT_CODE, entry.getValue());
				recMap.put(Constant.RESULT_CONTENT, entry.getValue().equals("0") ? "回执:接收成功" : "回执:接收失败");
				YKClient.tempResultMap.remove(entry.getKey());
				break;
			}
		}
		return recMap;
	}
}
