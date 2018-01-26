package com.ifudata.dvp.pay.util;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.dvp.pay.constants.CacheNSMapper;
import com.ifudata.dvp.sdk.util.RedisUtil;

/**
 * 从缓存中获取终端与支付机构关系对象
 *
 * Date: 2015年11月5日 <br>
 */
public final class TerminalOrgRelUtil {

	private TerminalOrgRelUtil() {

	}

	public static List<TerminalOrgRelVo> getTerminalOrgRels(String tenantId, String requestSource) {
		// ICacheClient cacheClient = CacheFactoryUtil
		// .getCacheClient(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL);
		String key = tenantId + "." + requestSource;
		//String data = null;
		// String data =
		// cacheClient.hget(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL, key);
		String hget = RedisUtil.hget(key, CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL);
		return JSONArray.parseArray(hget, TerminalOrgRelVo.class);
	}
}
