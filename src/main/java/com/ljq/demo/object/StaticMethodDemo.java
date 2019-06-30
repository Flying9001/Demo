package com.ljq.demo.object;

import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * @Description: 静态工厂方法创建对象示例类
 * @Author: junqiang.lu
 * @Date: 2019/6/29
 */
@Data
public class StaticMethodDemo {

    private String tag;

    private StaticMethodDemo(){

    }

    /**
     * from 示例
     * @param instant
     * @return
     */
    public static Date from(Instant instant) {
        return Date.from(instant);
    }

    public enum Rank {
        JACK,
        QUEEN,
        KING
    }

    /**
     * of 示例
     * @param element1
     * @return
     * @throws Exception
     */
    public static Set<Enum> of(Enum element1, Enum element2, Enum element3) throws Exception{
        Set<Enum> set = EnumSet.of(element1, element2, element3);
        return set;
    }

    /**
     * valueOf 示例
     * @param b
     * @return
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * getInstance 示例
     *
     * @return
     */
    public static volatile StaticMethodDemo staticMethodDemo;
    public static StaticMethodDemo getInstance() {
        if (staticMethodDemo == null) {
            synchronized (StaticMethodDemo.class) {
                if (staticMethodDemo == null) {
                    staticMethodDemo = new StaticMethodDemo();
                }
            }
        }
        return staticMethodDemo;
    }

    /**
     * create 示例
     *
     * @return
     */
    public static StaticMethodDemo create() {
        return new StaticMethodDemo();
    }




}
