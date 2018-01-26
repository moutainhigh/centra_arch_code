package com.ai.slp.user.api.login.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.login.interfaces.ILoginSV;
import com.ai.slp.user.api.login.param.LoginRequest;
import com.ai.slp.user.api.login.param.LoginResponse;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class LoginSVImplTest {

    @Autowired
    private ILoginSV loginSV;
    
    @Test
    public void loginTest(){
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setTenantId("SLP");
        loginRequest.setUserLoginName("12345");
        //loginRequest.setUserEmail("11@qq.com");
        loginRequest.setUserType("11");
        //loginRequest.setUserLoginPwd("123456");
        LoginResponse loginResponse = loginSV.login(loginRequest);
        System.out.println(JSON.toJSONString(loginResponse));
    }
}
