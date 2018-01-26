package com.ifudata.ums.system.webtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.ifudata.ums.system.common.Pinyin;
import com.ifudata.ums.system.util.DictUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("serial")
public class SelectTag extends BodyTagSupport{
	 private Logger logger = Logger.getLogger(SelectTag.class);
	/* 字典相关 */
	private String id;
	
	private String dictId; // ---大类

	private String parentValue; // 

	private String defaultValue;// 默认值

	/* select 控制相关 */

	private String name;

	private String size;

	private String multiple;

	private String disabled;

	private String tabindex;
	// 是否是可搜索的下拉框
	private String searchSelect;
	// private StringBuffer noselectlist;

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

	/* 是否允许空值 */
	private String nullOption;

	private String notnull;

	private String nullText = "";

	// **css的控制
	private String styleClass;

	private String style;

	private String preNode;

	private String nextNode;

	private String sort;

	private String sortMode;

	public SelectTag() {
		id = "";
		dictId = "";
		parentValue = "";

		nullOption = "false";
		displayCode = "false";

		name = "org.apache.struts.taglib.html.BEAN";
		size = "";
		multiple = "false";
		disabled = "false";
		tabindex = "";
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
		// noselectlist = null;

		notnull = "";
		style = "";
		keys = "";
		filters = "";
		nullText = "请选择";
		sort = "ASC";
		sortMode = "CODE";

		searchSelect = "FALSE";
	}

