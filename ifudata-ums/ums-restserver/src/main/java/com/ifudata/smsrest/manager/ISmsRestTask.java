package com.ifudata.smsrest.manager;

import java.util.List;

import com.ifudata.smsrest.db.mapper.bo.SmsRestTask;
import com.ifudata.smsrest.db.mapper.bo.SmsRestTaskCriteria;

/**
 *
 * 2015年10月16日下午2:50:10
 * 
 *
 */
public interface ISmsRestTask {
	Integer insertSmsRestTask(List<SmsRestTask> sctlist) throws Exception;
	List<SmsRestTask> getSmsRestTask(List<String> serviceTypeList) throws Exception;
	Integer updateSmsRestTask(SmsRestTask rec, SmsRestTaskCriteria criteria) throws Exception;
	Integer updateByPrimaryKey(SmsRestTask rec) throws Exception;
}
