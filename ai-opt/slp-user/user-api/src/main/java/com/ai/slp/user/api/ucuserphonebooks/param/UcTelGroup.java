package com.ai.slp.user.api.ucuserphonebooks.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class UcTelGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户标识
	 */
	private String tenantId;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 分组标识
	 */
	private String telGroupId;

	/**
	 * 序号
	 */
	private long seq;

	/**
	 * 分组名称
	 */
	private String telGroupName;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 更新时间
	 */
	private Timestamp updateTime;

	private String createTimeStr;

	private String updateTimeStr;

	/**
	 * 联系人数量
	 */
	private int count;

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

	public String getTelGroupId() {
		return telGroupId;
	}

	public void setTelGroupId(String telGroupId) {
		this.telGroupId = telGroupId;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getTelGroupName() {
		return telGroupName;
	}

	public void setTelGroupName(String telGroupName) {
		this.telGroupName = telGroupName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

}
