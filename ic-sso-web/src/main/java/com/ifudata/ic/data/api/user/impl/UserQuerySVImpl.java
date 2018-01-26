package com.ifudata.ic.data.api.user.impl;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.centra.sdk.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifudata.ic.data.api.user.interfaces.IUserQuerySV;
import com.ifudata.ic.data.api.user.param.UserQueryRequest;
import com.ifudata.ic.data.api.user.param.UserQueryResponse;
import com.ifudata.ic.data.constants.AccountConstants.ResultCode;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;
import com.ifudata.ic.data.service.busi.interfaces.IUserBusiSV;
import com.ifudata.ic.data.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class UserQuerySVImpl implements IUserQuerySV {

	@Autowired
	IUserBusiSV iUserBusiSV;
	@Autowired
	IVoValidateSV iVoValidateSV;

	@Override
	public UserQueryResponse queryBaseInfo(UserQueryRequest accountQueryRequest) throws BusinessException,SystemException {
		// 入参检查
		iVoValidateSV.validateQueryAccountBaseInfo(accountQueryRequest);
		// 查询数据
		String userId = accountQueryRequest.getUserId();
		SysUser sysUser = iUserBusiSV.queryByUserId(userId);
		// 整理返回对象
		UserQueryResponse response = new UserQueryResponse();
		if (sysUser != null) {
			BeanUtils.copyProperties(response, sysUser);
			response.setUserId(sysUser.getId());
			response.setLoginName(sysUser.getLoginName());
			response.setEmail(sysUser.getEmail());
			response.setMobile(sysUser.getMobile());
		}
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "数据查询成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

	
}
