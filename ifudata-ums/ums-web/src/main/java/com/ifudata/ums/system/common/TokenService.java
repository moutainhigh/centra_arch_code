/*
package com.ifudata.ums.system.common;


public class TokenService {
	private static TokenService instance;
	private ICacheSV redisSv;
	public static final String TOKEN_NAME="_FORM_TOKEN"; 
	
	private TokenService() {
		redisSv = CacheSVUtil.getCRMSessionCacheSV();
	}
	public static synchronized TokenService getInstance() {
		if(instance==null){
			instance = new TokenService();
		}
		return instance;
	}
	
	public String getToken(String id){
		Object obj = redisSv.get4Serial(id);
		if(obj != null && obj instanceof String){
			return (String)obj;
		}else{
			return null;
		}
    }
	
	 */
/**标识生成**//*

    public String setToken(String id){
        String token =  System.currentTimeMillis()+"-"+Math.round(Math.random()*9000+1000);
        return token;
    }
    */
/**
     * 向redis中存储唯一标示，和定义清除失效时间
     * @param token 唯一标示
     * @author yu
     *//*

    public void setTokenToRedis(String token){
        redisSv.put4Serial(token, "-1");
        //默认2分钟
        int expire = (CacheConfig.getInteger("redis.form.token")==null
             ||CacheConfig.getInteger("redis.form.token")<1)?300:CacheConfig.getInteger("redis.form.token")/1000;
        redisSv.expire(token,expire);
    }
    public void removeToken(String id){
        redisSv.remove(id);
    }
}
*/
