package com.ai.opt.sso.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import javax.validation.constraints.NotNull;

import org.jasig.cas.Message;
import org.jasig.cas.authentication.BasicCredentialMetaData;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.handler.NoOpPrincipalNameTransformer;
import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.jasig.cas.authentication.handler.PlainTextPasswordEncoder;
import org.jasig.cas.authentication.handler.PrincipalNameTransformer;
import org.jasig.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.authentication.support.PasswordPolicyConfiguration;
import org.jasig.cas.support.pac4j.plugin.common.ThirdLoginConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.api.user.param.KingSoftLoginErrorResponse;
import com.ai.opt.data.api.user.param.KingSoftLoginResponse;
import com.ai.opt.data.api.user.param.LoginLogRequest;
import com.ai.opt.data.api.user.param.UserLoginResponse;
import com.ai.opt.data.constants.ThirdUserConstants;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.util.Md5Util;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sso.exception.AccountNameNotExistException;
import com.ai.opt.sso.exception.AccountNotAllowLoginException;
import com.ai.opt.sso.exception.CaptchaErrorException;
import com.ai.opt.sso.exception.CaptchaIsNullException;
import com.ai.opt.sso.exception.CaptchaOutTimeException;
import com.ai.opt.sso.exception.EmailNotExistException;
import com.ai.opt.sso.exception.PasswordErrorException;
import com.ai.opt.sso.exception.PasswordIsNullException;
import com.ai.opt.sso.exception.PhoneNotExistException;
import com.ai.opt.sso.exception.SystemErrorException;
import com.ai.opt.sso.exception.UsernameIsNullException;
import com.ai.opt.sso.principal.BssCredentials;
import com.ai.opt.sso.service.LoadAccountService;
import com.ai.opt.sso.util.MD5Utils;
import com.ai.opt.sso.util.RegexUtils;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.opt.uac.web.constants.Constants.Register;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.ucenter.api.members.interfaces.IUcMembersOperationSV;
import com.ai.yc.ucenter.api.members.param.UcMembersResponse;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersActiveRequest;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersDynPassRequest;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersDynPassResponse;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersGetOperationcodeResponse;
import com.alibaba.fastjson.JSONObject;

import scala.language;

/**
 * Date: 2017年6月13日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author Gavin
 */
