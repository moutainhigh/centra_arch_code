package com.ifudata.ums.service.atom.impl;


import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.centra.sdk.util.StringUtil;
import com.ifudata.ums.constants.ExceptCodeConstants;
import com.ifudata.ums.dao.interfaces.OrdApplyBatchMapper;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchCriteria;
import com.ifudata.ums.exceptions.FileException;
import com.ifudata.ums.service.atom.interfaces.IOrdAppayBatchSV;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrdAppayBatchSVImpl implements IOrdAppayBatchSV {

	@Resource
	private OrdApplyBatchMapper applyBatchMapper;

	@Override
	public void save(OrdApplyBatch bean) throws Exception {

		OrdApplyBatchCriteria criteria = new OrdApplyBatchCriteria();
		criteria.createCriteria().andFileNameEqualTo(bean.getFileName());
		List<OrdApplyBatch> ordApplyBatches = applyBatchMapper.selectByExample(criteria);
		if(!CollectionUtil.isEmpty(ordApplyBatches)){
			throw new FileException("100009","文件名已存在，请重新命名");
		}
		applyBatchMapper.insertSelective(bean);
	}

	@Override
	public  OrdApplyBatch query(String fileName) throws Exception {

		if(StringUtil.isBlank(fileName)){
			OrdApplyBatchCriteria criteria = new OrdApplyBatchCriteria();
			criteria.createCriteria().andFileNameEqualTo(fileName);
			List<OrdApplyBatch> ordApplyBatches = applyBatchMapper.selectByExample(criteria);
			if(CollectionUtil.isEmpty(ordApplyBatches)){
				return ordApplyBatches.get(0);
			}else {
				throw new FileException("100008","文件名不存在，请确定文件名格式是否正确");
			}
		}else {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"文件名为空");
		}
	}

}
