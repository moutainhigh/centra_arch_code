package com.ai.slp.order.elasticjob;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.opt.sdk.util.CryptUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.util.PropertiesUtil;
import com.ai.slp.order.util.SftpUtil;
import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

/**
 * 读取订单商品信息文件 Date: 2017年1月6日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class OrdProdReadFileThread extends Thread {

	private static final Log LOG = LogFactory.getLog(OrdProdReadFileThread.class);

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	public BlockingQueue<String[]> ordOdProdQueue;
	public Map<String, String[]> index = new HashMap<>();

	/**
	 * 获取配置文件信息
	 */
	String ip = PropertiesUtil.getStringByKey("ftp.ip"); // 服务器IP地址
	String userName = CryptUtils.decrypt(PropertiesUtil.getStringByKey("ftp.userName")); // 用户名
	String userPwd = CryptUtils.decrypt(PropertiesUtil.getStringByKey("ftp.userPwd")); // 密码
	int port = Integer.parseInt(PropertiesUtil.getStringByKey("ftp.port")); // 端口号
	String path = PropertiesUtil.getStringByKey("ftp.path"); // 读取文件的存放目录
	String localpath = PropertiesUtil.getStringByKey("ftp.localpath");// 本地存在的文件路径

	public OrdProdReadFileThread(BlockingQueue<String[]> ordOdProdQueue) {
		this.ordOdProdQueue = ordOdProdQueue;
	}

	/**
	 * 线程启动
	 */
	public void run() {
		LOG.error("开始获取订单商品ftp文件：" + DateUtil.getSysDate());
		ChannelSftp sftp = SftpUtil.connect(ip, port, userName, userPwd);
		if(null==sftp){
			LOG.error("+++++++++++++++++连接订单商品ftp服务器失败");
			Thread.interrupted();
		}
		List<String> nameList = new ArrayList<>();
		try {
			LOG.error("开始获取订单商品信息文件列表");
			nameList = getFileName(path, sftp);
		} catch (SftpException e) {
			LOG.error("获取订单商品信息报错" + DateUtil.getSysDate() + JSON.toJSONString(e));
		}
		for (String fileName : nameList) {
			try {
				readOrdProdFile(fileName, sftp);
			} catch (Exception e) {
				LOG.error("读取订单商品数据出错" + DateUtil.getSysDate() + JSON.toJSONString(e));
			} 
		}
		LOG.error("获取订单商品ftp文件结束：" + DateUtil.getSysDate());
		SftpUtil.disconnect(sftp);
	}

	/**
	 * 读取ftp文件
	 * 
	 * @param fileName
	 * @param sftp
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public void readOrdProdFile(String fileName, ChannelSftp sftp) {
		InputStream ins = null;
		BufferedReader reader = null;
		try {
			// 从服务器上读取指定的文件
			LOG.error("开始读取订单商品文件：" + fileName);
			ins = SftpUtil.download(path, fileName, localpath + "bak", sftp);
			// ins = sftp.get(path + "/" + fileName);
			if (ins != null) {
				reader = new BufferedReader(new InputStreamReader(ins, "gbk"));
				String line;
				while ((line = reader.readLine()) != null) {
					try {
						String[] datTemp = line.split("\\t");
						if (datTemp.length != 8)
							continue;
						if (!index.keySet().contains(datTemp[0] + datTemp[1])) {
							LOG.error("全新的订单商品id");
							index.put(datTemp[0] + datTemp[1], datTemp);
							ordOdProdQueue.put(datTemp);
						} else {
							LOG.error("已存在的订单商品id");
							ordOdProdQueue.remove(index.get(datTemp[0] + datTemp[1]));
							index.remove(datTemp[0] + datTemp[1]);
							index.put(datTemp[0] + datTemp[1], datTemp);
							ordOdProdQueue.put(datTemp);
						}
						LOG.error("订单商品订单Id信息：" + datTemp[0]);
					} catch (Exception e) {
						LOG.error("读取订单商品文件失败：" + e.getMessage());
					}

				}
				/*reader.close();
				if (ins != null) {
					ins.close();
				}*/
				// SftpUtil.delete(path, fileName, sftp);
			}

		} catch (Exception e) {
			LOG.error("订单商品读取失败" + DateUtil.getSysDate() + e.getMessage());
		} finally {
			try {
				reader.close();
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			deleteFile(localpath + "bak/" + fileName);
		}
	}

	/**
	 * 匹配需要的文件
	 * 
	 * @param path
	 * @param sftp
	 * @return
	 * @throws SftpException
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public List<String> getFileName(String path, ChannelSftp sftp) throws SftpException {
		List<String> fileList = SftpUtil.listFiles(path, sftp);
		LOG.error("++++++++++获取ftp订单商品信息文件列表,文件列表如下" + JSON.toJSONString(fileList));
		List<String> nameList = new ArrayList<>();
		for (String string : fileList) {
			// String date = dateFormat.format(DateUtil.getSysDate());
			String date = format1(DateUtil.getSysDate());
			if (string.length() >= 20) {
				if ((date + "_" + "omsa01002").equals(string.substring(2, 20)) && string.endsWith(".dat")) {
					nameList.add(string);
				}
			}
		}
		LOG.error("++++++++++获取订单商品信息文件列表成功,文件列表如下" + JSON.toJSONString(nameList));
		return nameList;
	}

	/**
	 * 删除ftp文件
	 * 
	 * @param sPath
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public void deleteFile(String sPath) {
		File file = new File(sPath);
		LOG.error("删除文件条件" + file.isFile() + "++++++++++++" + file.exists() + "+++++++++" + sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	/**
	 * 安全关闭资源
	 * 
	 * @param fis
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public static void safeClose(InputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error(JSON.toJSONString(e));
			}
		}
	}

	/**
	 * 安全关闭资源
	 * 
	 * @param fis
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public static void safeClose(BufferedWriter fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error(JSON.toJSONString(e));
			}
		}
	}

	/**
	 * 安全关闭资源
	 * 
	 * @param fis
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public static void safeClose(BufferedReader fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error(JSON.toJSONString(e));
			}
		}
	}

	/**
	 * 格式化
	 * 
	 * @param date
	 * @return
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public synchronized String format1(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 格式化
	 * 
	 * @param date
	 * @return
	 * @author zhangqiang7
	 * @UCUSER
	 */
	public String format2(Date date) {
		synchronized (dateFormat) {
			return dateFormat.format(date);
		}
	}
}
