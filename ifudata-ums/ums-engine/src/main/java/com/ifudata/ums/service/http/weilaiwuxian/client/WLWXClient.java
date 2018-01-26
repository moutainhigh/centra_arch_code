package com.ifudata.ums.service.http.weilaiwuxian.client;




import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.service.http.weilaiwuxian.constant.WeilaiwuxianConstant;
import com.ifudata.ums.service.http.weilaiwuxian.util.MD;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2015年7月29日下午4:52:23
 * hongzhenfu
 *
 */
public class WLWXClient extends SMAbstractClient {
    private static final Log log = LogFactory.getLog(WLWXClient.class);

    @Override
    public Map<String, Object> writeMessage(String userNumber, String content) {
        log.debug("********** WLWXClient未来无线http发送 : 号码 ：["
                + userNumber
                + "];内容：[" + content + "]**********");
        Map<String, Object> status = new HashMap<String, Object>();
        HttpClient client = new HttpClient();
        log.debug("********** WLWXClient未来无线http发送地址："
                + WeilaiwuxianConstant.WRITE_URL + "；http Content-Type:"
                + WeilaiwuxianConstant.CONTENT_TYPE +"；http cust_code："
                + WeilaiwuxianConstant.CUST_CODE + "；http sp_code："
                + WeilaiwuxianConstant.SP_CODE);
        PostMethod post = new PostMethod(WeilaiwuxianConstant.WRITE_URL);

        post.addRequestHeader("Content-Type", WeilaiwuxianConstant.CONTENT_TYPE);

        NameValuePair cust_code = new NameValuePair("cust_code", WeilaiwuxianConstant.CUST_CODE);
        NameValuePair sp_code = new NameValuePair("sp_code", WeilaiwuxianConstant.SP_CODE);
        NameValuePair mobile = new NameValuePair("destMobiles", userNumber);

        int excuteStatus;
        try {
            String msg = URLEncoder.encode(content, "UTF-8");
            NameValuePair msgContent = new NameValuePair("content", content);
            log.debug("********** http sign："
                    + WeilaiwuxianConstant.PWD+"；MD5加密之后："
                    + MD.sign(msg, WeilaiwuxianConstant.PWD, "UTF-8"));
            NameValuePair sign = new NameValuePair("sign", MD.sign(msg, WeilaiwuxianConstant.PWD, "UTF-8"));

            post.setRequestBody(new NameValuePair[] {cust_code, sp_code, mobile, msgContent, sign});

            excuteStatus = client. executeMethod(post);
            log.debug("********** WLWXClient执行post方法状态 : "+excuteStatus+" **********");
            String returnString = post.getResponseBodyAsString();
            post.releaseConnection();
            log.debug("********** WLWXClient执行结果responseBody : "+returnString+" **********");

            String[] result = returnString.split(":");
            if(result[0].equalsIgnoreCase("SUCCESS")){
                log.debug("********** WLWXClient短信发送成功 ********** ");
                //针对的是单条发送的返回值，后两个就是msgId和result，所以就以分号来分割了
                //result[result.length-1]对应的值可能不是0，那么对应就是没有真正发送成功，eg:手机号写成字母，返回SUCCESS但是result[result.length-1]不是0
                status.put(Constant.RESULT_CODE, result[result.length-1].trim());
                status.put("msgId", result[result.length-2]);
            }else if(result[0].equalsIgnoreCase("ERROR")){
                log.debug("********** WLWXClient短信发送失败 ********** ");
                status.put(Constant.RESULT_CODE, result[result.length-1].trim());
                status.put(Constant.RESULT_CONTENT, result[result.length-1].trim());
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            log.debug("HttpException:	"+e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.debug("IOException:	"+e.toString());
        }
        return status;
    }

    @Override
    public Map<String, Object> readMessage() {
        return null;
    }
}
