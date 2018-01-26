<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>运营管理</title>
	<%@ include file="/inc/inc.jsp" %>
	<link href="${_slpres }/styles/bootstrap.css"rel="stylesheet" type="text/css">
	<link href="${_slpres }/styles/font-awesome.css" rel="stylesheet" type="text/css">
	<link href="${_slpres }/styles/frame.css" rel="stylesheet" type="text/css">
	<link href="${_slpres }/styles/global.css" rel="stylesheet" type="text/css">
	<link href="${_slpres }/styles/modular.css" rel="stylesheet" type="text/css">
	
</head>

<body>
	<!--顶部菜单-->
	<%@ include file="/inc/top-menu.jsp" %>
	<!--顶部菜单结束-->
	<!-- 左侧菜单 -->
	<%@ include file="/inc/left-menu.jsp" %>
	<!-- 左侧菜单结束 -->

<div class="wrapper"><!--外围框架-->
<!--右侧框架-->
 <div class="wrapper-right">
    <!--公告位置-->
    	<%@ include file="/inc/public-msg.jsp" %>
    <!--公告位置结束-->   
    <!--标签-->
    <div class="right-tags">
        <ul>
           <li>
	           <p class="none">您现在的位置：</p>
	           <p><a href="#">商品类目管理</a> > </p>  
	           <p>商品类目管理</p>
           </li>
        </ul>  
    </div>
   <!--标签结束-->
      <!--查询区域-->
    <div class="form-wrapper"><!--白底内侧-->
    
       <div class="form-label">
       	 	<ul>
                <li class="width-xlag">
                    <p class="word">类目名称</p>
                    <p><input id="standedProductName" type="text" class="int-text int-medium"></p>
                    <p><input id="selectNormProductList" type="button" value="查询" class="biu-btn btn-blue btn-mini"/></p>
                    <p><input id="selectNormProductList" type="button" value="重置" class="biu-btn btn-blue btn-mini"/></p>
                    <p class="sos"><a href="javascript:void(0);">高级搜索<i class="icon-caret-down"></i></a></p>
                </li>
            </ul>
            <!--点击展开-->
            <div id="selectDiv" class="open" style="display:none;">
            <ul>
                <li>
                    <p class="word">类目ID</p>
                    <p><input id="#" type="text" class="int-text int-medium"></p>
                </li>
                 <li>
                    <p class="word">是否有子分类</p>
                    <p>
                    	<select id="#" class="select select-medium">
		                   	<option value="">全部</option>
		                   	<option value="Y">是</option>
		                   	<option value="N">否</option>
                    	</select>
                    </p>
                </li>
            </ul> 
            </div>  
            <!--点击展开结束-->
        </div>
    
    </div>
   <!--查询区域结束-->
   <!--查询结果-->
   <div class="form-wrapper"><!--白底内侧-->
         <div class="nav-tplist-wrapper"><!--白底内侧-->
          <!--结果标题-->
             <div class="nav-tplist-title">
                  <ul>
                    <li>类目列表</li>
                  </ul>
                   <div class="nav-tplist-title nav-tplist-title-border">
                  <ul>
                    <div class="title-right">
	                    <p class="plus"><a href="#"><i class="icon-plus"></i></a></p>
	                    <p class="plus-word"><a href="${_base}/#">新增</a></p>
                    </div>
                  </ul>
              </div>
             </div>
         <!--结果表格-->
        <div class="table table-border table-bordered table-bg table-hover mt-10">
			<table width="100%" border="0">
              <tr class="bj">  
                <td width="5%">序号</td>
				<td width="10%">类目ID</td>
				<td width="30%">类目名称</td>
				<td width="10%">是否有子分类</td>
				<td width="10%">排序</td>
				<td>操作</td>
			<!-- 	<td>操作人</td> 
				<td>操作</td> -->
              </tr>
            <tbody id="searchNormProductData"></tbody>
            </table>
            <div id="showMessageDiv"></div>
                   <script id="searchNormProductTemple" type="text/template">
						 <%-- 	<tr>
                                <td>{{:#index+1}}</td>
                                <td>{{:productId}}</td>
                                <td>{{:productName}}</td>
								<td>{{:catName}}</td>
                                <td>{{:productType}}</td>
                                <td>{{:state}}</td>
								<td>{{:~timesToFmatter(operTime)}}</td>--%>
                       <%--        <td>{{:operId}}</td>
                                <td><a href="#" class="blue">查看详情</a><a href="#" class="red">编辑</a><a href="＃" class="blue">废弃</a></td>
 						--%> 
                            </tr>
			</script>
          </div> 
          <!--分页-->
		  	<div>
				 <nav style="text-align: right">
				<ul id="pagination-ul">
				</ul>
			</nav>
		  </div>
		 <!--分页-->
        <!--结果表格结束-->
         </div> 
    </div>
   <!--查询结果结束-->

    </div>
</div>	
<!-- footer -->
<div class="footer">版权所有 © SLP版权归运营家所有</div>
</body>
</html>
<script src="${_slpres }/scripts/metismenu.js"></script>
 <script type="text/javascript"> 
 
window.onload = function(){	
	var timer;
	var elem = document.getElementById('elem');
	var elem1 = document.getElementById('elem1');
	var elem2 = document.getElementById('elem2');
	elem2.innerHTML = elem1.innerHTML;
	timer = setInterval(Scroll,40);
	function Scroll(){
		if(elem.scrollTop>=elem1.offsetHeight){
			elem.scrollTop -= elem1.offsetHeight;
		}else{
			elem.scrollTop += 1;
		}
	}	
	elem.onmouseover = function(){
		clearInterval(timer);
	}	
	elem.onmouseout = function(){
		timer = setInterval(Scroll,40);
	}
}
</script>
<script type="text/javascript">
		var pager;
		var count = '${count}';
		var prodInfoList = '${prodInfoList}';
		var productEditInfo = '${productEditInfo}';
		(function () {
            seajs.use('app/jsp/productcat/catlist', function(
    				catlistPager) {
    			pager = new catlistPager({
    				element : document.body
    			});
    			pager.render();
    		});
		})();
</script>