	public int doStartTag()
	// throws JspException
	{
		return SKIP_BODY;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int doEndTag() throws JspException {
		try {
			StringBuffer stringbuffer = new StringBuffer();
			if ("TRUE".equals(this.searchSelect.toUpperCase())) {
				String dfName = "";
				String selName = (this.name).replaceAll("\\.", "");
				//获取参数值
				String dfCode = TagUtils.getStack(this.pageContext, name);
				if (dfCode == null || "".equals(dfCode)) 
				{
					dfCode = defaultValue;
					if (StringUtils.isNotEmpty(defaultValue)
							&& dfCode.indexOf("%{") == 0) 
					{

						dfCode = dfCode.substring(2, dfCode.length() - 1);
						dfCode = TagUtils.getStack(this.pageContext, name);
						dfCode = (dfCode == null ? "" : dfCode);
					}
				}
				if(dfCode != null && !"".equals(dfCode))
				{	
					dfName = DictUtil.getValueDesc(dictId,dfCode);
				}
				// 显示数据
				stringbuffer.append("<input id=\"" + selName
						+ "Name\"  name=\""+ this.name + "Name\" value=\""+dfName+"\" type=\"text\" ");
				stringbuffer.append(" />");
				// code存放
				stringbuffer.append("<input ");
				initAttribute(stringbuffer);
				stringbuffer.append("id=\"" + selName + "\" name=\""
						+ this.name + "\" type=\"hidden\" value=\""+dfCode+"\" />");
				// 下拉按钮
				stringbuffer
						.append("<img id=\""
								+ selName
								+ "Btn\" type=\"button\" class=\"searchSelBtn\" value=\"\" />");

				stringbuffer.append("<script>");
				stringbuffer.append("var " + selName + "Array = [");
				if (nullOption.equalsIgnoreCase("TRUE")) {
					stringbuffer
							.append(" {\"code\":\"\",\"py\":\"\",\"name\":\""
									+ nullText + "\"},");
				}
				/* 处理数据字典 */
//				Hashtable itemDict = initDatasrc();
				JSONArray sysVos = initDatasrc();
				if (sysVos != null) {
					int size = sysVos.size();
					// 组合数据,生成[{"code":code,"py":py,"name":name},{"code":code,"py":py,"name":name}]}格式
					for (int i = 0; i < size; i++) {
						JSONObject jsonObject = sysVos.getJSONObject(i);
						stringbuffer.append("{\"code\":");
						stringbuffer.append("\"" + jsonObject.getString("columnValue")
								+ "\",");
						stringbuffer.append("\"py\":");
						stringbuffer.append("\""
								+ Pinyin.getFirstPinyin(jsonObject.getString("columnDesc"))
								+ "\",");
						stringbuffer.append("\"name\":");
						stringbuffer.append("\"" + jsonObject.getString("columnDesc")
								+ "\"");
						stringbuffer.append("},");
					}
				}
				stringbuffer.deleteCharAt(stringbuffer.length() - 1);
				stringbuffer.append("];");
				// 生成searchSelect
				stringbuffer.append("$(document).ready");
				stringbuffer.append("(");
				stringbuffer.append("function()");
				stringbuffer.append("{");
				stringbuffer.append("$(\"#" + selName + "\").searchSelect();");
				stringbuffer.append("});");
				stringbuffer.append("</script>");
			} else {
				stringbuffer = new StringBuffer("<select ");
				initAttribute(stringbuffer);
				stringbuffer.append(">\n");

				String value = TagUtils.getStack(this.pageContext, name);

				if (value == null || "".equals(value)) {
					value = defaultValue;
					if (StringUtils.isNotEmpty(defaultValue)
							&& value.indexOf("%{") == 0) {

						value = value.substring(2, value.length() - 1);
						value = TagUtils.getStack(this.pageContext, name);
						value = (value == null ? "" : value);

					}
				}

				if (parentValue.indexOf("%{") == 0) {
					parentValue = parentValue.substring(2,
							parentValue.length() - 1);
					parentValue = TagUtils.getStack(this.pageContext, name);
					parentValue = (parentValue == null ? "" : parentValue);
				}

				/* 处理数据字典 */
//				Hashtable itemDict = initDatasrc();
				JSONArray sysVos = initDatasrc();

				if (nullOption.equalsIgnoreCase("TRUE")) {
					stringbuffer.append("\t<option value=''>");
					stringbuffer.append(nullText);
					stringbuffer.append("</option>\n");
				}
				String strTemp = "";
				String strCode = "";
				
				/*if (itemDict != null) {
					List lstDictItem = new ArrayList(itemDict.values());
					// 判断参数是否是受控的
					if (AllRight.isDataRightControl(dictId)) {
						UserInfo userInfo = SessionInfo.getUserInfo();
						Map map = userInfo.getDataRight();
						*//**
						 * 判断是否已经存在参数
						 *//*
						if (!map.containsKey(dictId)) {
							Map condition = new HashMap();
							RoleDao roleDao = (RoleDao) BeanFactory.getBean("roleDao");
							condition.put("data_code", dictId);
							condition.put("user_id", userInfo.getUser().getUser_id());
							List lstRight = roleDao.selectRole2Data(condition);
							Map dataRight = new HashMap();
							for (int i = 0; i < lstRight.size(); i++) {
								BaseData baseData = (BaseData) lstRight.get(i);
								if (!dataRight.containsKey(baseData.getData1())) {
									dataRight.put(baseData.getData1(), new HashMap());
								}
								if (!((Map) dataRight.get(baseData.getData1()))
										.containsKey(baseData.getCode())) {
									((Map) dataRight.get(baseData.getData1())).put(baseData
											.getCode(), new HashSet());
								}
								((Set) ((Map) dataRight.get(baseData.getData1())).get(baseData
										.getCode())).add(baseData.getName());
							}
							userInfo.setDataRight(dataRight);
						}

						if (StringUtils.isNotEmpty(parentValue)) {
							map = (Map) map.get(parentValue);
						} else {
							map = (Map) map.get("ALL");
						}
						Set setValues = (Set) map.get(dictId);
						for (int i = lstDictItem.size() - 1; i >= 0; i--) {
							DictItem dictItem = (DictItem) lstDictItem.get(i);
							if (!setValues.contains(dictItem.getItemCode())
									&& !dictItem.getItemCode().equals(value)) {
								lstDictItem.remove(dictItem);
							}
						}
					}*/
				if (sysVos != null) {

					// 排序
					/*if ("CODE".equals(this.sortMode.toUpperCase())) {
						if ("DESC".equals(this.sort.toUpperCase())) {
							Collections.sort(sysVos, new SortByCodeDesc());
						} else if ("ASC".equals(this.sort.toUpperCase())) {
							Collections.sort(sysVos, new SortByCodeAsc());
						}
					} else if ("ITEM".equals(this.sortMode.toUpperCase())) {
						if ("DESC".equals(this.sort.toUpperCase())) {
							Collections.sort(sysVos, new SortByNameDesc());
						} else if ("ASC".equals(this.sort.toUpperCase())) {
							Collections.sort(sysVos, new SortByNameAsc());
						}
					}*/
				    JSONObject jsonObject = new JSONObject();
					for (int i = 0; i < sysVos.size(); i++) {
						jsonObject = sysVos.getJSONObject(i);
						strCode = "";
						// 显示code
						if (displayCode.equalsIgnoreCase("TRUE")) {
							strCode = jsonObject.getString("columnValue") + "-";
						}
						if (jsonObject.getString("columnValue").equals(value)) {
							strTemp += "\t<option value=\""
									+ jsonObject.getString("columnValue") +"\"" + "  title=\""+ jsonObject.getString("columnDesc") + "\" selected>"
									+ strCode + jsonObject.getString("columnDesc")
									+ "</option>\n";
						} else {
							strTemp += "\t<option value=\""
									+ jsonObject.getString("columnValue") + "\"" + "  title=\""+ jsonObject.getString("columnDesc")+"\">" + strCode
									+ jsonObject.getString("columnDesc") + "</option>\n";
						}
					}
				}
				stringbuffer.append(strTemp);
				stringbuffer.append("</select>\n");
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
			sf.append("'");
		}
	}

	/**
	 * 初始化下拉框数据源
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JSONArray initDatasrc() {
		JSONArray vos = DictUtil.getSysParamS(dictId);
		if(vos==null||vos.size()==0){
			return null;
		}
		
		/*Hashtable itemDict = CRMDict.getDeptItemDict(dictId, parentValue);
		if (itemDict == null) {
			return itemDict;
		}*/
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

		if (multiple.equalsIgnoreCase("TRUE")) {
			stringbuffer.append(" multiple ");

		}
		if (disabled.equalsIgnoreCase("TRUE")) {
			stringbuffer.append(" disabled ");

		}
		// 处理属性
		this.appendAttribute(stringbuffer, "size", size);
		this.appendAttribute(stringbuffer, "tabindex", tabindex);
		this.appendAttribute(stringbuffer, "class", styleClass);
		this.appendAttribute(stringbuffer, "style", style);
		this.appendAttribute(stringbuffer, "notnull", notnull);
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

	public String getNullText() {
		return nullText;
	}

	public void setNullText(String nullText) {
		this.nullText = nullText;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getParentValue() {
		return parentValue;
	}

	public void setParentValue(String parentValue) {
		this.parentValue = parentValue;
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

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNextNode() {
		return nextNode;
	}

	public void setNextNode(String nextNode) {
		this.nextNode = nextNode;
	}

	public String getNotnull() {
		return notnull;
	}

	public void setNotnull(String notnull) {
		this.notnull = notnull;
	}

	public String getNullOption() {
		return nullOption;
	}

	public void setNullOption(String nullOption) {
		this.nullOption = nullOption;
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

	public String getPreNode() {
		return preNode;
	}

	public void setPreNode(String preNode) {
		this.preNode = preNode;
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

	public String getTabindex() {
		return tabindex;
	}

	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSortMode() {
		return sortMode;
	}

	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
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
	}*/

	public static void main(String[] args) {
		System.out.println("集团关键人修改1".compareToIgnoreCase("集团关键人修改2"));
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getSearchSelect() {
		return searchSelect;
	}

	public void setSearchSelect(String searchSelect) {
		this.searchSelect = searchSelect;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
