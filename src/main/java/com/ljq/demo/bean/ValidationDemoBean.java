package com.ljq.demo.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: java validation demo
 * @Author: junqiang.lu
 * @Date: 2018/9/28
 */
@Data
public class ValidationDemoBean implements Serializable {

    private static final long serialVersionUID = -1168911794208531678L;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 年龄
     */
    @Max(value = 150,message = "最大年龄不超过150岁")
    private int age;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;


    @NotNull(message = "childBean 不能为空")
    @Valid
    private ValidationDemoChildBean childBean;



}
