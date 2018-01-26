package com.ifudata.ums.service.http.byd.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.constant.Constant;

public class BYDSender  extends SMSender {
	public BYDSender(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isSendSuccess(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null && ("100".equals((String)status.get(Constant.RESULT_CODE))) ? true : false;
	}

	@Override
	protected String getSequenceNum(Map<String, Object> status) {
		return (String)status.get("msgId");
	}
	
	@Override
	protected Integer getSendStatus(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null && ("100".equals((String)status.get(Constant.RESULT_CODE))) ? Constant.SEND_FLAG_SUCCESS : Constant.SEND_FLAG_FAIL;
	}
}
