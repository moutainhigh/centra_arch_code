package com.ai.opt.data.dao.mapper.bo;

import java.sql.Timestamp;

public class LoginLog {
    private String id;

    private Integer userId;

    private Integer loginDate;

    private Timestamp loginDatetime;

    /**
	 * 系统来源:<br>
	 *  0	pc用户<br>
	 *	5	手机<br>
	 * 
	 */
    private String systemSource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Integer loginDate) {
        this.loginDate = loginDate;
    }

    public Timestamp getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Timestamp loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    public String getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(String systemSource) {
        this.systemSource = systemSource == null ? null : systemSource.trim();
    }
}