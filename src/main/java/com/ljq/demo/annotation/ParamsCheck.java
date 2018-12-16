package com.ljq.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: (自定义)参数校验注解, 添加该注解则表明该参数需要满足注解中对应的参数要求
 * @Author: junqiang.lu
 * @Date: 2018/12/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface ParamsCheck {

    /**
     * 参数描述信息(建议每一个注解都包含该参数)
     *
     * @return
     */
    String desc() default "";

    /**
     * 非空
     * 对于 String 对象,值为 "" 也会返回非空信息
     *
     * @return
     */
    boolean notNull() default false;

    /**
     * 最大值(数字参数使用该注解,参数值不可大于该限定值)
     * 支持 int,Integer,float,Float,double,Double 类型字段
     *
     * @return
     */
    int max() default -1;

    /**
     * 最小值(与 max 对应,数字参数使用该注解,参数值不可小于该限定值)
     * 支持 int,Integer,float,Float,double,Double 类型字段
     *
     * @return
     */
    int min() default -1;

    /**
     * 字符串最大长度值(String 参数使用该注解,字符串长度不可大于该限定值)
     *
     * @return
     */
    int strMaxLength() default -1;

    /**
     * 字符串最小长度值(String 参数使用该注解,字符串长度不可小于该限定值)
     *
     * @return
     */
    int strMinLength() default -1;

    /**
     * 是否为(中国大陆)手机号
     * 不校验非空,参数为空会抛出空指针异常(NullPointException)
     *
     * @return
     */
    boolean isMobile() default false;

    /**
     * 是否为邮箱
     * 不校验非空,参数为空会抛出空指针异常(NullPointException)
     *
     * @return
     */
    boolean isEmail() default false;

    /**
     * 是否为字母数字组成的字符串
     * 包含 a-z,A-Z 以及 0-9,不包含符号
     * 不校验非空,参数为空会抛出空指针异常(NullPointException)
     *
     * @return
     */
    boolean isAlphanumericStr() default false;

    /**
     * 是否为纯数字组成的字符串
     * 只包含 0-9
     * 不校验非空,参数为空会抛出空指针异常(NullPointException)
     *
     * @return
     */
    boolean isNumericStr() default false;











}
