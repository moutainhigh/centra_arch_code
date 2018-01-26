package com.ifudata.centra.base.vo;

import java.io.Serializable;

/**
 * 服务返回基本信息<br>
 * Date: 2016年2月26日 <br>
 * 
 * @author mayt
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SUCCESS = "000000";

    private static final String SUCCESS_MESSAGE = "成功";

    /**
     * 服务返回报文头信息
     */
    private ResponseHeader responseHeader;

    public BaseResponse() {
        responseHeader = new ResponseHeader(true, SUCCESS, SUCCESS_MESSAGE);
    }
    
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }
}
