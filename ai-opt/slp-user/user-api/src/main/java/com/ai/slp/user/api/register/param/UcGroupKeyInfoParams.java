package com.ai.slp.user.api.register.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 用户信息 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class UcGroupKeyInfoParams extends BaseInfo {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String userType;

    private String cretNum;

    private String custName;

    private String provinceCode;

    private String cityCode;

    private String subsTime;

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

    public String getCretNum() {
        return cretNum;
    }

    public void setCretNum(String cretNum) {
        this.cretNum = cretNum;
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

    public String getSubsTime() {
        return subsTime;
    }

    public void setSubsTime(String subsTime) {
        this.subsTime = subsTime;
    }

}
