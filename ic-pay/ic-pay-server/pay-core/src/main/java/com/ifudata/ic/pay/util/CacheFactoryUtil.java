package com.ifudata.ic.pay.util;

import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;

/**
 * 从工厂中获取缓存客户端
 *
 * Date: 2015年11月5日 <br>
 */
public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(String namespace) {
        return MCSClientFactory.getCacheClient(
                namespace);
    }

}
