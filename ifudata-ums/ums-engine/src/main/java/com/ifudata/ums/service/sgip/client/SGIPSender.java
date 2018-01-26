package com.ifudata.ums.service.sgip.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.constant.Constant;

public class SGIPSender extends SMSender {

	public SGIPSender(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isSendSuccess(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null /* && status.get(Constant.RESULT_CODE) != Constant.SEND_FLAG_SUCCESSANDWAITRESP */ ? true : false;
	}

	@Override
	protected String getSequenceNum(Map<String, Object> status) {
		return (String)status.get(Constant.SEQUENCE_NUM);
	}

	@Override
	protected Integer getSendStatus(Map<String, Object> status) {
		if (status.get(Constant.RESULT_CODE) != null) {
			return (Integer)status.get(Constant.RESULT_CODE);
		} else
			return Constant.SEND_FLAG_FAIL;
	}
}
