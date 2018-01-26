package com.ai.slp.order.service.business.impl;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.order.api.synchronize.params.OrdOdProdVo;
import com.ai.slp.order.api.synchronize.params.OrderSynchronizeVo;
import com.ai.slp.order.constants.OrdersConstants;
import com.ai.slp.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.slp.order.dao.mapper.bo.OrdBalacneIfCriteria;
import com.ai.slp.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.slp.order.dao.mapper.bo.OrdOdFeeTotalCriteria;
import com.ai.slp.order.dao.mapper.bo.OrdOdInvoice;
import com.ai.slp.order.dao.mapper.bo.OrdOdInvoiceCriteria;
import com.ai.slp.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.slp.order.dao.mapper.bo.OrdOdLogisticsCriteria;
import com.ai.slp.order.dao.mapper.bo.OrdOdProd;
import com.ai.slp.order.dao.mapper.bo.OrdOdProdCriteria;
import com.ai.slp.order.dao.mapper.bo.OrdOrder;
import com.ai.slp.order.dao.mapper.bo.OrdOrderCriteria;
import com.ai.slp.order.service.atom.interfaces.ISyncronizeAtomSV;
import com.ai.slp.order.service.business.interfaces.ISyncronizeBusiSV;
import com.ai.slp.order.util.SequenceUtil;
import com.ai.slp.order.util.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.esotericsoftware.minlog.Log;

@Service
@Transactional
public class SyncronizeBusiSVImpl implements ISyncronizeBusiSV {

	@Autowired
	private ISyncronizeAtomSV syncronizeAtomSV;
	
