package com.ifudata.smsrest.httpserver;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.ifudata.smsrest.httpserver.Response;

public class HttpResponse implements Response{
	private HttpExchange httpExchange;
	public HttpResponse(HttpExchange httpExchange){
		this.httpExchange = httpExchange;
	}
	
	@Override
	public void write(String result) {
		try {
			httpExchange.sendResponseHeaders(200, result.getBytes().length);// 设置响应头属性及响应信息的长度
			Headers responseHeaders = httpExchange.getResponseHeaders();  
	        responseHeaders.set("content-type", "text/html;charset=gbk");
			OutputStream out = httpExchange.getResponseBody(); // 获得输出流
			out.write(result.getBytes());
			out.flush();
			httpExchange.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
