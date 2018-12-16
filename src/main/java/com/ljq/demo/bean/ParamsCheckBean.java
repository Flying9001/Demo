package com.ljq.demo.bean;

import com.ljq.demo.annotation.ParamsCheck;
import lombok.Data;

/**
 * @Description: 参数校验实体类
 * @Author: junqiang.lu
 * @Date: 2018/12/16
 */
@Data
public class ParamsCheckBean {

    @ParamsCheck(notNull = true, desc = "账号")
    private String account;

    @ParamsCheck(max = 150, desc = "年龄")
    private int age;

    @ParamsCheck(min = 20, desc = "身高")
    private int height;

    @ParamsCheck(strMinLength = 2, desc = "昵称")
    private String nickName;

    @ParamsCheck(strMaxLength = 50, desc = "个性签名")
    private String description;

    @ParamsCheck(notNull = true, isMobile = true, desc = "手机号")
    private String mobile;

    @ParamsCheck(notNull = true, isEmail = true, desc = "邮箱")
    private String email;

    @ParamsCheck(notNull = true, isAlphanumericStr = true, desc = "邀请码")
    private String inviteCode;

    @ParamsCheck(notNull = true, isNumericStr = true, desc = "学号")
    private String studentId;




}
