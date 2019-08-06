package com.ljq.demo.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtilTest {

    @Test
    public void queryUtilTest() throws Exception {
        Map<String, Object> queryMap = new HashMap<>(16);
        queryMap.put("currPage", 2);
        queryMap.put("pageLimit", 6);
        queryMap.put("direction", "ASC");
        queryMap.put("properties", "account");
        QueryUtil queryUtil = new QueryUtil(queryMap);

        System.out.println(queryUtil);

        System.out.println("-------------------------");

        queryMap.clear();
        queryUtil = new QueryUtil(queryMap);
        System.out.println(queryUtil);

    }


    @Test
    public void pageUtilTest() {

        int totalCount = 24;
        int pageLimit = 5;
        List<String> strList = new ArrayList<>(16);
        for (int i = 0; i < pageLimit; i++) {
            strList.add("demo-" + (i + 1));
        }
        PageUtil pageUtil = new PageUtil(strList, totalCount, pageLimit, 0);

        System.out.println(pageUtil);

    }

    @Test
    public void queryUtilAndPageUtilTest() throws Exception {

        int totalCount = 19;
        List<String> stringList = new ArrayList<>(16);
        for (int i = 0; i < totalCount; i++) {
            stringList.add(String.valueOf(i));
        }

        Map<String, Object> queryMap = new HashMap<>(16);
        QueryUtil queryUtil = new QueryUtil(queryMap);
        PageUtil<String> pageUtil = new PageUtil<>(stringList, totalCount, queryUtil.getPageLimit(), queryUtil.getCurrPage());

        System.out.println(queryUtil);
        System.out.println(pageUtil);


    }

}