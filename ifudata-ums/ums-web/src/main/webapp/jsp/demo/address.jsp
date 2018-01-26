<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String bp = request.getContextPath();
	request.setAttribute("_base", bp);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>电信网上营业厅</title>
<meta name="description" content="电信网上营业厅" />
<meta name="keywords" content="电信网上营业厅" />
<link rel="stylesheet" type="text/css" href="<%=bp%>/ui/css/base.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=bp%>/ui/css/payment.css" />
<script type="text/javascript" src="<%=bp%>/js/jquery18.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<table>
		<tr>
			<td class="input-item-name"><span class="input-required">详细地址</span><input id="area" name="area" value="" type="hidden"></td>    
			<td class="input-item-value">
				<select id="province" onchange="setCityGB2260(this.value);getAreaGB2260()" name="province" >
					<option value="" selected="selected">请选择省</option>
				</select>
				   
				<select id="city" onchange="setCountyGB2260(this.value);getAreaGB2260()" name="city" style="display:;">
					<option value="" selected="selected">请选择市</option>
				</select>
				   
				<select id="county" name="county" onchange="_address();" style="display:;">
					<option value="" selected="selected">请选择县</option>
				</select>
				<input id="address" name="address" type="text" value="地址" />
			</td>
		</tr>
	</table>
	<script type="text/javascript" src="<%=bp%>/js/address.js"></script>
	<script>
	function _address(){
	  var shengvar =document.getElementById("province").options[document.getElementById("province").selectedIndex].text;
	  var shivar =document.getElementById("city").options[document.getElementById("city").selectedIndex].text;
	  var xianvar =document.getElementById("county").options[document.getElementById("county").selectedIndex].text;
	  document.getElementById('address').value=shengvar+shivar+xianvar;
	}
	</script>
	</body>

</html>

