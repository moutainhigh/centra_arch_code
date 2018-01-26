package com.ifudata.ums.manager;

import java.util.List;

import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.exception.InsertException;

/**
 *
 * 2015年10月16日下午2:50:10
 * hongzhenfu
 *
 */
public interface ISmsCommTask {
	Integer insertSmsCommTask(List<SmsCommTask> sctlist) throws InsertException;
}

