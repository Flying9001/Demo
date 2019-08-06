package com.ljq.demo.object;

import com.ljq.demo.annotation.ParamsCheck;
import com.ljq.demo.bean.ParamsCheckBean;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 注解测试
 * @Author: junqiang.lu
 * @Date: 2019/8/1
 */
public class AnnotationTest {


    @Test
    public void getAnnotationTest() {
        ParamsCheckBean paramsCheckBean = new ParamsCheckBean();
        Method[] methods = paramsCheckBean.getClass().getDeclaredMethods();
        for(Method method : methods) {
            if (method.isAnnotationPresent(ParamsCheck.class)) {
                System.out.println("1");
            }
        }
        Field[] fields = paramsCheckBean.getClass().getDeclaredFields();
        for(Field field : fields) {
            if (field.isAnnotationPresent(ParamsCheck.class)) {
                System.out.printf("%s%n", field.getName());

            }

        }




    }
}
