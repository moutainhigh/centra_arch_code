package com.ifudata.ums.system.base;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ifudata.ums.system.exception.SystemException;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * controller基类
 * @author weichuang
 */
public class BaseController {
	private Logger logger = Logger.getLogger(BaseController.class);
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;
	/**
	 * 响应客户端结果 成功、失败、错误
	 */
	private static final String RES_RESULT = "RES_RESULT";
	/**
	 * 响应客户端结果描述
	 */
	private static final String RES_MSG = "RES_MSG";
	/**
	 * 响应客户端数据
	 */
	private static final String RES_DATA = "RES_DATA";
	/**
	 * Exception Stack
	 */
	private static final String RES_ES = "RES_ES";
	/**
	 * 响应客户端结果 成功
	 */
	private static final String SUCCESS = "SUCCESS";
	/**
	 * 响应客户端结果 失败
	 */
	private static final String FAILED = "FAILED";
	/**
	 * 响应客户端结果 错误
	 */
	private static final String ERROR = "ERROR";

	/**
	 * json响应客户端成功
	 */
	protected void responseSuccess(HttpServletResponse response, String msg, JSONObject data) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, SUCCESS);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_DATA, data);
			printWriter.write(jsonObject.toString());
			printWriter.flush();
		} catch (Exception e) {
			logger.error("重大异常，responseSuccess报错！", e);
		} finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}

	/**
	 * json响应客户端失败
	 */
	protected void responseFailed(HttpServletResponse response, String msg, JSONObject data) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, FAILED);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_DATA, data);
			printWriter.write(jsonObject.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseFailed报错！", e);
		} finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}

	/**
	 * json响应客户端错误信息
	 */
	protected void responseError(HttpServletResponse response, String msg, Exception stackException) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, ERROR);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_ES, stackException.getStackTrace());
			jsonObject.put(RES_DATA, stackException.getMessage());
			printWriter.write(jsonObject.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseError报错！", e);
		} finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}

	/**
	 * json响应客户端true
	 */
	protected void responseTrue(HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			printWriter.write("true");
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseTrue报错！", e);
		} finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}

	/**
	 * json响应客户端false
	 */
	protected void responseFalse(HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			printWriter.write("false");
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseFalse报错！", e);
		} finally {
			if(printWriter!=null){
				printWriter.close();
			}
		}
	}

	/**
	 * 页面记录异常信息
	 */
	protected void markException(String msg, Exception e) {
		request.setAttribute("es", msg);
		request.setAttribute("exception", e);
	}
	/**
	/* * 页面记录异常信息
	 *//*
	protected  GnStaffVo getOperInfo(){
		return SessionInfo.getOperInfo(session);
	}
	
	protected String getProvinceCode(){
		if ("1".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnDepartVo().getProvinceCode();
		}else if ("2".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnChannelVo().getProvinceCode();
		}
		
		throw new SystemException("无法获取省份Code");
	}
	
	protected String getProvinceName(){
		if ("1".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnDepartVo().getProvinceName();
		}else if ("2".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnChannelVo().getProvinceName();
		}
		
		throw new SystemException("无法获取省份名字");
	}
	
	protected String getCityCode(){
		if ("1".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnDepartVo().getCityCode();
		}else if ("2".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnChannelVo().getCityCode();
		}
		
		throw new SystemException("无法获取地市Code");
	}
	
	protected String getCityName(){
		if ("1".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnDepartVo().getCityName();
		}else if ("2".equals(getOperInfo().getGnOperVo().getOrgType())){
			return getOperInfo().getGnChannelVo().getCityName();
		}
		
		throw new SystemException("无法获取地市名字");
	}
	
	protected GnDepartVo getGnDepartVo(){
		return getOperInfo().getGnDepartVo();
	}
	
	protected GnChannelVo getGnChannelVo(){
		return getOperInfo().getGnChannelVo();
	}*/
}
