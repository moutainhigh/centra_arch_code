/*
package com.ifudata.ums.system.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ifudata.crm.system.coremodel.SessionInfo;
import com.ifudata.crm.system.util.ConfigUtil;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnMenuVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnStaffVo;

public class CommFunc {

	public static boolean hasRight(HttpServletRequest request, String url) {
	    GnStaffVo operInfo = SessionInfo.getOperInfo(request);

		if (operInfo == null || operInfo.getGnOperVo().getMenuList() == null
				|| operInfo.getGnOperVo().getMenuList().isEmpty()) {
			return false;
		}
		
		Set<String> menus = new HashSet<String>();
		for(GnMenuVo menu : operInfo.getGnOperVo().getMenuList()){
		    if(StringUtils.isNotBlank(menu.getMenuUrl()))
		        menus.add(menu.getMenuUrl());
		}
		// URL的控制级别，如果为“1”则只校验“？”前部分的URL（如果包住“！”，则只取前面的）；如果为2则必须完全匹配才允许访问,默认为2

		*/
/** 获取request中原始的url **//*

		String exactUrl = url.contains("?") ? url + "&"
				+ request.getQueryString() : (url + "?" + request
				.getQueryString());

		if (menus.contains(url)) {// 能找到完全对应的URL
			return true;
		} else if ("1".equals(ConfigUtil.getProperty("URL_CTL_LEVEL","1"))) {
			url = trimURL(url);
			Iterator<String> ite = menus.iterator();
			String registedUrl = null;
			while (ite.hasNext()) {
				registedUrl = ite.next();
				if (url.equals(trimURL(registedUrl))) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	public static String trimURL(String url) {
		if(url == null) {
			return "";
		}
		int index1 = url.indexOf("?");
		if(index1 != -1) {
			url = url.substring(0, index1);
		}
		int index2 = url.indexOf("!");
		if(index2 != -1) {
			url = url.substring(0, index2);
		}
		return url;
	}

}
*/
