package com.ifudata.ums.api.applybatch.param;



import com.ifudata.centra.base.vo.ResponseHeader;

import java.io.Serializable;



/**
 * 批量提交受理返回类 Title: msg-CRM <br>
 * Description: <br>
 * Date: 2014年5月20日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author wangyongxin
 */
public class OrdApplyBatchResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    // 返回的报文头
    private ResponseHeader responseHeader;

    // 批次号
    private long batchId;

    // 处理描述
    private String batchDesc;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    public String getBatchDesc() {
        return batchDesc;
    }

    public void setBatchDesc(String batchDesc) {
        this.batchDesc = batchDesc;
    }

}
