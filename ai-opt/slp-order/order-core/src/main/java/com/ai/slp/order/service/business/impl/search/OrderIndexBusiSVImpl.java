package com.ai.slp.order.service.business.impl.search;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.search.ISearchClient;
import com.ai.paas.ipaas.search.vo.Result;
import com.ai.paas.ipaas.search.vo.SearchCriteria;
import com.ai.platform.common.api.cache.interfaces.ICacheSV;
import com.ai.platform.common.api.cache.param.SysParam;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListRequest;
import com.ai.slp.order.api.sesdata.param.SesDataByPageRequest;
import com.ai.slp.order.api.sesdata.param.SesDataRequest;
import com.ai.slp.order.api.sesdata.param.SesDataResponse;
import com.ai.slp.order.constants.OrdersConstants;
import com.ai.slp.order.constants.SearchConstants;
import com.ai.slp.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.slp.order.dao.mapper.bo.OrdOdFeeProd;
import com.ai.slp.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.slp.order.dao.mapper.bo.OrdOdInvoice;
import com.ai.slp.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.slp.order.dao.mapper.bo.OrdOdProd;
import com.ai.slp.order.dao.mapper.bo.OrdOrder;
import com.ai.slp.order.manager.ESClientManager;
import com.ai.slp.order.search.bo.OrdProdExtend;
import com.ai.slp.order.search.bo.OrderInfo;
import com.ai.slp.order.search.bo.ProdInfo;
import com.ai.slp.order.search.dto.SearchCriteriaStructure;
import com.ai.slp.order.service.atom.interfaces.IOrdBalacneIfAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOdFeeProdAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOdInvoiceAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.slp.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.slp.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.slp.order.service.business.interfaces.search.IOrderSearch;
import com.ai.slp.order.util.InfoTranslateUtil;
import com.alibaba.fastjson.JSON;


@Service
public class OrderIndexBusiSVImpl implements IOrderIndexBusiSV {
	
	private static Logger logger=LoggerFactory.getLogger(OrderIndexBusiSVImpl.class);

	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	@Autowired
	private IOrdOdLogisticsAtomSV ordOdLogisticsAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeProdAtomSV ordOdFeeProdAtomSV;
	@Autowired
	private IOrdOdInvoiceAtomSV ordOdInvoiceAtomSV;
	@Autowired
	private IOrdBalacneIfAtomSV ordBalacneIfAtomSV;
	
