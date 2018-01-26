package com.ifudata.centra.sdk.component.ses.base;

public abstract class AbstractSES {

    /**
     * 统一刷新ses方法，将数据库数据导入到到SES
     * 
     * @throws Exception
     * @author wangyongxin
     */
    public abstract void write() throws Exception;

}
