package com.ifudata.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.sdk.cache.base.AbstractCache;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.smc.constants.SmcCacheConstant;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItemPlan;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItemPlanCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemPlanCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemPlanCriteria stlPolicyItemPlanCriteria = new StlPolicyItemPlanCriteria();
        List<StlPolicyItemPlan> list = MapperFactory.getStlPolicyItemPlanMapper().selectByExample(
                stlPolicyItemPlanCriteria);
        RedisUtil.hset(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM_PLAN, JSON.toJSONString(list));

    }

}
