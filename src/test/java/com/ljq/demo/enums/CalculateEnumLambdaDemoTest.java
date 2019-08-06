package com.ljq.demo.enums;

import org.junit.Test;

public class CalculateEnumLambdaDemoTest {

    @Test
    public void lambdaTest() {
        double x = 2D;
        double y = 3D;
        for (CalculateEnumLambdaDemo lambdaDemo : CalculateEnumLambdaDemo.values()) {
            System.out.printf("%f %s %f = %f%n", x, lambdaDemo, y, lambdaDemo.apply(x, y));
        }

    }

    public void methodReferenceTest() {


    }
}