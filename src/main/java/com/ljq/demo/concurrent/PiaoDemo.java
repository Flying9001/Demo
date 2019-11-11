package com.ljq.demo.concurrent;

/**
 * @Description: 抢票示例(主程序)
 * @Author: junqiang.lu
 * @Date: 2019/11/11
 */
public class PiaoDemo {


    public static void main(String[] args) {
        int countPiao = 500;
        WorkPiao workPiao = new WorkPiao(countPiao);
        for (int i = 0; i < 5; i++) {
            new Thread(workPiao, "同步窗口" + (i + 1)).start();
        }
    }
}
