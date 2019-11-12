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

    /**
     * 使用 Junit 进行抢票测试，主线程结束整个程序就会结束,即使票没有被抢完
     * 可参考: com.ljq.demo.concurrent.WorkPiaoTest
     * 使用包含 main() 方法的java程序进行抢票测试,则可以将所有的票抢完
     * 可参考: com.ljq.demo.concurrent.PiaoDemo
     */
}
