package com.ai.slp.order.api.orderrefund.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.order.api.orderrefund.interfaces.IOrderRefundSV;
import com.ai.slp.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.slp.order.api.orderrefund.param.OrderRefuseRefundRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderRefundSVImplTest {
	
	@Autowired
	private IOrderRefundSV orderRefundSV;
	
	@Test
	public void testPartRefund() {
		OrderRefundRequest request=new OrderRefundRequest();
		request.setOperId("1111");
		request.setOrderId(2000034411596752l);
		request.setTenantId("changhong");
		request.setUpdateMoney(150l);
		request.setUpdateReason("商品吊牌拆毁");
		System.out.println(JSON.toJSONString(request));
		orderRefundSV.partRefund(request);
	}
	
	@Test
	public void testRefuseRefund() {
		OrderRefuseRefundRequest request=new OrderRefuseRefundRequest();
		request.setOperId("1111");
		request.setOrderId(2000034401233849l);
		request.setTenantId("changhong");
		request.setRefuseReason("商品损害");
		System.out.println(JSON.toJSONString(request));
		orderRefundSV.refuseRefund(request);
	}

}
