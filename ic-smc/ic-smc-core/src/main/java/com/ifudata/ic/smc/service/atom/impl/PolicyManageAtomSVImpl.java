package com.ifudata.ic.smc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;
import com.ifudata.ic.smc.service.atom.interfaces.IPolicyManageAtomSV;

@Component
public class PolicyManageAtomSVImpl implements IPolicyManageAtomSV {

    @Override
    public boolean isExistPolicyCode(String tenantId, String policyCode) {
        StlPolicyCriteria criteria = new StlPolicyCriteria();
        criteria.createCriteria().andTenantIdEqualTo(tenantId).andPolicyCodeEqualTo(policyCode);
        int count = MapperFactory.getStlPolicyMapper().countByExample(criteria);
        return count > 0;
    }

}
