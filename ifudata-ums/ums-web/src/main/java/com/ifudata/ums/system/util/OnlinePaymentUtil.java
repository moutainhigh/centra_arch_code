package com.ifudata.ums.system.util;//package com.ifudata.crm.system.util;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.security.cert.Certificate;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.Signature;
//import java.security.cert.CertificateFactory;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.log4j.Logger;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//
///**
// * 在线支付工具类、参数，ff
// * 
// * Title: ums-SP <br>
// * Description: <br>
// * Date:2014年3月27日 上午11:03:26 <br>
// * Copyright (c) 2014 ifudata <br>
// * 
// * @author zhangkq
// */
//public class OnlinePaymentUtil {
//	private static Logger logger = Logger.getLogger(OnlinePaymentUtil.class);
//	
//	
///***  1、  ********************    银联 在线支付       **********************************************/
//		//组装消费请求包
//		public final static String[] reqVo = new String[]{
//				"version",
//	            "charset",
//	            "transType",
//	            "origQid",
//	            "merId",
//	            "merAbbr",
//	            "acqCode",
//	            "merCode",
//	            "commodityUrl",
//	            "commodityName",
//	            "commodityUnitPrice",
//	            "commodityQuantity",
//	            "commodityDiscount",
//	            "transferFee",
//	            "orderNumber",
//	            "orderAmount",
//	            "orderCurrency",
//	            "orderTime",
//	            "customerIp",
//	            "customerName",
//	            "defaultPayType",
//	            "defaultBankNumber",
//	            "transTimeout",
//	            "frontEndUrl",
//	            "backEndUrl",
//	            "merReserved"
//		};
//
//		public final static String[] notifyVo = new String[]{
//	            "charset",
//	            "cupReserved",
//	            "exchangeDate",
//	            "exchangeRate",
//	            "merAbbr",
//	            "merId",
//	            "orderAmount",
//	            "orderCurrency",
//	            "orderNumber",
//	            "qid",
//	            "respCode",
//	            "respMsg",
//	            "respTime",
//	            "settleAmount",
//	            "settleCurrency",
//	            "settleDate",
//	            "traceNumber",
//	            "traceTime",
//	            "transType",
//	            "version"
//		};
//
//		public final static String[] queryVo = new String[]{
//			"version",
//			"charset",
//			"transType",
//			"merId",
//			"orderNumber",
//			"orderTime",
//			"merReserved"
//		};
//		
//		public final static String[] smsVo = new String[]{
//			"version",
//			"charset",
//			"acqCode",
//			"merId",
//			"merAbbr",
//			"orderNumber",
//			"orderAmount",
//	        "orderCurrency",
//			"merReserved"
//		};
///***  1、  ********************银联       在线支付**********************************************/
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
///*******工具方法*********************************************************************************/		
//		/**
//		 * 生成发送银联报文页面(在线支付)
//		 * 
//		 * @param map
//		 * @param signature
//		 * @return
//		 */
//		public static String createPayHtml(String[] valueVo, String signType){
//			Map<String, String> map = new TreeMap<String, String>();
//			for(int i = 0; i < reqVo.length; i++){
//				map.put(reqVo[i], valueVo[i]);
//			}
//			map.put("signature", signMap(map, signType));
//			map.put("signMethod", signType);
//			String payForm = generateAutoSubmitForm(ConfigUtil.getProperty("UNION_PayWay"), map);
//			return payForm;
//		}
//		
//		/**
//		 * 验证签名   在线支付
//		 * @param map
//		 * @param secretKey
//		 *            商城密钥
//		 * @return
//		 */
//		public static boolean checkSign(String[] valueVo, String signMethod, String signature) {
//
//			Map<String, String> map = new TreeMap<String, String>();
//			for (int i = 0; i < notifyVo.length; i++) {
//				map.put(notifyVo[i], valueVo[i]);
//			}
//			if (signature == null)
//				return false;
//			if ("MD5".equalsIgnoreCase(signMethod)) {
//				System.out.println(">>>" + joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey")));
//				System.out.println(">>>" + signature.equals(rjmd5(joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey")))));
//				return signature.equals(rjmd5(joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey"))));
//			} else {
//				return verifyWithRSA(signMethod, rjmd5(joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey"))), signature);
//			}
//
//		}	
//		
//		/**
//		 * 生成加密钥  在线支付
//		 * 
//		 * @param map
//		 * @param secretKey
//		 *            商城密钥
//		 * @return
//		 */
//		private static String signMap(Map<String, String> map, String signMethod) {
//			if ("MD5".equalsIgnoreCase(signMethod)) {
//				String strBeforeMd5 = joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey"));
//				System.out.println(strBeforeMd5);
//				return rjmd5(strBeforeMd5);
//			} else {
//				return signWithRSA(rjmd5(joinMapValue(map, '&') + rjmd5(ConfigUtil.getProperty("union_securityKey"))));
//			}
//		}
//		
//		public static String joinMapValue(Map<String, String> map, char connector) {
//			StringBuffer b = new StringBuffer();
//			for (Map.Entry<String, String> entry : map.entrySet()) {
//				b.append(entry.getKey());
//				b.append('=');
//				if (entry.getValue() != null) {
//					b.append(entry.getValue());
//				}
//				b.append(connector);
//			}
//			return b.toString();
//		}
//		
//		
//		/**
//		 * md5加密
//		 * @param str
//		 * @return
//		 */
//		private static String rjmd5(String str) {
//			if (str == null) {
//				return null;
//			}
//			MessageDigest messageDigest = null;
//			try {
//				messageDigest = MessageDigest.getInstance("MD5");
//				messageDigest.reset();
//				messageDigest.update(str.getBytes("UTF-8"));
//			} catch (NoSuchAlgorithmException e) {
//				return str;
//			} catch (UnsupportedEncodingException e) {
//				return str;
//			}
//			byte[] byteArray = messageDigest.digest();
//			StringBuffer md5StrBuff = new StringBuffer();
//			for (int i = 0; i < byteArray.length; i++) {
//				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
//					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
//				else
//					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
//			}
//			return md5StrBuff.toString();
//		}
//
//		private static String signWithRSA(String signData) {
//			String privateKeyPath = "D:/work/Test/data/upop_private.key";
//			ObjectInputStream priObjectIs = null;
//			try {
//				priObjectIs = new ObjectInputStream(new FileInputStream(privateKeyPath));
//				PrivateKey privateKey = PrivateKey.class.cast(priObjectIs.readObject());
//				Signature dsa = Signature.getInstance(ConfigUtil.getProperty("signType_SHA1withRSA"));
//				dsa.initSign(privateKey);
//				dsa.update(signData.getBytes("UTF-8"));
//				byte[] signature = dsa.sign();
//				BASE64Encoder base64Encoder = new BASE64Encoder();
//				return base64Encoder.encode(signature);
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			} finally {
//				if (priObjectIs != null) {
//					try {
//						priObjectIs.close();
//					} catch (IOException e) {
//						throw new RuntimeException(e);
//					}
//				}
//			}
//		}
//		
//		
//		/**
//		 * 非MD5加密时从本地获取upop.cer文件
//		 * @param algorithm
//		 * @param signData
//		 * @param signature
//		 * @return
//		 */
//		private static boolean verifyWithRSA(String algorithm, String signData, String signature) {
//			String publicKeyPath = "D:/work/Test/data/upop.cer";
//			ObjectInputStream pubObjectIs = null;
//			try {
//				CertificateFactory factory = CertificateFactory.getInstance("X.509");
//				InputStream in = new FileInputStream(publicKeyPath);
//				Certificate cert = factory.generateCertificate(in);
//				PublicKey publicKey = cert.getPublicKey();
//				Signature signCheck = Signature.getInstance(ConfigUtil.getProperty("signType_SHA1withRSA"));
//				signCheck.initVerify(publicKey);
//				signCheck.update(signData.getBytes("UTF-8"));
//				BASE64Decoder base64Decoder = new BASE64Decoder();
//				return signCheck.verify(base64Decoder.decodeBuffer(signature));
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			} finally {
//				if (pubObjectIs != null) {
//					try {
//						pubObjectIs.close();
//					} catch (IOException e) {
//						throw new RuntimeException(e);
//					}
//				}
//			}
//		}
//		
//		
///********  3、 融金   在线支付********************************************************************************/		
//		
//		
//		
//		public static String getDataContent(TreeMap<String, String> map) {
//			Set<String> keySet = map.keySet();
//			Iterator<String> iter = keySet.iterator();
//			StringBuilder sb = new StringBuilder();
//			while (iter.hasNext()){
//				String key = iter.next();
//				sb.append(key).append("=").append(map.get(key)).append("&");
//			}
//			return sb.toString();
//		}
//		
//		
//		
//		/**
//		 * 对一串内容进行md5运算
//		 * @param byte[] source 内容组成
//		 * @return md5后的数据摘要值
//		 */
//	public static  String getMD5(byte[] source){
//			String s = null;
//			char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f' };
//			try{
//				java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
//				md.update(source);
//				byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
//				// 用字节表示就是 16 个字节
//				char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
//				// 所以表示成 16 进制需要 32 个字符
//				int k = 0; // 表示转换结果中对应的字符位置
//				for (int i = 0; i < 16; i++)
//				{ // 从第一个字节开始，对 MD5 的每一个字节
//					// 转换成 16 进制字符的转换
//					byte byte0 = tmp[i]; // 取第 i 个字节
//					str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
//					// >>> 为逻辑右移，将符号位一起右移
//					str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
//				}
//				s = new String(str); // 换后的结果转换为字符串
//
//			} catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//			return s;
//		}
//	
//	
///****** 公共方法 ***************************************************************/
//	/** 
//	 * 获取Ip地址 
//	 * @return 
//	 */  
// public static String getIpAddr(HttpServletRequest request) {  
//	    String ip = request.getHeader("x-forwarded-for");  
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getHeader("Proxy-Client-IP");  
//	    }  
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getHeader("WL-Proxy-Client-IP");  
//	    }  
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getRemoteAddr();  
//	    }  
//	    return ip;  
//	} 
//	
// 
// 	/**
//	 * 在线支付生成form提交
//	 * @param actionUrl
//	 * @param paramMap
//	 * @return
//	 */
//	public static String generateAutoSubmitForm(String actionUrl, Map<String, String> paramMap) {
//		StringBuilder html = new StringBuilder();
//		html.append("<script language=\"javascript\">window.onload=function(){document.pay_form.submit();}</script>\n");
//		html.append("<form id=\"pay_form\" name=\"pay_form\" action=\"").append(actionUrl).append("\" method=\"post\">\n");
//
//		for (String key : paramMap.keySet()) {
//			html.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
//		}
//		html.append("</form>\n");
//		return html.toString();
//	}	
//	
//	/**
//	 * 把一定类型的字符串转成map类型：GneteDate=20140421&MerId=193&OrderNo=114042100004696&PayNo=200014&Explain=0
//	 * @param str
//	 * @return
//	 * 
//	 * //	if(state.equals("1")&&str.indexOf("OrderNo")!=-1&&str.indexOf("PayNo")!=-1&&str.indexOf("ReturnAmount")!=-1
//         //	&&str.indexOf("Explain")!=-1){
//	 */
//	public static Map String2Map(String str){
//		String strs[] =str.split("&");
//		Map map =new HashMap<String, String>();
//		try {
//			for (String string : strs) {
//				String ss[] =string.split("=");
//				if(ss.length ==1){
//					map.put(ss[0],"");
//				}else{
//					map.put(ss[0],ss[1]);
//				}
//			}
//		} catch (Exception e) {
//			return map;
//		}
//		return map;
//	}
//	
//	public static String strReplace(String str, String old_str, String new_str){
//		String tmpstr = str;
//		int found_pos = tmpstr.indexOf(old_str);
//		while (found_pos>=0){
//			tmpstr = tmpstr.substring(0,found_pos) + new_str + tmpstr.substring(found_pos + old_str.length(),tmpstr.length());			
//			found_pos = tmpstr.indexOf(old_str,found_pos+new_str.length());
//		}		
//		return tmpstr;
//	}
//	
//	
//	
///***********************  手机支付工具类方法****************************/	
//	
//	/**
//	 * 订单推送请求
//	 */
//	public static boolean trade(Map<String, String> req, Map<String, String> resp){
//		String nvp = buildReq(req);
//		logger.info("订单推送请求内容："+nvp);
//		String respString = MobileHttpUtil.post(ConfigUtil.getProperty("upmp.trade.url"), nvp);
//		logger.info("订单推送应答："+respString);
//		return verifyResponse(respString, resp);
//	}
//	
//	
//	
//	/**
//	 * 交易查询处理
//	 * @param req 请求要素
//	 * @param resp 应答要素
//	 * @return 是否成功
//	 */
//	public static boolean query(Map<String, String> req, Map<String, String> resp){
//		String nvp = buildReq(req);
//		String respString = MobileHttpUtil.post(ConfigUtil.getProperty("upmp.query.url"), nvp);
//		return verifyResponse(respString, resp);
//	}
//	
//	
//	
//	
//	
//	
//	/**
//	 * 拼接请求字符串
//	 * @param req 请求要素
//	 * @return 请求字符串
//	 */
//	public static String buildReq(Map<String, String> req) {
//	    //除去数组中的空值和签名参数
//        Map<String, String> filteredReq = paraFilter(req);
//		// 生成签名结果
//		String signature = buildSignature(filteredReq);
//
//		// 签名结果与签名方式加入请求提交参数组中
//		filteredReq.put("signature", signature);
//		filteredReq.put("signMethod", "MD5");
//
//		return createLinkString(filteredReq, false, true);
//		
//	}
//	
//	 /** 
//     * 除去请求要素中的空值和签名参数ss
//     * @param para 请求要素
//     * @return 去掉空值与签名参数后的请求要素
//     */
//    public static Map<String, String> paraFilter(Map<String, String> para) {
//        Map<String, String> result = new HashMap<String, String>();
//        if (para == null || para.size() <= 0) {
//            return result;
//        }
//        for (String key : para.keySet()) {
//            String value = para.get(key);
//            if (value == null || value.equals("") || key.equalsIgnoreCase("signature")|| key.equalsIgnoreCase("signMethod")) {
//                continue;
//            }
//            result.put(key, value);
//        }
//        return result;
//    }
//    
//    /**
//     * 生成签名
//     * @param req 需要签名的要素
//     * @return 签名结果字符串
//     */
//    public static String buildSignature(Map<String, String> req) {
//		String prestr = createLinkString(req, true, false);
//		logger.debug("签名前："+prestr);
//		prestr = prestr + "&" + sjmd5(ConfigUtil.getProperty("securitykey"));
//		return sjmd5(prestr);
//    }
//    
//    
//    
//    /**
//     * 把请求要素按照“参数=参数值”的模式用“&”字符拼接成字符串
//     * @param para 请求要素
//     * @param sort 是否需要根据key值作升序排列
//     * @param encode 是否需要URL编码
//     * @return 拼接成的字符串
//     */
//    public static String createLinkString(Map<String, String> para, boolean sort, boolean encode) {
//        List<String> keys = new ArrayList<String>(para.keySet());
//        if (sort)
//        	Collections.sort(keys);
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < keys.size(); i++) {
//            String key = keys.get(i);
//            String value = para.get(key);
//            if (encode) {
//				try {
//					value = URLEncoder.encode(value, "utf-8");
//				} catch (UnsupportedEncodingException e) {
//				}
//            }
//            
//            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
//                sb.append(key).append("=").append(value);
//            } else {
//                sb.append(key).append("=").append(value).append("&");
//            }
//        }
//        return sb.toString();
//    }
//    
//    /**
//   	 * get the md5 hash of a string
//   	 * 
//   	 * @param strddd
//   	 * @return
//   	 */
//   	public static String sjmd5(String str) {
//   		if (str == null) {
//   			return null;
//   		}
//   		MessageDigest messageDigest = null;
//   		try {
//   			messageDigest = MessageDigest.getInstance("MD5");
//   			messageDigest.reset();
//   			messageDigest.update(str.getBytes("UTF-8"));
//   		} catch (NoSuchAlgorithmException e) {
//   			return str;
//   		} catch (UnsupportedEncodingException e) {
//   			return str;
//   		}
//   		byte[] byteArray = messageDigest.digest();
//   		StringBuffer md5StrBuff = new StringBuffer();
//   		for (int i = 0; i < byteArray.length; i++) {
//   			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
//   				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
//   			else
//   				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
//   		}
//   		return md5StrBuff.toString();
//   	}
//    
//   	
//   	/**
//	 * 应答解析
//	 * @param respString 应答报文
//	 * @param resp 应答要素
//	 * @return 应答是否成功
//	 */
//	private static boolean verifyResponse(String respString, Map<String, String> resp) {
//		if (respString != null && !"".equals(respString)) {
//			// 请求要素
//			Map<String, String> para;
//			try {
//				para = parseQString(respString);
//			} catch (Exception e) {
//				return false;
//			}
//			boolean signIsValid = verifySignature(para);
//
//			resp.putAll(para);
//			
//            if (signIsValid) { 
//                return true;
//            }else {
//                return false;
//            }
//				
//		}
//		return false;
//	}
//	
//	/**
//	 * 解析应答字符串，生成应答要素
//	 * 
//	 * @param str 需要解析的字符串
//	 * @return 解析的结果map
//	 * @throws UnsupportedEncodingException
//	 */
//	public static Map<String, String> parseQString(String str) throws UnsupportedEncodingException {
//
//		Map<String, String> map = new HashMap<String, String>();
//		int len = str.length();
//		StringBuilder temp = new StringBuilder();
//		char curChar;
//		String key = null;
//		boolean isKey = true;
//
//		for (int i = 0; i < len; i++) {// 遍历整个带解析的字符串
//			curChar = str.charAt(i);// 取当前字符
//
//			if (curChar == '&') {// 如果读取到&分割符
//				putKeyValueToMap(temp, isKey, key, map);
//				temp.setLength(0);
//				isKey = true;
//			} else {
//				if (isKey) {// 如果当前生成的是key
//					if (curChar == '=') {// 如果读取到=分隔符
//						key = temp.toString();
//						temp.setLength(0);
//						isKey = false;
//					} else {
//						temp.append(curChar);
//					}
//				} else {// 如果当前生成的是value
//					temp.append(curChar);
//				}
//			}
//		}
//		putKeyValueToMap(temp, isKey, key, map);
//		return map;
//	}
//	
//	
//	 /**
//     * 异步通知消息验证
//     * @param para 异步通知消息
//     * @return 验证结果
//     */
//    public static boolean verifySignature(Map<String, String> para) {
//        String respSignature = para.get("signature");
//        // 除去数组中的空值和签名参数
//        Map<String, String> filteredReq =paraFilter(para);
//        String signature = buildSignature(filteredReq);
//        if (null != respSignature && respSignature.equals(signature)) {
//			return true;
//		}else {
//            return false;
//        }
//    }
//	private static void putKeyValueToMap(StringBuilder temp, boolean isKey,
//			String key, Map<String, String> map) throws UnsupportedEncodingException {
//		if (isKey) {
//			key = temp.toString();
//			if (key.length() == 0) {
//				throw new RuntimeException("QString format illegal");
//			}
//			map.put(key, "");
//		} else {
//			if (key.length() == 0) {
//				throw new RuntimeException("QString format illegal");
//			}
//			map.put(key, URLDecoder.decode(temp.toString(), "UTF-8"));
//		}
//	}
//	
//	
//   
//}
//