	/**
	 * 刷新数据--订单同步
	 */
	@Override
    @Transactional
	public void orderSynchDataToSes(SesDataRequest request) throws BusinessException, SystemException {
			//参数校验
		List<OrderInfo> orderList = new ArrayList<OrderInfo>();
		OrderInfo ordInfo = new OrderInfo();
			try{
			if(request==null) {
				throw new BusinessException("参数对象不能为空");
			}
			ICacheSV iCacheSV = DubboConsumerFactory.getService(ICacheSV.class);
		 	long orderId = request.getOrderId();
			//订单同步数据
			OrdOrder ord = ordOrderAtomSV.selectByPrimaryKey(orderId);
			if(ord!=null) {
				String tenantId = ord.getTenantId();
				ordInfo.setPorderid(orderId);
				ordInfo.setUserid(ord.getUserId());
				ordInfo.setUsername(ord.getUserName());
				ordInfo.setUsertel(ord.getUserTel());
				ordInfo.setFlag(ord.getFlag());
				ordInfo.setDeliveryflag(ord.getDeliveryFlag());
				//翻译是否需要物流
				ordInfo.setOrdertime(ord.getOrderTime());
				ordInfo.setParentorderstate(ord.getState());
				ordInfo.setSupplierid(ord.getSupplierId());
				ordInfo.setIfwarning(ord.getIfWarning());
				ordInfo.setWarningtype(ord.getWarningType());
				ordInfo.setChlid(ord.getChlId());
				ordInfo.setAccountid(ord.getAccountId());
				ordInfo.setToken(ord.getTokenId());
				ordInfo.setDownstreamorderid(ord.getDownstreamOrderId());
				ordInfo.setOrdertype(ord.getOrderType());
				// 获取物流信息
				OrdOdLogistics ordOdLogistics = ordOdLogisticsAtomSV.selectByOrd(tenantId, orderId);
				if(ordOdLogistics!=null) {
					ordInfo.setContacttel(ordOdLogistics.getContactTel());
					ordInfo.setExpressoddnumber(ordOdLogistics.getExpressOddNumber());
					ordInfo.setContactcompany(ordOdLogistics.getContactCompany());
					ordInfo.setContactname(ordOdLogistics.getContactName());
					ordInfo.setLogisticstype(ordOdLogistics.getLogisticsType());
					ordInfo.setProvincecode(ordOdLogistics.getProvinceCode() == null ? ""
							: iCacheSV.getAreaName(ordOdLogistics.getProvinceCode()));
					ordInfo.setCitycode(ordOdLogistics.getCityCode() == null ? ""
							: iCacheSV.getAreaName(ordOdLogistics.getCityCode()));
					ordInfo.setCountycode(ordOdLogistics.getCountyCode() == null ? ""
							: iCacheSV.getAreaName(ordOdLogistics.getCountyCode()));
					ordInfo.setPostcode(ordOdLogistics.getPostcode());
					ordInfo.setAreacode(ordOdLogistics.getAreaCode() == null ? ""
							: iCacheSV.getAreaName(ordOdLogistics.getAreaCode()));
					ordInfo.setAddress(ordOdLogistics.getAddress());
					ordInfo.setExpressid(ordOdLogistics.getExpressId());
				}
				// 查询费用信息
				OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.selectByOrderId(tenantId, orderId);
				if (ordOdFeeTotal != null) {
					//存在情况下
					ordInfo.setDiscountfee(ordOdFeeTotal.getDiscountFee());
					ordInfo.setAdjustfee(ordOdFeeTotal.getAdjustFee());
					ordInfo.setPaystyle(ordOdFeeTotal.getPayStyle());
				}
				// 查询订单其它信息
				ordInfo = this.ordProdExtendsSynch(ordInfo, ord, 
						iCacheSV, orderId,ordOdFeeTotal);
			}
			}catch(Exception e){
				logger.error("组装订单信息发生异常:"+JSON.toJSONString(e));
			}
			orderList.add(ordInfo);
			ESClientManager.getSesClient(SearchConstants.SearchNameSpace).bulkInsert(orderList);
		}
	
