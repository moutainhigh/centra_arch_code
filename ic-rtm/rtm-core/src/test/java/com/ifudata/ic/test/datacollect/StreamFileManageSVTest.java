package com.ifudata.ic.test.datacollect;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.ifudata.ic.rtm.api.datacollect.interfaces.IdataCollectSV;
import com.ifudata.ic.rtm.api.datacollect.params.JsDataVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class StreamFileManageSVTest {
    
	@Autowired
    protected IdataCollectSV collectSV;

    @Test
    public void importBillDetailData() {
//    	StreamFileParam streamFileParam = new StreamFileParam();
//    	//{"operId":"1","filePosition":"10.1.130.84:/aifs01/users/pabas01/tmp/test",
//    	//"fileName":"0005_20160427103610422.zip","accountPeriod":"201604",
//    	//"dataObj":"mvne-msg","tenantId":"809730CBD17648EFBAD2F4684D1EF233"}
//    	
//    	streamFileParam.setAccountPeriod("201604");
//    	streamFileParam.setDataObj("BIU-SF");
//    	streamFileParam.setFileName("testsmcdata.zip");
//    	streamFileParam.setFilePosition("192.168.0.16:/data/thrdsoft01/tools");
//    	streamFileParam.setOperId("1");
//    	streamFileParam.setTenantId("ifudata");
//		BaseResponse fileInport = streamService.fileInport(streamFileParam);
    	
    	JsDataVO dataVO = new JsDataVO();
    	dataVO.setMessage("ifudataBIU-SF20160301001mvne123456BIU-SF201603010011001hxbw17091234562016/3/1 12:23\"短信发送测试内容\"\"短信发送测试内容\"\"短信发送测试内容.\"1");
        dataVO.setjSBsn("JSifudata20160301001");
        JSONObject.toJSONString(dataVO);
        collectSV.JsResource(dataVO);
    	
//		System.out.println(JSONObject.toJSONString(fileInport));
    }
}
