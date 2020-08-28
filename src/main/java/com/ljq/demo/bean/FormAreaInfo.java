package com.ljq.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: 表单区域信息
 * @Author: junqiang.lu
 * @Date: 2020/8/9
 */
@Data
public class FormAreaInfo implements Serializable {
    private static final long serialVersionUID = -212446361467776204L;

    /**
     * 区域 id
     */
    private String areaId;
    /**
     * 是否为主业务标识
     */
    private boolean mainBusinessFlag;
    /**
     * 对应的业务表名
     */
    private String tableName;
    /**
     * 字段Map
     */
    Map<String, Object> fieldMap;
    /**
     * 字段Map列表
     */
    List<Map<String, Object>> fieldMapList;
}
