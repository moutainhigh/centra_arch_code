package com.ifudata.ic.pay.web.business.payment.controller.third;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.sdk.util.DateUtil;
import com.ifudata.centra.sdk.util.StringUtil;
import com.ifudata.ic.pay.api.tradequery.param.TradeRecord;
import com.ifudata.ic.pay.web.business.payment.controller.core.TradeBaseController;
import com.ifudata.ic.pay.web.business.payment.util.core.VerifyUtil;
import com.ifudata.ic.pay.web.system.configcenter.AbstractPayConfigManager;
import com.ifudata.ic.pay.web.system.configcenter.WoPayConfigManager;
import com.ifudata.ic.pay.web.system.constants.ExceptCodeConstants;
import com.ifudata.ic.pay.web.system.constants.PayConstants;
import com.ifudata.ic.pay.web.system.util.AmountUtil;
import com.ifudata.ic.pay.web.system.util.ConfigUtil;
import com.unicompay.sign.UniPaySignUtils;

@Controller
@RequestMapping(value = "/wopay")
public class WoPayController extends TradeBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WoPayController.class);

    private static final String WEB_NOTIFY_URL = "/wopay/webNotify";

    private static final String WEB_RETURN_URL = "/wopay/webReturn";

    @RequestMapping(value = "/webpayment/wopayapi")
    public void alipayWebPay(@RequestParam(value = "tenantId", required = true)
    String tenantId, @RequestParam(value = "orderId", required = true)
    String orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter printWriter = null;
        try {
            response.setContentType("text/html;charset=utf-8");
            printWriter = response.getWriter();
            LOGGER.info("沃支付WEB支付开始:商户订单号[" + orderId + "]" + " ，租户标识： " + tenantId);
            String infoMd5 = (String) request.getAttribute("infoMd5");
            if (StringUtil.isBlank(infoMd5)) {
                throw new SystemException("支付失败，传入的加密信息为空!");
            }
            String infoStr = orderId + VerifyUtil.SEPARATOR + tenantId;
            String key = AbstractPayConfigManager.getRequestKey(tenantId);
            if (!VerifyUtil.checkParam(infoStr, infoMd5, key)) {
                LOGGER.error("延签失败：传入的参数已被篡改！" + infoStr);
                throw new BusinessException(ExceptCodeConstants.ILLEGAL_PARAM,
                        "传入的支付请求参数非法,参数有误或已被篡改！");
            }
            TradeRecord tradeRecord = this.queryTradeRecord(tenantId, orderId);
            if (tradeRecord == null) {
                LOGGER.error("发起支付时查询不到此订单支付请求数据： 租户标识： " + tenantId + " ，订单号： " + orderId);
                throw new SystemException("发起支付时查询订单信息异常!");
            }
            //
            String basePath = AbstractPayConfigManager.getPayUrl();
            // LOGGER.info("项目根路径： " + basePath);
            // // 组织支付参数
            // String payment_type = "1"; // 支付类型,必填，不能修改
            // // 服务器异步通知页面路径
            String notify_url = basePath + WEB_NOTIFY_URL;
            // // 需http://格式的完整路径，不能加?id=123这类自定义参数 //页面跳转同步通知页面路径
            String return_url = basePath + WEB_RETURN_URL;
            // // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
            // String seller_email = ConfigUtil.getProperty(tenantId,
            // AliPayConfigManager.PAY_ORG_NAME, AliPayConfigManager.WEB_SELLER_EMAIL); // 卖家沃支付帐户
            // String partner = ConfigUtil.getProperty(tenantId, AliPayConfigManager.PAY_ORG_NAME,
            // AliPayConfigManager.WEB_SELLER_PID);
            // String seller_key = ConfigUtil.getProperty(tenantId,
            // AliPayConfigManager.PAY_ORG_NAME,
            // AliPayConfigManager.WEB_SELLER_KEY);
            String out_trade_no = tradeRecord.getTradeOrderId(); // 商户订单号
            // LOGGER.info("沃支付WEB支付开始:交易订单号[" + out_trade_no + "]");
            String subject = "网上支付";
            if (!StringUtil.isBlank(tradeRecord.getSubject())) {
                subject = tradeRecord.getSubject();
            }
            String total_fee = String.valueOf(AmountUtil.changeLiToFen(tradeRecord.getPayAmount())); // 付款金额
            // String body = null; // 订单描述
            // String show_url = null; // 商品展示地址
            // // 需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html //防钓鱼时间戳
            // String anti_phishing_key = "";
            // // 若要使用请调用类文件submit中的query_timestamp函数
            // // 客户端的IP地址
            // String exter_invoke_ip = "";
            // // 非局域网的外网IP地址，如：221.0.0.1
            //
            String merNo = ConfigUtil.getProperty(tenantId, WoPayConfigManager.PAY_ORG_CODE,
                    WoPayConfigManager.MER_NO);
            String orderDate = DateUtil.getDateString(DateUtil.YYYYMMDD);
            String signType = PayConstants.WoPay.SIGN_TYPE;
            //
            Map<String, String> params = new HashMap<String, String>();
            params.put("interfaceVersion", PayConstants.WoPay.INTERFACE_VERSION);
            params.put("tranType", PayConstants.WoPay.TRAN_TYPE);
            params.put("bankCode", "");
            params.put("payProducts", "");
            params.put("merNo", merNo);
            params.put("goodsName", subject);
            params.put("goodsDesc", subject);
            params.put("orderDate", orderDate);
            params.put("orderNo", out_trade_no);
            params.put("amount", total_fee);
            params.put("goodId", "");
            params.put("merUserId", "");
            params.put("merExtend", tenantId);
            params.put("customerName", "");
            params.put("mobileNo", "");
            params.put("customerEmail", "");
            params.put("customerID", "");
            params.put("charSet", "UTF-8");
            params.put("tradeMode", PayConstants.WoPay.TRADE_MODE);
            params.put("reqTime", DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS));
            params.put("reqIp", "");
            params.put("respMode", PayConstants.WoPay.RESP_MODE);
            params.put("callbackUrl", return_url);
            params.put("serverCallUrl", notify_url);
            params.put("signType", signType);

            // 获取商户签名密码
            String merchantSignKey = WoPayConfigManager.getMerchantSignKey(tenantId);
            // 获取商户签名密码
            String signMsg = null;
            signMsg = UniPaySignUtils.getMd5SignMsg(params, merchantSignKey, "UTF-8");
            params.put("signMsg", signMsg);
            // 建立请求
            String sHtmlText = "";

            List<String> keys = new ArrayList<String>(params.keySet());

            StringBuilder sbHtml = new StringBuilder();

            sbHtml.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
                    + "<html>"
                    + "<head><title>联通沃支付工具订单支付功能</title>"
                    + "<script>document.forms['form1'].submit();</script></head>"
                    // + "<body onload = \"javascript: document.form1.submit()\">"
                    + "<body >" + "<form  name=\"form1\" action=\""
                    + WoPayConfigManager.getOrderPayUrl() + "?reqCharSet="
                    + WoPayConfigManager.INPUT_CHARSET + "\" method=\"post\">");

            for (int i = 0; i < keys.size(); i++) {
                String name = (String) keys.get(i);
                String value = (String) params.get(name);

                sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value
                        + "\"/>");
            }
            sbHtml.append("<input type=\"submit\" value=\"支付\" style=\"display:none;\">");
            sbHtml.append("<p>&nbsp; </p></form></body></html>");
            sHtmlText = sbHtml.toString();

            LOGGER.info("向沃支付WEB即时到账交易接口发起支付请求：" + sHtmlText);
            printWriter.println(sHtmlText);
            printWriter.flush();
            printWriter.close();
        } catch (IOException ex) {
            LOGGER.error("沃支付网页支付发生错误", ex);
            throw ex;
        } catch (Exception ex) {
            LOGGER.error("沃支付网页支付发生错误", ex);
            throw ex;
        }
    }

    @RequestMapping(value = "/webNotify")
    public void wopayWebNotify(HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(value = "/webReturn")
    public void wopayWebReturn(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    }
}
