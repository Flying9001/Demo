package com.ljq.demo.util;

import cn.hutool.core.date.DateUtil;
import com.ljq.demo.bean.PaymentPlanBean;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

public class FinanceUtilTest {

    /**
     * 收付款计划需求:
     * 付款周期分为一次性支付、按月支付、按季度支付、按半年支付、按年支付
     * 计划付款日期:
     *    (1)第一次付款按指定的首次付款日期付款
     *    (2)付款周期：按期-月，第二次付款的付款日=首次付款日期中的月份+1，第三次付款的付款日=首次付款日期中的月份+2，以此类推；
     *      若后续月份中没有首次付款日期中指定的“日”，则默认当月最后一日为计划付款日期，如指定首次付款日期为2020年1月31日，
     *      2020年2月份没有31日就以2月份最后一天作为付款日；若指定首次付款日期中的“日”为当月最后一天，则后续月份的计划付款日期也为当月最后一天，
     *      如指定首次付款日期为2020年2月29日，则下次计划付款日期为2020年3月31日，而非2020年3月29日。
     *    (3)付款周期：按期-季，指定首次付款日期，第二次付款的付款日期=首次付款日期中的月份+3，第三次付款的付款日期=首次付款日期中的月份+6，
     *      以此类推；若后续月份中没有首次付款日期中指定的“日”，则默认当月最后一日为计划付款日期；若指定首次付款日期中的“日”为当月最后一天，
     *      则后续月份的计划付款日期也为当月最后一天。
     *    (4)付款周期：按期-半年，指定首次付款日期，第二次付款的付款日期=首次付款日期中的月份+6，第三次付款的付款日期=首次付款
     *      日期中的月份+12，以此类推；若后续月份中没有首次付款日期中指定的“日”，则默认当月最后一日为计划付款日期；
     *      若指定首次付款日期中的“日”为当月最后一天，则后续月份的计划付款日期也为当月最后一天。
     *    (5)付款周期：按期-年，指定首次付款日期，第二次付款的付款日期=首次付款日期中的年份+1，第三次付款的付款日期=首次付款日中的年份+2，
     *      以此类推；若后续月份中没有首次付款日期中指定的“日”，则默认当月最后一日为计划付款日期。若指定首次付款日期中的“日”为当月最后一天，
     *      则后续月份的计划付款日期也为当月最后一天。
     *
     */

    @Test
    public void generatePaymentPlan() {

        System.out.println("---------- 测试数据1 ----------");
        /**
         * 一次性支付
         */
        BigDecimal totalAmt = new BigDecimal("8888.8888").setScale(4, RoundingMode.HALF_DOWN);
        int period = 1;
        Date startDate = DateUtil.parse("2020-01-10");
        Date endDate = DateUtil.parse("2021-03-10");
        List<PaymentPlanBean> paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据2 ----------");
        /**
         * 按月支付
         * 起始日期 day 小于等于 结束日期 day;且 起始日期 day < 28(月份最小日数)
         */
        totalAmt = new BigDecimal("8888.8888").setScale(4, RoundingMode.HALF_DOWN);
        period = 2;
        startDate = DateUtil.parse("2020-01-10");
        endDate = DateUtil.parse("2021-03-10");
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据3 ----------");
        /**
         * 按月支付
         * 起始日期 day 小于等于 结束日期 day;且 起始日期 day 大于 28(最小月份日数)
         */
        startDate = DateUtil.parse("2020-01-30");
        endDate = DateUtil.parse("2021-03-10");
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据4 ----------");
        /**
         * 按月支付
         * 起始日期 day 为月底最后一天
         */
        startDate = DateUtil.parse("2020-01-31");
        endDate = DateUtil.parse("2021-03-10");
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据5 ----------");
        /**
         * 按季支付
         */
        startDate = DateUtil.parse("2020-01-30");
        endDate = DateUtil.parse("2021-03-10");
        period = 3;
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据6 ----------");
        /**
         * 按半年支付
         */
        startDate = DateUtil.parse("2020-01-30");
        endDate = DateUtil.parse("2021-03-10");
        period = 4;
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));

        System.out.println("---------- 测试数据7 ----------");
        /**
         * 按年支付
         */
        startDate = DateUtil.parse("2020-01-30");
        endDate = DateUtil.parse("2021-03-10");
        period = 5;
        paymentPlanList = FinanceUtil.generatePaymentPlan(totalAmt, period, startDate, endDate);
        paymentPlanList.stream().forEach(paymentPlan -> System.out.println(paymentPlan));



    }
}