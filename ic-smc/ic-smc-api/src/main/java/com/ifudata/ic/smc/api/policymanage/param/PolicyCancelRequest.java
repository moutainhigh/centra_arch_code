package com.ifudata.ic.smc.api.policymanage.param;

import java.util.List;

import com.ifudata.dvp.base.vo.BaseInfo;


public class PolicyCancelRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    private List<Long> policyIds;

    public List<Long> getPolicyIds() {
        return policyIds;
    }

    public void setPolicyIds(List<Long> policyIds) {
        this.policyIds = policyIds;
    }
}
