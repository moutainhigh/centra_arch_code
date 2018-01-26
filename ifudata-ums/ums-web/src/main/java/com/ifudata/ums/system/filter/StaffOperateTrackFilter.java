/*
package com.ifudata.ums.system.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ifudata.ums.system.base.BeanFactory;
import com.ifudata.ums.system.config.Constants;
import com.ifudata.ums.system.exception.BusiException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.ums.crm.api.base.vo.ResponseHeader;
import com.ifudata.ums.crm.api.commons.operoptlogmaintain.interfaces.IOperOptLogMaintainDubboSV;
import com.ifudata.ums.crm.api.commons.operoptlogmaintain.param.OperOptLogMaintainRequest;
import com.ifudata.ums.crm.api.commons.operoptlogmaintain.param.OperOptLogMaintainResponse;
import com.ifudata.ums.crm.api.commons.operoptlogmaintain.param.OperOptLogVO;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnOperVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnStaffVo;

public class StaffOperateTrackFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(StaffOperateTrackFilter.class);
	*/
/**资源路径*//*

	private String[] obviablePath;
	private IOperOptLogMaintainDubboSV iOperOptLogMaintainDubboSV;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	    
	    @SuppressWarnings("resource")
	    String exclude = filterConfig.getInitParameter("obviablePath");
	    try {
            BeanFactory.loadApplicationContext(filterConfig.getServletContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
	    iOperOptLogMaintainDubboSV = (IOperOptLogMaintainDubboSV) BeanFactory.getBean("iOperOptLogMaintainDubboSV");
        if (exclude != null) {
            obviablePath = exclude.split(",");
        }
		logger.info("过滤器[StaffOperateTrackFilter]执行初始化init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			HttpSession session = httpRequest.getSession();
			String uri = httpRequest.getRequestURI();
			
			//请求是否包含?
			if(!StringUtils.isBlank(uri)&&uri.contains("?")){
				uri = uri.substring(0, uri.indexOf("?"));
			}
			
			//判断uri是否包含项目名称
			String ctxPath = httpRequest.getContextPath();
			if(uri.startsWith(ctxPath)){
				uri = uri.substring(ctxPath.length());
			}
			if (isObviable(uri)) {
			    return;
			}
			
			//获取所有需要被拦截的请求
			Map<String,String> urlMap = Constants.OPER_OPT_LOG.getOperUrlMap();
			if(urlMap.containsKey(uri)){
			    logger.info("操作轨迹："+uri);
//				String optDesc = "";
//				if("/busichg/subsuser/close/toFeeCal".equals(uri)){
//					//根据busiCode进行区分
//					String busiCode = httpRequest.getParameter("busiCode");
//					if(ConstantsBusiCode.BUSI_OPER_CODE_TTZJS.equals(busiCode)){
//						optDesc = "操作了妥投转拒销户费用计算";
//					}else{
//						optDesc = "操作了强制销户费用计算";
//					}
//				}else if("/busichg/forceCloseAccountController/toFeeCal".equals(uri)){
//					//根据busiType区分 1是预销户 2取消预销户
//					String busiType = httpRequest.getParameter("busiType");
//					if("1".equals(busiType)){
//						optDesc = "操作了预销户费用计算";
//					}else{
//						optDesc = "操作了取消预销户费用计算";
//					}
//				}else{
//					optDesc = urlMap.get(uri);
//				}
			    String optDesc = urlMap.get(uri);
				
				//获取operId
				GnStaffVo gnStaffVo = (GnStaffVo) session.getAttribute(Constants.SESSION_OPER);
			    long operId = 0l;
                //获取chnlId
                String chnlId = "";
                //获取departId
                String departId = "";
                if(gnStaffVo != null){
                    GnOperVo gnOperVo = gnStaffVo.getGnOperVo();
                    if(gnOperVo != null){                   
                        chnlId = gnOperVo.getChnlId();
                        departId = gnOperVo.getDepartId();
                        operId = gnOperVo.getOperId();
                    }
                }
			
				//创建接口请求对象
				OperOptLogMaintainRequest operateLogRequest = new OperOptLogMaintainRequest();
				operateLogRequest.setRequestHeader(RequestUtil.getRequestHeader(httpRequest));
				//封装参数对象
				OperOptLogVO operOptLogVO = new OperOptLogVO();
				operOptLogVO.setOperId(operId);
				operOptLogVO.setChnlId(chnlId);
				operOptLogVO.setDepartId(departId);
				operOptLogVO.setOptDesc(optDesc);
				operateLogRequest.setOperOptLogVo(operOptLogVO);
				//后场接口调用
				OperOptLogMaintainResponse OperLogResponse = iOperOptLogMaintainDubboSV.createOptLog(operateLogRequest);
				ResponseHeader responseHeader = OperLogResponse.getResponseHeader();
				if(responseHeader.getResultCode().equals(ConstantsResultCode.SUCCESS)){
					logger.info("记录营业员操作轨迹后场返回成功");
				}else{
					throw new BusiException("记录营业员操作轨迹异常",responseHeader.getResultCode(),responseHeader.getResultMessage(),responseHeader.getDetail(),"");
				}
			}
		} catch (Exception e) {
			logger.error("记录营业员操作轨迹出现异常,异常信息-->"+e);
		} finally {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		logger.info("过滤器[StaffOperateTrackFilter]执行完成destroy");
	}
	   private boolean isObviable(String servletPath) {
	        if (obviablePath == null)
	            return false;
	        for (int i = 0; i < obviablePath.length; i++) {
	            if (servletPath.indexOf(obviablePath[i]) != -1) {
	                return true;
	            }
	        }
	        return false;
	    }
}
*/
