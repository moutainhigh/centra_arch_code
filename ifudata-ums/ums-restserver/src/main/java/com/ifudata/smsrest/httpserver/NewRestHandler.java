package com.ifudata.smsrest.httpserver;

import com.ifudata.smsrest.httpserver.Request;
import com.ifudata.smsrest.httpserver.Response;
import com.ifudata.smsrest.main.DbSvr;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.smsrest.httpserver.HttpHandler;
  
public class NewRestHandler extends HttpHandler{
	private static final Log log = LogFactory.getLog(NewRestHandler.class);
//	private static final DeliverRespObj deliverResp = new DeliverRespObj();
//	private static final ReportRespObj reportResp = new ReportRespObj();
//	private static final SubmitRespObj submitResp = new SubmitRespObj();
	public static String fromStream2String(InputStream is, String encode) {
		if (is == null)
			return null;
		StringBuilder sb = new StringBuilder("");
		try {
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public void doGet(Request request, Response response) {
		String getData1 = request.getRequestBody();
		String path = request.getReuestURI().getPath();
		String res = null;

		log.debug("rec_url:"+path);
		log.debug("rec_msg:"+getData1);
		InputStream is = new ByteArrayInputStream(getData1.getBytes());
		// 根据返回的xml内容判断是否要进行解析
		getData1 = fromStream2String(is, "gbk");
		log.debug("getData1 gbk:" + getData1);
		String getData = getData1;
//		try {
//			getData = new String(getData1.getBytes(),"utf-8");
//			
//			log.debug("getData utf-8:" + getData);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (getData1.equals(null) || getData1.equals("")) {
			response.write("9");
		 // 如果接收失败，返回9
		} else {
			DbSvr dbSvr = new DbSvr();
			if (path.toUpperCase().indexOf("SENDMSGBATCH") >= 0) {
				//批量写sms_result表
				res = dbSvr.setSmsFromJsonSms(getData);
				log.debug("setSmsFromJsonSms(getData):" + res);
				response.write(res);
			} else if (path.toUpperCase().indexOf("SENDMSG") >= 0) {
				res = dbSvr.setSgipSrcFromJson(getData);
				log.debug("rec_url"+"SENDMSG");
				response.write(res);
//				if (dbSvr.setSgipSrcFromJson(getData) >= 0)
//					response.write("0");
//				else 
//					response.write("9");
			} else if (path.toUpperCase().indexOf("MSGREPORT") >= 0) {
				res = dbSvr.getReportJson(getData);
				response.write(res);
			} else if (path.toUpperCase().indexOf("FULLOBJSTATUS") >= 0) {
				//获取全部状态信息
				res = dbSvr.getFullObjStatusJson(getData);
				log.debug("getFullObjStatusJson(getData):" + res);
				response.write(res);
				
			} else if (path.toUpperCase().indexOf("RECMSG") >= 0) {
				res = dbSvr.getRestTaskJson();
				response.write(res);
			} else {
				log.error("path no default handle:" + path);
				response.write("9");
			}
		} // 如果接收成功，返回0
	}
	
	@Override
	public void doPost(Request request, Response response) {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
