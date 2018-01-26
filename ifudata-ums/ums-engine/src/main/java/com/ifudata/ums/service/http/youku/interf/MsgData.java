/*************************************************  

* @Title: MsgData.java 

* @Package com.ifudata.service.ucool.interf

* @Description: TODO(用一句话描述该文件做什么) 

* @author lvsj  

* @date 2015年6月1日 下午2:33:03 

* @version V1.0  

**************************************************/

package com.ifudata.ums.service.http.youku.interf;

import java.util.Map;
import org.json.JSONObject;
/** 

 * @ClassName: MsgData 

 * @Description: TODO(这里用一句话描述这个类的作用) 

 * @author：lvsj

 * @date 2015年6月1日 下午2:33:03 

 * 
 

 */
 
public interface MsgData {
	public JSONObject getMsgData();
	public Map<String, String> getMsgData(JSONObject obj);
}
