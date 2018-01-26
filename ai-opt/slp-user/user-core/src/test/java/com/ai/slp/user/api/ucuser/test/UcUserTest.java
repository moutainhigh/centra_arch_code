package com.ai.slp.user.api.ucuser.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.ucuser.intefaces.IUcUserSV;
import com.ai.slp.user.api.ucuser.param.AgentUserResponse;
import com.ai.slp.user.api.ucuser.param.SearchUserRequest;
import com.ai.slp.user.api.ucuser.param.SearchUserResponse;
import com.ai.slp.user.api.ucuser.param.UcUserInfoParams;
import com.ai.slp.user.api.ucuser.param.UpdateUserInfoRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UcUserTest {
 
    @Autowired
    IUcUserSV ucUsersv;
    
    @Test
    public void testUcUser(){
        SearchUserRequest quest  = new SearchUserRequest();
        quest.setUserEmail("178070754@qq.com");
        SearchUserResponse response = ucUsersv.queryByEmail(quest);
        System.out.println("--------------"+JSON.toJSONString(response));
    }
    
    @Test
    public void updateTest(){
        UpdateUserInfoRequest re = new UpdateUserInfoRequest();
        re.setTenantId("SLP");
        re.setUserId("000000000000000101");
        re.setAuditState("10");
        ucUsersv.updateBaseInfo(re);
    }
    
    @Test
    public void testQueryAgentUserInfo(){
        UcUserInfoParams userInfoParams = new UcUserInfoParams();
        userInfoParams.setTenantId("SLP");
        userInfoParams.setUserId("000000000000000320");
        AgentUserResponse respose = ucUsersv.queryAgentUserInfo(userInfoParams);
        System.out.println(JSON.toJSONString(respose));
    }
}
