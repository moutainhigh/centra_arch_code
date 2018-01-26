<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>产品线管理</title>
	<%@ include file="/inc/inc.jsp" %>
	<script src="${_base}/resources/ztree/js/jquery.ztree.all-3.5.min.js"></script>
	<link rel="stylesheet" href="${_base}/resources/ztree/css/zTreeStyle/zTreeStyle.css"/>
</head>

<body
	class="theme-whbl  pace-done fixed-header fixed-leftmenu fixed-footer">
	<div id="theme-wrapper">

		<%@ include file="/jsp/common/head.jsp"%>


		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="/jsp/common/leftmenu.jsp"%>
	<div class="content-wrapper"><!--右侧灰色背景-->
	
	<div id="content-wrapper"><!--右侧灰色背景-->
	

	<div class="my-service-menu">
        <ul id="treeDemo" class="ztree"></ul>
		<input type="hidden" id="selectId" value=""/>
		<input type="hidden" id="selectName" value=""/>
    </div>



	<div class="my-service-cnt">
	<div class="row"><!--外围框架-->
		<div class="col-lg-12"><!--删格化-->
			<div class="row"><!--内侧框架-->
				<div class="col-lg-12"><!--删格化-->
					<div class="main-box clearfix"><!--白色背景-->
						<div class="main-box-body clearfix">
                            <!-- 查询条件 -->
						<div class="form-label">
							<input type="hidden" id="categoryId" value=""/>
							<input type="hidden" id="prdlineId" value="${prdlineId}"/>
							<ul>
								<li class="col-md-6">
									<p class="word">当前目录：</p>
									<p id="category"></p>
								</li>
								<li class="col-md-6">
									<p class="word">服务个数：</p>
									<p id="serviceCount"></p>
								</li>
							</ul>
							<ul>
									<li class="width-xlag">
										<p><input type="text" class="int-text int-xxlarge" id="searchParams" placeholder="服务编码/服务名称"></p>
										<p><input type="button" class="biu-btn  btn-primary btn-blue btn-medium ml-10"
												  id="searchServiceBtn" value="查  询"></p>
									</li>
							</ul>
						</div>
                            
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row"><!--外围框架-->
		<div class="col-lg-12"><!--删格化-->
			<div class="row"><!--内侧框架-->
				<div class="col-lg-12"><!--删格化-->
					<div class="main-box clearfix"><!--白色背景-->
						<div class="main-box-body clearfix">
                            <!--标题-->
							<header class="main-box-header clearfix">
								<h2 class="pull-left">服务列表</h2>
							</header>
                        	
                        	<div class="main-box-body clearfix">
							<!--table表格-->
							<div class="table-responsive clearfix">
								<table class="table table-hover table-border table-bordered">
									<thead>
									<tr>
										<th>序号</th>
										<th>服务编码</th>
										<th>服务名称</th>
										<th>服务分类</th>
										<th>产品标签</th>
										<th>版本记录</th>
									</tr>
									</thead>
									<tbody id="searchServiceData">
									</tbody>

								</table>
								<div id="showMessageDiv"></div>
								<script id="searchServiceTemple" type="text/template">
									{{for result ~pageNo=pageNo ~pageSize=pageSize}}
									<tr>
										<td>{{:#index+1+(~pageNo-1)*~pageSize}}</td>
										<td>{{:srvApiId}}</td>
										<td>
											<div class="hind1 text-l pl-15">
                                                <div class="center-hind" >{{:srvApiName}}</div>
                                                <div class="showbj"><i class="fa fa-posi fa-caret-up"></i>{{:srvApiName}}</div>
                                            </div>
										</td>
										<td>
											<div class="hind1 text-l pl-15">
                                                <div class="center-hind" >{{:srvCategoryValue}}</div>
                                                <div class="showbj"><i class="fa fa-posi fa-caret-up"></i>{{:srvCategoryValue}}</div>
                                            </div>
										</td>
										<td>
											{{if prdlineCount>0}}
												<a href="javaScript:void(0)" onclick="pager._showPrdlineInfo('{{:srvApiId}}')" class="blue-border">{{:prdlineCount}}</a>
											{{else}}
												0
											{{/if}}
										</td>
                                        <td>
											{{if versionCount>0}}
												<a href="javaScript:void(0)" onclick="pager._showVersionInfo('{{:srvApiId}}')" class="blue-border">{{:versionCount}}</a>
											{{else}}
												0
											{{/if}}
										</td>
									</tr>
									{{/for}}
								</script>
							</div>
							<!--分页-->
							<div class="paging">
								<ul id="pagination-ul">
								</ul>
							</div>
							<!--分页结束-->
						</div>
                        	
                        	<div  class="row pt-30">
                            	<p class="center pr-30 mt-30">
                                    <input id="cancelBtn" type="button" class="biu-btn  btn-primary  btn-small  ml-5"
                                           value="返    回">
                            	</p>
                            </div>
                        	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
	
	
	</div>
	<%@ include file="/jsp/common/foot.jsp"%>
</div>
</div>
</div>
</body>
<style type="text/css">
.my-service-menu {
    width: 180px;
    background: #fff;
    float: left;
    height: 100%;
    overflow: hidden;
    margin-top: 10px;
    padding-bottom: 30px;
}
.my-service-cnt {
    width: 890px;
    float: left;
    margin: 10px 0 0 20px;
}
</style>

<script type="text/javascript">
    var pager;
    (function () {
        seajs.use('app/jsp/prdline/serviceList', function (serviceListPager) {
            pager = new serviceListPager({element: document.body});
            pager.render();
        });
    })(); 
    
    var zTreeNodes;
    var setting = {
    	isSimpleData : true,              //数据是否采用简单 Array 格式，默认false  
    	treeNodeKey : "categoryId",               //在isSimpleData格式下，当前节点id属性  
    	treeNodeParentKey : "parentCategoryId",        //在isSimpleData格式下，当前节点的父节点id属性  
    	showLine : true,    
        async: {
            enable: true,
            url: "${_base}/category/treeData",
            autoParam: ["categoryId"],
            dataFilter: filter
        }, 
        callback: {
            onClick: function (event, treeId, treeNode) {
                $("#selectName").val(treeNode.categoryName);
                $("#selectId").val(treeNode.categoryId);
                $("#category").html(treeNode.categoryName);
                $("#categoryId").val(treeNode.categoryId);
                pager._selectServiceList();
            }
        },
        view: {
            showIcon: true
        }
    };

    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null
        for (var i = 0, l = childNodes.length; i < l; i++) {
            childNodes[i].name = childNodes[i].categoryName;
            childNodes[i].isParent = true;
        }
        return childNodes;
    }

    $(document).ready(function () {
        $.fn.zTree.init($("#treeDemo"), setting);
    });
</script>

</html>