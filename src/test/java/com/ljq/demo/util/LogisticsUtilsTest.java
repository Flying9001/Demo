package com.ljq.demo.util;

import com.ljq.demo.bean.LogisticsInfo;
import org.junit.Test;

import java.io.IOException;

public class LogisticsUtilsTest {

    @Test
    public void getLogisticsInfoByA() throws IOException {

        String jsonStrA = "{" +
                "            \"comCodeA\": \"YTO\"," +
                "            \"postNoA\": \"M0101065279\"," +
                "            \"successA\": true," +
                "            \"failReasonA\": \"\"," +
                "            \"stateA\": 3," +
                "            \"tracesA\": [" +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 20:01:04\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已收件\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 22:20:33\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已打包\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 22:23:13\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已发出 下一站 【上海转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 03:07:34\"," +
                "                    \"acceptStationA\": \"【上海转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 03:14:21\"," +
                "                    \"acceptStationA\": \"【上海转运中心】 已发出 下一站 【杭州转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 10:37:02\"," +
                "                    \"acceptStationA\": \"【杭州转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 13:11:00\"," +
                "                    \"acceptStationA\": \"【杭州转运中心】 已发出 下一站 【石桥转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 22:45:20\"," +
                "                    \"acceptStationA\": \"【石桥转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-12 13:19:39\"," +
                "                    \"acceptStationA\": \"客户 签收人: 圆通代签 已签收 感谢使用圆通速递，期待再次为您服务\"" +
                "                }" +
                "            ]" +
                "        }" +
                "}";
        LogisticsInfo logisticsInfo = LogisticsUtils.getLogisticsInfoByA(jsonStrA);
        System.out.println("logisticsInfo: " + logisticsInfo);
    }

}