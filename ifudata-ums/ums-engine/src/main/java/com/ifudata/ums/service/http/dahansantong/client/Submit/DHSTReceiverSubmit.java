package com.ifudata.ums.service.http.dahansantong.client.Submit;

import java.util.Map;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;
import com.ifudata.ums.constant.Constant;

/**
 *
 * 2015年10月9日下午3:57:19
 * hongzhenfu
 *
 */
public class DHSTReceiverSubmit extends SMReceiver{

	public DHSTReceiverSubmit(SMAbstractClient smClient) {
		super(smClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isRecSuccess(Map<String, Object> recMap) {
		// TODO Auto-generated method stub
		if(recMap.get(Constant.RESULT_CODE).toString().equals("0")){
			return true;
		}
		return false;
	}

}

