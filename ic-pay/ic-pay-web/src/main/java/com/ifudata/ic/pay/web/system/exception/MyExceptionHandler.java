package com.ifudata.ic.pay.web.system.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.pay.web.business.payment.annotation.BackTransService;
import com.ifudata.ic.pay.web.business.payment.model.BaseRes;
import com.ifudata.ic.pay.web.system.constants.ExceptCodeConstants;
import com.ifudata.ic.pay.web.system.constants.PayConstants;

public class MyExceptionHandler implements HandlerExceptionResolver {
    
    private static final Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if(method.isAnnotationPresent(BackTransService.class)) {
                this.handlerBackTransException(response, ex);
                return new ModelAndView();
            }
        }
        
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex); 
        if (ex instanceof BusinessException) {
            return new ModelAndView("error/businessError", model);
        }
        
        return new ModelAndView("error/businessError", model);
    }
    
    /**
     * 支付平台同步交易异常统一处理
     * @param response
     * @param ex
     * @ApiDocMethod
     * @ApiCode
     */
    private void handlerBackTransException(HttpServletResponse response, Exception ex) {
        BaseRes errRes = this.toResponse(ex);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.write(JSON.toJSONString(errRes));
            printWriter.flush();
        } catch (IOException e) {
            LOG.error("支付平台同步返回出错", e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }
    
    /**
     * 支付平台同步接口异常转换
     * @param ex
     * @return
     * @ApiDocMethod
     * @ApiCode
     */
    private BaseRes toResponse(Exception ex) {
        String returnFaild = PayConstants.ReturnCode.FAILD;
        if (ex instanceof BusinessException) {
            BusinessException e = (BusinessException) ex;
            return new BaseRes(returnFaild, e.getErrorCode(), e.getErrorMessage());
        }   
        
        if (ex instanceof SystemException) {
            SystemException e = (SystemException) ex;
            return new BaseRes(returnFaild, e.getErrorCode(), e.getErrorMessage());
        }
        
        if (ex instanceof NullPointerException) {
            return new BaseRes(returnFaild, ExceptCodeConstants.SYSTEM_ERROR, "空指针异常，请联系支付中心处理");
        }
        
        return new BaseRes(returnFaild, ExceptCodeConstants.SYSTEM_ERROR, "系统异常，请联系支付中心处理。异常摘要:" + ex.getMessage());
    }
    
}
