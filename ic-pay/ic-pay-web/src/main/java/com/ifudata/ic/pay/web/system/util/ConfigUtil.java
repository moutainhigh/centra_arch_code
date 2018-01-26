package com.ifudata.ic.pay.web.system.util;

import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;
import com.ifudata.centra.sdk.util.StringUtil;

/**
 * 支付中心配置工具类
 *
 * Date: 2015年11月2日 <br>
 */
public final class ConfigUtil {
    
    private ConfigUtil() {
        
    }

    private static final Logger LOG = LoggerFactory.getLogger(ConfigUtil.class);

    /**
     * 支付中心配置根路径
     */
    private static final String PAY_CONFIG_PATH = "/com/ifudata/ic/pay-center/config/";

    /**
     * 多租户公用配置目录名称
     */
    private static final String PUBLIC = "public";

    /**
     * 第三方支付机构公用配置目录名称
     */
    public static final String COMMON = "common";

    /**
     * 路径分隔符
     */
    private static final String SEPARATOR = "/";
    
    /**
     * 读取配置中心文件名
     */
    private static final String FILE_NAME = "ic_pay_infomation.properties";

    /**
     * 获取公用配置方法,次配置跟租户无关，跟支付机构无关
     * 
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return getProperty(PUBLIC, COMMON, key);
    }

    /**
     * 获取支付机构配置，此配置跟租户无关，例如获取机构的地址信息
     * 
     * @param payOrgCode
     * @param key
     * @return
     */
    public static String getPayOrgProperty(String payOrgCode, String key) {
        return getProperty(PUBLIC, payOrgCode, key);
    }

    /**
     * 取配置中心配置方法
     * 
     * @param tenantId
     *            租户ID
     * @param payOrgCode
     *            支付机构
     * @param key
     *            配置的键
     * @return
     */
    public static String getProperty(String tenantId, String payOrgCode, String key) {
        if (StringUtil.isBlank(tenantId)) {
            throw new SystemException("传入的租户ID为空");
        }

        if (StringUtil.isBlank(payOrgCode)) {
            throw new SystemException("传入的支付机构为空");
        }

        if (StringUtil.isBlank(key)) {
            throw new SystemException("传入的配置键值为空");
        }

        /* 1. 获取配置中心客户端服务 */
//        IConfigClient client = CCSClientFactory.getDefaultConfigClient();
//        if (client == null) {
//            throw new SystemException("获取配置中心客户端服务失败");
//        }
        //取配置中心配置文件
        Map<String, Object> configFile = ConfigTool.getConfigFile(FILE_NAME);
        if(configFile == null || configFile.isEmpty()){
        	throw new SystemException("获取配置中心客户端服务失败");
        }

        /* 2. 获取支付中心配置KEY树级路径 */
        String path = PAY_CONFIG_PATH + tenantId + SEPARATOR + payOrgCode;
        String confs = null;
        
        try {
			confs = configFile.get(path).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new SystemException("获取不到此路径[" + path + "下的配置信息");
		}
        
//		try {
//			confs = client.get(path);
//		} catch (ConfigException e) {
//			 throw new SystemException("获取不到此路径[" + path + "下的配置信息");
//		}
        if (StringUtil.isBlank(confs)) {
            throw new SystemException("获取不到此路径[" + path + "下的配置信息");
        }

        JSONObject json = new JSONObject(confs);
        String value = json.getString(key);
        //LOG.debug("获取配置" + key + ":" + value);
        return value;
    }
    /**
     * 获取租户级别基础配置信息,此配置跟支付机构无关
     * @param tenantId
     * @param key
     * @return
     * @ApiDocMethod
     */
    public static String getTenantCommonProperty(String tenantId, String key) {
        return getProperty(tenantId, COMMON, key);
    }

    /**
     * 添加/修改公用配置方法
     * @param config
     * @ApiDocMethod
     * @ApiCode
     */
    public static void addProperty(String config) {
        addProperty(COMMON, config);
    }

    /**
     * 添加/修改支付机构公用配置方法
     * @param payOrgCode
     * @param config
     * @ApiDocMethod
     * @ApiCode
     */
    public static void addProperty(String payOrgCode, String config) {
        addProperty(PUBLIC, payOrgCode, config);
    }

    /**
     * 添加/修改支付中心配置方法
     * 
     * @param tenantId
     *            租户ID
     * @param payOrgCode
     *            支付机构编码
     * @param config
     *            配置json字符串
     */
    public static void addProperty(String tenantId, String payOrgCode, String config) {
        /* 1. 获取配置中心客户端服务 */
//    	IConfigClient client = CCSClientFactory.getDefaultConfigClient();
//        if (client == null) {
//            throw new SystemException("获取配置中心客户端服务失败");
//        }

        /* 2. 获取支付中心配置KEY树级路径 */
        String path = PAY_CONFIG_PATH + tenantId + SEPARATOR + payOrgCode;
//        try {
//			if (!client.exists(path)) {
//				client.add(path, config);
//			} else {
//				client.modify(path, config);
//			}
//		} catch (ConfigException e) { 
			LOG.info("添加配置失败：" + path + ":" + config);
			
//		}

        LOG.info("添加配置成功：" + path + ":" + config);
    }
    /**
     * 增加租户级别基础配置信息
     * @param tenantId
     * @param config
     * @ApiDocMethod
     */
    public static void addTenantCommonProperty(String tenantId,  String config) {
        addProperty(tenantId,COMMON,config);
    }

}
