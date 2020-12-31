package com.ljq.demo.constant;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 枚举类测试
 * @Author: junqiang.lu
 * @Date: 2020/12/31
 */
@Getter
@ToString
public enum DemoEnum {

    /**
     * 成功
     */
    success(200,"success"),
    /**
     * 失败
     */
    fail(500, "fail");

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String msg;

    private DemoEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取状态码列表
     *
     * @return
     */
    public static List<Integer> getCodeList() {
        List<Integer> codeList = new ArrayList<>();
        for (DemoEnum demoEnum : DemoEnum.values()) {
            codeList.add(demoEnum.getCode());
        }
        return codeList;
    }

    /**
     * 获取消息列表
     *
     * @return
     */
    public static List<String> getMsgList() {
        List<String> msgList = new ArrayList<>();
        for (DemoEnum demoEnum : DemoEnum.values()) {
            msgList.add(demoEnum.getMsg());
        }
        return msgList;
    }






}
