package com.ljq.demo.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * @Description: java 发射示例
 * @Author: junqiang.lu
 * @Date: 2019/10/15
 */
public class ReflectDemo {

    public static void reflect(String param) {
        // Translate the class name into a Class object
        Class<? extends Set<String>> cl = null;
        try {
            cl = (Class<? extends Set<String>>)
                    Class.forName(param);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Get the constructor
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // Instantiate the set
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        // Exercise the set
        s.addAll(Arrays.asList(param));
        System.out.println(s);



    }
}