public final class BssCredentialsAuthencationHandler
        extends AbstractPreAndPostProcessingAuthenticationHandler {

//	 @Autowired
	private static ILoginSV iLoginSV;
	
	static String kingKey = ThirdLoginConfigUtil.getKingSoftConfig().getAppid();
	static String kingSecret = ThirdLoginConfigUtil.getKingSoftConfig().getSecret();
	
	//金山登录接口
	private static String loginInterface = "http://my.iciba.com/index.php?c=sso&m=login";
	//金山校验用户名接口
	private static String userCheckInterface = "http://my.iciba.com/index.php?c=sso&m=username_check";
	//金山登录验证接口(获取用户登录信息)
	private static String loginCheckInterface = "http://my.iciba.com/index.php?c=sso&m=check_ck";
	
    @Resource
    private LoadAccountService loadAccountService;

    @NotNull
    private PasswordEncoder passwordEncoder;

    @NotNull
    private PrincipalNameTransformer principalNameTransformer;

    private PasswordPolicyConfiguration passwordPolicyConfiguration;

    public LoadAccountService getLoadAccountService() {
        return loadAccountService;
    }

    public void setLoadAccountService(LoadAccountService loadAccountService) {
        this.loadAccountService = loadAccountService;
    }

    public BssCredentialsAuthencationHandler() {
        this.passwordEncoder = new PlainTextPasswordEncoder();
        this.principalNameTransformer = new NoOpPrincipalNameTransformer();
    }

    @Override
    public boolean supports(Credential credentials) {
        return credentials != null
                && (BssCredentials.class.isAssignableFrom(credentials.getClass()));
    }

    @Override
    protected HandlerResult doAuthentication(final Credential credentials)
            throws GeneralSecurityException, PreventedException {

        // 获取配置中心登录失败有效时间
        logger.debug("开始认证用户凭证credentials");
        if (credentials == null) {
            logger.info("用户凭证credentials为空");
            throw new LoginException("Credentials is null");
        }
        BssCredentials bssCredentials = (BssCredentials) credentials;
        String loginType = bssCredentials.getLoginType();
        //手机快速登录
        if("1".equals(loginType)){
        	mobileLogin(bssCredentials);
        }//金山登录
        else if("2".equals(loginType)){
        	kingsoftLogin(bssCredentials);
        }//普通登录
        else {
            commonLogin(bssCredentials);
        }
        String userName = bssCredentials.getUsername();
        logger.info("用户 [" + userName + "] 认证成功。");

        return creatHandlerResult(bssCredentials, new SimplePrincipal(userName), null);
    }

    private HandlerResult creatHandlerResult(BssCredentials bssCredentials,
            SimplePrincipal simplePrincipal, List<Message> warnings) {
        return new HandlerResult(this, new BasicCredentialMetaData(bssCredentials), simplePrincipal,
                warnings);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public PrincipalNameTransformer getPrincipalNameTransformer() {
        return principalNameTransformer;
    }

    public void setPrincipalNameTransformer(PrincipalNameTransformer principalNameTransformer) {
        this.principalNameTransformer = principalNameTransformer;
    }

    public PasswordPolicyConfiguration getPasswordPolicyConfiguration() {
        return passwordPolicyConfiguration;
    }

    public void setPasswordPolicyConfiguration(
            PasswordPolicyConfiguration passwordPolicyConfiguration) {
        this.passwordPolicyConfiguration = passwordPolicyConfiguration;
    }

    /**
     * 普通登录验证
     */
    private void commonLogin(BssCredentials bssCredentials)
            throws CredentialException {
        String errorNumTimeOut = bssCredentials.getErrorNumTimeOutCCS();
        final String username = bssCredentials.getUsername();
        final String pwdFromPage = bssCredentials.getPassword();
        final String sessionId = bssCredentials.getSessionId();
        //systemSource非必填,可以为空
        final String systemSource = bssCredentials.getSystemId();
        
        // 用户名非空校验
        if (!StringUtils.hasText(username)) {
            logger.error("请输入手机号码或邮箱地址");
            throw new UsernameIsNullException();
        }
        // 密码非空校验
        if (!StringUtils.hasText(pwdFromPage)) {
            logger.error("密码为空！");
            throw new PasswordIsNullException();
        }

        Integer timoutNum = null;
        if (!StringUtils.isEmpty(errorNumTimeOut)) {
            timoutNum = Integer.valueOf(errorNumTimeOut);
        }
        if (timoutNum == null || timoutNum < 300) {
            timoutNum = 300;
        }

        ICacheClient jedis = MCSClientFactory.getCacheClient("com.ai.opt.uac.cache.logincount.cache");
        String requestIp = jedis.get(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + bssCredentials.getId());
        String errorNumstr = bssCredentials.getErrorNum();
        Integer errorNum = StringUtils.hasText(errorNumstr)?Integer.valueOf(errorNumstr):null;
        // 获取配置中心登录失败次数
        String errorNumConfig = bssCredentials.getErrorNumCCS();
        Integer errorNumberCCS = StringUtils.hasText(errorNumConfig)?Integer.valueOf(errorNumConfig):null;
        logger.info("errorNum={}，errorNumber={}", errorNum,errorNumberCCS);
        //是否显示验证码
        boolean captchaShow = (errorNum >= errorNumberCCS)?true:false;
        logger.info("captchaShow={}", captchaShow);
        if (captchaShow == true) {
            final String captchaCode = bssCredentials.getCaptchaCode().toLowerCase();

            // 验证码非空校验
            if (!StringUtils.hasText(captchaCode)) {
                logger.error("请输入验证码");
                throw new CaptchaIsNullException();
            }

            ICacheClient iCacheClient = MCSClientFactory.getCacheClient(Register.CACHE_NAMESPACE);
            // 生成的校验码
            String cookieCaptcha = iCacheClient.get(Register.CACHE_KEY_VERIFY_PICTURE + sessionId)
                    .toLowerCase();
            // 校验图片是否失效
            if (StringUtil.isBlank(cookieCaptcha)) {
                throw new CaptchaOutTimeException();
            }

            // 校验验证码
            logger.error("cookieCaptcha={},bssCredentials={}",
                    cookieCaptcha,bssCredentials.getCaptchaCode().toLowerCase());

            if (!cookieCaptcha.equals(bssCredentials.getCaptchaCode().toLowerCase())) {
                throw new CaptchaErrorException();
            }
        }

        UserLoginResponse user = null;
        try {
            //查询用户信息
            user = loadAccountService.loadAccount(bssCredentials);

            // if(SSOConstants.ACCOUNT_LOGIN_FLAG.equals(user.getLoginFlag())){
            // //账号不允许登录
            // logger.error("账号不允许登录");
            // throw new AccountNotAllowLoginException();
            // }
            if (user == null || StringUtil.isBlank(user.getUserId())) {
                if (RegexUtils.checkIsPhone(bssCredentials.getUsername())) {
                    logger.error("手机号码未注册");
                    throw new PhoneNotExistException();
                } else if (RegexUtils.checkIsEmail(bssCredentials.getUsername())) {
                    logger.error("邮箱未绑定");
                    throw new EmailNotExistException();
                } /*
                   * else if(SSOConstants.ACCOUNT_LOGIN_FLAG.equals(user.getLoginFlag())){ //账号不允许登录
                   * logger.error("账号不允许登录"); throw new AccountNotAllowLoginException(); }
                   */
                /*
                 * else if(SSOConstants.ACCOUNT_DEL_FLAG.equals(user.getDelFlag())){ //账号已删除
                 * logger.error("账号已删除"); throw new AccountNameNotExistException(); }
                 */
                else {
                    logger.error("账号未注册，密码错误");

                    throw new AccountNameNotExistException();
                }
            }
            //验证密码有效性
            String dbPwd = user.getLoginPassword();
            String salt = user.getSalt();
            logger.info("【dbPwd】=" + dbPwd);
            logger.info("【pwdFromPage】=" + pwdFromPage);
            String encryPwdFromPage = MD5Utils.md5(MD5Utils.md5(pwdFromPage).concat(salt));

            // 密码不对
            if (!encryPwdFromPage.equals(dbPwd)) {
                logger.error("密码错误！");
                throw new PasswordErrorException();
            }

            // if(!SSOConstants.ACCOUNT_ACITVE_STATE.equals(user.getState())){
            // //密码不对
            // throw new CredentialException("账号状态异常");
            // }
            // Date currentDate=new Date();
            // Date acitveDate=user.getEffectiveDate();
            // Date inactiveDate=user.getExpiryDate();
            // if(acitveDate!=null&&currentDate.before(acitveDate)){
            // throw new CredentialException("账号未生效");
            // }
            // if(inactiveDate!=null&&inactiveDate.before(currentDate)){
            // throw new CredentialException("账号已失效");
            // }

            // BeanUtils.copyProperties(bssCredentials, user);
            bssCredentials.setTenantId(user.getTenantId());
            bssCredentials.setUserId(user.getUserId());
            bssCredentials.setMobile(user.getMobile());
            bssCredentials.setEmail(user.getEmail());
            bssCredentials.setLoginName(user.getLoginName());
            bssCredentials.setDomainname(user.getDomainname());
            bssCredentials.setErrorNum(errorNum.toString());

            jedis.del(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp);
          //登陆日志
            LoginLogRequest logRequest = new LoginLogRequest();
            logRequest.setUserId(Integer.valueOf(user.getUserId()));
            logRequest.setSystemSource(systemSource);
            iLoginSV.saveLoginLog(logRequest);
        } catch (RPCSystemException e) {
            logger.error("调用查询账户服务（Dubbo）失败", e);
            throw new CredentialException("系统错误");
        } catch (Exception e) {
            logger.error("系统异常", e);

            if (!jedis.exists(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp)) {
                jedis.setex(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, timoutNum,
                        0 + "");
            }
            jedis.incrBy(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, 1);
            logger.error("【" + user.getLoginName() + "】 登录失败，目前失败次数为："
                    + jedis.get(Constants.LOGIN_LOST_COUNT_KEY + ":" + user.getLoginName()));
            throw new SystemErrorException();
        }
    }
    
    /**
     * 金山登录验证
     */
    private void kingsoftLogin(BssCredentials bssCredentials)
            throws CredentialException {
        String errorNumTimeOut = bssCredentials.getErrorNumTimeOutCCS();
        final String username = bssCredentials.getUsername();
        final String pwdFromPage = bssCredentials.getPassword();
        final String sessionId = bssCredentials.getSessionId();
      //systemSource非必填,可以为空
        final String systemSource = bssCredentials.getSystemId();
        // 用户名非空校验
        if (!StringUtils.hasText(username)) {
            logger.error("请输入手机号码或邮箱地址");
            throw new UsernameIsNullException();
        }
        // 密码非空校验
        if (!StringUtils.hasText(pwdFromPage)) {
            logger.error("密码为空！");
            throw new PasswordIsNullException();
        }

        Integer timoutNum = null;
        if (StringUtils.hasText(errorNumTimeOut)) {
            timoutNum = Integer.valueOf(errorNumTimeOut);
        }
        if (timoutNum < 300) {
            timoutNum = 300;
        }
        
        ICacheClient jedis = MCSClientFactory.getCacheClient("com.ai.opt.uac.cache.logincount.cache");
        String requestIp = jedis.get(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + bssCredentials.getId());
        String errorNumstr = bssCredentials.getErrorNum();
        Integer errorNum = StringUtils.hasText(errorNumstr)?Integer.valueOf(errorNumstr):null;
        // 获取配置中心登录失败次数
        String errorNumConfig = bssCredentials.getErrorNumCCS();
        final String captchaCode = bssCredentials.getCaptchaCode().toLowerCase();

        // 验证码非空校验
        if (!StringUtils.hasText(captchaCode)) {
            logger.error("请输入验证码");
            throw new CaptchaIsNullException();
        }

        ICacheClient iCacheClient = MCSClientFactory.getCacheClient(Register.CACHE_NAMESPACE);
        // 生成的校验码
        String cookieCaptcha = iCacheClient.get(Register.CACHE_KEY_VERIFY_PICTURE + sessionId)
                .toLowerCase();
        // 校验图片是否失效
        if (StringUtil.isBlank(cookieCaptcha)) {
            throw new CaptchaOutTimeException();
        }

        // 校验验证码
        logger.error("cookieCaptcha={},bssCredentials={}",
                cookieCaptcha,bssCredentials.getCaptchaCode().toLowerCase());

        if (!cookieCaptcha.equals(bssCredentials.getCaptchaCode().toLowerCase())) {
            throw new CaptchaErrorException();
        }

        UserLoginResponse user = null;
        //发送请求
        String param = getCommonParam()+"&username="+username+"&password="+ Md5Util.md5(pwdFromPage);
        
        logger.info("金山登陆请求url:"+loginInterface+"金山登陆请求参数:"+param);
        
        JSONObject jsonObj = JSONObject.parseObject(sendPost(loginInterface, param)); 
        logger.info("login kingsoft response:"+jsonObj.toJSONString());
        System.out.println("login kingsoft response:"+jsonObj.toJSONString());
        if (jsonObj==null) {
        	logger.error("登陆失败");
        	throw new AccountNameNotExistException();
        }
        
        KingSoftLoginResponse jb = (KingSoftLoginResponse)JSONObject.toJavaObject(jsonObj,KingSoftLoginResponse.class);
        if (jb.getUid()==null) {
        	KingSoftLoginErrorResponse javaObject = JSONObject.toJavaObject(jsonObj,KingSoftLoginErrorResponse.class);
        	if (javaObject.getError_code().equals("10006")) {
        		throw new AccountNameNotExistException();
        	}else {
        		throw new AccountNameNotExistException();
        	}
        }
        try {
        	
        	String kingsoftUid = jb.getUid();
			String kingsoftUsername="KINGSOFT_"+kingsoftUid;
			UcMembers ucMembers=new UcMembers();
			ucMembers.setUsersource(ThirdUserConstants.UserSource.KINGSOFT);
			ucMembers.setThirduid(kingsoftUid);
			ucMembers.setUsername(jb.getNickname());
			
			String uid=iLoginSV.bindThirdUser(ucMembers);
			
			//查询用户信息
            user = loadAccountService.loadAccount(bssCredentials);
			
            if (user == null || StringUtil.isBlank(user.getUserId())) {
                if (RegexUtils.checkIsPhone(bssCredentials.getUsername())) {
                    logger.error("手机号码未注册");
                    throw new PhoneNotExistException();
                } else if (RegexUtils.checkIsEmail(bssCredentials.getUsername())) {
                    logger.error("邮箱未绑定");
                    throw new EmailNotExistException();
                } else {
                    logger.error("账号未注册，密码错误");

                    throw new AccountNameNotExistException();
                }
            }
            //验证密码有效性
            String dbPwd = user.getLoginPassword();
            String salt = user.getSalt();
            logger.info("【dbPwd】=" + dbPwd);
            logger.info("【pwdFromPage】=" + pwdFromPage);
            String encryPwdFromPage = MD5Utils.md5(MD5Utils.md5(pwdFromPage).concat(salt));

            // 密码不对
            /*if (!encryPwdFromPage.equals(dbPwd)) {
                logger.error("密码错误！");
                throw new PasswordErrorException();
            }*/


          //bssCredentials.setTenantId(user.getTenantId());
            bssCredentials.setUserId(kingsoftUid);
           // bssCredentials.setMobile(user.getMobile());
            bssCredentials.setEmail(jb.getEmail());
            bssCredentials.setLoginName(jb.getNickname());
            //bssCredentials.setDomainname(user.getDomainname());
           //bssCredentials.setErrorNum(errorNum.toString());

            jedis.del(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp);
            
          //登陆日志
            LoginLogRequest logRequest = new LoginLogRequest();
            logRequest.setUserId(Integer.valueOf(user.getUserId()));
            logRequest.setSystemSource(systemSource);
            iLoginSV.saveLoginLog(logRequest);
            
        } catch (Exception e) {
            logger.error("系统异常", e);

            if (!jedis.exists(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp)) {
                jedis.setex(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, timoutNum,
                        0 + "");
            }
            jedis.incrBy(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, 1);
            logger.error("【" + user.getLoginName() + "】 登录失败，目前失败次数为："
                    + jedis.get(Constants.LOGIN_LOST_COUNT_KEY + ":" + user.getLoginName()));
            throw new SystemErrorException();
        }
    }
    
    
    /**
     *  手机快速登录验证
     */
    private void mobileLogin(BssCredentials bssCredentials)
    		throws CredentialException {
    	String errorNumTimeOut = bssCredentials.getErrorNumTimeOutCCS();
    	final String username = bssCredentials.getUsername();
    	final String pwdFromPage = bssCredentials.getPassword();
    	final String sessionId = bssCredentials.getSessionId();
    	bssCredentials.setMobile(bssCredentials.getUsername());
    	//systemSource非必填,可以为空
        final String systemSource = bssCredentials.getSystemId();
    	// 用户名非空校验
    	if (!StringUtils.hasText(username)) {
    		logger.error("请输入手机号码或邮箱地址");
    		throw new UsernameIsNullException();
    	}
    	// 密码非空校验
    	if (!StringUtils.hasText(pwdFromPage)) {
    		logger.error("密码为空！");
    		throw new PasswordIsNullException();
    	}
    	
    	Integer timoutNum = null;
    	if (StringUtils.hasText(errorNumTimeOut)) {
    		timoutNum = Integer.valueOf(errorNumTimeOut);
    	}
    	if (timoutNum < 300) {
    		timoutNum = 300;
    	}
    	
    	ICacheClient jedis = MCSClientFactory.getCacheClient("com.ai.opt.uac.cache.logincount.cache");
    	String requestIp = jedis.get(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + bssCredentials.getId());
    	String errorNumstr = bssCredentials.getErrorNum();
    	Integer errorNum = StringUtils.hasText(errorNumstr)?Integer.valueOf(errorNumstr):null;
    	// 获取配置中心登录失败次数
    	String errorNumConfig = bssCredentials.getErrorNumCCS();
    	final String captchaCode = bssCredentials.getCaptchaCode().toLowerCase();
    	
    	// 验证码非空校验
    	if (!StringUtils.hasText(captchaCode)) {
    		logger.error("请输入验证码");
    		throw new CaptchaIsNullException();
    	}
    	
    	ICacheClient iCacheClient = MCSClientFactory.getCacheClient(Register.CACHE_NAMESPACE);
    	// 生成的校验码
    	String cookieCaptcha = iCacheClient.get(Register.CACHE_KEY_VERIFY_PICTURE + sessionId)
    			.toLowerCase();
    	// 校验图片是否失效
    	if (StringUtil.isBlank(cookieCaptcha)) {
    		throw new CaptchaOutTimeException();
    	}
    	
    	// 校验验证码
    	logger.error("cookieCaptcha={},bssCredentials={}",
    			cookieCaptcha,bssCredentials.getCaptchaCode().toLowerCase());
    	
    	if (!cookieCaptcha.equals(bssCredentials.getCaptchaCode().toLowerCase())) {
    		throw new CaptchaErrorException();
    	}
    
    	UserLoginResponse user = null;
    	//发送登陆请求
    	UcMembersDynPassRequest request = new UcMembersDynPassRequest();
    	request.setMobilephone(username);
    	request.setDynPass(pwdFromPage);
    	request.setRegip(requestIp);
    	request.setLoginmode("3");
    	request.setSystemsource("0");
    	request.setLogin(true);
    	
    	
    	UcMembersDynPassResponse res = DubboConsumerFactory.getService(IUcMembersOperationSV.class).ucDynPassVerify(request);
    	/*UcMembersActiveRequest request = new UcMembersActiveRequest();
    	request.setOperationcode(bssCredentials.getPassword());
    	request.setOperationtype("3");
    	request.setUserinfo(username);*/
    	//UcMembersResponse res = DubboConsumerFactory.getService(IUcMembersOperationSV.class).ucActiveMember(request);
    	if (res==null||!res.getResponseHeader().getResultCode().equals("000000")) {
    		logger.error("登陆失败");
    		throw new CaptchaErrorException();
    	}
    	try {
    		
    		//查询用户信息by mobile
    		user = loadAccountService.loadAccountByMobile(bssCredentials);
    		//手机号没有注册 -- 注册插入数据
    		if (user == null || StringUtil.isBlank(user.getMobile())) {
    			if (RegexUtils.checkIsPhone(bssCredentials.getMobile())) {
    				//
    				UcMembers ucMembers=new UcMembers();
    				ucMembers.setMobilephone(bssCredentials.getMobile());
    				iLoginSV.saveUserByMobileLogin(ucMembers);
    			}
    			user = loadAccountService.loadAccountByMobile(bssCredentials);
			}
    		
    		bssCredentials.setTenantId(user.getTenantId());
            bssCredentials.setUserId(user.getUserId());
            bssCredentials.setMobile(user.getMobile());
            bssCredentials.setEmail(user.getEmail());
            bssCredentials.setLoginName(user.getLoginName());
            bssCredentials.setDomainname(user.getDomainname());
            bssCredentials.setErrorNum(errorNum.toString());
    		
    		jedis.del(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp);
    		//登陆日志
            LoginLogRequest logRequest = new LoginLogRequest();
            logRequest.setUserId(Integer.valueOf(user.getUserId()));
            logRequest.setSystemSource(systemSource);
            iLoginSV.saveLoginLog(logRequest);
    	}catch (RPCSystemException e) {
            logger.error("调用查询账户服务（Dubbo）失败", e);
            throw new CredentialException("系统错误");
        } catch (Exception e) {
    		logger.error("系统异常", e);
    		
    		if (!jedis.exists(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp)) {
    			jedis.setex(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, timoutNum,
    					0 + "");
    		}
    		jedis.incrBy(CustomLoginFlowUrlHandler.CAS_REDIS_PREFIX + requestIp, 1);
    		logger.error("【" + user.getLoginName() + "】 登录失败，目前失败次数为："
    				+ jedis.get(Constants.LOGIN_LOST_COUNT_KEY + ":" + user.getLoginName()));
    		throw new SystemErrorException();
    	}
    }
    
    public  JSONObject loginCheckToKing(String ck){
		String param = "ck="+ck;
		JSONObject jsonObj = JSONObject.parseObject(sendPost(loginCheckInterface, param));
		return jsonObj;
	}
    
	public  String getCommonParam(){
		Long auth_timestamp = new Date().getTime();
		String auth_nonce = getUUID();
		String auth_signature = Md5Util.md5(kingKey+auth_nonce+auth_timestamp+kingSecret);
		StringBuffer sb = new StringBuffer();
		sb.append("auth_key=");
		sb.append(kingKey);
		sb.append("&auth_signature=");
		sb.append(auth_signature);
		sb.append("&auth_timestamp=");
		sb.append(auth_timestamp);
		sb.append("&auth_nonce=");
		sb.append(auth_nonce);
		return sb.toString();
	}
    
    public  String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			logger.error("发送 POST 请求出现异常!" , e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static String getUUID(){ 
        String s = UUID.randomUUID().toString();
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }

	public static ILoginSV getiLoginSV() {
		return iLoginSV;
	}

	public static void setiLoginSV(ILoginSV iLoginSV) {
		BssCredentialsAuthencationHandler.iLoginSV = iLoginSV;
	}
	
	
}
