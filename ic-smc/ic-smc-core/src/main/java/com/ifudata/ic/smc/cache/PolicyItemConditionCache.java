package com.ifudata.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.sdk.cache.base.AbstractCache;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.smc.constants.SmcCacheConstant;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItemCondition;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItemConditionCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemConditionCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemConditionCriteria stlPolicyItemConditionCriteria = new StlPolicyItemConditionCriteria();
        List<StlPolicyItemCondition> list = MapperFactory.getStlPolicyItemConditionMapper()
                .selectByExample(stlPolicyItemConditionCriteria);
        RedisUtil.hset(SmcCacheConstant.NameSpace.POLICY_CACHE,
                SmcCacheConstant.POLICY_ITEM_CONDITION, JSON.toJSONString(list));

    }

}
