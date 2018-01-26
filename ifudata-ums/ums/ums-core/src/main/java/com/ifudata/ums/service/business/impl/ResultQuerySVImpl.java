package com.ifudata.ums.service.business.impl;


import com.ifudata.ums.api.testdamon.param.TestDamonRequest;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.service.atom.interfaces.ISmsResultSV;
import com.ifudata.ums.service.business.interfaces.IResultQuerySV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultQuerySVImpl implements IResultQuerySV {

	@Autowired
	private ISmsResultSV iSmsResultSV;

	@Override
	public SmsResult querySmsResult(TestDamonRequest req) {
		return iSmsResultSV.queryByResflag(req.getA());
	}

}
