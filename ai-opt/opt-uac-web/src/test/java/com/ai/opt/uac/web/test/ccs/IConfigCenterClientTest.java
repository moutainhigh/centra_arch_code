package com.ai.opt.uac.web.test.ccs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.constants.SDKConstants;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.opt.uac.web.constants.VerifyConstants;
import com.ai.opt.uac.web.constants.VerifyConstants.EmailVerifyConstants;
import com.ai.opt.uac.web.constants.VerifyConstants.PhoneVerifyConstants;
import com.ai.opt.uac.web.constants.VerifyConstants.PictureVerifyConstants;
import com.ai.paas.ipaas.ccs.IConfigClient;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

public class IConfigCenterClientTest {

    private IConfigClient client;

    @Before
    public void initData() {
        this.client = CCSClientFactory.getDefaultConfigClient();
    }

    @Ignore
    @Test
    public void testGetConfig() throws Exception {
        client.add("/test", "test");
        assertEquals("test", client.get("/test"));
        System.out.println("aaaaaa");
    }
    @Test
    public void addServiceIdPwdMap() throws ConfigException {
        String cachesnsConfig = "{\"MCS005\":\"" + "123456"     
                + "\"}";
        
        // paas serviceid password 映射配置
        if (!client.exists(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH))
            client.add(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        }
    }

    //@Ignore
    @Test
    public void addMcsConfig() throws ConfigException {
        // 缓存服务主机
        String uacRedisHost = "MCS005";
        // 缓存空间
        String cachesnsConfig = "{\"com.ai.opt.uac.sso.unicache\":\"" + uacRedisHost
                + "\",\"com.ai.opt.uac.register.cache\":\"" + uacRedisHost
                + "\",\""+Constants.RetakePassword.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\""+Constants.UpdateEmail.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\""+Constants.UpdatePhone.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\""+Constants.UpdatePassword.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\""+Constants.LoginConstant.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\""+Constants.BandEmail.CACHE_NAMESPACE+"\":\"" + uacRedisHost
                + "\",\"com.ai.opt.uni.session.sessionclient.uacweb\":\"" + uacRedisHost + "\"}";
        
      /*  StringBuilder bu=new StringBuilder();
        bu.append("{								");
        bu.append("  \"uacRedisHost\":                     ");
        bu.append("  {                                      ");
        bu.append("		  \"mcsHost\":\"10.1.130.84:16379\",     ");
        //bu.append("		  \"mcsHost\":\"localhost:6379\",     ");
        bu.append("	  	\"mcsMaxtotal\":\"200\",            ");
        bu.append("		  \"mcsMaxIdle\":\"10\",              ");
        bu.append("		  \"mcsMinIdle\":\"5\",               ");
        bu.append("		  \"mcsTestOnBorrow\":\"true\",       ");
        bu.append("		  \"mcsPassword\":\"\"          ");
        bu.append("  }                                     ");
        bu.append("}                                        ");*/
        
        
        
       /* // 缓存服务主机和密码设置
        if (!client.exists(
                SDKConstants.PAAS_CACHE_REDIS_CLUSTER_MAPPED_PATH)) {
            client.add(
                    SDKConstants.PAAS_CACHE_REDIS_CLUSTER_MAPPED_PATH,
                    bu.toString());
        } else {
            client.modify(
                    SDKConstants.PAAS_CACHE_REDIS_CLUSTER_MAPPED_PATH,
                    bu.toString());
        }
*/
        // 缓存空间配置
        if (!client.exists(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
                    cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
                    cachesnsConfig);
        }
    }
   /* //@Ignore
    @Test
    public void readMcsConfig() {
    	
    	String cachesns=client.get(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH);
    	String redisconf=client.get(SDKConstants.PAAS_CACHE_REDIS_CLUSTER_MAPPED_PATH);
    	
    	System.out.println("cachesns:"+cachesns);
    	System.out.println("redisconf:"+redisconf);
    	
    }*/

    
     @Test
     public void addUrlConfig() throws ConfigException{
    	 System.out.println("url config ... start");
    	 String indexUrl = "http://10.1.235.245:14101/baas-pt";
    	 if (!client.exists(Constants.URLConstant.INDEX_URL_KEY)) {
             client.add(Constants.URLConstant.INDEX_URL_KEY, indexUrl);
         } else {
             client.modify(Constants.URLConstant.INDEX_URL_KEY, indexUrl);
         }
    	 
    	 
    	 String baas_op_indexUrl = "http://10.1.235.245:14105/baas-op";
    	 if (!client.exists(Constants.URLConstant.BAAS_OP_INDEX_URL_KEY)) {
             client.add(Constants.URLConstant.BAAS_OP_INDEX_URL_KEY, baas_op_indexUrl);
         } else {
             client.modify(Constants.URLConstant.BAAS_OP_INDEX_URL_KEY, baas_op_indexUrl);
         }

    	 System.out.println("url config ... end");
     }
     @Test
     public void readUrlConfig() throws ConfigException{
    	 System.out.println("url config ... read start");
    	 String indexUrl = "";
    	 if (client.exists(Constants.URLConstant.INDEX_URL_KEY)) {
    		 indexUrl=client.get(Constants.URLConstant.INDEX_URL_KEY);
         } 

    	 System.out.println("indexUrl="+indexUrl);
    	 System.out.println("url config ... read end");
     }
     
