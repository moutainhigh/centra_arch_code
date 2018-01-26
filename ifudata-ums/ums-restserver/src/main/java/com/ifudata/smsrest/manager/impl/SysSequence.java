package com.ifudata.smsrest.manager.impl;

import com.ifudata.smsrest.db.mapper.bo.SysSequenceCredit;
import com.ifudata.smsrest.manager.ISysSequenceCredit;
import com.ifudata.smsrest.db.interfaces.SysSequenceCreditMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsj on 2015/9/27.
 */
public class SysSequence implements ISysSequenceCredit {
	private static Log log = LogFactory.getLog(SysSequence.class);
	@Autowired
	private SysSequenceCreditMapper sysSequenceCreditMapper;
	private SqlSessionTemplate sqlSessionTemplate;
	private static SysSequence ourInstance = new SysSequence();

	public static SysSequence getInstance() {
		if (ourInstance == null) {
			ourInstance = new SysSequence();
		}
		return ourInstance;
	}

	private SysSequence() {

	}

	@Transactional(rollbackFor = Exception.class)
	public List<Long> getSequence(String name, int nCount) throws Exception {
		List<Long> longList = new ArrayList<>();
		long currvalue;
		long nextvalue;

		SysSequenceCredit sequence = sysSequenceCreditMapper.selectByPrimaryKey(name);

		if (sequence == null) {
			log.error("序列名[" + name + "]没有定义,请对表sys_sequence_credit进行维护");
			throw new Exception("序列名[" + name + "]没有定义,请对表sys_sequence_credit进行维护");
		}
		// 获取当前值
		currvalue = sequence.getCurrentValue();
		nextvalue = currvalue + nCount;
		sequence.setCurrentValue(nextvalue);

		int nRet = sysSequenceCreditMapper.updateByPrimaryKey(sequence);

		if (nRet <= 0) {
			log.error("序列[" + name + "更新异常");
			throw new Exception("序列[" + name + "更新异常");
		}

		for (long l = currvalue; l < nextvalue; l++) {
			longList.add(l);
		}
		return longList;
	}

	@Transactional(rollbackFor = Exception.class)
	public Long getSequence(String name) throws Exception {
		List<Long> longList = getSequence(name, 1);
		if ((longList == null) || (longList.isEmpty())) {
			log.error("获取序列异常");
			throw new Exception("获取序列异常");
		}
		return longList.get(0);
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.sqlSessionTemplate = session;
	}
}
