package com.ifudata.centra.sdk.dubbo.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.centra.sdk.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.base.vo.BaseResponse;
import com.ifudata.centra.base.vo.ResponseHeader;

@Activate(group = { Constants.PROVIDER })
public class DubboRequestTrackFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(DubboRequestTrackFilter.class);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        String protocol = invoker.getUrl().getProtocol();
        String reqSV = invoker.getInterface().getName();
        String reqMethod = invocation.getMethodName();
        Object[] requestParams = invocation.getArguments();
        List<Class> paramClazz = null;
        if (requestParams != null) {
            paramClazz = new ArrayList<Class>();
            for (Object param : requestParams) {
                paramClazz.add(param.getClass());
            }
        }
        Class returnClazz = null;
        try {
            Method method = invoker.getInterface().getMethod(reqMethod,
                    paramClazz == null ? null : paramClazz.toArray(new Class[paramClazz.size()]));
            returnClazz = method.getReturnType();
        } catch (NoSuchMethodException | SecurityException e1) {
            LOG.error("获取方法的返回类型失败，具体原因：" + e1.getMessage(), e1);
        }

        // 交易序列
        String tradeSeq = UUIDUtil.genId32();
        // 打印请求参数明细
        if (CollectionUtil.isEmpty(requestParams)) {
            if (LOG.isInfoEnabled()) {
                LOG.info("TRADE_SEQ:{},请求接口:{},请求方法:{},请求参数:{}", tradeSeq, reqSV, reqMethod, "");
            }
        } else {
            if (LOG.isInfoEnabled()) {
                LOG.info("TRADE_SEQ:{},请求接口:{},请求方法:{},请求参数:{}", tradeSeq, reqSV, reqMethod,
                        JSON.toJSONString(requestParams));
            }
        }
        // 执行结果
        Result result = null;
        try {
            if (LOG.isInfoEnabled()) {
                LOG.info("TRADE_SEQ:{},执行调用服务{}类中的{}方法", tradeSeq, reqSV, reqMethod);
            }
            result = invoker.invoke(invocation);
            if (result.hasException()) {
                Throwable e = result.getException();
                if (LOG.isErrorEnabled()) {
                    LOG.error("TRADE_SEQ:{},调用服务{}类中的{}方法发生异常，原因:{}", tradeSeq, reqSV, reqMethod,
                            result.getException().getMessage(), result.getException());
                }

                // rest的情况下，不抛出异常
                if (null != protocol && "rest".equalsIgnoreCase(protocol)) {

                    BaseResponse response = new BaseResponse();
                    ResponseHeader header = new ResponseHeader(false, "999999", e.getMessage(),
                            Arrays.toString(e.getStackTrace()));
                    if (e instanceof BusinessException) {
                        BusinessException ex = (BusinessException) e;
                        header.setResultCode(ex.getErrorCode());
                    } else if (e instanceof SystemException) {
                        SystemException ex = (SystemException) e;
                        header.setResultCode(ex.getErrorCode());
                    }

                    response.setResponseHeader(header);
                    RpcResult r = new RpcResult();
                    Gson gson = new Gson();
                    r.setValue(gson.fromJson(gson.toJson(response), returnClazz));
                    return r;
                }
                // dubbo情况下，抛出异常
                else {
                    if (e instanceof BusinessException) {
                        BaseResponse response = new BaseResponse();
                        response.setResponseHeader(
                                new ResponseHeader(false, ((BusinessException) e).getErrorCode(),
                                        ((BusinessException) e).getErrorMessage()));
                        RpcResult r = new RpcResult();
                        r.setValue(response);
                        return r;
                    } else if (e instanceof SystemException) {
                        throw (SystemException) e;
                    } else {
                        throw new SystemException(e.getMessage(), e);
                    }
                }

            }
            if (LOG.isInfoEnabled()) {
                LOG.info("TRADE_SEQ:{},调用服务{}类中的{}方法的结果:{}", tradeSeq, reqSV, reqMethod,
                        JSON.toJSONString(result.getValue()));
            }
            return result;
        } catch (Exception ex) {
            if (LOG.isErrorEnabled()) {
                LOG.error("TRADE_SEQ:{},执行{}类中的{}方法发生异常:{}", tradeSeq, reqSV, reqMethod, ex);
            }
            if (null != protocol && protocol.equalsIgnoreCase("rest")) {

                BaseResponse response = new BaseResponse();
                response.setResponseHeader(
                        new ResponseHeader(false, "999999", ex.getMessage(), Arrays.toString(ex.getStackTrace())));
                RpcResult r = new RpcResult();
                Gson gson = new Gson();
                r.setValue(gson.fromJson(gson.toJson(response), returnClazz));
                return r;
            }
            RpcResult r = new RpcResult();

            r.setException(ex);
            return r;
        }

    }

}
