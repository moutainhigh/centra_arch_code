package com.ifudata.ums.service.http.baiwunew.server.http;


import com.ifudata.ums.service.http.baiwunew.server.http.Handler;
import com.ifudata.ums.service.http.baiwunew.server.http.Request;
import com.ifudata.ums.service.http.baiwunew.server.http.Response;

public abstract class HttpHandler implements Handler {

	@Override
	public void service(Request request, Response response) {
		request.initRequestHeader();
		request.initRequestParam();
		if(request.getMethod().equals(Request.GET)){
			doGet(request,response);
		}else if(request.getMethod().equals(Request.POST)){
			request.initRequestBody();
			doPost(request,response);
		}
	}

	@Override
	public abstract void doGet(Request request, Response response);

	@Override
	public abstract void doPost(Request request, Response response);
}
