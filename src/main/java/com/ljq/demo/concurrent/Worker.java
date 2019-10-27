package com.ljq.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 工作负载(线程)
 * @Author: junqiang.lu
 * @Date: 2019/10/27
 */
public class Worker extends Thread{

    /**
     * 线程休眠时间
     */
    private int delay;
    /**
     * 线程等待计数器
     */
    private CountDownLatch countDownLatch;


    /**
     * 构造方法
     *
     * @param delay
     * @param countDownLatch
     * @param name
     */
    public Worker(int delay, CountDownLatch countDownLatch, String name) {
        super(name);
        this.delay = delay;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " finished !");
            System.out.println("countDownLatch count: " + countDownLatch.getCount());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }

        super.run();
    }
}
