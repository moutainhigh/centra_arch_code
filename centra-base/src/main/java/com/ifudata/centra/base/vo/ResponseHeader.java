package com.ifudata.centra.base.vo;

import java.io.Serializable;

/**
 * 服务返回报文头信息<br>
 * 标识业务处理成功或业务异常原因<br>
 * Date: 2016年2月26日 <br>
 * 
 * @author mayt
 */
public class ResponseHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否业务成功
     */
    private boolean success;

    private String resultCode;

    private String resultMessage;
    
    //用于异常时，存放堆栈信息
    private  String info="";

    public ResponseHeader(boolean success, String resultCode, String resultMessage) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
    
    public ResponseHeader(boolean success, String resultCode, String resultMessage,String info) {
    	this.success = success;
    	this.resultCode = resultCode;
    	this.resultMessage = resultMessage;
    	this.info=info;
    }

    public ResponseHeader() {

    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
    
    

}
