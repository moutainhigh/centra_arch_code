package com.ifudata.ic.smc.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.sdk.cache.base.AbstractCache;
import com.ifudata.dvp.sdk.util.CollectionUtil;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.smc.constants.SmcCacheConstant;
import com.ifudata.ic.smc.constants.SmcConstants;
import com.ifudata.ic.smc.dao.mapper.bo.StlElement;
import com.ifudata.ic.smc.dao.mapper.bo.StlElementCriteria;
import com.ifudata.ic.smc.dao.mapper.factory.MapperFactory;

import com.alibaba.fastjson.JSON;

@Component
public class ObjectToElementCache extends AbstractCache {

    @Override
    public void write() throws Exception {

        StlElementCriteria stlElementCriteria = new StlElementCriteria();
        StlElementCriteria.Criteria criteria = stlElementCriteria.createCriteria();
        criteria.andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        List<StlElement> stlElements = MapperFactory.getElementMapper().selectByExample(
                stlElementCriteria);
        if (CollectionUtil.isEmpty(stlElements)) {
            return;
        }
        List<StlElement> UniqueStlElements = UniqueData(stlElements);

        for (StlElement stlElement : UniqueStlElements) {

            StlElementCriteria stlElementCriteriaNew = new StlElementCriteria();
            StlElementCriteria.Criteria criteriaNew = stlElementCriteriaNew.createCriteria();

            criteriaNew.andTenantIdEqualTo(stlElement.getTenantId());
            criteriaNew.andObjectIdEqualTo(stlElement.getObjectId());
            List<StlElement> stlElementResults = MapperFactory.getElementMapper().selectByExample(
                    stlElementCriteriaNew);
            // key:tenantId.elementId,value:StlElement
            StringBuilder key = new StringBuilder();
            key.append(stlElement.getTenantId()).append(".").append(stlElement.getObjectId());
            RedisUtil.hset(SmcCacheConstant.NameSpace.OBJECT_ELEMENT_CACHE, key.toString(),
                    JSON.toJSONString(stlElementResults));
        }
    }

    private List<StlElement> UniqueData(List<StlElement> stlElements) {
        List<StlElement> results = new ArrayList<StlElement>();
        Map<String, Integer> unique = new HashMap<String, Integer>();
        for (StlElement stlElement : stlElements) {
            if (unique.containsKey(stlElement.getObjectId() + stlElement.getTenantId())) {
                continue;
            } else {
                unique.put(stlElement.getObjectId() + stlElement.getTenantId(), 1);
                results.add(stlElement);
            }
        }
        return results;
    }

}
