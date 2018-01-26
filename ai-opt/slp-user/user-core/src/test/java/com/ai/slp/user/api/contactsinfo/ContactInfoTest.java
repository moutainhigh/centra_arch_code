package com.ai.slp.user.api.contactsinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.contactsinfo.interfaces.IUcContactsInfoSV;
import com.ai.slp.user.api.contactsinfo.param.InsertContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoSingleRequest;
import com.ai.slp.user.api.contactsinfo.param.UpdateContactsInfoRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ContactInfoTest {

    @Autowired
    IUcContactsInfoSV iu;
    //@Test
    public void test()
    {
        InsertContactsInfoRequest re = new InsertContactsInfoRequest();
        re.setTenantId("SLP");
        re.setUserId("123");
        re.setContactCertNum("11");
        iu.insertContactsInfo(re);
    }
    
    @Test
    public void query(){
        QueryContactsInfoSingleRequest re = new QueryContactsInfoSingleRequest();
        re.setTenantId("SLP");
        re.setUserId("000000000000000202");
        System.out.println(JSON.toJSONString(iu.queryContactsInfoSingle(re)));
    }
    
    @Test
    public void update(){
        UpdateContactsInfoRequest re = new UpdateContactsInfoRequest();
        re.setTenantId("SLP");
        re.setUserId("000000000000000202");
        re.setContactAddress("12445");
        System.out.println(iu.updateContactsInfo(re));
    }
}
