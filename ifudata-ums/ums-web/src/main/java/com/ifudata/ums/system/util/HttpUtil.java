package com.ifudata.ums.system.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

public class HttpUtil {
    private static  Logger logger = Logger.getLogger(HttpUtil.class);

    /**
     * 发送报文并接收到报文
     * @param requestUrl
     * @param params
     * @return
     * @author LiangMeng
     */
    public static String post(String requestUrl ,Map<String,String> params){
        URL url;
        HttpURLConnection conn;
        String result = null;
        try {
            /*1.初始化连接*/
            url = new URL(requestUrl);
            logger.info("请求地址：[ " + requestUrl+"]");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(50000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            /*2.构造发送参数*/
            StringBuffer sb = new StringBuffer();
            if(params!=null){
                for (Entry<String, String> e : params.entrySet()) {
                    sb.append(e.getKey());
                    sb.append("=");
                    sb.append(e.getValue());
                    sb.append("&");
                }
                sb.substring(0, sb.length() - 1);
            }
            /*3.发送报文*/
            OutputStreamWriter writer;
            writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            logger.info("发送报文：[" + sb+"]");
            writer.write(sb.toString());
            writer.flush();
            writer.close();
            String line;
            StringBuilder builder = new StringBuilder();
            /*4.接收返回报文*/
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            reader.close();
         // logger.info("接收报文: [" + URLDecoder.decode(builder.toString()+"]","UTF-8"));
         // return URLDecoder.decode(builder.toString(),"UTF-8");
            logger.info("接收报文: [" + builder.toString()+"]");
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("返回数据有误:" + e.getMessage(),e);
        }
        return result;
    }
    
}
