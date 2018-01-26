package com.ifudata.smsrest.main;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
//import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.smsrest.constant.Constant;
import com.ifudata.smsrest.constant.SysParamConstant;
import com.ifudata.smsrest.db.mapper.bo.SgipSrcGsm;
import com.ifudata.smsrest.db.mapper.bo.SmsRestTask;
import com.ifudata.smsrest.db.mapper.bo.SmsResult;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHisCriteria;
import com.ifudata.smsrest.db.mapper.bo.SubsUser;
import com.ifudata.smsrest.db.mapper.bo.SubsUserCriteria;
import com.ifudata.smsrest.main.procotol.DeliverObj;
import com.ifudata.smsrest.main.procotol.ReportJsonObj;
import com.ifudata.smsrest.main.procotol.ReportObj;
import com.ifudata.smsrest.main.procotol.ReportRespJsonObj;
import com.ifudata.smsrest.main.procotol.ReportRespObj;
import com.ifudata.smsrest.main.procotol.SmsJsonObj;
import com.ifudata.smsrest.main.procotol.StatusJsonObj;
import com.ifudata.smsrest.main.procotol.SubmitJsonObj;
import com.ifudata.smsrest.main.procotol.SubmitObj;
import com.ifudata.smsrest.main.procotol.SubmitRespJsonObj;
import com.ifudata.smsrest.main.procotol.SubmitRespObj;
import com.ifudata.smsrest.manager.ISgipSrcGsm;
import com.ifudata.smsrest.manager.ISmsRestTask;
import com.ifudata.smsrest.manager.ISmsResult;
import com.ifudata.smsrest.manager.ISubsUser;
import com.ifudata.smsrest.manager.ISysSequenceCredit;
//import com.ifudata.smsrest.manager.ISmsRestTask;
//import com.ifudata.smsrest.manager.ISmsResult;
//import com.ifudata.smsrest.manager.ISysSequenceCredit;
//import com.ifudata.smsrest.db.mapper.bo.SmsRestTask;
//import com.ifudata.smsrest.db.mapper.bo.SmsRestTaskCriteria;
//import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;
import com.ifudata.smsrest.util.ApplicationContextUtil;
import com.ifudata.smsrest.util.DateUtils;
import com.ifudata.smsrest.util.MD;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class DbSvr {
	
	private static final Log log = LogFactory.getLog(DbSvr.class);
	private ISmsResult smsResultService = (ISmsResult)ApplicationContextUtil
			.getInstance().getBean("smsResultService");
	private ISmsRestTask smsRestTaskService = (ISmsRestTask)ApplicationContextUtil
			.getInstance().getBean("smsRestTaskService");
	private ISgipSrcGsm sgipSrcGsmService = (ISgipSrcGsm)ApplicationContextUtil
			.getInstance().getBean("sgipSrcGsmService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");
	private ISubsUser subsUserService = (ISubsUser)ApplicationContextUtil
			.getInstance().getBean("subsUserService");
	
	//deliver
	public String getRestTaskJson() {
		log.debug("getRestTaskJson  start");
		List<SmsRestTask> sctlist;
		try {
			sctlist = smsRestTaskService.getSmsRestTask(SysParamConstant.SERVICE_TYPE);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("smsRestTaskService error:" + e.getMessage());
			return "{}";
		}
		List<DeliverObj> deliverList = new ArrayList<DeliverObj>();
		
		for (SmsRestTask ele : sctlist) {
			DeliverObj obj = new DeliverObj();
			obj.setCust_code(Constant.CORP_SERVICE);
			obj.setSp_code(ele.getSpNumber());
			obj.setMobile(ele.getDeviceNumber());
			obj.setMsg_id(ele.getMsgId());
			obj.setContent(ele.getMessage());
			obj.setRecv_time(ele.getGetDate().toString());
			deliverList.add(obj);
		}
		
		Iterator<SmsRestTask> iterator = sctlist.iterator();
	    while (iterator.hasNext()) {
	    	SmsRestTask resobj = iterator.next();
	    	iterator.remove();
	    	//SmsRestTaskCriteria criteria = new SmsRestTaskCriteria();
	    	//criteria.createCriteria().andTaskSerialEqualTo(resobj.getTaskSerial());
			resobj.setOptDate(new Timestamp(System.currentTimeMillis()));
			try {
				//smsRestTaskService.updateSmsRestTask(resobj, criteria);
				smsRestTaskService.updateByPrimaryKey(resobj);
			} catch (Exception e) {
				log.error("updateSmsResultHis error:" + e.getMessage());
				e.printStackTrace();
				continue;
			}
	    }		
		
		Gson gson = new Gson();
		String gs= gson.toJson(deliverList);
		return gs;
	}
	
	//submit SendErrMsg[][]
	public String setSgipSrcFromJson(String src) {
		log.debug("setSgipSrcFromJson  start");
		//http响应
		SubmitRespJsonObj respJson = new SubmitRespJsonObj();
		List<SubmitRespObj> listSubmitResp = new ArrayList<SubmitRespObj>();

		List<SgipSrcGsm> sgiplist = new ArrayList<SgipSrcGsm>();
		List<SubmitObj> listSubmitObj;
		SubmitJsonObj subjson;
		Gson gson = new Gson();
		try {
			subjson = gson.fromJson(src, SubmitJsonObj.class); // (src, new TypeToken<SubmitJsonObj>() {}.getType());
			
			listSubmitObj = subjson.getSubmit();
		} catch (JsonSyntaxException e1) {
			//SendErrMsg
			log.error("fromJson error:" + e1.getMessage());
			SubmitRespObj resobj = new SubmitRespObj();
			resobj.setMsg_id("");
			resobj.setRetcode("6");
			resobj.setRetmsg("Json格式错误");
			listSubmitResp.add(resobj);
			respJson.setSubmitResp(listSubmitResp);

			return gson.toJson(respJson);
		}
		
		Iterator<SubmitObj> iterator = listSubmitObj.iterator();
	    while (iterator.hasNext()) {
	    	//synchronized (Object.class) {
	    		SubmitRespObj resobj1 = new SubmitRespObj();
	    		resobj1.setMsg_id("");
		    	SubmitObj obj = iterator.next();
		    	//listSubmitObj.remove(obj);
		    	if (resobj1.getMsg_id().equals("")) {
			    	Random rand = new Random(100);
			    	//int num = rand.nextInt(1000);
			    	resobj1.setMsg_id(obj.getCust_code() + DateUtils.format(new Date(), "yyyyMMddHHmmss") 
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0")
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0")
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0"));
		    	}
		    	Long smsid = 0l;
				try {
					smsid = sysSequence.getSequence("SMSPROXY");
				} catch (Exception e) {
					log.error("sysSequence.getSequence error:" + e.getMessage());
					e.printStackTrace();
					
					resobj1.setRetcode("7");
					resobj1.setRetmsg("内部错误");
					listSubmitResp.add(resobj1);					
					continue;
				}
				
				//验证手机号
				SubsUserCriteria criteria = new SubsUserCriteria();
				criteria.clear();
				criteria.createCriteria().andServiceNumEqualTo(obj.getMobile());
				criteria.createCriteria().andActiveTimeLessThanOrEqualTo(new Timestamp(System.currentTimeMillis()));
				criteria.createCriteria().andInactiveTimeGreaterThanOrEqualTo(new Timestamp(System.currentTimeMillis()));
				List<SubsUser> uses = subsUserService.getSubsUser(criteria);
				if (uses.size() <= 0) {
					resobj1.setRetcode("5");
					resobj1.setRetmsg("手机号码有误");
					listSubmitResp.add(resobj1);					
					continue;
				}
				
				String pwd = MD.sign(obj.getContent() + Constant.CORP_PWD, Constant.MD5_TD_CODE, "utf-8");
				if (! pwd.equals(obj.getSign())) {
					log.error("msg context sign invalidte:" + obj);
					resobj1.setRetcode("3");
					resobj1.setRetmsg("密码错误");
					listSubmitResp.add(resobj1);					
					continue;
				}
				
		    	SgipSrcGsm sgipSrcGsm = new SgipSrcGsm();
		    	
		    	//todo
		    	sgipSrcGsm.setTemplateId((Long)Long.getLong(Constant.TEMPLATE_ID));
		    	sgipSrcGsm.setSrcName(Constant.SRC_NAME);
		    	sgipSrcGsm.setServicetype(uses.get(0).getBasicOrgId());
		    	sgipSrcGsm.setVerifyid(BigDecimal.valueOf(smsid));
		    	sgipSrcGsm.setPhone(obj.getMobile());
		    	sgipSrcGsm.setGsmcontent(obj.getContent());
		    	sgipSrcGsm.setFlag(0);
		    	sgipSrcGsm.setPriority(0);
		    	sgipSrcGsm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    	
		    	sgiplist.add(sgipSrcGsm);
		    	//每条响应内容
		    	resobj1.setRetcode("0");
		    	resobj1.setRetmsg("发送成功");
		    	listSubmitResp.add(resobj1);
	    	//}
	    }
		
	    int in = 0;
		try {
			in = sgipSrcGsmService.insertSgipSrc(sgiplist);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("sgipSrcGsmService error:" + e.getMessage() + " sgipSrcGsmService.insertSgipSrc: " + in);
//			resobj.setRetcode("1");
//			resobj.setRetmsg(String.valueOf(in));
//			return gson.toJson(resobj);
		}

		respJson.setSubmitResp(listSubmitResp);
		return gson.toJson(respJson);
	}

	//setSmsFromJson  直接写sms表 内部处理不对外
	public String setSmsFromJson(String src) {
		log.debug("setSmsFromJson  start");
		//http响应 json串
		SubmitRespJsonObj respJson = new SubmitRespJsonObj();
		List<SubmitRespObj> listSubmitResp = new ArrayList<SubmitRespObj>();
		
		//
		List<SubmitObj> listSubmitObj = null;
		SubmitJsonObj subjson;
		Gson gson = new Gson();
		try {
			subjson = gson.fromJson(src, SubmitJsonObj.class); // (src, new TypeToken<SubmitJsonObj>() {}.getType());
			
			listSubmitObj = subjson.getSubmit();
		} catch (JsonSyntaxException e1) {
			//SendErrMsg
			log.error("fromJson error:" + e1.getMessage());
			SubmitRespObj resobj1 = new SubmitRespObj();
			resobj1.setMsg_id("");
			resobj1.setRetcode("6");
			resobj1.setRetmsg("Json格式错误");
			listSubmitResp.add(resobj1);
			respJson.setSubmitResp(listSubmitResp);
			return gson.toJson(respJson);
		}
		log.debug("setSmsFromJson"+listSubmitObj.toString());
		List<SmsResult> listSmsObj = new ArrayList<SmsResult>();
		Iterator<SubmitObj> iterator = listSubmitObj.iterator();
	    while (iterator.hasNext()) {
	    	//synchronized (Object.class) {
	    		SubmitRespObj resobj = new SubmitRespObj();
	    		resobj.setMsg_id("");
	    		SubmitObj obj = iterator.next();

	    		int npos = obj.getMsg_id().indexOf(obj.getCust_code());
	    		String strverify = "";
	    		if (npos >= 0)
	    			strverify = obj.getMsg_id().substring(npos + obj.getCust_code().length() + 14);

		    	if (strverify.equals("")) {
			    	Random rand = new Random(100);
			    	//int num = rand.nextInt(1000);
			    	
			    	resobj.setMsg_id(obj.getCust_code() + DateUtils.format(new Date(), "yyyyMMddHHmmss") 
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0")
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0")
			    				+ String.format("%5d", rand.nextInt(1000)).replace(" ", "0"));
		    	}
		    	
				//验证手机号
				SubsUserCriteria criteria = new SubsUserCriteria();
				criteria.clear();
				criteria.createCriteria().andServiceNumEqualTo(obj.getMobile())
					.andActiveTimeLessThanOrEqualTo(new Timestamp(System.currentTimeMillis()))
					.andInactiveTimeGreaterThanOrEqualTo(new Timestamp(System.currentTimeMillis()));
				List<SubsUser> uses = subsUserService.getSubsUser(criteria);
				if (uses.size() <= 0) {
					resobj.setRetcode("5");
					resobj.setRetmsg("手机号码有误");
					listSubmitResp.add(resobj);					
					continue;
				}
				
		    	Long smsid = 0l;
				try {
					//区分内部调用还是外部调用 外部调用使用 SMSPROXY
					smsid = sysSequence.getSequence("SEQ_SMS_RESULT");
				} catch (Exception e) {
					log.error("sysSequence.getSequence error:" + e.getMessage());
					e.printStackTrace();
					
					resobj.setRetcode("7");
					resobj.setRetmsg("内部错误");
					listSubmitResp.add(resobj);
					continue;
				}

				String pwd = MD.sign(obj.getContent() + Constant.CORP_PWD, Constant.MD5_TD_CODE, "utf-8");
				if (! pwd.equals(obj.getSign())) {
					log.error("msg context sign invalidte:" + obj);
					
					resobj.setRetcode("3");
					resobj.setRetmsg("密码错误");
					listSubmitResp.add(resobj);
					
					continue;
				}

				long verifyid = Integer.parseInt(strverify);
		    	SmsResult smsResult = new SmsResult();
		    	smsResult.setTemplateId(Long.getLong(Constant.TEMPLATE_BATCH_ID));
		    	smsResult.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    	smsResult.setContent(obj.getContent());
		    	smsResult.setVerifyid(verifyid);
		    	smsResult.setSendFlag(0);
		    	smsResult.setMaxTimes(1);
		    	smsResult.setSrcName(Constant.SRC_BATCH_NAME);
		    	smsResult.setPhone(obj.getContent());
		    	smsResult.setGsmcontent("");
		    	smsResult.setResSeq(smsid);
		    	smsResult.setServicetype(uses.get(0).getBasicOrgId());
		    	listSmsObj.add(smsResult);
		    	
		    	//每条响应内容
		    	resobj.setRetcode("0");
		    	resobj.setRetmsg("发送成功");
		    	listSubmitResp.add(resobj);
	    	//}
	    }
		
	    int in = 0;
		try {
			log.info("setSmsFromJson:" + listSmsObj.toString());
			in = smsResultService.insertSmsResult(listSmsObj);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("smsResultService error:" + e.getMessage() + " smsResultService.insertSmsResult:" + in);
			//return gson.toJson(resobj);
		}

		respJson.setSubmitResp(listSubmitResp);
		return gson.toJson(respJson);
	}
	
	//setSmsFromJson  直接写sms表 内部处理不对外
	public String setSmsFromJsonSms(String src) {
		log.debug("setSmsFromJsonSms  start");
		//http响应 json串
		SubmitRespJsonObj respJson = new SubmitRespJsonObj();
		List<SubmitRespObj> listSubmitResp = new ArrayList<SubmitRespObj>();
		log.debug("setSmsFromJsonSms"+src);
		SmsJsonObj subjson;
		Gson gson = new Gson();
		List<SmsResult> listSmsObj = null;
		List<SmsResult> smsResultList = new ArrayList<SmsResult>();
		try {
			subjson = gson.fromJson(src, SmsJsonObj.class); // (src, new TypeToken<SubmitJsonObj>() {}.getType());
			
			listSmsObj = subjson.getSubmit();
		} catch (JsonSyntaxException e1) {
			//SendErrMsg
			log.error("fromJson error:" + e1.getMessage());
			SubmitRespObj resobj1 = new SubmitRespObj();
			resobj1.setMsg_id("");
			resobj1.setRetcode("6");
//			resobj1.setRetmsg("Json格式错误");
			resobj1.setRetmsg("error of json ");
			listSubmitResp.add(resobj1);
			respJson.setSubmitResp(listSubmitResp);
			return gson.toJson(respJson);
		}
		log.debug("setSmsFromJsonSms:"+listSmsObj.toString());
		

		for (SmsResult smsResult : listSmsObj ) {
		//List<SmsResult> listSmsObj = subjson.getSubmit();
		//Iterator<SmsResult> iterator = listSmsObj.iterator();
	    //while (iterator.hasNext()) {
	    	//synchronized (Object.class) {
	    		SubmitRespObj resobj = new SubmitRespObj();
	    		resobj.setMsg_id("");
	    		//SmsResult smsResult = iterator.next();

				//验证手机号
				SubsUserCriteria criteria = new SubsUserCriteria();
				criteria.clear();
				criteria.createCriteria().andServiceNumEqualTo(smsResult.getPhone())
					.andActiveTimeLessThanOrEqualTo(new Timestamp(System.currentTimeMillis()))
					.andInactiveTimeGreaterThanOrEqualTo(new Timestamp(System.currentTimeMillis()));
				List<SubsUser> uses = null;
				try {
					uses = subsUserService.getSubsUser(criteria);
					if (uses.size() <= 0) {
						resobj.setRetcode("5");
//						resobj.setRetmsg("手机号码有误");
						resobj.setRetmsg("nbr error");
						listSubmitResp.add(resobj);					
						continue;
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error("subsUserService error:" + e.getMessage() + " getSubsUser err:");
					continue;
				}
				
		    	//Long smsid = 0l;
		    	Long resseq = 0l;
				try {
					//区分内部调用还是外部调用 外部调用使用 SMSPROXY
					//smsid = sysSequence.getSequence("SMSBATCHBUS");

					resseq = sysSequence.getSequence("SEQ_SMS_RESULT");
				} catch (Exception e) {
					log.error("sysSequence.getSequence error:" + e.getMessage());
					e.printStackTrace();
					
					resobj.setRetcode("7");
//					resobj.setRetmsg("内部错误");
					resobj.setRetmsg("system error");
					listSubmitResp.add(resobj);
					continue;
				}

		    	smsResult.setGsmcontent("");
		    	smsResult.setResSeq(resseq);
		    	//smsResult.setVerifyid(smsid);
		    	smsResult.setSendFlag(0);
		    	smsResult.setSrcName(Constant.SRC_BATCH_NAME);
		    	smsResult.setGsmcontent("");
		    	
		    	smsResult.setMaxTimes(1);
		    	smsResult.setTemplateId(Long.getLong(Constant.TEMPLATE_BATCH_ID));
		    	smsResult.setServicetype(uses.get(0).getBasicOrgId());
		    	//listSmsObj.add(smsResult);
		    	smsResultList.add(smsResult);
		    	//每条响应内容
		    	resobj.setMsg_id(smsResult.getVerifyid().toString());
		    	resobj.setRetcode("0");
		    	//resobj.setRetmsg("发送成功");
		    	resobj.setRetmsg("send ok");
		    	listSubmitResp.add(resobj);
		    	//break;
	    	//}
	    }
		
	    int in = 0;
		try {
			log.info("setSmsFromJsonSms:" + smsResultList.toString());
			in = smsResultService.insertSmsResult(smsResultList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("smsResultService error:" + e.getMessage() + " insert err:" + in);
		}

		respJson.setSubmitResp(listSubmitResp);
		return gson.toJson(respJson);
	}
	
	//report 只找his表中reporttime=null的  返回错误码见  3.4	返回码参数说明
	public String getReportJson(String src) {
		log.debug("getReportJson  start");
		if (src.equals(""))
			return "2";
		Gson gson = new Gson();
		ReportJsonObj reportjsonobj = null;
		try {
			reportjsonobj = gson.fromJson(src, ReportJsonObj.class);
		} catch (JsonSyntaxException e1) {
			//SendErrMsg
			log.error("fromJson error:" + e1.getMessage());
			return "6";
		}
		
		if (reportjsonobj == null)
			return "6";
		if (reportjsonobj.getReport().size() <= 0)
			return "6";
		ReportObj reportobj = reportjsonobj.getReport().get(0);
		String corp_id = reportobj.getCust_code();
		if (!corp_id.equals(Constant.ID)) {
			return "2";
		}
		String sgin = MD.sign(Constant.ID + Constant.CORP_PWD, Constant.MD5_TD_CODE, "utf-8");
		if (!sgin.equals(reportobj.getSgin()))
			return "3";
		
		List<SmsResultHis> sctlist;
		String currmonth = DateUtils.getCurrMonth();
		try {
			sctlist = smsResultService.getSmsResultHis(currmonth, Constant.SRC_BATCH_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getReportJson error:" + e.getMessage());
			return "7";
		}
		
		List<ReportRespObj> list = new ArrayList<ReportRespObj>();
		
		for (SmsResultHis ele : sctlist) {
			ReportRespObj obj = new ReportRespObj();
			obj.setMsg_id(ele.getResSeq().toString());
			obj.setSeq(ele.getSendSeq());
			obj.setErr(ele.getRecFlag().toString());
			obj.setFail_desc(ele.getRemark());

			obj.setReport_time(ele.getRecTime().toString());
			list.add(obj);
		}
		
		Iterator<SmsResultHis> iterator = sctlist.iterator();
	    while (iterator.hasNext()) {
	    	SmsResultHis resobj = iterator.next();
	    	iterator.remove();
	    	SmsResultHisCriteria criteria = new SmsResultHisCriteria();
	    	criteria.currmonth = currmonth;
	    	criteria.createCriteria().andResSeqEqualTo(resobj.getResSeq());
			resobj.setReportingTime(new Timestamp(System.currentTimeMillis()));
			try {
				smsResultService.updateSmsResultHis(currmonth, resobj, criteria);
			} catch (Exception e) {
				log.error("updateSmsResultHis error:" + e.getMessage());
				e.printStackTrace();
				continue;
			}
	    }
	    ReportRespJsonObj jsonobj = new ReportRespJsonObj();
		jsonobj.setReportResp(list);
		
		String gs = gson.toJson(jsonobj);
		return gs;
	}
	
	public String getFullObjStatusJson(String src) {
		log.debug("getFullObjStatusJson  start");
		if (src.equals(""))
			return "2";
		Gson gson = new Gson();
		ReportJsonObj reportjsonobj = gson.fromJson(src, ReportJsonObj.class);
		if (reportjsonobj == null)
			return "6";
		if (reportjsonobj.getReport().size() <= 0)
			return "6";
		ReportObj reportobj = reportjsonobj.getReport().get(0);
		String corp_id = reportobj.getCust_code();
		if (!corp_id.equals(Constant.ID)) {
			return "2";
		}
		String sgin = MD.sign(Constant.ID + Constant.CORP_PWD, Constant.MD5_TD_CODE, "utf-8");
		if (!sgin.equals(reportobj.getSgin()))
			return "3";		
		
		List<SmsResultHis> sctlist;
		String currmonth = DateUtils.getCurrMonth();
		try {
			sctlist = smsResultService.getSmsResultHis(currmonth, Constant.SRC_BATCH_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getReportJson error:" + e.getMessage());
			return "7";
		}

		//上个月的
		String privmonth = DateUtils.getPrivMonth();
		List<SmsResultHis> sctlistpriv;
		try {
			sctlistpriv = smsResultService.getSmsResultHis(privmonth, Constant.SRC_BATCH_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getReportJson error:" + e.getMessage());
			return "7";
		}
		
		//更新his表
		Iterator<SmsResultHis> iterator = sctlist.iterator();
	    while (iterator.hasNext()) {
	    	SmsResultHis resobj = iterator.next();
	    	//iterator.remove();
	    	SmsResultHisCriteria criteria = new SmsResultHisCriteria();
	    	criteria.currmonth = currmonth;
	    	criteria.createCriteria().andResSeqEqualTo(resobj.getResSeq());
			resobj.setReportingTime(new Timestamp(System.currentTimeMillis()));
			try {
				smsResultService.updateSmsResultHis(currmonth, resobj, criteria);
			} catch (Exception e) {
				log.error("updateSmsResultHis error:" + e.getMessage());
				e.printStackTrace();
				continue;
			}
	    }
	    //上个月的历史表
		Iterator<SmsResultHis> iteratorpriv = sctlistpriv.iterator();
	    while (iteratorpriv.hasNext()) {
	    	SmsResultHis resobj = iteratorpriv.next();
	    	//iteratorpriv.remove();
	    	SmsResultHisCriteria criteria = new SmsResultHisCriteria();
	    	criteria.currmonth = privmonth;
	    	criteria.createCriteria().andResSeqEqualTo(resobj.getResSeq());
			resobj.setReportingTime(new Timestamp(System.currentTimeMillis()));
			try {
				smsResultService.updateSmsResultHis(privmonth, resobj, criteria);
			} catch (Exception e) {
				log.error("updateSmsResultHis error:" + e.getMessage());
				e.printStackTrace();
				continue;
			}
	    }	    
	    
		if (sctlistpriv.size() > 0) {
			sctlist.addAll(sctlistpriv);
		}
		
		StatusJsonObj jsonobj = new StatusJsonObj();
		jsonobj.setStatus(sctlist);
		String gs = gson.toJson(jsonobj);
		
		return gs;
	}
}
