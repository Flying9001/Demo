package com.ljq.demo.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateUtilTest {

    @Test
    public void getTimes() {
        int a = 14;
        int b = 5;
        // 付款次数
        int numbers = CalculateUtil.getTimes(a, b);
        System.out.println("付款总次数: " + numbers);
        // 代付款总金额
        double totalAmount = 15001;
        // 临时金额,除去最后一次付款金额的总金额
        double tmpAmount = 0;
        // 平均每次付款金额
        BigDecimal perAmount = CalculateUtil.divide(totalAmount, numbers, 2);
        tmpAmount = CalculateUtil.multiply(perAmount.doubleValue(), numbers, 2).doubleValue();
        System.out.println("平均每次金额: " + perAmount);
        // 最后一次付款金额
        BigDecimal lastPerAmount = CalculateUtil.add(perAmount.doubleValue(),
                CalculateUtil.subtract(totalAmount, tmpAmount,2).doubleValue(), 2);
        System.out.println("最后一次金额: " + lastPerAmount);

    }


    @Test
    public void multiply() {
        BigDecimal a = new BigDecimal(1).setScale(6);
        BigDecimal b = new BigDecimal(2).setScale(6);
        System.out.println("a:" + a);
        BigDecimal sum = CalculateUtil.add(a.doubleValue(), b.doubleValue(), CalculateUtil.DEFAULT_SCALE);
        System.out.println("sum: " + sum);
        BigDecimal product = CalculateUtil.multiply(a.doubleValue(), b.doubleValue(), CalculateUtil.DEFAULT_SCALE);
        System.out.println("product: " + product);
        BigDecimal product2 = CalculateUtil.multiply(a.doubleValue(), b.doubleValue(), 6,6);
        System.out.println("product2: " + product2);


    }

    @Test
    public void doubleSubTest() {
        Double a = 6.56;
        System.out.println(a/100);
    }

    @Test
    public void bigDecimalTest(){
        BigDecimal amt = new BigDecimal("100").setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(amt);

    }

}