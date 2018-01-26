package com.ifudata.ums.service.http.weilaiwuxian.client;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;

/**
 *
 * 2015年7月30日上午9:34:26
 * hongzhenfu
 *
 */
public class WLWXReceiver extends SMReceiver{

	public WLWXReceiver(SMAbstractClient smClient) {
		super(smClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		// TODO Auto-generated method stub
		return false;
	}

}

