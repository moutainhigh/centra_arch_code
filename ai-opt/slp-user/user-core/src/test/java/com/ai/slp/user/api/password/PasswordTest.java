package com.ai.slp.user.api.password;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.ucUserSecurity.interfaces.IUcUserSecurityManageSV;
import com.ai.slp.user.api.ucUserSecurity.param.UpdatePasswordRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class PasswordTest {

    @Autowired
    IUcUserSecurityManageSV uc;
    @Test
    public void updatePassword(){
        UpdatePasswordRequest request = new UpdatePasswordRequest();
        request.setTenantId("0");
        request.setUserLoginName("11124");
        request.setUserType("10");
        request.setUserLoginPwd("1234567");
        uc.updatePassword(request);
    } 
}
