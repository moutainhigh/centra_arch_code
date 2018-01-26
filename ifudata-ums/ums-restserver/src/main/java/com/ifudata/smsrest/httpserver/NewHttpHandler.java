package com.ifudata.smsrest.httpserver;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.ifudata.smsrest.httpserver.Handler;
import com.ifudata.smsrest.httpserver.HttpRequest;
import com.ifudata.smsrest.httpserver.HttpResponse;
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
		//Handler handler = Context.getHandler(request.getReuestURI().getPath());
		//Handler handler = Context.getHandler(request.getReuestURI().getPath());
		System.out.println(request.getReuestURI().getPath());
		Handler handler = new NewRestHandler();
		handler.service(request, response);
	}
}
