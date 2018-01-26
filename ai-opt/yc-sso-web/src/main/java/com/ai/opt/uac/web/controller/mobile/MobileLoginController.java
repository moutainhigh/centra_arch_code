package com.ai.opt.uac.web.controller.mobile;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.RandomUtil;
import com.ai.opt.sdk.web.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.util.SmsSenderUtil;
import com.ai.opt.uac.web.constants.CacheKey;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.opt.uac.web.constants.Constants.UcenterOperation;
import com.ai.opt.uac.web.constants.Constants.kingsoftLogin;
import com.ai.opt.uac.web.util.CacheUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.ucenter.api.members.interfaces.IUcMembersOperationSV;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersGetOperationcodeRequest;
import com.ai.yc.ucenter.api.members.param.opera.UcMembersGetOperationcodeResponse;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/mobileLogin")
@Controller
public class MobileLoginController{
	private static final Logger LOG = LoggerFactory.getLogger(MobileLoginController.class);
	
	 @Autowired
	 private static ILoginSV iLoginSV;
	 @Autowired
	 //private static IUcMembersOperationSV iUcMembersOperationSV;
	
	/**
	 * 查询国家
	 */
	@RequestMapping("/loadCountry")
	@ResponseBody
	public static ResponseData<List<CountryResponse>> loadCountry() {
		
		List<CountryResponse> list = new ArrayList<>();
        ICacheClient iCacheClient = CacheUtil.getCommonCacheClient();
        String str = iCacheClient.hget(CacheKey.COUNTRY_L_KEY,CacheKey.COUNTRY_L_KEY);
        if(StringUtils.isNotBlank(str)) {
        	list = JSONObject.parseArray(str, CountryResponse.class);
        }
        
        return new ResponseData<List<CountryResponse>>(ResponseData.AJAX_STATUS_SUCCESS, "ok", list);
	}
	
	/**
	 * 校验图片证码
	 */
	@RequestMapping("/checkImageVerifyCode")
	@ResponseBody
	public static ResponseData<Boolean> checkImageVerifyCode(HttpServletRequest request, String verifyCode) {
		String msg = "验证码信息错误";
		ResponseData<Boolean> result = checkImageVerifyCode(request, verifyCode,
				msg);
		return result;
	}
	
