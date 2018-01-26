package com.ifudata.ums.expums.model;
import java.io.Serializable;

/**
 * 
 * Title: ums-CRM <br>
 * Description: 赠款记录vo<br>
 * Date: 2015年4月24日 <br>
 * Copyright (c) 2015 ifudata <br>
 * 
 * @author fanpw
 */
public class GrantsRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //序列号
    private String seriesNo;
    public String getSeriesNo() {
		return seriesNo;
	}
	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	public String getChiId() {
		return chiId;
	}
	public void setChiId(String chiId) {
		this.chiId = chiId;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFailMsg() {
		return failMsg;
	}
	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}
	//服务号码
    private String phone;
    //内容
    private String content; 
    //推送时间
    private String effectDate;
     //渠道
    private String chiId;
    //分组号
    private String groupNum;
    //省份
    private String provinceCode;
    //地市
    private String cityCode;
    //原因描述
    private String reason;
    //校验失败原因
    private String failMsg;
 
}
