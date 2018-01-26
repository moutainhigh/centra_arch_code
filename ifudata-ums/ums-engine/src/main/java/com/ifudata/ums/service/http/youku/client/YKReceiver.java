/*************************************************  

* @Title: YkReceiver.java 

* @Package com.ifudata.service.http.youku.client

* @Description: TODO(用一句话描述该文件做什么) 

* @author lvsj  

* @date 2015年6月5日 下午5:46:30 

* @version V1.0  

**************************************************/

package com.ifudata.ums.service.http.youku.client;

import java.util.Map;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.core.SMReceiver;
import com.ifudata.ums.service.http.youku.constant.SmsJsonConstant;

/** 

 * @ClassName: YkReceiver 

 * @Description: TODO(这里用一句话描述这个类的作用) 

 * @author：lvsj

 * @date 2015年6月5日 下午5:46:30 

 * 
 

 */
public class YKReceiver extends SMReceiver {
	
	public YKReceiver(SMAbstractClient smClient) {
		super(smClient);
	}
	protected  boolean isRecSuccess(Map<String, Object> recMap)
	{
		return recMap.get(Constant.RESULT_CODE) != null && ((String)recMap.get(Constant.RESULT_CODE)).startsWith(SmsJsonConstant.Success) ? true : false;
	}
}
