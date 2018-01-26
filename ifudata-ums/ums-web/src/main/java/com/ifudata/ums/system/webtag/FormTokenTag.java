package com.ifudata.ums.system.webtag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * 防止form表单重复提交
 *
 */
public class FormTokenTag extends BodyTagSupport {
	private static final long serialVersionUID = 143543L;
	
	private String id;
	private String name;
	private String value;

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}
	
	/**
	 * 生成唯一认证串
	 * 页面写隐藏控件，带上认证串
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			//setName(TokenService.TOKEN_NAME);
			//setValue(TokenService.getInstance().setToken(name));
			
		    StringBuffer stringbuffer =new StringBuffer("<input type=\"hidden\" ");
		    initAttribute(stringbuffer);
		    stringbuffer.append(" />");
	    
			pageContext.getOut().print(stringbuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FormTokenTag(){
		id = "";
		//name = TokenService.TOKEN_NAME;
		value = "";
	}
	
	private void initAttribute(StringBuffer stringbuffer) {
		this.appendAttribute(stringbuffer, "id", id);
		this.appendAttribute(stringbuffer, "name", name);
		this.appendAttribute(stringbuffer, "value", value);
	}
	
	private void appendAttribute(StringBuffer sf, String attrName,
			String attrValue) {
		if (attrValue != null && !"".equals(attrValue)) {
			sf.append(attrName + "='");
			sf.append(attrValue);
			sf.append("'");
		}
	}

}
