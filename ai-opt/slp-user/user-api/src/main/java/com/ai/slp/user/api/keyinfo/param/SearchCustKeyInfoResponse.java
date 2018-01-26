package com.ai.slp.user.api.keyinfo.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class SearchCustKeyInfoResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户Id
	 */
	private String tenantId;

	/**
	 * 用户Id
	 */
	private String userId;

	/**
	 * 用户类型
	 */
	private String userType;

	/**
	 * 企业名称
	 */
	private String custName;

	/**
	 * 证件类型
	 */
	private String certType;

	/**
	 * 证件号码
	 */
	private String certNum;

	/**
	 * 证件地址归属省
	 */
	private String provinceCode;

	/**
	 * 证件地址归属地市
	 */
	private String cityCode;

	/**
	 * 证件地址归属区县
	 */
	private String countyCode;

	/**
	 * 证件地址详细信息
	 */
	private String certAddr;

	/**
	 * 发证日期
	 */
	private Timestamp certIssueDate;

	/**
	 * 发证机关
	 */
	private String certIssueOrg;

	/**
	 * 证件有效期(生效时间)
	 */
	private Timestamp certValidDate;

	/**
	 * 证件有效期(失效时间)
	 */
	private Timestamp certInvalidDate;

	/**
	 * 性别
	 */
	private String custSex;

	/**
	 * 个人介绍
	 */
	private String personalRemark;

	/**
	 * 生日
	 */
	private Timestamp custBirthday;

	/**
	 * 居住（联系）地址归属省
	 */
	private String custProvinceCode;

	/**
	 * 居住（联系）地址归属地市
	 */
	private String custCityCode;

	/**
	 * 居住（联系）地址归
	 */
	private String custCountyCode;

	/**
	 * 居住（联系）地址
	 */
	private String custAddr;

	/**
	 * 收入水平
	 */
	private String incomeLevel;

	/**
	 * 所属行业
	 */
	private String custIndustry;

	/**
	 * 学历
	 */
	private String custEducation;

	/**
	 * 创建渠道
	 */
	private String createChlId;

	/**
	 * 创建员工
	 */
	private Long createOperId;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 修改时间
	 */
	private Timestamp updateTime;

	/**
	 * 修改渠道
	 */
	private String updateChlId;

	/**
	 * 修改员工
	 */
	private Long updateOperId;

	/**
	 * 认证状态
	 */
	private String verifyFlag;

	// 审核状态
	private String auditState;

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCertAddr() {
		return certAddr;
	}

	public void setCertAddr(String certAddr) {
		this.certAddr = certAddr;
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
		this.certIssueOrg = certIssueOrg;
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
		this.custSex = custSex;
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
		this.custProvinceCode = custProvinceCode;
	}

	public String getCustCityCode() {
		return custCityCode;
	}

	public void setCustCityCode(String custCityCode) {
		this.custCityCode = custCityCode;
	}

	public String getCustCountyCode() {
		return custCountyCode;
	}

	public void setCustCountyCode(String custCountyCode) {
		this.custCountyCode = custCountyCode;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustEducation() {
		return custEducation;
	}

	public void setCustEducation(String custEducation) {
		this.custEducation = custEducation;
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
		this.updateChlId = updateChlId;
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
		this.personalRemark = personalRemark;
	}

	public String getVerifyFlag() {
		return verifyFlag;
	}

	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}

}
