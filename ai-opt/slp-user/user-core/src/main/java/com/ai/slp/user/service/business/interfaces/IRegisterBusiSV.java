package com.ai.slp.user.service.business.interfaces;


import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.register.param.RegisterParamsRequest;
import com.ai.slp.user.api.register.param.UcBankKeyInfoParams;
import com.ai.slp.user.api.register.param.UcContactInfoParams;
import com.ai.slp.user.api.register.param.UcGroupKeyInfoParams;
import com.ai.slp.user.api.register.param.UcUserAgreeParams;
import com.ai.slp.user.api.register.param.UcUserParams;

public interface IRegisterBusiSV {
    
    public String insertUserInfo(RegisterParamsRequest registerParamsRequest);
    
    public void insertCompanyInfoAttest(RegisterParamsRequest registerParamsRequest);
    
    public boolean checkUserExist(UcUserParams userParams);
    
    public boolean checkUcGroupKeyExist(UcGroupKeyInfoParams ucGroupKeyInfoParams);
    
    public void insertAgentInfoAttest(RegisterParamsRequest registerParamsRequest);

   // public void updateUserInfo(UpdateUserParams updateUserParams);
    
    public void insertUserInfoAttest(RegisterParamsRequest registerParamsRequest);

}
