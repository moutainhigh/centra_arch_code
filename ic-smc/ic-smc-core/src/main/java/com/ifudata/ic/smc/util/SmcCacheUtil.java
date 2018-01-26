package com.ifudata.ic.smc.util;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.ifudata.dvp.base.exception.SystemException;
import com.ifudata.dvp.sdk.cache.base.AbstractCache;


public final class SmcCacheUtil {
    private SmcCacheUtil(){}
    
    public static void refreshMcs(ApplicationContext context) {
        Map<String, AbstractCache> caches = context.getBeansOfType(AbstractCache.class);
        for (AbstractCache cache : caches.values()) {
            try {
                cache.write();
            } catch (Exception e) {
                // LOGGER.error("写入mcs缓存失败", e);
                throw new SystemException(e);
            }

        }
    }
}
