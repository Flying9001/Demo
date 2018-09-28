package com.ljq.demo.util;

import com.ljq.demo.bean.ValidationDemoBean;
import com.ljq.demo.bean.ValidationDemoChildBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BeanValidateUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(BeanValidateUtilTest.class);

    @Test
    public void validate() {

        List<ValidationDemoChildBean> demoChildBeanList = new ArrayList<>(16);
        List<ValidationDemoBean> demoBeanList = new ArrayList<>(16);
        /**
         * case 1 测试属性非空
         */
        ValidationDemoChildBean demoChildBean1 = new ValidationDemoChildBean();
        demoChildBean1.setHeight(1);
        demoChildBeanList.add(demoChildBean1);
        /**
         * case 2 测试数字
         */
        ValidationDemoChildBean demoChildBean2 = new ValidationDemoChildBean();
        demoChildBean2.setHeight(500);
        demoChildBean2.setPhone("13112345678");
        demoChildBeanList.add(demoChildBean2);
        /**
         * case 3 测试正则
         */
        ValidationDemoChildBean demoChildBean3 = new ValidationDemoChildBean();
        demoChildBean3.setHeight(130);
        demoChildBean3.setPhone("123456789");
        demoChildBeanList.add(demoChildBean3);
        /***
         * case 4 测试全部符合要求
         */
        ValidationDemoChildBean demoChildBean4 = new ValidationDemoChildBean();
        demoChildBean4.setHeight(140);
        demoChildBean4.setPhone("13112345678");
        demoChildBeanList.add(demoChildBean4);
        /**
         * case 5 测试邮箱
         */
        ValidationDemoBean demoBean5 = new ValidationDemoBean();
        demoBean5.setUserName("tomcat5");
        demoBean5.setAge(5);
        demoBean5.setEmail("demo.demo");
        demoBean5.setChildBean(demoChildBean4);
        demoBeanList.add(demoBean5);
        /**
         * case 6 测试对象属性非空
         */
        ValidationDemoBean demoBean6 = new ValidationDemoBean();
        demoBean6.setUserName("tomcat6");
        demoBean6.setAge(6);
        demoBean6.setEmail("demo@demo.com");
        demoBeanList.add(demoBean6);
        /**
         * case 7 测试对象属性中的属性
         */
        ValidationDemoBean demoBean7 = new ValidationDemoBean();
        demoBean7.setUserName("tomcat7");
        demoBean7.setAge(7);
        demoBean7.setEmail("demo@demo.com");
        ValidationDemoChildBean demoChildBean7 = new ValidationDemoChildBean();
        demoChildBean7.setHeight(170);
        demoBean7.setChildBean(demoChildBean7);
        demoBeanList.add(demoBean7);

        for (int i = 0; i < demoChildBeanList.size(); i++) {
            String validResult = BeanValidateUtil.validate(demoChildBeanList.get(i));
            logger.debug("case {} : {}", (i + 1), validResult);
        }
        for (int j = 0; j < demoBeanList.size(); j++) {
            String validResult = BeanValidateUtil.validate(demoBeanList.get(j));
            logger.debug("case {} : {}", (j + 5), validResult);
        }

    }
}