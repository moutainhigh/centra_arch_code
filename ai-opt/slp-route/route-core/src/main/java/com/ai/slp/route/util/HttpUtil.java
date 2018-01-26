package com.ai.slp.route.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * http请求工具类
 *
 */
public class HttpUtil {

    public HttpUtil() {
	}

	private static final Logger logger = LogManager.getLogger(HttpUtil.class);
	
	//HttpPost方式远程调用
    public static String doPostRequest(String requestUrl, String requestValue) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(requestUrl);
            StringEntity entity = new StringEntity(requestValue, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            logger.info("Executing request " + httpPost.getRequestLine());

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            return httpclient.execute(httpPost, responseHandler);
        } finally {
            httpclient.close();
        }
    }
}
