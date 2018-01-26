package com.ai.slp.user.api.safari.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.safari.param.DeleteSafariRequest;
import com.ai.slp.user.api.safari.param.InsertUserSafariRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoResponse;
import com.ai.slp.user.service.business.interfaces.IUserSafariBusiSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UserSafariSVImplTest {

    @Autowired
    private IUserSafariBusiSV userSafariBusiSV;

    // @Test
    public void insertSafariTest() {
        InsertUserSafariRequest request = new InsertUserSafariRequest();
        request.setUserId("111");
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        request.setProdId("333");
        System.out.println(userSafariBusiSV.insertUserSafari(request).getResponseHeader());
    }

    @Test
    public void querySafariTest() {
        UserSafariInfoRequest request = new UserSafariInfoRequest();
        request.setPageNo(11);
        request.setPageSize(11);
        // request.setSafariTime(DateUtils.currTimeStamp());
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        request.setUserId("111");
        UserSafariInfoResponse response = userSafariBusiSV.queryUserSafari(request);
        System.out.println(response.getPageInfo().getCount());
    }

    //@Test
    public void deleteSafariTest() {
        DeleteSafariRequest request = new DeleteSafariRequest();
        request.setUserId("111");
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        // request.setProdId("333");
        // request.setDateTime("2016-4-27");
        request.setDeleteCode("1");
        userSafariBusiSV.deleteUserSafari(request);
    }
}
