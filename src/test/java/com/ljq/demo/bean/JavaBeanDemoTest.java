package com.ljq.demo.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.junit.Test;

public class JavaBeanDemoTest {

    @Test
    public void beanCopyTest1() {
        JavaBeanDemo javaBeanDemo1 = new JavaBeanDemo();
        javaBeanDemo1.setUsername("userName1");
        javaBeanDemo1.setPasscode("111111");
        javaBeanDemo1.setIfVIP(false);

        JavaBeanDemo javaBeanDemo2 = javaBeanDemo1;
        System.out.println("javaBean 1 before :" + javaBeanDemo1);
        System.out.println("javaBean 2 before :" + javaBeanDemo2);

        javaBeanDemo2.setUsername("userName2");
        javaBeanDemo2.setPasscode("222222");
        javaBeanDemo2.setIfVIP(true);
        System.out.println("javaBean 1 after :" + javaBeanDemo1);
        System.out.println("javaBean 2 after :" + javaBeanDemo2);

    }

    @Test
    public void beanCopyTest2() {
        JavaBeanDemo javaBeanDemo1 = new JavaBeanDemo();
        javaBeanDemo1.setUsername("userName1");
        javaBeanDemo1.setPasscode("111111");
        javaBeanDemo1.setIfVIP(false);

        JavaBeanDemo javaBeanDemo2 = new JavaBeanDemo();
        BeanUtil.copyProperties(javaBeanDemo1, javaBeanDemo2,
                CopyOptions.create().setIgnoreError(true).setIgnoreNullValue(true));
        System.out.println("javaBean 1 before :" + javaBeanDemo1);
        System.out.println("javaBean 2 before :" + javaBeanDemo2);

        javaBeanDemo2.setUsername("userName2");
        javaBeanDemo2.setPasscode("222222");
        javaBeanDemo2.setIfVIP(true);
        System.out.println("javaBean 1 after :" + javaBeanDemo1);
        System.out.println("javaBean 2 after :" + javaBeanDemo2);

    }

    /**
     * beanCopy 测试结论:
     *
     * beanCopyTest1 中对象通过直接赋值的方式将对象 1 赋值给对象 2 ，此时，如果更新对象 2 的成员变量，
     *     则对象 1 中的成员属性也会跟着改变
     * beanCopyTest2 中对象通过属性复制的方式将值传递给对象 2，则对象 1、对象 2 相对独立，更新对象 2 的属性，
     *     不会对对象 1 产生影响
     *
     */


}