package com.ljq.demo.bean;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 数据库表
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
@Data
public class Table<C extends Column> implements Serializable {

    /**
     * 表名
     */
    @NotBlank
    private String name;
    /**
     * 注释
     */
    private String comment;
    /**
     * 字段列表
     */
    @Valid
    private List<C> columnList;

    /**
     * 获取主键列(列表)
     *
     * @return
     */
    public List<C> getPkColumns() {
        if (CollectionUtils.isEmpty(this.columnList)) {
            return Collections.emptyList();
        }
        List<C> list = new ArrayList<>();
        this.columnList.stream().forEach(c -> {
            if (c.isPrimary()) {
                list.add(c);
            }
        });
        return list;
    }

    /**
     * 获取列信息
     *
     * @param name 列名
     * @return
     */
    public C getColumn(String name) {
        if (CollectionUtils.isEmpty(this.columnList)) {
            return null;
        }
        for (C c : this.columnList) {
            if (name.equalsIgnoreCase(c.getName())) {
                return c;
            }
        }
        return null;
    }




}
