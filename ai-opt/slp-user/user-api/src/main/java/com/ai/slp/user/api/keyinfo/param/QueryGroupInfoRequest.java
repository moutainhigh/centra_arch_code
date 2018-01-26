package com.ai.slp.user.api.keyinfo.param;

import com.ai.opt.base.vo.BaseInfo;

public class QueryGroupInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;
    /**
     * 企业名称
     */
    private String custName;
    /**
     * 用户类型
     */
    private String userType;
    
    private Integer pageNo;

    private Integer pageSize;
    /**
     * 审核状态
     */
    private String auditState;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

}
