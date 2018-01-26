package com.ifudata.ic.pay.util;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import com.ifudata.ic.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.ic.pay.constants.CacheNSMapper;

/**
 * 从缓存中获取终端与支付机构关系对象
 *
 * Date: 2015年11月5日 <br>
 */
public final class TerminalOrgRelUtil {

	private TerminalOrgRelUtil() {

	}

	public static List<TerminalOrgRelVo> getTerminalOrgRels(String tenantId, String requestSource) {
//		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL);
		ICacheClient cacheClient = MCSClientFactory.getDefaultCacheClient();
		String key = tenantId + "." + requestSource;
		String data = cacheClient.hget(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL, key);
//		 String hget = RedisUtil.hget(key,
//		 CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL);
		return JSONArray.parseArray(data, TerminalOrgRelVo.class);
	}
}
