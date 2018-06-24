package com.ljq.demo.util;

/**
 * @Description: java util class demo
 * @Author: junqiang.lu
 * @Date: 2018/6/24
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 使用 final 修饰类,禁止继承
 */
public final class JavaUtilDemo {

    /**
     * 使用 private 修饰构造方法,将构造方法私有化,禁止使用 new 的方式来创建类的实例
     */
    private JavaUtilDemo(){}

    /**
     * 工具类中的方法需要使用 static 修饰
     */
    /**
     * 获取当前时间(线程安全)
     *
     * @return string 当前时间,格式为:"yyyy-MM-dd HH:mm:ss:SSS"
     * @since java 8(jdk 1.8+ 才可以使用该方法)
     * */
    public static String getCurrentDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatter);
    }
}
