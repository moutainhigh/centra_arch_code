/*
package com.ifudata.ums.system.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ifudata.ums.api.applybatch.param.RequestHeader;
import com.ifudata.ums.system.config.Constants;
import com.ifudata.ums.system.coremodel.SessionInfo;
import com.ifudata.ums.system.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ifudata.ums.crm.api.commons.chnlquery.interfaces.IChnlQueryDubboSV;
import com.ifudata.ums.crm.api.commons.chnlquery.param.ChnlQueryRequest;
import com.ifudata.ums.crm.api.commons.chnlquery.param.ChnlQueryResponse;
import com.ifudata.ums.crm.api.commons.chnlquery.param.StorageInfo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnChannelVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnDepartVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnOperVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnStaffVo;
import com.ifudata.ums.crm.api.orders.orderchangetrade.param.OrdChangeInvoice;
import com.ifudata.ums.crm.api.products.productlistquery.param.ProductBasicOrgVo;
import com.ifudata.ums.crm.api.products.productlistquery.param.ProductChannelVo;
import com.ifudata.ums.crm.api.products.productlistquery.param.ProductChlTypeVo;
import com.ifudata.ums.crm.api.products.productlistquery.param.ProductListQueryRequest;
import com.alibaba.dubbo.common.utils.StringUtils;

public class RequestUtil {
    @Autowired
    public static IChnlQueryDubboSV iChnlQueryDubboSV;//根据渠道编码查询仓库的服务
    private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
    */
/**
     * 根据session中的操作员信息生成报文头VO
     * @return
     * @author moubd
     *//*

    public static RequestHeader getRequestHeader(HttpServletRequest request){
    	 RequestHeader requestHeader = new RequestHeader();
         */
/*在缓存中获取操作员信息*//*

         GnStaffVo gnStaffVo = SessionInfo.getOperInfo(request);
         logger.debug("gnStaffVo is not null ?" + (gnStaffVo != null));
         if(gnStaffVo==null){
             throw new BusiException("业务受理失败", "",
 					"在缓存中获取不到操作员信息！", "", "");
         }
         
         //操作员ID
         GnOperVo operVo = gnStaffVo.getGnOperVo();
         logger.debug("gnStaffVo is not null ?" + (operVo != null));
         if(operVo == null){
             throw new BusiException("业务受理失败", "",
 					"在缓存中获取不到操作员信息！", "", "");
         }
         
         long operId = operVo.getOperId();
         //操作员省份 地市
         String provinceCode = null;
         String cityCode = null;
         //接入类型
         String fromType = Constants.FROM_TYPE.CRM;
         
         //归属类型
         if (Constants.Org_Type.CHANNEL.equals(operVo.getOrgType())){
         	requestHeader.setOrgType(Constants.Org_Type.CHANNEL);
         	//操作员地市
             //渠道ID
             String chnlId = operVo.getChnlId();
             if(StringUtil.isBlank(chnlId)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员["+operId+"]对应的渠道编码！", "", "");
             }
             
             GnChannelVo channelVo = gnStaffVo.getGnChannelVo();
             if(channelVo == null){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应的渠道["+chnlId+"]信息！", "", "");
             }
             
             //操作员省份 地市
             provinceCode = channelVo.getProvinceCode();
             if(StringUtil.isBlank(provinceCode)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应渠道的省份编码！", "", "");
             }
             
             cityCode = channelVo.getCityCode();
             if(StringUtil.isBlank(cityCode)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应渠道的地市编码！", "", "");
             }
             
             requestHeader.setApplyChlId(chnlId);
             
         }else if (Constants.Org_Type.DEPART.equals(operVo.getOrgType())){
         	requestHeader.setOrgType(Constants.Org_Type.DEPART);
         	//操作员地市
             //渠道ID
             String departId = operVo.getDepartId();
             if(StringUtil.isBlank(departId)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员["+operId+"]对应的部门编码！", "", "");
             }
             
             GnDepartVo departVo = gnStaffVo.getGnDepartVo();
             if(departVo == null){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应的部门["+departId+"]信息！", "", "");
             }
             
             //操作员省份 地市
             provinceCode = departVo.getProvinceCode();
             if(StringUtil.isBlank(provinceCode)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应渠道的省份编码！", "", "");
             }
             
             cityCode = departVo.getCityCode();
             if(StringUtil.isBlank(cityCode)){
                 throw new BusiException("业务受理失败", "",
                 		"获取不到操作员对应渠道的地市编码！", "", "");
             }
             
             requestHeader.setApplyChlId(departId);
             
         }else{
         	 throw new BusiException("业务受理失败", "",
  					"在缓存中获取不到操作员归属类型！", "", "");
         }
         
         requestHeader.setOperId(Long.valueOf(operId));
         requestHeader.setFromType(fromType);
         requestHeader.setProvinceCode(provinceCode);
         requestHeader.setCityCode(cityCode);
        
         return requestHeader;
    }
    */
/**
     * 获取操作员对应的渠道ID
     * @return
     * @author moubd
     *//*

    public static String getChnlId(HttpServletRequest request){
        */
