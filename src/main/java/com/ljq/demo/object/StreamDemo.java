package com.ljq.demo.object;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Description: Stream 应用示例
 * @Author: junqiang.lu
 * @Date: 2019/8/8
 */
public class StreamDemo {

    /**
     * 迭代器转Stream
     * @param iterable
     * @param <E>
     * @return
     */
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {

        return StreamSupport.stream(iterable.spliterator(),false);
    }



}
