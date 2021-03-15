package com.ljq.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 收付款计划对象
 * @Author: junqiang.lu
 * @Date: 2021/3/12
 */
@Data
public class PaymentPlanBean implements Serializable {

    private static final long serialVersionUID = -1435345954543763628L;

    /**
     * 收付款计划序号
     **/
    private Integer sortNo;
    /**
     * 收付款比例
     **/
    private BigDecimal paymentRatio;
    /**
     * 计划收付款金额
     **/
    private BigDecimal planPayAmt;
    /**
     * 计划收付款日期
     **/
    private Date planPayDate;



}