/*在缓存中获取操作员信息*//*

        GnStaffVo gnStaffVo = SessionInfo.getOperInfo(request);
        if(gnStaffVo==null){
        	 throw new BusiException("业务受理失败", "",
 					"在缓存中获取不到操作员信息！", "", "");
        }
        
        String chnlId = null;
        if (Constants.Org_Type.CHANNEL.equals(gnStaffVo.getGnOperVo().getOrgType())){
        	//渠道ID
        	chnlId = gnStaffVo.getGnOperVo().getChnlId();
        	if(StringUtil.isBlank(chnlId)){
        		throw new BusiException("业务受理失败", "",
            		"获取不到操作员对应的渠道编码！", "", "");
        	}
        }
        return chnlId;
    }
    */
/**
     * 获取操作员对应的渠道类型ID
     * @param request
     * @return
     * @author NeoEvan
     *//*

    public static String getChnlKindId(HttpServletRequest request){
    	String chnlKindId=null;
    	 */
/*在缓存中获取操作员信息*//*

        GnStaffVo gnStaffVo = SessionInfo.getOperInfo(request);
        if(gnStaffVo==null){
        	 throw new BusiException("业务受理失败", "",
 					"在缓存中获取不到操作员信息！", "", "");
        }
        if (Constants.Org_Type.CHANNEL.equals(gnStaffVo.getGnOperVo().getOrgType())){
    		GnChannelVo gnChannelVo= gnStaffVo.getGnChannelVo();
    		if(gnChannelVo!=null){
    			chnlKindId=gnChannelVo.getChnlKindId();
    			if(chnlKindId==null||chnlKindId.trim().equals("")){
    				throw new BusiException("业务受理失败", "",
    	 					"在缓存中获取不到操作员对应的渠道类型ID！", "", "");
    			}
    		}else{
    			throw new BusiException("业务受理失败", "",
   					"在缓存中获取不到操作员[GnChannelVo]信息！", "", "");
    		}
        }else{
        	throw new BusiException("业务受理失败", "",
 					"归属于部门的操作员不能打开业务受理类菜单", "", "");
        }
        return chnlKindId;
    }
    */
/**
     * 根据渠道ID,获取网厅对应的仓库ID 服务后返回List，默认取第一个Vo中的仓库ID
     * @param chnlId
     * @return
     * @author moubd
     *//*

    public static String getStorageId(HttpServletRequest request){
        String chnlId =  getChnlId(request);
        String stroageId="";
        ChnlQueryRequest chnlQueryRequest = new ChnlQueryRequest();
        chnlQueryRequest.setChnlId(chnlId);
        RequestHeader header = getRequestHeader(request);
        chnlQueryRequest.setRequest(header);
        chnlQueryRequest.setProvinceCode(header.getProvinceCode());
        chnlQueryRequest.setCityCode(header.getCityCode());
        ChnlQueryResponse response = iChnlQueryDubboSV.queryStoragesByChnlId(chnlQueryRequest);
        ResponseHeader responseHeader = response.getResponse();
        if(!ConstantsResultCode.SUCCESS.equals(responseHeader.getResultCode())){
        	throw new BusiException("业务受理失败", responseHeader.getResultCode(),
        			responseHeader.getResultMessage(), responseHeader.getDetail(), "");
        }
        List<StorageInfo> list = (List<StorageInfo>)response.getStorageInfos();
        if(list==null || list.size()==0){
            throw new BusiException("业务受理失败", "",
 					"没有查询到操作员渠道编码相应的仓库ID！", "", "");
        }
        StorageInfo info = list.get(0);
        stroageId = info.getStorageId();
        if(StringUtil.isBlank(stroageId)){
            throw new BusiException("业务受理失败", "",
 					"没有查询到渠道编码相应的仓库ID！", "", "");
        }
        return stroageId;
    }
    
    */
/**
     * 根据渠道ID,获取网厅对应的仓库ID 服务后返回List，默认取第一个Vo中的仓库ID
     * @param chnlId
     * @return
     * @author zhanglei
     *//*

    public static String getStorageIdByChnlId(HttpServletRequest request, String chnlId){
    	if (StringUtils.isEmpty(chnlId)) {
    		 throw new BusiException("业务受理失败", "",
    				 "根据渠道编码获取仓库信息失败，原因是渠道编码为空", "", "");
		}
        String stroageId="";
        ChnlQueryRequest chnlQueryRequest = new ChnlQueryRequest();
        chnlQueryRequest.setChnlId(chnlId);
        RequestHeader header = getRequestHeader(request);
        chnlQueryRequest.setRequest(header);
        chnlQueryRequest.setProvinceCode(header.getProvinceCode());
        chnlQueryRequest.setCityCode(header.getCityCode());
        ChnlQueryResponse response = iChnlQueryDubboSV.queryStoragesByChnlId(chnlQueryRequest);
        ResponseHeader responseHeader = response.getResponse();
        if(!ConstantsResultCode.SUCCESS.equals(responseHeader.getResultCode())){
        	throw new BusiException("业务受理失败", responseHeader.getResultCode(),
        			responseHeader.getResultMessage(), responseHeader.getDetail(), "");
        }
        List<StorageInfo> list = (List<StorageInfo>)response.getStorageInfos();
        if(list==null || list.size()==0){
            throw new BusiException("业务受理失败", "",
   				 "没有查询到操作员渠道编码相应的仓库ID！", "", "");
        }
        StorageInfo info = list.get(0);
        stroageId = info.getStorageId();
        if(StringUtil.isBlank(stroageId)){
            throw new BusiException("业务受理失败", "",
      				 "没有查询到渠道编码相应的仓库ID！", "", "");
        }
        return stroageId;
    }
    */
