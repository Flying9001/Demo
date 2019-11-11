package com.ljq.demo.concurrent;

/**
 * @Description: 计算器测试
 * @Author: junqiang.lu
 * @Date: 2019/11/11
 */
public class CalculateDemo {


    public static void main(String[] args) {
        int count = 50;
        WorkCalculate workCalculate = new WorkCalculate();

        for (int i = 0; i < count; i++) {
            workCalculate.setParamA((i+1));
            workCalculate.setParamB(i+5);
            new Thread(workCalculate, "计算器" + (i + 1)).start();
        }







    }
}
