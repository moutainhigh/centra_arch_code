package com.ifudata.ums.api.testdamon;


import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.ums.api.testdamon.interfaces.ITestDamonDubboSV;
import com.ifudata.ums.api.testdamon.param.TestDamonRequest;
import com.ifudata.ums.api.testdamon.param.TestDamonResponse;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.service.business.interfaces.IResultQuerySV;

import javax.annotation.Resource;

@Service
public class TestDamonDubboSVImpl implements ITestDamonDubboSV {

	@Resource
	private IResultQuerySV iResultQuerySV;

	@Override
	public TestDamonResponse testQuery(TestDamonRequest req) {

		TestDamonResponse response =new TestDamonResponse();
		if(req.getA()==null){
			response.setCode("900000");
			return response;
		}
		SmsResult querySmsResult = iResultQuerySV.querySmsResult(req);
		if(querySmsResult==null){
			response.setCode("900000");
			return response;
		}else{
			response.setCode("100000");
			return response;
		}
	}

}
