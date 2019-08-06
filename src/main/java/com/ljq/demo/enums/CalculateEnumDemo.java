package com.ljq.demo.enums;

/**
 * @Description: 计算器枚举类示例
 * @Author: junqiang.lu
 * @Date: 2019/7/31
 */
public enum CalculateEnumDemo {

    /**
     * 加法
     */
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    /**
     * 减法
     */
    SUBTRACT("-"){
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    /**
     * 乘法
     */
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    /**
     * 除法
     */
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };


    /**
     * 符号
     */
    private final String symbol;

    CalculateEnumDemo(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);


}
