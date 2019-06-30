package com.ljq.demo.object;

import lombok.Data;

/**
 * @Description: builder 模式创建对象示例 - 用户模型
 * @Author: junqiang.lu
 * @Date: 2019/6/30
 */
@Data
public class BuilderUserDemo {
    /**
     * required
     */
    private final String userName;
    private final String passcode;
    /**
     * options
     */
    private final int age;
    private final int sex;
    private final String nickName;

    public static class Builder{
        /**
         * required
         */
        private final String userName;
        private final String passcode;

        /**
         * options
         * initialized to default values
         */
        private int age = 0;
        private int sex = 0;
        private String nickName = "";

        public Builder(String userName, String passcode) {
            this.userName = userName;
            this.passcode = passcode;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(int sex) {
            this.sex = sex;
            return this;
        }
        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public BuilderUserDemo builder(){
            return new BuilderUserDemo(this);
        }

    }

    private BuilderUserDemo (Builder builder) {
        this.userName = builder.userName;
        this.passcode = builder.passcode;
        this.age = builder.age;
        this.sex = builder.sex;
        this.nickName = builder.nickName;
    }



}
