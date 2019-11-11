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
        CalculateUtil.addUnThreadSafe(paramA, paramB);
    }
}
