package com.ljq.demo.enums;

import java.util.function.DoubleBinaryOperator;

/**
 * @Description: 计算器枚举类 lambda 版本示例
 * @Author: junqiang.lu
 * @Date: 2019/8/1
 */
public enum  CalculateEnumLambdaDemo {

    /**
     * 加法
     */
    PLUS ("+", (x, y) -> x + y),
    /**
     * 减法
     */
    SUBTRACT("-", (x, y) -> x - y),
    /**
     * 乘法
     */
    MULTIPLY("*", (x, y) -> x * y),
    /**
     * 除法
     */
    DIVIDE("/", (x, y) -> x / y);

    private String symbol;
    private DoubleBinaryOperator operator;

    CalculateEnumLambdaDemo(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }
}
