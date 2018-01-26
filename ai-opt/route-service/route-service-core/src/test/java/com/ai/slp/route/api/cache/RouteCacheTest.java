package com.ai.slp.route.api.cache;

import com.ai.slp.route.service.business.interfaces.IRouteCache;
import com.ai.slp.route.util.CacheKeyUtil;
import com.ai.slp.route.util.MCSUtil;
import com.ai.slp.route.vo.*;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by xin on 16-5-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class RouteCacheTest {
    @Autowired
    private IRouteCache routeCacheA;
    @Test
    public void testRefreshAllCache() throws SQLException, ParseException {
        routeCacheA.refreshAllCache("SLP-001");
        String value = MCSUtil.hLoad(CacheKeyUtil.RK_Route("ROUTE-001"), "RT-RULE-001");
        RuleBaseInfo ruleBaseInfo = new Gson().fromJson(value, RuleBaseInfo.class);
        assertEquals(ruleBaseInfo.getMaxQuantity(), 100D, 0);
        assertEquals(ruleBaseInfo.getMinQuantity(), -1D, 0);
        assertEquals(ruleBaseInfo.getRuleItem(), RuleItem.ORDERCOUNT);
        assertEquals(ruleBaseInfo.getCycleUnit(), CycleUnit.DAY);
        assertEquals(ruleBaseInfo.getCycleValue(), 3);
        assertEquals(ruleBaseInfo.getTimeType(), TimeType.CYCLE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals(ruleBaseInfo.getValidateTime(), new Timestamp(simpleDateFormat.parse("2016-04-27 00:00:00").getTime()));
        assertEquals(ruleBaseInfo.getInvalidateTime(), new Timestamp(simpleDateFormat.parse("2016-05-05 23:59:59").getTime()));
    }

    @Test
    public void refreshTenantCache() throws SQLException {
        routeCacheA.refreshAllCache("SLP");
    }

    @Test
    public void refreshGroupCache()throws SQLException{
        routeCacheA.refreshRouteGroup("5000000001");
    }

    @Test
    public void refreshRouteTest(){
        routeCacheA.refreshRoute("8000000001");
//        routeCacheA.refreshRoute("900000002");
//        routeCacheA.refreshRoute("900000003");
    }

    @Test
    public void refreshRuleTest(){
        routeCacheA.refreshRule("9000002");
//        routeCacheA.refreshRule("9000003");
    }


    @Test
    public void testGson() {
        String value = new Gson().toJson(Route.RouteStatus.INVALIDATE);
        System.out.println(value);
        assertEquals(Route.RouteStatus.INVALIDATE, new Gson().fromJson(value, Route.RouteStatus.class));
    }
}
