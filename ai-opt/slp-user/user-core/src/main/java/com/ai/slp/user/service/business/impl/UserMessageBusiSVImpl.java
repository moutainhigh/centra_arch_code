package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.message.param.DeleteMessageRequest;
import com.ai.slp.user.api.message.param.InsertUserMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageResponse;
import com.ai.slp.user.api.message.param.UpdateMessageRequest;
import com.ai.slp.user.api.message.param.UserMessageParams;
import com.ai.slp.user.constants.OperMessageCodeConstants;
import com.ai.slp.user.dao.mapper.bo.UcUserMessage;
import com.ai.slp.user.dao.mapper.bo.UcUserMessageCriteria;
import com.ai.slp.user.service.atom.interfaces.IUserMessageAtomSV;
import com.ai.slp.user.service.business.interfaces.IUserFavoriteBusiSV;
import com.ai.slp.user.service.business.interfaces.IUserMessageBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;
import com.alibaba.dubbo.common.utils.StringUtils;

@Service
@Transactional
public class UserMessageBusiSVImpl implements IUserMessageBusiSV {

    private static final Log LOG = LogFactory.getLog(IUserFavoriteBusiSV.class);

    @Autowired
    private IUserMessageAtomSV userMessageAtomSV;

    @Override
    public BaseResponse insertUserMessage(InsertUserMessageRequest messageRequest)
            throws BusinessException, SystemException {
        UcUserMessage ucUserMessage = new UcUserMessage();
        ucUserMessage.setInfoSeqId(SequenceUtil.createInfoSeqId());
        BeanUtils.copyProperties(messageRequest, ucUserMessage);
        ucUserMessage.setCreateTime(DateUtils.currTimeStamp());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userMessageAtomSV.insert(ucUserMessage);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateUserMessage(UpdateMessageRequest request)
            throws BusinessException, SystemException {

        UcUserMessageCriteria example = new UcUserMessageCriteria();
        UcUserMessageCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        UcUserMessage ucUserMessage = new UcUserMessage();
        BaseResponse response = new BaseResponse();

        // 判断更新read flag还是更新state
        if (request.getOperCode().equals(OperMessageCodeConstants.DELETE)) {
            if (!StringUtils.isBlank(request.getOperId())) {
                criteria.andInfoSeqIdEqualTo(request.getOperId());
            }
            ucUserMessage.setUpdateTime(DateUtils.currTimeStamp());
            ucUserMessage.setState("11");

        }
        if (request.getOperCode().equals(OperMessageCodeConstants.UPDATE)) {
            if (!StringUtils.isBlank(request.getOperId())) {
                criteria.andInfoSeqIdEqualTo(request.getOperId());
            }
            ucUserMessage.setReadTime(DateUtils.currTimeStamp());
            ucUserMessage.setReadFlag("10");
        }
        response = updateMessageSingle(ucUserMessage, example);
        return response;
    }

    public BaseResponse updateMessageSingle(UcUserMessage ucUserMessage,
            UcUserMessageCriteria example) {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userMessageAtomSV.updateByExampleSelective(ucUserMessage, example);
            responseHeader = new ResponseHeader(true, "success", "更新成功");
        } catch (Exception e) {
            LOG.error("更新操作失败", e);
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public QueryMessageResponse queryUserMessage(QueryMessageRequest queryRequest)
            throws BusinessException, SystemException {
        UcUserMessageCriteria example = new UcUserMessageCriteria();
        UcUserMessageCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(queryRequest.getTenantId());
        criteria.andUserIdEqualTo(queryRequest.getUserId());
        // 判断查询条件
        if (!StringUtils.isBlank(queryRequest.getInfoType())) {
            criteria.andInfoTypeEqualTo(queryRequest.getInfoType());
        } else {
            if (!StringUtils.isBlank(queryRequest.getReadFlag())) {
                criteria.andReadFlagEqualTo(queryRequest.getReadFlag());
            }
        }
        List<UcUserMessage> list = new ArrayList<UcUserMessage>();
        int count = 0;
        Integer pageNo = queryRequest.getPageNo();
        Integer pageSize = queryRequest.getPageSize();
        ResponseHeader responseHeader;
        try {
            count = userMessageAtomSV.countByExample(example);
            list = userMessageAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        PageInfo<UserMessageParams> pageInfo = new PageInfo<UserMessageParams>();
        List<UserMessageParams> responseList = new ArrayList<UserMessageParams>();
        QueryMessageResponse response = new QueryMessageResponse();
        for (UcUserMessage ucUserMessage : list) {
            UserMessageParams userMessageParams = new UserMessageParams();
            BeanUtils.copyProperties(ucUserMessage, userMessageParams);
            responseList.add(userMessageParams);
        }
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setResult(responseList);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse deleteMessage(DeleteMessageRequest deleteRequest)
            throws BusinessException, SystemException {
        UcUserMessageCriteria example = new UcUserMessageCriteria();
        UcUserMessageCriteria.Criteria criteria = example.createCriteria();

        criteria.andTenantIdEqualTo(deleteRequest.getTenantId());
        criteria.andUserIdEqualTo(deleteRequest.getUserId());
        criteria.andInfoSeqIdIn(deleteRequest.getList());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userMessageAtomSV.deleteByExample(example);
            responseHeader = new ResponseHeader(true, "success", "删除成功");
        } catch (Exception e) {
            LOG.error("删除操作失败", e);
            responseHeader = new ResponseHeader(false, "fail", "删除失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

}
