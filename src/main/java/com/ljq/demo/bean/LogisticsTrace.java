package com.ljq.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 快递物流轨迹信息
 * @Author: junqiang.lu
 * @Date: 2018/9/26
 */
@Data
public class LogisticsTrace implements Serializable {

    private static final long serialVersionUID = -5152487306550447774L;

    /**
     * 接收时间
     */
    private String acceptTime;

    /**
     * 物流描述
     */
    private String acceptStation;

    /**
     * 备注信息
     */
    private String remark;
}
