package com.ai.opt.uac.web.util;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sso.client.filter.SSOClientConstants;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.opt.uac.web.model.ssoclient.GeneralSSOClientUser;
import com.ai.paas.ipaas.ccs.IConfigClient;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

import net.sf.json.JSONObject;

public final class CacheUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);
	private CacheUtil(){}
	
	/**
	 * 设置缓存数据
	 * @param key
	 * @param second 缓存有效时间
	 * @param value
	 * @param namespace 命名空间
	 */
	public static void setValue(String key, int second, Object value, String namespace){
		JSONObject userObject = JSONObject.fromObject(value);
		ICacheClient cacheClient = MCSClientFactory.getCacheClient(namespace);
		cacheClient.setex(key, second, userObject.toString());
	}
	
	/**
	 * 取值
	 * @param key
	 * @param namespace 命名空间
	 * @param beanClass 取出的对象类型
	 * @return
	 */
	public static Object getValue(String key,String namespace,Class<?> beanClass){
		if(StringUtil.isBlank(key)||StringUtil.isBlank(namespace)){
			return null;
		}
		ICacheClient cacheClient = MCSClientFactory.getCacheClient(namespace);
		String userClientStr = cacheClient.get(key);
		if(StringUtil.isBlank(userClientStr)){
			return null;
		}
		JSONObject userObject = JSONObject.fromObject(userClientStr);
		return JSONObject.toBean(userObject, beanClass);
	}
	
	/**
	 * 
	 * @param key
	 * @param namespace 命名空间
	 */
	public static void deletCache(String key,String namespace){
		ICacheClient cacheClient = MCSClientFactory.getCacheClient(namespace);
		cacheClient.del(key);
	}
	
	
	/**
	 * 获取公共缓存
	 * @return
     */
	public static ICacheClient getCommonCacheClient(){
		return MCSClientFactory.getCacheClient(Constants.DEFAULT_COMMON_CACHE_NAMESPACE);
	}
	
	 /**
     * 获取验证码配置
     * @return
     */
	public static com.alibaba.fastjson.JSONObject getVerificationCodeConfig() {
		try {
			IConfigClient defaultConfigClient = CCSClientFactory
					.getDefaultConfigClient();
			String info = defaultConfigClient
					.get(Constants.VERIFICATION_CCS_NAMESPACE);
			System.out.println(info);
			if (!StringUtil.isBlank(info)) {
				//JSONObject json = JSONObject.parseObject(info);
				 com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(info);
				 //JSONObject json = JSONObject.fromObject(info);
				return json;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}
	
	/**
     * 获取管理员标识
     * @return
     */
    public static String getUserId(){
        GeneralSSOClientUser ssoClientUser = getSsoUser();
        return ssoClientUser!=null?ssoClientUser.getUserId():null;
    }
    
    /**
     * 获取单点登陆的用户信息
     * @return
     */
    public static GeneralSSOClientUser getSsoUser(){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        GeneralSSOClientUser clientUser = (GeneralSSOClientUser)session.getAttribute(SSOClientConstants.USER_SESSION_KEY);
        //TODO....模拟数据
//        if (clientUser==null) {
//            clientUser = new GeneralSSOClientUser();
//            clientUser.setUserId("305234");
//            clientUser.setEmail("mengbo@asiainfo.com");
//            clientUser.setUsername("mengbo@asiainfo.com");
//            saveSsoUser(clientUser);
//        }
        return clientUser;
    }
}
