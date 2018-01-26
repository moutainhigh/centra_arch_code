package com.ai.slp.route.api.server.params;

import com.ai.opt.base.vo.BaseInfo;

/**
 * Created by xin on 16-5-5.
 */
public class RouteServerResponse  extends BaseInfo {
	/**
	 * 返回编码
	 */
    private String responseCode;
    /**
	 * 放回信息
	 */
    private String responseMessage;
    /**
	 * 返回数据
	 */
    private String responseData;

    public RouteServerResponse(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
