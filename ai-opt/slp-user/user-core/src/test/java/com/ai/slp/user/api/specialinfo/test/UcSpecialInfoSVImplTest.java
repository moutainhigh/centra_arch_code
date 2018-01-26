package com.ai.slp.user.api.specialinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.specialinfo.interfaces.IUcSpecialInfoSV;
import com.ai.slp.user.api.specialinfo.param.InsertSpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.UpdateSepcialInfoRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UcSpecialInfoSVImplTest {

    @Autowired
    private IUcSpecialInfoSV ucSpecialInfoSV;

    //@Test
    public void insertSpecialInfoTest() {
        InsertSpecialInfoRequest request = new InsertSpecialInfoRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setInfoSpecialId(111L);
        request.setAttrValue("666");
        System.out.println(ucSpecialInfoSV.insertSpecialInfo(request).getResponseHeader());
    }

   // @Test
    public void updateSpecialInfoTest() {
        UpdateSepcialInfoRequest request = new UpdateSepcialInfoRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setInfoSpecialId(111L);
        ucSpecialInfoSV.updateSpecialInfo(request);
    }
    
    @Test
    public void querySpecialInfoTest(){
        QuerySpecialInfoRequest request = new QuerySpecialInfoRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setSpecialInfoId(111L);
        System.out.println(ucSpecialInfoSV.querySpecialInfo(request).getResponseHeader());
    }
}
