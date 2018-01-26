package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.dvp.base.exception.SystemException;
import com.ifudata.dvp.base.vo.PageInfo;
import com.ifudata.ic.smc.api.policymanage.param.PolicyCancelRequest;
import com.ifudata.ic.smc.api.policymanage.param.PolicyCreateRequest;
import com.ifudata.ic.smc.api.policymanage.param.PolicyDetailQueryRequest;
import com.ifudata.ic.smc.api.policymanage.param.PolicyDetailQueryResponse;
import com.ifudata.ic.smc.api.policymanage.param.PolicyListQueryInfo;
import com.ifudata.ic.smc.api.policymanage.param.PolicyListQueryRequest;
import com.ifudata.ic.smc.api.policymanage.param.PolicyModifyRequest;

public interface IPolicyManageBusiSV {

    void createPolicy(PolicyCreateRequest request) throws SystemException;

    void modifyPolicy(PolicyModifyRequest request);

    void cancelPolicy(PolicyCancelRequest request);

    PageInfo<PolicyListQueryInfo> queryPolicyList(PolicyListQueryRequest request);

    PolicyDetailQueryResponse queryPolicyDetail(PolicyDetailQueryRequest request);

}
