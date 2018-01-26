package com.ifudata.ums.dao.mapper.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SgipSrcGsm {
    private String srcName;

    private Long templateId;

    private String servicetype;

    private BigDecimal verifyid;

    private String phone;

    private String gsmcontent;

    private Integer flag;

    private Timestamp createTime;

    private Integer priority;

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName == null ? null : srcName.trim();
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    public BigDecimal getVerifyid() {
        return verifyid;
    }

    public void setVerifyid(BigDecimal verifyid) {
        this.verifyid = verifyid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGsmcontent() {
        return gsmcontent;
    }

    public void setGsmcontent(String gsmcontent) {
        this.gsmcontent = gsmcontent == null ? null : gsmcontent.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SgipSrcGsm{" +
                "srcName='" + srcName + '\'' +
                ", templateId=" + templateId +
                ", servicetype='" + servicetype + '\'' +
                ", verifyid=" + verifyid +
                ", phone='" + phone + '\'' +
                ", gsmcontent='" + gsmcontent + '\'' +
                ", flag=" + flag +
                ", createTime=" + createTime +
                ", priority=" + priority +
                '}';
    }
}