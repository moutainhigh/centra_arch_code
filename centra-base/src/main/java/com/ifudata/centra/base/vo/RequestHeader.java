package com.ifudata.centra.base.vo;

import java.io.Serializable;

/**
 * 交易请求报文头<br>
 * Date: 2015年8月12日 <br>
 * 
 * @author mayt
 */
public class RequestHeader implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 系统ID
     */
    private String systemId;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 工号
     */
    private Long staffId;

    /**
     * 省分代码
     */
    private String provinceCode;

    /**
     * 地市代码
     */
    private String cityCode;
    
    /**
     * 部门ID
     */
    private Long departId;
    
    /**
     * 部门级别
     */
    private Integer departLevel;
    
    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public Integer getDepartLevel() {
		return departLevel;
	}

	public void setDepartLevel(Integer departLevel) {
		this.departLevel = departLevel;
	}
	

}
