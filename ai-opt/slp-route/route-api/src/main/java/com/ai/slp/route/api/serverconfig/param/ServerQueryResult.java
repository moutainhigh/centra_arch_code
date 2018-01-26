package com.ai.slp.route.api.serverconfig.param;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 服务配置查询返回参数<br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangxw
 */
public class ServerQueryResult extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 服务ID
     */
    private String splServId;

    /**
     * 服务名称
     */
    private String servName;

    /**
     * 服务类型
     */
    private String servType;

    /**
     * 服务内容
     */
    private String servContent;

    /**
     * url
     */
    private String url;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回参数
     */
    private String returnParam;

    public String getSplServId() {
        return splServId;
    }

    public String getServName() {
        return servName;
    }

    public String getServType() {
        return servType;
    }

    public String getUrl() {
        return url;
    }

    public void setSplServId(String splServId) {
        this.splServId = splServId;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

    public void setServType(String servType) {
        this.servType = servType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServContent() {
        return servContent;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public String getReturnParam() {
        return returnParam;
    }

    public void setServContent(String servContent) {
        this.servContent = servContent;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public void setReturnParam(String returnParam) {
        this.returnParam = returnParam;
    }

}
