package com.ai.slp.user.api.ucuser.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.ucUserSecurity.interfaces.IUcUserSecurityManageSV;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserPhoneRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UcSecurityTest {

    @Autowired
    IUcUserSecurityManageSV ic;

    @Test
    public void test(){
        
        UcUserPhoneRequest phoneModifyRequest = new UcUserPhoneRequest();
        phoneModifyRequest.setTenantId("0");
        phoneModifyRequest.setAccountId("000000000000000157");
        phoneModifyRequest.setPhone("111111");
        ic.setPhoneData(phoneModifyRequest);
    }
}
