package com.ifudata.ic.pay.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.cache.base.AbstractCache;
import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.pay.constants.CacheNSMapper;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantInfo;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantInfoCriteria;
import com.ifudata.ic.pay.dao.mapper.factory.MapperFactory;

/**
 * 支付中心管理的租户信息缓存实现类
 * 
 * Date: 2015年11月5日 <br>
 */
@Component
public class PayTenantInfoCache extends AbstractCache{

    public void write() throws Exception {
        List<PayTenantInfo> tenantInfos = MapperFactory.getPayTenantInfoMapper().selectByExample(
                new PayTenantInfoCriteria());
        if (CollectionUtil.isEmpty(tenantInfos)) {
            return;
        }

//        ICacheClient cacheClient = CacheFactoryUtil
//                .getCacheClient(CacheNSMapper.CACHE_PAY_TENANT_INFO);
        ICacheClient cacheClient = MCSClientFactory.getDefaultCacheClient();
        
        
        for (PayTenantInfo tenantInfo : tenantInfos) {
            String keyOne = tenantInfo.getTenantId();
            String keyTwo = tenantInfo.getPartnerId();
            String tenantInfoJson = JSON.toJSONString(tenantInfo);
            cacheClient.hset(CacheNSMapper.CACHE_PAY_TENANT_INFO, keyOne, tenantInfoJson);
            cacheClient.hset(CacheNSMapper.CACHE_PAY_TENANT_INFO, keyTwo, tenantInfoJson);
//              RedisUtil.hset(keyOne, CacheNSMapper.CACHE_PAY_TENANT_INFO, tenantInfoJson);
//              RedisUtil.hset(keyTwo, CacheNSMapper.CACHE_PAY_TENANT_INFO, tenantInfoJson);
              
        }
    }

}