	/**
	 * 订单同步相关数据
	 * @param ordInfo
	 * @param ord
	 * @param iCacheSV
	 * @param parentOrderId
	 * @param ordOdFeeTotal
	 * @return
	 * @author caofz
	 * @ApiDocMethod
	 * @ApiCode 
	 * @RestRelativeURL
	 */
	private OrderInfo ordProdExtendsSynch(OrderInfo ordInfo, OrdOrder ord, ICacheSV iCacheSV, Long parentOrderId,
			OrdOdFeeTotal ordOdFeeTotal) {
		List<OrdProdExtend> prodExtends=new ArrayList<OrdProdExtend>();
		int totalprodsize = 0;
		List<ProdInfo> prodInfos=new ArrayList<ProdInfo>();
		OrdProdExtend prodExtend=new OrdProdExtend();
		prodExtend.setState(ord.getState());
		//订单状态翻译
		SysParam sysParamState = InfoTranslateUtil.translateInfo(ord.getTenantId(),
				"ORD_ORDER", "STATE",ord.getState(), iCacheSV);
		prodExtend.setStatename(sysParamState == null ? "" : sysParamState.getColumnDesc());
		prodExtend.setBusicode(ord.getBusiCode());//父订单
		prodExtend.setOrderid(parentOrderId);
		if(ordOdFeeTotal!=null) {
			prodExtend.setTotalfee(ordOdFeeTotal.getTotalFee());
			prodExtend.setDiscountfee(ordOdFeeTotal.getDiscountFee());
			prodExtend.setAdjustfee(ordOdFeeTotal.getAdjustFee());
			prodExtend.setFreight(ordOdFeeTotal.getFreight());
		}
		prodExtend.setRemark(ord.getRemark());
		// 查询商品信息
		prodInfos = this.queryOrdProd(prodInfos,ord.getTenantId(),
				parentOrderId);
		prodExtend.setProdsize(prodInfos.size());
		totalprodsize=prodInfos.size()+totalprodsize;
		prodExtend.setProdinfos(prodInfos);
		prodExtends.add(prodExtend);
		
		ordInfo.setTotalprodsize(totalprodsize);
		ordInfo.setOrdextendes(prodExtends);
		return ordInfo;
	}

	
	/**
	 * 刷新搜索引擎状态数据
	 */
	@Override
	public void refreshStateData(OrdOrder ordOrder,OrdOrder pOrder) throws BusinessException, SystemException {
		ICacheSV iCacheSV = DubboConsumerFactory.getService(ICacheSV.class);
  		IOrderSearch orderSearch = new OrderSearchImpl();
		List<SearchCriteria> orderSearchCriteria = SearchCriteriaStructure.
				commonConditionsByOrderId(ordOrder.getParentOrderId());
		Result<OrderInfo> result = orderSearch.search(orderSearchCriteria, 0, 1, null);
		List<OrderInfo> ordList = result.getContents();
		if(CollectionUtil.isEmpty(ordList)) {
			throw new BusinessException("搜索引擎无数据! 父订单id为:"+ordOrder.getParentOrderId());
		}
		OrderInfo orderInfo = ordList.get(0);
		//更新父订单状态
		if(pOrder!=null) {
			orderInfo.setParentorderstate(pOrder.getState());
		}
		List<OrdProdExtend> ordextendes = orderInfo.getOrdextendes();
		for (OrdProdExtend ordProdExtend : ordextendes) {
			if(ordOrder.getOrderId()==ordProdExtend.getOrderid()) {
				ordProdExtend.setState(ordOrder.getState());
				//订单状态翻译
				SysParam sysParamState = InfoTranslateUtil.translateInfo(ordOrder.getTenantId(),
						"ORD_ORDER", "STATE",ordOrder.getState(), iCacheSV);
				ordProdExtend.setStatename(sysParamState == null ? "" : sysParamState.getColumnDesc());
			}
		}
		ESClientManager.getSesClient(SearchConstants.SearchNameSpace).bulkInsert(ordList);
	}

	
	@Override
	public SesDataResponse insertSesDataByPage(SesDataByPageRequest request) throws BusinessException, SystemException {
		SesDataResponse response=new SesDataResponse();
		final long orderId=0;
		int startSize = 1;
		int maxSize = 1;
		// 最大条数设置
		int pageNo = request.getPageNo();
		int size = request.getPageSize();
		if (pageNo < 1) {
			startSize = 0;
		} else {
			startSize = (pageNo - 1) * size;
		}
		maxSize = size;
	 	final String tenantId = request.getTenantId();
	 	//性能数据
	 	int queryCount = ordOrderAtomSV.countForSes();
	 	List<OrdOrder> ordOrderDatas = ordOrderAtomSV.selectSesData(startSize,maxSize);
	
	 	List<OrdOrder> tmpList = new ArrayList<OrdOrder>();
	 	for(int i=0;i<ordOrderDatas.size();i++){
	 		if(tmpList.size() < 100){
	 			tmpList.add(ordOrderDatas.get(i));
	 			continue;
	 		}
	 		if(tmpList.size() == 100){
	 			PushToSesManager.push(orderId, tenantId, tmpList,this); 
	 			tmpList = null;
		 		tmpList = new ArrayList<OrdOrder>();
		 		tmpList.add(ordOrderDatas.get(i));
	 		}
	 	}
	 	//避免主线程停止
		sleep(1000L);
		while(true){
			if(PushToSesManager.isFinished()){
				break;
			}
			sleep(1000L);
		}
	 	response.setQueryCount(queryCount);
	 	return response;
	}

	

