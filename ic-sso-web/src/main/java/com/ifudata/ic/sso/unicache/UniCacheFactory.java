package com.ifudata.ic.sso.unicache;

import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import org.springframework.stereotype.Component;



@Component
public class UniCacheFactory {

    public static ICacheClient getCacheClient() {
    	return MCSClientFactory.getDefaultCacheClient();
    }
    
}
