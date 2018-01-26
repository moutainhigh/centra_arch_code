package com.ifudata.centra.sdk.component.ses;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.component.ccs.base.ConfigLoader;
import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;
import com.ifudata.centra.sdk.constant.CcsConstant;
import com.ifudata.centra.sdk.exception.SdkException;
import com.ifudata.centra.sdk.model.ConfigModel;
import com.ifudata.centra.sdk.component.ses.impl.SearchClientImpl;
import com.ifudata.centra.sdk.component.ses.interfaces.ISearchClient;
import com.ifudata.centra.sdk.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SESClientFactory {

    private static transient final Logger LOG = LoggerFactory.getLogger(SESClientFactory.class);

    private static Map<String, ISearchClient> searchClients = new ConcurrentHashMap<String, ISearchClient>();
    private final static String ELASTIC_HOST = "hosts";
    private final static String ELASTIC_ID = "id";

    private SESClientFactory() {}

    public static ISearchClient getDefaultSearchClient() {
        return getSearchClient(CcsConstant.SES_FILE);
    }

    public static ISearchClient getSearchClient(String fileName) {
        if (StringUtil.isBlank(fileName)) {
            throw new SdkException("请输入搜索服务配置映射的文件常量");
        }
        Map<String, Object> sesConfig = ConfigTool.getConfigFile(fileName);
        LOG.debug("sesConfig="+ JSON.toJSONString(sesConfig));
        String hosts = (String) sesConfig.getOrDefault(ELASTIC_HOST,"127.0.0.1:9300");
        String id = (String) sesConfig.getOrDefault(ELASTIC_ID,"");
        final ConfigModel configModel = ConfigLoader.getConfigModel();
        final String appKey = configModel.getApp()+"_"+configModel.getEnv()+"_"+configModel.getVersion();
        ISearchClient client;
        try {
            if (!searchClients.containsKey(appKey)) {
                final String indexName = String.valueOf(Math.abs(appKey.hashCode()));
                client = new SearchClientImpl(hosts, indexName, id);
                searchClients.put(appKey, client);
            } else {
                client = searchClients.get(appKey);
            }
        } catch (Exception e) {
            throw new SdkException("无法获取SES服务[" + appKey + "]对应的客户端实例", e);
        }
        return client;
    }
}
