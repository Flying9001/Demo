package com.ljq.demo.mode;

/**
 * @Description: singleton mode 单例模式
 * @Author: junqiang.lu
 * @Date: 2018/6/24
 */
public class SingletonModeDemo {

    /**
     * 私有化 构造方法
     */
    private SingletonModeDemo(){}

    /**
     * 定义需要实例化的对象/属性
     * 可以为当前类,也可以为其他类
     */
    private volatile static SingletonModeDemo singletonModeDemo;

    /**
     * Volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
     * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，
     * 两个不同的线程总是看到某个成员变量的同一个值
     */

    /**
     * volatile是一种稍弱的同步机制，在访问volatile变量时不会执行加锁操作，
     * 也就不会执行线程阻塞，因此volatilei变量是一种比synchronized关键字更轻量级的同步机制
     */


    /**
     * 获取对象实例
     * 线程安全
     *
     * @return
     */
    public static SingletonModeDemo getInstance(){
        if (singletonModeDemo == null) {
            synchronized (SingletonModeDemo.class) {
                if (singletonModeDemo == null) {
                    singletonModeDemo = new SingletonModeDemo();
                }
            }
        }
        return singletonModeDemo;
    }

}
