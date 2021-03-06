package com.ifudata.ic.pay.util;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import com.ifudata.ic.pay.constants.CacheNSMapper;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantInfo;

/**
 * 从缓存中获取合作方信息
 *
 * Date: 2015年11月5日 <br>
 */
public final class TenantInfoUtil {

	private TenantInfoUtil() {

	}

	/**
	 * 获取合作方编码
	 * 
	 * @param tenantId
	 * @return
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public static String getPartnerId(String tenantId) {
		// return tenantId;
//		 ICacheClient cacheClient = CacheFactoryUtil
//		 .getCacheClient(CacheNSMapper.CACHE_PAY_TENANT_INFO);
		
		ICacheClient cacheClient = MCSClientFactory.getDefaultCacheClient();
		 String data = cacheClient.hget(CacheNSMapper.CACHE_PAY_TENANT_INFO,
		 tenantId);
//		String hget = RedisUtil.hget(tenantId, CacheNSMapper.CACHE_PAY_TENANT_INFO);
		 PayTenantInfo tenantInfo = JSON.parseObject(data,
		 PayTenantInfo.class);
//		PayTenantInfo parseObject = JSON.parseObject(hget, PayTenantInfo.class);
		if (tenantInfo == null) {
			return null;
		}

		return tenantInfo.getPartnerId();
	}

	/**
	 * 通过合作方编码查询对应的租户ID
	 * 
	 * @param partnerId
	 * @return
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public static String getTenantId(String partnerId) {
//		 ICacheClient cacheClient = CacheFactoryUtil
//		 .getCacheClient(CacheNSMapper.CACHE_PAY_TENANT_INFO);
		 
		 ICacheClient cacheClient = MCSClientFactory.getDefaultCacheClient();
		 
		 String data = cacheClient.hget(CacheNSMapper.CACHE_PAY_TENANT_INFO,
		 partnerId);
//		String hget = RedisUtil.hget(partnerId, CacheNSMapper.CACHE_PAY_TENANT_INFO);
		 PayTenantInfo tenantInfo = JSON.parseObject(data,
		 PayTenantInfo.class);
//		PayTenantInfo parseObject = JSON.parseObject(hget, PayTenantInfo.class);
		if (tenantInfo == null) {
			return null;
		}

		return tenantInfo.getTenantId();
	}
}
