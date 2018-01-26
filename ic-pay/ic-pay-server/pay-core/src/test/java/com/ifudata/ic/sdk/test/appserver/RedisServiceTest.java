package com.ifudata.ic.sdk.test.appserver;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifudata.ic.pay.api.tenantinfoquery.impl.TenantInfoQuerySVImpl;
import com.ifudata.ic.pay.api.tenantinfoquery.param.TenantInfoParam;
import com.ifudata.ic.pay.api.terminalorgrelquery.impl.TerminalOrgRelQuerySVImpl;
import com.ifudata.ic.pay.api.terminalorgrelquery.param.TerminalOrgRelQryParam;
import com.ifudata.ic.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.ic.pay.cache.PayTenantInfoCache;
import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRel;
import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRelCriteria;
import com.ifudata.ic.pay.dao.mapper.factory.MapperFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context/core-context.xml"})
public class RedisServiceTest {
	
	@Test
	public void tess01() throws Exception {
		
		RedisServiceTest redisServiceTest = new RedisServiceTest();
		PayTenantInfoCache payTenantInfoCache =new PayTenantInfoCache();
		//payTenantInfoCache.write();
		System.out.println("-----");
		redisServiceTest.testGet();
		
	}
	@Test
	public void tess(){
		
		List<PayTerminalOrgRel> payTerminalOrgRelList = MapperFactory.getChgTerminalOrgRelMapper()
                .selectByExample(new PayTerminalOrgRelCriteria());
		System.out.println("---");
		System.out.println(payTerminalOrgRelList.toString());

		
	}
	
	public void testGet(){
		
		TenantInfoParam param = new TenantInfoParam();
        param.setTenantId("54234");
        TenantInfoQuerySVImpl tenantInfoQuerySV = new TenantInfoQuerySVImpl();
        String partnerId = tenantInfoQuerySV.getPartnerId(param);   
        System.out.println("返回的合作方编码：" + partnerId);
		
	}
	public void testSet(){
		
		TerminalOrgRelQryParam qryParam = new TerminalOrgRelQryParam();
        qryParam.setTenantId("BIS-ST");
        qryParam.setRequestSource("1");
        TerminalOrgRelQuerySVImpl terminalOrgRelQuerySV = new TerminalOrgRelQuerySVImpl();
        List<TerminalOrgRelVo> relVoList = terminalOrgRelQuerySV.queryTerminalOrgRels(qryParam);
        for (TerminalOrgRelVo terminalOrgRelVo : relVoList) {
			System.out.println(terminalOrgRelVo.toString());
		}
        
        
	}
	
	
	

}
