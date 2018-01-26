package com.ifudata.dvp.pay.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ifudata.dvp.pay.constants.CacheNSMapper;
import com.ifudata.dvp.pay.dao.mapper.bo.PayTenantInfo;
import com.ifudata.dvp.pay.dao.mapper.bo.PayTenantInfoCriteria;
import com.ifudata.dvp.pay.dao.mapper.factory.MapperFactory;
import com.ifudata.dvp.pay.util.CacheFactoryUtil;
import com.ifudata.dvp.sdk.util.CollectionUtil;
import com.ifudata.dvp.sdk.util.RedisUtil;

/**
 * 支付中心管理的租户信息缓存实现类
 * 
 * Date: 2015年11月5日 <br>
 */
@Component
public class PayTenantInfoCache   {

    public void write() throws Exception {
        List<PayTenantInfo> tenantInfos = MapperFactory.getPayTenantInfoMapper().selectByExample(
                new PayTenantInfoCriteria());
        if (CollectionUtil.isEmpty(tenantInfos)) {
            return;
        }

//        ICacheClient cacheClient = CacheFactoryUtil
//                .getCacheClient(CacheNSMapper.CACHE_PAY_TENANT_INFO);
        for (PayTenantInfo tenantInfo : tenantInfos) {
            String keyOne = tenantInfo.getTenantId();
            String keyTwo = tenantInfo.getPartnerId();
            String tenantInfoJson = JSON.toJSONString(tenantInfo);
//            cacheClient.hset(CacheNSMapper.CACHE_PAY_TENANT_INFO, keyOne, tenantInfoJson);
//            cacheClient.hset(CacheNSMapper.CACHE_PAY_TENANT_INFO, keyTwo, tenantInfoJson);
              RedisUtil.hset(keyOne, CacheNSMapper.CACHE_PAY_TENANT_INFO, tenantInfoJson);
              RedisUtil.hset(keyTwo, CacheNSMapper.CACHE_PAY_TENANT_INFO, tenantInfoJson);
              
        }
    }

}
