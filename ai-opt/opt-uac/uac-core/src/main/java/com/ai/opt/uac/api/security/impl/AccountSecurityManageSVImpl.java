package com.ai.opt.uac.api.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.IAccountBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountSecurityManageSVImpl implements IAccountSecurityManageSV {

	@Autowired
	IAccountBusiSV iAccountBusiSV;
	@Autowired
	IVoValidateSV iVoValidateSV;

	@Override
	public BaseResponse setEmailData(AccountEmailRequest emailModifyRequest) throws BusinessException,SystemException {
		// 入参检查
		iVoValidateSV.validateSetAccountEmail(emailModifyRequest);
		// 整理数据
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, emailModifyRequest);
		return updateAccountById(gnAccount,"邮箱");
	}

	@Override
	public BaseResponse setPasswordData(AccountPasswordRequest passwordModifyRequest) throws BusinessException,SystemException {
		iVoValidateSV.validateSetAccountPwd(passwordModifyRequest);
		// 整理数据
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, passwordModifyRequest);
		return updateAccountById(gnAccount,"密码");
	}

	@Override
	public BaseResponse setPhoneData(AccountPhoneRequest phoneModifyRequest) throws BusinessException,SystemException {
		iVoValidateSV.validateSetPhoneTenant(phoneModifyRequest);
		// 整理数据
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, phoneModifyRequest);
		return updateAccountById(gnAccount,"电话");
	}

	/**
	 * 根据账号ID更新账户信息
	 * 
	 * @param gnAccount
	 * @return
	 * @throws SystemException
	 */
	private BaseResponse updateAccountById(GnAccount gnAccount,String message) throws SystemException {
		gnAccount.setUpdateTime(DateUtil.getSysDate());
		int updateCount = iAccountBusiSV.updateByAccountId(gnAccount);
		BaseResponse baseResponse = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		if (updateCount > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage(message+"更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage(message+"更新失败");
		}
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

}
