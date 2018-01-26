package com.ifudata.ums.service.http.youku.client;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.service.http.youku.PackIn;


public class YKSender extends SMSender {
	private static final Log log = LogFactory.getLog(YKSender.class);	
	public YKSender(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isSendSuccess(Map<String, Object> status) {

		PackIn item = null;
		if (status.size() == 0)
		{
			log.debug("isSendSuccess:status 没有值呀"); 
		}
		for (String key : status.keySet()) {
			item = (PackIn)status.get(key);
			log.debug("isSendSuccess:"+item.getMsgData().toString()); 
			
			if (item != null)
			{
				log.debug("isSendSuccess getReturnCode:"+item.getReturnCode()); 
				if (item.getReturnCode().equals("0")){
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	protected String getSequenceNum(Map<String, Object> status) {

		PackIn item = null;
		for (String key : status.keySet()) {
			item = (PackIn)status.get(key);
			if (item != null)
			{
				log.debug("getSequenceNum:"+item.getMsgData().toString()); 
				log.debug("getReturnCode:"+item.getReturnCode());
				log.debug("getTransId:"+item.getTransId());
				log.debug("getTransTime:"+item.getTransTime());
				log.debug("getReturnCode:"+item.getReturnCode());
				
				if (item.getReturnCode().equals("0")){
					log.debug("OK"+item.getReturnCode());
					return item.getTransId();
				}
				else
				{
					log.debug("NO"+item.getReturnCode());
				}
			}
		}
		
		return null;
	}
	
	@Override
	protected Integer getSendStatus(Map<String, Object> status) {
		return Constant.SEND_FLAG_SUCCESS;
	}	
}
