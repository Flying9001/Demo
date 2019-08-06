package com.ljq.demo.enums;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class CalculateEnumDemoTest {

    @Test
    public void enumTest() {
        double x = 2D;
        double y = 3D;
        for (CalculateEnumDemo enumDemo : CalculateEnumDemo.values()) {
            System.out.printf("%f %s %f = %f%n", x, enumDemo, y, enumDemo.apply(x, y));
        }


    }

    @Test
    public void enumToStringTest() {
        Map<String, CalculateEnumDemo> stringToEnum = Stream.of(CalculateEnumDemo.values()).collect(toMap(Object::toString, e -> e));

        System.out.println(stringToEnum);

        for (Map.Entry key : stringToEnum.entrySet()) {
            Optional<CalculateEnumDemo> optional = Optional.ofNullable(stringToEnum.get(key.getKey()));
            System.out.println(optional);

        }
    }

    @Test
    public void enumSetTest() {
        EnumSet<CalculateEnumDemo> enumSet = EnumSet.of(CalculateEnumDemo.DIVIDE,CalculateEnumDemo.PLUS);
        System.out.println(enumSet);
    }

}