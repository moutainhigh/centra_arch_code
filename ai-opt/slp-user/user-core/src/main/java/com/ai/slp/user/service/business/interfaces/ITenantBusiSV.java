package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserTenant;

public interface ITenantBusiSV {
	UcUserTenant queryByTenantId(String tenantId) throws SystemException;
	
	boolean insertTenantAndSyncAccount(UcUserTenant gnTenant,UcUser ucUser) throws SystemException;
}
