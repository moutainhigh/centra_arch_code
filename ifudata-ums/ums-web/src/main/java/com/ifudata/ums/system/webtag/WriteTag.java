package com.ifudata.ums.system.webtag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.ifudata.ums.system.util.DictUtil;
import org.apache.commons.lang.StringUtils;

public class WriteTag extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dictId;
	private String name;
	private String property;
	private String defaultValue = "";
	private String separator;
	private String scope = "";
	private String code = "";
	private static String SEPARATOR = ",";
	private String parentValue = "";

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int doEndTag() throws JspException {
		Object obj = null;
		if (scope == null || "".equals(scope)) {
			obj = TagUtils.getStack(pageContext,name);
		} else if ("page".equalsIgnoreCase(scope)) {
			obj = pageContext.getAttribute(name);
		} else if ("request".equalsIgnoreCase(scope)) {
			obj = pageContext.getRequest().getAttribute(name);
		} else if ("session".equalsIgnoreCase(scope)) {
			obj = pageContext.getSession().getAttribute(name);
		} else if ("value".equalsIgnoreCase(scope)) {
			obj = code;
		}
		StringBuffer stringbuffer = new StringBuffer();
		if (separator == null || ("").equals(separator)) {
			separator = SEPARATOR;
			if (obj != null) {
				String value = "";
				value = DictUtil.getValueDesc(dictId, obj.toString());
				if (StringUtils.isEmpty(value)) {
					if (StringUtils.isNotEmpty(parentValue)) {
					/*	Object pObject = TagUtils.getStack(this.pageContext).findValue(parentValue);
						if (pObject != null)
							value = CRMDict.getDictItemName(dictId, pObject.toString(), obj.toString());*/
					} else {
						value = DictUtil.getValueDesc(dictId, obj.toString());
					}
				}
				if (StringUtils.isEmpty(value)) {
					value = obj.toString();
				}
				stringbuffer.append(value);
			} else if (!defaultValue.equals(""))
				stringbuffer.append(defaultValue);
		} else {
			if (obj != null) {
				String[] nameList = obj.toString().split(separator);
				for (int i = 0; i < nameList.length; i++) {
					String val = "";
					val = DictUtil.getValueDesc(dictId,  nameList[i]);

					if (StringUtils.isEmpty(val)) {
						val = DictUtil.getValueDesc(dictId,  nameList[i]);
					}
					if (StringUtils.isEmpty(val)) {
						val = nameList[i];
					}
					if (!"".equals(val)) {
						stringbuffer.append(separator + val);
					}
				}
				if (stringbuffer.length() > 0)
					stringbuffer = stringbuffer.deleteCharAt(0);
			} else {
				if (!"".equals(defaultValue))
					stringbuffer.append(defaultValue);
			}
		}

		try {
			if ("".equals(stringbuffer.toString())) {
				pageContext.getOut().print(defaultValue);
			} else {
				pageContext.getOut().print(stringbuffer.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentValue() {
		return parentValue;
	}

	public void setParentValue(String parentValue) {
		this.parentValue = parentValue;
	}

}
