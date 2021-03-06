package com.ifudata.ic.smc.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.sdk.cache.base.AbstractCache;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.smc.constants.SmcCacheConstant;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItem;
import com.ifudata.ic.smc.dao.mapper.bo.StlPolicyItemCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;
import com.alibaba.fastjson.JSON;

@Component
public class PolicyItemCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        // TODO Auto-generated method stub
        StlPolicyItemCriteria stlPolicyItemCriteria = new StlPolicyItemCriteria();
        List<StlPolicyItem> list = MapperFactory.getStlPolicyItemMapper().selectByExample(
                stlPolicyItemCriteria);
        RedisUtil.hset(SmcCacheConstant.NameSpace.POLICY_CACHE, SmcCacheConstant.POLICY_ITEM,
                JSON.toJSONString(list));

    }

}
