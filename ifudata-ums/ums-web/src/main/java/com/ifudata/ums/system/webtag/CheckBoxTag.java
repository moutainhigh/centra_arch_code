package com.ifudata.ums.system.webtag;

import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.ifudata.ums.system.util.DictUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("serial")
public class CheckBoxTag extends BodyTagSupport{
	 private Logger logger = Logger.getLogger(CheckBoxTag.class);
	/* 字典相关 */
	private String id;
	
	private String dictId; // ---大类

	private String defaultValue;// 默认值

	/* radio 控制相关 */

	private String name;

	private String size;

	private String disabled;


	// 事件
	private String onfocus;

	private String onblur;

	private String onchange;

	private String onclick;

	private String ondblclick;

	private String onkeydown;

	private String onkeypress;

	private String onkeyup;

	private String onmousedown;

	private String onmousemove;

	private String onmouseout;

	private String onmouseover;

	private String onmouseup;

	private String displayCode;

	/* 被包含的code */
	private String keys;

	/* 被过滤的code */
	private String filters;


	// **css的控制
	private String styleClass;

	private String style;


	public CheckBoxTag() {
		id = "";
		dictId = "";

		displayCode = "false";

		name = "org.apache.crm.taglib.html.BEAN";
		size = "";
		disabled = "false";
		onfocus = "";
		onblur = "";
		onchange = "";
		onclick = "";
		ondblclick = "";
		onkeydown = "";
		onkeypress = "";
		onkeyup = "";
		onmousedown = "";
		onmousemove = "";
		onmouseout = "";
		onmouseover = "";
		onmouseup = "";
		styleClass = "";

		style = "";
		keys = "";
		filters = "";

	}

	public int doStartTag()
	{
		return SKIP_BODY;

	}

	public int doEndTag() throws JspException {
		try {
			StringBuffer stringbuffer = new StringBuffer();

			String value = TagUtils.getStack(this.pageContext, name);
			//默认值有多个时
			boolean mutiDe = false;
			List<String> defaultVas = null;
			
			if (value == null || "".equals(value)) {
				value = defaultValue;
				if (StringUtils.isNotEmpty(defaultValue)
						&& value.indexOf("%{") == 0) {

					value = value.substring(2, value.length() - 1);
					value = TagUtils.getStack(this.pageContext, name);
					value = (value == null ? "" : value);

				}
				//默认值有多个时
				if(defaultValue!=null&&defaultValue.contains(",")){
					mutiDe = true;
					defaultVas = Arrays.asList(defaultValue.split(","));
				}
			}
			

			/* 处理数据字典 */
			JSONArray sysVos = initDatasrc();

			String strTemp = "";
			String strCode = "";
			
			if (sysVos != null) {

				for (int i = 0; i < sysVos.size(); i++) {
					JSONObject jsonObject = sysVos.getJSONObject(i);
					strCode = "";
					stringbuffer.append("<input type=\"checkbox\"" );
					initAttribute(stringbuffer);
					// 显示code
					if (displayCode.equalsIgnoreCase("TRUE")) {
						strCode = "("+jsonObject.getString("columnValue") + ")";
					}
					if(mutiDe){
						//默认值有多个时
						if (defaultVas.contains(jsonObject.getString("columnValue"))) {
							strTemp = " value=\""
									+ jsonObject.getString("columnValue") + "\" checked />"
									+ jsonObject.getString("columnDesc")+ strCode
									+ "\n";
						} else {
							strTemp = " value=\""
									+ jsonObject.getString("columnValue") + "\" />" 
									+ jsonObject.getString("columnDesc")+ strCode + "\n";
						}
					}else{
						if (jsonObject.getString("columnValue").equals(value)) {
							strTemp = " value=\""
									+ jsonObject.getString("columnValue") + "\" checked />"
									+ jsonObject.getString("columnDesc")+ strCode
									+ "\n";
						} else {
							strTemp = " value=\""
									+ jsonObject.getString("columnValue") + "\" />" 
									+ jsonObject.getString("columnDesc")+ strCode + "\n";
						}
					}
					
					stringbuffer.append(strTemp);
					
				}
			}
			

			pageContext.getOut().print(stringbuffer.toString());

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}

		return EVAL_PAGE;
	}


