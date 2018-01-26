package com.ai.slp.user.api.apiinfo.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 企业、代理商申请API创建服务请求 <br>
 * Date: 2016年4月19日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class InsertApiInfoRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id 不能为空
     */
    private String userId;

    /**
     * Api信息名称
     */
    private String apiName;

    /**
     * Api类型
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
     * 服务
     */
    private String operService;

    /**
     * 安全码
     */
    private String secretKey;

    /**
     * API码
     */
    private String apiKey;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人证件类型
     */
    private String contactCertType;

    /**
     * 联系人证件号
     */
    private String contactCertNum;

    /**
     * 联系人微信号
     */
    private String contactWxId;

    /**
     * 联系手机号
     */
    private String contactMp;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 联系人邮政编码
     */
    private String groupZip;

    /**
     * 联系人部门
     */
    private String contactDept;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建渠道
     */
    private String createChlId;

    /**
     * 创建员工
     */
    private Long createOperId;

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

}
