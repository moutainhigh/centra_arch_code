/*
package com.ifudata.ums.system.base;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ifudata.base.vo.RequestHeader;
import com.ifudata.ums.system.config.ConstantsResultCode;
import com.ifudata.ums.system.coremodel.SessionInfo;
import com.ifudata.ums.system.exception.SystemException;
import com.ifudata.ums.system.session.SessionService;
import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;


public class CrmSessionLoadHandler implements SessionLoadHandler {

	private static String sessionCookieName = null;
	
	@Override
	public boolean isSessionLoaded(HttpServletRequest request,
			HttpServletResponse arg1) {
		return !SessionInfo.isSessionExp(request);
	}

	@Override
	public void loadSession(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				*/
/**
				 * 调用后厂服务封装操作员信息
				 *//*

				IGnStaffDubboSV gnStaffDubboSV = (IGnStaffDubboSV) BeanFactory.getBean("gnStaffDubboSV");
				if (gnStaffDubboSV != null) {
					StaffMaintainRequest staffRequest = new StaffMaintainRequest();
					RequestHeader header = new RequestHeader();
					header.setOperId(1l);
					staffRequest.setRequestHeader(header);
					String operCode = getCasUser(request);
					if(StringUtils.isBlank(operCode)){
						throw new SystemException("","",
								"单点登录 服务端未返回操作员信息",null);
					}
					staffRequest.setOperCode(operCode);
					StaffMaintainResponse staffResponse = gnStaffDubboSV.queryBusinessStaff(staffRequest);
					if (staffResponse != null) {
						String resultCode = staffResponse.getResponseHeader().getResultCode();
						// 调用服务 成功
						if (ConstantsResultCode.SUCCESS.equals(resultCode)) {
							SessionInfo.setOperInfo(request.getSession(), staffResponse.getGnStaffVo());
						} else {
							// 后厂返回 错误
							throw new SystemException(staffResponse.getResponseHeader().getResultCode(),"",
									staffResponse.getResponseHeader().getResultMessage(),null);
						}
					} else {
						throw new SystemException("","",
								"后厂无返回",null);
					}

				}else{
					throw new SystemException("","",
							"获取后厂服务为空",null);
				}

	}

	*/
/**
	 * 获取单点登录服务端 传过来的operCode
	 * 
	 * @param request
	 * @return
	 *//*

	private String getCasUser(HttpServletRequest request) {
		String operCode = request.getRemoteUser();
		if(StringUtils.isBlank(operCode)){
		        final HttpSession session = request.getSession(false);
		        final Assertion assertion = (Assertion) (session == null ? request
		                .getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : session
		                .getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));
		        operCode = (assertion == null ? null : assertion.getPrincipal().getName());
		}
		return operCode;
	}
	
	*/
/**
	 * 单点登出时 删除本项目的内存、redis中的session
	 *//*

	public void removeSession(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String sid = getRequestedSessionId(request, response);
			if (null != sid) {
				SessionService.getInstance().removeSession(sid);
			}
			request.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getRequestedSessionId(HttpServletRequest request,
			HttpServletResponse response) {
		// String cookid=request.getRequestedSessionId();
		// System.out.println(cookid);
		Cookie[] cookies = request.getCookies();
		String sessionId = null;
		if ((cookies == null) || (cookies.length == 0))
			return null;
		for (Cookie cookie : cookies) {
			if (sessionCookieName.equals(cookie.getName()))
				sessionId = cookie.getValue();
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return sessionId;
	}
	
	static {

		try {
			sessionCookieName = CacheConfig
					.getString("redis.session.jsessionidincookie");
			if (StringUtils.isBlank(sessionCookieName)) {
				throw new Exception(
						"cache.propeties未配置redis.session.jsessionidincookie参数");
			}
		} catch (Exception e) {
			sessionCookieName = "JSESSIONID_IN_COOKIE";
		}

	}

}
*/
