package com.ifudata.ic.smc.cache;

import java.util.List;

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
public class ElementCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        StlElementCriteria stlElementCriteria = new StlElementCriteria();
        stlElementCriteria.createCriteria().andStateEqualTo(SmcConstants.StlElement.State.NORMAL);
        List<StlElement> stlElements = MapperFactory.getElementMapper().selectByExample(
                stlElementCriteria);
        if (CollectionUtil.isEmpty(stlElements)) {
            return;
        }
        for (StlElement stlElement : stlElements) {
            // key:tenantId.elementId,value:StlElement
            StringBuilder key = new StringBuilder();
            key.append(stlElement.getTenantId()).append(".").append(stlElement.getElementId());
            RedisUtil.hset(SmcCacheConstant.NameSpace.ELEMENT_CACHE, key.toString(),
                    JSON.toJSONString(stlElement));
        }
    }

}
