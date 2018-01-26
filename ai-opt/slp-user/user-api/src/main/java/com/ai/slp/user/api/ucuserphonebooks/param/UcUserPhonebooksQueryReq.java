package com.ai.slp.user.api.ucuserphonebooks.param;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPhonebooksQueryReq extends BaseInfo {

	private static final long serialVersionUID = 1L;

	private Integer pageNo;

	private Integer pageSize;

	/**
	 * 通讯录分组标识
	 */
	private String telGroupId;

	/**
	 * 省份编码
	 */
	private String provinceCode;

	/**
	 * 地市编码
	 */
	private String cityCode;

	/**
	 * 基础运营商编码
	 */
	private String basicOrgId;

	/**
	 * 电话号码
	 */
	private String telMp;

	/**
	 * 姓名
	 */
	private String telName;

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

	public String getBasicOrgId() {
		return basicOrgId;
	}

	public void setBasicOrgId(String basicOrgId) {
		this.basicOrgId = basicOrgId;
	}

	public String getTelMp() {
		return telMp;
	}

	public void setTelMp(String telMp) {
		this.telMp = telMp;
	}

	public String getTelName() {
		return telName;
	}

	public void setTelName(String telName) {
		this.telName = telName;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getTelGroupId() {
		return telGroupId;
	}

	public void setTelGroupId(String telGroupId) {
		this.telGroupId = telGroupId;
	}

}
