package com.ifudata.ums.service.diy09.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;
import com.ifudata.ums.constant.Constant;

public class Diy09Receiver extends SMReceiver {

	public Diy09Receiver(SMAbstractClient smClient) {
		super(smClient);
	}

	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		int resultCode = 1;
		if (recMap.get(Constant.RESULT_CODE) != null) {
			resultCode = Integer.parseInt((String) recMap.get(Constant.RESULT_CODE));
		}
		return resultCode == 0 ? true : false;
	}
}