     @Test
     public void addSendVerifyTimesConfig() throws ConfigException{
    	 System.out.println("addSendVerifyTimesConfig ... start");
    	 String PHONE_VERIFY_OVERTIME = "300";
    	 String PHONE_SEND_VERIFY_MAX_TIME = "60";
    	 String EMAIL_VERIFY_OVERTIME = "1800";
    	 String EMAIL_SEND_VERIFY_MAX_TIME = "60";
    	 String PICTURE_VERIFY_OVERTIME = "600";
    	 String PHONE_IP_SEND_MAXTIMES="10";
    	 String EMAIL_IP_SEND_MAXTIMES="10";
    	 String PHONE_IP_SEND_OVERTIME="300";
    	 String EMAIL_IP_SEND_OVERTIME="300";
    	 if (!client.exists(VerifyConstants.PhoneVerifyConstants.SEND_VERIFY_MAX_TIME_KEY)) {
             client.add(PhoneVerifyConstants.SEND_VERIFY_MAX_TIME_KEY, PHONE_SEND_VERIFY_MAX_TIME);
         } else {
             client.modify(PhoneVerifyConstants.SEND_VERIFY_MAX_TIME_KEY, PHONE_SEND_VERIFY_MAX_TIME);
         }
    	 if (!client.exists(VerifyConstants.PhoneVerifyConstants.VERIFY_OVERTIME_KEY)) {
             client.add(PhoneVerifyConstants.VERIFY_OVERTIME_KEY, PHONE_VERIFY_OVERTIME);
         } else {
             client.modify(PhoneVerifyConstants.VERIFY_OVERTIME_KEY, PHONE_VERIFY_OVERTIME);
         }
    	 
    	 if (!client.exists(VerifyConstants.EmailVerifyConstants.SEND_VERIFY_MAX_TIME_KEY)) {
             client.add(EmailVerifyConstants.SEND_VERIFY_MAX_TIME_KEY, EMAIL_SEND_VERIFY_MAX_TIME);
         } else {
             client.modify(EmailVerifyConstants.SEND_VERIFY_MAX_TIME_KEY, EMAIL_SEND_VERIFY_MAX_TIME);
         }
    	 if (!client.exists(VerifyConstants.EmailVerifyConstants.VERIFY_OVERTIME_KEY)) {
             client.add(EmailVerifyConstants.VERIFY_OVERTIME_KEY, EMAIL_VERIFY_OVERTIME);
         } else {
             client.modify(EmailVerifyConstants.VERIFY_OVERTIME_KEY, EMAIL_VERIFY_OVERTIME);
         }
    	 if (!client.exists(VerifyConstants.PictureVerifyConstants.VERIFY_OVERTIME_KEY)) {
             client.add(PictureVerifyConstants.VERIFY_OVERTIME_KEY, PICTURE_VERIFY_OVERTIME);
         } else {
             client.modify(PictureVerifyConstants.VERIFY_OVERTIME_KEY, PICTURE_VERIFY_OVERTIME);
         }
    	 if (!client.exists(VerifyConstants.PhoneVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY)) {
             client.add(PhoneVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY, PHONE_IP_SEND_MAXTIMES);
         } else {
             client.modify(PhoneVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY, PHONE_IP_SEND_MAXTIMES);
         }
    	 if (!client.exists(VerifyConstants.EmailVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY)) {
             client.add(EmailVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY, EMAIL_IP_SEND_MAXTIMES);
         } else {
             client.modify(EmailVerifyConstants.SEND_VERIFY_IP_MAX_NO_KEY, EMAIL_IP_SEND_MAXTIMES);
         }
    	 
    	 if (!client.exists(VerifyConstants.PhoneVerifyConstants.IP_SEND_OVERTIME_KEY)) {
             client.add(PhoneVerifyConstants.IP_SEND_OVERTIME_KEY, PHONE_IP_SEND_OVERTIME);
         } else {
             client.modify(PhoneVerifyConstants.IP_SEND_OVERTIME_KEY, PHONE_IP_SEND_OVERTIME);
         }
    	 
    	 if (!client.exists(VerifyConstants.EmailVerifyConstants.IP_SEND_OVERTIME_KEY)) {
             client.add(EmailVerifyConstants.IP_SEND_OVERTIME_KEY, EMAIL_IP_SEND_OVERTIME);
         } else {
             client.modify(EmailVerifyConstants.IP_SEND_OVERTIME_KEY, EMAIL_IP_SEND_OVERTIME);
         }
    	 System.out.println("addSendVerifyTimesConfig ... end");
     }
    
}