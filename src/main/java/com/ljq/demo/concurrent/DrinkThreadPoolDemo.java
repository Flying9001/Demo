package com.ljq.demo.concurrent;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.thread.ThreadUtil;
import com.ljq.demo.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 喝酒线程池示例
 * @Author: junqiang.lu
 * @Date: 2021/5/14
 */
@Slf4j
public class DrinkThreadPoolDemo {

    public static void main(String[] args) {
        manualThreadPool();
        huToolThreadUtil();
        localThreadPoolUtil();
    }

    /**
     * 手动创建线程池
     */
    public static void manualThreadPool() {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,10,100,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), ThreadFactoryBuilder.create().build(),
                new ThreadPoolExecutor.AbortPolicy());
        // 总杯数
        int totalCup = 100;
        int cupNumber;
        for (int i = 1; i <= totalCup; i++) {
            try {
                cupNumber = executor.submit(new DrinkTask(i)).get();
                log.info("manual cupNumber: {}", cupNumber);
            } catch (InterruptedException e) {
                log.error("线程池执行错误", e);
            } catch (ExecutionException e) {
                log.error("武松喝醉了", e);
            }
        }
        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 使用 hutool 线程工具类
     * (线程池不会自动销毁)
     */
    public static void huToolThreadUtil() {
        // 总杯数
        int totalCup = 100;
        int cupNumber;
        for (int i = 1; i <= totalCup; i++) {
            try {
                cupNumber = ThreadUtil.execAsync(new DrinkTask(i)).get();
                log.info("hutool cupNumber: {}", cupNumber);
            } catch (InterruptedException e) {
                log.error("线程池执行错误", e);
            } catch (ExecutionException e) {
                log.error("武松喝醉了", e);
            }
        }
    }

    /**
     * 本地线程池工具类
     */
    public static void localThreadPoolUtil() {
        // 总杯数
        int totalCup = 100;
        int cupNumber;
        for (int i = 1; i <= totalCup; i++) {
            try {
                cupNumber = ThreadPoolUtil.executeAsync(new DrinkTask(i)).get();
                log.info("local cupNumber: {}", cupNumber);
            } catch (InterruptedException e) {
                log.error("线程池执行错误", e);
            } catch (ExecutionException e) {
                log.error("武松喝醉了", e);
            }
        }
        ThreadPoolUtil.shutdown();

    }
}
