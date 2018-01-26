/*
package com.ifudata.ums.system.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ifudata.crm.system.base.BeanFactory;
import com.ifudata.crm.system.config.Constants;
import com.ifudata.crm.system.config.ConstantsResultCode;
import com.ifudata.ums.crm.api.base.vo.RequestHeader;
import com.ifudata.ums.crm.api.commons.areaquery.interfaces.IAreaQueryDubboSV;
import com.ifudata.ums.crm.api.commons.areaquery.param.AreaQueryRequest;
import com.ifudata.ums.crm.api.commons.areaquery.param.AreaQueryResponse;
import com.ifudata.ums.crm.api.commons.areaquery.param.AreaVo;

*/
/**
 * 获得后厂提供的邮寄区域信息
 * 
 * @author gaosx
 *
 *//*

public class GnAreaUtil {
	private static Logger logger = Logger.getLogger(GnAreaUtil.class);
	*/
/**
	 * 获取 区域信息
	 * 
	 * @param areaLevel
	 * @param parentCode
	 * @return
	 *//*

	public static List<AreaVo> getAreas(String areaLevel,String parentCode){
		List<AreaVo> area = null;
		try {
			area = new ArrayList<AreaVo>();
			IAreaQueryDubboSV areaQueryDubboSV = (IAreaQueryDubboSV)BeanFactory.getBean("iAreaQueryDubboSV");
			AreaQueryRequest  request = new AreaQueryRequest();
			RequestHeader rh = new RequestHeader();
			request.setRequestHeader(rh);
			AreaQueryResponse response = null;
			if(Constants.AreaLevel.PROVINCE.equals(areaLevel)){
				//获得有效省分信息
				response = areaQueryDubboSV.queryAllProvince(request);
				if(response!=null&&ConstantsResultCode.SUCCESS.equals(response.getResponseHeader().getResultCode())){
					area = response.getAreaVos();
				}
			}else if(Constants.AreaLevel.CITY.equals(areaLevel)){
				//地市
				request.setProvinceCode(parentCode);
				response = areaQueryDubboSV.queryAllCityByProvince(request);
				if(response!=null&&ConstantsResultCode.SUCCESS.equals(response.getResponseHeader().getResultCode())){
					area = response.getAreaVos();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return area;
	}
	
	*/
/**
	 * @param areaCode
	 * @return
	 *//*

	public static AreaVo getArea(String areaCode){
		AreaVo vo = null;
		try {
			vo = new AreaVo();
			IAreaQueryDubboSV areaQueryDubboSV = (IAreaQueryDubboSV)BeanFactory.getBean("iAreaQueryDubboSV");
			AreaQueryRequest  request = new AreaQueryRequest();
			RequestHeader rh = new RequestHeader();
			request.setRequestHeader(rh);
			request.setAreaCode(areaCode);
			AreaQueryResponse response = areaQueryDubboSV.queryAreaMsgByAreaCode(request);
			if(response!=null&&ConstantsResultCode.SUCCESS.equals(response.getResponseHeader().getResultCode())){
				vo = response.getAreaVo();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return vo;
	}
}
*/
