package com.ai.slp.user.api.apiinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.apiinfo.param.ApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.ApiInfoResponse;
import com.ai.slp.user.api.apiinfo.param.InsertApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.UcApiInfoParams;
import com.ai.slp.user.service.business.interfaces.IApiInfoBusiSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ApiInfoSVImplTest {

    @Autowired
    private IApiInfoBusiSV apiInfoBusiSV;

    //@Test
    public void insertApiInfoTest() {
        InsertApiInfoRequest request = new InsertApiInfoRequest();
        request.setApiInfo("test11111");
        request.setApiName("1111");
        request.setApiType("00");
        request.setWebAddr("www.111.com");
        request.setUserId("111");
        request.setCreateOperId(111L);
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        System.out.println(apiInfoBusiSV.insertApiInfo(request).getResponseHeader());
    }

   //@Test
    public void updateApiInfoTest() {
        UcApiInfoParams request = new UcApiInfoParams();
        request.setApiKey("333");
        request.setSecretKey("555");
        request.setTenantId("test111");
        request.setUserId("111");
        request.setApiSeqId("2222");
        request.setUpdateOperId(111L);

        apiInfoBusiSV.updateApiInfo(request);
    }

    @Test
    public void queryApiInfoTest() {
        ApiInfoRequest request = new ApiInfoRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setPageNo(11);
        request.setPageSize(11);
        ApiInfoResponse response = apiInfoBusiSV.queryApiInfo(request);
        System.out.println(response.getResponseHeader());
        System.out.println("***************************************");
        System.out.println(response.getPageInfo().getResult().size());
    }

}
