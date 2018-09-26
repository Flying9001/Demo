package com.ljq.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 物流信息 model
 * @Author: junqiang.lu
 * @Date: 2018/9/26
 */
@Data
public class LogisticsInfo implements Serializable {

    private static final long serialVersionUID = 6951873346591540974L;

    /**
     * 快递公司识别码
     */
    private String comCode;

    /**
     * 快递单号
     */
    private String postNo;

    /**
     * 快递物流信息查询是否成功
     */
    private boolean success;

    /**
     * 快递查询失败原因
     */
    private String failReason;

    /**
     * 快递物流状态
     */
    private int state;

    /**
     * 快递物流轨迹信息
     */
    List<LogisticsTrace> logisticsTraceList;
}
