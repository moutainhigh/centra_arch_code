package com.ifudata.centra.sdk.component.mail;

import java.text.MessageFormat;

/**
 * html邮件模板工具类
 *
 * Date: 2017年7月17日 <br>
 * Copyright (c) 2017 ifudata.com <br>
 * @author wangyongxin
 */
public class EmailTemplateUtil {

    private EmailTemplateUtil() {

    }
    /**
     * 生产html邮件内容
     * @param templateClassPath  邮件模板classpath路径，如"email/template/upgrade-notify-public.xml"
     * @param data 数据对象
     * @return
     * @author wangyongxin
     * @ApiDocMethod
     * @ApiCode
     */
    public static String buildHtmlTextFromTemplate(String templateClassPath,Object[] data) {
        String tmp = EmailTemplateReader.read(templateClassPath);
        String html = MessageFormat.format(tmp, data);
        return html;
    }
    

}
