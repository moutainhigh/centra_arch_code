package com.ai.slp.user.service.business.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sdk.util.UUIDUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.user.api.register.param.RegisterParamsRequest;
import com.ai.slp.user.api.register.param.UcBankKeyInfoParams;
import com.ai.slp.user.api.register.param.UcContactInfoParams;
import com.ai.slp.user.api.register.param.UcCustKeyInfoParams;
import com.ai.slp.user.api.register.param.UcGroupKeyInfoParams;
import com.ai.slp.user.api.register.param.UcUserParams;
import com.ai.slp.user.constants.ExceptCodeConstants;
import com.ai.slp.user.constants.UcUserConstants.Account;
import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserAgree;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.service.atom.interfaces.IRegisterAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcBankInfoAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcContactsInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IRegisterBusiSV;
import com.ai.slp.user.util.SequenceUtil;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class RegisterBusiSVImpl implements IRegisterBusiSV {

    private static final Log LOG = LogFactory.getLog(RegisterBusiSVImpl.class);
    @Autowired
    public IRegisterAtomSV registerAtomSv;
    
    @Autowired
    public IUcContactsInfoAtomSV iUcContactsInfoAtomSV;
    
    @Autowired
    public IUcBankInfoAtomSV iUcBankInfoAtomSV;
    
    /**
     * 个人用户、企业注册、代理商、供应商注册
     */
    
    @Override
    public String insertUserInfo(RegisterParamsRequest registerParamsRequest) {
            UcUserParams userParams = registerParamsRequest.getUcUserParam();
            List<UcUser> list = getUserInfoBycondition(userParams);
            if(!CollectionUtil.isEmpty(list)){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "账户不唯一");
            }
            UcUser ucUser = new UcUser();
            if(userParams==null){
                throw new BusinessException("ACCOUNT_SET_INFO_CHECK_FAILED","注册失败,请输入用户信息");
            }
            
            //插入user主表
            String userId = SequenceUtil.createUserId();
            userParams.setUserId(userId);
            userParams.setTenantId("SLP");
            userParams.setUserLoginName(userParams.getUserLoginName().toLowerCase());
            //用户信息
            BeanUtils.copyProperties(ucUser, userParams);
           
            ucUser.setUserState(ExceptCodeConstants.Account.REGISTER_STATE);
            registerAtomSv.insertUserInfo(ucUser);
             
            //用户状态变更
            insertUserStateChg(userParams,ExceptCodeConstants.Account.REGISTER_STATE);
            
            //个人用户注册需要添加一个有注册转变为正常状态的记录
            if(ExceptCodeConstants.Account.REGISTER_STATE.equals(userParams.getUserType())){
                insertUserStateChg(userParams,ExceptCodeConstants.Account.REGISTER_STATE);
            }
            
            //插入用户协议表
            String agreementId = SequenceUtil.createAgreeSeqId();
            UcUserAgree ucUserAgree = new UcUserAgree();
            ucUserAgree.setUserId(userParams.getUserId());
            ucUserAgree.setAgreementId(agreementId);
            ucUserAgree.setTenantId(userParams.getTenantId());
            ucUserAgree.setAgreeSeqId(agreementId);
            registerAtomSv.InsertUcUserAgreeAtomSv(ucUserAgree);
          
            //创建支付密码账户
            RegAccReq vo = new RegAccReq();
            vo.setExternalId(UUIDUtil.genId32());// 外部流水号ID
            vo.setSystemId("SLP-UAC_WEB");// 系统ID
            vo.setTenantId(Account.TENANT_ID);// 租户ID
            vo.setRegCustomerId(userId);
            vo.setAcctName(userParams.getUserLoginName());
            vo.setAcctType("0");// 账户类型， 0 后付费
            vo.setRegType("1");//注册方式网站注册
            vo.setPayType("2");// 支付方式
            IAccountMaintainSV accountMaintainSV = DubboConsumerFactory.getService(IAccountMaintainSV.class);
            try {
               accountMaintainSV.createAccount(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return userId;
            
    }
    /**
     * 获取用户信息
     */
    @Override
    public boolean checkUserExist(UcUserParams userParams) {
        List<UcUser> list = getUserInfoBycondition(userParams);
        boolean flag = list!=null&&list.size()>0?false:true;
        return flag;
    }
    
    /**
     * 企业用户名或者手机号是不是唯一
     */
    @Override
    public boolean checkUcGroupKeyExist(UcGroupKeyInfoParams ucGroupKeyInfoParams){
        boolean flag = false;
        /**
         * 用户名或者手机号是不是唯一
         */
        UcGroupKeyInfoCriteria example =  new UcGroupKeyInfoCriteria();
        UcGroupKeyInfoCriteria.Criteria criteria = example.createCriteria();
        if(!StringUtil.isBlank(ucGroupKeyInfoParams.getCustName())){
            criteria.andCustNameEqualTo(ucGroupKeyInfoParams.getCustName());
        }
        List<UcGroupKeyInfo> list = registerAtomSv.getUcGroupKeyInfo(example);
        /**
         * list.size()>0说明用户名或者手机不唯一，返回false
         */
        flag = list!=null&&list.size()>0?false:true;
        
        return flag;
    }
    
    
    /**
     * 企业资质认证(企业注册后台)
     */
    @Override
    public void insertCompanyInfoAttest(RegisterParamsRequest registerParamsRequest) {
        
            /**
             * 获取当前用户信息
             */
            UcUserParams userParams = registerParamsRequest.getUcUserParam();
            List<UcUser> list = getUserInfoBycondition(userParams);
            
            if(CollectionUtil.isEmpty(list)){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            //企业客户关键信息表
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            UcGroupKeyInfoParams ucGroupKeyInfoParams = registerParamsRequest.getUcGroupKeyInfoParams();
            if(ucGroupKeyInfoParams==null){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入企业客户信息");
            }
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            ucGroupKeyInfo.setUserId(userId);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            
            //用户联系人表
            UcContactsInfo ucContactsInfo = new UcContactsInfo();
            ucContactsInfo.setUserId(userId);
            UcContactInfoParams ucContactInfoParams = registerParamsRequest.getUcContactInfoParams();
            if(ucContactInfoParams==null){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入企业客户信息");
            }
            BeanUtils.copyProperties(ucContactsInfo, ucContactInfoParams);
            registerAtomSv.insertUcContactsInfo(ucContactsInfo);
            
            //用户状态变更
            insertUserStateChg(userParams,ExceptCodeConstants.Account.REGISTER_STATE);
            
            
    }
    
    /**
     * 代理商资质认证
     */
    @Override
    public void insertAgentInfoAttest(RegisterParamsRequest registerParamsRequest) {
            /**
             * 获取当前用户信息
             */
            UcUserParams userParams = registerParamsRequest.getUcUserParam();
            List<UcUser> list = getUserInfoBycondition(userParams);
            if(CollectionUtil.isEmpty(list)&&list.size()==0){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            //企业客户关键信息表
            UcGroupKeyInfoParams ucGroupKeyInfoParams = registerParamsRequest.getUcGroupKeyInfoParams();
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            if(ucGroupKeyInfoParams==null){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            ucGroupKeyInfo.setUserId(userId);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            
            //用户联系人表
            UcContactsInfo ucContactsInfo = new UcContactsInfo();
            UcContactInfoParams ucContactInfoParams = registerParamsRequest.getUcContactInfoParams();
            ucContactsInfo.setUserId(userId);
            if(ucContactInfoParams==null){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            BeanUtils.copyProperties(ucContactsInfo, ucContactInfoParams);
            registerAtomSv.insertUcContactsInfo(ucContactsInfo);
            
            //用户银行信息
            UcBankInfo ucBankInfo = new UcBankInfo();
            ucBankInfo.setUserId(userId);
            UcBankKeyInfoParams ucBankKeyInfoParam = registerParamsRequest.getUcBankKeyParams();
            if(ucBankKeyInfoParam==null){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            BeanUtils.copyProperties(ucBankInfo, ucBankKeyInfoParam);
            
            //用户状态变更
            insertUserStateChg(userParams,ExceptCodeConstants.Account.REGISTER_STATE);
            
    }
    
    
    /**
     * 个人认证
     * @param userParams
     * @param ucCustKeyInfpParam
     * @param ucBackInfo
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    @Override
    public void insertUserInfoAttest(RegisterParamsRequest registerParamsRequest){
       
            /**
             * 获取当前用户信息
             */
            UcUserParams userParams = registerParamsRequest.getUcUserParam();
            List<UcUser> list = getUserInfoBycondition(userParams);
            if(CollectionUtil.isEmpty(list)||list.size()==0){
                throw new BusinessException("ACCOUNT_NOT_FOUND", "账户资料验证失败");
            }
            String userId = list.get(0).getUserId();
            userParams.setUserId(userId);
            
            UcCustKeyInfo ucCustKeyInfo = new UcCustKeyInfo();
            ucCustKeyInfo.setUserId(userId);
            UcCustKeyInfoParams ucCustKeyInfpParam = registerParamsRequest.getUcCustKeyInfoParams();
            if(ucCustKeyInfpParam==null){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入客户信息");
            }
            BeanUtils.copyProperties(ucCustKeyInfo, ucCustKeyInfpParam);
            registerAtomSv.insertUcCustKeyInfo(ucCustKeyInfo);
        
    }
    
    
    /**
     * 供货商申请注册
     * @param userParams
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    public void inertProviderInfo(RegisterParamsRequest registerParamsRequest){
        
            //企业客户关键信息表
            UcGroupKeyInfo ucGroupKeyInfo = new UcGroupKeyInfo();
            UcUserParams userParams = registerParamsRequest.getUcUserParam();
            ucGroupKeyInfo.setUserId(userParams.getUserId());
            UcGroupKeyInfoParams ucGroupKeyInfoParams = registerParamsRequest.getUcGroupKeyInfoParams();
            if(ucGroupKeyInfoParams==null){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入供应商信息");
            }
            BeanUtils.copyProperties(ucGroupKeyInfo, ucGroupKeyInfoParams);
            registerAtomSv.insertUcGroupKeyInfo(ucGroupKeyInfo);
            
            //缺少供应产品信息
            
            //用户状态变更
            insertUserStateChg(userParams,ExceptCodeConstants.Account.REGISTER_STATE);
            
    }
    
    public List<UcUser>  getUserInfoBycondition(UcUserParams userParams){
        /**
         * 用户名、手机号、邮箱是不是唯一
         */
        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();
        if(!StringUtils.isBlank(userParams.getUserMp())){
            criteria.andUserTypeEqualTo(userParams.getUserType());
            criteria.andUserMpEqualTo(userParams.getUserMp());
        }
        if(!StringUtils.isBlank(userParams.getUserLoginName())){
            criteria.andUserTypeEqualTo(userParams.getUserType());
            criteria.andUserLoginNameEqualTo(userParams.getUserLoginName());
        }
        if(!StringUtils.isBlank(userParams.getUserEmail())){
            criteria.andUserTypeEqualTo(userParams.getUserType());
            criteria.andUserEmailEqualTo(userParams.getUserEmail());
        }
        List<UcUser> list = registerAtomSv.getUserInfo(example);
        
        return list;
    }
  
    /**
     * 用户轨迹状态变化方法
     * @param userParams
     * @return
     * @author zhangyh7
     * @ApiDocMethod
     */
    public int insertUserStateChg(UcUserParams userParams,String state){
        UcStateChg ucStateChgRegister = new UcStateChg();
        ucStateChgRegister.setTenantId(userParams.getTenantId());
        ucStateChgRegister.setUserId(userParams.getUserId());
        ucStateChgRegister.setOperType(userParams.getUserType());
        ucStateChgRegister.setStateChgId("1");
        ucStateChgRegister.setNewState(state);
        ucStateChgRegister.setChgTime(new Timestamp(new Date().getTime()));
        return registerAtomSv.insertUcStateChgBusiInfo(ucStateChgRegister);
    }
    
   /* @Override
    public void updateUserInfo(UpdateUserParams updateUserParams){
        
        if(updateUserParams==null){
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入用户信息");
        }
        *//*************更新用户基本信息*********************//*
        UcUserParams ucUserParams = updateUserParams.getUcUserParams();
        if(ucUserParams ==null){
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "用户基本信息为空信息为空，更新失败");
        }else{
            //校验用户名、邮箱、手机号码
            List<UcUser> list = getUserInfoBycondition(ucUserParams);
            boolean valide =CollectionUtil.isEmpty(list)&&list.size()>0?false:true;
            if(valide){
                //根据用户id判断是否是当前用户如果不是当前用户 则表示用户名、邮箱、手机号码重复
                boolean uservalide = false;
                for(UcUser user :list){
                    if(!user.getUserId().equals(ucUserParams.getUserId())){
                        uservalide = true ;
                    }
                }
                if(uservalide){
                    throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED, "请输入有效信息");
                }
            }
            UcUser record = new UcUser();
            BeanUtils.copyProperties(record, ucUserParams);
            UcUserCriteria example = new UcUserCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                                       .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateUserInfo(record, example);
        }
        //更新用户个人详细信息
        UcCustKeyInfoParams ucCustKey = updateUserParams.getUcCustKeyInfoParams();
        if(ucCustKey!=null){
            UcCustKeyInfo record = new UcCustKeyInfo();
            BeanUtils.copyProperties(record, ucCustKey);
            UcCustKeyInfoCriteria example = new UcCustKeyInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                                       .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateCustKeyInfo(record, example);
        }
        //更新企业信息
        UcGroupKeyInfoParams  ucGroupKeyInfoParams  = updateUserParams.getUcGroupKeyInfoParams();
        if(ucGroupKeyInfoParams!=null ){
            UcGroupKeyInfo record = new UcGroupKeyInfo();
            BeanUtils.copyProperties(record, ucGroupKeyInfoParams);
            UcGroupKeyInfoCriteria example = new UcGroupKeyInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                            .andTenantIdEqualTo(record.getTenantId());
            registerAtomSv.updateGroupKeyInfo(record, example);
        }
        //更新用户联系人信息
        UcContactInfoParams ucContactInfoParams  = updateUserParams.getUcContactInfoParams();
        if(ucContactInfoParams!=null){
            UcContactsInfo record = new UcContactsInfo();
            BeanUtils.copyProperties(record, ucContactInfoParams);
            UcContactsInfoCriteria example = new UcContactsInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
                                            .andTenantIdEqualTo(record.getTenantId());
            iUcContactsInfoAtomSV.updateByExampleSelective(record, example);
        }
        //更新用户银行信息
        UcBankKeyInfoParams ucBankKeyParams = updateUserParams.getUcBankKeyParams();
        if(ucBankKeyParams!=null){
            UcBankInfo record = new UcBankInfo();
            BeanUtils.copyProperties(record, ucBankKeyParams);
            UcBankInfoCriteria example = new UcBankInfoCriteria();
            example.createCriteria().andUserIdEqualTo(record.getUserId())
            .andTenantIdEqualTo(record.getTenantId());
            iUcBankInfoAtomSV.updateByExampleSelective(record, example);
        }
    }*/
}
