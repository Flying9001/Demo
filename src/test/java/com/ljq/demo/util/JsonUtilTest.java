package com.ljq.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljq.demo.bean.FormAreaInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class JsonUtilTest {

    /**
     * JSON Str <=> JSON,参考: https://tools.knowledgewalls.com
     */
    private static final String jsonStr = "{\n" +
            "    \"formSubArea_1\": {\n" +
            "        \"formMainBusinessFlag\": true,\n" +
            "        \"formTableName\": \"business_a\",\n" +
            "        \"field1\": \"字段一\",\n" +
            "        \"field2\": \"字段二\"\n" +
            "    },\n" +
            "    \"formSubArea_2\": {\n" +
            "        \"formMainBusinessFlag\": false,\n" +
            "        \"formTableName\": \"\",\n" +
            "        \"field3\": \"字段三\",\n" +
            "        \"field4\": \"字段四\"\n" +
            "    },\n" +
            "    \"formSubArea_3\": {\n" +
            "        \"formMainBusinessFlag\": false,\n" +
            "        \"formTableName\": \"business_b\",\n" +
            "        \"items\": [\n" +
            "            {\n" +
            "                \"field5\": \"字段五\",\n" +
            "                \"field6\": \"字段六\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"field5\": \"字段五\",\n" +
            "                \"field6\": \"字段六\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";


    @Test
    public void getFormAreaInfo() throws JsonProcessingException {

        JsonNode jsonNode = new ObjectMapper().readTree(jsonStr);

        List<FormAreaInfo> formAreaInfoList = JsonUtil.getFormAreaInfo(jsonNode);
        formAreaInfoList.stream().forEach(formAreaInfo -> {
            log.debug("{}",formAreaInfo);
        });


    }


}