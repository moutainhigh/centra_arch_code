package com.ifudata.ums.service.atom.impl;

import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ums.dao.interfaces.SmsResultMapper;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import com.ifudata.ums.service.atom.interfaces.ISmsResultSV;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SmsResultSVImpl implements ISmsResultSV {

	@Resource
	private SmsResultMapper smsResultMapper;

	@Override
	public SmsResult queryByResflag(Integer id){
		SmsResultCriteria criteria = new SmsResultCriteria();
		criteria.createCriteria().andRecFlagEqualTo(id);
		List<SmsResult> smsResults = smsResultMapper.selectByExample(criteria);
		if(!CollectionUtil.isEmpty(smsResults)){
			return smsResults.get(0);
		}
		return null;
	}

}
