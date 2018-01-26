package com.ai.slp.user.api.register.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 用户信息 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class UcContactInfoParams extends BaseInfo {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String contactSeqId;

    private String contactName;

    private String contactCertTy;

    private String contactCertNu;

    private String contactWxId;

    private String contactMp;

    private String contactEmail;

    private String contactAdress;

    private String groupZip;

    private String createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactSeqId() {
        return contactSeqId;
    }

    public void setContactSeqId(String contactSeqId) {
        this.contactSeqId = contactSeqId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCertTy() {
        return contactCertTy;
    }

    public void setContactCertTy(String contactCertTy) {
        this.contactCertTy = contactCertTy;
    }

    public String getContactCertNu() {
        return contactCertNu;
    }

    public void setContactCertNu(String contactCertNu) {
        this.contactCertNu = contactCertNu;
    }

    public String getContactWxId() {
        return contactWxId;
    }

    public void setContactWxId(String contactWxId) {
        this.contactWxId = contactWxId;
    }

    public String getContactMp() {
        return contactMp;
    }

    public void setContactMp(String contactMp) {
        this.contactMp = contactMp;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAdress() {
        return contactAdress;
    }

    public void setContactAdress(String contactAdress) {
        this.contactAdress = contactAdress;
    }

    public String getGroupZip() {
        return groupZip;
    }

    public void setGroupZip(String groupZip) {
        this.groupZip = groupZip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
