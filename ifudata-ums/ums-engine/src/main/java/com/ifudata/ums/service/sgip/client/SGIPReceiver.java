package com.ifudata.ums.service.sgip.client;

import java.util.Map;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.service.sgip.constant.SGIPConstant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;

public class SGIPReceiver extends SMReceiver {

	public SGIPReceiver(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		return recMap.get(Constant.RESULT_CODE) != null && (
				Integer.parseInt((String)recMap.get(Constant.RESULT_CODE)) == 0 
				|| Integer.parseInt((String)recMap.get(Constant.RESULT_CODE)) == (int)((SGIPConstant.SGIP_BIND_RESP - SGIPConstant.SGIP_BIND)/ 0x10000l)) ? true : false;
	}
}
