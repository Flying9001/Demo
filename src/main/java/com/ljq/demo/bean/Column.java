package com.ljq.demo.bean;

import com.ljq.demo.enums.ColumnType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description: 数据库表字段列
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
@Data
public class Column implements Serializable {

    private static final long serialVersionUID = -774273157941656527L;

    /**
     * 列名
     */
    @NotBlank
    protected String name;
    /**
     * 类型 枚举 : ColumnType
     */
    @NotBlank
    protected String type;
    /**
     * 长度
     */
    protected int length;
    /**
     * 小数点
     */
    protected int decimal;
    /**
     * 是否必填
     */
    protected boolean required;
    /**
     * 是否主键
     */
    protected boolean primary;
    /**
     * 默认值
     */
    protected String defaultValue;
    /**
     * 注释
     */
    protected String comment;

    public Column () {
        super();
        this.type = ColumnType.VARCHAR.toString();
        this.length = 50;
        this.decimal = 0;
        this.primary = false;
        this.required = false;

    }

}
