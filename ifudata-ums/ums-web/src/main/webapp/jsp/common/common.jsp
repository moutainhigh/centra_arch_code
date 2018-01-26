<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String _base = request.getContextPath();
	String bp = _base;
	request.setAttribute("_base", _base);
	
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);   
	response.setHeader("Pragma","No-cache");
		
%>
<script>
  var webpath = "<%=_base%>";
</script>
<%--jquery --%>
<script type="text/javascript" src="<%=_base%>/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=_base%>/js/jquery/jquery-migrate-1.1.0.js"></script>
<%--基于jquery的弹窗 --%>
<script type="text/javascript" src="<%=_base%>/js/jquery/lhgdialog/lhgdialog.min.js?self=true&skin=chrome"></script>
<%--基于jquery的表单校验 --%>
<script type="text/javascript" src="<%=_base%>/js/jquery/validate/jquery.validate.min.js" ></script>
<script type="text/javascript" src="<%=_base%>/js/jquery/validate/jquery.form.js" ></script>
<script type="text/javascript" src="<%=_base%>/js/jquery/validate/card.js" ></script>
<script type="text/javascript" src="<%=_base%>/js/jquery/validate/additional-methods.js" ></script>
<script type="text/javascript" src="<%=_base%>/js/jquery/validate/localization/messages_zh.js" ></script>
<%--基于jquery的日期插件 --%>
<script type="text/javascript" src="<%=_base%>/js/jquery/date/WdatePicker.js"></script>
<%--基于jquery的文件上传插件 --%>
<script type="text/javascript" src="<%=_base%>/js/jquery/file_upload/js/file_upload_plug-in.js" ></script>
<%--基于jquery的 浮动提示信息 --%>
<script type="text/javascript" src="${_base}/js/jquery/validate/commonPrompt.js"></script>
<%--基于jquery的table标签页--%>
<script type="text/javascript" src="${_base}/js/table-js.js"></script>
<script type="text/javascript" src="${_base}/js/jquery/jPages/js/jPages.min.js"></script>
<script>
(function(config){
    config['extendDrag'] = true; // 注意，此配置参数只能在这里使用全局配置，在调用窗口的传参数使用无效
    config['lock'] = true;
    config['fixed'] = true;
    config['okVal'] = '确定';
    config['cancelVal'] = '取消';
    // [more..]
	//禁止后退键 作用于Firefox、Opera
    document.onkeypress = forbidBackSpace;
    //禁止后退键  作用于IE、Chrome
    document.onkeydown = forbidBackSpace;
})($.dialog.setting);

(function( $, lhgdialog, undefined ){

	var _zIndex = function()
	{
	    return lhgdialog.setting.zIndex;
	};
	lhgdialog.ok = function( content, callback)
	{
		return lhgdialog({
			title: '提示',
			id: 'Alert',
			zIndex: _zIndex(),
			icon: 'success.gif',
			fixed: false,
			lock: true,
			content: content,
			ok: true,
			okVal:"确认",
			resize: false,
			close: callback
		});
	};
})( this.jQuery||this.lhgcore, this.lhgdialog );
/**
 * 得到Token的唯一随机数
 */
function getToken(){
	var timestamp = Date.parse(new Date());
	var mathss = Math.random()*9000+1000;
	return timestamp+''+ mathss;
}
<%--方便框架获取本页面的高度 --%>
$(function(){window.name　=　document.body.scrollHeight;});


//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外 add by suntq
function forbidBackSpace(e) {
    var ev = e || window.event; //获取event对象 
    var obj = ev.target || ev.srcElement; //获取事件源 
    var t = obj.type || obj.getAttribute('type'); //获取事件源类型 
    //获取作为判断条件的事件类型 
    var vReadOnly = obj.readOnly;
    var vDisabled = obj.disabled;
    //处理undefined值情况 
    vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;
    vDisabled = (vDisabled == undefined) ? true : vDisabled;
    //当敲Backspace键时，事件源类型为密码或单行、多行文本的， 
    //并且readOnly属性为true或disabled属性为true的，则退格键失效 
    var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true);
    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效 
    var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";
    //判断 
    if (flag2 || flag1) return false;
}
</script>