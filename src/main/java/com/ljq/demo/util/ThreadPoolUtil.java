package com.ljq.demo.util;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description: 线程池工具类
 * @Author: junqiang.lu
 * @Date: 2021/5/14
 */
public class ThreadPoolUtil {

    private ThreadPoolUtil(){
    }

    static {
        initExecutor();
    }

    /**
     * 线程池执行器
     */
    private static transient ThreadPoolExecutor executor;

    /**
     * 执行任务
     * (不包含返回值)
     *
     * @param command
     */
    public static void execute(Runnable command) {
        executor.execute(command);
    }

    /**
     * 执行任务
     * (包含返回值)
     *
     * @param task
     * @param <T>
     * @return
     */
    public static <T> Future<T> executeAsync(Callable<T> task) {
        return executor.submit(task);
    }

    /**
     * 销毁线程池
     */
    public static void shutdown() {
        executor.shutdown();
    }

    /**
     * 初始化线程池
     */
    private static void initExecutor() {
        if (executor == null || executor.isShutdown()) {
            synchronized (ThreadPoolUtil.class) {
                if (executor == null || executor.isShutdown()) {
                    executor = new ThreadPoolExecutor(4,10,100,
                            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000),
                            ThreadFactoryBuilder.create().build(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
    }


}
