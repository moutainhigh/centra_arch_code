package com.ai.slp.mall.web.test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.dubbo.extension.DubboRestResponse;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.ai.slp.order.api.orderlist.interfaces.IOrderListSV;
import com.ai.slp.order.api.orderlist.param.OrdOrderVo;
import com.ai.slp.order.api.orderlist.param.QueryOrderRequest;
import com.ai.slp.order.api.orderlist.param.QueryOrderResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:dubbo/applicationContext-dubbo-service-consumer.xml" })
public class Testrest {

	@Autowired
    protected ApplicationContext ctx;

    public <T> T getBean(Class<T> type) {
        return ctx.getBean(type);
    }

    public Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }
    
  /*  @Autowired
    private IOrderListSV orderListSV;*/
/*    @Autowired
    private IDemoSV demoSV;*/
    

    @Test
    public void orderListTestByDubbo() {
    	IOrderListSV orderListSV=DubboConsumerFactory.getService(IOrderListSV.class);
    	QueryOrderRequest request = new QueryOrderRequest();
        request.setOrderId(78436478);
        request.setTenantId("SLP");
        QueryOrderResponse queryOrder = orderListSV.queryOrder(request);
        OrdOrderVo ordOrderVo = queryOrder.getOrdOrderVo();
        System.out.println("param="+JSON.toJSONString(request));
        System.out.println("result="+JSON.toJSONString(ordOrderVo));
    }
    
    @Test
    public void orderListTestByRest() {
    	QueryOrderRequest request = new QueryOrderRequest();
        request.setOrderId(78436478);
        request.setTenantId("SLP");
        String url="http://10.1.245.9:10887/slp-order/orderlist/queryOrder";
        String param=JSON.toJSONString(request);
        String result=HttpClientUtil.sendPost(url, param);
        System.out.println("param="+JSON.toJSONString(request));
        System.out.println("result="+result);
        
        //===============反序列化JSON字符串 开始==========================
        JSONObject resp =JSON.parseObject(result, JSONObject.class);        
        Object data=resp.get("data");
        System.out.println("data="+data);
        JSONObject dataJson =JSON.parseObject(data.toString(), JSONObject.class);
        JSONObject orderData=dataJson.getJSONObject("ordOrderVo");
        System.out.println("rest orderData="+JSON.toJSONString(orderData));
        //===============反序列化JSON字符串 结束==========================
    }
    
    
    /*@Test
    public void demotest() {
//    	IDemoSV orderListSV=(IDemoSV) ctx.getBean(IDemoSV.class);
    	System.out.println(demoSV.hello("world"));
    }*/
    
    
}
