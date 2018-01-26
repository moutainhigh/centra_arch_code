package com.ifudata.ums.service.http.sikong.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;
import com.ifudata.ums.constant.Constant;

public class SikongReceiver extends SMReceiver {

	public SikongReceiver(SMAbstractClient smClient) {
		super(smClient);
	}

	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		int resultCode = 1;
		if (recMap.get(Constant.RESULT_CODE) != null && "0".equals(recMap.get(Constant.RESULT_CODE))) {
			resultCode = 0;
		}
		return resultCode == 0 ? true : false;
	}
}
