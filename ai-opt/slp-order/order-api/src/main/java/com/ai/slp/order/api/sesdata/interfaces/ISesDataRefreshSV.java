package com.ai.slp.order.api.sesdata.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListRequest;
import com.ai.slp.order.api.sesdata.param.SesDataByPageRequest;
import com.ai.slp.order.api.sesdata.param.SesDataResponse;

@Path("/ses")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ISesDataRefreshSV {
	/**
	 * 从数据库中刷新数据到es(性能备用)
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiCode SES_001
	 * @ApiDocMethod
	 * @RestRelativeURL sesData/updateSesData
	 */
	@POST
	@Path("/refreshSesData")
	SesDataResponse refreshSesData(SesDataByPageRequest request) throws BusinessException, SystemException;
	
	/**
	 * 按条件删除es数据(性能测试备用)
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiCode SES_001
	 * @ApiDocMethod
	 * @RestRelativeURL sesData/updateSesData
	 */
	@POST
	@Path("/deleteSesData")
	SesDataResponse deleteSesData(BehindQueryOrderListRequest request) throws BusinessException, SystemException;
	
	
}
