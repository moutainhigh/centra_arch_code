package com.ifudata.ums.core;

import java.sql.Timestamp;
import java.util.*;

import com.ifudata.ums.exception.DeleteException;
import com.ifudata.ums.exception.FindSeqenceException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SgipSrcGsm;
import com.ifudata.ums.dao.mapper.bo.SgipTemplate;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.manager.ISgipSrcGsm;
import com.ifudata.ums.manager.ISgipTemplate;
import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.manager.ISysSequenceCredit;
import com.ifudata.ums.util.ApplicationContextUtil;
import com.ifudata.ums.util.DateUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;

import org.springframework.transaction.annotation.Transactional;

/**
 * 短信生成器,负责根据短信接口表和短信模板表生成结果短信
 * 
 * @author guofei
 */

public class SMGenerator implements Runnable {

	private static final Log log = LogFactory.getLog(SMGenerator.class);

	private ISgipSrcGsm sgipSrcGsmService = (ISgipSrcGsm) ApplicationContextUtil.getInstance()
			.getBean("sgipSrcGsmService");

	private ISmsResult smsResultService = (ISmsResult) ApplicationContextUtil.getInstance().getBean("smsResultService");

	private ISgipTemplate sgipTemplateService = (ISgipTemplate) ApplicationContextUtil.getInstance()
			.getBean("sgipTemplateService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit) ApplicationContextUtil.getInstance()
			.getBean("sysSequence");

	@Override
	public void run() {
		log.debug("********** SMGenerator 启动。。。。。。  **********");
		// 首先设置当前线程名称
		Thread.currentThread().setName("SMGenerator");
		while (true) {
			try {
				List<SgipSrcGsm> sgipSrcGsmList = sgipSrcGsmService.getSgipSrc(SysParamConstant.SERVICE_TYPE,
						SysParamConstant.BATCH_GEN_SIZE);

				if ((sgipSrcGsmList == null) || (sgipSrcGsmList.isEmpty())) {
				} else {
					doProcess(sgipSrcGsmList);
				}

			} catch (Exception e) {
				log.error("Exception Error: ", e);
			} finally {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_GENERATOR);
				} catch (InterruptedException e) {
					log.error("InterruptedException Error:", e);
					e.printStackTrace();
				}
			}
		}
	}

	@Transactional()
	private void doProcess(List<SgipSrcGsm> srcLst) {
		log.info("***共有" + srcLst.size() + "条短信接口记录需要处理");
		// 用于批量处理的短信结果对象集合、历史短信接口对象集合
		List<SmsResult> smsResultList = new ArrayList<SmsResult>();
		smsResultList.clear();

		Iterator<SgipSrcGsm> sListIterator = srcLst.iterator();
		while (sListIterator.hasNext()) {
			SgipSrcGsm sgipSrcGsm = sListIterator.next();

			Long templateId = sgipSrcGsm.getTemplateId();

			SgipTemplate sgipTemplate = sgipTemplateService.getSgipTemplate(templateId);

			if ((sgipTemplate == null) || sgipTemplate.equals(null)) {
				log.error("***没找到对应 templateId[" + templateId + "]的模板配置,跳过此数据处理");
				sgipSrcGsm.setFlag(2);
				continue;
			}
			log.debug("********** " + sgipTemplate + " **********");

			String currTime = DateUtils.format(new Date(), "HHmmss");
			// 时间验证不符合的不发送,从列表中移除
			if (sgipTemplate.getSbeginTime().compareTo(currTime) > 0
					|| sgipTemplate.getScloseTime().compareTo(currTime) < 0) {
				sListIterator.remove();
				continue;
			}
			SmsResult smsResult = new SmsResult();

			String content = this.replaceTemplate(sgipTemplate.getTemplateText(), sgipSrcGsm.getGsmcontent());
			try {
				// SAC_SMS_MM
				sgipSrcGsm.setFlag(1);
				smsResult.setResSeq(sysSequence.getSequence("SEQ_SMS_RESULT"));
			} catch (UpdateException e) {
				// TODO Auto-generated catch block
				log.error("短信生成程序，取序列【SEQ_SMS_RESULT】更新异常:" + " 原因:" + e.getStackTrace().toString());
			} catch (FindSeqenceException e) {
				log.error("短信生成程序，取序列【SEQ_SMS_RESULT】异常:" + " 原因:" + e.getStackTrace().toString());

			} catch (Exception e) {
				log.error("短信生成程序，取序列【SEQ_SMS_RESULT】异常:" + " 原因:" + e.getStackTrace().toString());
			}
			smsResult.setSrcName(sgipSrcGsm.getSrcName());
			smsResult.setTemplateId(sgipSrcGsm.getTemplateId());
			smsResult.setServicetype(sgipSrcGsm.getServicetype());
			smsResult.setVerifyid(Long.valueOf(sgipSrcGsm.getVerifyid().toString()));

			smsResult.setPhone(sgipSrcGsm.getPhone());
			smsResult.setGsmcontent(sgipSrcGsm.getGsmcontent());
			smsResult.setContent(content);
			smsResult.setMaxTimes(sgipTemplate.getRetryTimes());
			smsResult.setSendFlag(Constant.SEND_FLAG_TOSEND);
			smsResult.setCreateTime(new Timestamp(System.currentTimeMillis()));
			// 加入结果列表
			smsResultList.add(smsResult);
		}

		try {
			if ((smsResultList.size() > 0) || (srcLst.size() > 0)) {
				sgipSrcGsmService.moveSgipSrc(srcLst);
				smsResultService.insertSmsResult(smsResultList);
			}
		} catch (DeleteException e) {
			log.error("短信生成程序，删除状态异常:" + " 原因:" + e.getMessage());
		} catch (InsertException e) {
			log.error("短信生成程序，插入状态异常:" + " 原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("短信生成程序，异常:" + " 原因:" + e.getMessage());
		}
	}

	/**
	* 
	* @param a
	* 被匹配的长字符串
	* @param b
	* 匹配的短字符串
	* @return 匹配次数
	*/
	public int hit(String a, String b) {
		if (a.length() < b.length()) {
			return 0;
		}
		char[] a_t = a.toCharArray();
		int count = 0;

		for (int i = 0; i < a.length() - b.length(); i++) {
			StringBuffer buffer = new StringBuffer();
			for (int j = 0; j < b.length(); j++) {
				buffer.append(a_t[i + j]);
			}
			if (buffer.toString().equals(b)) {
				count++;
			}
		}

		return count;
	}
	
	/**
	 * 利用模板替换生成真正短信内容
	 * 
	 * @param original:带有通配符的短信内容  ${Year} ${Month} 表示需要替换的变量 %%%之间的内容%%%为需要重复的内容!!!
	 * @param replacement:通配符对应的替换模板  
	 * @return 真正短信内容
	 */
	private String replaceTemplate(String original, String replacement) {
		// 先将replacement 按 符号 ^ 进行分割 得到一个String数组
		// 然后将String数组每一个元素继续 按 符号 ：进行分割 得到又一个String数组
		// 然后进行替换即可
		
		/*
		 * original = 
		 * 尊敬的客户，截止${Year}年${Month}月${Day}日${Hour}时${Minute}分,您订购的${ProductOfferName}套餐，包含%%%${QueryAccumName}${AccumTotal}${Unit}，已经使用${AccumUsedALL}${Unit}%%%查询办理业务请登录网厅www.hua10036.com。",
			replacement= "${Year}:2016^${Month}:7^${Day}:20^${Hour}:17^${Minute}:44^${ProductOfferName}:PRODUCTNAME^${QueryAccumName}:语音^${AccumTotal}:100^${AccumUsedALL}:30^${Unit}:分钟^${QueryAccumName}:短信^${AccumTotal}:100^${AccumUsedALL}:30^${Unit}:条"
			输出  "尊敬的客户，截止2016年7月20日17时44分,您订购的PRODUCTNAME套餐，包含语音100分钟，已经使用30分钟;短信100条，已经使用30条;查询办理业务请登录网厅www.hua10036.com。"
		 */
		int irep = original.indexOf("%%%");
		int irep1 = original.lastIndexOf("%%%");
		String strrepeat = "";
		String strrepeathead = "";
		String strrepeatail = "";
		String strsub = "";
		if (irep != irep1) {
			strrepeat = original.substring(irep + 3, irep1);
			strrepeathead = original.substring(0, irep);
			strrepeatail = original.substring(irep1 + 3);
			/*
			 * original=
			 * '尊敬的客户，截止${Year}年${Month}月${Day}日${Hour}时${Minute}分,您订购的${ProductOfferName}套餐，包含%%%${QueryAccumName}${AccumTotal}${Unit}，已经使用${AccumUsedALL}${Unit}%%%。查询办理业务请登录网厅www.hua10036.com。'
			 * replacement =
			 * ${Year}:2016^${Month}:7^${Day}:20^${Hour}:17^${Minute}:44^${ProductOfferName}:PRODUCTNAME
			 * ^${QueryAccumName}:语音^${AccumTotal}:100^${AccumUsedALL}:30^${Unit}:分钟
			 * ^${QueryAccumName}:短信^${AccumTotal}:100^${AccumUsedALL}:30^${Unit}:条
			 */
			String[] temp1 = strrepeat.split("\\$\\{");
			if (temp1.length > 0) {
				int isize = temp1.length;
				String[] temp2 = new String[isize];
				int icount = 0;
				for (int iloop = 0; iloop < temp1.length; iloop ++) {
					if (temp1[iloop].equals(""))
						continue;
					if (temp1[iloop].indexOf("}") >= 0) {
						temp1[iloop] = "${" + temp1[iloop];
						temp2[icount++] = temp1[iloop].substring(1, temp1[iloop].indexOf("}") + 1); 
					}
				}
				
				System.out.println("temp1[0]:" + temp2[0] + "}");
				//获取传入参数中需要循环的次数
				String strsubrepeat = "";
				String strrepeat1 = strrepeat;
				//需要重复替换的次数
				int irepeat = hit(replacement, temp2[0]);
				if (irepeat > 0) {
					//第二次循环替换时的起始位置
					int icontinue = 0;
					for (int ii = 0; ii < irepeat; ii ++) {
						String[] firstTemp = replacement.split("\\^");
						
						//外层循环按输入参数的顺序
						for (int i = icontinue; i < firstTemp.length; i++) {
							String[] secondTemp = firstTemp[i].split(":");
							//找到需要替换的第一个值
							if (firstTemp[i].indexOf(temp2[0]) >= 0) {
								if (secondTemp != null && secondTemp.length == 2) {
									strsubrepeat = strrepeat1.replace(secondTemp[0], secondTemp[1]);
									for (int j = 1; j < icount; j ++) {
										//在此循环中把 需要重复替换的都找出来 需要注意的是需重复替换的第一个参数位置不能更改 其它不限!
										String[] secondTempa = firstTemp[++ i].split(":");
										strsubrepeat = strsubrepeat.replace(secondTempa[0], secondTempa[1]);
										//System.out.println("i=" + i + " firstTemp.length=" +  firstTemp.length);
										if (i >= firstTemp.length - 1) {
											break;
										}
									}
									icontinue = i;
									strsub = strsub + strsubrepeat + ";";
									break;
								}
							}
						}
					}
				}
			}
			
			String[] firstTemp = replacement.split("\\^");
			for (int i = 0; i < firstTemp.length; i++) {
				String[] secondTemp = firstTemp[i].split(":");
				if (secondTemp != null && secondTemp.length == 2) {
					strrepeathead = strrepeathead.replace(secondTemp[0], secondTemp[1]);
				}
			}
			
			String[] firstTemp2 = replacement.split("\\^");
			for (int i = 0; i < firstTemp2.length; i++) {
				String[] secondTemp = firstTemp2[i].split(":");
				if (secondTemp != null && secondTemp.length == 2) {
					strrepeatail = strrepeatail.replace(secondTemp[0], secondTemp[1]);
				}
			}	
			
			return strrepeathead + strsub + strrepeatail;
		}

		if (replacement != null) {
			String[] firstTemp = replacement.split("\\^");
			for (int i = 0; i < firstTemp.length; i++) {
				String[] secondTemp = firstTemp[i].split(":");
				if (secondTemp != null && secondTemp.length == 2) {
					original = original.replace(secondTemp[0], secondTemp[1]);
				}
			}
		}
		return original;
	}	
}

