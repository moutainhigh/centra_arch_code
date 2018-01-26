package com.ifudata.ums.core;

import java.util.*;
import com.ifudata.ums.exception.DeleteException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import com.ifudata.ums.manager.ISmsResult;
import com.ifudata.ums.util.ApplicationContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;

/**
 * 超时监控器,负责轮询短信结果表,将成功或者失败并超时的短信转移到历史表
 * 
 * @author guofei
 */
public class SMTimeoutMonitor implements Runnable {

	private static final Log log = LogFactory.getLog(SMTimeoutMonitor.class);
	private ISmsResult smsResultService = (ISmsResult) ApplicationContextUtil.getInstance().getBean("smsResultService");

	/*
	 * 超时监控线程步骤: 1.首先到sms_result表中查找send_flag为1或2的记录: 1.1 如果没有,sleep约定的时间,然后继续扫描
	 * 1.2 如果有,加载到内存.然后遍历这些记录,对于每一条记录: 2.如果send_flag为1 2.1
	 * 如果rec_flag为0,那么用当前时间减去send_time,
	 * 如果结果值超过了约定的值,那么将该记录的rec_flag置为3,并将该记录转移到sms_result_timeout表
	 * 2.2
	 * 如果rec_flag为1,那么直接将该记录转移到his_sms_result表当中 2.3 如果rec_flag为2,那么判断(max_times
	 * - retry_times)的值 如果大于0,那么将该记录的send_flag置为3,rec_flag置为0
	 * 否则将该记录转移到his_sms_result表当中 
	 * 3.如果send_flag为2,那么判断(max_times - retry_times)的值 如果大于0,那么将该记录的send_flag置为3,rec_flag置为0
	 * 否则将该记录转移到his_sms_result表当中.
	 * 4. 如果当前实际-超时表里面的send_time 大于设置的 timeOutHisLimit值 转移到his_sms_result表当中
	 * 
	 * 5.对于收到回执的操作是 先找当前表 send_time 更新状态 当前表找不到 在更新超时表 smReceiver函数后半部分判断
	 */
	@Override
	public void run() {
		log.debug("********** SMTimeoutMonitor 启动。。。。。。  **********");
		// 首先设置当前线程名称
		Thread.currentThread().setName("SMTimeoutMonitor");
		while (true) {
			try {

				doProcess();

			} catch (Exception e) {
				log.error(e.getMessage());
			} finally {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_TIMEOUT_MONITOR);
				} catch (InterruptedException e) {
					log.error(e.getMessage());
				}
			}
		}
	}

	// 201601 超时表处理
	private void doProcessTimeout() {
		// 拼装查询结果条件，仅处理发送成功和发送失败的
		SmsResultCriteria conditions = new SmsResultCriteria();
		List<Integer> sendFlagLst = new ArrayList<>();
		sendFlagLst.add(Constant.SEND_FLAG_SUCCESS);
		//因锁表等问题 导致重复发送  添加一个发送状态 重新发送时不再取此状态的记录
		sendFlagLst.add(Constant.SEND_FLAG_WAITSEND);
		conditions.createCriteria().andSendFlagIn(sendFlagLst);
		// 获取发送结果数据
		List<SmsResult> smsResultList = smsResultService.getSmsResultTimeout(conditions);
		// 未取到结果信息返回
		if ((smsResultList == null) || (smsResultList.isEmpty())) {
			return;
		}
		// 逐条处理
		Iterator<SmsResult> smsResultIterator = smsResultList.iterator();
		// 从列表中获取数据逐条处理
		while (smsResultIterator.hasNext()) {
			SmsResult smsResult = smsResultIterator.next();
			try {
				if (smsResult.getSendFlag().equals(Constant.SEND_FLAG_SUCCESS)) {
					//	|| smsResult.getSendFlag().equals(Constant.SEND_FLAG_SUCCESSANDWAITRESP)) {
					if (smsResult.getRecFlag().equals(Constant.REC_FLAG_TOREC)) {
						// 用当前时间减去send_time
						// 如果结果值超过了阈值,那么将该记录的rec_flag置为3,并将该记录转移到his_sms_result表当中
						// 否则,空操作
						Long currTime = new Date().getTime();
						Long sendTime = smsResult.getSendTime().getTime();
						if ((currTime - sendTime) > SysParamConstant.TIMEOUT_HIS_LIMIT) {
							// 先将阈值硬编码为72小时,后续配置到配置文件当中
							smsResult.setRecFlag(Constant.REC_FLAG_TIMEOUT);
							if (smsResult.getRecResult().length() < 180)
								if (smsResult.getRecResult().indexOf(" 接收回执超时不再处理") == -1) 
									smsResult.setRecResult(smsResult.getRecResult() + " 接收回执超时不再处理");
							
							SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
							smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
							smsResultService.updateSmsResultTimeout(smsResult, smsResultCriteria);
							smsResultIterator.remove();
						}
						// 2016-01-05 转移到his表中
					} else if (smsResult.getRecFlag().equals(Constant.REC_FLAG_SUCCESS)
							|| smsResult.getRecFlag().equals(Constant.REC_FLAG_FAIL)
							|| smsResult.getRecFlag().equals(Constant.REC_FLAG_TIMEOUT)) {
						// 直接将该记录转移到his_sms_result表当中
						smsResultService.moveSmsResultTimeoutToBackup(smsResult);
						smsResultIterator.remove();
					}
					// } else if (
					// smsResult.getSendFlag().equals(Constant.SEND_FLAG_FAIL) )
					// {
					// if ( (smsResult.getRetryTimes() -
					// smsResult.getMaxTimes()) >= 0 ) {
					// smsResult.setSendFlag(Constant.SEND_FLAG_TORESEND);
					// smsResult.setRecFlag(Constant.REC_FLAG_TOREC);
					// SmsResultCriteria smsResultCriteria = new
					// SmsResultCriteria();
					// smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
					// smsResultService.updateSmsResultTimeout(smsResult,
					// smsResultCriteria);
					// smsResultIterator.remove();
					// } else {
					// smsResultService.moveSmsResultTimeoutToBackup(smsResult);
					// smsResultIterator.remove();
					// }
				} else if (smsResult.getSendFlag().equals(Constant.SEND_FLAG_WAITSEND) || 
						smsResult.getSendFlag().equals(Constant.SEND_FLAG_SUCCESSANDWAITRESP) ||
						smsResult.getSendFlag().equals(Constant.SEND_FLAG_FAIL)) {
					//
					if (!smsResult.getRecFlag().equals(Constant.REC_FLAG_TIMEOUT)) {
						Long currTime = new Date().getTime();
						Long sendTime = smsResult.getSendTime().getTime();
						if ((currTime - sendTime) > SysParamConstant.TIMEOUT_HIS_LIMIT) {
							// 先将阈值硬编码为72小时,后续配置到配置文件当中
							smsResult.setRecFlag(Constant.REC_FLAG_TIMEOUT);
							if (smsResult.getRecResult().length() < 180)
								if (smsResult.getRecResult().indexOf(" 接收回执超时不再处理") == -1) 							
									smsResult.setRecResult(smsResult.getRecResult() + " 接收回执超时不再处理");
							SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
							smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
							smsResultService.updateSmsResultTimeout(smsResult, smsResultCriteria);
							smsResultIterator.remove();
						}
					} else if (smsResult.getRecFlag().equals(Constant.REC_FLAG_SUCCESS)
							|| smsResult.getRecFlag().equals(Constant.REC_FLAG_FAIL)
							|| smsResult.getRecFlag().equals(Constant.REC_FLAG_TIMEOUT)) {
						// 直接将该记录转移到his_sms_result表当中
						smsResultService.moveSmsResultTimeoutToBackup(smsResult);
						smsResultIterator.remove();
					}
				}
			} catch (UpdateException e) {
				log.error(e.getMessage());
			} catch (InsertException e) {
				log.error(e.getMessage());
			} catch (DeleteException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

	private void doProcess() {
		// 拼装查询结果条件，仅处理发送成功和发送失败的
		SmsResultCriteria conditions = new SmsResultCriteria();
		List<Integer> sendFlagLst = new ArrayList<>();
		//sendFlagLst.add(Constant.SEND_FLAG_SUCCESSANDWAITRESP);
		sendFlagLst.add(Constant.SEND_FLAG_SUCCESS);
		sendFlagLst.add(Constant.SEND_FLAG_FAIL);
		sendFlagLst.add(Constant.SEND_FLAG_WAITSEND);
		// sendFlagLst.add(Constant.SEND_FLAG_TORESEND);
		conditions.createCriteria().andSendFlagIn(sendFlagLst);
		// 获取发送结果数据
		List<SmsResult> smsResultList = smsResultService.getSmsResult(conditions);
		// 未取到结果信息返回
		// 201601 不再返回 再查超时表
		if ((smsResultList == null) || (smsResultList.isEmpty())) {
			doProcessTimeout();
			return;
		}
		// 逐条处理
		Iterator<SmsResult> smsResultIterator = smsResultList.iterator();
		// 从列表中获取数据逐条处理
		while (smsResultIterator.hasNext()) {
			SmsResult smsResult = smsResultIterator.next();
			try {
				if (smsResult.getSendFlag().equals(Constant.SEND_FLAG_SUCCESS)) {
					if (smsResult.getRecFlag().equals(Constant.REC_FLAG_TOREC)) {
						// 用当前时间减去send_time
						// 如果结果值超过了阈值,那么将该记录的rec_flag置为3,并将该记录转移到sms_result_timeout表当中
						// 否则,空操作
						Long currTime = new Date().getTime();
						Long sendTime = smsResult.getSendTime().getTime();
						if ((currTime - sendTime) > SysParamConstant.tIME_OUT_LIMIT) {
							// 先将阈值硬编码为30min,后续配置到配置文件当中
							smsResult.setRecFlag(Constant.REC_FLAG_TIMEOUT);
							smsResult.setRecResult("接收回执超时,转移到超时表");
							SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
							smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
							smsResultService.updateSmsResult(smsResult, smsResultCriteria);
							smsResultIterator.remove();
						}
						// 2016-01-05 转移到tmp表中
					} else if (smsResult.getRecFlag().equals(Constant.REC_FLAG_SUCCESS)
							|| smsResult.getRecFlag().equals(Constant.REC_FLAG_FAIL)) {
						// 直接将该记录转移到his_sms_result表当中
						smsResultService.moveSmsResult(smsResult);
						smsResultIterator.remove();
					} else if (smsResult.getRecFlag().equals(Constant.REC_FLAG_TIMEOUT)) {
						// 直接将该记录转移到sms_result_timeout表当中
						smsResult.setRecFlag(Constant.REC_FLAG_TOREC);
						smsResultService.moveSmsResultTimeout(smsResult);
						smsResultIterator.remove();
					}
				} else if (smsResult.getSendFlag().equals(Constant.SEND_FLAG_FAIL) ||
						smsResult.getSendFlag().equals(Constant.SEND_FLAG_SUCCESSANDWAITRESP)) {
					//发送失败 和使用socket协议时没有收到submit响应的
					if (smsResult.getRetryTimes() < smsResult.getMaxTimes()) {
						smsResult.setSendFlag(Constant.SEND_FLAG_TORESEND);
						smsResult.setRecFlag(Constant.REC_FLAG_TOREC);
						SmsResultCriteria smsResultCriteria = new SmsResultCriteria();
						smsResultCriteria.createCriteria().andResSeqEqualTo(smsResult.getResSeq());
						smsResultService.updateSmsResult(smsResult, smsResultCriteria);
						smsResultIterator.remove();
					} else {
						Long currTime = new Date().getTime();
						Long sendTime = smsResult.getSendTime().getTime();
						if ((currTime - sendTime) > SysParamConstant.tIME_OUT_LIMIT) {
							// 多次发送失败 直接进历史表
							smsResultService.moveSmsResult(smsResult);
							smsResultIterator.remove();
						}
					} 
				} else if (smsResult.getSendFlag().equals(Constant.SEND_FLAG_WAITSEND)) {
					Long currTime = new Date().getTime();
					Long sendTime = smsResult.getSendTime().getTime();
					if ((currTime - sendTime) > SysParamConstant.tIME_OUT_LIMIT) {
						// 发送超时,转移到超时表
						smsResult.setRecFlag(Constant.REC_FLAG_TIMEOUT);
						smsResult.setRecResult("发送超时,转移到超时表");
						smsResultService.moveSmsResultTimeout(smsResult);
						smsResultIterator.remove();
					}
				}

				// else if (
				// smsResult.getSendFlag().equals(Constant.SEND_FLAG_TORESEND) )
				// {
				// if ( smsResult.getMaxTimes() != 0 &&
				// (smsResult.getRetryTimes() - smsResult.getMaxTimes()) >= 0 )
				// {
				// Long currTime = new Date().getTime();
				// Long sendTime = smsResult.getSendTime().getTime();
				// if ( (currTime - sendTime) > SysParamConstant.tIME_OUT_LIMIT
				// ) {
				// //多次发送失败 直接进历史表
				// smsResultService.moveSmsResult(smsResult);
				// smsResultIterator.remove();
				// }
				// }
				// }
			} catch (UpdateException e) {
				log.error(e.getMessage());
			} catch (InsertException e) {
				log.error(e.getMessage());
			} catch (DeleteException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}
