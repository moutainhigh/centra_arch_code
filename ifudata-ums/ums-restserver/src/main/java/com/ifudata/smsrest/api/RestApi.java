package com.ifudata.smsrest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ifudata.smsrest.main.DbSvr;
import com.sun.jersey.spi.resource.Singleton;

@Singleton  
@Path("")
public final class RestApi {
	private static final Logger log = LoggerFactory.getLogger(RestApi.class);
	@POST  
    @Consumes(MediaType.TEXT_HTML)  
    @Produces(MediaType.TEXT_HTML)
	@Path("SENDMSGBATCH")
	
	public String SendMsgBatch(String getData){
		try{
			DbSvr dbSvr = new DbSvr();
			String res = dbSvr.setSmsFromJsonSms(getData);
			log.debug("setSmsFromJsonSms(getData):" + res);
			
			return res;
		}catch(Exception e){
			log.error("ums 发送短信异常",e);
			return "1";
		}
	}
	
	@POST  
    @Consumes(MediaType.TEXT_HTML)  
    @Produces(MediaType.TEXT_HTML)
	@Path("SENDMSG")
	public String SendMsg(String getData){
		try{
			DbSvr dbSvr = new DbSvr();
			String res = dbSvr.setSgipSrcFromJson(getData);
			log.debug("setSgipSrcFromJson(getData):" + res);
			return res;
		}catch(Exception e){
			log.error("发送短信异常",e);
			return "1";
		}
	}
	
	@POST  
    @Consumes(MediaType.TEXT_HTML)  
    @Produces(MediaType.TEXT_HTML)
	@Path("MSGREPORT")
	public String MsgReport(String getData){
		try{
			DbSvr dbSvr = new DbSvr();
			String res = dbSvr.getReportJson(getData);
			log.debug("getReportJson(getData):" + res);
			return res;
		}catch(Exception e){
			log.error("获取状态报告异常",e);
			return "1";
		}
	}
	
	@POST  
    @Consumes(MediaType.TEXT_HTML)  
    @Produces(MediaType.TEXT_HTML)
	@Path("FULLOBJSTATUS")
	public String FullObjStatus(String getData){
		try{
			DbSvr dbSvr = new DbSvr();
			String res = dbSvr.getFullObjStatusJson(getData);
			log.debug("getFullObjStatusJson(getData):" + res);
			return res;
		}catch(Exception e){
			log.error("ums获取状态报告异常",e);
			return "1";
		}
	}

	@POST  
    @Consumes(MediaType.TEXT_HTML)  
    @Produces(MediaType.TEXT_HTML)
	@Path("RECMSG")
	public String RecMsg(String getData){
		try{
			DbSvr dbSvr = new DbSvr();
			String res = dbSvr.getRestTaskJson();
			log.debug("getRestTaskJson(getData):" + res);
			return res;
		}catch(Exception e){
			log.error("获取任务列表异常",e);
			return "1";
		}
	}	
}

