package com.ai.opt.data.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.api.user.param.ContinueLoginLogResponse;
import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcMembers;

public interface ILoginBusiSV {
	UcMembers queryByUserName(UcMembers user) throws BusinessException;
	UcMembers queryByUserNamePhoneEmail(String loginname) throws BusinessException;
	
	/**
	 * 插入第三方登录的用户信息
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
	 */
	String saveThirdUser(UcMembers ucMembers) throws BusinessException,SystemException;
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
	 * 插入手机快速登录的用户信息
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 */
	String saveUserByMobileLogin(UcMembers ucMembers) throws BusinessException,SystemException;
	
	/**
	 * 插入登陆日志
	 * @param loginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String saveLoginLog(LoginLog loginLog) throws BusinessException,SystemException;
	
	/**
	 * 更新用户最后登陆时间
	 * @param ucMembers
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String updateUcMembers(UcMembers ucMembers) throws BusinessException, SystemException;
	
	/**
	 * 查询登陆日志(根据用户id 登陆日期)
	 * @param loginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	int queryLoginLog(LoginLog loginLog) throws BusinessException,SystemException;
	
	/**
	 * 插入记录连续登陆天数
	 * @param continueLoginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String saveContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException,SystemException;

	/**
	 * 更新记录连续登陆天数
	 * @param continueLoginLog
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	String updateContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException,SystemException;
	
	/**
	 * 查询连续登陆天数
	 * @param uid
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	UcContinueLoginLog queryContinueLoginLog(Integer uid) throws BusinessException,SystemException;
	
}
