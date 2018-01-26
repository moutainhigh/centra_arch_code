package com.ifudata.ums.service.http.dahansantong.client.deliver;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.constant.Constant;

/**
 *
 * 2015年10月9日下午4:00:24
 * hongzhenfu
 *
 */
public class DHSTSenderDeliver extends SMSender{

	public DHSTSenderDeliver(SMAbstractClient smClient) {
		super(smClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isSendSuccess(Map<String, Object> status) {
		// TODO Auto-generated method stub
		if (null != status.get(Constant.RESULT_CODE)) {
			if (("0").equals((String) status.get(Constant.RESULT_CODE))) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected String getSequenceNum(Map<String, Object> status) {
		// TODO Auto-generated method stub
		return (String)status.get("msgId");
	}

	@Override
	protected Integer getSendStatus(Map<String, Object> status) {
		return status.get(Constant.RESULT_CODE) != null && ("0".equals((String)status.get(Constant.RESULT_CODE))) ? Constant.SEND_FLAG_SUCCESS : Constant.SEND_FLAG_FAIL;
	}	
}

