package com.ifudata.ums.service.http.dahansantong.client.deliver;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;

/**
 *
 * 2015年10月9日下午3:57:19
 * hongzhenfu
 *
 */
public class DHSTReceiverDeliver extends SMReceiver{

	public DHSTReceiverDeliver(SMAbstractClient smClient) {
		super(smClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		// TODO Auto-generated method stub
		return false;
	}

}

