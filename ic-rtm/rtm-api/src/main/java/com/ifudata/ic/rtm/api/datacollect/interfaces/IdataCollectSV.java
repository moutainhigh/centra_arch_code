package com.ifudata.ic.rtm.api.datacollect.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.base.exception.SystemException;
import com.ifudata.ic.rtm.api.datacollect.params.DataVO;
import com.ifudata.ic.rtm.api.datacollect.params.JsDataVO;
import com.ifudata.ic.rtm.api.datacollect.params.RtmResponse;

/**
 * 接受数据接口类 <br>
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 */
@Path("/dataService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IdataCollectSV {
	/**
	 * 接受rest协议传输的数据信息
	 * 
	 * @param obj 传输的具体数据信息
	 * @throws BusinessException
	 * @throws SystemException
	 * @author 
	 * @ApiCode RTM_0001
	 * @RestRelativeURL dataService/transResource
	 */
	@POST
	@Path("/transResource")
	public RtmResponse transResource(DataVO obj) throws BusinessException,SystemException;
	@interface TransResource{}
	
	/**
	 * 接受rest协议传输的结算数据信息
	 * 
	 * @param obj 传输的具体数据信息
	 * @throws BusinessException
	 * @throws SystemException
	 * @author 
	 * @ApiCode RTM_0002
	 * @RestRelativeURL dataService/JsResource
	 */
	@POST
	@Path("/JsResource")
	public RtmResponse JsResource(JsDataVO obj) throws BusinessException,SystemException;
	@interface JsResource{}
	


}
