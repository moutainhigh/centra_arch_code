package com.ai.slp.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOrder {
    private long orderId;

    private String tenantId;

    private String busiCode;

    private String orderType;

    private String subFlag;

    private long parentOrderId;

    private long batchNo;

    private String userId;

    private long acctId;

    private long subsId;

    private String supplierId;

    private String storageId;

    private String routeId;

    private String provinceCode;

    private String cityCode;

    private String state;

    private Timestamp stateChgTime;

    private String displayFlag;

    private Timestamp displayFlagChgTime;

    private String deliveryFlag;

    private String lockFlag;

    private Timestamp lockTime;

    private Timestamp orderTime;

    private long sellerId;

    private String chlId;

    private String operId;

    private String workflowId;

    private String reasonType;

    private String reasonDesc;

    private Timestamp finishTime;

    private long origOrderId;

    private String orderDesc;

    private String keywords;

    private String remark;

    private String externalOrderId;

    private String externalSupplyId;

    private String downstreamOrderId;

    private String userType;

    private String ipAddress;

    private String ifWarning;

    private String warningType;

    private String cusServiceFlag;

    private String accountId;

    private String flag;

    private String tokenId;

    private String userName;

    private String userTel;

    private String pointRate;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode == null ? null : busiCode.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getSubFlag() {
        return subFlag;
    }

    public void setSubFlag(String subFlag) {
        this.subFlag = subFlag == null ? null : subFlag.trim();
    }

    public long getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(long parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(long batchNo) {
        this.batchNo = batchNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public long getAcctId() {
        return acctId;
    }

    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Timestamp getStateChgTime() {
        return stateChgTime;
    }

    public void setStateChgTime(Timestamp stateChgTime) {
        this.stateChgTime = stateChgTime;
    }

    public String getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(String displayFlag) {
        this.displayFlag = displayFlag == null ? null : displayFlag.trim();
    }

    public Timestamp getDisplayFlagChgTime() {
        return displayFlagChgTime;
    }

    public void setDisplayFlagChgTime(Timestamp displayFlagChgTime) {
        this.displayFlagChgTime = displayFlagChgTime;
    }

    public String getDeliveryFlag() {
        return deliveryFlag;
    }

    public void setDeliveryFlag(String deliveryFlag) {
        this.deliveryFlag = deliveryFlag == null ? null : deliveryFlag.trim();
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag == null ? null : lockFlag.trim();
    }

    public Timestamp getLockTime() {
        return lockTime;
    }

    public void setLockTime(Timestamp lockTime) {
        this.lockTime = lockTime;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId == null ? null : chlId.trim();
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId == null ? null : workflowId.trim();
    }

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonType) {
        this.reasonType = reasonType == null ? null : reasonType.trim();
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc == null ? null : reasonDesc.trim();
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public long getOrigOrderId() {
        return origOrderId;
    }

    public void setOrigOrderId(long origOrderId) {
        this.origOrderId = origOrderId;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? null : orderDesc.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId == null ? null : externalOrderId.trim();
    }

    public String getExternalSupplyId() {
        return externalSupplyId;
    }

    public void setExternalSupplyId(String externalSupplyId) {
        this.externalSupplyId = externalSupplyId == null ? null : externalSupplyId.trim();
    }

    public String getDownstreamOrderId() {
        return downstreamOrderId;
    }

    public void setDownstreamOrderId(String downstreamOrderId) {
        this.downstreamOrderId = downstreamOrderId == null ? null : downstreamOrderId.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getIfWarning() {
        return ifWarning;
    }

    public void setIfWarning(String ifWarning) {
        this.ifWarning = ifWarning == null ? null : ifWarning.trim();
    }

    public String getWarningType() {
        return warningType;
    }

    public void setWarningType(String warningType) {
        this.warningType = warningType == null ? null : warningType.trim();
    }

    public String getCusServiceFlag() {
        return cusServiceFlag;
    }

    public void setCusServiceFlag(String cusServiceFlag) {
        this.cusServiceFlag = cusServiceFlag == null ? null : cusServiceFlag.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId == null ? null : tokenId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getPointRate() {
        return pointRate;
    }

    public void setPointRate(String pointRate) {
        this.pointRate = pointRate == null ? null : pointRate.trim();
    }
}