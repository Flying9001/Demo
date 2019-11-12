package com.ljq.demo.concurrent;

/**
 * @Description: 计算器
 * @Author: junqiang.lu
 * @Date: 2019/11/11
 */
public class CalculateUtil {

    /**
     * 加法计算
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        System.out.println(Thread.currentThread().getName() + " : " + a + " + " + b);
        int c = a + b;
        System.out.println(Thread.currentThread().getName() + " = " + c);
        return c;
    }
}
