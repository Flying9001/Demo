package com.ljq.demo.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 反射示例
 * @Author: junqiang.lu
 * @Date: 2020/9/9
 */
public class ReflectDemo {

    /**
     * 获取结果
     *
     * @param key
     * @return
     */
    public String getResult(String key) {
        System.out.println("Key: " + key);
        return key;
    }

    /**
     * 获取代理类
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public Class getProxyClass(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);

        return clazz;
    }

    /**
     * 获取代理方法
     *
     * @param methodName
     * @param clazz
     * @return
     * @throws NoSuchMethodException
     */
    public Method getProxyMethod(String methodName, Class clazz) throws NoSuchMethodException {
        Method method = clazz.getMethod(methodName, String.class);
        return method;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String className = "com.ljq.demo.util.ReflectDemo";
        String methodName = "getResult";
        String key = "Hello World !!!";
        ReflectDemo reflectDemo = new ReflectDemo();
        // 获取代理类
        Class clazz = reflectDemo.getProxyClass(className);
        // 实例化代理类
        Object classInstance = clazz.newInstance();
        // 获取代理方法
        Method method = reflectDemo.getProxyMethod(methodName, clazz);
        // 执行代理方法
        String result = (String) method.invoke(classInstance, key);
        System.out.println("result: " + result);

    }

}
