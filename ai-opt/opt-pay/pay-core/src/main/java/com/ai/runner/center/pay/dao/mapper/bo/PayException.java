package com.ai.runner.center.pay.dao.mapper.bo;

import java.sql.Timestamp;

public class PayException {
    private Long payId;

    private String tenantId;

    private String orderId;

    private String tradeOrderId;

    private String subject;

    private String requestSource;

    private Integer payRequestType;

    private Long payAmount;

    private String currencyUnit;

    private String payOrgId;

    private String payOrgSerial;

    private String notifyUrl;

    private String returnUrl;

    private Timestamp createTime;

    private Integer status;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTradeOrderId() {
        return tradeOrderId;
    }

    public void setTradeOrderId(String tradeOrderId) {
        this.tradeOrderId = tradeOrderId == null ? null : tradeOrderId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource == null ? null : requestSource.trim();
    }

    public Integer getPayRequestType() {
        return payRequestType;
    }

    public void setPayRequestType(Integer payRequestType) {
        this.payRequestType = payRequestType;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public String getPayOrgId() {
        return payOrgId;
    }

    public void setPayOrgId(String payOrgId) {
        this.payOrgId = payOrgId == null ? null : payOrgId.trim();
    }

    public String getPayOrgSerial() {
        return payOrgSerial;
    }

    public void setPayOrgSerial(String payOrgSerial) {
        this.payOrgSerial = payOrgSerial == null ? null : payOrgSerial.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}