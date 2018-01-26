package com.ifudata.ums.system.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ifudata.ums.system.exception.SystemException;
import org.apache.log4j.Logger;
import org.json.JSONObject;


public class AuthenticationFilter implements Filter {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);

    private String[] obviablePath;
    
    public static final String TOKEN_EXIST = "-1";
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
     * 响应客户端结果 失败
     */
    private static final String REPEATFAILED = "REPEATFAILED";
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException,SystemException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        String url = hRequest.getRequestURI();
        if (isObviable(url)) {
            chain.doFilter(request, response);
            return;
        }
        //String token = hRequest.getParameter(TokenService.TOKEN_NAME);
        boolean tag = true;
        /*if(token!=null){
            if(TOKEN_EXIST.equals(TokenService.getInstance().getToken(token))){
                String requestedWith = ((HttpServletRequest) request).getHeader("x-requested-with"); 
                // 表示是一个AJAX POST请求
                if ("XMLHttpRequest".equalsIgnoreCase(requestedWith)) {
                    responseFailed(response,"重复提交页面",null);
                    tag = false;
                }else{
                    throw new SystemException("系统异常","","重复提交页面","");
                }               
            }else{
                TokenService.getInstance().setTokenToRedis(token);
            }
        }*/
        if(tag){
            chain.doFilter(request, response);   
        }
    }
    /**
     * json响应客户端失败
     */
    protected void responseFailed(ServletResponse response, String msg, JSONObject data) {
        PrintWriter printWriter = null;
        try {
            response.setContentType("text/html;charset=utf-8");
            printWriter = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(RES_RESULT, REPEATFAILED);
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
    public void destroy() {

    }

    public void init(FilterConfig arg0) throws ServletException {
        String exclude = arg0.getInitParameter("obviablePath");
        if (exclude != null) {
            obviablePath = exclude.split(",");
        }
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