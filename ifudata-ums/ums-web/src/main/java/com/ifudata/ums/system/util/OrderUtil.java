/*
package com.ifudata.ums.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ifudata.ums.crm.api.orders.orderdetail.param.OrdProduct;

public class OrderUtil {
    
    */
/**基本业务编码前缀*//*

    public static final String ORDER_BASE_PREFIX = "1";
    */
/**基本业务编码范围内非基本业务后缀（增值业务）*//*

    public static final String ORDER_BASE_ESCAPE_SUFFIX = "3";
    */
/**第三方增值业务编码前缀*//*

    public static final String ORDER_VALUE_ADD_PERFIX = "3";
    */
/**受理业务编码前缀*//*

    public static final String ORDER_APPLY_PERFIX = "2";
    */
/**业务卡业务编码前缀*//*

    public static final String ORDER_CARD_PERFIX = "4";
    */
/**促销品业务编码前缀*//*

    public static final String ORDER_SALE_PREFIX = "5";
    */
/**主产品*//*

    public static final String ORDER_BASE = "10001";
    */
/**流量叠加*//*

    public static final String ORDER_RATE_ADD = "10002";
    */
/**联通增值业务*//*

    public static final String ORDER_UNICOM = "10003";
    */
/**语音叠加*//*

    public static final String ORDER_VOICE_ADD = "10004";
    */
/**漫游服务*//*

    public static final String ORDER_ROAM = "10005";
    */
/**月功能费*//*

    public static final String ORDER_FUNC_MONTH = "10006";
    */
/**短信叠加包*//*

    public static final String ORDER_MSG_ADD = "10007";
    */
/**存费送费*//*

    public static final String ORDER_FEE_FEE = "20001";
    */
/**存费送实物*//*

    public static final String ORDER_FEE_MATERIAY = "20002";
    */
/**存费送业务*//*

    public static final String ORDER_FEE_BUSI = "20003";
    */
/**第三方业务*//*

    public static final String ORDER_PARTNER = "30000";
    */
/**流量卡*//*

    public static final String ORDER_RATE_CARD = "40001";
    */
/**增值业务卡*//*

    public static final String ORDER_VALUE_ADD_CARD = "40002";
    */
/**促销品*//*

    public static final String ORDER_SALE = "50001";
    
    */
/**
     * 将产品分类
     * @param ordProducts
     * @return
     * @author chenrui
     *//*

    private static Map<String, List<OrdProduct>> getProductCateMap(List<OrdProduct> ordProducts){
        
        Map<String, List<OrdProduct>>  productMap = new HashMap<String, List<OrdProduct>>();
        
        for (OrdProduct ordProduct : ordProducts) {
            
            String productType = ordProduct.getProductType();
            List<OrdProduct> productList = productMap.get(productType);
            if (productList == null) {
                productList = new ArrayList<OrdProduct>();
                productList.add(ordProduct);
            }else {
                productList.add(ordProduct);
            }
        }
        for (OrdProduct ordProduct : ordProducts) {
            
        
            String productType = ordProduct.getProductType();
            */
/*switch (productType) {
            case ORDER_BASE:
                
                break;
            case ORDER_RATE_ADD:
                
                break;
            case ORDER_UNICOM:
                
                break;
            case ORDER_VOICE_ADD:
                
                break;
            case ORDER_ROAM:
                
                break;
            case ORDER_FUNC_MONTH:
                
                break;
            case ORDER_MSG_ADD:
                
                break;
            case ORDER_FEE_FEE:
                
                break;
            case ORDER_FEE_MATERIAY:
                
                break;
            case ORDER_FEE_BUSI:
                
                break;
            case ORDER_PARTNER:
                
                break;
            case ORDER_RATE_CARD:
                
                break;
            case ORDER_VALUE_ADD_CARD:
                
                break;
            case ORDER_SALE:
                
                break;
                
            default:
                break;
            }*//*

        }
        return null;
        
    }
    
}
*/
