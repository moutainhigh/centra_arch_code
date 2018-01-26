package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcCustKeyInfo {
    private String tenantId;

    private String userId;

    private String userType;

    private String custName;

    private String certType;

    private String certNum;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String certAddr;

    private Timestamp certIssueDate;

    private String certIssueOrg;

    private Timestamp certValidDate;

    private Timestamp certInvalidDate;

    private String custSex;

    private Timestamp custBirthday;

    private String custProvinceCode;

    private String custCityCode;

    private String custCountyCode;

    private String custAddr;

    private String incomeLevel;

    private String custIndustry;

    private String custEducation;

    private Timestamp createTime;

    private String createChlId;

    private Long createOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private Long updateOperId;

    private String personalRemark;

    private String verifyFlag;

    private String auditState;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum == null ? null : certNum.trim();
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

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getCertAddr() {
        return certAddr;
    }

    public void setCertAddr(String certAddr) {
        this.certAddr = certAddr == null ? null : certAddr.trim();
    }

    public Timestamp getCertIssueDate() {
        return certIssueDate;
    }

    public void setCertIssueDate(Timestamp certIssueDate) {
        this.certIssueDate = certIssueDate;
    }

    public String getCertIssueOrg() {
        return certIssueOrg;
    }

    public void setCertIssueOrg(String certIssueOrg) {
        this.certIssueOrg = certIssueOrg == null ? null : certIssueOrg.trim();
    }

    public Timestamp getCertValidDate() {
        return certValidDate;
    }

    public void setCertValidDate(Timestamp certValidDate) {
        this.certValidDate = certValidDate;
    }

    public Timestamp getCertInvalidDate() {
        return certInvalidDate;
    }

    public void setCertInvalidDate(Timestamp certInvalidDate) {
        this.certInvalidDate = certInvalidDate;
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex == null ? null : custSex.trim();
    }

    public Timestamp getCustBirthday() {
        return custBirthday;
    }

    public void setCustBirthday(Timestamp custBirthday) {
        this.custBirthday = custBirthday;
    }

    public String getCustProvinceCode() {
        return custProvinceCode;
    }

    public void setCustProvinceCode(String custProvinceCode) {
        this.custProvinceCode = custProvinceCode == null ? null : custProvinceCode.trim();
    }

    public String getCustCityCode() {
        return custCityCode;
    }

    public void setCustCityCode(String custCityCode) {
        this.custCityCode = custCityCode == null ? null : custCityCode.trim();
    }

    public String getCustCountyCode() {
        return custCountyCode;
    }

    public void setCustCountyCode(String custCountyCode) {
        this.custCountyCode = custCountyCode == null ? null : custCountyCode.trim();
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr == null ? null : custAddr.trim();
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel == null ? null : incomeLevel.trim();
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry == null ? null : custIndustry.trim();
    }

    public String getCustEducation() {
        return custEducation;
    }

    public void setCustEducation(String custEducation) {
        this.custEducation = custEducation == null ? null : custEducation.trim();
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
        this.createChlId = createChlId == null ? null : createChlId.trim();
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId == null ? null : updateChlId.trim();
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

    public String getPersonalRemark() {
        return personalRemark;
    }

    public void setPersonalRemark(String personalRemark) {
        this.personalRemark = personalRemark == null ? null : personalRemark.trim();
    }

    public String getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(String verifyFlag) {
        this.verifyFlag = verifyFlag == null ? null : verifyFlag.trim();
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState == null ? null : auditState.trim();
    }
}