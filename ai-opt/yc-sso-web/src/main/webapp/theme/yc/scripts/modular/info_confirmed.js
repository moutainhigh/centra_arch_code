$(function(){
  var num=3;//设置添加的翻译语言子元素个数的计数器
  var id=3;
  var langValue;//语言名称的dataValue值
  var typeValue;//翻译方式的dataValue值
 
  //添加语言的效果
  $(document).on('click','[add-languages]',function(){
    var text = $("<div class='edit quesbox addLanguage'> <ul class='quesbox-wrap addLanguage'> <li> <div class='select-wrap select-wrap1'> <div class='select radius drop-down LanguageType' drop-down dataValue="+langValue+">中文→西班牙语</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;' dataValue='1' selectA1>中文→英语</a></li> <li><a href='javascript:;' dataValue='2' selectA1>中文→日语</a></li> <li><a href='javascript:;' dataValue='3' selectA1>中文→韩语</a></li> </ul> </div> </div> <div class='select-wrap select-wrap2'> <div class='select radius drop-down selectType' drop-down dataValue="+typeValue+">口译</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;' dataValue='1' selectA2>口译</a></li> <li><a href='javascript:;' dataValue='2' selectA2>笔译</a></li> </ul> </div> </div> <input type='text' class='int-text int-mini radius input1 inputPrice' id='ok'> <span class='unit' >元/千字</span> <p class='edit-chose'> <span class='txt4' ok></span> <span class='txt5' clear></span> </p> </li> </ul> </div>"); 
      //每次只能添加一个编辑项目
      if(!$(this).parent('.value').find('[add-program] .quesbox').length>0){
        $(this).siblings('[add-program]').append(text);
      }
      return false;
  });
  //确定添加语言
  $(document).on('click','[ok]',function(){
    var input1=$('.addLanguage').find(".LanguageType").html()// 取得选项-1的值 语种
    var input2=$('.addLanguage').find(".selectType").html()//取得选项-2的值 口译或者笔译
    var input3=$('.addLanguage').find(".inputPrice").val()//取得选项-3的值 价格
    var clone=$( "<p class=inputp"+num+"><span class='txt1 inputLang'>"+input1+"</span>"+"<span class='txt2 inputType' >"+input2+"</span>"+"<span class='txt1 inputPrice'><strong>"+input3+"</strong>元/千字（参考价）</span>"+"<span>未测试</span>"+"<input type='button' class='btn biu-btn btn-auto-25 btn-red radius10' name="+id+" value='删 除' delete-language ><input type='button' class='btn biu-btn btn-auto-25 btn-green radius10' editBtnLang name=1."+id+" value='编 辑' "+"><input type='button' class='btn biu-btn btn-auto-25 btn-blue radius10' value='测 试'></p>" )
    $('.inputexit').before(clone);
    num+=1;
    id+=1;
    $('.addLanguage.quesbox').remove();
    console.log('执行确定添加语言')
  })
  //取消添加语言
  $(document).on('click','[clear]',function(){
    $('.addLanguage.quesbox').remove();
  })
  //编辑当期翻译语言
  $(document).on('click','[editBtnLang]',function(){
    var input1=$(this).parent().find(".inputLang").html()// 取得选项-1的值 语种
    var input2=$(this).parent().find(".inputType").html()//取得选项-2的值 口译或者笔译
    var input3=$(this).parent().find(".inputPrice").find('strong').html()//取得选项-3的值 价格
    // input1=1231;
    // console.log(input3)
    // var delettedNodeNum=$(this).attr('name').substr(2)//处理’编辑‘对应的id 取尾数
    var delettedName=$(this).attr('name')+''
    var delettedNodeNum=parseInt(delettedName.replace(/[^0-9]/ig,""))-10
    var id = ".inputp"+delettedNodeNum;
    var langType = $(this).parent().children();//编辑按钮的父级是<p>
    var parentp=$(this).parent();//编辑按钮的父级
    var contentp=$(this).parent().children();//编辑按钮的父级的所有子节点
    // console.log(langType)
    var edit = $("<div class='edit quesbox addLanguage'> <ul class='quesbox-wrap addLanguage'> <li> <div class='select-wrap select-wrap1'> <div class='select radius drop-down LanguageType' drop-down>"+input1+"</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;'>中文→英语</a></li> <li><a href='javascript:;'>中文→日语</a></li> <li><a href='javascript:;'>中文→韩语</a></li> </ul> </div> </div> <div class='select-wrap select-wrap2'> <div class='select radius drop-down selectType' drop-down>"+input2+"</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;'>口译</a></li> <li><a href='javascript:;'>笔译</a></li> </ul> </div> </div> <input type='text' class='int-text int-mini radius input1 inputPrice input-sm' id='ok' value="+input3+"> <span class='unit' >元/千字</span> <p class='edit-chose'> <span class='txt4' okkk ></span> <span class='txt5' clearcc ></span> </p> </li> </ul> </div>"); 
    //每次只允许编辑一个选项
    if(!$(this).parents('.value').find('.addLanguage').length>0){
      //禁用本栏目其他编辑按钮
      $(this).parents('.inputContainer').find('[editBtnLang]').attr("disabled",true);
      // 移除全部子节点（编辑框在原位）
      // langType.remove();
      //添加修改的内容到<p>（编辑框在原位）
      // parentp.append(edit)
      $('.inputexit').before(edit)

      
    }
    $(document).on('click','[clearcc]',function(){
      //移除编辑框
      $('.addLanguage').remove();
      //把原内容放回原位置
      parentp.append(contentp)
      //取消其他按钮禁用
      $('[editBtnLang]').removeAttr("disabled");
    })
    // $(document).on('click','[okkk]',function(){
      $('[okkk]').off("click").click(function(){
      var input11=$('.addLanguage').find(".LanguageType").html()// 取得选项-1的值 语种
      var input22=$('.addLanguage').find(".selectType").html()//取得选项-2的值 口译或者笔译
      var input33=$('.addLanguage').find(".inputPrice").val()//取得选项-3的值 价格
      //添加修改的内容
      var cls='inputp'+delettedNodeNum
      var clone=$( "<p class='"+cls+"'><span class='txt1 inputLang'>"+input11+"</span>"+"<span class='txt2 inputType' >"+input22+"</span>"+"<span class='txt1 inputPrice'><strong>"+input33+"</strong>元/千字（参考价）</span>"+"<span>未测试</span>"+"<input type='button' class='btn biu-btn btn-auto-25 btn-red radius10' name="+delettedNodeNum+" value='删 除' delete-language ><input type='button' class='btn biu-btn btn-auto-25 btn-green radius10' editBtnLang name=1."+delettedNodeNum+" value='编 辑' "+"><input type='button' class='btn biu-btn btn-auto-25 btn-blue radius10' value='测 试'></p>" )
      // 移除全部子节点
      $('.inputContainer').find(id).replaceWith(clone);
      console.log(id)
      console.log(delettedNodeNum)
      //移除inputpx
      // $('.inputContainer').find(id).remove()
      // 移除当前编辑框
      $('.addLanguage').remove();
      //取消其他按钮禁用
      $('[editBtnLang]').removeAttr("disabled");
    })
  })
   //删除当前认证语言
	$(document).on('click','[delete-language]',function(){
		var delettedNodeNum=$(this).attr('name');
		$('#delete-language-mask').fadeIn(100);
		$('#delete-language').slideDown(100);
		//点击确认
		$('#delete-language-confirm').click(function(){
		  $('#delete-language-mask').fadeOut(200);
		  $('#delete-language').slideUp(200);
		  var cla=".inputp"+delettedNodeNum;
		  $('.inputContainer').find(cla).remove();
		  $('.addLanguage').remove();
		  //取消其他按钮禁用
		  $('[editBtnLang]').removeAttr("disabled");
		})
		//点击取消
		$('#delete-language-cancel').click(function(){
		  $('#delete-language-mask').fadeOut(200);
		  $('#delete-language').slideUp(200);
		  delettedNodeNum=''
		}) 
	}) 
});