package com.ai.slp.user.api.statechg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.user.api.ucStateChg.interfaces.IUcStateChgSV;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgRequest;
import com.ai.slp.user.api.ucStateChg.param.UcStateChgParamsRequest;
import com.ai.slp.user.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UcStateChgSVImplTest {

    @Autowired
    private IUcStateChgSV ucStateChgSV;

    //@Test
    public void insertStateChg() {
        UcStateChgParamsRequest request = new UcStateChgParamsRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        //request.setStateChgId("111");
        //request.setChgTime(DateUtils.currTimeStamp());
        ucStateChgSV.insertUcStateChgInfo(request);
    }

    // @Test
    public void updateStateChg() {
        UcStateChgParamsRequest request = new UcStateChgParamsRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        //request.setStateChgId("111");
        //request.setChgTime(DateUtils.currTimeStamp());
        ucStateChgSV.updateUcStateChgInfo(request);
    }

    @Test
    public void queryStateChg() {
        QueryStateChgRequest request = new QueryStateChgRequest();
        request.setTenantId("test111");
        request.setUserId("111");
        request.setStateChgId("111");
        System.out.println(ucStateChgSV.queryStateChg(request).getTenantId());
    }
}
