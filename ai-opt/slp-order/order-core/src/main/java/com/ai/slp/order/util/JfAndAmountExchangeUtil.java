package com.ai.slp.order.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.ai.opt.sdk.util.ParseO2pDataUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.order.constants.OrdersConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 获取积分与人民币的兑换比例 (已废弃)
 * @date 2016年10月17日 
 * @author caofz
 */
public class JfAndAmountExchangeUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(ChUserUtil.class);
	//获取用户信息
	public static String getRate(String accountId){
		 Map<String,String> params=new HashMap<String,String>();
		   params.put("accountId", accountId);
	       String param=JSON.toJSONString(params);
	       Map<String,String> mapHeader = new HashMap<String,String>();
	       mapHeader.put("appkey", OrdersConstants.OFC_APPKEY);
	       mapHeader.put("sign", OrdersConstants.OFC_SIGN);
	       String result ="";
	       Object rate=null;
			try {
				result = HttpClientUtil.sendPost(OrdersConstants.INTEGRAL_RATE_URL, param,mapHeader);
				JSONObject object = ParseO2pDataUtil.getData(result);
				Object obj = object.get("resultCode");
				if(obj!=null) {
					return null;
				}
				rate = object.get("rate");
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("请求出现错误!");
			}
			return rate==null?null:rate.toString();
	}
	
	public static void main(String[] args) {
		String rate = getRate("jfat1.201609256101549914_0001");
		if(!StringUtil.isBlank(rate)) {
			String[] split = rate.split(":");
			String s = split[0];
			String s1 = split[1];
			BigDecimal JfAmout=BigDecimal.valueOf(983).divide(new BigDecimal(s),5,BigDecimal.ROUND_HALF_UP);
			System.out.println(JfAmout.divide(new BigDecimal(s1),2,BigDecimal.ROUND_HALF_UP));
		}
	}
}
