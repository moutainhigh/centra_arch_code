/**
 * 二代身份证读取数据
 * 
 */
function showvalue(cabId,name,sex,nation,num,addr,valid,invalid,birthday){
	i=0;
	flag=0;
	try{
		if(cabId.OpenComm(1001)==1){
			flag=1;
		}else{
			for(i=1;i<3;i++){
			  if(cabId.OpenComm(i)==1){
					flag=1;
					break;
				}
			}
			if(flag!=1){
				$.dialog.alert("身份证识别设备没有正常连接，请检查！"); 		
			}
		}			
	if(flag==1){
		if (cabId.Authen()==1){
			ret=cabId.ReadCardPath("c:\\",1);
			if(ret==1||ret==3){
				var snation = '';
				var ssex = 0;
				switch(cabId.sNation){
					case '01' : snation = '汉';break;
					case '02' : snation = '蒙古';break;
					case '03' : snation = '回';break;
					case '04' : snation = '藏';break;
					case '05' : snation = '维吾尔';break;
					case '06' : snation = '苗';break;
					case '07' : snation = '彝';break;
					case '08' : snation = '壮';break;
					case '09' : snation = '布依';break;
					case '10' : snation = '朝鲜';break;
					case '11' : snation = '满';break;
					case '12' : snation = '侗';break;
					case '13' : snation = '瑶';break;
					case '14' : snation = '白';break;
					case '15' : snation = '土家';break;
					case '16' : snation = '哈尼';break;
					case '17' : snation = '哈萨克';break;
					case '18' : snation = '傣';break;
					case '19' : snation = '黎';break;
					case '20' : snation = '傈僳';break;
					case '21' : snation = '佤';break;
					case '22' : snation = '畲';break;
					case '23' : snation = '高山';break;
					case '24' : snation = '拉祜';break;
					case '25' : snation = '水';break;
					case '26' : snation = '东乡';break;
					case '27' : snation = '纳西';break;
					case '28' : snation = '景颇';break;
					case '29' : snation = '柯尔克孜';break;
					case '30' : snation = '土';break;
					case '31' : snation = '达斡尔';break;
					case '32' : snation = '仫佬';break;
					case '33' : snation = '羌';break;
					case '34' : snation = '布朗';break;
					case '35' : snation = '撒拉';break;
					case '36' : snation = '毛南';break;
					case '37' : snation = '仡佬';break;
					case '38' : snation = '锡伯';break;
					case '39' : snation = '阿昌';break;
					case '40' : snation = '普米';break;
					case '41' : snation = '塔吉克';break;
					case '42' : snation = '怒';break;
					case '43' : snation = '乌孜别克';break;
					case '44' : snation = '俄罗斯';break;
					case '45' : snation = '鄂温克';break;
					case '46' : snation = '德昂';break;
					case '47' : snation = '保安';break;
					case '48' : snation = '裕固';break;
					case '49' : snation = '京';break;
					case '50' : snation = '塔塔尔';break;
					case '51' : snation = '独龙';break;
					case '52' : snation = '鄂伦春';break;
					case '53' : snation = '赫哲';break;
					case '54' : snation = '门巴';break;
					case '55' : snation = '珞巴';break;
					case '56' : snation = '基诺';break;
					default : snation = '未知';
				}
				switch(cabId.sSex){
					case '0' : ssex = 2;break;
					case '1' : ssex = 1;break;
					case '2' : ssex = 0;break;
					default : ssex = 2;
				}
				$("#"+name).val(cabId.sName);
				$("#"+sex).val(ssex);
				$("#"+nation).val(snation);
				$("#"+num).val(cabId.sIDNo);
				$("#"+addr).val(cabId.sAddress);
				$("#"+valid).val(cabId.sStartDate.substr(0,4)+'-'+cabId.sStartDate.substr(4,2)+'-'+cabId.sStartDate.substr(6,2));
				$("#"+invalid).val(cabId.sEndDate.substr(0,4)+'-'+cabId.sEndDate.substr(4,2)+'-'+cabId.sEndDate.substr(6,2));
				$("#"+birthday).val(cabId.sBornDate.substr(0,4)+'-'+cabId.sBornDate.substr(4,2)+'-'+cabId.sBornDate.substr(6,2));
				
				$("#"+name).attr("readonly","readonly");
				$("#"+sex).attr("disabled","disabled");
				$("#"+nation).attr("readonly","readonly");
				$("#"+num).attr("readonly","readonly");
				$("#"+addr).attr("readonly","readonly");
				$("#"+valid).attr("disabled","disabled");
				$("#"+invalid).attr("disabled","disabled");
				$("#"+birthday).attr("disabled","disabled");
				cabId.ReadCard(3)
			}else{
				$.dialog.alert("读卡错误！"+cabId.ReadCardPath("",1));
			}
		}else{
			$.dialog.alert("请重新放置身份证卡片！");
		}
	}
	cabId.EndComm();
	}catch(e){
		$.dialog.alert("请使用IE浏览器，并正确安装控件！");
	}
}

