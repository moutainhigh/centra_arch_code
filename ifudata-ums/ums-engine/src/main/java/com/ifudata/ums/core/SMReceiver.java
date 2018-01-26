package com.ifudata.ums.core;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.service.sgip.constant.SGIPConstant;
import com.ifudata.ums.util.ApplicationContextUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;

/**
 * 消息接收子线程
 * 
 * @author guofei
 */
public abstract class SMReceiver implements Runnable {

	private static final Log log = LogFactory.getLog(SMReceiver.class);

	private SMAbstractClient smClient;

	private ISmsResult smsResultService = (ISmsResult) ApplicationContextUtil.getInstance().getBean("smsResultService");

	public SMReceiver(SMAbstractClient smClient) {
		this.smClient = smClient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		// 首先设置当前线程名称
		Thread.currentThread().setName("Receiver");
		while (true) {
			try {
				// 使用具体协议的client接收回执 this.smClient.readMessage()
				// 根据序列号修改对应记录的rec_flag,rec_result,rec_time
				// log.debug("********** 准备读取回执,阻塞中。。。。。。 **********");
				Map<String, Object> recMap = this.smClient.readMessage();
				if (recMap != null && recMap.size() > 0) {
					// 新加同步
					log.info("******** recMap.size ********" + recMap.size());
					synchronized (Object.class) {
						if (recMap.get("dhst") != null) {
							if (recMap.get("details") != null) {
								log.info("******** 开始记录短信回执 ********");
								for (Map<String, Object> details : (List<Map<String, Object>>) recMap.get("details")) {
									smReceiver(details);
								}
							}
						} else if (recMap.get("baiwunew") != null) {
							if (recMap.get("details") != null) {
								log.info("******** baiwunew 开始记录短信回执 ********");
								for (Map<String, Object> details : (List<Map<String, Object>>) recMap.get("details")) {
									smReceiver(details);
								}
							}
						} else if (recMap.get("byd") != null) {
							if (recMap.get("details") != null) {
								log.info("******** byd 开始记录短信回执 ********");
								for (Map<String, Object> details : (List<Map<String, Object>>) recMap.get("details")) {
									smReceiver(details);
								}
							}
						} else if (recMap.get("sgip") != null) {
							if (recMap.get("details") != null) {
								log.info("******** sgip 开始记录短信回执 ********");
								for (Map<String, Object> details : (List<Map<String, Object>>) recMap.get("details")) {
									smReceiver(details);
								}
							}
						}
						else {
							smReceiver(recMap);
						}
					}
				}
			} catch (Exception e) {
				log.error("接收异常:", e);
			} finally {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("接收异常:", e);
				}
			}
		}
	}

	protected abstract boolean isRecSuccess(Map<String, Object> recMap);

	/*
	 * 
	 */
	private void smReceiver(Map<String, Object> recMap) {
		log.debug("smReceiver recMap :" + recMap);
		String sequenceNum = (String) recMap.get(Constant.SEQUENCE_NUM);
		String resultContent = (String) recMap.get(Constant.RESULT_CONTENT);
		String resultCode = (String) recMap.get(Constant.RESULT_CODE);
		int ires = 0;
		try {
			ires = Integer.parseInt(resultCode);
		} catch (NumberFormatException e) {
			log.error("parseInt error:" + resultCode);
			ires = 0;
		}
		
		SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
		smsResultCriteria.createCriteria().andSendSeqEqualTo(sequenceNum);
		List<SmsResult> smsResultList = smsResultService.getSmsResult(smsResultCriteria);
		if ((smsResultList != null) && (smsResultList.size() > 0)) {
			SmsResult smsResult = smsResultList.get(0);

			log.debug("smReceiver:smsResultList.size:" + smsResultList.size() + " seq:" + sequenceNum + " resultCode:" + resultCode);
			if (isRecSuccess(recMap)) {
				if (ires < (int)((SGIPConstant.SGIP_BIND_RESP - SGIPConstant.SGIP_BIND)/ 0x10000l)) {
					//此为submit_resp
					if (smsResult.getSendFlag() == Constant.SEND_FLAG_SUCCESSANDWAITRESP) {
						log.debug("**smReceiver*smsResult*submit_resp**SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_SUCCESS**" + ires + " sequenceNum" + sequenceNum);
						smsResult.setSendFlag(Constant.SEND_FLAG_SUCCESS);
					} else {
						//这种情况是联通网关socket上次发送submit_resp出现问题重新发送的 在remark中记录一下
						log.debug("**smReceiver*smsResult*submit_resp**!!SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + ires + " sequenceNum" + sequenceNum);
						smsResult.setSendFlag(Constant.SEND_FLAG_SUCCESS);
						smsResult.setRecFlag(Constant.REC_FLAG_SUCCESS);
						smsResult.setRemark(smsResult.getRemark() + "," + resultCode);
					}
				} else if (smsResult.getSendFlag() == Constant.SEND_FLAG_SUCCESS) {
					//此为收到report
					log.debug("**smReceiver*smsResult*report*****SEND_FLAG_SUCCESS**" + ires + " sequenceNum" + sequenceNum);
					smsResult.setRecFlag(Constant.REC_FLAG_SUCCESS);
					smsResult.setRemark(smsResult.getRemark() + "," + resultCode);
				} else
					log.debug("**smReceiver*smsResult*isRecSuccess(recMap) && not SUCCESS**" + ires + " sequenceNum" + sequenceNum);
			} else {
				//如果是submit_resp 且响应码为不成功  写发送状态
				if (smsResult.getSendFlag() == Constant.SEND_FLAG_SUCCESSANDWAITRESP) {
					log.debug("**smReceiver**smsResult*SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + sequenceNum);
					smsResult.setSendFlag(Constant.SEND_FLAG_FAIL);
				} else {
					log.debug("**smReceiver**smsResult*!!SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + sequenceNum);
					smsResult.setRecFlag(Constant.REC_FLAG_FAIL);
				}
				smsResult.setRemark(smsResult.getRemark() + "," + resultCode);
			}	
			smsResult.setRecResult(resultContent);
			smsResult.setRecTime(new Timestamp(System.currentTimeMillis()));
			try {
				int ires1 = smsResultService.updateSmsResult(smsResult, smsResultCriteria);
				log.debug("**smsResultService updateSmsResult**" + ires1 + " sequenceNum" + sequenceNum);
			} catch (UpdateException e) {
				log.error("短信接收程序，更新状态异常:" + " Result.resid[" + smsResult.getResSeq() + " SEND_SEQ:" + smsResult.getSendSeq() + "]");
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			// 超时的
			smsResultList = smsResultService.getSmsResultTimeout(smsResultCriteria);
			if ((smsResultList != null) && (smsResultList.size() > 0)) {
				SmsResult smsResultTimeout = smsResultList.get(0);

				log.debug("smReceiver:smsResultTimeout.size:" + smsResultList.size() + " seq:" + sequenceNum);
				if (isRecSuccess(recMap)) {
					if (ires < (int)((SGIPConstant.SGIP_BIND_RESP - SGIPConstant.SGIP_BIND)/ 0x10000l)) {
						//此为submit_resp 对于report的采用 + 0x80000000l 区分
						if (smsResultTimeout.getSendFlag() == Constant.SEND_FLAG_SUCCESSANDWAITRESP) {
							log.debug("**smReceiver*smsResultTimeout*submit_resp**SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_SUCCESS**" + ires + " sequenceNum" + sequenceNum);
							smsResultTimeout.setSendFlag(Constant.SEND_FLAG_SUCCESS);
						} else {
							//这种情况是联通网关socket上次发送submit_resp出现问题重新发送的 在remark中记录一下
							log.debug("**smReceiver*smsResultTimeout*submit_resp**!!SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + ires + " sequenceNum" + sequenceNum);
							smsResultTimeout.setSendFlag(Constant.SEND_FLAG_SUCCESS);
							smsResultTimeout.setRecFlag(Constant.REC_FLAG_SUCCESS);
							smsResultTimeout.setRemark(smsResultTimeout.getRemark() + ", " + resultCode);
						}
					} else if (smsResultTimeout.getSendFlag() == Constant.SEND_FLAG_SUCCESS) {
						//此为收到report 
						log.debug("**smReceiver*smsResultTimeout*report*****SEND_FLAG_SUCCESS**" + ires + " sequenceNum" + sequenceNum);
						smsResultTimeout.setRecFlag(Constant.REC_FLAG_SUCCESS);
						smsResultTimeout.setRemark(smsResultTimeout.getRemark() + "," + resultCode);
					} else {
						log.debug("**smReceiver*smsResultTimeout*isRecSuccess(recMap) && not SUCCESS**" + ires + " sequenceNum" + sequenceNum);
						smsResultTimeout.setRemark(smsResultTimeout.getRemark() + "," + resultCode);
					}
				} else {
					//如果是submit_resp 且响应码为不成功  写发送状态
					if (smsResultTimeout.getSendFlag() == Constant.SEND_FLAG_SUCCESSANDWAITRESP) {
						log.debug("**smReceiver**smsResultTimeout*SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + " sequenceNum" + sequenceNum);
						smsResultTimeout.setSendFlag(Constant.SEND_FLAG_FAIL);
					} else {
						log.debug("**smReceiver**smsResultTimeout*!!SEND_FLAG_SUCCESSANDWAITRESP***SEND_FLAG_FAIL**" + " sequenceNum" + sequenceNum);
						smsResultTimeout.setRecFlag(Constant.REC_FLAG_FAIL);
					}
					smsResultTimeout.setRemark(smsResultTimeout.getRemark() + "," + resultCode);
				}				
				smsResultTimeout.setRecResult(resultContent);
				smsResultTimeout.setRecTime(new Timestamp(System.currentTimeMillis()));
//				log.debug("********** " + smsResultTimeout + "**********");
				try {
					smsResultService.updateSmsResultTimeout(smsResultTimeout, smsResultCriteria);
				} catch (UpdateException e) {
					log.error("短信接收程序，更新状态异常:" + " Result.resid[" + smsResultTimeout.getResSeq() + " SEND_SEQ:" + smsResultTimeout.getSendSeq() + "]");
				} catch (Exception e) {
					log.error(e);
				}
			}
		}
	}
}
