package com.ifudata.smsrest.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.ifudata.smsrest.httpserver.Request;
import com.ifudata.smsrest.main.RestServer;

public class HttpRequest implements Request {
	private HttpExchange httpExchange;
	private Map<String, String> paramMap = new HashMap<String, String>();
	private Map<String, List<String>> headMap = new HashMap<String, List<String>>();
	private String requestBody = "";
	
	private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);

	public HttpRequest(HttpExchange httpExchange) {
		this.httpExchange = httpExchange;
	}

	@Override
	public String getParamter(String param) {
		return paramMap.get(param);
	}

	@Override
	public String getMethod() {
		return httpExchange.getRequestMethod().trim().toUpperCase();
	}

	@Override
	public URI getReuestURI() {
		return httpExchange.getRequestURI();
	}

	@Override
	public void initRequestParam() {
		String query = getReuestURI().getQuery();
		String[] arrayStr = query.split("&");
		for (String str : arrayStr) {
			paramMap.put(str.split("=")[0], str.split("=")[1]);
		}
	}

	@Override
	public void initRequestHeader() {
		for (String s : httpExchange.getRequestHeaders().keySet()) {
			headMap.put(s, httpExchange.getRequestHeaders().get(s));
		}
	}

	@Override
	public void initRequestBody() {
		InputStream in = httpExchange.getRequestBody(); // 获得输入流
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String temp = null;
		try {
			while ((temp = reader.readLine()) != null) {
				requestBody += temp;
			}
			log.debug("initRequestBody:" + requestBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getRequestBody() {
		return requestBody;
	}

	@Override
	public String getRequestHead() {
		return "";
	}
	
	public static void main(String[] args) {

		String query = "aaa=aaa&bbb=bbb";
		String[] a = query.split("&");
		for (String s : a) {
			System.out.print(s.split("=")[0] + "=");
			System.out.println(s.split("=")[1]);
		}
	}
}
