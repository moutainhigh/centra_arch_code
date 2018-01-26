package com.ifudata.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.sdk.cache.base.AbstractCache;
import com.ifudata.dvp.sdk.util.CollectionUtil;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.smc.constants.SmcCacheConstant;
import com.ifudata.ic.smc.constants.SmcConstants;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicy;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlPolicyCriteria criteria = new StlPolicyCriteria();
        criteria.createCriteria().andStateEqualTo(SmcConstants.StlPolicy.State.NORMAL);
        List<StlPolicy> stlPolicies = MapperFactory.getStlPolicyMapper().selectByExample(criteria);
        if (CollectionUtil.isEmpty(stlPolicies)) {
            return;
        }
        for (StlPolicy stlPolicy : stlPolicies) {
            // key:tenantId.policyCode,value:stlPolicy
            StringBuilder keyOne = new StringBuilder();
            keyOne.append(stlPolicy.getTenantId());
            keyOne.append(".");
            keyOne.append(stlPolicy.getPolicyCode());
            RedisUtil.hset(SmcCacheConstant.NameSpace.POLICY_CACHE, keyOne.toString(),
                    JSON.toJSONString(stlPolicy));
        }
        RedisUtil.hset(SmcCacheConstant.NameSpace.POLICY_CACHE, SmcCacheConstant.POLICY_ALL,
                JSON.toJSONString(stlPolicies));
    }

}
