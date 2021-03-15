package com.ljq.demo.constant;

/**
 * @Description: 收付款计划常量
 * @Author: junqiang.lu
 * @Date: 2021/3/12
 */
public class PaymentPlanConst {

    private PaymentPlanConst() {
    }

    /**
     * 收付款周期
     * 1: 一次性付清
     * 2: 按月计算
     * 3: 按季度计算
     * 4: 按照半年
     * 6: 按年度计算
     */
    public static final int PAYMENT_PERIOD_ONCE = 1;
    public static final int PAYMENT_PERIOD_MONTH = 2;
    public static final int PAYMENT_PERIOD_SEASON = 3;
    public static final int PAYMENT_PERIOD_HALF_YEAR = 4;
    public static final int PAYMENT_PERIOD_YEAR = 5;


}
