package com.ifudata.ums.api.applybatch.param;

import java.io.Serializable;

/**
 * Title: msg-CRM <br>
 * Description: 批量业务导入的业务数据抽象类<br>
 * Date: 2014年5月22日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author wangyongxin
 */
public abstract class AbstractBatchData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String SUCCESS = "1";
    
    public static final String FAILURE = "0";

    // 校验结果编码
    private String checkCode;

    // 校验结果描述
    private String checkMessage;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCheckMessage() {
        return checkMessage;
    }

    public void setCheckMessage(String checkMessage) {
        this.checkMessage = checkMessage;
    }

}
