/*************************************************  

* @Title: PackIn.java 

* @Package com.ifudata.service.ucool.msgdown

* @Description: TODO(用一句话描述该文件做什么) 

* @author lvsj  

* @date 2015年6月1日 下午2:53:07 

* @version V1.0  

**************************************************/

package com.ifudata.ums.service.http.youku;

import java.util.Map;

import com.ifudata.ums.service.http.youku.interf.MsgData;
import org.json.JSONObject;

/** 

 * @ClassName: PackIn 

 * @Description: TODO(这里用一句话描述这个类的作用) 

 * @author：lvsj

 * @date 2015年6月1日 下午2:53:07 

 * 
 
 */
public class PackIn implements MsgData {
	//交易流水
	private String transId = "";
	//交易时间
	private String transTime = "";
	//0为成功，-1失败
	private String returnCode = "";
	//返回结果信息描述
	private String returnMessage = "";
	private JSONObject jsonobj = null;
	public PackIn(JSONObject obj)
	{
		super();
		this.jsonobj = obj;
		if (obj.has("transId"))
			this.transId = obj.getString("transId");
		if (obj.has("transTime"))
			this.transId = obj.getString("transTime");
		if (obj.has("returnMessage"))
			this.transId = obj.getString("returnMessage");		
		if (obj.has("returnCode"))
			this.transId = obj.getString("returnCode");			
	}
	public PackIn(String sb)
	{
		
		JSONObject obj = new JSONObject(sb);
		this.jsonobj = obj;
		if (obj.has("transId"))
			this.transId = obj.getString("transId");
		if (obj.has("transTime"))
			this.transTime = obj.getString("transTime");
		if (obj.has("returnMessage"))
			this.returnMessage = obj.getString("returnMessage");		
		if (obj.has("returnCode"))
			this.returnCode = obj.getString("returnCode");	
	}	
	/** 
	
	* @return transId 
	
	*/ 
	public String getTransId() {
		return transId;
	}

	/** 
	
	* @param transId 要设置的 transId 
	
	*/ 
	public void setTransId(String transId) {
		this.transId = transId;
	}

	/** 
	
	* @return transTime 
	
	*/ 
	public String getTransTime() {
		return transTime;
	}

	/** 
	
	* @param transTime 要设置的 transTime 
	
	*/ 
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	/** 
	
	* @return returnCode 
	
	*/ 
	public String getReturnCode() {
		return returnCode;
	}

	/** 
	
	* @param returnCode 要设置的 returnCode 
	
	*/ 
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/** 
	
	* @return returnMessage 
	
	*/ 
	public String getReturnMessage() {
		return returnMessage;
	}

	/** 
	
	* @param returnMessage 要设置的 returnMessage 
	
	*/ 
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	/* (非 Javadoc) 
	
	 * <p>Title: getMsgData</p> 
	
	 * <p>Description: </p> 
	
	 * @return 
	
	 * @see com.ifudata.service.ucool.interf.MsgData#getMsgData()
	
	 */
	@Override
	public JSONObject getMsgData() {
		// TODO Auto-generated method stub
		return this.jsonobj;
	}

	/* (非 Javadoc) 
	
	 * <p>Title: getMsgData</p> 
	
	 * <p>Description: </p> 
	
	 * @param obj
	 * @return 
	
	 * @see com.ifudata.service.ucool.interf.MsgData#getMsgData(net.sf.json.JSONObject)
	
	 */
	@Override
	public Map<String, String> getMsgData(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		PackIn msg = new PackIn("{\"transId\": \"ceshi20150508133201123456 \",\"transTime\": \"20150508133201 \",\"returnMessage\": \"成功\",\"returnCode\": \"0\"}");
		String sb = "";
		PackIn msg1 = null;
		msg1 = msg;
		msg1.getMsgData().toString();
		
		System.out.println("msg1="+msg1.getTransId());
		System.out.println("msg="+msg.getTransId());		
		System.out.println("msg="+msg.getMsgData().toString());
		System.out.println(sb);
		
	}

}
