package com.ai.slp.order.api.ordermodify.impl;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.orderpricemodify.interfaces.INotPaidOrderModifySV;
import com.ai.slp.order.api.orderpricemodify.param.OrderModifyRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/context/core-context.xml" })
public class NotPaidOrderModifySVImplTest {
	
	@Autowired
	INotPaidOrderModifySV notPaidOrderModifySV;

	@Test
	public void test() {
        OrderModifyRequest request=new OrderModifyRequest();
        request.setOrderId(2000034374759095l);
		request.setUpdateAmount(3000l);
		request.setTenantId("changhong");
		request.setOperId("1212");
		request.setUpdateRemark("测试.....");
		System.out.println(JSON.toJSONString(request));
		BaseResponse response = notPaidOrderModifySV.modify(request);
		System.out.println(response);
	}
}
