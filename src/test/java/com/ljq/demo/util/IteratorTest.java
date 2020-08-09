package com.ljq.demo.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 迭代器测试类
 * @Author: junqiang.lu
 * @Date: 2020/8/9
 */

public class IteratorTest {


    /**
     * 迭代器遍历-新旧对比
     */
    @Test
    public  void iteratorTest(){
        List<String> userList = new ArrayList();
        userList.add("ChaiXuKun");
        userList.add("LuBenWei");
        userList.add("LuoZhiXiang");

        Iterator<String> it = userList.iterator();
        Iterator<String> it2 = userList.iterator();

        // 旧式遍历法
        while(it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }

        System.out.println("------------ 新旧分割线 ------------");

        // 新式遍历法(Since jdk 1.8)
        it2.forEachRemaining(item -> {
            System.out.println(item);
        });
    }



}
