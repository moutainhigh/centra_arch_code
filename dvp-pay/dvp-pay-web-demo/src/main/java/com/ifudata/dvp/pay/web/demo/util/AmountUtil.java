package com.ifudata.dvp.pay.web.demo.util;

import java.math.BigDecimal;

/**
 * 金额转化工具类
 *
 * Date: 2015年11月2日 <br>
 */
public final class AmountUtil {

    private AmountUtil() {
        
    }
    
    /**
     * 厘转为元
     * @param liAmount
     * @return
     */
    public static double changeLiToYuan(long liAmount) {
        BigDecimal amountDecimal = new BigDecimal(Long.toString(liAmount)).divide(new BigDecimal(1000));
        return amountDecimal.doubleValue();
    }
    /**
     * 厘转为分
     * @param liAmount
     * @return
     */
    public static long changeLiToFen(long liAmount) {
        BigDecimal amountDecimal = new BigDecimal(Long.toString(liAmount)).divide(new BigDecimal(10));
        return amountDecimal.longValue();
    }
    /**
     * 分转为元
     * @param fenAmount
     * @return
     * @ApiDocMethod
     * @ApiCode
     */
    public static double changeFenToYuan(long fenAmount) {
        return BigDecimal.valueOf(fenAmount).divide(new BigDecimal(100)).doubleValue();
    }
    
    /**
     * 元转为厘
     * @param yuanAmount
     * @return
     * @ApiDocMethod
     * @ApiCode
     */
    public static long changeYuanToLi(double yuanAmount) {
        return new BigDecimal(Double.toString(yuanAmount)).multiply(new BigDecimal(1000)).longValue();
    }

    /**
     * 元转为分
     * @param yuanAmount
     * @return
     * @ApiDocMethod
     * @ApiCode
     */
    public static long changeYuanToFen(double yuanAmount) {
        return new BigDecimal(Double.toString(yuanAmount)).multiply(new BigDecimal(100)).longValue();
    }
    
    public static BigDecimal divide(long amount, int divisor) {
        return new BigDecimal(amount).divide(new BigDecimal(divisor));
    }

    public static BigDecimal divide(long amount, int divisor, int scale) {
        return divide(amount, divisor).setScale(scale);
    }

    public static BigDecimal divideHalfUp(long amount, int divisor, int scale) {
        return divide(amount, divisor).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

}
