package com.ljq.demo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description: 金融计算工具
 * @Author: junqiang.lu
 * @Date: 2018/7/3
 */
public class CalculateUtil {

    /**
     * 默认保留小数位数
     */
    public static final int DEFAULT_SCALE = 6;

    private CalculateUtil(){
    }

    /**
     * 加法计算
     *
     * @param var1 参数1(加数)
     * @param var2 参数2(被加数)
     * @param scale 参数精度,并非计算结果精度
     * @return 两个参数的和
     */
    public static BigDecimal add(double var1, double var2, int scale){
        scale = getValidScale(scale);
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(var1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(var2));
        bigDecimal1 = bigDecimal1.setScale(scale, RoundingMode.DOWN);
        bigDecimal2 = bigDecimal2.setScale(scale,RoundingMode.DOWN);
        return bigDecimal1.add(bigDecimal2);
    }

    /**
     * 减法计算
     *
     * @param var1 参数1(减数)
     * @param var2 参数2(被减数)
     * @param scale 参数精度,并非计算结果精度
     * @return 两个参数的差
     */
    public static BigDecimal subtract(double var1, double var2, int scale){
        scale = getValidScale(scale);
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(var1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(var2));
        bigDecimal1 = bigDecimal1.setScale(scale,RoundingMode.DOWN);
        bigDecimal2 = bigDecimal2.setScale(scale,RoundingMode.DOWN);
        return bigDecimal1.subtract(bigDecimal2);
    }

    /**
     * 乘法计算
     *
     * @param var1 参数1(乘数)
     * @param var2 参数2(被乘数)
     * @param scale 参数精度,并非结果精度
     * @return 两个参数的乘积
     */
    public static BigDecimal multiply(double var1, double var2,int scale){
        scale = getValidScale(scale);
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(var1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(var2));
        bigDecimal1 = bigDecimal1.setScale(scale,RoundingMode.DOWN);
        bigDecimal2 = bigDecimal2.setScale(scale,RoundingMode.DOWN);
        return bigDecimal1.multiply(bigDecimal2);
    }

    /**
     * 乘法计算
     *
     * @param var1 参数1(乘数)
     * @param var2 参数2(被乘数)
     * @param scale 参数精度,并非结果精度
     * @param resultScale 计算结果精度
     * @return 两个参数的乘积
     */
    public static BigDecimal multiply(double var1, double var2,int scale, int resultScale){
        return multiply(var1, var2, scale).setScale(resultScale, RoundingMode.HALF_DOWN);
    }

    /**
     * 除法计算
     *
     * @param var1 参数1(除数)
     * @param var2 参数2(被除数)
     * @param scale 参数精度,并非结果精度
     * @return 两个参数的商
     */
    public static BigDecimal divide(double var1, double var2,int scale){
        scale = getValidScale(scale);
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(var1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(var2));
        bigDecimal1 = bigDecimal1.setScale(scale, RoundingMode.HALF_DOWN);
        bigDecimal2 = bigDecimal2.setScale(scale, RoundingMode.HALF_DOWN);
        return bigDecimal1.divide(bigDecimal2, scale,  RoundingMode.HALF_DOWN);
    }

    /**
     * 除法计算
     *
     * @param var1 参数1(除数)
     * @param var2 参数2(被除数)
     * @param scale 参数精度,并非结果精度
     * @param resultScale 计算结果精度
     * @return 两个参数的商
     */
    public static BigDecimal divide(double var1, double var2, int scale, int resultScale){
        return divide(var1, var2, scale).setScale(resultScale, RoundingMode.HALF_DOWN);
    }

    /**
     * 获取有效保留小数位数
     *
     * @param scale 保留小数位数
     * @return
     */
    private static int getValidScale(int scale) {
        scale = Math.abs(scale);
        if(scale == 0){
            scale = DEFAULT_SCALE;
        }
        return scale;
    }

    /**
     * 计算次数
     *
     * @param divisor 除数
     * @param dividend 被除数
     * @return
     */
    public static int getTimes(int divisor, int dividend) {
        int reminder = divisor % dividend;
        if (reminder == 0) {
            return divisor / dividend;
        }
        return divisor / dividend + 1;
    }



}
