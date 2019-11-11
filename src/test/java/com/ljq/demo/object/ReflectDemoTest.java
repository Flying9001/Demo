package com.ljq.demo.object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReflectDemoTest {

    @Test
    public void reflect() {
//        String param = "66666";
//        ReflectDemo.reflect(param);

        List<String> stringList = new ArrayList<>(16);
        for (String s : stringList) {
            System.out.println("Result" + s);
        }

    }
}