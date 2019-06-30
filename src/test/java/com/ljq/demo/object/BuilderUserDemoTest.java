package com.ljq.demo.object;

import org.junit.Test;

public class BuilderUserDemoTest {

    @Test
    public void builderDemo() {
        String userName = "Tom";
        String passcode = "111111";
        int age = 10;
        int sex = 1;
        String nickName = "Tomcat";

        BuilderUserDemo builderUserDemo = new BuilderUserDemo
                .Builder(userName, passcode)
                .age(age)
                .sex(sex)
                .nickName(nickName)
                .builder();

        System.out.println("builderUserDemo: " + builderUserDemo);

        /**
         * 重复设置某一个属性
         * 结果会以最后一次设置的为准
         */
        BuilderUserDemo builderUserDemo2 = new BuilderUserDemo
                .Builder(userName, passcode)
                .sex(sex)
                .sex(sex + 1)
                .builder();

        System.out.println("builderUserDemo2: " + builderUserDemo2);

    }
}