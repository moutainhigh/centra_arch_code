package com.ifudata.ums.service.http.byd.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.service.http.byd.constant.BYDConstant;
import com.ifudata.ums.util.DateUtils;

public class BYDClient extends SMAbstractClient {

	private static final Log log = LogFactory.getLog(BYDClient.class);
	private static final Map<String, Object> tempResultMap = new HashMap<String, Object>();

	private static int nWillSendNum = 0;

	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {
		Map<String, Object> status = new HashMap<String, Object>();

		nWillSendNum = status.size();

		try {
			// msgId通过程序生成
			String msgId = genMsgId();
			status.put("msgId", msgId);
			log.debug("********** byd writeMessage 方法状态 :  **********");
			// 实例化HttpClient对象
			HttpClient client = new HttpClient();
			// PostMethod对象用于存放地址
			PostMethod post = new PostMethod(BYDConstant.GETMT_URL);
			// 在头文件中设置转码
			post.addRequestHeader("Content-Type", BYDConstant.CONTENT_TYPE);

			NameValuePair cmd = new NameValuePair("cmd", BYDConstant.C_BYD_SMS_GETMT);
			NameValuePair uid = new NameValuePair("uid", BYDConstant.UID);
			NameValuePair psw = new NameValuePair("psw", BYDConstant.PSW);
			NameValuePair mobiles = new NameValuePair("mobiles", userNumber);
			NameValuePair _msgId = new NameValuePair("msgid", msgId);
			NameValuePair msg = new NameValuePair("msg", content);
			NameValuePair msgformat = new NameValuePair("msgformat", BYDConstant.MSGFORMAT);

			post.setRequestBody(new NameValuePair[] { cmd, uid, psw, mobiles, _msgId, msg, msgformat });
			// 执行的状态
			int excuteStatus = client.executeMethod(post);
			log.debug("********** HttpClient执行post方法状态 : " + excuteStatus + " **********");
			// 返回的数字，对应着不同的情况
			String responseBody = post.getResponseBodyAsString();
			// 关闭连接
			post.releaseConnection();
			log.debug("********** responseBody : " + responseBody + " **********");
			String strres = parseString4MSGResult(responseBody);
			status.put(Constant.RESULT_CODE, strres);
			status.put(Constant.RESULT_CONTENT, responseBody);
			if (!strres.equals("100")) {
				log.error("********** send sms failed : " + strres + " " + BYDConstant.mapErr.get(strres)
						+ " **********");
			}
		} catch (Exception e) {
			log.debug("**********write message 过程发生异常**********", e);
		}
		return status;
	}

	private String genMsgId() {
		// 时间+随机数
		Random r = new Random(100);
		int n4 = r.nextInt(100);
		System.out.println("random:" + n4);
		return (DateUtils.format(new Date(), "yyyyMMddHHmmssSSS") + String.format("%02d", n4));
	}

	// 判断下行短信是否发送成功
	public static String parseString4MSGResult(String source) {
		String result = "";
		if (source == null || source.length() < 3)
			return result;
		result = source.substring(0, 3);
		return result;
	}

	@Override
	public Map<String, Object> readMessage() {
		if (isFirstRead) {
			new Thread(new ReadTask()).start();
			isFirstRead = false;
		}

		Map<String, Object> recMap = new HashMap<String, Object>();
		if (BYDClient.tempResultMap != null && BYDClient.tempResultMap.size() > 0) {

			//String strkey = (String) BYDClient.tempResultMap.get("byd");
			String result = (String) BYDClient.tempResultMap.get("result");
			List<Map<String, Object>> bydList = new ArrayList<>();

			String strarr[] = result.split(BYDConstant.LINE_SPILT);
			try {
				// 获取document对象
				for (int iloop = 0; iloop < strarr.length; iloop++) {
					String str = strarr[iloop];
					// 将信息添加进map容器中
					String strarr1[] = str.split(BYDConstant.CONTENT_SPILT);
					if (strarr1.length == 3) {
						Map<String, Object> detailMap = new HashMap<>();
						detailMap.put(Constant.SEQUENCE_NUM, strarr1[0]);
						detailMap.put(Constant.RESULT_CODE, strarr1[2]);
						detailMap.put(Constant.RESULT_CONTENT, strarr1[1]);
						bydList.add(detailMap);
					}
				}

				if (bydList.size() > 0) {
					recMap.put("byd", strarr[0]);
					recMap.put("details", bydList);
					log.debug("********** 状态报告接口返回结果:" + bydList + " **********");
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("********** 状态报告接口返回结果:" + result + System.getProperty("line.separater") + " **********");
			}
		}

		return recMap;
	}

	private class ReadTask implements Runnable {

		@Override
		public void run() {
			// 接收线程
			while (true) {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("Error:", e);
				}
				// 1. 先取是否发完
				// if (GetNum() != nWillSendNum)
				// {
				// continue;
				// }

				// 2. 接收report
				int excuteStatus;
				InputStream is = null;
				// 实例化HttpClient对象
				HttpClient client = new HttpClient();
				// PostMethod对象用于存放地址
				PostMethod post = new PostMethod(BYDConstant.GETNUM_URL);
				// NameValuePair数组对象用于传入参数
				post.addRequestHeader("Content-Type", BYDConstant.CONTENT_TYPE);// 在头文件中设置转码

				NameValuePair cmd = new NameValuePair("cmd", BYDConstant.C_BYD_SMS_GETSTATUS);
				NameValuePair uid = new NameValuePair("uid", BYDConstant.UID);
				NameValuePair psw = new NameValuePair("psw", BYDConstant.PSW);
				post.setRequestBody(new NameValuePair[] { cmd, uid, psw });
				try {
					excuteStatus = client.executeMethod(post);
					log.debug("********** HttpClient执行post方法状态  GETSTATUS: " + excuteStatus + " **********");
					// 返回的数字，对应着不同的情况
					is = post.getResponseBodyAsStream();
					// 根据返回的xml内容判断是否要进行解析
					String result = BYDClient.fromStream2String(is, "UTF-8");
					log.debug(
							"********** 此次状态报告返回结果为：" + result + System.getProperty("line.separator") + " **********");
					if (result == null || result.length() < 3) {
						continue;
					}

					String strres = parseString4MSGResult(result);
					// 取返回值错 循环!
					if (!strres.equals(BYDConstant.C_BYD_SMSRESPONE_SUCCESS)) {
						continue;
					}

					String strarr[] = result.split(BYDConstant.LINE_SPILT);
					String strresult = "";
					for (int iloop = 1; iloop < strarr.length; iloop++) {
						if (strresult.equals(""))
							strresult = strarr[iloop];
						else
							strresult = strresult + BYDConstant.LINE_SPILT + strarr[iloop];
					}
					if (!strresult.equals("")) {
						BYDClient.tempResultMap.put("byd", strres);
						BYDClient.tempResultMap.put("result", strresult);
					} else
						continue;
					// result =
					// StringUtils.CheckUnicodeStringAndReplcace(result, ' ');
					// Map<String, String> map =
					// BYDClient.this.parseString4ReportResult(result);
					// BYDClient.tempResultMap.putAll(map);
				} catch (Exception e) {
					log.error("读取数量过程发生异常 ", e);
				} finally {
					try {
						if (is != null) {
							is.close();
						}
					} catch (IOException e) {
						log.error("Error :", e);
					}
					if (post != null) {
						// 关闭连接
						post.releaseConnection();
					}
				}
			}
		}
	}

