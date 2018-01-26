package com.ifudata.ums.service.http.baiwunew.client;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;

public class BWNewReceiver extends SMReceiver {
	private static final Log log = LogFactory.getLog(BWNewReceiver.class);
	public BWNewReceiver(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		int resultCode = 1;
		if (recMap.get(Constant.RESULT_CODE) != null) {
			//&& recMap.get(Constant.RESULT_CODE).equals("0")) {
			//int ires = -1;
			try {
				resultCode = Integer.parseInt((String)recMap.get(Constant.RESULT_CODE));
			} catch (NumberFormatException e) {
				log.error("parseInt error:" + recMap.get(Constant.RESULT_CODE));
				resultCode = 1;
			}			
		}
		return resultCode == 0 ? true : false;
	}
}