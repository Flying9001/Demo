package com.ljq.demo.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtilTest {

    @Test
    public void getPageUtil() {

        int totalCount = 24;
        int pageLimit = 5;
        List<String> strList = new ArrayList<>(16);
        for (int i = 0; i < pageLimit; i++) {
            strList.add("demo-" + (i + 1));
        }
        PageUtil pageUtil = new PageUtil(strList, totalCount, pageLimit, 0);

        System.out.println(pageUtil);

    }

    /**
     * 实际业务中 service 实现类中应用分页查询
     * @throws Exception
     */
    @Test
    public void serviceImplQueryTest() throws Exception {

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
         * IntegralGoodsEntity,integralGoodsDao 仅作为演示,该 demo 项目中并不包含
         */
//        List<IntegralGoodsEntity> integralGoodsList = integralGoodsDao.queryList(queryUtil);
//        int total = integralGoodsDao.queryCount(queryUtil);
//        PageUtil pageUtil = new PageUtil(integralGoodsList, total, queryUtil.getLimit(), queryUtil.getPage());



    }

}