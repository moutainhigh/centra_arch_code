<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String bp = request.getContextPath();
			request.setAttribute("_base", bp);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>电信</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="<%=bp%>/ui/css/global.css?dasdsa" rel="stylesheet"
	type="text/css" />
<link href="<%=bp%>/ui/css/iframe.css?1232" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=bp%>/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=bp%>/js/jquery/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="<%=bp%>/js/menu.js?xx"></script>
<script type="text/javascript">
</script>
</head>
<body class="cifco_bg" style="overflow-x: hidden;">
	<div class="head">
		<div class="head_menu">
			<div class="companyLogo">
				<a href="#">电信</a>
			</div>
			<div class="headright">
				<ul class="headOther">
					<li class="common_win userinfo">
						<h3>
							<a href="#">${sessionScope.CRM_SESSION_OPER.gnOperVo.operCode }<span></span></a>
						</h3>
					</li>
					<li class="notice"><a href="#">通知</a>
						<div class="notice_nm">
							<span>4</span>
						</div></li>
					<li class="logout"><a href="${_base}/logout.jsp">退出系统</a></li>
				</ul>
			</div>
		</div>
		<!--二级导航-->
		<div class="navigation">
			<ul id="menuone"> 
				<li class="common_nav pay1">
					<h2 class="select">
						<a href="#">短信管理</a>
					</h2>
				</li> 
				<li class="common_nav system1">
					<h2>
						<a href="#">系统管理</a>
					</h2>
				</li> 
			</ul>
		</div>
	</div>
	<div class="container">
		<!--左边菜单-->
		<div class="con_side">
			<div class="con_side_top"></div>
			<ul id="menutwo"> 
		      <li class="pay"><a href="javascript:void(0)" 
		    		onclick="javascript:loadMenuUrl('${_base }/expums/ExpUmsConfig');return false;">短信推广</a></li>
		      <li class="pay"><a href="javascript:void(0)" 
		    		onclick="javascript:loadMenuUrl('${_base }/expums/UmsFileNameQuery');return false;">短信状态查询</a></li>
		    		 
			</ul>
			<div class="con_side_bottom"></div>
		</div>

		<div class="con_main">
			<iframe src="" name="main_iframe" allowtransparency="transparent"
				height="100%" marginheight="0" align="middle" marginwidth="0"
				width="100%" scrolling="auto" frameborder="0"
				style="min-height: 460px;" id="main_iframe"></iframe>
		</div>
	</div>
</body>
<script language="javascript" type="text/javascript"> 

function loadMenuUrl(url){
	dynaHeight(url);
	//$("#main_iframe").attr("src",url);
	//alert(url);
}
function dyniframesize(down) {  
	 // var iframeHeight = $("#"+down).contents().height();
	  //alert(iframeHeight);
var pTar = null; 
if (document.getElementById){ 
pTar = document.getElementById(down); 
} 
else{ 
eval('pTar = ' + down + ';'); 
} 
var heigth = 600;
if (pTar && !window.opera){ 
//begin resizing iframe 
pTar.style.display="block" 
if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){ 
//ns6 syntax 
heigth = pTar.contentDocument.body.offsetHeight +20; 
//pTar.width = pTar.contentDocument.body.scrollWidth+20; 
} 
else if (pTar.Document && pTar.Document.body.scrollHeight){ 
//ie5+ syntax 
heigth = pTar.Document.body.scrollHeight; 
//pTar.width = pTar.Document.body.scrollWidth; 
}
}
alert(heigth);
if(iframeHeight<1000)
	iframeHeight = 1000;
pTar.height = iframeHeight;
} 
$(document).ready(function(){
	/* $("#menutwo").find("li").each(function(){
		$(this).hide();
	});
	$(".pay1").show(); */
});



//iframe高度
function dynaHeight(url){ 
	//alert("123:||"+(navigator.appName == "Microsoft Internet Explorer")+"  "+navigator.appName );
	var　iframe　=　$('#main_iframe'); 
	iframe.attr('_name_',iframe.attr('name'))　 　　　//备份原来的　name
	.attr('src',url)　　　　　　　　　　　 　　　　　　　　　　　　　　　　　//设置URL
	.one ('load',function　()　{
		var　msg 　=　this.contentWindow.name;　　　　　　　　　　　　//得到值　这个值就是高度了
		try
		{
		　　　　var 　height　=　eval(msg);　　　　　　　　　　　　　　　　　　　　//得到并设置高度
			 if(height<600)
				 height = 1200;
		　　　 　iframe.css('height',　height　+　'px');
		}
		catch(e)
		{
		　　　　alert('目标页面没有设置高度到　 window.name');
		}　　　　
		
　　　　	})
}
</script>
</html>