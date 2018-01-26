package com.ai.opt.sso.util;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.yc.common.api.cache.param.AdvertCache;
import com.ai.yc.common.api.cachekey.key.CacheKey;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackieliu on 2017/6/20.
 */
public final class CacheUtils {
    /**
     * 获取广告信息
     * @param local
     * @param adPoint
     * @return
     */
    public static List<AdvertCache> getAdvert(String local, String adPoint){
        ICacheClient iCacheClient = MCSClientFactory.getCacheClient(Constants.DEFAULT_COMMON_CACHE_NAMESPACE);;
        String advertKey = local+"&1&"+adPoint;
        String adListStr = iCacheClient.hget(CacheKey.ADVERTMANAGER_D_KEY,advertKey);
        List<AdvertCache> adList = new ArrayList<>();
        if(StringUtils.isNotBlank(adListStr)){
            adList = JSON.parseArray(adListStr,AdvertCache.class);
        }
        return adList;
    }
}
