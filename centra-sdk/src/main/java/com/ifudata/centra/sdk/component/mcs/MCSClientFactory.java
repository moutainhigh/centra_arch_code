package com.ifudata.centra.sdk.component.mcs;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.component.ccs.base.ConfigLoader;
import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;
import com.ifudata.centra.sdk.constant.CcsConstant;
import com.ifudata.centra.sdk.exception.SdkException;
import com.ifudata.centra.sdk.component.mcs.constants.MCSConstants;
import com.ifudata.centra.sdk.component.mcs.impl.CacheClient;
import com.ifudata.centra.sdk.component.mcs.impl.CacheClusterClient;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import com.ifudata.centra.sdk.model.ConfigModel;
import com.ifudata.centra.sdk.util.StringUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MCSClientFactory {
	private static final Logger LOG = LoggerFactory.getLogger(MCSClientFactory.class);
	private static Map<String, ICacheClient> cacheClients = new ConcurrentHashMap<String, ICacheClient>();

    private MCSClientFactory() {}

	public static ICacheClient getDefaultCacheClient() {
		return getCacheClient(CcsConstant.MCS_FILE);
	}

    public static ICacheClient getCacheClient(String fileName) {
		if (StringUtil.isBlank(fileName)) {
			throw new SdkException("请输入服务配置文件标识appKey");
		}
		Map<String, Object> redisConfig = ConfigTool.getConfigFile(fileName);
		LOG.debug("redisConfig="+JSON.toJSONString(redisConfig));
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxTotal(Integer.parseInt(redisConfig.getOrDefault(MCSConstants.MCS_MAXTOTAL,"500").toString()));
		genericObjectPoolConfig.setMaxIdle(Integer.parseInt(redisConfig.getOrDefault(MCSConstants.MCS_MAXIDLE, "10").toString()));
		genericObjectPoolConfig.setMinIdle(Integer.parseInt(redisConfig.getOrDefault(MCSConstants.MCS_MINIDLE, "5").toString()));
		genericObjectPoolConfig.setTestOnBorrow(Boolean.parseBoolean(redisConfig.getOrDefault(MCSConstants.MCS_TESTONBORROW, "true").toString()));

		String hostStr = redisConfig.getOrDefault(MCSConstants.MCS_HOST,"127.0.0.1:6379").toString();
		String pwd = redisConfig.getOrDefault(MCSConstants.MCS_PASSWORD,"").toString();
		ICacheClient client;
		final ConfigModel configModel = ConfigLoader.getConfigModel();
		final String appKey = configModel.getApp()+"_"+configModel.getEnv()+"_"+configModel.getVersion();
		try {
			if (!cacheClients.containsKey(appKey)) {
				final String[] hosts = hostStr.split(";");
				synchronized (MCSClientFactory.class){
					if(hosts.length>1){
						client = new CacheClusterClient(genericObjectPoolConfig,hosts);
					}else {
						client = new CacheClient(genericObjectPoolConfig,hosts[0],pwd);
					}
				}
				cacheClients.put(appKey, client);
			}
			else{
				client=cacheClients.get(appKey);
			}
		} catch (Exception e) {
			throw new SdkException("无法获取缓存服务[" + appKey + "]对应的客户端实例", e);
		}
		return client;
    }

}
