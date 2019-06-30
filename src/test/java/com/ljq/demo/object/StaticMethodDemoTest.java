package com.ljq.demo.object;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

public class StaticMethodDemoTest {

    @Test
    public void from() {
        Instant instant =Instant.now();
        Date date = StaticMethodDemo.from(instant);
        System.out.println("date: " + date);

    }

    @Test
    public void of() throws Exception {
        Set<Enum> set = StaticMethodDemo.of(StaticMethodDemo.Rank.JACK, StaticMethodDemo.Rank.KING, StaticMethodDemo.Rank.QUEEN);
        System.out.println("set" + set);

    }

    @Test
    public void valueOf() {
        Boolean flag = StaticMethodDemo.valueOf(false);
        System.out.println("flag: " + flag);

    }

    @Test
    public void getInstance() {
        StaticMethodDemo methodDemo = StaticMethodDemo.getInstance();
        methodDemo.setTag("Hello world !!!");
        System.out.println("staticMethodDemo - 1: " + methodDemo);
        methodDemo = StaticMethodDemo.getInstance();
        System.out.println("staticMethodDemo - 2: " + methodDemo);

    }

    @Test
    public void create() {
        StaticMethodDemo methodDemo = StaticMethodDemo.create();
        methodDemo.setTag("I'm fine !");
        System.out.println("staticMethodDemo - 1: " + methodDemo);
        methodDemo = StaticMethodDemo.create();
        System.out.println("staticMethodDemo - 2: " + methodDemo);


    }
}