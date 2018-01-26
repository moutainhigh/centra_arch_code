package com.ai.slp.user.api.apiinfo.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 企业、代理商申请API信息表 <br>
 * Date: 2016年4月19日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */

public class UcApiInfoParams extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * APIId
     */
    private String apiSeqId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * API名称
     */
    private String apiName;

    /**
     * API类型
     */
    private String apiType;

    /**
     * API场景描述
     */
    private String apiInfo;

    /**
     * 网站地址
     */
    private String webAddr;

    /**
     * IP白名单
     */
    private String ipAddr;

    /**
     * 开通服务串
     */
    private String operService;

    /**
     * SECRET_KEY
     */
    private String secretKey;

    /**
     * API_KEY
     */
    private String apiKey;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人证件类型
     */
    private String contactCretType;

    /**
     * 联系人证件号码
     */
    private String contactCretNum;

    /**
     * 联系人微信ID
     */
    private String contactWxId;

    /**
     * 联系人手机号码
     */
    private String contactMp;

    /**
     * 联系人EMAIL
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
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建渠道
     */
    private String createChlId;

    /**
     * 创建员工
     */
    private Long createOperId;

    /**
     * 修改渠道
     */
    private String updateChlId;

    /**
     * 修改员工
     */
    private Long updateOperId;

    public String getApiSeqId() {
        return apiSeqId;
    }

    public void setApiSeqId(String apiSeqId) {
        this.apiSeqId = apiSeqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(String apiInfo) {
        this.apiInfo = apiInfo;
    }

    public String getWebAddr() {
        return webAddr;
    }

    public void setWebAddr(String webAddr) {
        this.webAddr = webAddr;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getOperService() {
        return operService;
    }

    public void setOperService(String operService) {
        this.operService = operService;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCretType() {
        return contactCretType;
    }

    public void setContactCretType(String contactCretType) {
        this.contactCretType = contactCretType;
    }

    public String getContactCretNum() {
        return contactCretNum;
    }

    public void setContactCretNum(String contactCretNum) {
        this.contactCretNum = contactCretNum;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateChlId() {
        return createChlId;
    }

    public void setCreateChlId(String createChlId) {
        this.createChlId = createChlId;
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
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
