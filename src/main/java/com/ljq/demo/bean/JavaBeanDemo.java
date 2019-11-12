package com.ljq.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: java bean demo/java bean 的示范类
 * @Author: junqiang.lu
 * @Date: 2018/6/21
 */

/**
 * 通过引入 lombok 包,在java bean 类上边使用 @Setter,@Getter,@ToString 注解
 * 即可实现 setter,getter,和 toString 的方法,无需再自己手写,以精简代码
 */
@Setter
@Getter
@ToString
/**
 * 实现 Serializable 接口,实现序列化
 */
public class JavaBeanDemo implements Serializable {
    /**
     * 定义 serialVersionUID,确保序列化与反序列化的过程中,属性值不变
     */
    private static final long serialVersionUID = 4833136009765814333L;

    private String username;

    /**
     * 引入 jackson 包,用于处理 json 数据转换
     * 使用 @JsonIgnore 注解,java 对象在转化为 json 对象时可以忽略此字段
     * 在 java 实体类(entity)中,有些字段在做 json 转换时是不需要的,则可以使用该注解
     */
    @JsonIgnore
    private String passcode;

    /**
     * 对于 boolean 类型的字段,不要以 is 开头,eg: isPay
     * 因为 boolean 类型的字段的 getter 方法以 is 开头的,而非 get
     * 如果字段也是以 is 开头,则会被忽略掉本身的 is,
     * 在客户端通过接口进行传值时会引起后台获取不到对应值或 json 转换失败等问题
     */
    private boolean ifVIP;

}
