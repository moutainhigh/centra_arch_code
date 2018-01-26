package com.ifudata.smsrest.db.mapper.bo;

import java.sql.Timestamp;

public class SubsUser {
    private Long subsUniqueId;

    private Long subsId;

    private Long custId;

    private Long acctId;

    private String acctType;

    private Long userCustId;

    private String serviceNum;

    private String imsi;

    private String simType;

    private String sim;

    private String basicOrgId;

    private String svcPwd;

    private String svcType;

    private String userType;

    private String subsStatus;

    private Timestamp joinTime;

    private Timestamp normalizeTime;

    private String serviceStatus;

    private String statusChgType;

    private Timestamp statusChgTime;

    private String lastServiceStatus;

    private Timestamp lastStatusChgTime;

    private String lastStatusChgType;

    private String provinceCode;

    private String cityCode;

    private Timestamp createTime;

    private String optChlId;

    private Long optOperId;

    private String chlId;

    private Long devId;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String remark;

    private String acctName;

    private String svcProductType;

    public Long getSubsUniqueId() {
        return subsUniqueId;
    }

    public void setSubsUniqueId(Long subsUniqueId) {
        this.subsUniqueId = subsUniqueId;
    }

    public Long getSubsId() {
        return subsId;
    }

    public void setSubsId(Long subsId) {
        this.subsId = subsId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    public Long getUserCustId() {
        return userCustId;
    }

    public void setUserCustId(Long userCustId) {
        this.userCustId = userCustId;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum == null ? null : serviceNum.trim();
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType == null ? null : simType.trim();
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim == null ? null : sim.trim();
    }

    public String getBasicOrgId() {
        return basicOrgId;
    }

    public void setBasicOrgId(String basicOrgId) {
        this.basicOrgId = basicOrgId == null ? null : basicOrgId.trim();
    }

    public String getSvcPwd() {
        return svcPwd;
    }

    public void setSvcPwd(String svcPwd) {
        this.svcPwd = svcPwd == null ? null : svcPwd.trim();
    }

    public String getSvcType() {
        return svcType;
    }

    public void setSvcType(String svcType) {
        this.svcType = svcType == null ? null : svcType.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getSubsStatus() {
        return subsStatus;
    }

    public void setSubsStatus(String subsStatus) {
        this.subsStatus = subsStatus == null ? null : subsStatus.trim();
    }

    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    public Timestamp getNormalizeTime() {
        return normalizeTime;
    }

    public void setNormalizeTime(Timestamp normalizeTime) {
        this.normalizeTime = normalizeTime;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus == null ? null : serviceStatus.trim();
    }

    public String getStatusChgType() {
        return statusChgType;
    }

    public void setStatusChgType(String statusChgType) {
        this.statusChgType = statusChgType == null ? null : statusChgType.trim();
    }

    public Timestamp getStatusChgTime() {
        return statusChgTime;
    }

    public void setStatusChgTime(Timestamp statusChgTime) {
        this.statusChgTime = statusChgTime;
    }

    public String getLastServiceStatus() {
        return lastServiceStatus;
    }

    public void setLastServiceStatus(String lastServiceStatus) {
        this.lastServiceStatus = lastServiceStatus == null ? null : lastServiceStatus.trim();
    }

    public Timestamp getLastStatusChgTime() {
        return lastStatusChgTime;
    }

    public void setLastStatusChgTime(Timestamp lastStatusChgTime) {
        this.lastStatusChgTime = lastStatusChgTime;
    }

    public String getLastStatusChgType() {
        return lastStatusChgType;
    }

    public void setLastStatusChgType(String lastStatusChgType) {
        this.lastStatusChgType = lastStatusChgType == null ? null : lastStatusChgType.trim();
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getOptChlId() {
        return optChlId;
    }

    public void setOptChlId(String optChlId) {
        this.optChlId = optChlId == null ? null : optChlId.trim();
    }

    public Long getOptOperId() {
        return optOperId;
    }

    public void setOptOperId(Long optOperId) {
        this.optOperId = optOperId;
    }

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId == null ? null : chlId.trim();
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getSvcProductType() {
        return svcProductType;
    }

    public void setSvcProductType(String svcProductType) {
        this.svcProductType = svcProductType == null ? null : svcProductType.trim();
    }
}