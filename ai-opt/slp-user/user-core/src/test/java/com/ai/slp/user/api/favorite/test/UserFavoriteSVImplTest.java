package com.ai.slp.user.api.favorite.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.favorite.interfaces.IUserFavoriteSV;
import com.ai.slp.user.api.favorite.param.DeleteFavoriteListRequest;
import com.ai.slp.user.api.favorite.param.InsertUserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UpdateFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteResponse;
import com.ai.slp.user.api.login.test.LoginSVImplTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UserFavoriteSVImplTest {

    private static final Log LOG = LogFactory.getLog(LoginSVImplTest.class);

    @Autowired
    private IUserFavoriteSV userFavoriteSV;

    @Test
    public void createUserFavoriteTest() {
        InsertUserFavoriteRequest request = new InsertUserFavoriteRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setTenantPwd("123456");
        request.setFavoriteType("01");
        request.setFavoriteRelId("1234");
        request.setFavoriteReqId("222222");
        System.out.println(userFavoriteSV.insertUcFavorite(request).getResponseHeader());
    }

    // @Test
    public void updateUserFavoriteTest() {
        UpdateFavoriteRequest request = new UpdateFavoriteRequest();
        request.setUserId("111");
        request.setTenantId("test111");
        request.setTenantPwd("123456");

        List<String> list = new ArrayList<String>();
        list.add("111111");
        list.add("222222");
        request.setFavoriteList(list);
        LOG.info("开始更新了");
        userFavoriteSV.cancelFavorite(request);
    }

    // @Test
    public void deleteFavoriteSVImplTest() {
        DeleteFavoriteListRequest request = new DeleteFavoriteListRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setTenantPwd("123456");
        List<String> list = new ArrayList<String>();
        list.add("111111");
        list.add("223333");

        request.setFavoriteReqIdList(list);
        userFavoriteSV.deleteFavorite(request);
    }

    // @Test
    public void queryFavoriteSVImplTest() {
        UserFavoriteRequest request = new UserFavoriteRequest();
        request.setTenantId("test111");
        request.setTenantPwd("123456");
        request.setUserId("111");
        // request.setFavoriteSeqId("223333");
        request.setPageNo(11);
        request.setPageSize(11);
        ;
        UserFavoriteResponse response = userFavoriteSV.queryFavorite(request);
        System.out.println(response.getPageInfo().getPageCount());
    }
}
