package com.ljq.demo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @Description: 时间日期工具类
 * @Author: junqiang.lu
 * @Date: 2018/4/23
 */
public final class DateUtil {

    private DateUtil(){

    }

    /**
     * 获取当前时间,并返回指定格式(线程安全)
     * @param format 时间格式(eg: yyyyMMddHHmmssSSS)
     *
     * @return string 当前时间
     * */
    public static String getCurrentDateTime(String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }

    /**
     * 获取当前时间(线程安全)
     *
     * @return string 当前时间,格式为:"yyyy-MM-dd HH:mm:ss:SSS"
     * */
    public static String getCurrentDateTime(){
        return getCurrentDateTime("yyyy-MM-dd HH:mm:ss:SSS");
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate(){
        return getCurrentDateTime("yyyy-MM-dd");
    }

    /**
     * 获取某一日期 n 天前/后的日期
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     * @param days 距离指定时间的天数,为负表示之前；为正表示之后
     *
     * @return 距离 指定日期 n 天前/后的日期(格式: yyyy-MM-dd 字符串)
     * */
    public static String getAppointedDate(String dateStr, int days){
        int[] arr= getDateArrFromStr(dateStr);
        LocalDate appointedDate = LocalDate.of(arr[0],arr[1],arr[2]);
        if(days > 0){
            appointedDate = appointedDate.plusDays(days);
        }else {
            appointedDate = appointedDate.minusDays(Math.abs(days));
        }
        return appointedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取某一日期所在月份的第一天
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     *
     * @return 指定日期所在月的第一天日期(格式: yyyy-MM-dd 字符串)
     */
    public static String getMonthFirstDayStr(String dateStr){
        int[] arr= getDateArrFromStr(dateStr);
        LocalDate appointedDate = LocalDate.of(arr[0],arr[1],1);
        return appointedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取某一日期所在月份的第一天
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     *
     * @return 指定日期所在月的第一天日期
     */
    public static Date getMonthFirstDayDate(String dateStr){
        int[] arr= getDateArrFromStr(dateStr);
        LocalDate appointedDate = LocalDate.of(arr[0],arr[1],1);
        return Date.from(appointedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取某一日期所在月份的最后一天
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     *
     * @return 指定日期所在月的最后一天日期(格式: yyyy-MM-dd 字符串)
     */
    public static String getMonthLastDayStr(String dateStr){
        int[] arr= getDateArrFromStr(dateStr);
        LocalDate appointedDate = LocalDate.of(arr[0],arr[1],arr[2]);
        appointedDate = appointedDate.with(TemporalAdjusters.lastDayOfMonth());
        return appointedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取某一日期所在月份的最后一天
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     *
     * @return 指定日期所在月的最后一天日期
     */
    public static Date getMonthLastDayDate(String dateStr){
        int[] arr= getDateArrFromStr(dateStr);
        LocalDate appointedDate = LocalDate.of(arr[0],arr[1],arr[2]);
        appointedDate = appointedDate.with(TemporalAdjusters.lastDayOfMonth());
        return Date.from(appointedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 时间转化为字符串
     * 转换后的格式为: yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期时间
     * @return
     */
    public static String getDateString(Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(formatter);
    }

    /**
     * 将string类型时间转换为date类型时间
     *
     * @param dateStr
     * @return
     */
    public static Date getDateFromString(String dateStr) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取一天的最小时间
     * @param date
     * @return
     */
    public static long getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取一天的最大时间
     *
     * @param date
     * @return
     */
    public static long getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return endOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 从 yyyy-MM-dd 格式的日期字符串总获取对应的 年、月、日
     * @param dateStr 符合 yyyy-MM-dd 格式的日期字符串
     *
     * @return int[] 分别为 年、月、日的值的数组
     * */
    public static int[] getDateArrFromStr(String dateStr){
        String[] strArr = dateStr.split("-");
        int[] arr  = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }


}
