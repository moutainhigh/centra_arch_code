package com.ifudata.ic.uni.session;


import com.ifudata.ic.uni.session.impl.CacheHttpSession;

public interface SessionListener {
    void onAttributeChanged(CacheHttpSession paramRedisHttpSession);

    void onInvalidated(CacheHttpSession paramRedisHttpSession);
}
