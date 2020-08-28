package com.ljq.demo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.ljq.demo.bean.FormAreaInfo;
import com.ljq.demo.constant.FormConst;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Description: JSON 转换工具类
 * @Author: junqiang.lu
 * @Date: 2020/8/9
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {}

    /**
     * 获取表单区域信息
     *
     * @param jsonNode 表单完整数据 json 对象
     * @return
     */
    public static List<FormAreaInfo> getFormAreaInfo(JsonNode jsonNode) {
        List<FormAreaInfo> formAreaInfoList = new ArrayList<>(16);
        // 遍历区域
        jsonNode.fieldNames().forEachRemaining(subAreaId -> {
            JsonNode tmpNode = jsonNode.get(subAreaId);
            FormAreaInfo formAreaInfo = new FormAreaInfo();
            formAreaInfo.setAreaId(subAreaId);
            formAreaInfo.setMainBusinessFlag(Objects.nonNull(tmpNode.get(FormConst.FORM_MAIN_BUSINESS_FLAG)) ?
                    tmpNode.get(FormConst.FORM_MAIN_BUSINESS_FLAG).asBoolean(): false);
            formAreaInfo.setTableName(Objects.nonNull(tmpNode.get(FormConst.TABLE_NAME)) ?
                    tmpNode.get(FormConst.TABLE_NAME).asText() : "");
            // 遍历区域中的字段
            Map<String, Object> fieldMap = new HashMap<>(32);
            List<Map<String, Object>> fieldMapList = new ArrayList<>(16);
            tmpNode.fieldNames().forEachRemaining(fieldName -> {
                if (!Objects.equals(fieldName, FormConst.FORM_MAIN_BUSINESS_FLAG) &&
                        !Objects.equals(fieldName, FormConst.TABLE_NAME)) {
                    // 单独的字段
                    if (tmpNode.get(fieldName).isValueNode()) {
                        fieldMap.put(fieldName, tmpNode.get(fieldName).isTextual() ?
                                tmpNode.get(fieldName).asText() : tmpNode.get(fieldName));
                    }
                    // 列表字段
                    if (tmpNode.get(fieldName).isArray()) {
                        Iterator<JsonNode> it = tmpNode.get(fieldName).iterator();
                        it.forEachRemaining(subNode -> {
                            Map<String, Object> subDataMap = new HashMap<>(32);
                            subNode.fieldNames().forEachRemaining(subFieldName -> {
                                subDataMap.put(subFieldName, subNode.get(subFieldName).isTextual() ?
                                        subNode.get(subFieldName).asText() : subNode.get(subFieldName));
                            });
                            fieldMapList.add(subDataMap);
                        });
                    }
                }
            });
            formAreaInfo.setFieldMap(fieldMap);
            formAreaInfo.setFieldMapList(fieldMapList);
            formAreaInfoList.add(formAreaInfo);
        });
        return formAreaInfoList;
    }


}
