package com.ai.slp.user.api.ucuserphonebooks.param;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPhonebooksModifyReq extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 记录标识
	 */
	private String telNo;

	/**
	 * 通讯录分组标识
	 */
	private String telGroupId;

	/**
	 * 电话号码
	 */
	private String telMp;

	/**
	 * 姓名
	 */
	private String telName;

	public String getTelMp() {
		return telMp;
	}

	public void setTelMp(String telMp) {
		this.telMp = telMp;
	}

	public String getTelGroupId() {
		return telGroupId;
	}

	public void setTelGroupId(String telGroupId) {
		this.telGroupId = telGroupId;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getTelName() {
		return telName;
	}

	public void setTelName(String telName) {
		this.telName = telName;
	}

}
