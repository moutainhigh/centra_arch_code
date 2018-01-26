<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${_base}/js/jquery/validate/card.js"></script>
 <script type="text/javascript" src="${_base}/js/jquery/validate/commonPrompt.js"></script>

     <script type="text/javascript">
     var  JbrFlag =true;
     $(document).ready(function() {
    	 $("#jbrIsDisplay :input").val("");
    	 gestor_display(-1);
    		
    	// initValadate();
    		 
    	});
     
     function gestor_display(isShow){
    		if(isShow==-1){
    			$("#jbrIsDisplay").hide();
    			$("#exp_div_gestor").show();
    			$("#duc_div_gestor").hide();
    			if($("#JbrName").val()!=null&&$("#JbrName").val()!=""){
    				 $("#gestorInfo").html("");
    				 $("#gestorInfo").html(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经办人:"+$("#JbrName").val()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 证件号:"+$("#JbrCertNum").val()+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:"+$("#JbrTel").val());		
    				 $("#gestorInfo").show();	
    			}else{
    				 $("#gestorInfo").html("");
    			}
    		}
    		if(isShow==1){
    			$("#jbrIsDisplay").show();
    			$("#exp_div_gestor").hide();
    			$("#duc_div_gestor").show();
    			 $("#gestorInfo").html("");
    		}	
    	};
     
     function initValadate(){
    	
			 var JbrName = $("#JbrName").val();
			 if(JbrName!='' && JbrName.getRealLen()>32){
				 showPromptDivByEleId("姓名不能超过32个字符", "JbrName","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
			 var JbrCertNum = $("#JbrCertNum").val();
			 var JbrCertType =$("#JbrCertType").val();
			 if(JbrCertNum!='' && JbrCertType==''){
				 showPromptDivByEleId("请选择证件类型", "JbrCertType","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
			 if(JbrCertNum=='' && JbrCertType!=''){
				 showPromptDivByEleId("请输入证件号码", "JbrCertNum","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
			 if(JbrCertNum!='' && JbrCertType=="01" && idCardNoUtil.checkIdCardNo(JbrCertNum)==false){
				 showPromptDivByEleId("请输入正确的身份证号码", "JbrCertNum","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
			 if(JbrCertNum !="" && JbrCertNum !="01"){
				 if(JbrCertNum.getRealLen()>32){
					 showPromptDivByEleId("长度不能大于16个汉字或32个字母（数字）", "JbrCertNum","top",200,30);
					 JbrFlag = false;
					 return JbrFlag;
				 }
			 }
			 var JbrTel = $("#JbrTel").val();
			 if(JbrTel!='' && checkPhone(JbrTel)==false){
				 showPromptDivByEleId("经办人电话有误", "JbrTel","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
		 
			 var JbrInfo = $("#JbrInfo").val();
			 if(JbrInfo!='' && JbrInfo.getRealLen()>1024){
				 showPromptDivByEleId("备注长度不能超过512个字符", "JbrInfo","top",200,30);
				 JbrFlag = false;
				 return JbrFlag;
			 }
		 JbrFlag = true;
		 return JbrFlag;
     };
     
     function checkPhone(phoneNum){
    	 var isMobile = /^0?[1][34578]\d{9}$/;
    	 //var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
    	 if(!isMobile.test(phoneNum)){
             return false;
         }
    	 return true;
    };
    String.prototype.getRealLen = function() { 
    return this.replace(/[^\x00-\xff]/ig, "aa").length; 
    };

     </script>
   <div class="big_main">
	    <div class="big_title">
	    	<p>经(代)办人信息</p>
	    	<p id="exp_div_gestor"><a href="javascript:void(0)" id="" onclick="return gestor_display(1)">【展开】</a></p>
	    	<p id="duc_div_gestor"><a href="javascript:void(0)" id="" onclick="return gestor_display(-1)">【收起】</a></p>
	  	</div>
   		
    <!---录入表单查询--->
    <div class="query_main" id="jbrIsDisplay" style="display:none">
    	<form id ="form1">
      <ul>
        <li>
          <p class="query_zi">经(代)办人姓名：</p>
          <p>
            <input name="JbrName" type="text" class="query_input" id="JbrName"  />
          </p>
        </li>
        <li>
          <p class="query_zi">经(代)办人证件类型：</p>
          <p>
            <ifudata:select dictId="CM_CUST.CERT_TYPE_PERSON" name="JbrCertType" id="JbrCertType" styleClass="query_xial"  nullOption="true"></ifudata:select>
          </p>
        </li>
      </ul>
      <ul>
        <li>
          <p class="query_zi">经(代)办人证件号码：</p>
          <p>
            <input name="JbrCertNum" type="text" class="query_input" id="JbrCertNum"  />
          </p>
        </li>
        <li>
          <p class="query_zi">经(代)办人电话：</p>
          <p>
            <input name="JbrTel" type="text" class="query_input" id="JbrTel"  />
          </p>
        </li>
      </ul>
      <ul>
        <li>
          <p class="query_zi">备注：</p>
          <p>
             <textarea name="JbrInfo" class="query_input5" id="JbrInfo" style=" resize:none;" ></textarea>
          </p>
        </li>
      </ul>
      
      </form>
      	
    </div>
     <div id="gestorInfo">
         	 <div class="fk-grid">
            	<div class="n-cols">
                    <div class="fk-d">
                     </div>
                </div>
            </div> 
            
        </div>
  </div>