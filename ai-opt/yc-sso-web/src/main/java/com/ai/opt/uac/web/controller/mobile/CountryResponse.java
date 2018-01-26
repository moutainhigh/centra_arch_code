package com.ai.opt.uac.web.controller.mobile;

import java.io.Serializable;

public class CountryResponse  implements Serializable{

	private static final long serialVersionUID = -1136018098652271458L;
	
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 中文名称
	 */
	private String countryNameCn;
	/**
	 * 英文名称
	 */
	private String countryNameEn;
	/**
	 * 简称
	 */
	private String countryValue;
	/**
	 * 代码
	 */
	private String countryCode;
	/**
	 * 正则校验手机
	 */
	private String regularExpression;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryNameCn() {
		return countryNameCn;
	}
	public void setCountryNameCn(String countryNameCn) {
		this.countryNameCn = countryNameCn;
	}
	public String getCountryNameEn() {
		return countryNameEn;
	}
	public void setCountryNameEn(String countryNameEn) {
		this.countryNameEn = countryNameEn;
	}
	public String getCountryValue() {
		return countryValue;
	}
	public void setCountryValue(String countryValue) {
		this.countryValue = countryValue;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRegularExpression() {
		return regularExpression;
	}
	public void setRegularExpression(String regularExpression) {
		this.regularExpression = regularExpression;
	}
	
	
}
