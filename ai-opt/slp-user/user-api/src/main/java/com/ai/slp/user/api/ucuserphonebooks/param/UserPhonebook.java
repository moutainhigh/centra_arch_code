package com.ai.slp.user.api.ucuserphonebooks.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserPhonebook implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 记录标识
     */
    private String recordId;

    /**
     * 租户标识
     */
    private String tenantId;

    /**
     * 归属用户
     */
    private String userId;

    /**
     * 通讯录分组标识
     */
    private String telGroupId;

    /**
     * 通信录分组名称
     */
    private String telGroupName;

    /**
     * 电话号码
     */
    private String telNo;

    /**
     * 排序号
     */
    private long seq;

    /**
     * 姓名
     */
    private String telName;

    private String telMp;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 地市编码
     */
    private String cityCode;

    /**
     * 地市名称
     */
    private String cityName;

    /**
     * 基础运营商编码
     */
    private String basicOrgId;

    /**
     * 基础运营商名称
     */
    private String basicOrgName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
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

    public String getTelGroupId() {
        return telGroupId;
    }

    public void setTelGroupId(String telGroupId) {
        this.telGroupId = telGroupId;
    }

    public String getTelGroupName() {
        return telGroupName;
    }

    public void setTelGroupName(String telGroupName) {
        this.telGroupName = telGroupName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName;
    }

    public String getTelMp() {
        return telMp;
    }

    public void setTelMp(String telMp) {
        this.telMp = telMp;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBasicOrgId() {
        return basicOrgId;
    }

    public void setBasicOrgId(String basicOrgId) {
        this.basicOrgId = basicOrgId;
    }

    public String getBasicOrgName() {
        return basicOrgName;
    }

    public void setBasicOrgName(String basicOrgName) {
        this.basicOrgName = basicOrgName;
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

}
