package com.ai.opt.uac.web.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sso.client.filter.SSOClientUtil;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

@RequestMapping("/home")
@Controller
public class LoginJumpPageController {

	@RequestMapping("/index")
	public String JumpPageAfterLogin(HttpServletRequest request){
		//获取配置中心配置的登录页面
		String service_url="";
        try {
        	//service_url目前配置的是商城的首页。因为商城首页不需登录，无法获取session，所以url后面加上/login
            service_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.INDEX_URL_KEY)+"/login";
        } catch (ConfigException e) {
            e.printStackTrace();            
        }
		//若不存在 跳转默认页面
		if (StringUtil.isBlank(service_url)) {
			service_url = SSOClientUtil.getCasServerUrlPrefixRuntime(request);
		}
		return "redirect:"+service_url;
	}
}
