package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.dao.mapper.bo.UcUserTenant;
import com.ai.slp.user.dao.mapper.bo.UcUserTenantCriteria;

public interface IUcUSerTenantAtomSV {
	
	int insert(UcUserTenant gnTenant) throws SystemException;
	
	UcUserTenant queryByTenantId(String tenantId) throws SystemException;
	
	List<UcUserTenant> queryTenantList(UcUserTenantCriteria criteria) throws SystemException;

	int queryTenantCount(UcUserTenantCriteria criteria) throws SystemException;
	
    int updateTenantById(UcUserTenant gnTenant) throws SystemException;
}
