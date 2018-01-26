package com.ai.slp.user.api.register.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 用户信息 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class UcUserAgreeParams extends BaseInfo {

    private static final long serialVersionUID = 1L;

    private String agreeSeqId;

    private String userId;

    private String agreementId;

    private Timestamp subsTime;

    public String getAgreeSeqId() {
        return agreeSeqId;
    }

    public void setAgreeSeqId(String agreeSeqId) {
        this.agreeSeqId = agreeSeqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Timestamp getSubsTime() {
        return subsTime;
    }

    public void setSubsTime(Timestamp subsTime) {
        this.subsTime = subsTime;
    }

}
