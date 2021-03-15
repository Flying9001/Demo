package com.ljq.demo.util;

import com.ljq.demo.bean.PaymentPlanBean;
import com.ljq.demo.constant.PaymentPlanConst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 财务工具类
 * @Author: junqiang.lu
 * @Date: 2021/3/12
 */
public class FinanceUtil {

    /**
     * 金额计算精度
     */
    public static final int AMT_SCALE = 4;
    /**
     * 比例计算精度
     */
    public static final int RATIO_SCALE = 2;


    private FinanceUtil() {
    }

    /**
     * 生成收付款计划
     *
     * @param totalAmt 收付款总金额
     * @param period 收付款周期枚举值
     * @param startDate 首次收付款日期
     * @param endDate 最后一次收付款日期
     * @return
     */
    public static List<PaymentPlanBean> generatePaymentPlan(BigDecimal totalAmt, int period, Date startDate,
                                                            Date endDate) {
        // 收付款周期(以月为单位)
        int paymentPeriodMonth = convertPaymentPeriod(period);
        // 收付款期数
        int paymentNumber = getPaymentNumber(paymentPeriodMonth, startDate, endDate);
        // 首次付款日是否为所在月最后一天
        boolean isLastDayOfMonth = FinanceDateUtil.isLastDayOfMonth(startDate);
        // 平均收付款比例
        BigDecimal paymentRatio = CalculateUtil.divide(100, paymentNumber, RATIO_SCALE, RATIO_SCALE);
        // 平均每次付款金额
        BigDecimal perPaymentAmt = CalculateUtil.divide(totalAmt.doubleValue(),paymentNumber, AMT_SCALE, AMT_SCALE);
        // 当前还款日期
        Date currentRepaymentDate = startDate;
        // 生成除最后一期外的收付款数据
        List<PaymentPlanBean> paymentPlanList = new ArrayList<>();
        PaymentPlanBean paymentPlan;
        for (int i = 1; i <= paymentNumber; i++) {
            paymentPlan = new PaymentPlanBean();
            paymentPlan.setSortNo(i);
            paymentPlan.setPaymentRatio(paymentRatio);
            paymentPlan.setPlanPayAmt(perPaymentAmt);
            if (i > 1) {
                currentRepaymentDate = FinanceDateUtil.getNextRepaymentDate(startDate,
                        (i-1) * paymentPeriodMonth, isLastDayOfMonth);
            }
            paymentPlan.setPlanPayDate(currentRepaymentDate);
            paymentPlanList.add(paymentPlan);
        }
        // 计算最后一次收付款数据
        // 最后一次收付款比例
        BigDecimal lastPaymentRatio = CalculateUtil.subtract(100, CalculateUtil
                .multiply(paymentRatio.doubleValue(), (paymentNumber -1), RATIO_SCALE).doubleValue(),RATIO_SCALE);
        // 最后一次收收付款金额
        BigDecimal lastPaymentAmt = CalculateUtil.subtract(totalAmt.doubleValue(), CalculateUtil
                .multiply(perPaymentAmt.doubleValue(), (paymentNumber-1),AMT_SCALE).doubleValue(),AMT_SCALE);
        // 最后一次还款日期
        currentRepaymentDate = currentRepaymentDate.before(endDate) ?
                currentRepaymentDate : endDate;
        paymentPlanList.get(paymentNumber -1).setPaymentRatio(lastPaymentRatio);
        paymentPlanList.get(paymentNumber -1).setPlanPayAmt(lastPaymentAmt);
        paymentPlanList.get(paymentNumber -1).setPlanPayDate(currentRepaymentDate);
        return paymentPlanList;
    }

    /**
     * 转换付款周期，按月为单位
     *
     * @param paymentPeriod
     * @return
     */
    public static int convertPaymentPeriod(int paymentPeriod) {
        int defaultMonth = 1;
        switch (paymentPeriod) {
            case PaymentPlanConst.PAYMENT_PERIOD_ONCE:
                return 0;
            case PaymentPlanConst.PAYMENT_PERIOD_MONTH:
                return defaultMonth;
            case PaymentPlanConst.PAYMENT_PERIOD_SEASON:
                return 3;
            case PaymentPlanConst.PAYMENT_PERIOD_HALF_YEAR:
                return 6;
            case PaymentPlanConst.PAYMENT_PERIOD_YEAR:
                return 12;
            default: break;
        }
        return defaultMonth;
    }

    /**
     * 获取收付款次数
     *
     * @param paymentPeriodMonth 还款周期(按月为单位)
     * @param startDate 首次收付款日期
     * @param endDate 最后一次收付款日期
     * @return
     */
    public static int getPaymentNumber(int paymentPeriodMonth, Date startDate, Date endDate) {
        if (paymentPeriodMonth == 0) {
            return 1;
        }
        // 月份间隔
        int monthDiff = FinanceDateUtil.getMonthDifference(startDate, endDate) + 1;
        // 计算收付款次数
        int reminder = monthDiff % paymentPeriodMonth;
        if (reminder == 0) {
            return monthDiff / paymentPeriodMonth;
        }
        return (monthDiff / paymentPeriodMonth) + 1;
    }



}
