package com.ifudata.ums.service.http.baiwunew.server.http;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.ifudata.ums.service.http.baiwunew.server.http.Handler;
import com.ifudata.ums.service.http.baiwunew.server.http.HttpRequest;
import com.ifudata.ums.service.http.baiwunew.server.http.HttpResponse;
//import com.ifudata.ums.service.http.baiwunew.server.http.HttpHandler;
/**
 * @author 
 * @Description: 内部消息处理类
 * @date 2014年11月12日 下午3:53:44
 * @version V1.0
 */
public class NewHttpHandler implements HttpHandler {

	public void handle(HttpExchange httpExchange) throws IOException {
		HttpRequest request = new HttpRequest(httpExchange);
		HttpResponse response = new HttpResponse(httpExchange);
		Handler handler = Context.getHandler(request.getReuestURI().getPath());
		System.out.println(request.getReuestURI().getPath());
		handler.service(request, response);
	}
}
