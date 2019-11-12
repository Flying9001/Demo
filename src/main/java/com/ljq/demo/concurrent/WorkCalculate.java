package com.ljq.demo.concurrent;

import lombok.Data;

/**
 * @Description: 计算器工作线程
 * @Author: junqiang.lu
 * @Date: 2019/11/11
 */
@Data
public class WorkCalculate implements Runnable {

    private int paramA;

    private int paramB;



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + paramA + " + " + paramB);
        System.out.println(Thread.currentThread().getName() + " : " + paramA + " + " + paramB);
        CalculateUtil.add(paramA, paramB);
    }

    /**
     * 测试结果显示:
     *
     * 类中的成员变量 paramA、paramB 属于共享变量
     * 该类中的方法操作这些变量时会存在因并发而导致数据不同步的问题
     * 使用 CalculateUtil.add() 方法进行计算，计算结果不受程序并发的影响。传入到 add() 方法
     *     的 paramA、paramB 在 Calculate 类(add() 方法)中属于局部变量
     *
     */
}
