package com.ai.slp.user.api.register.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 注册用户信息参数 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class RegisterParamsRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;
    /**
     * 用户联系人
     */
    private UcContactInfoParams ucContactInfoParams;
    /**
     * 个人用户
     */
    private UcUserParams ucUserParam;

    /**
     * 企业客户信息
     */
    private UcGroupKeyInfoParams ucGroupKeyInfoParams;
    /**
     * 个人客户关键信息
     */
    private UcCustKeyInfoParams ucCustKeyInfoParams;

    /**
     * 用户银行信息
     */
    private UcBankKeyInfoParams ucBankKeyParams;
    /**
     * 用户协议信息
     */
    private UcUserAgreeParams agreeInfoParams;

    public UcContactInfoParams getUcContactInfoParams() {
        return ucContactInfoParams;
    }

    public void setUcContactInfoParams(UcContactInfoParams ucContactInfoParams) {
        this.ucContactInfoParams = ucContactInfoParams;
    }

    public UcUserParams getUcUserParam() {
        return ucUserParam;
    }

    public void setUcUserParam(UcUserParams ucUserParam) {
        this.ucUserParam = ucUserParam;
    }

    public UcGroupKeyInfoParams getUcGroupKeyInfoParams() {
        return ucGroupKeyInfoParams;
    }

    public void setUcGroupKeyInfoParams(UcGroupKeyInfoParams ucGroupKeyInfoParams) {
        this.ucGroupKeyInfoParams = ucGroupKeyInfoParams;
    }

    public UcCustKeyInfoParams getUcCustKeyInfoParams() {
        return ucCustKeyInfoParams;
    }

    public void setUcCustKeyInfoParams(UcCustKeyInfoParams ucCustKeyInfoParams) {
        this.ucCustKeyInfoParams = ucCustKeyInfoParams;
    }

    public UcBankKeyInfoParams getUcBankKeyParams() {
        return ucBankKeyParams;
    }

    public void setUcBankKeyParams(UcBankKeyInfoParams ucBankKeyParams) {
        this.ucBankKeyParams = ucBankKeyParams;
    }

    public UcUserAgreeParams getAgreeInfoParams() {
        return agreeInfoParams;
    }

    public void setAgreeInfoParams(UcUserAgreeParams agreeInfoParams) {
        this.agreeInfoParams = agreeInfoParams;
    }

}
