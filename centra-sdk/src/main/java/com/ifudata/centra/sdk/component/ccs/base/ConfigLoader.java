package com.ifudata.centra.sdk.component.ccs.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ifudata.centra.sdk.model.ConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.constant.CcsConstant;
import com.ifudata.centra.sdk.exception.SdkException;
import com.ifudata.centra.sdk.util.StringUtil;

/**
 * 存放配置中心的连接配置，主机、应用、版本等
 * 
 * @author mayt
 *
 */
public final class ConfigLoader {
    private static final String CONF_PATH = "disconf.properties";

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigLoader.class);

    private static Properties properties;

    private static ConfigModel configModel = new ConfigModel();

    static {
        loadProp();
    }
    private static void loadProp() {
        String conf = System.getProperty("disconf.conf");
        InputStream is;
        try {
            if (!StringUtil.isBlank(conf)) {
                is = new FileInputStream(conf);
                LOGGER.info("通过配置加载 " + conf);
            } else {
                is = ConfigLoader.class.getClassLoader().getResourceAsStream(CONF_PATH);

            }
            LOGGER.info("加载的属性文件流:" + JSON.toJSONString(is));

            properties = new Properties();
            properties.load(is);
            LOGGER.info("加载的属性文件prop:" + JSON.toJSONString(properties));
            configModel = new ConfigModel();
            configModel.setApp(properties.getProperty(CcsConstant.APP));
            configModel.setConfServerHost(properties.getProperty(CcsConstant.CONF_SERVER_HOST));
            configModel.setConfServerUrlRetrySleepSeconds(properties.getProperty(CcsConstant.CONF_SERVER_URL_RETRY_SLEEP_SECONDS));
            configModel.setConfServerUrlRetryTimes(properties.getProperty(CcsConstant.CONF_SERVER_URL_RETRY_TIMES));
            configModel.setDebug(Boolean.parseBoolean(properties.getProperty(CcsConstant.DEBUG)));
            configModel.setEnableRemoteConf(Boolean.parseBoolean(properties.getProperty(CcsConstant.ENABLE_REMOTE_CONF)));
            configModel.setEnv(properties.getProperty(CcsConstant.ENV));
            configModel.setIgnore(properties.getProperty(CcsConstant.IGNORE));
            configModel.setVersion(properties.getProperty(CcsConstant.VERSION));
        } catch (IOException e) {
            throw new SdkException("loding context file failed", e);
        }
    }

    public static void main(String[] args) {
        String a = ConfigLoader.getConfServerHost();
        System.out.println(a);
    }

    private ConfigLoader() {
        // 禁止实例化
    }

    public static void loadConf(Properties p) {
        LOGGER.debug("[loadConf   开始。。。]");
        if (properties == null) {
            // 多线程并发获取实例时候，避免等线程锁造成性能低下，因此在创建实例时候进行同步处理
            LOGGER.debug("[prop为空]");
            synchronized (ConfigLoader.class) {
                if (properties == null) {
                    loadProp(p);
                }
            }
        }
        LOGGER.debug("[loadConf   结束。。。]:" + JSON.toJSONString(properties));
    }

    private static void loadProp(Properties p) {
        properties = p;
    }

    private static void init() {
        if (null == properties) {
            // 多线程并发获取实例时候，避免等线程锁造成性能低下，因此在创建实例时候进行同步处理
            LOGGER.debug("[prop为空]");
            synchronized (ConfigLoader.class) {
                if (properties == null) {
                    loadProp();
                }
            }
        }
        LOGGER.debug("[loadConf   结束。。。]:" + JSON.toJSONString(properties));
    }

    public static String getConfServerHost() {
        if (null == properties) {
            init();
        }
        return configModel.getConfServerHost();
    }

    public static String getApp() {
        if (null == properties) {
            init();
        }
        return configModel.getApp();
    }

    public static String getVersion() {
        if (null == properties) {
            init();
        }
        return configModel.getVersion();
    }

    public static String getEnv() {
        if (null == properties) {
            init();
        }
        return configModel.getEnv();
    }

    public static ConfigModel getConfigModel() {
        return configModel;
    }
}
