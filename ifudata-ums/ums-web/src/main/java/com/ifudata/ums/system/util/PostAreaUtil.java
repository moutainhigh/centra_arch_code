/*
package com.ifudata.ums.system.util;

import java.util.ArrayList;
import java.util.List;

import com.ifudata.centra.base.vo.RequestHeader;
import com.ifudata.ums.system.base.BeanFactory;
import com.ifudata.ums.system.config.Constants;
import com.ifudata.ums.system.config.ConstantsResultCode;
import org.apache.log4j.Logger;

*/
/**
 * 获得后厂提供的邮寄区域信息
 * 
 * @author liwenxian
 *
 *//*

public class PostAreaUtil {

	 private static Logger logger = Logger.getLogger(PostAreaUtil.class);
	*/
/**
	 * 获取 区域信息
	 * 
	 * @param areaLevel
	 * @param parentCode
	 * @return
	 *//*

	public static List<PostAreaVo> getAreas(String areaLevel,String parentCode){
		List<PostAreaVo> area = null;
		try {
			area = new ArrayList<PostAreaVo>();
			IPostAreaQueryDubboSV iPostAreaQueryDubboSV = (IPostAreaQueryDubboSV) BeanFactory.getBean("iPostAreaQueryDubboSV");
	 		PostAreaQueryRequest  request = new PostAreaQueryRequest();
			RequestHeader rh = new RequestHeader();
			rh.setApplyChlId("1");
			request.setRequestHeader(rh);
			PostAreaQueryResponse response = null;
			if(Constants.AreaLevel.PROVINCE.equals(areaLevel)){
				//获得有效省分信息
				response = iPostAreaQueryDubboSV.queryAllProvince(request);
				if(response!=null&& ConstantsResultCode.SUCCESS.equals(response.getResponseHeader().getResultCode())){
					area = response.getAreaVos();
				}
			}else if(Constants.AreaLevel.CITY.equals(areaLevel)){
				//地市
				request.setProvinceCode(parentCode);
				response = iPostAreaQueryDubboSV.queryAllCityByProvince(request);
				if(response!=null&&ConstantsResultCode.SUCCESS.equals(response.getResponseHeader().getResultCode())){
					area = response.getAreaVos();
				}
			}else if(Constants.AreaLevel.COUNTY.equals(areaLevel)){
				//区县
				request.setCityCode(parentCode);
				response = iPostAreaQueryDubboSV.queryAllCountryByProvince(request);
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

	public static PostAreaVo getArea(String areaCode){
		PostAreaVo vo = null;
		try {
			vo = new PostAreaVo();
			IPostAreaQueryDubboSV iPostAreaQueryDubboSV = (IPostAreaQueryDubboSV)BeanFactory.getBean("iPostAreaQueryDubboSV");
			PostAreaQueryRequest  request = new PostAreaQueryRequest();
			RequestHeader rh = new RequestHeader();
			rh.setApplyChlId("1");
			request.setRequestHeader(rh);
			request.setAreaCode(areaCode);
			PostAreaQueryResponse response = iPostAreaQueryDubboSV.queryAreaMsgByAreaCode(request);
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
