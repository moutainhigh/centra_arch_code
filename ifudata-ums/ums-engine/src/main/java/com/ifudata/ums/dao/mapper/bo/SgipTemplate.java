package com.ifudata.ums.dao.mapper.bo;

import java.util.Objects;

public class SgipTemplate {
    private Long templateId;

    private String templateText;

    private String sbeginTime;

    private String scloseTime;

    private Integer retryTimes;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateText() {
        return templateText;
    }

    public void setTemplateText(String templateText) {
        this.templateText = templateText == null ? null : templateText.trim();
    }

    public String getSbeginTime() {
        return sbeginTime;
    }

    public void setSbeginTime(String sbeginTime) {
        this.sbeginTime = sbeginTime == null ? null : sbeginTime.trim();
    }

    public String getScloseTime() {
        return scloseTime;
    }

    public void setScloseTime(String scloseTime) {
        this.scloseTime = scloseTime == null ? null : scloseTime.trim();
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    @Override
    public String toString() {
        return "SgipTemplate{" +
                "templateId=" + templateId +
                ", templateText='" + templateText + '\'' +
                ", sbeginTime='" + sbeginTime + '\'' +
                ", scloseTime='" + scloseTime + '\'' +
                ", retryTimes=" + retryTimes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        SgipTemplate that = (SgipTemplate) o;
        return Objects.equals(templateId, that.templateId) &&
                Objects.equals(templateText, that.templateText) &&
                Objects.equals(sbeginTime, that.sbeginTime) &&
                Objects.equals(scloseTime, that.scloseTime) &&
                Objects.equals(retryTimes, that.retryTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateId, templateText, sbeginTime, scloseTime, retryTimes);
    }
}