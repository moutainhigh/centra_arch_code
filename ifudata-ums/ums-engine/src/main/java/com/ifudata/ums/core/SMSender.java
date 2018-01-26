package com.ifudata.ums.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.service.sgip.client.SGIPClient;
import com.ifudata.ums.util.ApplicationContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;

/**
 * 消息发送子线程
 * 
 * @author guofei
 */
public abstract class SMSender implements Runnable {

	private static final Log log = LogFactory.getLog(SMSender.class);

	private SMAbstractClient smClient;
	private ISmsResult smsResultService = (ISmsResult) ApplicationContextUtil.getInstance().getBean("smsResultService");

	public SMSender(SMAbstractClient smClient) {
		this.smClient = smClient;
	}

	@Override
	public void run() {

		// 首先设置当前线程名称
		Thread.currentThread().setName("Sender");

		while (true) {
			try {
				// 首先到短信结果表当中取service_type为0并且send_flag为0或者3的记录:如果没有,sleep约定的时间;如果有,加载到内存
				// 使用具体协议的client发送短信到短信网关,并获得发送短信的序列号
				// this.smClient.writeMessage(userNumber, content)
				// 更新短信结果表中当前记录的字段 :
				// send_seq,send_flag,rec_flag,retry_times,send_time
				
				//联通网关限制 此处控制一下速度
				if (SGIPClient.tempResultMap.size() > SysParamConstant.BAND_WIDTH) {
					Thread.sleep(500);
					continue;
				}
				
				SmsResultCriteria conditions = new SmsResultCriteria();
				List<Integer> sendFlagList = new ArrayList<>();
				sendFlagList.add(Constant.SEND_FLAG_TOSEND);
				sendFlagList.add(Constant.SEND_FLAG_FAIL);
				sendFlagList.add(Constant.SEND_FLAG_TORESEND);
				conditions.createCriteria().andSendFlagIn(sendFlagList).andServicetypeIn(SysParamConstant.SERVICE_TYPE);

				List<SmsResult> smsResultList = smsResultService.getSmsResult(conditions);
		//		update to sending!!!!  SEND_FLAG_WAITSEND 此状态为发送之前的状态
				Iterator<SmsResult> smsResultIterator = smsResultList.iterator();
				while (smsResultIterator.hasNext()) {
					SmsResult smsResult = smsResultIterator.next();
					smsResult.setSendTime(new Timestamp(System.currentTimeMillis()));
					smsResult.setSendFlag(Constant.SEND_FLAG_WAITSEND);
					SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
					smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
					try {
						smsResultService.updateSmsResult(smsResult, smsResultCriteria);
					} catch (UpdateException e) {
						log.error("短信发送程序，更新状态异常:" + " Result.resid[" + smsResult.getResSeq() + "]");
						smsResultList.remove(smsResult);
					} catch (Exception e) {
						log.error(e);
						smsResultList.remove(smsResult);
					}
				}
				
				if ((smsResultList == null) || (smsResultList.isEmpty())) {

				} else {
					log.info("***************** 查询sms_result获取：[" + smsResultList.size() + "]条数据 *****************");
					doProcess(smsResultList);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			} finally {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} catch (InterruptedException e) {
					log.error("Error", e);
				}
			}
		}
	}

	private void doProcess(List<SmsResult> smsResultList) {
		Iterator<SmsResult> smsResultIterator = smsResultList.iterator();
		while (smsResultIterator.hasNext()) {
			// 新加同步
			synchronized (Object.class) {
				SmsResult smsResult = smsResultIterator.next();
				if (smsResult.getRetryTimes() >= smsResult.getMaxTimes()) {
					continue;
				}
//				log.debug("********** 准备发送短信  **********");
				String msgContent = smsResult.getContent();// + (msgCounter++);
				log.debug("********** 发送的号码为:[" + smsResult.getPhone() + "]发送的短信内容为:[" + msgContent + "]");
				Map<String, Object> status = this.smClient.writeMessage(smsResult.getPhone(), msgContent);
				if (isSendSuccess(status)) {
					//直连短信网关 处理 异步处理
					if (getSendStatus(status) == Constant.SEND_FLAG_SUCCESSANDWAITRESP) {
						log.debug("********** SEND_FLAG_SUCCESSANDWAITRESP **********");
						smsResult.setSendFlag(Constant.SEND_FLAG_SUCCESSANDWAITRESP);
					} else
						smsResult.setSendFlag(Constant.SEND_FLAG_SUCCESS);
					smsResult.setRecFlag(Constant.REC_FLAG_TOREC);
					smsResult.setSendSeq(getSequenceNum(status));
				} else {
					log.error("********** SMSSender短信发送发送失败 **********");
					smsResult.setSendFlag(Constant.SEND_FLAG_FAIL);
					smsResult.setRecFlag(Constant.REC_FLAG_TOREC);
					smsResult.setRemark(smsResult.getRemark() + "; send retry:" + smsResult.getRetryTimes() + ", error:"
							+ status.get(Constant.RESULT_CONTENT));
				}
				smsResult.setRetryTimes(smsResult.getRetryTimes() + 1);
				smsResult.setSendTime(new Timestamp(System.currentTimeMillis()));
				SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
				smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
				try {
					smsResultService.updateSmsResult(smsResult, smsResultCriteria);
				} catch (UpdateException e) {
					log.error("短信发送程序，更新状态异常:" + " Result.resid[" + smsResult.getResSeq() + "]");
				} catch (Exception e) {
					log.error(e);
				}
				try {
					Thread.sleep(1000 / SysParamConstant.BAND_WIDTH);
				} catch (InterruptedException e) {
					log.error("Error", e);
				}
			}
		}
	}

	protected abstract boolean isSendSuccess(Map<String, Object> status);

	protected abstract String getSequenceNum(Map<String, Object> status);

	//socket直连网关时异步操作
	protected abstract Integer getSendStatus(Map<String, Object> status);
}
