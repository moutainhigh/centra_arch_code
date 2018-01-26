package com.ifudata.ums.api.applybatch.param;

import java.io.Serializable;

public class RequestHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provinceCode;
	private String cityCode;
	private String chlId;
	private String corpId;
	private Long operId;
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
	public String getChlId() {
		return chlId;
	}
	public void setChlId(String chlId) {
		this.chlId = chlId;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public Long getOperId() {
		return operId;
	}
	public void setOperId(Long operId) {
		this.operId = operId;
	} 
	
}
