package com.ai.slp.user.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserTenant;
import com.ai.slp.user.service.atom.interfaces.IUcUSerTenantAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcUserAtomSV;
import com.ai.slp.user.service.business.interfaces.ITenantBusiSV;

@Service
@Transactional
public class TenantBusiSVImpl implements ITenantBusiSV {

	@Autowired
	IUcUSerTenantAtomSV itenantAtomSV;
	@Autowired
	IUcUserAtomSV iAccountAtomSV;

	@Override
	public UcUserTenant queryByTenantId(String tenantId) throws SystemException {
		return itenantAtomSV.queryByTenantId(tenantId);
	}

	@Override
	public boolean insertTenantAndSyncAccount(UcUserTenant gnTenant, UcUser gnAccount) throws SystemException {
		int insertCount = itenantAtomSV.insert(gnTenant);
		boolean result = false;
		if (insertCount > 0) {
			int updateCount = iAccountAtomSV.updateByAccountId(gnAccount,null);
			if (updateCount > 0) {
				result = true;
			}
		}
		return result;
	}

}
