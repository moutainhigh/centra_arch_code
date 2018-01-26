package com.ai.slp.user.api.ucLoginLog.param;

import java.io.Serializable;


import com.ai.opt.base.vo.BaseInfo;

public class UcLoginLogParamsRequest extends BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;  

    /**
     * 登录IP归属省
     */
    private String loginProvice;

    /**
     * 登录IP归属地市
     */

    private String loginCity;

    /**
     * 用户登录IP地址
     */

    private String loginIpAdd;

    /**
     * 登录用户的手机号码
     */
    private String loginMp;

    /**
     * 用户手机品牌
     */
    private String userPhone;

    /**
     * 用户手机型号
     */
    private String userPhoneType;

    /**
     * 手机IMEI
     */
    private String userPhoneImei;

    /**
     * 手机定位省
     */
    private String provice;

    /**
     * 手机定位地市
     */
    private String city;

    /**
     * 用户登录渠道
     */
    private String loginChl;

    /**
     * 用户登录方式
     */
    private String loginWay;

    private Integer pageNo;

    private Integer pageSize;
    
    public String getLoginProvice() {
        return loginProvice;
    }

    public void setLoginProvice(String loginProvice) {
        this.loginProvice = loginProvice;
    }

    public String getLoginCity() {
        return loginCity;
    }

    public void setLoginCity(String loginCity) {
        this.loginCity = loginCity;
    }

    public String getLoginIpAdd() {
        return loginIpAdd;
    }

    public void setLoginIpAdd(String loginIpAdd) {
        this.loginIpAdd = loginIpAdd;
    }

    public String getLoginMp() {
        return loginMp;
    }

    public void setLoginMp(String loginMp) {
        this.loginMp = loginMp;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhoneType() {
        return userPhoneType;
    }

    public void setUserPhoneType(String userPhoneType) {
        this.userPhoneType = userPhoneType;
    }

    public String getUserPhoneImei() {
        return userPhoneImei;
    }

    public void setUserPhoneImei(String userPhoneImei) {
        this.userPhoneImei = userPhoneImei;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLoginChl() {
        return loginChl;
    }

    public void setLoginChl(String loginChl) {
        this.loginChl = loginChl;
    }

    public String getLoginWay() {
        return loginWay;
    }

    public void setLoginWay(String loginWay) {
        this.loginWay = loginWay;
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

}
