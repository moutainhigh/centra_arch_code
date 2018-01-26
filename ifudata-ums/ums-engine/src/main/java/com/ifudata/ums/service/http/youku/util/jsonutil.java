package com.ifudata.ums.service.http.youku.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ifudata.ums.service.http.youku.constant.SmsJsonConstant;

/** 

* @ClassName: jsonutil 

* @Description: 优酷短信常用工具类

* @author：lvsj

* @date 2015年6月1日 上午12:00:37 

* 
 

*/ 
public class jsonutil {
	private static final Logger	logger	= Logger.getLogger(jsonutil.class);
	public static String getTime()
	{
		 Date date = new Date(); 
	     DateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss"); 
	     
	     return df2.format(date); 
	}

	public static String getDate()
	{
		 Date date = new Date(); 
	     DateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmssSSS"); 
	     
	     return df2.format(date); 
	}
	public static String seqstr()
	{
		long seq = jsonseq.getSeq();
		String seqString ;
		int length,remaining;
		StringBuilder sb = new StringBuilder();
		
		seqString = Long.toString(seq); 

		length = seqString.length();
		
		remaining = SmsJsonConstant.seqlens  - length;

		if(remaining > 0)
		{
			for(int i = 0;i < remaining ;i++)
			{
				sb .append(0);
			}
			sb.append(seqString);
		}
		
		return sb.toString();
	}

	public static String getMD5(String comeString) throws NoSuchAlgorithmException 
	{
		//System.out.println(comeString);

        String s = null;
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                          'a', 'b', 'c', 'd', 'e', 'f' };// �������ֽ�ת����16���Ʊ�ʾ���ַ�
        byte sources[] = comeString.getBytes();

        try {
                 MessageDigest md = MessageDigest.getInstance("MD5");
                 md.update(sources);
                 byte tmp[] = md.digest();// MD5 �ļ�������һ�� 128 λ�ĳ�����
                 // ���ֽڱ�ʾ���� 16 ���ֽ�
                 char str[] = new char[16 * 2];// ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ����Ա�ʾ�� 16
                 // ������Ҫ 32 ���ַ�
                 int k = 0;// ��ʾת������ж�Ӧ���ַ�λ��
                 for (int i = 0; i < 16; i++) {// �ӵ�һ���ֽڿ�ʼ���� MD5 ��ÿһ���ֽ�// ת���� 16
                          // �����ַ��ת��
                          byte byte0 = tmp[i];// ȡ�� i ���ֽ�
                          str[k++] = hexDigits[byte0 >>> 4 & 0xf];// ȡ�ֽ��и� 4 λ������ת��,// >>>
                          // Ϊ�߼����ƣ������λһ������
                          str[k++] = hexDigits[byte0 & 0xf];// ȡ�ֽ��е� 4 λ������ת��
                 }

                 s = new String(str);// ����Ľ��ת��Ϊ�ַ�

        } catch (NoSuchAlgorithmException e) {
                 // TODO Auto-generated catch block
                 throw  new NoSuchAlgorithmException(); 
        }
        return s;
	}
	
	/** 
	
	* @Title: UrlisConnect 
	
	* @Description: 判断Url是否能够连接成功 
	
	* @param @param urlStr
	* @param @return    设定文件 
	
	* @return URL    返回类型 
	
	* @throws 
	
	*/
	public static synchronized HttpURLConnection UrlisConnect(String urlStr) {
		URL 	myurl = null;
		HttpURLConnection	myconnection = null;
		int counts = 0; 
	    if (urlStr == null || urlStr.length() <= 0) {                          
	    	return null;                    
	    }   
	    while (counts < 5) {   
		     try {   
		    	myurl = new URL(urlStr);   
		    	myconnection = (HttpURLConnection) myurl.openConnection();   
		    	myconnection.setConnectTimeout(3000);  
				myconnection.setDoOutput(true);
				myconnection.setReadTimeout( 8 * 1000);
				myconnection.setDoInput(true);
				myconnection.setRequestMethod("POST");
				myconnection.setUseCaches(false);
				myconnection.setInstanceFollowRedirects(true);
				myconnection.setRequestProperty("Content-Type",
	                     "application/json;text/xml; charset=utf-8");      

				myconnection.connect();
				break;
		     }catch (Exception ex) {   
			      counts++;    
		    	  logger.error("***"+urlStr+"**连接失败****"+"连接第 "+counts+" 次");
		    	  try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      urlStr = null;   
			      continue;   
		     }   
	    }   
	    return myconnection;   
	}   

}
