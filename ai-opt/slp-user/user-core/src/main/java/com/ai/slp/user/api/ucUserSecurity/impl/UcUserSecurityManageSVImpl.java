package com.ai.slp.user.api.ucUserSecurity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.ucUserSecurity.interfaces.IUcUserSecurityManageSV;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserEmailRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserPasswordRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserPhoneRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UpdatePasswordRequest;
import com.ai.slp.user.constants.ExceptCodeConstants;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.service.business.interfaces.IUcUserBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class UcUserSecurityManageSVImpl implements IUcUserSecurityManageSV {

	@Autowired
	IUcUserBusiSV iAccountBusiSV;

	@Override
	public BaseResponse setEmailData(UcUserEmailRequest emailModifyRequest) throws BusinessException,SystemException {
		/*// 入参检查
		iVoValidateSV.validateSetAccountEmail(emailModifyRequest);*/
		// 整理数据
		UcUser gnAccount = new UcUser();
		BeanUtils.copyProperties(gnAccount, emailModifyRequest);
		return updateAccountById(gnAccount,"邮箱");
	}

	@Override
	public BaseResponse setPasswordData(UcUserPasswordRequest passwordModifyRequest) throws BusinessException,SystemException {
		//iVoValidateSV.validateSetAccountPwd(passwordModifyRequest);
		// 整理数据
	    UcUser gnAccount = new UcUser();
	    gnAccount.setTenantId(passwordModifyRequest.getTenantId());
	    gnAccount.setUserId(passwordModifyRequest.getAccountId());
	    gnAccount.setUserLoginPwd(passwordModifyRequest.getAccountPassword());
	    gnAccount.setCreateOperId(passwordModifyRequest.getUpdateAccountId());
		return updateAccountById(gnAccount,"密码");
	}

	@Override
	public BaseResponse setPhoneData(UcUserPhoneRequest phoneModifyRequest) throws BusinessException,SystemException {
		//iVoValidateSV.validateSetPhoneTenant(phoneModifyRequest);
		// 整理数据
		UcUser gnAccount = new UcUser();
		gnAccount.setTenantId(phoneModifyRequest.getTenantId());
		gnAccount.setUserMp(phoneModifyRequest.getPhone());
		gnAccount.setUserId(phoneModifyRequest.getAccountId());
		gnAccount.setUpdateOperId(phoneModifyRequest.getUpdateAccountId());
		return updateAccountById(gnAccount,"电话");
	}

	    @Override
	    public BaseResponse updatePassword(UpdatePasswordRequest updatePasswordRequest)
	            throws BusinessException, SystemException {
	        UcUser gnAccount = new UcUser();
	        BeanUtils.copyProperties(gnAccount, updatePasswordRequest);
	        return updateByAcountInfo(gnAccount);
	    }
	
	/**
	 * 根据账号ID更新账户信息
	 * 
	 * @param gnAccount
	 * @return
	 * @throws SystemException
	 */
	private BaseResponse updateAccountById(UcUser gnAccount,String message) throws SystemException {
	    UcUserCriteria example = new UcUserCriteria();
	    UcUserCriteria.Criteria criteria = example.createCriteria();
	    criteria.andTenantIdEqualTo(gnAccount.getTenantId());
	    criteria.andUserIdEqualTo(gnAccount.getUserId());
		gnAccount.setUpdateTime(DateUtil.getSysDate());
		int updateCount = iAccountBusiSV.updateByAccountId(gnAccount,example);
		BaseResponse baseResponse = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		if (updateCount > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.SUCCESS);
			responseHeader.setResultMessage(message+"更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.FAILD);
			responseHeader.setResultMessage(message+"更新失败");
		}
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

   

	/**
	 * 根据账户信息修改密码
	 * @return
	 * @author zhangqiang7
	 */
	private BaseResponse updateByAcountInfo(UcUser gnAccount){
	    UcUser ucUser = new UcUser();
	    ucUser.setUserLoginPwd(gnAccount.getUserLoginPwd());
	    
	    UcUserCriteria example = new UcUserCriteria();
	    UcUserCriteria.Criteria criteria = example.createCriteria();
	    criteria.andTenantIdEqualTo(gnAccount.getTenantId());
	    criteria.andUserTypeEqualTo(gnAccount.getUserType());
	    //判断账户类型
	    if (!StringUtil.isBlank(gnAccount.getUserLoginName())) {
            criteria.andUserLoginNameEqualTo(gnAccount.getUserLoginName());
        }
        if (!StringUtil.isBlank(gnAccount.getUserEmail())) {
            criteria.andUserEmailEqualTo(gnAccount.getUserEmail());
            criteria.andEmailValidateFlagEqualTo("11");
        }
        if (!StringUtil.isBlank(gnAccount.getUserMp())) {
            criteria.andUserMpEqualTo(gnAccount.getUserMp());
        }
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try{
        iAccountBusiSV.updateByAcountInfo(ucUser, example);
        responseHeader = new ResponseHeader(true,"success","更新成功");
        }catch(Exception e){
            responseHeader = new ResponseHeader(false,"fail","更新失败");
            e.printStackTrace();
        }
        response.setResponseHeader(responseHeader);
        return response;
	}
	
}
