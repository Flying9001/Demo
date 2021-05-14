package com.ljq.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Description: 喝酒任务
 * @Author: junqiang.lu
 * @Date: 2021/5/14
 */
@Slf4j
public class DrinkTask implements Callable<Integer> {

    /**
     * 当前杯数
     */
    private int cupNumber;

    public DrinkTask(int cupNumber) {
        this.cupNumber = cupNumber;
    }

    @Override
    public Integer call() throws Exception {
        log.info("武松喝完了第[" + cupNumber + "]杯酒");
        Thread.sleep(100);
        return cupNumber;
    }
}
