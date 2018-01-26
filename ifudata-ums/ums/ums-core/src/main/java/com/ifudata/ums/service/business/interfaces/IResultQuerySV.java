package com.ifudata.ums.service.business.interfaces;


import com.ifudata.ums.api.testdamon.param.TestDamonRequest;
import com.ifudata.ums.dao.mapper.bo.SmsResult;

public interface IResultQuerySV {
	SmsResult querySmsResult(TestDamonRequest req);
}
