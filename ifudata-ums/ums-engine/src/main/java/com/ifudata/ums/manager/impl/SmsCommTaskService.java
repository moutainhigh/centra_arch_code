package com.ifudata.ums.manager.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.ums.dao.interfaces.SmsCommTaskMapper;
import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.manager.ISmsCommTask;

/**
 *
 * 2015年10月16日下午2:51:57 hongzhenfu
 *
 */
public class SmsCommTaskService implements ISmsCommTask {

	private static Log log = LogFactory.getLog(SmsCommTaskService.class);
	@Autowired
	private SmsCommTaskMapper smsCommTaskMapper;
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsCommTask(List<SmsCommTask> sctlist) throws InsertException {
		// TODO Auto-generated method stub
		int count = 0;
		for (SmsCommTask sct : sctlist) {
			log.debug("******** 进入保存SMSCommTask方法  将要保存的SmsCommTask信息 " + sct.toString() + " ********");
			if (smsCommTaskMapper.insert(sct) <= 0) {
				throw new InsertException("插入结果表不成功   " + sct.toString());
			} else {
				count++;
			}

		}
		if (count < sctlist.size()) {
			throw new InsertException("插入结果表数目不对   " + sctlist.toString());
		}
		return count;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
