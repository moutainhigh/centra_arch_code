package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcLoginLog {
    private String tenantId;

    private String userId;

    private String loginSeqId;

    private Timestamp loginTime;

    private String loginProvine;

    private String loginCity;

    private String loginIpAddr;

    private String phoneProvine;

    private String phoneCity;

    private String loginMp;

    private String userPhone;

    private String userPhoneType;

    private String userPhoneImei;

    private String provine;

    private String city;

    private String loginChl;

    private String loginWay;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginSeqId() {
        return loginSeqId;
    }

    public void setLoginSeqId(String loginSeqId) {
        this.loginSeqId = loginSeqId == null ? null : loginSeqId.trim();
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginProvine() {
        return loginProvine;
    }

    public void setLoginProvine(String loginProvine) {
        this.loginProvine = loginProvine == null ? null : loginProvine.trim();
    }

    public String getLoginCity() {
        return loginCity;
    }

    public void setLoginCity(String loginCity) {
        this.loginCity = loginCity == null ? null : loginCity.trim();
    }

    public String getLoginIpAddr() {
        return loginIpAddr;
    }

    public void setLoginIpAddr(String loginIpAddr) {
        this.loginIpAddr = loginIpAddr == null ? null : loginIpAddr.trim();
    }

    public String getPhoneProvine() {
        return phoneProvine;
    }

    public void setPhoneProvine(String phoneProvine) {
        this.phoneProvine = phoneProvine == null ? null : phoneProvine.trim();
    }

    public String getPhoneCity() {
        return phoneCity;
    }

    public void setPhoneCity(String phoneCity) {
        this.phoneCity = phoneCity == null ? null : phoneCity.trim();
    }

    public String getLoginMp() {
        return loginMp;
    }

    public void setLoginMp(String loginMp) {
        this.loginMp = loginMp == null ? null : loginMp.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPhoneType() {
        return userPhoneType;
    }

    public void setUserPhoneType(String userPhoneType) {
        this.userPhoneType = userPhoneType == null ? null : userPhoneType.trim();
    }

    public String getUserPhoneImei() {
        return userPhoneImei;
    }

    public void setUserPhoneImei(String userPhoneImei) {
        this.userPhoneImei = userPhoneImei == null ? null : userPhoneImei.trim();
    }

    public String getProvine() {
        return provine;
    }

    public void setProvine(String provine) {
        this.provine = provine == null ? null : provine.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLoginChl() {
        return loginChl;
    }

    public void setLoginChl(String loginChl) {
        this.loginChl = loginChl == null ? null : loginChl.trim();
    }

    public String getLoginWay() {
        return loginWay;
    }

    public void setLoginWay(String loginWay) {
        this.loginWay = loginWay == null ? null : loginWay.trim();
    }
}