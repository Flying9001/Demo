package com.ljq.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 线程同步 CountDownLatch 示例
 * @Author: junqiang.lu
 * @Date: 2019/10/27
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        Worker worker1 = new Worker(1000, countDownLatch, "Worker-1");
        Worker worker2 = new Worker(2000, countDownLatch, "Worker-2");
        Worker worker3 = new Worker(3000, countDownLatch, "Worker-3");
        Worker worker4 = new Worker(4000, countDownLatch, "Worker-4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + " has finished !!!");




    }



}
