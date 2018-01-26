package com.ifudata.ic.data.api.user.impl;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.centra.sdk.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifudata.ic.data.api.user.interfaces.ILoginSV;
import com.ifudata.ic.data.api.user.param.UserLoginResponse;
import com.ifudata.ic.data.constants.AccountConstants.ResultCode;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;
import com.ifudata.ic.data.service.busi.interfaces.ILoginBusiSV;
import com.ifudata.ic.data.service.busi.interfaces.IVoValidateSV;
import com.ifudata.ic.data.util.RegexUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class LoginSVImpl implements ILoginSV {
    @Autowired
    private ILoginBusiSV iLoginBusiSV;
    @Autowired
	IVoValidateSV iVoValidateSV;

    @Override
    public UserLoginResponse queryUserByUserName(String username)
            throws BusinessException,SystemException {
        iVoValidateSV.validateLogin(username);
        // 判断用户名是手机还是邮箱
        boolean isEmial = RegexUtils.checkIsEmail(username);
        boolean isPhone = RegexUtils.checkIsPhone(username);
        SysUser account = new SysUser();
        if (isPhone == true) {
            account.setMobile(username);
        }else if (isEmial == true) {
            account.setEmail(username);
        }else{
            account.setLoginName(username); 
        }
        SysUser sysUser = iLoginBusiSV.queryByUserName(account);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (sysUser != null) {
            BeanUtils.copyProperties(response, sysUser);
            response.setUserId(sysUser.getId());
			response.setLoginName(sysUser.getLoginName());
			response.setEmail(sysUser.getEmail());
			response.setMobile(sysUser.getMobile());
			response.setLoginPassword(sysUser.getPassword());
			//add by zhouxh
			response.setLoginFlag(sysUser.getLoginFlag());
			response.setDelFlag(sysUser.getDelFlag());
			response.setEffectiveDate(sysUser.getEffectiveDate());
			response.setEffectiveDate(sysUser.getEffectiveDate());
			
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(false, ResultCode.FAIL_CODE,
                    "用户不存在");
            response.setResponseHeader(responseHeaders);
        }
        return response;
    }


}