	//同步订单信息
	@Override
	public long orderSynchronize(OrderSynchronizeVo request) throws BusinessException, SystemException {
		ValidateUtils.validateSynchronize(request);
		OrdOrder ordOrder = new OrdOrder();
		OrdOdLogistics ordOdLogistics = new OrdOdLogistics();
		OrdOdInvoice ordOdInvoice = new OrdOdInvoice();
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		OrdBalacneIf ordBalacneIf = new OrdBalacneIf();
		long orderId = SequenceUtil.createOrderId();
		try {
			if (request.getOrdOrderVo() != null) {
				BeanUtils.copyProperties(request.getOrdOrderVo(), ordOrder);
				ordOrder.setTenantId(request.getTenantId());
				ordOrder.setOrderId(orderId);
				ordOrder.setDownstreamOrderId(request.getOrderId()+"");
				// 长虹侧无子订单的概念
				ordOrder.setSubFlag(OrdersConstants.OrdOrder.SubFlag.NO);
				// 状态变化时间
				ordOrder.setStateChgTime(DateUtil.getSysDate());
				ordOrder.setOrderTime(Timestamp.valueOf(request.getOrdOrderVo().getOrderTime()));
				// 客户端显示状态
				ordOrder.setDisplayFlag(OrdersConstants.OrdOrder.DisplayFlag.USER_NORMAL_VISIABLE);
				ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
				OrdOrderCriteria example = new OrdOrderCriteria();
				OrdOrderCriteria.Criteria criteria = example.createCriteria();
				criteria.andTenantIdEqualTo(request.getTenantId());
				criteria.andOrderIdEqualTo(orderId);
				int count = 0;
				count = syncronizeAtomSV.countByExample(example);
				if (count == 0) {
					syncronizeAtomSV.insertSelective(ordOrder);
				} else {
					syncronizeAtomSV.updateByExampleSelective(ordOrder, example);
				}
			}
			if (request.getOrdOdProdList() != null && (!request.getOrdOdProdList().isEmpty())) {
				for (OrdOdProdVo ordOdProdVo : request.getOrdOdProdList()) {
					OrdOdProd ordOdProd = new OrdOdProd();
					BeanUtils.copyProperties(ordOdProdVo, ordOdProd);
					// 订单商品主键
					long prodDetailId = SequenceUtil.createProdDetailId();
					ordOdProd.setTenantId(request.getTenantId());
					ordOdProd.setOrderId(orderId);
					// 标准品id
					ordOdProd.setStandardProdId(OrdersConstants.OrdOdProd.StandProdId.STAND_PROD_ID);
					ordOdProd.setState(OrdersConstants.OrdOdProd.State.SELL);
					ordOdProd.setProdId(OrdersConstants.OrdOdProd.State.PRODID);
					ordOdProd.setProdDetalId(prodDetailId);
					ordOdProd.setProdType(OrdersConstants.OrdOdProd.ProdType.PROD);
					ordOdProd.setValidTime(DateUtil.getSysDate());
					ordOdProd.setUpdateTime(DateUtil.getSysDate());
					OrdOdProdCriteria example = new OrdOdProdCriteria();
					OrdOdProdCriteria.Criteria criteria = example.createCriteria();
					criteria.andTenantIdEqualTo(request.getTenantId());
					criteria.andOrderIdEqualTo(orderId);
					criteria.andProdCodeEqualTo(ordOdProd.getProdCode());
					int count = 0;
					count = syncronizeAtomSV.countByExample(example);
					if (count == 0) {
						syncronizeAtomSV.insertSelective(ordOdProd);
					}
				}

			}
			if (request.getOrdOdLogisticVo() != null) {
				BeanUtils.copyProperties(request.getOrdOdLogisticVo(), ordOdLogistics);
				// 订单物流主键
				ordOdLogistics.setLogisticsId(SequenceUtil.genLogisticsId());
				ordOdLogistics.setTenantId(request.getTenantId());
				ordOdLogistics.setOrderId(orderId);
				OrdOdLogisticsCriteria example = new OrdOdLogisticsCriteria();
				OrdOdLogisticsCriteria.Criteria criteria = example.createCriteria();
				criteria.andTenantIdEqualTo(request.getTenantId());
				criteria.andOrderIdEqualTo(orderId);
				int count = 0;
				count = syncronizeAtomSV.countByExample(example);
				if (count == 0) {
					syncronizeAtomSV.insertSelective(ordOdLogistics);
				} else {
					syncronizeAtomSV.updateByExampleSelective(ordOdLogistics, example);
				}
			}

			if (request.getOrdOdInvoiceVo() != null) {
				BeanUtils.copyProperties(request.getOrdOdInvoiceVo(), ordOdInvoice);
				ordOdInvoice.setTenantId(request.getTenantId());
				ordOdInvoice.setOrderId(orderId);
				OrdOdInvoiceCriteria example = new OrdOdInvoiceCriteria();
				OrdOdInvoiceCriteria.Criteria criteria = example.createCriteria();
				criteria.andTenantIdEqualTo(request.getTenantId());
				criteria.andOrderIdEqualTo(orderId);
				int count = 0;
				count = syncronizeAtomSV.countByExample(example);
				if (count == 0) {
					syncronizeAtomSV.insertSelective(ordOdInvoice);
				} else {
					syncronizeAtomSV.updateByExampleSelective(ordOdInvoice, example);
				}
			}

			if (request.getOrdOdFeeTotalVo() != null) {
				BeanUtils.copyProperties(request.getOrdOdFeeTotalVo(), ordOdFeeTotal);
				// 收退费标识
				ordOdFeeTotal.setTenantId(request.getTenantId());
				ordOdFeeTotal.setOrderId(orderId);
				ordOdFeeTotal.setPayFlag(OrdersConstants.OrdOdFeeTotal.payFlag.IN);
				ordOdFeeTotal.setUpdateTime(DateUtil.getSysDate());
				OrdOdFeeTotalCriteria example = new OrdOdFeeTotalCriteria();
				OrdOdFeeTotalCriteria.Criteria criteria = example.createCriteria();
				criteria.andTenantIdEqualTo(request.getTenantId());
				criteria.andOrderIdEqualTo(orderId);
				int count = 0;
				count = syncronizeAtomSV.countByExample(example);
				if (count == 0) {
					syncronizeAtomSV.insertSelective(ordOdFeeTotal);
				} else {
					syncronizeAtomSV.updateByExampleSelective(ordOdFeeTotal, example);
				}
			}

			if (request.getOrdBalanceIfVo() != null) {
				BeanUtils.copyProperties(request.getOrdBalanceIfVo(), ordBalacneIf);
				// 订单支付主键
				ordBalacneIf.setBalacneIfId(SequenceUtil.createBalacneIfId());
				ordBalacneIf.setTenantId(request.getTenantId());
				ordBalacneIf.setOrderId(orderId);
				ordBalacneIf.setCreateTime(DateUtil.getSysDate());
				OrdBalacneIfCriteria example = new OrdBalacneIfCriteria();
				OrdBalacneIfCriteria.Criteria criteria = example.createCriteria();
				criteria.andTenantIdEqualTo(request.getTenantId());
				criteria.andOrderIdEqualTo(orderId);
				int count = 0;
				count = syncronizeAtomSV.updateByExampleSelective(ordBalacneIf, example);
				if (count == 0) {
					syncronizeAtomSV.insertSelective(ordBalacneIf);
				} else {
					syncronizeAtomSV.updateByExampleSelective(ordBalacneIf, example);
				}
			}

		} catch (Exception e) {
			Log.error("同步订单数据失败:syncronize fail:" + DateUtil.getSysDate() + ":原因:" + JSON.toJSONString(e));
			throw new BusinessException("同步失败");
		}
		return orderId;
	}

}