/**
     * 根据渠道ID获取对应的仓库ID列表
     * @param chnlId
     * @return
     * @author moubd
     *//*

    public static List<StorageInfo> getStorageInfoList(HttpServletRequest request){
        String chnlId =  getChnlId(request);
        ChnlQueryRequest chnlQueryRequest = new ChnlQueryRequest();
        chnlQueryRequest.setChnlId(chnlId);
        RequestHeader header = getRequestHeader(request);
        chnlQueryRequest.setRequest(header);
        chnlQueryRequest.setProvinceCode(header.getProvinceCode());
        chnlQueryRequest.setCityCode(header.getCityCode());
        ChnlQueryResponse response = iChnlQueryDubboSV.queryStoragesByChnlId(chnlQueryRequest);
        ResponseHeader responseHeader = response.getResponse();
        if(!ConstantsResultCode.SUCCESS.equals(responseHeader.getResultCode())){
        	throw new BusiException("业务受理失败", responseHeader.getResultCode(),
        			responseHeader.getResultMessage(), responseHeader.getDetail(), "");
        }
        List<StorageInfo> list = (List<StorageInfo>)response.getStorageInfos();
        if(list==null || list.size()==0){
            throw new BusiException("业务受理失败", "",
     				 "没有查询到渠道编码相应的仓库ID！", "", "");
        }
        return list;
    }
    
    public static void setiChnlQueryDubboSV(IChnlQueryDubboSV iChnlQueryDubboSV) {
        RequestUtil.iChnlQueryDubboSV = iChnlQueryDubboSV;
    }
    */
/**
     * 产品查询时增加一些必要参数
     * @param productListQueryRequest
     * @param request
     * @return
     * @author NeoEvan
     *//*

    public static ProductListQueryRequest getProductListQueryRequest(HttpServletRequest request){
    	ProductListQueryRequest productListQueryRequest=new ProductListQueryRequest();
    	*/
/*基础运营商*//*

    	List<ProductBasicOrgVo> productBasicOrgs=new ArrayList<ProductBasicOrgVo>();
    	ProductBasicOrgVo productBasicOrgVo=new ProductBasicOrgVo();
    	productBasicOrgVo.setBasicOrgId(Constants.BASIC_ORG_ID.UNICOM);
    	productBasicOrgs.add(productBasicOrgVo);
    	productListQueryRequest.setProductBasicOrgs(productBasicOrgs);
    	*/
/*产品渠道类型*//*

    	List<ProductChlTypeVo> productChlTypes=new ArrayList<ProductChlTypeVo>();
    	ProductChlTypeVo productChlTypeVo=new ProductChlTypeVo();
    	productChlTypeVo.setChlType(getChnlKindId(request));
    	productChlTypes.add(productChlTypeVo);
    	productListQueryRequest.setProductChlTypes(productChlTypes);
    	*/
/*渠道ID*//*

    	List<ProductChannelVo> productChannels=new ArrayList<ProductChannelVo>();
    	ProductChannelVo productChannelVo=new ProductChannelVo();
    	productChannelVo.setChnlId(getChnlId(request));
    	productChannels.add(productChannelVo);
    	productListQueryRequest.setProductChannels(productChannels);
    	return productListQueryRequest;
    }
    */
/**
     * 变更类业务公共方法，根据Request获取发票信息
     * @param request
     * @return
     * @author moubd
     *//*

    @SuppressWarnings("unchecked")
    public static OrdChangeInvoice  getOrdChangeInvoice(HttpServletRequest request){
        String myOID = request.getParameter("myOID");
        if (StringUtils.isEmpty(myOID)) {
            throw new BusiException("session唯一标示不能为空");
        }
        HttpSession session = request.getSession();
        Map<String, Object> myOIDMap=(Map<String, Object>)session.getAttribute(myOID);
        String invoiceTitle = myOIDMap.get(Constants.OrderSubmitSession.INVOICE_TITLE)+"";
        OrdChangeInvoice ordInvoice = null;
        if(!StringUtil.isBlank(invoiceTitle)){
            ordInvoice = new OrdChangeInvoice();
            ordInvoice.setInvoiceContent("");//发票内容
            ordInvoice.setInvoiceContentType(Constants.INVOICE_CONTENT_TYPE.TRUTH_CONTENT_PRINT);//登记打印内容 0：实际内容打印1：登记内容打印
            ordInvoice.setInvoiceTitle(invoiceTitle);
        }
        
        return ordInvoice;
    }
}
*/
