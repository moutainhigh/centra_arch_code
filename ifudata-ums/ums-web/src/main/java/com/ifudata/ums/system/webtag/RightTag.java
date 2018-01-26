package com.ifudata.ums.system.webtag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class RightTag extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 142354325L;
	private String url;

	public int doStartTag() throws JspException {
		/*if (!CommFunc.hasRight((HttpServletRequest) pageContext.getRequest(),
				url)) {
			return SKIP_BODY;

		} else {
			return EVAL_BODY_INCLUDE;
		}*/
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {

		return EVAL_PAGE;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
