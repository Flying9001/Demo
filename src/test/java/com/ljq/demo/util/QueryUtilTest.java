package com.ljq.demo.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class QueryUtilTest {

    @Test
    public void createQuery() throws Exception {

        int page = -1;
        int limit = 1;
        String sidx = "insert_time";
        String order = "desc";
        Map<String, Object> queryMap = new HashMap<>(16);
        queryMap.put("currPage", page);
        queryMap.put("pageLimit", limit);
        queryMap.put("sidx", sidx);
        queryMap.put("order", order);

        QueryUtil queryUtil = new QueryUtil(queryMap);

        /**
         * 遍历 map
         */
        for (Map.Entry<String, Object> entry : queryMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("---------- 分割线 ----------");
        for (Map.Entry<String, Object> entry : queryUtil.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }
}