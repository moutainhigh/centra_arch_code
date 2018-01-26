package com.ifudata.ums.service.http.weilaiwuxian.server;

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
import java.util.Date;
import java.util.List;

import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;

import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.service.http.weilaiwuxian.util.IsNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.service.http.weilaiwuxian.constant.WeilaiwuxianConstant;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * 2015年8月5日上午10:48:08
 * hongzhenfu
 *
 */
public class WLWXHttpHandler implements HttpHandler{
	
	private static final Log log = LogFactory.getLog(WLWXHttpHandler.class);
	@Autowired
	private static ISmsResult smsResultService;
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		// TODO Auto-generated method stub
		log.debug("*******************端口监听获取到数据****************************");
		StringBuilder sb = new StringBuilder("");
		OutputStream out = httpExchange.getResponseBody();  //获得输出流  
		if(httpExchange.getRequestMethod().equalsIgnoreCase("POST")){
			boolean flag=true;
			//ipswitch值为空,不过滤
			if( IsNull.FieldIsNull(WeilaiwuxianConstant.IPSWITCH)){
				flag = true;
			}else if(WeilaiwuxianConstant.IPSWITCH.equalsIgnoreCase("on")){//不为空，进行判断，打开ip过滤
				String ip = httpExchange.getRemoteAddress().toString().substring(1).split(":")[0];
				flag=WeilaiwuxianConstant.IPS.contains(ip)?true:false;
			}
			if(flag){
				//获得输入流
				InputStream in = httpExchange.getRequestBody(); 
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		        String temp = null;  
		        //每调用一次readLine指针就会移动一次！！！
		        while((temp = reader.readLine()) != null) {  
		        	String value = URLDecoder.decode(temp, "UTF-8");
		        	sb.append(value);
		        }
		        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 1); //设置响应头属性及响应信息的长度
		        if(sb.length()>0){
					log.debug("************获取到"+httpExchange.getRemoteAddress().toString().substring(1).split(":")[0]+"请求************");
					log.debug(sb.toString());
					//保存数据的地方
					saveSmsResult(sb.toString());
					//输出0表示接收并保存成功
					out.write(0);
				}else{
					log.debug(httpExchange.getRemoteAddress().toString().substring(1).split(":")[0]+"请求无效");
					out.write(-1); 
				}
			}else{
//				这里可以发出警告信息
//				out.write(FAIL.getBytes());
			}
	        out.flush();  
	        httpExchange.close();
		}else{
			log.debug("*******************检测发送方法非post请求**************************");
			log.debug(httpExchange.getRemoteAddress().toString().substring(1).split(":")[0]+"非POST请求！");
			out.write(1); 
			out.flush();  
		    httpExchange.close();
		}

	}
	/**
	 * 修改状态报告对应的记录信息
	* @date 2015年8月5日 下午7:55:37 
	* @author hongzhenfu
	* @param @param smsResults
	* @return void
	* @throws
	 */
	public static void saveSmsResult(String smsResults){
//		SmsResultDao smsResultDao = new SmsResultDao();
		String[] results = smsResults.split("=")[1].split("\\^");
		for(String result : results){
			log.debug("*********"+result+"*********");
			log.debug("**********进入修改状态报告的方法*********");
			String[] srs = result.split(",");
			SmsResultCriteria conditions = new SmsResultCriteria();
			conditions.createCriteria().andSendSeqEqualTo(srs[ 0 ]);

			List<SmsResult> smsResultList = smsResultService.getSmsResult(conditions) ;
			SmsResult sr = null;
			if(smsResultList != null && smsResultList.size() > 0){
				sr = smsResultList.get(0);
			}
			sr.setSendSeq(srs[0]);
			sr.setPhone(srs[1]);
			if(srs[2].equalsIgnoreCase("DELIVRD")){
				sr.setRecFlag(Constant.REC_FLAG_SUCCESS);
			}else{
				sr.setRecFlag(Constant.REC_FLAG_FAIL);
				sr.setRecResult(srs[2]);
			}
			try {
				Date format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(srs[ 3 ]);

				sr.setRecTime(Timestamp.valueOf(format.toString()));
			} catch (ParseException e) {
				log.debug(srs[3]+"	日期格式转化错误！");
				log.debug("ParseException= [" + e.toString() + "]");
			}
			log.debug("**********开始修改接收到的状态报告*********");
			//保存解析的状态报告
			try {
				smsResultService.updateSmsResult(sr,conditions);
			}catch ( UpdateException e ){
				log.debug(e.getMessage());
			}

		}
		log.debug("状态报告修改完成");
	}
}