	/***
	 * 刷新数据
	 * @param ordInfo
	 * @param ord
	 * @param iCacheSV
	 * @param parentOrderId
	 * @param ordOdFeeTotal
	 * @return
	 * @author caofz
	 * @ApiDocMethod
	 * @ApiCode 
	 * @RestRelativeURL
	 */
	private OrderInfo queryOrdProdExtends(OrderInfo ordInfo,OrdOrder ord,ICacheSV iCacheSV,
			Long parentOrderId,OrdOdFeeTotal ordOdFeeTotal) {
		List<OrdProdExtend> prodExtends=new ArrayList<OrdProdExtend>();
		//子订单
		List<OrdOrder> subOrders = ordOrderAtomSV.selectChildOrder(ord.getTenantId(), parentOrderId);
		int totalprodsize = 0;
		if(!CollectionUtil.isEmpty(subOrders)) {
			//存在子订单
			for (OrdOrder ordOrder : subOrders) {
				OrdProdExtend prodExtend=new OrdProdExtend();
				List<ProdInfo> prodInfos=new ArrayList<ProdInfo>();
				prodExtend.setState(ordOrder.getState());
				//订单状态翻译
				SysParam sysParamState = InfoTranslateUtil.translateInfo(ordOrder.getTenantId(),
						"ORD_ORDER", "STATE",ordOrder.getState(), iCacheSV);
				prodExtend.setStatename(sysParamState == null ? "" : sysParamState.getColumnDesc());
				prodExtend.setBusicode(ordOrder.getBusiCode());
				prodExtend.setParentorderid(parentOrderId);
				prodExtend.setOrderid(ordOrder.getOrderId());
				prodExtend.setRouteid(ordOrder.getRouteId());
				prodExtend.setOrigorderid(ordOrder.getOrigOrderId());
				//子订单和售后订单对应的相应费用信息
				OrdOdFeeTotal feeTotal = ordOdFeeTotalAtomSV.selectByPrimaryKey(ordOrder.getOrderId());
				if(feeTotal!=null) {
					prodExtend.setTotalfee(feeTotal.getTotalFee());
					prodExtend.setAdjustfee(feeTotal.getAdjustFee());
					prodExtend.setDiscountfee(feeTotal.getDiscountFee());
					prodExtend.setPaidfee(feeTotal.getPaidFee());
					prodExtend.setFreight(feeTotal.getFreight());
				}
				//售后订单
				if(!OrdersConstants.OrdOrder.BusiCode.NORMAL_ORDER.
						equals(ordOrder.getBusiCode())) {
					OrdOdLogistics afterLogistics = ordOdLogisticsAtomSV.
							selectByOrd(null, ordOrder.getOrderId());
					if(afterLogistics!=null) {
						prodExtend.setAfterexpressid(afterLogistics.getExpressId());
						prodExtend.setAfterexpressoddnumber(afterLogistics.getExpressOddNumber());
					}
				}
				// 查询商品信息
				prodInfos = this.queryOrdProd(prodInfos,ord.getTenantId(),
						ordOrder.getOrderId());
				prodExtend.setProdsize(prodInfos.size());
				totalprodsize=prodInfos.size()+totalprodsize;
				prodExtend.setProdinfos(prodInfos);
				prodExtends.add(prodExtend);
			}
		}else {
			//不存在子订单
			List<ProdInfo> prodInfos=new ArrayList<ProdInfo>();
			OrdProdExtend prodExtend=new OrdProdExtend();
			prodExtend.setState(ord.getState());
			//订单状态翻译
			SysParam sysParamState = InfoTranslateUtil.translateInfo(ord.getTenantId(),
					"ORD_ORDER", "STATE",ord.getState(), iCacheSV);
			prodExtend.setStatename(sysParamState == null ? "" : sysParamState.getColumnDesc());
			prodExtend.setBusicode(ord.getBusiCode());//父订单
			prodExtend.setOrderid(parentOrderId);
			if(ordOdFeeTotal!=null) {
				prodExtend.setTotalfee(ordOdFeeTotal.getTotalFee());
				prodExtend.setDiscountfee(ordOdFeeTotal.getDiscountFee());
				prodExtend.setAdjustfee(ordOdFeeTotal.getAdjustFee());
				prodExtend.setFreight(ordOdFeeTotal.getFreight());
			}
			prodExtend.setRemark(ord.getRemark());
			// 查询商品信息
			prodInfos = this.queryOrdProd(prodInfos,ord.getTenantId(),
					parentOrderId);
			prodExtend.setProdsize(prodInfos.size());
			totalprodsize=prodInfos.size()+totalprodsize;
			prodExtend.setProdinfos(prodInfos);
			prodExtends.add(prodExtend);
		}
		ordInfo.setTotalprodsize(totalprodsize);
		ordInfo.setOrdextendes(prodExtends);
		return ordInfo;
	}

