package com.ai.opt.data.api.user.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginLogRequest  implements Serializable{

	private static final long serialVersionUID = -6364372990368813445L;
	//loginlog主键
	private String id;

    private Integer userId;

    private Integer loginDate;

    private Timestamp loginDatetime;

    //系统来源
    /**
     * 0 ：译云
		1 ：金山
		2 ：百度
		3 ：微信
		4：找翻译
		5：WAP端
     */
    private String systemSource;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		this.systemSource = systemSource;
	}
    
}
