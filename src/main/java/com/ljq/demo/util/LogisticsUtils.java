package com.ljq.demo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljq.demo.bean.LogisticsInfo;
import com.ljq.demo.bean.LogisticsTrace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 物流信息工具类
 * @Author: junqiang.lu
 * @Date: 2018/9/26
 */
public final class LogisticsUtils {



    /**
     * 解析通过「A」接口提供方获取的物流信息
     * json 解析: jackson, https://www.baeldung.com/jackson
     *
     * @param jsonStr 物流信息,json 格式字符串
     * @return 封装后的物流信息
     */
    public static LogisticsInfo getLogisticsInfoByA(String jsonStr) throws IOException {

        LogisticsInfo logisticsInfo = new LogisticsInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonStr);
        String comCode = rootNode.get("comCodeA") != null ? rootNode.get("comCodeA").asText() : "";
        String postNo = rootNode.get("postNoA") != null ? rootNode.get("postNoA").asText() : "";
        boolean success = rootNode.get("successA") != null ? rootNode.get("successA").asBoolean() : false;
        String failReason = rootNode.get("failReasonA") != null ? rootNode.get("failReasonA").asText() : "";
        int state = rootNode.get("stateA") != null ? rootNode.get("stateA").asInt() : 0;

        logisticsInfo.setComCode(comCode);
        logisticsInfo.setPostNo(postNo);
        logisticsInfo.setSuccess(success);
        logisticsInfo.setFailReason(failReason);
        logisticsInfo.setState(state);
        /**
         * 遍历物流轨迹
         */
        if (rootNode.get("tracesA") != null && rootNode.get("tracesA").size() > 0) {
            List<LogisticsTrace> logisticsTraceList = new ArrayList<>(16);
            LogisticsTrace logisticsTrace;
            JsonNode traceNode = rootNode.get("tracesA");
            for (int i = 0; i < traceNode.size(); i++) {
                logisticsTrace = new LogisticsTrace();
                logisticsTrace.setAcceptTime(traceNode.get(i).get("acceptTimeA").asText());
                logisticsTrace.setAcceptStation(traceNode.get(i).get("acceptStationA").asText());
                logisticsTraceList.add(logisticsTrace);
            }
            logisticsInfo.setLogisticsTraceList(logisticsTraceList);
        }
        return logisticsInfo;
    }

    /**
     * 解析通过「B」接口提供方获取的物流信息
     * json 解析: jackson, https://www.baeldung.com/jackson
     *
     * @param jsonStr 物流信息,json 格式字符串
     * @return 封装后的物流信息
     */
    public static LogisticsInfo getLogisticsInfoByB(String jsonStr) throws IOException {
        LogisticsInfo logisticsInfo = new LogisticsInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonStr);
        String comCode = rootNode.get("comCodeB") != null ? rootNode.get("comCodeB").asText() : "";
        String postNo = rootNode.get("postNoB") != null ? rootNode.get("comCodeB").asText() : "";
        boolean success = rootNode.get("successB") != null ? rootNode.get("successB").asBoolean() : false;
        String failReason = rootNode.get("failReasonB") != null ? rootNode.get("failReasonB").asText() : "";
        int state = rootNode.get("stateB") != null ? rootNode.get("stateB").asInt() : 0;

        logisticsInfo.setComCode(comCode);
        logisticsInfo.setPostNo(postNo);
        logisticsInfo.setSuccess(success);
        logisticsInfo.setFailReason(failReason);
        logisticsInfo.setState(state);
        /**
         * 遍历物流轨迹
         */
        if (rootNode.get("tracesB") != null && rootNode.get("tracesB").size() > 0) {
            List<LogisticsTrace> logisticsTraceList = new ArrayList<>(16);
            LogisticsTrace logisticsTrace;
            JsonNode traceNode = rootNode.get("tracesB");
            for (int i = 0; i < traceNode.size(); i++) {
                logisticsTrace = new LogisticsTrace();
                logisticsTrace.setAcceptTime(traceNode.get(i).get("acceptTimeB").asText());
                logisticsTrace.setAcceptStation(traceNode.get(i).get("acceptStationB").asText());
                logisticsTraceList.add(logisticsTrace);
            }
            logisticsInfo.setLogisticsTraceList(logisticsTraceList);
        }
        return logisticsInfo;
    }



    private LogisticsUtils(){}
}
