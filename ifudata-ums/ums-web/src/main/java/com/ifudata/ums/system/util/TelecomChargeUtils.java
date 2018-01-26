package com.ifudata.ums.system.util;//package com.ifudata.crm.system.util;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ifudata.crm.system.config.Constants;
//import com.ifudata.ums.crm.api.accounts.paycenter.param.PayApplyLog;
//import com.ifudata.ums.crm.api.base.vo.RequestHeader;
//import com.ifudata.tele.ums.service.bean.common.input.TcpCont;
//import com.ifudata.tele.ums.service.recharge.IRecharge;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeInput;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeInput.SvcCont;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeInput.SvcCont.RechargeBalanceReq;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeInput.SvcCont.RechargeBalanceReq.Balance_Information;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeInput.SvcCont.RechargeBalanceReq.Balance_Information.Bonus;
//import com.ifudata.tele.ums.service.recharge.bean.charge.ChargeOutput;
///**
// * 
// * Title: ums-SP <br>
// * Description: <br>
// * Date: 2014年6月9日 <br>
// * Copyright (c) 2014 ifudata <br>
// * 电信号码交费确认服务（调用电信充值接口）
// * 
// * @author zhangkq
// */
//public class TelecomChargeUtils {
//    private static Logger logger = Logger.getLogger(TelecomChargeUtils.class);
//
//    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//            new String[] { "/common/applicationContext.xml" });;
//
//    private static IRecharge iRecharge = (IRecharge) TelecomChargeUtils.context
//            .getBean("iRecharge");
//
//    public static com.ifudata.tele.ums.service.bean.common.output.TcpCont telecomCharge(
//            RequestHeader requestHeader, PayApplyLog payApplyLog, Long PayAmount, String applyId) {
//        logger.debug("电信号码充值确认工具类构造参数。。。。..........");
//        com.ifudata.tele.ums.service.bean.common.output.TcpCont outTcpCont = new com.ifudata.tele.ums.service.bean.common.output.TcpCont();
//
//        try {
//
//            ChargeInput chargeInput = new ChargeInput();
//            SvcCont svcCont = new SvcCont();
//            RechargeBalanceReq rechargeBalanceReq = new RechargeBalanceReq();
//            Balance_Information information = new Balance_Information();
//            information.setBalance_ItemType_ID(Constants.TELECOM_PAY.BALANCE_ITEMTYPE_ID); // 帐本类型 0：默认（本金）
//            List<Bonus> bonusList = new ArrayList<Bonus>();
//            information.setBonus(bonusList); // 赠送项一个充值项可存在多个赠送项
//            information.setChannel_Staff_Id("[" + requestHeader.getApplyChlId() + "]"+ requestHeader.getOperId()); // 操作工号渠道工号，以[]分隔：表示方法为[渠道]工号；若渠道为空，则表示为[]工号；
//            information.setCharge_Source(Constants.TELECOM_PAY.CHARGE_SOURCE); // 全数字，格式为aabbccddee，详见主数据“接入渠道编码”
//            information.setDestination_Attr(Constants.TELECOM_PAY.DESTINATION_ATTR); // 被充值用户属性2：移动手机用户
//            information.setDestination_Id(payApplyLog.getServiceNum()); // 被充值用户号码
//            information.setDestination_Id_Type(Constants.TELECOM_PAY.DESTINATION_ID_TYPE); // 被充值用户号码类型：3 –用户号码（充帐户帐本）
//            information.setFeeAmount(String.valueOf(new BigDecimal(PayAmount).divide(new BigDecimal(10)).longValue())); // 充值金额
//            information.setProlongDays(Constants.TELECOM_PAY.PROLONG_DAYS); // 充值延长有效期(天数)0：默认值
//            information.setReq_Serial(applyId); // 充值请求流水号
//            information.setRequestAmount(Constants.TELECOM_PAY.REQUEST_AMOUNT); // 赠送条数当赠送为分月形式时，RequestAmount！＝1。没有赠送金额时填0。
//            information.setUnitType_Id(Constants.TELECOM_PAY.UNIT_TYPE_ID); // 充值单位类型0 – 分（金额）
//            rechargeBalanceReq.setBalance_Information(information);
//            svcCont.setRechargeBalanceReq(rechargeBalanceReq);
//            chargeInput.setSvcCont(svcCont);
//            TcpCont chargeTcpCont = TcpContUtil.createTcpContIn(Constants.TELECOM_PAY.TCP_CONT_IN);
//            chargeInput.setTcpCont(chargeTcpCont);
//            logger.debug("电信号码充值确认工具类构造参数结束。。。。..........");
//            logger.debug("电信号码交费确认服务开始。。。。。");
//            ChargeOutput chargeOutput = iRecharge.charge(chargeInput); // 电信交费确认服务
//            logger.debug("电信号码交费确认服务结束。。。。。");
//            if (chargeOutput == null) {
//                logger.debug("电信号码交费确认服务返回对象为null。。。。。");
//                return outTcpCont;
//            }
//
//            // 返回参数
//            outTcpCont = chargeOutput.getTcpCont();
//
//        } catch (Exception e) {
//            logger.debug("电信接口异常：", e);
//            return outTcpCont;
//        }
//        return outTcpCont;
//    }
//
//}
