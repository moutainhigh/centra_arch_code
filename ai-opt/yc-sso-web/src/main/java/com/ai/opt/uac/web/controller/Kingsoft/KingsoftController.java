package com.ai.opt.uac.web.controller.Kingsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.support.pac4j.plugin.common.ThirdLoginConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.constants.ThirdUserConstants;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.util.Md5Util;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sdk.web.model.ResponseData;
import com.ai.opt.sso.client.filter.SSOClientConstants;
import com.ai.opt.uac.web.constants.Constants.kingsoftLogin;
import com.ai.opt.uac.web.model.ssoclient.GeneralSSOClientUser;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/kingsoft")
@Controller
public class KingsoftController{
	private static final Logger LOG = LoggerFactory.getLogger(KingsoftController.class);
	
	 @Autowired
	private static ILoginSV iLoginSV;
	static String kingKey = ThirdLoginConfigUtil.getKingSoftConfig().getAppid();
	static String kingSecret = ThirdLoginConfigUtil.getKingSoftConfig().getSecret();
	
	//金山登录接口
	private static String loginInterface = "http://my.iciba.com/index.php?c=sso&m=login";
	//金山校验用户名接口
	private static String userCheckInterface = "http://my.iciba.com/index.php?c=sso&m=username_check";
	//金山登录验证接口(获取用户登录信息)
	private static String loginCheckInterface = "http://my.iciba.com/index.php?c=sso&m=check_ck";
		
	
	@RequestMapping(value = "/kingsoftLogin", method = RequestMethod.POST)
	@ResponseBody
	public static ResponseData<Boolean> kingsoftLogin(HttpServletRequest request,String username, String password, String verifyCode){
		ResponseData<Boolean> response = new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
				"登陆成功", true);
		//校验验证码
		ResponseData<Boolean> result = checkImageVerifyCode(request, verifyCode);
		if (ResponseData.AJAX_STATUS_FAILURE.equals(result.getStatusCode())
				|| !result.getData()) {// 图片验证码校验
			response.setData(true);
			response.setResponseHeader(result.getResponseHeader());
			response.setStatusCode(result.getStatusCode());
			response.setStatusInfo(result.getStatusInfo());
			return response;
		}
		
		String param = getCommonParam()+"&username="+username+"&password="+ Md5Util.md5(password);
		JSONObject jsonObj = JSONObject.parseObject(sendPost(loginInterface, param));
		if (jsonObj == null) {
			response= new ResponseData<Boolean>(ResponseData.AJAX_STATUS_SUCCESS,
					"登陆信息有误", true);
			return response;
		}else {
		
			//金山用户登录信息正确  -- 把信息存入 session
			String kingsoftUid = (String) jsonObj.get("uid");
			String kingsoftUsername="KINGSOFT_"+kingsoftUid;
			UcMembers ucMembers=new UcMembers();
			ucMembers.setUsersource(ThirdUserConstants.UserSource.KINGSOFT);
			ucMembers.setThirduid(kingsoftUid);
			ucMembers.setUsername(kingsoftUsername);
			String uid=iLoginSV.bindThirdUser(ucMembers);
			
			GeneralSSOClientUser kingSoftUser = new GeneralSSOClientUser();
			kingSoftUser.setUserId(uid);
			kingSoftUser.setLoginName(kingsoftUsername);
			kingSoftUser.setUsername(kingsoftUsername);
			kingSoftUser.setDomainname("CN");
			request.getSession().setAttribute(SSOClientConstants.USER_SESSION_KEY, kingSoftUser);
			
		}
		return response;
	}
	
	public static JSONObject loginCheckToKing(String ck){
		String param = "ck="+ck;
		JSONObject jsonObj = JSONObject.parseObject(sendPost(loginCheckInterface, param));
		return jsonObj;
	}
	
	public static String getCommonParam(){
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

	public static String sendPost(String url, String param) {
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
			LOG.error("发送 POST 请求出现异常!" + e);
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
	
}
