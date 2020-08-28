package com.ljq.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: Spring Bean 工具类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    /**
     * 应用上下文
     */
    private static ApplicationContext context;

    private SpringBeanUtil(){

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取 bean 对象
     *
     * @param beanClass spring bean 类
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 获取 bean 对象
     *
     * @param beanName spring bean 名称
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }


}