	private List<ProdInfo>  queryOrdProd(List<ProdInfo> prodInfos,String tenantId, 
			Long orderId) {
		List<OrdOdProd> ordOdProds = ordOdProdAtomSV.selectByOrd(tenantId, orderId);
		if (!CollectionUtil.isEmpty(ordOdProds)) {
			for (OrdOdProd ordOdProd : ordOdProds) {
				ProdInfo prodInfo=new ProdInfo();
				prodInfo.setBuysum(ordOdProd.getBuySum());
				prodInfo.setProdname(ordOdProd.getProdName());
			
				prodInfo.setSaleprice(ordOdProd.getSalePrice());
				prodInfo.setCouponfee(ordOdProd.getCouponFee());
				prodInfo.setJffee(ordOdProd.getJfFee());
				prodInfo.setGivejf(ordOdProd.getJf());
				prodInfo.setCusserviceflag(ordOdProd.getCusServiceFlag());
				prodInfo.setState(ordOdProd.getState());
				prodInfo.setProdcode(ordOdProd.getProdCode());
				prodInfo.setSkuid(ordOdProd.getSkuId());
				prodInfo.setProddetalid(ordOdProd.getProdDetalId());
				//TODO 是否查询商品服务
				//prodInfo.setVfsid(vfsid);
				//prodInfo.setPictype(pictype);
				//售后图片信息
				prodInfo.setImageurl(ordOdProd.getProdDesc());
				prodInfo.setProdextendinfo(ordOdProd.getProdSn());
				prodInfo.setSkustorageid(ordOdProd.getSkuStorageId());
				prodInfos.add(prodInfo);
			}
		}
		return prodInfos;
	}
	
