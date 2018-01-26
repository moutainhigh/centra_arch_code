package com.ifudata.centra.sdk.config.hdfs;

import com.alibaba.fastjson.JSON;
import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.ifudata.centra.sdk.config.dubbo.DubboConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@DisconfUpdateService(classes = {HdfsConfig.class})
@DisconfFile(filename = "hdfs.properties")
public class HdfsConfig implements IDisconfUpdate{

    private static final Logger LOGGER = LoggerFactory.getLogger(IDisconfUpdate.class);

    private String defaultFS;

    @DisconfFileItem(name = "default.fs", associateField = "defaultFS")
    public String getDefaultFS() {
        return defaultFS;
    }

    public void setDefaultFS(String defaultFS) {
        this.defaultFS = defaultFS;
    }

    @Override
    public void reload() throws Exception {
        LOGGER.info("更新hdfs.properties:"+ JSON.toJSONString(this));
    }
}
