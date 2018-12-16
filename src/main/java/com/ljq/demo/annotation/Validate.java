package com.ljq.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 校验注解,添加该注解则表明该参数需要进行校验
 * @Author: junqiang.lu
 * @Date: 2018/12/16
 *
 * @Retention: 定义注解的保留策略
 *     @Retention(RetentionPolicy.SOURCE)  注解仅存在于源码中，在class字节码文件中不包含
 *     @Retention(RetentionPolicy.CLASS)   默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
 *     @Retention(RetentionPolicy.RUNTIME) 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 *
 * @Target 注解类型声明
 *     CONSTRUCTOR 构造方法声明
 *     FIELD 字段声明（包括枚举常量）LOCAL_VARIABLE 局部变量声明
 *     METHOD 方法声明
 *     PACKAGE 包声明
 *     PARAMETER 参数声明
 *     TYPE 类、接口（包括注释类型）或枚举声明
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
public @interface Validate {



}
