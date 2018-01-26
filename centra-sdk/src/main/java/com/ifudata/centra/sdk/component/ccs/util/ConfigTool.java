package com.ifudata.centra.sdk.component.ccs.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ifudata.centra.sdk.component.ccs.base.ConfigLoader;
import com.ifudata.centra.sdk.config.hdfs.HdfsConfig;
import com.ifudata.centra.sdk.config.jdbc.JdbcConfig;
import com.ifudata.centra.sdk.config.sso.SsoConfig;
import com.ifudata.centra.sdk.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.ifudata.centra.sdk.config.ConfigFactory;
import com.ifudata.centra.sdk.config.dubbo.DubboConfig;
import com.ifudata.centra.sdk.constant.CcsConstant;
import com.ifudata.centra.sdk.constant.JdbcConstant;
import com.zaxxer.hikari.HikariConfig;

public final class ConfigTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigTool.class);

    private ConfigTool() {
    }

    public static HikariConfig getDBConf(String dataSourceName) {
        JdbcConfig jdbcConfig = (JdbcConfig) ConfigFactory.getConfig(JdbcConfig.class);
        HikariConfig dbconf = new HikariConfig();
        dbconf.setDriverClassName(jdbcConfig.getDriverClassName());
        dbconf.setJdbcUrl(jdbcConfig.getJdbcUrl());
        dbconf.setUsername(jdbcConfig.getUsername());
        dbconf.setPassword(jdbcConfig.getPassword());
        dbconf.setAutoCommit(jdbcConfig.isAutoCommit());
        dbconf.setConnectionTimeout(jdbcConfig.getConnectionTimeout());
        dbconf.setIdleTimeout(jdbcConfig.getIdleTimeout());
        dbconf.setMaxLifetime(jdbcConfig.getMaxLifetime());
        dbconf.setMaximumPoolSize(jdbcConfig.getMaximumPoolSize());
        return dbconf;
    }

    public static HikariConfig getDBConfByRest(String dataSourceName) {
        Map<String, Object> map = null;
        if ("1".equalsIgnoreCase(dataSourceName) || StringUtils.isEmpty(dataSourceName)) {
            map = getConfigFile(CcsConstant.JDBC_FILE);
        } else {
            map = getConfigFile("jdbc-" + dataSourceName + ".properties");
        }

        HikariConfig dbconf = new HikariConfig();
        dbconf.setDriverClassName((String) map.get(JdbcConstant.JDBC_DRIVERCLASSNAME));
        dbconf.setJdbcUrl((String) map.get(JdbcConstant.JDBC_JDBCURL));
        dbconf.setUsername((String) map.get(JdbcConstant.JDBC_USERNAME));
        dbconf.setPassword((String) map.get(JdbcConstant.JDBC_PASSWORD));
        dbconf.setAutoCommit(Boolean.parseBoolean((String) map.get(JdbcConstant.JDBC_AUTOCOMMIT)));
        dbconf.setConnectionTimeout(Long.parseLong((String) map
                .get(JdbcConstant.JDBC_CONNECTIONTIMEOUT)));
        dbconf.setIdleTimeout(Long.parseLong((String) map.get(JdbcConstant.JDBC_IDLETIMEOUT)));
        dbconf.setMaxLifetime(Long.parseLong((String) map.get(JdbcConstant.JDBC_MAXLIFETIME)));
        dbconf.setMaximumPoolSize(Integer.parseInt((String) map
                .get(JdbcConstant.JDBC_MAXIMUMPOOLSIZE)));
        dbconf.setConnectionTestQuery((String) map.get(JdbcConstant.JDBC_CONNECTIONTESTQUERY));
        return dbconf;
    }

    public static JSONObject getDubboConfig() {
        DubboConfig dubboConfig = (DubboConfig) ConfigFactory.getConfig(DubboConfig.class);
        return (JSONObject) JSON.toJSON(dubboConfig);
    }

    public static JSONObject getDubboConfigByRest() {
        Map<String, Object> map = getConfigFile(CcsConstant.DUBBO_FILE);
        return (JSONObject) JSON.toJSON(map);
    }

    public static JSONObject getFrameJobJdbcByRest() {
        Map<String, Object> map = getConfigFile(CcsConstant.FRAME_JOB_JDBC_FILE);
        return (JSONObject) JSON.toJSON(map);
    }

    /*
     * public static SsoConfig getSsoConfig(){ SsoConfig ssoConfig = (SsoConfig)
     * ConfigFactory.getConfig(SsoConfig.class); return ssoConfig; }
     */
    public static SsoConfig getSsoConfigByRest() {
        Map<String, Object> map = getConfigFile(CcsConstant.SSO_FILE);
        // SsoConfig ssoConfig = (SsoConfig) ConfigFactory.getConfig(SsoConfig.class);
        SsoConfig ssoConfig = new SsoConfig();
        ssoConfig.setCasServerLoginUrl((String) map.get("cas.server.login.url"));
        ssoConfig.setCasServerUrlPrefix((String) map.get("cas.server.url.prefix"));
        ssoConfig.setServerName((String) map.get("server.name"));
        return ssoConfig;
    }

    public static HdfsConfig getHdfsConfigByRest() {
        Map<String, Object> map = getConfigFile(CcsConstant.HDFS_FILE);
        HdfsConfig config = new HdfsConfig();
        config.setDefaultFS((String) map.get("fs.defaultFS"));
        return config;
    }

    public static void main(String[] args) {
        System.out.println("====== is" + new Gson().toJson(getSsoConfigByRest()));
        LOGGER.error(getConfigItem("test_key"));
        LOGGER.error(getConfigFile("test.properties").toString());
    }

    /**
     * 获取配置中心配置项
     * 
     * @param path
     * @return
     * @author mayt
     */
    public static String getConfigItem(String path) {
        // ConfigModel configModel = ConfigFactory.getConfigModel();
        // String url = configModel.getConfServerHost() + CcsConstant.CONFIG_URL_ITEM;
        String url = ConfigLoader.getConfServerHost() + CcsConstant.CONFIG_URL_ITEM;
        return getConfig(url, path);
    }
    
    /**
     * 获取配置项
     * @param fileName
     * @param key
     * @return
     */
    public static String getConfigValueByKey(String fileName,String key) {
    	Map<String, Object> map = getConfigFile(fileName);
    	
    	if(map!=null && !map.isEmpty()){
    		return (String)map.get(key);
    	}else{
    		return null;
    	}
    }

    public static Map<String, Object> getConfigFile(String fileName) {
        // ConfigModel configModel = ConfigFactory.getConfigModel();
        // String url = configModel.getConfServerHost() + CcsConstant.CONFIG_URL_FILE;
        InputStream inputStream = null;
        if(ConfigLoader.getConfigModel().isEnableRemoteConf()){
            String url = ConfigLoader.getConfServerHost() + CcsConstant.CONFIG_URL_FILE;
            String result = getConfig(url, fileName);
            inputStream = new ByteArrayInputStream(result.getBytes());
        }else{
            inputStream = ConfigTool.class.getClassLoader().getResourceAsStream(fileName);
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("read context center file error", e);
        }
        @SuppressWarnings({ "unchecked", "rawtypes" })
        Map<String, Object> map = new HashMap<String, Object>((Map) properties);
        return map;
    }

    private static String getConfig(String url, String path) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(CcsConstant.APP, ConfigLoader.getApp());
        parameters.put(CcsConstant.VERSION, ConfigLoader.getVersion());
        parameters.put(CcsConstant.ENV, ConfigLoader.getEnv());
        parameters.put(CcsConstant.CONFIG_KEY, path);
        String result = HttpUtil.doGet(url, parameters);
        LOGGER.info("获取到配置:{}", result);
        return result;
    }

}
