package com.ai.opt.uac.api.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.uac.util.AccountSeqUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation="true")
@Component
public class RegisterSVImpl implements IRegisterSV {
    @Autowired
    private IRegisterBusiSV iRegisterBusiSV;
    @Autowired
	IVoValidateSV iVoValidateSV;
    

    @Override
    public PhoneRegisterResponse registerByPhone(PhoneRegisterRequest request)
            throws BusinessException,SystemException {
        iVoValidateSV.validateRegister(request);
        // 设置默认值
        GnAccount account = new GnAccount();
        BeanUtils.copyProperties(account, request);
        account.setState(AccountConstants.Account.ACCOUNT_STATE);
        account.setNickName(AccountSeqUtil.createNickName());
        account.setAccountType(AccountConstants.Account.ACCOUNT_TYPE);
        account.setAccountLevel(AccountConstants.Account.ACCOUNT_LEVEL);
        account.setActiveTime(DateUtil.getSysDate());
        account.setInactiveTime(DateUtil.getTimestamp(AccountConstants.Account.INACTIVE_DATE,DateUtil.DATETIME_FORMAT));
        account.setCreateTime(DateUtil.getSysDate());
        long accountId = iRegisterBusiSV.registerByPhone(account);
        PhoneRegisterResponse response = new PhoneRegisterResponse();
        ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "成功");
        response.setAccountId(accountId);
        response.setResponseHeader(responseHeader);
        return response;
    }

}
