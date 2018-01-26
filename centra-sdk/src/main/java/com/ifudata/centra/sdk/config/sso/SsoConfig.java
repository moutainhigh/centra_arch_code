package com.ifudata.centra.sdk.config.sso;

import com.alibaba.fastjson.JSON;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@Service
@Scope("singleton")
@DisconfUpdateService(classes = {SsoConfig.class})
@DisconfFile(filename = "sso.properties")
public class SsoConfig implements IDisconfUpdate{
    private static final Logger LOGGER = LoggerFactory.getLogger(IDisconfUpdate.class);

    private String casServerLoginUrl;
    private String serverName;
    private String casServerUrlPrefix;

    @DisconfFileItem(name = "casServerLoginUrl",associateField = "casServerLoginUrl")
    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    @DisconfFileItem(name = "serverName",associateField = "serverName")
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @DisconfFileItem(name = "casServerUrlPrefix",associateField = "casServerUrlPrefix")
    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    @Override
    public void reload() throws Exception {
        LOGGER.info("更新sso.properties:"+ JSON.toJSONString(this));
    }
}