	public SesDataResponse pushToSes(List<OrdOrder> ordOrderDatas,long orderId,
			ICacheSV iCacheSV, String tenantId) {
		SesDataResponse response=new SesDataResponse();
		List<OrderInfo> orderList = new ArrayList<OrderInfo>();
		int failCount=0;
	 	List<Long> failOrders=new ArrayList<Long>();
	 	int shareParentCount=0;
		if(!CollectionUtil.isEmpty(ordOrderDatas)){
		for (OrdOrder ord: ordOrderDatas) {
			//父订单
			if(orderId==ord.getOrderId()) {
				shareParentCount++;
			}
			orderId = ord.getOrderId();
			OrderInfo ordInfo = new OrderInfo();
			ordInfo.setPorderid(orderId);
			ordInfo.setUserid(ord.getUserId());
			ordInfo.setUsername(ord.getUserName());
			ordInfo.setUsertel(ord.getUserTel());
			ordInfo.setFlag(ord.getFlag());
			ordInfo.setDeliveryflag(ord.getDeliveryFlag());
			//翻译是否需要物流
			SysParam sysParamDf = InfoTranslateUtil.translateInfo(tenantId, "ORD_ORDER",
					"ORD_DELIVERY_FLAG", ord.getDeliveryFlag(), iCacheSV);
			ordInfo.setDeliveryflagname(sysParamDf == null ? "" : sysParamDf.getColumnDesc());
			
			ordInfo.setOrdertime(ord.getOrderTime());
			ordInfo.setParentorderstate(ord.getState());
			ordInfo.setSupplierid(ord.getSupplierId());
			ordInfo.setIfwarning(ord.getIfWarning());
			ordInfo.setWarningtype(ord.getWarningType());
			ordInfo.setChlid(ord.getChlId());
			ordInfo.setAccountid(ord.getAccountId());
			ordInfo.setToken(ord.getTokenId());
			ordInfo.setDownstreamorderid(ord.getDownstreamOrderId());
			ordInfo.setOrdertype(ord.getOrderType());
			
			// 获取手机号
			OrdOdLogistics ordOdLogistics = ordOdLogisticsAtomSV.selectByOrd(tenantId, orderId);
			if(ordOdLogistics==null) {
				failCount++;
				failOrders.add(orderId);
				logger.error(">>>>>>>>>>不存在订单运费信息! 父订单id:"+ orderId);
				continue;
			}
			ordInfo.setContacttel(ordOdLogistics.getContactTel());
			ordInfo.setExpressoddnumber(ordOdLogistics.getExpressOddNumber());
			ordInfo.setContactcompany(ordOdLogistics.getContactCompany());
			ordInfo.setContactname(ordOdLogistics.getContactName());
			ordInfo.setLogisticstype(ordOdLogistics.getLogisticsType());
			ordInfo.setProvincecode(ordOdLogistics.getProvinceCode() == null ? ""
					: iCacheSV.getAreaName(ordOdLogistics.getProvinceCode()));
			ordInfo.setCitycode(ordOdLogistics.getCityCode() == null ? ""
					: iCacheSV.getAreaName(ordOdLogistics.getCityCode()));
			ordInfo.setCountycode(ordOdLogistics.getCountyCode() == null ? ""
					: iCacheSV.getAreaName(ordOdLogistics.getCountyCode()));
			ordInfo.setPostcode(ordOdLogistics.getPostcode());
			ordInfo.setAreacode(ordOdLogistics.getAreaCode() == null ? ""
					: iCacheSV.getAreaName(ordOdLogistics.getAreaCode()));
			ordInfo.setAddress(ordOdLogistics.getAddress());
			ordInfo.setExpressid(ordOdLogistics.getExpressId());
			
			// 获取积分
			List<OrdOdFeeProd> orderFeeProdList = ordOdFeeProdAtomSV.selectByOrderId(orderId);
			if(CollectionUtil.isEmpty(orderFeeProdList)) {
				failCount++;
				failOrders.add(orderId);
				logger.error(">>>>>>>>>>不存在订单费用明细信息! 父订单id:"+ orderId);
				continue;
			}
			//存在的情况下
			long points = 0; 
			for (OrdOdFeeProd ordOdFeeProd : orderFeeProdList) {
				if (OrdersConstants.OrdOdFeeProd.PayStyle.JF.equals(ordOdFeeProd.getPayStyle())) {
					points += ordOdFeeProd.getPaidFee();
					break;
				}
			}
			ordInfo.setPoints(points);
			// 查询费用信息
			OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.selectByOrderId(tenantId, orderId);
			if (ordOdFeeTotal == null) {
				failCount++;
				failOrders.add(orderId);
				logger.error(">>>>>>>>>>不存在订单费用主表信息! 父订单id:"+ orderId);
				continue;
			}
			
			//查询发票信息
			OrdOdInvoice odInvoice = ordOdInvoiceAtomSV.selectByPrimaryKey(orderId);
			if(odInvoice!=null) {
				ordInfo.setInvoicetype(odInvoice.getInvoiceType());
				ordInfo.setInvoicetitle(odInvoice.getInvoiceTitle());
				ordInfo.setInvoicecontent(odInvoice.getInvoiceContent());
				ordInfo.setInvoicestatus(odInvoice.getInvoiceStatus());
				ordInfo.setBuyertaxpayernumber(odInvoice.getBuyerTaxpayerNumber());
				ordInfo.setBuyerbankname(odInvoice.getBuyerBankName());
				ordInfo.setBuyerbankaccount(odInvoice.getBuyerBankAccount());
			}
			
			OrdBalacneIf ordBalacneIf = ordBalacneIfAtomSV.selectByOrderId(orderId);
			if(ordBalacneIf!=null) {
				ordInfo.setBalacneifid(ordBalacneIf.getBalacneIfId());
				ordInfo.setExternalid(ordBalacneIf.getExternalId());
			}
			
			//存在情况下
			ordInfo.setDiscountfee(ordOdFeeTotal.getDiscountFee());
			ordInfo.setAdjustfee(ordOdFeeTotal.getAdjustFee());
			ordInfo.setPaystyle(ordOdFeeTotal.getPayStyle());
			// 查询订单其它信息
			ordInfo = this.queryOrdProdExtends(ordInfo, ord, 
					iCacheSV, orderId,ordOdFeeTotal);
			orderList.add(ordInfo);
		}
		try{
			ESClientManager.getSesClient(SearchConstants.SearchNameSpace).bulkInsert(orderList);
		}catch(Exception e){
			throw new SystemException("","订单信息加入搜索引擎失败,订单ID:"+orderId);
		}
	}
	response.setFailCount(failCount);
	response.setShareParentCount(shareParentCount);
	response.setFailOrders(failOrders);
	return response;
  }
	
	
	private void sleep(long times) {
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 按条件删除es数据
	 */
	@Override
	public void deleteSesData(BehindQueryOrderListRequest request) throws BusinessException, SystemException {
		ISearchClient sesClient = ESClientManager.getSesClient(SearchConstants.SearchNameSpace);
		List<SearchCriteria> orderSearchCriteria = SearchCriteriaStructure.commonConditions(request);
		sesClient.delete(orderSearchCriteria);
	}
}
