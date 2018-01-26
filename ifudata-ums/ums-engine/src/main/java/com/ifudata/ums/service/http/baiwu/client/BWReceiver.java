package com.ifudata.ums.service.http.baiwu.client;

import java.util.Map;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;

public class BWReceiver extends SMReceiver {

	public BWReceiver(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		int resultCode = 1;
		if(recMap.get(Constant.RESULT_CODE) != null){
			resultCode = Integer.parseInt((String)recMap.get(Constant.RESULT_CODE));
		}
		return resultCode == 0 ? true : false;
	}
}
