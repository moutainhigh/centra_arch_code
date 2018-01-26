package com.ifudata.centra.sdk.component.mcs.exception;

/**
 * Created by wangyongxin on 2017/7/17.
 */
public class CacheClientException extends RuntimeException{
    private String errCode;
    private String errDetail;
    private static final String MCS_MSG = "MCS RUNTIME ERROR";

    public CacheClientException(String errCode, String errDetail) {
        super(errCode + ":" + errDetail);
        this.errCode = errCode;
        this.errDetail = errDetail;
    }

    public CacheClientException(String errCode, Exception ex) {
        super(errCode, ex);
        this.errCode = errCode;
    }

    public CacheClientException(String errCode, String errDetail, Exception ex) {
        super(errCode + ":" + errDetail, ex);
        this.errCode = errCode;
        this.errDetail = errDetail;
    }

    public CacheClientException(Exception ex) {
        super(MCS_MSG, ex);
    }

    public CacheClientException(String errDetail) {
        super(errDetail);
        this.errDetail = errDetail;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }
}
