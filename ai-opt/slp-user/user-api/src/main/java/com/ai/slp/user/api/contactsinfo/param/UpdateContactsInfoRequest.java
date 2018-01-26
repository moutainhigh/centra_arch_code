package com.ai.slp.user.api.contactsinfo.param;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 更新用户联系人入参 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UpdateContactsInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id NOT NULL
     */
    @NotNull(message = "userId不能为空")
    private String userId;

    private String contactSeqId;

    /**
     * 状态
     */
    private String state;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人证件类型
     */
    private String contactCertType;

    /**
     * 联系人证件号码
     */
    private String contactCertNum;

    /**
     * 联系人微信Id
     */
    private String contactWxId;

    /**
     * 联系人电话
     */
    private String contactMp;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 联系人地址
     */
    private String contactAddress;

    /**
     * 联系人邮政编码
     */
    private String groupZip;

    /**
     * 联系人工作部门
     */
    private String contactDept;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新渠道
     */
    private String updateChlId;

    /**
     * 更新员工
     */
    private Long updateOperId;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCertType() {
        return contactCertType;
    }

    public void setContactCertType(String contactCertType) {
        this.contactCertType = contactCertType;
    }

    public String getContactCertNum() {
        return contactCertNum;
    }

    public void setContactCertNum(String contactCertNum) {
        this.contactCertNum = contactCertNum;
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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getGroupZip() {
        return groupZip;
    }

    public void setGroupZip(String groupZip) {
        this.groupZip = groupZip;
    }

    public String getContactDept() {
        return contactDept;
    }

    public void setContactDept(String contactDept) {
        this.contactDept = contactDept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId;
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

}
