/*************************************************  

* @Title: PackOut.java 

* @Package com.ifudata.service.ucool.msgdown

* @Description: TODO(用一句话描述该文件做什么) 

* @author lvsj  

* @date 2015年6月1日 下午2:52:05 

* @version V1.0  

**************************************************/

package com.ifudata.ums.service.http.youku;

import java.net.URLEncoder;
import java.util.Map;

import com.ifudata.ums.service.http.youku.constant.SmsJsonConstant;
import org.json.JSONObject;
import com.ifudata.ums.service.http.youku.interf.MsgData;
import com.ifudata.ums.service.http.youku.util.jsonutil;

/** 

 * @ClassName: PackOut 

 * @Description: 下行短信发送信息报文内容

 * @author：lvsj

 * @date 2015年6月1日 下午2:52:05 

 * 
 

 */

public class PackOut implements MsgData {
	//交易流水
	private String transId = "ceshi20150508133201123456";
	//交易时间
	private String transTime = "20150508133201";
	//电话号码
	private String phoneNumber = "13810894515";
	//短信内容
	private String smsContent = "A23456789012345678901234567890123456789012345678901234567890B2345678901";
	//业务来源
	private String resource = "MVON";
	//签名
	private String sign = "451681037b4a7a9dd0167c00722f10da";
	
	public PackOut(String phoneNbr,String conTent)
	{
		super();
		this.transId = SmsJsonConstant.resource + jsonutil.getDate() + jsonutil.seqstr();
		this.transTime = jsonutil.getTime();
		this.phoneNumber = phoneNbr;
		this.resource = SmsJsonConstant.resource;
		this.smsContent = conTent;
		this.GenerateSign();
		
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
	
	* @return phoneNumber 
	
	*/ 
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/** 
	
	* @param phoneNumber 要设置的 phoneNumber 
	
	*/ 
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/** 
	
	* @return smsContent 
	
	*/ 
	public String getSmsContent() {
		return smsContent;
	}

	/** 
	
	* @param smsContent 要设置的 smsContent 
	
	*/ 
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	/** 
	
	* @return resource 
	
	*/ 
	public String getResource() {
		return resource;
	}

	/** 
	
	* @param resource 要设置的 resource 
	
	*/ 
	public void setResource(String resource) {
		this.resource = resource;
	}

	/** 
	
	* @return sign 
	
	*/ 
	public String getSign() {
		return sign;
	}

	/** 
	
	* @param sign 要设置的 sign 
	
	*/ 
	public void setSign(String sign) {
		this.sign = sign;
	}

	/* (非 Javadoc) 
	
	 * <p>Title: getMsgData</p> 
	
	 * <p>Description: </p> 
	
	 * @return 
	
	 * @see com.ifudata.service.ucool.interf.MsgData#getMsgData()
	
	 */
	@Override
	public JSONObject getMsgData() {
		JSONObject obj = new JSONObject();
	
		obj.put("transId", this.transId);
		obj.put("transTime", this.transTime);
		obj.put("phoneNumber", this.phoneNumber);
		obj.put("smsContent", this.EncodeTxt());
		obj.put("resource", this.resource);
		obj.put("sign", this.sign);
		return obj;
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
		return null;
	}
	
	/** 
	
	* @Title: GenerateSign 
	
	* @Description: 根据短信内容生成签名
	* 生成签名时需要把短信内容强行转换字符集UTF-8
	
	* @param     设定文件 
	
	* @return void    返回类型 
	
	* @throws 
	
	*/
	private void GenerateSign()
	{
		String buff;
		try
		{
			buff =	"transId"+ this.transId;
			buff +=	"transTime"+ this.transTime;
			buff +=	"phoneNumber"+ this.phoneNumber;		
			buff +=	"smsContent"+ this.EncodeTxt();		
			buff +=	"resource"+ this.resource;	
			buff +=	"ykfm_sign_key" + SmsJsonConstant.sighkey;
			this.sign = jsonutil.getMD5(buff);
		}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
		
	}
	private String EncodeTxt()
	{
		String buff = "";
		try
		{
			buff = URLEncoder.encode(this.smsContent, "utf-8");
		}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
		return buff;
	}
	public static void main(String[] args) {
		PackOut msg = new PackOut("18618387298","你好");
		String sb = "";
		if (msg.getMsgData().has("sign"))
			sb = msg.getMsgData().getString("sign");
		
		System.out.println(msg.getMsgData().toString());
		System.out.println(sb);
		
	}
}
