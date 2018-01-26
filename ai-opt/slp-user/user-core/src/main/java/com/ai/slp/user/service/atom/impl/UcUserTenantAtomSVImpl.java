package com.ai.slp.user.service.atom.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.user.dao.mapper.bo.UcUserTenant;
import com.ai.slp.user.dao.mapper.bo.UcUserTenantCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcUSerTenantAtomSV;

@Component
public class UcUserTenantAtomSVImpl implements IUcUSerTenantAtomSV {

	@Override
	public int insert(UcUserTenant gnTenant) throws SystemException {
		/*GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		Timestamp createTime = gnTenant.getCreateTime();
		if(createTime == null){
			gnTenant.setCreateTime(DateUtil.getSysDate());
		}*/
		//return tenantMapper.insertSelective(gnTenant);
	    return 0;
	}

	@Override
	public UcUserTenant queryByTenantId(String tenantId) throws SystemException {
		//GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		//return tenantMapper.selectByPrimaryKey(tenantId);
	    return null;
	}

	@Override
	public List<UcUserTenant> queryTenantList(UcUserTenantCriteria criteria) throws SystemException {
		// GnTenantCriteria sql = new GnTenantCriteria();
		// GnTenantCriteria.Criteria criteria = sql.createCriteria();
		// if (!StringUtil.isBlank(gnTenant.getTenantId())) {
		// criteria.andTenantIdEqualTo(gnTenant.getTenantId());
		// }
		// if (!StringUtil.isBlank(gnTenant.getTenantName())) {
		// criteria.andTenantNameLike("%"+gnTenant.getTenantName()+"%");
		// }
		// if (!StringUtil.isBlank(gnTenant.getState())) {
		// criteria.andStateEqualTo(gnTenant.getState());
		// }
		// sql.setLimitStart(start);
		// sql.setLimitEnd(end);
       /* GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
        return tenantMapper.selectByExample(criteria);*/
	    return null;
	}

	@Override
	public int updateTenantById(UcUserTenant gnTenant) throws SystemException {
		/*GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		Timestamp updateTime = gnTenant.getUpdateTime();
		if(updateTime == null){
			gnTenant.setUpdateTime(DateUtil.getSysDate());
		}
        return tenantMapper.updateByPrimaryKeySelective(gnTenant);*/
	    return 0;
	}

	@Override
	public int queryTenantCount(UcUserTenantCriteria criteria) throws SystemException {
		//GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		// GnTenantCriteria example = new GnTenantCriteria();
		// GnTenantCriteria.Criteria criteria = example.createCriteria();
		// if (!StringUtil.isBlank(gnTenant.getTenantId())) {
		// criteria.andTenantIdEqualTo(gnTenant.getTenantId());
		// }
		// if (!StringUtil.isBlank(gnTenant.getTenantName())) {
		// criteria.andTenantNameLike("%"+gnTenant.getTenantName()+"%");
		// }
		// if (!StringUtil.isBlank(gnTenant.getState())) {
		// criteria.andStateEqualTo(gnTenant.getState());
		// }
		//return tenantMapper.countByExample(criteria);
	    return 0;
	}

}
