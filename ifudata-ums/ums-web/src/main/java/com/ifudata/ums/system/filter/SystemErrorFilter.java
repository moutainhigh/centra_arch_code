package com.ifudata.ums.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ifudata.ums.system.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SystemErrorFilter implements Filter{

	private Logger log = LoggerFactory.getLogger(SystemErrorFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("SystemErrorFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch (Error e) {
			//e.printStackTrace();
			log.error("=========" + e);
			if (e instanceof Error){
				((HttpServletRequest)request).setAttribute("exception", new SystemException(e.getMessage()));
			}
			((HttpServletRequest)request).getRequestDispatcher("/jsp/common/error.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//e.printStackTrace();
			log.error("=========" + e.getStackTrace());			
			if (e != null){
				((HttpServletRequest)request).setAttribute("exception", e.getCause());
				log.debug(e.getMessage());
			}
			((HttpServletRequest)request).getRequestDispatcher("/jsp/common/error.jsp").forward(request, response);
			return;
		}
		
	}

	@Override
	public void destroy() {
		log.debug("SystemErrorFilter destroy");
	}

}
