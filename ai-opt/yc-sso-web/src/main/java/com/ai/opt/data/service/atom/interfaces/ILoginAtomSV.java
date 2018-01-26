package com.ai.opt.data.service.atom.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.api.user.param.ContinueLoginLogResponse;
import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcMembers;

public interface ILoginAtomSV {
	UcMembers queryByUserName(UcMembers ucMembers) throws SystemException;
	/**
	 * 通过用户名/手机号/邮箱 查询用户
	 * @param loginname
	 * @return
	 * @throws SystemException
	 * @author gucl
	 */
	UcMembers queryByUserNamePhoneEmail(String loginname) throws SystemException;
	
	/**
	 * 插入第三方登录的用户信息
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
	 */
	String insertThirdUser(UcMembers ucMembers) throws BusinessException,SystemException;
	/**
	 * 查询第三方登录的用户信息（依据usersource和thirduid查询）
	 * @param usersource 用户来源.<br>
	 *  0	内部用户（默认）<br>
	 *	1	金山账号<br>
	 *	2	百度账号<br>
	 *	3	qq账号<br>
	 *	4	预留<br>
	 *	5	预留<br>
	 *	6	新浪账号<br>
	 *	7	微信账号<br>

	 *  
	 * @param thirduid  第三方系统用户ID
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
	 */
	UcMembers queryThirdUser(String usersource,String thirduid) throws BusinessException,SystemException;
	
	/**
	 * 插入第三方登录的用户信息
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
	 */
	String saveUserByMobileLogin(UcMembers ucMembers) throws BusinessException,SystemException;
	
	/**
	 * 登陆日志(登陆送积分,登陆送成长值)
	 * @param loginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String insertLoginlog(LoginLog loginLog) throws BusinessException, SystemException;
	
	/**
	 * 更新最后登陆时间
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String updateUcMembers(UcMembers ucMembers) throws BusinessException, SystemException;
	
	/**
	 * 查询日志
	 * @param loginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	int queryLoginLogByExample(LoginLog loginLog) throws BusinessException, SystemException;
	
	/**
	 * 插入记录连续天数
	 * @param continueLoginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String insertUcContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException, SystemException;
	
	/**
	 * 更新记录连续天数
	 * @param continueLoginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String updateContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException, SystemException;
	
	/**
	 * 查询连续登陆天数
	 * @param continueLoginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	ContinueLoginLogResponse queryContinueLoginLogByExample(UcContinueLoginLog continueLoginLog) throws BusinessException, SystemException;

	/**
	 * 查询连续登陆天数
	 * @param uid
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	UcContinueLoginLog queryContinueLoginLogByUid(Integer uid) throws BusinessException, SystemException;
}
