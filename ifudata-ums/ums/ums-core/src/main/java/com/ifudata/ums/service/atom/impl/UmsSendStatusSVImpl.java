package com.ifudata.ums.service.atom.impl;

import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.dao.interfaces.UmsSendStatusMapper;
import com.ifudata.ums.dao.mapper.bo.UmsSendStatus;
import com.ifudata.ums.dao.mapper.bo.UmsSendStatusCriteria;
import com.ifudata.ums.service.atom.interfaces.IUmsSendStatusSV;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UmsSendStatusSVImpl implements IUmsSendStatusSV {

	@Resource
	private UmsSendStatusMapper umsSendStatusMapper;

	@Override
	public List<UmsSendStatus> getBeans(OrdSendStatusRequest request, long batchId) throws Exception {
		UmsSendStatusCriteria criteria = new UmsSendStatusCriteria();
		criteria.createCriteria().andBatchIdEqualTo(String.valueOf(batchId));
		criteria.setLimitStart((request.getPageInfo().getPageNo()-1)*request.getPageInfo().getPageSize());
		criteria.setLimitEnd(request.getPageInfo().getPageSize());
		criteria.setOrderByClause("order by send_flag");
		return umsSendStatusMapper.selectByExample(criteria);
	}

	@Override
	public int getBeansCount(OrdSendStatusRequest request, long batchId) throws Exception {
		UmsSendStatusCriteria criteria = new UmsSendStatusCriteria();
		criteria.createCriteria().andBatchIdEqualTo(String.valueOf(batchId));
		return umsSendStatusMapper.countByExample(criteria);
	}

}
