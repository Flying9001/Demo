package com.ljq.demo.object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: Lambda 示例
 * @Author: junqiang.lu
 * @Date: 2019/8/1
 */
public class LambdaDemo {

    @Test
    public void lambdaDemo() {
        List<String> words = new ArrayList<>(16);
        words.add("bbb");
        words.add("dddd");
        words.add("aaaaa");
        words.add("c");

        words.stream().forEach(s -> {
            System.out.println(s);
        });

        
        words.sort(Comparator.comparingInt(String::length));
        words.stream().forEach(s -> {
            System.out.println(s);
        });



    }

    public void emptyListTest(){
        Collections.emptyList();

    }

}
