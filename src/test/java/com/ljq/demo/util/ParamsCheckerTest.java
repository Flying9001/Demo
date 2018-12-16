package com.ljq.demo.util;

import com.ljq.demo.bean.ParamsCheckBean;
import org.junit.Test;

public class ParamsCheckerTest {


    /**
     * 参数非空测试
     *
     * @throws Exception
     */
    @Test
    public void checkParamNotNull() throws Exception {

        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamNotNull");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 限定最大值测试
     *
     * @throws Exception
     */
    @Test
    public void checkParamMax() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(156);
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamMax");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 限定最小值测试
     *
     * @throws Exception
     */
    @Test
    public void checkParamMin() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(10);
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamMin");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 字符串长度最小值测试
     *
     * @throws Exception
     */
    @Test
    public void checkParamStrMinLength() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("明");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamStrMinLength");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 字符串长度最大值测试
     *
     * @throws Exception
     */
    @Test
    public void checkParamStrMaxLength() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamStrMaxLength");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 正则表达式-手机号校验
     *
     * @throws Exception
     */
    @Test
    public void checkParamMobile() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        paramsCheckBean.setMobile("1234567");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamMobile");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 正则表达式-邮箱校验
     *
     * @throws Exception
     */
    @Test
    public void checkParamEmail() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        paramsCheckBean.setMobile("13122223333");
        paramsCheckBean.setEmail("demo@");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamEmail");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 正则表达式-字母数字校验
     *
     * @throws Exception
     */
    @Test
    public void checkParamAlphanumericStr() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        paramsCheckBean.setMobile("13122223333");
        paramsCheckBean.setEmail("demo@gmail.com");
        paramsCheckBean.setInviteCode("123aD*");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamAlphanumericStr");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }

    /**
     * 正则表达式-纯数字字符串校验
     *
     * @throws Exception
     */
    @Test
    public void checkParamNumericStr() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        paramsCheckBean.setMobile("13122223333");
        paramsCheckBean.setEmail("demo@gmail.com");
        paramsCheckBean.setInviteCode("123QWEa");
        paramsCheckBean.setStudentId("12345Q");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamNumericStr");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }



    /**
     * 参数符合要求
     *
     * @throws Exception
     */
    @Test
    public void checkParamValid() throws Exception{
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        paramsCheckBean.setAccount("helloWorld");
        paramsCheckBean.setAge(20);
        paramsCheckBean.setHeight(100);
        paramsCheckBean.setNickName("hello小明");
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            description.append("a");
        }
        paramsCheckBean.setDescription(description.toString());
        paramsCheckBean.setMobile("13122223333");
        paramsCheckBean.setEmail("demo@gmail.com");
        paramsCheckBean.setInviteCode("123QWEa");
        paramsCheckBean.setStudentId("1234567890");
        String result = ParamsValidator.validateParams(paramsCheckBean);

        System.out.println("测试方法: checkParamValid");
        System.out.println(paramsCheckBean);
        System.out.println("result: " + result);
        System.out.println("------------------------------");
    }



}