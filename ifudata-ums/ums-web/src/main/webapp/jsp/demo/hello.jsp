<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ifudata" uri="/WEB-INF/tag/ifudata-tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/jsp/common/common.jsp"%>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<!-- 邮寄信息 -->
<script type="text/javascript" src="${_base}/js/post/post.js"></script>
<script type="text/javascript">
function open1(){
	$.dialog({
	    content: '如果定义了回调函数才会出现相应的按钮',
	    ok: function(){
	        this.title('3秒后自动关闭').time(3);
	        return false;
	    },
	    cancelVal: '关闭',
	    cancel: true /*为true等价于function(){}*/
	});
}
function open2(){
	$.dialog({
	    id: 'testID',
	    content: 'hello world!',
	    button: [
	        {
	            name: '同意',
	            callback: function(){
	                this.content('你同意了')
	                .button({
	                    id:'disBtn',
	                    name:'我变成有效按钮了',
	                    disabled: false
	                });
	                return false;
	            },
	            focus: true
	        },
	        {
	            name: '不同意',
	            callback: function(){
	                alert('你不同意')
	            }
	        },
	        {
	            id: 'disBtn',
	            name: '无效按钮',
	            disabled: true
	        },
	        {
	            name: '关闭我'
	        }
	    ]
	});
}
function open3(){
	$.dialog({title:'我是新标题'});
}
</script>
</head>
<body>
	<a href="javascript:open1();" >open1</a>
	<a href="javascript:open2();" >open2</a>
	<a href="javascript:open3();" >open3</a>
	
	<br/>
	ifudata:select标签：<br/>
	<ifudata:select dictId="CM_CUST.BRAND" name="brand" nullOption="true"  nullText="全部"></ifudata:select>
	<br/>
	ifudata:write标签(翻译)：<br/>
	<%request.setAttribute("brand", "10"); %>
	<ifudata:write dictId="CM_CUST.BRAND" name="brand"></ifudata:write>
	
	
	<%
	java.util.List<String> brands = new java.util.ArrayList<String>();
	brands.add("10");
	brands.add("1");
	brands.add("2");
	brands.add("3");
	request.setAttribute("brands", brands); 
	%>
	<c:forEach items="${brands}" var="bra">
		<ifudata:write dictId="CM_CUST.BRAND" name="brand21" scope="value" code="${bra }"></ifudata:write>
	</c:forEach>
	
	
	<br/>
	ifudata:radio标签：<br/>
	<ifudata:radio dictId="CM_CUST.BRAND" name="brand" defaultValue="${brand}"></ifudata:radio>
	<br/>
	ifudata:checkBox标签：<br/>
	<ifudata:checkBox dictId="CM_CUST.BRAND" name="brand" defaultValue="${brand}"></ifudata:checkBox>
	<ifudata:right url=""><button>审核</button></ifudata:right>
	
	
	
	<!-- 有默认省市区 -->
	<%
	request.setAttribute("XXprovince", "86"); 
	request.setAttribute("XXcity", "862"); 
	request.setAttribute("XXcounty", "86211"); 
	%>
	省市区标签:<br />
	省:<ifudata:province name="XXprovince"  defaultValue="${XXprovince }" onchange="setCity(this,\"XXcity\",\"316\");setCountyByPro(\"XXcounty\")"/>
	市:<ifudata:area name="XXcity" id="XXcity" parentValue="${XXprovince }" defaultValue="${XXcity }" onchange="setCounty(this,\"XXcounty\",\"\")"/>
	区(县):<ifudata:county name="XXcounty" id="XXcounty" parentValue="${XXcity }" defaultValue="${XXcounty }" />
	<br />
	
	<!-- 无默认省市区 -->
	省市区标签:<br />
	省:<ifudata:province name="YYprovince" onchange="setCity(this,\"YYcity\",\"\");setCountyByPro(\"YYcounty\")" nullText="请选择" notnull="true"/>
	市:<ifudata:area name="YYcity"  id="YYcity" parentValue="-1" onchange="setCounty(this,\"YYcounty\",\"\")"  nullText="请选择" notnull="true"/>
	区(县):<ifudata:county  parentValue="-1" name="YYcounty"  id="YYcounty" nullText="请选择" notnull="true"/>
	<br />
	
	省市区标签:<br />
	省:<ifudata:province name="YYprovince" onchange="setCity(this,\"YYcity1\",\"\");setCountyByPro(\"YYcounty1\")" defaultValue="81"/>
	市:<ifudata:area name="YYcity" id="YYcity1" parentValue="81" onchange="setCounty(this,\"YYcounty1\",\"\")" nullText="请选择" notnull="true"/>
	区(县):<ifudata:county  parentValue="-1" name="YYcounty1"  id="YYcounty1" nullText="请选择" notnull="true"/>
	<!--上述代码为功能基本配置，ifudata:area、ifudata:county的id\parentValue不可为空。-->
</body>
</html>