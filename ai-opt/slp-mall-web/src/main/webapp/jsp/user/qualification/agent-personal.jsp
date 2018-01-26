<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ include file="/inc/inc.jsp"%>
<!--Support IE Text -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>资质申请－代理商－个人</title>
<link href="${_slpbase }/styles/modular.css" rel="stylesheet" type="text/css">
<link href="${_slpbase }/styles/global.css" rel="stylesheet" type="text/css">
<link href="${_slpbase }/styles/frame.css" rel="stylesheet" type="text/css">
<link href="${_slpbase }/styles/font-awesome.css" rel="stylesheet" type="text/css">
</head>
<body>
 <!--顶部菜单-->
 <%@ include file="/inc/top-menu.jsp" %>
<!--顶部菜单结束-->

<!--导航区域-->
 <%@ include file="/inc/user-nav.jsp" %>
<!--导航区域结束-->
     <!--订单详情-->
<div class="fsast-charge">
    <div class="big-wrapper"><!--内侧居中框架-->
    <!--我的订单-->
    <!--我的订单左侧-->
     <%@ include file="/inc/user-leftmenu.jsp" %>
 <!--／我的订单左侧结束-->  
<!--资质申请右侧-->  
  <div class="my-order-cnt">
       <div class="payment-title">
          <p><a href="#">账户中心</a>&gt;</p>
          <p><a href="#">资质认证</a></p>
      </div>
      <div class="account-bj">
       <!--提示风险-->
        <div class="prompt-risk small-risk">
            <p>提醒：代理商用户在完善基础认证信息后，才能查看代理商专属价格及专属货品，赶快提交认证所需信息吧！</p>
            <p class="img"><img src="${_slpbase}/images/yue-1.png"></p>
        </div>
      <!--标题-->
     <div class="mar-account-title">
     <div class="account-title"><p>资质类型:个人</p></div>
     </div>
     
     <!--标题-->  
     <div class="account-title"><p>个人资质信息</p></div>
     <!--信息填写-->
     <form:form id="agentPersonal" method="post">
     <div class="nav-form">
         <ul>
             <li>
                <p class="word"><b class="red">*</b>真实姓名:</p>
               <p><input type="text" class="int-medium" placeholder="请填写真实姓名" id="realName" name="custName"></p>
                     <label id="realNameErrMsg" style="display:none"><img src="${_slpbase}/images/icon-d.png" id="realNameImage"><span id="realNameText">2-24个字符，可用汉字或英语字母</span></label>
             </li>
         </ul>
         <ul>
             <li>
                <p class="word"><b class="red">*</b>性别:</p>
                <p><input type="radio" class="checkbox-medium" name="custSex" id="man" value="0"><span class="Gender">男</span></p>
                <p><input type="radio" class="checkbox-medium" name="custSex" id="woman" value="1" ><span class="Gender">女</span></p>
                <label id="custSexErrMsg" style="display:none"><img src="${_slpbase}/images/icon-d.png" id="custSexImage"><span id="custSexText">2-24个字符，可用汉字或英语字母</span></label>
             </li>
         </ul>
         <ul>
             <li>
                <p class="word">学历:</p>
                <p>
                 <select class="select-medium" id="custEducation" name="custEducation">
                 	<option value="0">请选择</option>
                 	<c:forEach var="map" items="${educationMap}">
                 		<option value="${map.key}">${map.value}</option>
                 	</c:forEach>
                 </select>
                 <label id="custEducationErrMsg" style="display:none"><img src="${_slpbase}/images/icon-a.png" id="custEducationImage"><span class="ash" id="custEducationText">请输入学历信息</span></label>
                </p>
             </li>
         </ul>
       	  <ul>
              <li>
                <p class="word"><b class="red">*</b>联系地址:</p>
                <p>
                
                <select class="select-xmini" id="provinceCode" name="custProvinceCode" >
                	<option value="0">请选择</option>
                	<c:forEach items="${provinceList}" var="record">
                		<option value="${record.provinceCode}">${record.areaName }</option>
                	</c:forEach>
                </select>
                
                </p>
                <p>
                 <select class="select-xmini" id="cityCode" name="custCityCode">
                	<option value="0">请选择</option>
                 </select>
                </p>
                <p>
                  <select class="select-xmini" id="countyCode" name="custCountyCode">
                	<option value="0">请选择</option>
                  </select></p>
                <label id="registerAddrErrMsg" style="display:none"><img src="${_slpbase}/images/icon-a.png" id="registerAddrImage"><span class="ash" id="registerAddrText">请选择联系地址信息</span></label>
             </li>
             <li class="right">
             <p><input type="text" class="int-xlarge" placeholder="详细街道地址" id="certAddr" name="custAddr"></p>
             <label id="certAddrErrMsg" style="display:none"><img src="${_slpbase}/images/icon-c.png" id="certAddrImage"><span class="ash" id="certAddrText">5-120个字符</span></label>
             </li>
         </ul>
          <ul>
             <li>
                <p class="word">生日:</p>
                <p><select class="select-xmini" id="yy_mm_dd" name="yy_mm_dd">
                	 <option value="0">请选择</option>
                   </select>
                 </p>
                <p>
                	<select class="select-xmini" id="mm" name="mm">
                		<option value="0">请选择</option>
                	</select>
                </p>
                <p>
                	<select class="select-xmini" id="dd" name="dd">
                		<option value="0">请选择</option>
                	</select>
                </p>
                <label id="bithdayErrMsg" style="display:none"><img src="${_slpbase}/images/icon-a.png" id="bithdayImage"><span class="ash" id="bithdayText">请选择生日信息</span></label>
             </li>
             
         </ul>
   		  <ul>
             <li>
                <p class="word">收入:</p>
                <p>
	                <select class="select-medium" id="inCome" name="incomeLevel">
		                <option value="0">请选择收入</option>
		                <c:forEach var="map" items="${incomeLevelMap}">
                 			<option value="${map.key}">${map.value}</option>
                 		</c:forEach>
	                </select>
                </p>
                <label id="idComeErrMsg" style="display:none"><img src="${_slpbase}/images/icon-a.png" id="inComeImage"><span class="ash" id="inComeText">请选择收入信息</span></label>
             </li>
         </ul>
         <ul>
             <li>
                <p class="word">介绍信息:</p>
                <p><textarea type="text" class="textarea-xxlarge" id="introduce" name="personalRemark" placeholder = "简要介绍您产品销售渠道方面的优势或经验等相关内容"></textarea></p>
                <label id="personalRemarkErrMsg" style="display:none"><img src="${_slpbase}/images/icon-a.png" id="personalRemarkImage"><span class="ash" id="personalRemarkText">请选择收入信息</span></label>
             </li>
         </ul>
     </div>
     <!--标题-->  
     <div class="account-title"><p>身份证信息</p></div>
     <!--信息填写-->
     <div class="nav-form">
           <ul>
                <li>
                	<p class="word"><b class="red">*</b>身份证号:</p>
                    <p><input type="text" class="int-medium" placeholder="请填写和真实姓名一致的18位身份证号码" id="idNumber" name="certNum"></p>
                     <label id="idNumberErrMsg" style="display:none"><img src="${_slpbase}/images/icon-c.png" id="idNumberImage"><span class="ash" id="idNumberText">18位数字</span></label>
                 </li>
             </ul>
               <ul>
	             <li>
	                <p class="word"><b class="red">*</b>身份证正面照:</p>
	                <input type="hidden" name="list[0].infoName" value="身份证正面照"/>
	                 <input type="hidden" value="11" name="list[0].infoType">
               		 <input type="hidden" value="11001" name="list[0].infoItem">
	                <p class="img"><img src="${_slpbase }/images/fom-t.png" id="certPic1"></p>
	                <p class="small-p">
	                <span><input type="button" value="点击上传" class="file-btn">
	                <input type="file" class="file" id="image1" name="image1" onchange="uploadImg('image1','certPic1','idpsId1','imgErrShow1');">
	                <a href="javascript:void(0)" onclick="deleteImg('image1','certPic1','idpsId1','imgErrShow1');">删除</a></span>
	                <span>支持JPG/PNG/GIF格式，最大不超过3M</span>
	                <span id="imgErrShow1"></span>
	                </p>
	                <%-- <p><div class="card-left-word"><img src="${_slpbase }/images/icon-a.png">请上传手持证件照片</div></p> --%>
	                </li>
	              <li>
	                 <!--右侧展示-->   
                    <div class="card-right-big">
                         <p>示例:</p>
                            <div class="card-right">
                               <img src="${_slpbase }/images/card-1.png">
                    </div>
                   </div>
	            
	            </li>
        		 </ul>
        		  <ul>
	             <li>
	                <p class="word"><b class="red">*</b>身份证背面照片:</p>
	                <input type="hidden" name="list[1].infoName" value="身份证背面照片"/>
	                  <input type="hidden" value="11" name="list[1].infoType">
               		 <input type="hidden" value="11002" name="list[1].infoItem">
	                <p class="img"><img src="${_slpbase }/images/fom-t.png" id="certPic2"></p>
	                <p class="small-p">
	                <span><input type="button" value="点击上传" class="file-btn">
	                <input type="file" class="file" id="image2" name="image2" onchange="uploadImg('image2','certPic2','idpsId2','imgErrShow2');">
	                <a href="javascript:void(0)" onclick="deleteImg('image2','certPic2','idpsId2','imgErrShow2');">删除</a></span>
	                <span>支持JPG/PNG/GIF格式，最大不超过3M</span>
	                <span id="imgErrShow2"></span>
	                </p>
	               <%--  <p><div class="card-left-word"><img src="${_slpbase }/images/icon-a.png">请上传手持证件照片</div></p> --%>
	                </li>
	              <li>
	                 <!--右侧展示-->   
                    <div class="card-right-big">
                         <p>示例:</p>
                            <div class="card-right">
                               <img src="${_slpbase }/images/card-1.png">
                    </div>
                   </div>
	            
	            </li>
        		 </ul>
        		  <ul>
	             <li>
	                <p class="word"><b class="red">*</b>手持身份证正面照片:</p>
	                <input type="hidden" name="list[2].infoName" value="手持身份证正面照片"/>
	                 <input type="hidden" value="11" name="list[2].infoType">
               		 <input type="hidden" value="11003" name="list[2].infoItem">
	                <p class="img"><img src="${_slpbase }/images/fom-t.png" id="certPic3"></p>
	                <p class="small-p">
	                <span><input type="button" value="点击上传" class="file-btn">
	                <input type="file" class="file" id="image3" name="image3" onchange="uploadImg('image3','certPic3','idpsId3','imgErrShow3');">
	                <a href="javascript:void(0)" onclick="deleteImg('image3','certPic3','idpsId3','imgErrShow3');">删除</a></span>
	                <span>支持JPG/PNG/GIF格式，最大不超过3M</span>
	                <span id="imgErrShow3"></span>
	                </p>
	               <%--  <p><div class="card-left-word"><img src="${_slpbase }/images/icon-a.png">请上传手持证件照片</div></p> --%>
	                </li>
	              <li>
	                 <!--右侧展示-->   
                    <div class="card-right-big">
                         <p>示例:</p>
                            <div class="card-right">
                               <img src="${_slpbase }/images/card-1.png">
                    </div>
                   </div>
	            </li>
        		 </ul>
             <ul>
                 <li class="form-btn">
                 	<input type="button" class="slp-btn regsiter-btn" id="savePersonalQualification" value="保存资质">
                 	<input type="hidden" id="realNameFlag"/>
                 	<input type="hidden" id="certAddrFlag">
                 	<input type="hidden" id="idNumberFlag"/>
                 	<input type="hidden" id="bithdayFlag"/>
                 	<input type="hidden" id="inComeFlag"/>
                 	<input type="hidden" id="custEducationFlag"/>
                 	<input type="hidden" id="provinceCodeFlag"/>
                 	<input type="hidden" id="picFlag"/>
                 	<input type="hidden" id="contactNameFlag"/>
                 	<input type="hidden" id="custSexFlag"/>
                 	
                 	<input type="hidden" id="idpsId1" name="list[0].attrValue"/>
                 	<input type="hidden" id="idpsId2" name="list[1].attrValue"/>
                 	<input type="hidden" id="idpsId3" name="list[2].attrValue"/>
                 </li>
             </ul>
             </div>
     </form:form>
     </div>
     </div>
  		</div>  
   		</div>
		 <!--底部-->
    		<%@ include file="/inc/foot.jsp" %>
   <!--底部 结束-->
</body>
</html>
<script type="text/javascript">
		var agentPersonalPager;
		var baseInfoPager;
		var gender = "";
		var year = "";
		var qualificationSubmitPager;
		(function() { 
			seajs.use(['app/jsp/user/qualification/agent-personal','app/jsp/user/qualification/baseinfo','app/jsp/user/qualification/qualificationSubmit'],function(AgentPersonalPager,BaseInfoQualificationPager,QualificationSubmitPager) {
				    agentPersonalPager = new AgentPersonalPager({
					element : document.body
				});
				    baseInfoPager = new BaseInfoQualificationPager({
					element : document.body
				});
				    qualificationSubmitPager = new QualificationSubmitPager({
					element : document.body
				});
				agentPersonalPager.render();
				baseInfoPager.render();
				qualificationSubmitPager.render();
			});
		})();  
</script>
