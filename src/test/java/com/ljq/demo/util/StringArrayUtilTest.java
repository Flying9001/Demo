package com.ljq.demo.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StringArrayUtilTest {

    private String source = "[1,3,5,7,9]";

    @Test
    public void toStringArray() {
        System.out.println(Arrays.toString(StringArrayUtil.toStringArray(source)));
    }

    @Test
    public void toIntArray() {
        System.out.println(Arrays.toString(StringArrayUtil.toIntArray(source)));
    }

    @Test
    public void toLongArray() {
        System.out.println(Arrays.toString(StringArrayUtil.toLongArray(source)));
    }

    @Test
    public void toDoubleArray() {
        System.out.println(Arrays.toString(StringArrayUtil.toDoubleArray(source)));
    }

    @Test
    public void toIntegerArray() {
        System.out.println(Arrays.toString(StringArrayUtil.toIntegerArray(source)));
    }
}