package com.ifudata.ums.service.atom.impl;

import com.ifudata.ums.dao.interfaces.OrdApplyBatchDetailMapper;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetailWithBLOBs;
import com.ifudata.ums.service.atom.interfaces.IOrdAppayBatchDetailSV;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrdAppayBatchDetailSVImpl implements IOrdAppayBatchDetailSV {

	@Resource
	private OrdApplyBatchDetailMapper applyBatchDetailMapper;

	@Override
	public void sava(OrdApplyBatchDetailWithBLOBs bean) throws Exception {
		applyBatchDetailMapper.insertSelective(bean);
	}

	@Override
	public void sava(List<OrdApplyBatchDetailWithBLOBs> beans) throws Exception {
		for(OrdApplyBatchDetailWithBLOBs bean:beans){
			applyBatchDetailMapper.insertSelective(bean);
		}
	}

}
