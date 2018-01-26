package com.ifudata.ic.sso.service;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.data.api.user.interfaces.ILoginSV;
import com.ifudata.ic.data.api.user.param.UserLoginResponse;
import com.ifudata.ic.sso.principal.BssCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 加载账号信息服务（Dubbo服务）
 *
 * Date: 2016年3月17日 <br>
 * Copyright (c) 2016 ifudata.com <br>
 * @author wangyongxin
 */
@Service
public class LoadAccountService {

	private static final Logger LOG = LoggerFactory.getLogger(LoadAccountService.class);
	
	@Autowired
	private ILoginSV iLoginSV;

	/**
	 * 加载账号信息
	 * 
	 * @param bssCredentials
	 * @throws SystemException
	 */
	public UserLoginResponse loadAccount(BssCredentials bssCredentials)
			throws SystemException {
		UserLoginResponse user = null;
		if (bssCredentials != null) {
			user= iLoginSV.queryUserByUserName(bssCredentials.getUsername());
		} // end if
		
		return user;
	}// end

}
