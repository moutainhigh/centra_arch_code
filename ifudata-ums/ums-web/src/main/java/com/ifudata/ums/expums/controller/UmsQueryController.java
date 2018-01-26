package com.ifudata.ums.expums.controller;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.centra.sdk.dubbo.util.DubboConsumerFactory;
import com.ifudata.ums.api.applybatch.interfaces.IOrdApplyBatchDubboSV;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusResponse;
import com.ifudata.ums.api.applybatch.param.SendStatusInfo;
import com.ifudata.ums.system.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/expums")
public class UmsQueryController extends BaseController {
	private Logger logger = Logger.getLogger(UmsQueryController.class);

	/* 根路径 */
	private static final String BASE = "expums";
	private final String UMS_QUERY_URL = "/expums/UmsFileNameQuery";// 查询 页面的路径
	/* 点击查询*/
	private static final String TO_UMS_INFO_QUERY = "/umsQueryInfoList"; 
	private static final String UMS_INFO_QUERY = "/UmsInformation";


	@RequestMapping(value = "/UmsFileNameQuery")
	public String UmsFileNameQuery(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("按照文件名查询页面.......");
		return UMS_QUERY_URL; // 返回页面的路径
	}



	// 查询按钮
	@RequestMapping(value = TO_UMS_INFO_QUERY)
	public String umsQueryInfoList(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		String fileNameJ; 
		String errMsg;
		try { 
			fileNameJ = request.getParameter("fileName"); // 文件名称（模糊）“fileName”  是jsp函数里定义 的变量 var fileName = $(_this.settings.FILE_NAME).val();
			if (null == fileNameJ) 
			{
				fileNameJ = "";
			} 

			logger.info("开始查询文件名含(模糊)[" + fileNameJ + "]");  
			// 分页信息
			PageInfo<SendStatusInfo> p = new PageInfo<SendStatusInfo>();
			int pageNo = 1;
			pageNo = Integer.parseInt(request.getParameter("pageNo"));  // 从页面获得第几页
			int pageSize = 5;
			p.setPageNo(pageNo);
			p.setPageSize(pageSize); 

			/* 接口入参 */  
			OrdSendStatusRequest param = new OrdSendStatusRequest();
			param.setPageInfo(p);  
			param.setFileName(fileNameJ);   
			System.out.println("fileNameJ : " + fileNameJ); 
			System.out.println("pageNo : " +  pageNo);

			request.setAttribute("fileName_paramJ", fileNameJ); // request.setAttribute就是保存数据，然后还可以用getAttribute方法来取出。
			IOrdApplyBatchDubboSV iOrdApplyBatchDubboSV = DubboConsumerFactory.getService(IOrdApplyBatchDubboSV.class);
			OrdSendStatusResponse result = iOrdApplyBatchDubboSV.sendStatus(param); // 后台查询接收接口

			logger.info(JSON.toJSONString(result));
			PageInfo<SendStatusInfo> pageInfoJ =result.getSendStatus(); 
			System.out.println("stat23232323e:" + result.getState()); 
			if ("1".equals(result.getState()) || "2".equals(result.getState()))
				request.setAttribute("listSize", 1); 
			else
			{ 
				if ("3".equals(result.getState())) 
				{
					if (null != pageInfoJ && !CollectionUtils.isEmpty(pageInfoJ.getResult())) 
						request.setAttribute("pageInfo", pageInfoJ);  // request.setAttribute就是保存数据，然后还可以用getAttribute方法来取出。
					else
						request.setAttribute("listSize", 0); 
				} 
				else
				{
					request.setAttribute("listSize", 0); 
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			errMsg = "获取查询数据异常：[" + e.getMessage() + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg);
		}
		// 跳转到jsp文件夹中的页面 UmsInformation.jsp  
		return BASE + UMS_INFO_QUERY;
	}


 
	
}
