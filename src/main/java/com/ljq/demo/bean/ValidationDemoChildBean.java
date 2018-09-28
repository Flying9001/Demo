package com.ljq.demo.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Description: java bean 校验引用类
 * @Author: junqiang.lu
 * @Date: 2018/9/28
 */
@Data
public class ValidationDemoChildBean implements Serializable {

    private static final long serialVersionUID = 8313082827473756093L;

    /**
     * 身高,单位: cm
     */
    @Min(value = 1, message = "最小值必须大于等于 1")
    @Max(value = 300, message = "最大值不超过 300")
    private int height;

    /**
     * 手机号
     * 中国大陆11位手机号码，匹配格式：前三位固定格式+后8位任意数
     */
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^((13[0-9])|145|147|(15[^4])|166|(17[^2])|(17[^4])|(17[^9])|(18[0-9])|(19[8-9]))\\d{8}$",
        message = "手机号不符合要求")
    private String phone;


}