	private void appendAttribute(StringBuffer sf, String attrName,
			String attrValue) {
		if (attrValue != null && !"".equals(attrValue)) {
			sf.append(attrName + "='");
			sf.append(attrValue);
			sf.append("' ");
		}
	}

	/**
	 * 初始化checkBox框数据源
	 * 
	 * @return
	 */
	private JSONArray initDatasrc() {
	    JSONArray vos = DictUtil.getSysParamS(dictId);
        if(vos==null||vos.size()==0){
            return null;
        }
        
        JSONArray _itemDict = new JSONArray();
        if (StringUtils.isNotEmpty(keys)) {
            String[] _keys = keys.split(",");
            for (int i = 0; i < _keys.length; i++) {
                for(int j=0;j<vos.size();j++){
                	JSONObject jsonObject = vos.getJSONObject(j);
                    if(_keys[i].equals(jsonObject.getString("columnValue"))){
                        _itemDict.add(jsonObject);
                        break;
                    }
                    
                }
            }
        }else{
            _itemDict = vos;
        }

        if (StringUtils.isNotEmpty(filters)) {
            String[] _filters = filters.split(",");
            for (int i = 0; i < _filters.length; i++) {
                for(int j=0;j<_itemDict.size();j++){
                	JSONObject jsonObject = _itemDict.getJSONObject(j);
                    if(_filters[i].equals(jsonObject.getString("columnValue"))){
                        _itemDict.remove(j);
                        break;
                    }
                }
            }
        }
        
        return _itemDict;
	}

	/**
	 * 初始化下拉框数据源
	 * 
	 * @return
	 */
	private void initAttribute(StringBuffer stringbuffer) {
		this.appendAttribute(stringbuffer, "id", id);
		this.appendAttribute(stringbuffer, "name", name);

		if (disabled.equalsIgnoreCase("TRUE")) {
			stringbuffer.append(" disabled ");

		}
		// 处理属性
		this.appendAttribute(stringbuffer, "size", size);
		this.appendAttribute(stringbuffer, "class", styleClass);
		this.appendAttribute(stringbuffer, "style", style);
		this.appendAttribute(stringbuffer, "keys", keys);
		this.appendAttribute(stringbuffer, "filters", filters);
		/* 处理事件 */
		this.appendAttribute(stringbuffer, "onfocus", onfocus);
		this.appendAttribute(stringbuffer, "onblur", onblur);
		this.appendAttribute(stringbuffer, "onchange", onchange);
		this.appendAttribute(stringbuffer, "onclick", onclick);
		this.appendAttribute(stringbuffer, "ondblclick", ondblclick);
		this.appendAttribute(stringbuffer, "onkeydown", onkeydown);
		this.appendAttribute(stringbuffer, "onkeypress", onkeypress);
		this.appendAttribute(stringbuffer, "onkeyup", onkeyup);
		this.appendAttribute(stringbuffer, "onmousedown", onmousedown);
		this.appendAttribute(stringbuffer, "onmousemove", onmousemove);
		this.appendAttribute(stringbuffer, "onmouseout", onmouseout);
		this.appendAttribute(stringbuffer, "onmouseover", onmouseover);
		this.appendAttribute(stringbuffer, "onmouseup", onmouseup);
	}

	public void release() {
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}


	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}


	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getDisplayCode() {
		return displayCode;
	}

	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}


	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}


	/*@SuppressWarnings("rawtypes")
	class SortByNameAsc implements Comparator {
		public int compare(Object a, Object b) {
			return ((TSysParamVo) a).getColumnDesc().compareTo(
					((TSysParamVo) b).getColumnDesc());
		}
	}

	@SuppressWarnings("rawtypes")
	class SortByCodeAsc implements Comparator {
		public int compare(Object a, Object b) {
			return ((TSysParamVo) a).getColumnValue().compareTo(
					((TSysParamVo) b).getColumnValue());
		}
	}

	@SuppressWarnings("rawtypes")
	class SortByNameDesc implements Comparator {
		public int compare(Object a, Object b) {
			return ((TSysParamVo) b).getColumnDesc().compareTo(
					((TSysParamVo) a).getColumnDesc());
		}
	}

	@SuppressWarnings("rawtypes")
	class SortByCodeDesc implements Comparator {
		public int compare(Object a, Object b) {
			return ((TSysParamVo) b).getColumnValue().compareTo(
					((TSysParamVo) a).getColumnValue());
		}
	}
*/

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