	// 把http响应数据流转成string
	public static String fromStream2String(InputStream is, String encode) {
		if (is == null)
			return null;
		StringBuilder sb = new StringBuilder("");
		try {
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line + BYDConstant.LINE_SPILT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// 解析状态报告
	public static Map<String, String> parseString4ReportResult(String responseBody) {
		// 判断传递参数
		if (responseBody == null)
			return null;

		// 第一行是返回值
		String strarr[] = responseBody.split(BYDConstant.LINE_SPILT);

		Map<String, String> map = new HashMap<String, String>();
		try {
			// 获取document对象
			for (int iloop = 1; iloop < strarr.length; iloop++) {
				String str = strarr[iloop];
				// 将信息添加进map容器中
				String strarr1[] = str.split(BYDConstant.CONTENT_SPILT);
				if (strarr1.length == 3)
					map.put(strarr1[0], strarr1[1] + BYDConstant.CONTENT_SPILT + strarr1[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater") + " **********");
		}
		return map;
	}

	// 获取发送数量
	@SuppressWarnings("unused")
	private int GetNum() {
		int nres = -1;
		// 实例化HttpClient对象
		HttpClient clientnum = new HttpClient();
		// PostMethod对象用于存放地址
		PostMethod postnum = new PostMethod(BYDConstant.GETNUM_URL);
		// NameValuePair数组对象用于传入参数
		postnum.addRequestHeader("Content-Type", BYDConstant.CONTENT_TYPE);// 在头文件中设置转码

		NameValuePair cmd = new NameValuePair("cmd", BYDConstant.C_BYD_SMS_GETNUM);
		NameValuePair uid = new NameValuePair("uid", BYDConstant.UID);
		NameValuePair psw = new NameValuePair("psw", BYDConstant.PSW);
		postnum.setRequestBody(new NameValuePair[] { cmd, uid, psw });
		// 执行的状态
		int excuteStatus;
		InputStream is = null;
		try {
			excuteStatus = clientnum.executeMethod(postnum);
			log.debug("********** HttpClient执行post方法状态  GETNUM: " + excuteStatus + " **********");
			// 返回的数字，对应着不同的情况
			is = postnum.getResponseBodyAsStream();
			// 根据返回的xml内容判断是否要进行解析
			String result = BYDClient.fromStream2String(is, "UTF-8");
			log.debug("********** 此次状态报告返回结果为：" + result + System.getProperty("line.separator") + " **********");
			if (result == null || result.length() < 3) {
				return nres;
			}

			// 取数量错 循环!
			if (result.substring(1, 3).equals(BYDConstant.C_BYD_SMSRESPONE_FAILED)) {
				log.error("读取数量过程错误 ");
				return nres;
			}

			String str = result.substring(4);
			String[] arrstr = str.split(BYDConstant.CONTENT_SPILT);
			if (arrstr.length != 2) {
				log.error("读取数量过程错误 ");
				return nres;
			}

			if (Integer.parseInt(arrstr[0]) != Integer.parseInt(arrstr[1])) {
				log.info("已发送条数 :" + arrstr[0] + "应发送条数:" + nWillSendNum);
				return nres;
			}

			nres = Integer.parseInt(arrstr[0]);
		} catch (Exception e) {
			log.error("读取数量过程发生异常 ", e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				log.error("Error ", e);
			}
			if (postnum != null) {
				// 关闭连接
				postnum.releaseConnection();
			}
		}

		return nres;
	}
}
