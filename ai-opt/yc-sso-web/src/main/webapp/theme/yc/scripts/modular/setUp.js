$(document).on('click','[setting-save-btn1]',function(){
    var input1=$(this).parent().find(".setting-input").html()// 取得选项-1的值 语种
    var input2=$(this).parent().find(".setting-price").find('strong').html()//取得选项-2的值 价格
    // input1=1231;
    // console.log(input1);
    // console.log(input2);
    // var delettedNodeNum=$(this).attr('name').substr(2)//处理’编辑‘对应的id 取尾数
    var delettedName=$(this).attr('name')+'';

    var delettedNodeNum=parseInt(delettedName.replace(/[^0-9]/ig,""))-10
    var id = ".inputp"+delettedNodeNum;
    var settingType = $(this).parent().children();//编辑按钮的父级是<p>
    var parentp=$(this).parent();//编辑按钮的父级
    var contentp=$(this).parent().children();//编辑按钮的父级的所有子节点
    
    var edit = $("<div class='edit addLanguage'><ul class='addLanguage'><li><div class=' select-wrap1'>"+input1+"</i></div><input type='text' class='int-text int-mini radius input1 inputPrice input-sm' id='ok' value="+input2+"><span class='unit' >元/千字</span><p class='edit-chose'><span class='txt4' okkk ></span><span class='txt5' clearcc ></span></p></li></ul></div>"); 
    //var edit = $("<div class='edit quesbox addLanguage'> <ul class='quesbox-wrap addLanguage'> <li> <div class='select-wrap select-wrap1'> <div class='select radius drop-down LanguageType' drop-down>"+input1+"</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;'>中文→英语</a></li> <li><a href='javascript:;'>中文→日语</a></li> <li><a href='javascript:;'>中文→韩语</a></li> </ul> </div> </div> <div class='select-wrap select-wrap2'> <div class='select radius drop-down selectType' drop-down>"+input2+"</i></div> <div class='select-con undis'> <ul> <li><a href='javascript:;'>口译</a></li> <li><a href='javascript:;'>笔译</a></li> </ul> </div> </div> <input type='text' class='int-text int-mini radius input1 inputPrice input-sm' id='ok' value=''> <span class='unit' >元/千字</span> <p class='edit-chose'> <span class='txt4' okkk ></span> <span class='txt5' clearcc ></span> </p> </li> </ul> </div>"); 
    //每次只允许编辑一个选项
    
    if(!$(this).parents('.value').find('.addLanguage').length>0){
      //禁用本栏目其他编辑按钮
      $(this).parents('.transslate-price').find('[setting-save-btn1]').attr("disabled",true);
      // 移除全部子节点（编辑框在原位）
      // langType.remove();  
      //添加修改的内容到<p>（编辑框在原位）
      // parentp.append(edit)
      $('.inputext').before(edit);

      
    }
    $(document).on('click','[clearcc]',function(){
      //移除编辑框
      $('.addLanguage').remove();
      //把原内容放回原位置
      parentp.append(contentp)
      //取消其他按钮禁用
      $('[setting-save-btn1]').removeAttr("disabled");
    })
    // $(document).on('click','[okkk]',function(){
      $('[okkk]').off("click").click(function(){
      var input22=$('.addLanguage').find(".inputPrice").val()//取得选项-3的值 价格
      //添加修改的内容
      var cls='inputp'+delettedNodeNum
      var clone=$( "<p class='txt1 "+cls+"'><span class='setting-input'>"+input1+"</span>"+"<span class='setting-price'><strong>"+input22+"</strong>元/千字</span>"+"<input type='button' class='btn biu-btn btn-auto-25 btn-green radius10' name=1."+delettedNodeNum+" value='编 辑' setting-save-btn1></p>" )
      // 移除全部子节点
      $('.transslate-price').find(id).replaceWith(clone);
      // console.log(id)
      // console.log(delettedNodeNum)
      //移除inputpx
      // $('.inputContainer').find(id).remove()
      // 移除当前编辑框
      $('.addLanguage').remove();
      //取消其他按钮禁用
      $('[setting-save-btn1]').removeAttr("disabled");
    })
  })