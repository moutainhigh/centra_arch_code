package com.ai.slp.user.api.keyinfo.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class SearchGroupUserInfoResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户ID
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
	 * 营业执照注册号
	 */
	private String certNum;

	/**
	 * 企业名称
	 */
	private String custName;

	/**
	 * 企业注册地址归属省
	 */
	private String provinceCode;

	/**
	 * 企业注册地址归属地
	 */
	private String cityCode;

	/**
	 * 企业注册地址归属区县
	 */
	private String countyCode;

	/**
	 * 企业注册地址详细信息
	 */
	private String certAddr;

	/**
	 * 发证日期（注册时间）
	 */
	private Timestamp certIssueDate;

	/**
	 * 注册资本（万元）
	 */
	private Long registeredCapitals;

	/**
	 * 证件有效期(生效时间)
	 */
	private Timestamp certValidDate;

	/**
	 * 证件有效期(失效时间)
	 */
	private Timestamp certInvalidDate;

	/**
	 * 是否有官网标志
	 */
	private String webFlag;

	/**
	 * 官方网址
	 */
	private String groupWebsite;

	/**
	 * 公司人数
	 */
	private String groupMemberScale;

	/**
	 * 企业性质
	 */
	private String groupType;

	/**
	 * 所属行业
	 */
	private String groupIndustry;

	/**
	 * 经营范围
	 */
	private String groupBusinessScope;

	/**
	 * 主要产品
	 */
	private String groupProduct;

	/**
	 * 法人代表
	 */
	private String legalPerson;

	/**
	 * 法人身份证号码
	 */
	private String legalCertNum;

	/**
	 * 组织机构代码
	 */
	private String orgCode;

	/**
	 * 纳税人识别号
	 */
	private String taxpayerCode;

	/**
	 * 纳税人类型
	 */
	private String taxpayerType;

	/**
	 * 纳税类型税码
	 */
	private String taxpayerTypeCode;

	/**
	 * 介绍信息
	 */
	private String groupInfo;

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
	 * 合同客户ID
	 */
	private String contractCustId;

	/**
	 * 审核状态
	 */
	private String auditState;
	/**
	 * 用户名称
	 */
	private String userLoginName;
	/**
	 * 用户状态
	 */
	private String userState;
	/**
	 * 用户手机号
	 */
	private String userMp;
	/**
	 * 绑定邮箱
	 */
	private String userEmail;
	/**
	 * 邮件认证标志
	 */
	private String emailValidateFlag;

	private String stationProvinceCode;

	private String stationCityCode;

	private String stationCountyCode;

	private String stationCertAddr;

	private Long annualIncome;

	private Long floorSpace;

	private String fax;

	private String eMail;

	private String telephone;

	public String getStationProvinceCode() {
		return stationProvinceCode;
	}

	public void setStationProvinceCode(String stationProvinceCode) {
		this.stationProvinceCode = stationProvinceCode;
	}

	public String getStationCityCode() {
		return stationCityCode;
	}

	public void setStationCityCode(String stationCityCode) {
		this.stationCityCode = stationCityCode;
	}

	public String getStationCountyCode() {
		return stationCountyCode;
	}

	public void setStationCountyCode(String stationCountyCode) {
		this.stationCountyCode = stationCountyCode;
	}

	public String getStationCertAddr() {
		return stationCertAddr;
	}

	public void setStationCertAddr(String stationCertAddr) {
		this.stationCertAddr = stationCertAddr;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Long getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(Long floorSpace) {
		this.floorSpace = floorSpace;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public Long getRegisteredCapitals() {
		return registeredCapitals;
	}

	public void setRegisteredCapitals(Long registeredCapitals) {
		this.registeredCapitals = registeredCapitals;
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

	public String getWebFlag() {
		return webFlag;
	}

	public void setWebFlag(String webFlag) {
		this.webFlag = webFlag;
	}

	public String getGroupWebsite() {
		return groupWebsite;
	}

	public void setGroupWebsite(String groupWebsite) {
		this.groupWebsite = groupWebsite;
	}

	public String getGroupMemberScale() {
		return groupMemberScale;
	}

	public void setGroupMemberScale(String groupMemberScale) {
		this.groupMemberScale = groupMemberScale;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getGroupIndustry() {
		return groupIndustry;
	}

	public void setGroupIndustry(String groupIndustry) {
		this.groupIndustry = groupIndustry;
	}

	public String getGroupBusinessScope() {
		return groupBusinessScope;
	}

	public void setGroupBusinessScope(String groupBusinessScope) {
		this.groupBusinessScope = groupBusinessScope;
	}

	public String getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(String groupProduct) {
		this.groupProduct = groupProduct;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalCertNum() {
		return legalCertNum;
	}

	public void setLegalCertNum(String legalCertNum) {
		this.legalCertNum = legalCertNum;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getTaxpayerCode() {
		return taxpayerCode;
	}

	public void setTaxpayerCode(String taxpayerCode) {
		this.taxpayerCode = taxpayerCode;
	}

	public String getTaxpayerType() {
		return taxpayerType;
	}

	public void setTaxpayerType(String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}

	public String getTaxpayerTypeCode() {
		return taxpayerTypeCode;
	}

	public void setTaxpayerTypeCode(String taxpayerTypeCode) {
		this.taxpayerTypeCode = taxpayerTypeCode;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
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

	public String getContractCustId() {
		return contractCustId;
	}

	public void setContractCustId(String contractCustId) {
		this.contractCustId = contractCustId;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserMp() {
		return userMp;
	}

	public void setUserMp(String userMp) {
		this.userMp = userMp;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getEmailValidateFlag() {
		return emailValidateFlag;
	}

	public void setEmailValidateFlag(String emailValidateFlag) {
		this.emailValidateFlag = emailValidateFlag;
	}

}
