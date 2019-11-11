package com.ljq.demo.concurrent;

/**
 * @Description: 抢票示例(同步)
 * @Author: junqiang.lu
 * @Date: 2019/11/11
 */
public class WorkPiao implements Runnable {

    private int countPiao;

    public WorkPiao(int countPiao) {
        this.countPiao = countPiao;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (countPiao > 0) {
                    --countPiao;
                    System.out.println(Thread.currentThread().getName() + "当前剩余票数: " + countPiao);
                } else {
                    System.out.println(Thread.currentThread().getName() + "票已卖完");
                    break;
                }
            }
        }

    }
}
