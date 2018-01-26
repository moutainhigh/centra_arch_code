/*
package com.ifudata.ums.system.common;

import javax.servlet.http.HttpSession;

import com.ifudata.ums.system.config.ConstantsResultCode;
import com.ifudata.ums.system.coremodel.SessionInfo;
import com.ifudata.ums.system.exception.BusiException;
import com.ifudata.ums.system.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


*/
/**
 * 临时加载 用户session Title: ums-CRM <br>
 * Description: <br>
 * Date: 2014年3月5日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author liwenxian
 *//*

public class LoadOperSession {

	*/
/**
	 * 封装操作员信息
	 * 
	 * @param session
	 * @param operCode
	 * @author liwenxian
	 *//*

	private static Logger logger = LoggerFactory.getLogger(LoadOperSession.class);
	public static void loadOperInfo(HttpSession session, String operCode) {

		try {
//			if (SessionInfo.isSessionExp(session)) {
				*/
/**
				 * 调用后厂服务封装操作员信息
				 *//*

				IGnStaffDubboSV gnStaffDubboSV = (IGnStaffDubboSV) BeanFactory.getBean("gnStaffDubboSV");
				if (gnStaffDubboSV != null) {
					StaffMaintainRequest request = new StaffMaintainRequest();
					RequestHeader header = new RequestHeader();
					header.setOperId(1l);
					request.setRequestHeader(header);
					request.setOperCode(operCode);
					// request.setStaffNo(operCode);
					// request.setOperId("2");
					StaffMaintainResponse response = gnStaffDubboSV.queryBusinessStaff(request);
					if (response != null) {
						String resultCode = response.getResponseHeader().getResultCode();
						// 调用服务 成功
						if (ConstantsResultCode.SUCCESS.equals(resultCode)) {
							SessionInfo.setOperInfo(session, response.getGnStaffVo());
						} else {
							throw new BusiException("业务受理失败", response.getResponseHeader().getResultCode(),
									response.getResponseHeader().getResultMessage(), response.getResponseHeader().getDetail(), "");
							// 后厂返回 错误
							//newOperInfo(session, operCode);
						}
					} else {
						//newOperInfo(session, operCode);
						throw new BusiException("业务受理失败", "",
								"无返回", "", "");
					}
					*/
/*
					 * request.setOperId(""); request.setStaffNo("admin");
					 * StaffMaintainResponse response2 =
					 * gnStaffDubboSV.queryStaffInfoByStaffNo(request);
					 * if(response != null){
					 * System.out.println("CODE---------------------:"
					 * +response2.getResponseHeader().getResultCode());
					 * System.out.println("MES---------------------:"+response2.
					 * getResponseHeader().getResultMessage()); }
					 *//*


				}
//			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//newOperInfo(session, operCode);
			if(e instanceof BusiException)
				throw (BusiException)e;
			throw new SystemException("","",e.getMessage(),"");
		}
	}

	*/
/**
	 * 虚拟封装操作员信息
	 *//*

	private static void newOperInfo(HttpSession session, String operCode) {
		String code = operCode == null ? "admin" : operCode;

		GnStaffVo operInfo = new GnStaffVo();
		GnOperVo oper = new GnOperVo();
		GnDepartVo depart = new GnDepartVo();
		GnChannelVo channel = new GnChannelVo();

		// 人员
		operInfo.setStaffId("1");
		operInfo.setStaffNo(code);
		operInfo.setStaffName("超级管理员");
		operInfo.setStaffClass("1");
		operInfo.setDepartId("1");
		operInfo.setChnlId("1");
		operInfo.setContactTel("010-88018801");
		operInfo.setEmail("admin@163.com");
		operInfo.setAddress("西城区");
		operInfo.setPostcode("100100");
		operInfo.setState("1");
		// 操作员
		oper.setOperId(1);
		oper.setStaffId("1");
		oper.setOperCode(code);
		oper.setOperType("0");
		oper.setState("1");

		// 部门
		depart.setDepartId("1");
		depart.setDepartName("中国国际期货集团总部");
		depart.setDepartKindType("3");
		depart.setDepartLevel("0");
		depart.setProvinceCode("00");
		depart.setCityCode("000");
		depart.setAreaCode("00");
		depart.setProvinceName("总部");
		depart.setCityName("中心");
		depart.setAreaName("中心");
		depart.setAreaLevel("0");
		depart.setState("1");
		depart.setSortId(1);

		channel.setProvinceCode("00");
		channel.setCityCode("000");
		channel.setAreaCode("00");
		channel.setProvinceName("总部");
		channel.setCityName("中心");
		channel.setAreaName("中心");
		channel.setAreaLevel("0");
		channel.setChnlId("1");
		channel.setChnlName("测试1渠道");

		operInfo.setGnOperVo(oper);
		operInfo.setGnDepartVo(depart);
		operInfo.setGnChannelVo(channel);
		SessionInfo.setOperInfo(session, operInfo);
	}

}
*/
