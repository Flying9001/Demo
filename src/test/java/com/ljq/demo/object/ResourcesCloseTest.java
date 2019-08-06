package com.ljq.demo.object;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 资源关闭测试类
 * @Author: junqiang.lu
 * @Date: 2019/7/2
 */
public class ResourcesCloseTest {

    /**
     * try-with-resources 示例
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static String firstLineOfFile(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    /**
     * 泛型测试
     *
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> union2(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    @Test
    public void firstLineOfFileTest() throws IOException {

        String path = "F:\\download\\errorLog-2019-06-30.0.txt";

        String firstLine = ResourcesCloseTest.firstLineOfFile(path);


        System.out.println(firstLine);

    }







}
