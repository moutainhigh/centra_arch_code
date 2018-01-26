package com.ifudata.ums.system.webtag;

import javax.servlet.jsp.PageContext;

import org.springframework.util.StringUtils;

public class TagUtils {
	 public static String getStack(PageContext pageContext, String expr) {
		 String pageValue = pageContext.getAttribute(expr)==null?null:pageContext.getAttribute(expr).toString();
		 if(StringUtils.isEmpty(pageValue)){
			 pageValue = pageContext.getRequest().getAttribute(expr)==null
					 ?null:pageContext.getRequest().getAttribute(expr).toString(); 
		 }
		 if(StringUtils.isEmpty(pageValue)){
			 pageValue = pageContext.getSession().getAttribute(expr)==null?null
					 :pageContext.getSession().getAttribute(expr).toString(); 
		 }
		 return pageValue;
	 }
}
