package com.ljq.demo.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 金融财务日期工具
 * @Author: junqiang.lu
 * @Date: 2021/3/12
 */
public class FinanceDateUtil {

    private FinanceDateUtil(){
    }

    /**
     * 计算两个日期相差的月数
     * 当开始日期大于截止日期时,返回 -1
     *
     * @param startDate 开始日期
     * @param endDate 截止日期
     * @return
     */
    public static int getMonthDifference(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            return -1;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        Calendar temp = Calendar.getInstance();
        temp.setTime(endDate);
        temp.add(Calendar.DATE, 1);
        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }

    /**
     * 获取下一个还款日
     *
     * @param currentRepaymentDate 当前还款日期
     * @param monthInterval 还款间隔月,最少为 1
     * @return
     */
    private static Date getNextRepaymentDate(Date currentRepaymentDate, int monthInterval) {
        monthInterval = monthInterval < 1 ? 1 : monthInterval;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentRepaymentDate);
        calendar.add(Calendar.MONTH, monthInterval);
        return calendar.getTime();
    }

    /**
     * 获取下一个还款日
     * (包括月最后一天的判断,如果还款日为所在月最后一天,则下一次还款日也是月最后一天)
     *
     * @param currentRepaymentDate 当前还款日期
     * @param monthInterval 还款间隔月,最少为 1
     * @param lastDayOfMonth 是否按照月最后一天判断
     * @return
     */
    public static Date getNextRepaymentDate(Date currentRepaymentDate, int monthInterval, boolean lastDayOfMonth) {
        if (!lastDayOfMonth) {
            return getNextRepaymentDate(currentRepaymentDate, monthInterval);
        }
        monthInterval = monthInterval < 1 ? 1 : monthInterval;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentRepaymentDate);
        boolean isLastDayOfMonth = isLastDayOfMonth(calendar);
        calendar.add(Calendar.MONTH, monthInterval);
        if (isLastDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return calendar.getTime();
    }

    /**
     * 判断一个日期是否为所在月的最后一天
     *
     * @param date 日期
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return isLastDayOfMonth(calendar);
    }

    /**
     * 判断一个日期是否为所在月的最后一天
     * @param calendar
     * @return
     */
    public static boolean isLastDayOfMonth(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
