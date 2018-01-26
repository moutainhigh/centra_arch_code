package com.ifudata.ums.service.http.baiwunew.server.http;

import com.ifudata.ums.service.http.baiwunew.server.http.Request;
import com.ifudata.ums.service.http.baiwunew.server.http.Response;

import java.io.InputStream;

import com.ifudata.ums.service.http.baiwunew.server.BWNewServer;
import com.ifudata.ums.service.http.baiwunew.server.http.HttpHandler;
  
public class NewBaiwuHandler extends HttpHandler{
//
//	<?xml version="1.0" encoding="GBK" ?> 
//	<delivers>
//	<deliver>
//	<corp_id>test</corp_id>
//	<mobile>13810000000</mobile>
//	<ext>8888</ext> (对应下发时的ext参数，根据手机用户回复短信（即上行信息）的ext的值， 匹配客户或者客户下发的信息)
//	<time>2010-07-02 00:00:00</time>
//	<content>收到</content>
//	</deliver>
//	</delivers>
	
	@Override
	public void doGet(Request request, Response response) {
		// TODO Auto-generated method stub
		// InputStream in = request.getRequestBody();
		// BufferedInputStream buf = new BufferedInputStream(in);
		// byte[] buffer = new byte[1024];
		// StringBuffer data =new StringBuffer();
		// int a ;
		// while((a = buf.read(buffer))!= -1){
		// data.append(new String(buffer,0,a,"gbk"));
		// }
		// String getData = data.toString();
		// System.out.println(getData ); //显示接收的字符串

		String getData = request.getRequestBody();
		System.out.println("request:" + getData);
		if (getData.equals(null) || getData.equals("")) {
			response.write("9");
		 // 如果接收失败，返回9
		} else {
			if (getData.indexOf("reports") >= 0) {
				BWNewServer.reportArray.add(getData);
				response.write("0");
			} else if (getData.indexOf("delivers") >= 0) {
				BWNewServer.deliverArray.add(getData);
				response.write("0");
			} else
				response.write("9");
		} // 如果接收成功，返回0
	}
	
	@Override
	public void doPost(Request request, Response response) {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