	/**
	 * 校验图片验证码
	 * 
	 * @param request
	 * @param errorMsg
	 * @return
	 */
	public static ResponseData<Boolean> checkImageVerifyCode(
			HttpServletRequest request, String verifyCode, String errorMsg) {
		try {
			String cacheKey = kingsoftLogin.CACHE_KEY_VERIFY_PICTURE
					+ request.getSession().getId();
			String imgCode = verifyCode;
			Boolean isRight = checkImageVerifyCode(kingsoftLogin.CACHE_NAMESPACE,
					cacheKey, imgCode);
			if (isRight) {
				errorMsg = "ok";
			}
			return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
					errorMsg, isRight);

		} catch (Exception e) {
			return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_FAILURE,
					"error");
		}
	}

	/**
	 * 校验图片验证码
	 * 
	 * @param namespace
	 * @param cacheKey
	 * @param ckValue
	 * @return
	 */
	public static boolean checkImageVerifyCode(String namespace,
			String cacheKey, String ckValue) {
		Boolean isRight = false;
		try {
			ICacheClient cacheClient = MCSClientFactory
					.getCacheClient(namespace);
			String code = cacheClient.get(cacheKey);
			if (!StringUtil.isBlank(code) && !StringUtil.isBlank(ckValue)
					&& ckValue.equalsIgnoreCase(code)) {
				isRight = true;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return isRight;
	}
	
    /**
     * 发送短信处理
     * @param request
     * @param req
     * @param type
     * @param uid
     * @param phone
     * @return 
     * @return
     */
	@RequestMapping("/sendMobileSmsCode")
	@ResponseBody
	public ResponseData<Boolean> sendSmsCode(HttpServletRequest request,
			HttpServletResponse response) {
		String phone = request.getParameter("mobile");
		String type = request.getParameter("type");
		String countryValue = request.getParameter("countryValue");
		SmsRequest req = new SmsRequest();
		req.setPhone(phone);
		/** 手机验证码key **/
		String codeKey = null;
		/** 手机验证码超时时间 **/
		String codeOverTimeKey = null;
		/** 最多发送次数key **/
		String maxCountKey = null;
		/** 最多发送次数超时时间key **/
		String maxCountOverTimeKey = null;
		/** 当前发送次数key **/
		String nowCountKey = null;
		if (StringUtil.isBlank(type)) {
			type = Constants.UcenterOperation.OPERATION_TYPE_PHONE_ACTIVATE;
		}
		if (Constants.UcenterOperation.OPERATION_TYPE_PHONE_ACTIVATE.equals(type)) {// 注册手机激活码
			codeKey = Constants.PhoneVerify.REGISTER_PHONE_CODE + phone;
			codeOverTimeKey = Constants.PhoneVerify.REGISTER_PHONE_CODE_OVERTIME;
			nowCountKey = Constants.PhoneVerify.REGISTER_PHONE_CODE_COUNT + phone;
			maxCountKey = Constants.PhoneVerify.REGISTER_PHONE_CODE_MAX_COUNT;
			maxCountOverTimeKey = Constants.PhoneVerify.REGISTER_PHONE_CODE_MAX_COUNT_OVERTIME;
		} else if (Constants.UcenterOperation.OPERATION_TYPE_PHONE_VERIFY.equals(type)) {// 手机验证码
			codeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE + phone;
			codeOverTimeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_OVERTIME;
			nowCountKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_COUNT + phone;
			maxCountKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_MAX_COUNT;
			maxCountOverTimeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_MAX_COUNT_OVERTIME;
		}else if (Constants.UcenterOperation.OPERATION_TYPE_PHONE_DYNAMIC.equals(type)) {// 手机动态码
			codeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE + phone;
			codeOverTimeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_OVERTIME;
			nowCountKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_COUNT + phone;
			maxCountKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_MAX_COUNT;
			maxCountOverTimeKey = Constants.PhoneVerify.UPDATE_DATA_PHONE_CODE_MAX_COUNT_OVERTIME;
	   }
		
		LOG.info("codeKey"+codeKey+"codeOverTimeKey"+codeOverTimeKey+"nowCountKey"+nowCountKey);
		
		req.setCodeKey(codeKey);
		req.setCodeOverTimeKey(codeOverTimeKey);
		req.setMaxCountKey(maxCountKey);
		req.setMaxCountOverTimeKey(maxCountOverTimeKey);
		req.setNowCountKey(nowCountKey);
		//String uid = request.getParameter("uid");
		/*if(StringUtil.isBlank(uid)){
			uid = CacheUtil.getUserId();
		}*/
		return sendSms(request,req, type, phone, countryValue);

	}
	
	
	private ResponseData<Boolean> sendSms(HttpServletRequest request,SmsRequest req, String type,
			 String phone, String countryValue) {
		ICacheClient iCacheClient = CacheUtil.getCommonCacheClient();
		JSONObject config = CacheUtil.getVerificationCodeConfig();
		// 最多发送次数 key
		LOG.info("最多发送次数 key-----req.getMaxCountKey()"+req.getMaxCountKey());
		int maxCount = 0;
		if (req.getMaxCountKey() == null) {
			 maxCount = config.getIntValue("update_data_phone_code_max_count");
		}else {
			maxCount = config.getIntValue(req.getMaxCountKey());
		}
		LOG.info("最多发送次数 "+maxCount);
		
		// 当前发送次数
		Integer nowCount = 0;
		String sendCount = iCacheClient.get(req.getNowCountKey());
		LOG.info("最多发送次数 "+sendCount);
		if (!StringUtil.isBlank(sendCount)) {
			nowCount = Integer.parseInt(sendCount);
		}
		if (nowCount > maxCount) {
			return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
					"ycregisterMsg.verificationCodeCountError", false);
		}
		Object[] ucenterRes = getUcenterOperationCode(type, phone);
		if (!(boolean) ucenterRes[0]) {
			
			return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
					"获取动态密码失败", false);
		}
		String randomStr = (String) ucenterRes[1];// RandomUtil.randomNum(6);
		
		//String randomStr = RandomUtil.randomNum(6);
		LOG.info("生成验证码返回：" + randomStr);
		//System.out.println("生成验证码返回：" + randomStr);
		//默认中文模版
		String _template = Constants.PhoneVerify.SMS_CODE_TEMPLATE_ZH_CN;
		//String countryValue = request.getParameter("countryValue");
		//获取当前登录用户国家信息
		CountryResponse country = null;
		if(CacheUtil.getSsoUser()!=null){
			String domainname = CacheUtil.getSsoUser().getDomainname();
			ICacheClient commonCacheClient = CacheUtil.getCommonCacheClient();
	    	String str = commonCacheClient.hget(CacheKey.COUNTRY_D_KEY,domainname);
	        if(StringUtils.isNotBlank(str)) {
	        	country = JSONObject.parseObject(str, CountryResponse.class);
	        }
		}
		Locale locale = LocaleContextHolder.getLocale();
        /**
         * 如果countryValue为空表示是验证手机号
         * 如果countryValue不为空表示是修改或者是绑定手机号
         */
        if(Locale.US.toString().equals(locale.toString())){
        	_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_EN_US;
        }
        if(Locale.SIMPLIFIED_CHINESE.toString().equals(locale.toString())){
        	if(null != country && StringUtil.isBlank(countryValue)){
        		if(!"86".equals(country.getCountryCode())){
        			_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_EN_US;
        		}
        	}
        	// country 要在 countryValue前，因为在countryValue有值的情况下country是错误的
        	if(!StringUtil.isBlank(countryValue)){
        		if(!"86".equals(countryValue)){
        			_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_EN_US;
        		}
        	}
        	if(!StringUtil.isBlank(countryValue)){
        		if("86".equals(countryValue)){
        			_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_ZH_CN;
        		}
        	}
        	if("+".equals(phone.substring(0, 1))){
        		if("+86".equals(phone.substring(0, 3))){
            		_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_ZH_CN;
            	} else {
            		_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_EN_US;
            	}
        	}
        	if(StringUtil.isBlank(countryValue) && (null == country)){
        		if(!"+86".equals(phone.substring(0, 3))){
            		_template =  Constants.PhoneVerify.SMS_CODE_TEMPLATE_EN_US;
            	}
        	}
        }
		req.setContent(MessageFormat.format(_template,randomStr));
		// 手机注册特殊处理 请求ucenter  phone没有国家代码 
		/*if (Constants.UcenterOperation.OPERATION_TYPE_PHONE_ACTIVATE.equals(type)) {
		    request.getSession().setAttribute(req.getCodeKey()+Constants.PhoneVerify.PHONE_CODE_REGISTER_UID, ucenterRes[3]);
		    phone = request.getParameter("fullPhone");//+86格式
		}*/
		LOG.info("短信验证码是====="+randomStr+"短信内容是============"+req.getContent());
		if(!StringUtil.isBlank(countryValue)&&!phone.contains("+")){
			phone = "+"+countryValue+phone;
		}
		boolean sendOk = SmsSenderUtil.sendMessage(phone,req.getContent());
		if (sendOk) {
			// 最多发送次数超时时间
			int maxOverTimeCount = config.getIntValue(req
					.getMaxCountOverTimeKey());
			nowCount = nowCount + 1;
			iCacheClient.setex(req.getNowCountKey(), maxOverTimeCount,
					String.valueOf(nowCount));
			// 手机验证码超时时间
			int overTime = config.getIntValue(req.getCodeOverTimeKey());
			iCacheClient.setex(req.getCodeKey(), overTime, randomStr);
			return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
					"ycregisterMsg.sendSmsSuccess", true);
		}
		return new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS, "",
				false);
	}
	
	/**
	 * 调用ucenter生成操作码
	 */
	private Object[] getUcenterOperationCode(String operationtype, 
			String userinfo) {
		UcMembersGetOperationcodeRequest req = new UcMembersGetOperationcodeRequest();
		req.setTenantId(Constants.DEFAULT_TENANT_ID);
		req.setOperationtype(operationtype);
		/*if (!StringUtil.isBlank(uid)) {
			req.setUid(Integer.parseInt(uid));
		}*/
		if (!StringUtil.isBlank(userinfo)) {
			req.setUserinfo(userinfo);
		}
		if (UcenterOperation.OPERATION_TYPE_PHONE_ACTIVATE.equals(operationtype)) {
			// 注册手机激活码续传递domainName
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	        String domainName = request.getParameter("domainName");
	        req.setDomainname(domainName);
		}
		boolean isOk = false;
		String code = "";
		String msg = "";
		//String resUid ="";
		
		
		UcMembersGetOperationcodeResponse res = DubboConsumerFactory
				.getService(IUcMembersOperationSV.class)
				.ucGetOperationcode(req);
		
		
		LOG.info("ucenter 生成验证码返回：" + res);
		if (res != null && res.getMessage() != null
				&& res.getMessage().isSuccess() && res.getCode() != null
				&& res.getCode().getCodeNumber() != null) {
			if (res.getCode().getCodeNumber() == 1) {
				isOk = true;
				code = res.getDate().get("operationcode") + "";
				//resUid =res.getDate().get("uid") + "";
			} else {
				msg = res.getCode().getCodeMessage();
			}

		}

		return new Object[] { isOk, code, msg};
	}

}
