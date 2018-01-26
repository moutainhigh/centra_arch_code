package com.ai.slp.user.api.message.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.message.interfaces.IUserMessageSV;
import com.ai.slp.user.api.message.param.DeleteMessageRequest;
import com.ai.slp.user.api.message.param.InsertUserMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageRequest;
import com.ai.slp.user.api.message.param.UpdateMessageRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UserMessageSVImplTest {

    @Autowired
    private IUserMessageSV userMessageSV;
    
    //@Test
    public void insertMessageTest(){
        InsertUserMessageRequest request = new InsertUserMessageRequest();
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        request.setUserId("111");
        request.setInfoSeqId("111");
        request.setInfoType("2");
        request.setReadFlag("2");
        
        System.out.println(userMessageSV.insertUserMessage(request).getResponseHeader());
    }
    
    //@Test
    public void updateMessageTest(){
        UpdateMessageRequest request = new UpdateMessageRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setOperCode("0001");
        request.setOperId("111");
        userMessageSV.updateUserMessage(request);
    }
    
    @Test
    public void queryMessageTest(){
        QueryMessageRequest request = new QueryMessageRequest();
        request.setPageNo(11);
        request.setPageSize(11);
        request.setReadFlag("10");
        request.setTenantId("SLP");
        request.setUserId("111");
        System.out.println(userMessageSV.queryUserMessage(request).getPageInfo().getResult().size());
    }
    
    //@Test
    public void deleteMessageTest(){
        DeleteMessageRequest request = new DeleteMessageRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        List<String> list = new ArrayList<String>();
        list.add("111");
        request.setList(list);
        userMessageSV.deleteMessage(request);
    }
    
}
