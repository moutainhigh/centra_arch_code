package com.ifudata.ums.service.http.sikong.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import com.ifudata.ums.exception.FindSeqenceException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.manager.ISmsCommTask;
import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.manager.ISysSequenceCredit;
import com.ifudata.ums.service.http.sikong.constant.SikongConstant;
import com.ifudata.ums.service.http.sikong.msgobj.DeliverObj;
import com.ifudata.ums.service.http.sikong.msgobj.ReportRespObj;
import com.ifudata.ums.service.http.sikong.server.SikongHttpHandler;
import com.ifudata.ums.service.http.weilaiwuxian.util.IsNull;
import com.ifudata.ums.util.ApplicationContextUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SikongHttpHandler implements HttpHandler {

	private static final Log log = LogFactory.getLog(SikongHttpHandler.class);
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");	
	
	@Autowired
	private static ISmsResult smsResultService;

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		// TODO Auto-generated method stub
		log.debug("*******************端口监听获取到数据****************************");
		StringBuilder sb = new StringBuilder("");
		OutputStream out = httpExchange.getResponseBody(); // 获得输出流
		if (httpExchange.getRequestMethod().equalsIgnoreCase("POST")) {
			boolean flag = true;
			// ipswitch值为空,不过滤
			if (IsNull.FieldIsNull(SikongConstant.IPSWITCH)) {
				flag = true;
			} else if (SikongConstant.IPSWITCH.equalsIgnoreCase("on")) {// 不为空，进行判断，打开ip过滤
				String ip = httpExchange.getRemoteAddress().toString().substring(1).split(":")[0];
				flag = SikongConstant.IPS.contains(ip) ? true : false;
			}
			if (flag) {
				// 获得输入流
				InputStream in = httpExchange.getRequestBody();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String temp = null;
				// 每调用一次readLine指针就会移动一次！！！
				while ((temp = reader.readLine()) != null) {
					String value = URLDecoder.decode(temp, "UTF-8");
					sb.append(value);
				}
				
				if (sb.length() > 0) {
					log.debug("************获取到" + httpExchange.getRemoteAddress().toString().substring(1).split(":")[0]
							+ "请求************");
					log.debug(sb.toString());
					// 保存数据的地方  delivers 上行短信
					int ipos = sb.toString().indexOf("delivers");
					if (ipos >= 0) {
						Map<String, Object> map = this.parseString4DeliverResult(sb.toString());
						if (map.size() > 0) {
							saveToSmsCommTask(map);
						}
					} else if (sb.toString().indexOf("reports") >= 0) {
						//report
						Map<String, Object> map = this.parseString4ReportResult(sb.toString());
						if (map.size() > 0) {
							saveSmsResult(sb.toString());
						}						
					}
					// 输出0表示接收并保存成功
					httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 1); // 设置响应头属性及响应信息的长度
					out.write(0);
				} else {
					log.debug(httpExchange.getRemoteAddress().toString().substring(1).split(":")[0] + "请求无效");
					httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 2); 
					out.write(-1);
				}
			} else {
				// 这里可以发出警告信息
				// out.write(FAIL.getBytes());
			}
			out.flush();
			httpExchange.close();
		} else {
			log.debug("*******************检测发送方法非post请求**************************");
			log.debug(httpExchange.getRemoteAddress().toString().substring(1).split(":")[0] + "非POST请求！");
			out.write(1);
			out.flush();
			httpExchange.close();
		}
	}

	private Map<String, Object> parseString4DeliverResult(String responseBody) {
		// 判断传递参数
		if (responseBody == null)
			return null;
		Map<String, Object> map = null;
		try {
			// 获取document对象
			log.debug("********** responseBody : "+ responseBody + " **********");
			Document doc = DocumentHelper.parseText(responseBody);
			// 创建Map容器
			map = new HashMap<String, Object>();
			// 获取root节点
			Element root = doc.getRootElement();
			
			@SuppressWarnings("rawtypes")	
			Iterator reports = root.elementIterator("deliver");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中 把其他信息写入到value里面
				//map.put(msgReport.elementTextTrim("msg_id"), msgReport.elementTextTrim("fail_desc"));
				
				DeliverObj robj = new DeliverObj();
				robj.setCorp_id(msgReport.elementTextTrim("corp_id"));
				robj.setMobile(msgReport.elementTextTrim("mobile"));
				robj.setExt(msgReport.elementTextTrim("ext"));
				robj.setTime(msgReport.elementTextTrim("time"));
				robj.setContent(msgReport.elementTextTrim("content"));
				map.put(msgReport.elementTextTrim("time") + msgReport.elementTextTrim("mobile"), robj);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater")+" **********");
		}
		return map;
	}	
	
	public Map<String, Object> parseString4ReportResult(String responseBody) {
		// 判断传递参数
		if (responseBody == null)
			return null;
		Map<String, Object> map = null;
		try {
			// 获取document对象
			log.debug("********** responseBody : "+ responseBody + " **********");
			Document doc = DocumentHelper.parseText(responseBody);
			// 创建Map容器
			map = new HashMap<String, Object>();
			// 获取root节点
			Element root = doc.getRootElement();
			
			@SuppressWarnings("rawtypes")	
			Iterator reports = root.elementIterator("reports");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中 todo 将信息添加进map容器中 把其他信息写入到value里面
				ReportRespObj robj = new ReportRespObj();
				robj.setCorp_id(msgReport.elementTextTrim("corp_id"));
				robj.setMobile(msgReport.elementTextTrim("mobile"));
				robj.setSub_seq(msgReport.elementTextTrim("sub_seq"));
				robj.setErr(msgReport.elementTextTrim("err"));
				robj.setMsg_id(msgReport.elementTextTrim("msg_id"));
				robj.setFail_desc(msgReport.elementTextTrim("fail_desc"));
				robj.setReport_time(msgReport.elementTextTrim("report_time"));
				
				map.put(msgReport.elementTextTrim("msg_id"), robj);
				//Gson gson = new Gson();
				//map.put(msgReport.elementTextTrim("msg_id"), gson.toJson(robj));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater")+" **********");
		}
		return map;
	}	

	private void saveToSmsCommTask(Map<String, Object> map) {
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() instanceof DeliverObj) {
				DeliverObj robj = (DeliverObj) entry;

				List<SmsCommTask> sctlist = new ArrayList<>();
				SmsCommTask sct = new SmsCommTask();
				try {
					sct.setCommTaskSerial(Integer.valueOf(sysSequence.getSequence("SAC_SMS_MM").toString()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UpdateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FindSeqenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sct.setSvcType("0");
				sct.setRegionId("Z");
				sct.setDeviceNumber(robj.getMobile());
				sct.setRunStatus("0");
				sct.setMessage(robj.getContent());
				sct.setTryNum(0);
				sct.setSpNumber(robj.getCorp_id());
				sct.setReturnResult(null);
				sctlist.add(sct);

				try {
					smsCommTaskService.insertSmsCommTask(sctlist);
				} catch (InsertException e) {
					// TODO Auto-generated catch block
					log.debug("插入SmsCommTask表失败 "+e.toString());
				}
			}
		}
	}
	/**
	 * 修改状态报告对应的记录信息 @date 2015年8月5日 下午7:55:37 @author @param @param
	 * smsResults @return void @throws
	 */
	public static void saveSmsResult(String smsResults) {
		// SmsResultDao smsResultDao = new SmsResultDao();
		String[] results = smsResults.split("=")[1].split("\\^");
		for (String result : results) {
			log.debug("*********" + result + "*********");
			log.debug("**********进入修改状态报告的方法*********");
			String[] srs = result.split(",");
			SmsResultCriteria conditions = new SmsResultCriteria();
			conditions.createCriteria().andSendSeqEqualTo(srs[0]);

			List<SmsResult> smsResultList = smsResultService.getSmsResult(conditions);
			SmsResult sr = null;
			if (smsResultList != null && smsResultList.size() > 0) {
				sr = smsResultList.get(0);
			}
			sr.setSendSeq(srs[0]);
			sr.setPhone(srs[1]);
			if (srs[2].equalsIgnoreCase("DELIVRD")) {
				sr.setRecFlag(Constant.REC_FLAG_SUCCESS);
			} else {
				sr.setRecFlag(Constant.REC_FLAG_FAIL);
				sr.setRecResult(srs[2]);
			}
			try {
				Date format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(srs[3]);

				sr.setRecTime(Timestamp.valueOf(format.toString()));
			} catch (ParseException e) {
				log.debug(srs[3] + "	日期格式转化错误！");
				log.debug("ParseException= [" + e.toString() + "]");
			}
			log.debug("**********开始修改接收到的状态报告*********");
			// 保存解析的状态报告
			try {
				smsResultService.updateSmsResult(sr, conditions);
			} catch (UpdateException e) {
				log.debug(e.getMessage());
			}
		}
		log.debug("状态报告修改完成");
	}
}
