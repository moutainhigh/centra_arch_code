package com.ifudata.ums.service.http.baiwu.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.constant.Constant;

public class BWSender extends SMSender {

	public BWSender(SMAbstractClient smClient) {
		super(smClient);
	}
	
	@Override
	protected boolean isSendSuccess(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null && ((String)status.get(Constant.RESULT_CODE)).equals("0") ? true : false;
	}

	@Override
	protected String getSequenceNum(Map<String, Object> status) {
		return (String)status.get("msgId");
	}

	@Override
	protected Integer getSendStatus(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null && ("0".equals((String)status.get(Constant.RESULT_CODE))) ? Constant.SEND_FLAG_SUCCESS : Constant.SEND_FLAG_FAIL;
	}
}
