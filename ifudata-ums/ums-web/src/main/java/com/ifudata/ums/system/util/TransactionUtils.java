/*
package com.ifudata.ums.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifudata.crm.system.config.ConstantsResultCode;
import com.ifudata.crm.system.util.DateUtil;
import com.ifudata.ums.crm.api.base.vo.RequestHeader;
import com.ifudata.ums.crm.api.commons.crmserial.interfaces.ICrmSerialDubboSV;
import com.ifudata.ums.crm.api.commons.crmserial.param.CrmSerialRequest;
import com.ifudata.ums.crm.api.commons.crmserial.param.CrmSerialResponse;

@Component
public class TransactionUtils {
	
	private static ICrmSerialDubboSV crmSerialDubboSV;
	
    public static String getTransactionID(String appKey){
    	CrmSerialRequest request=new CrmSerialRequest();
        request.setRequestHeader(buildRequestHeader());
        
        CrmSerialResponse response=crmSerialDubboSV.getCrmSerialNum(request);
        String onlyNum;
        if(ConstantsResultCode.SUCCESS.equals(response.getResponse().getResultCode())){
            onlyNum=response.getCrmSerialNum();
        }else{
            throw new RuntimeException("获取流水号失败:"+response.getResponse().getResultMessage());
        }
        return appKey+DateUtil.getNowDate()+onlyNum;
    }

	private static RequestHeader buildRequestHeader() {
		RequestHeader header=new RequestHeader();
    	
    	header.setApplyChlId("1000001");
        header.setCityCode("000");
        header.setFromType("1");
        header.setProvinceCode("09");
        header.setOperId(1000001l);
        
        return header;
	}
	
	@Autowired(required = true)
	public void setIuamSign(ICrmSerialDubboSV crmSerialDubboSV) {
		TransactionUtils.crmSerialDubboSV = crmSerialDubboSV;
	}
    
}
*/
