package com.ljq.demo.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * @Description: 字段类型
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
@Getter
@ToString
public enum ColumnType {

    /**
     * 字符串
     */
    VARCHAR("varchar", "字符串", new String[] { "varchar", "varchar2", "char", "tinyblob", "tinytext" }),
    /**
     * 大文本
     */
    CLOB("clob", "大文本", new String[] { "text", "clob", "blob", "mediumblob", "mediumtext", "longblob", "longtext" }),
    /**
     * 数字型
     */
    NUMBER("number", "数字型", new String[] { "tinyint", "number", "smallint", "mediumint", "int", "integer", "bigint", "float", "double", "decimal", "numeric" }),
    /**
     * 日期型
     */
    DATE("date", "日期型", new String[] { "date", "time", "year", "datetime", "timestamp" });
    /**
     * key
     */
    private String key;
    /**
     * 描述
     */
    private String desc;
    /**
     * 支持的数据库类型
     */
    private String[] supports;

    private ColumnType(String key, String desc, String[] supports) {
        this.key = key;
        this.desc = desc;
        this.supports = supports;
    }

    public static ColumnType getByDbDataType(String dbDataType, String columnName) throws Exception {
        for (ColumnType type : ColumnType.values()) {
            for (String support : Arrays.asList(type.supports)) {
                if (dbDataType.toLowerCase().contains(support.toLowerCase())) {
                    return type;
                }
            }
        }
        throw new Exception(String.format("字段[%s]的类型[%s]无法转为系统支持的类型",columnName, dbDataType));
    }




}
