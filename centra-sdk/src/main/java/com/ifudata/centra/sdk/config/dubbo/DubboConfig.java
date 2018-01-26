package com.ifudata.centra.sdk.config.dubbo;

import com.alibaba.fastjson.JSON;
import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@DisconfUpdateService(classes = {DubboConfig.class})
@DisconfFile(filename = "dubbo/dubbo.properties")
public class DubboConfig implements IDisconfUpdate{
    private static final Logger LOGGER = LoggerFactory.getLogger(DubboConfig.class);
    private String dubboAppname;

    private String dubboRegistryProtocol;

    private String dubboRegistryAddress;

    private String dubboRregistryFile;

    private String dubboProtocol;

    private String dubboProtocolPort;

    private String dubboProviderTimeout;

    private String dubboProtocolService;

    private String dubboProtocolContextpath;

    @DisconfFileItem(name = "dubbo.appname", associateField = "dubboAppname")
    public String getDubboAppname() {
        return dubboAppname;
    }

    public void setAppname(String appname) {
        this.dubboAppname = appname;
    }

    @DisconfFileItem(name = "dubbo.registry.protocol", associateField = "dubboRegistryProtocol")
    public String getDubboRegistryProtocol() {
        return dubboRegistryProtocol;
    }

    public void setRegistryProtocol(String registryProtocol) {
        this.dubboRegistryProtocol = registryProtocol;
    }

    @DisconfFileItem(name = "dubbo.registry.address", associateField = "dubboRegistryAddress")
    public String getDubboRegistryAddress() {
        return dubboRegistryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.dubboRegistryAddress = registryAddress;
    }

    @DisconfFileItem(name = "dubbo.registry.file", associateField = "dubboRregistryFile")
    public String getDubboRegistryFile() {
        return dubboRregistryFile;
    }

    public void setRegistryFile(String registryFile) {
        this.dubboRregistryFile = registryFile;
    }

    @DisconfFileItem(name = "dubbo.protocol", associateField = "dubboProtocol")
    public String getDubboProtocol() {
        return dubboProtocol;
    }

    public void setProtocol(String protocol) {
        this.dubboProtocol = protocol;
    }

    @DisconfFileItem(name = "dubbo.protocol.port", associateField = "dubboProtocolPort")
    public String getDubboProtocolPort() {
        return dubboProtocolPort;
    }

    public void setProtocolPort(String protocolPort) {
        this.dubboProtocolPort = protocolPort;
    }

    @DisconfFileItem(name = "dubbo.provider.timeout", associateField = "dubboProviderTimeout")
    public String getDubboProviderTimeout() {
        return dubboProviderTimeout;
    }

    public void setProviderTimeout(String providerTimeout) {
        this.dubboProviderTimeout = providerTimeout;
    }

    @DisconfFileItem(name = "dubbo.protocol.service", associateField = "dubboProtocolService")
    public String getDubboProtocolService() {
        return dubboProtocolService;
    }

    public void setProtocolService(String protocolService) {
        this.dubboProtocolService = protocolService;
    }

    @DisconfFileItem(name = "dubbo.protocol.contextpath", associateField = "dubboProtocolContextpath")
    public String getDubboProtocolContextpath() {
        return dubboProtocolContextpath;
    }

    public void setProtocolContextpath(String protocolContextpath) {
        this.dubboProtocolContextpath = protocolContextpath;
    }

    @Override
    public void reload() throws Exception {
        LOGGER.info("更新dubbo.properties:"+ JSON.toJSONString(this));
    }
}
