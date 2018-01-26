package com.ifudata.ums.system.util;//package com.ifudata.crm.system.util;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.ifudata.tele.ums.service.bean.common.input.TcpCont;
//
//public class TcpContUtil {
//	
//	public static TcpCont  createTcpContIn(String method){
//		TcpCont tcpContIn = new TcpCont();
//		
//		//EOP转售给企业系统的AppKey
//		tcpContIn.setAppKey("#");
//		//API接口名称
//		tcpContIn.setMethod(method);
//		//请求时间
//		tcpContIn.setReqTime(TcpContUtil.getReqTime());
//		//请求签名字符串
//		tcpContIn.setSign("#");
//		//交易流水号 每笔交易都不一样
//		tcpContIn.setTransactionID(TransactionUtils.getTransactionID(tcpContIn.getAppKey()));
//		//tcpContIn.setTransactionID("#");
//		//接口版本
//		tcpContIn.setVersion("V1.0");
//		
//		return tcpContIn;
//	}
//	
//	private static String getReqTime(){
//		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//	}
//	
//	
//}
