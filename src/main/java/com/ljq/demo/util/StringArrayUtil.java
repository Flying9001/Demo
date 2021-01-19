package com.ljq.demo.util;

import java.util.Arrays;

/**
 * @Description: 字符串转数组工具
 * @Author: junqiang.lu
 * @Date: 2021/1/19
 */
public class StringArrayUtil {

    private StringArrayUtil(){
    }

    /**
     * 数组格式字符串转 String 数组
     *
     * @param source
     * @return
     */
    public static String[] toStringArray(String source) {
        return source.substring(1,source.length()-1).split(",");
    }

    /**
     * 数组格式字符串转 int 数组
     *
     * @param source
     * @return
     */
    public static int[] toIntArray(String source) {
        return Arrays.stream(toStringArray(source)).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 数组格式字符串转 long 数组
     *
     * @param source
     * @return
     */
    public static long[] toLongArray(String source) {
        return Arrays.stream(toStringArray(source)).mapToLong(Long::parseLong).toArray();
    }

    /**
     * 数组格式字符串转 double 数组
     *
     * @param source
     * @return
     */
    public static double[] toDoubleArray(String source) {
        return Arrays.stream(toStringArray(source)).mapToDouble(Double::parseDouble).toArray();
    }

    /**
     * 数组格式字符串转 Integer 数组
     *
     * @param source
     * @return
     */
    public static Integer[] toIntegerArray(String source) {
        String[] strings = toStringArray(source);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }



}
