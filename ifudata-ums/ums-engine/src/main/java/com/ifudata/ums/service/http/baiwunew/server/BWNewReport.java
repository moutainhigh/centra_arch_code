package com.ifudata.ums.service.http.baiwunew.server;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.service.http.baiwu.util.StringUtils;
import com.ifudata.ums.service.http.baiwunew.client.BWNewClient;

public class BWNewReport implements Runnable {
	private static final Log log = LogFactory.getLog(BWNewReport.class);

	@Override
	public void run() {
		Thread.currentThread().setName("BWNewReport");
		while(true){
			try {
				Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
			} catch (InterruptedException e) {
				log.error("InterruptedException Error:", e);
			}		
			
			Iterator<String> iterator = BWNewServer.reportArray.iterator();
			while (iterator.hasNext()) {
		    	synchronized (Object.class) {
					String key = iterator.next();
					log.debug("**BWNewServer.reportArray key:" + key + "**");
	
					BWNewServer.reportArray.remove(key);
					
					InputStream is = new ByteArrayInputStream(key.getBytes());
					// 根据返回的xml内容判断是否要进行解析
					String result = BWNewClient.fromStream2String(is, "UTF-8");
					log.debug("********** 此次状态报告返回结果为：" + result + System.getProperty("line.separator") + " **********");
					if(!BWNewClient.isXML(result)){
						continue;
					}
					result = StringUtils.CheckUnicodeStringAndReplcace(result,' ');
					Map<String, Object> map = BWNewClient.parseString4ReportResult(result);
					
					BWNewClient.tempResultMap.putAll(map);
									
				}
			}
		}
	}
}
