package com.bsoft.common.utils;

import org.checkerframework.checker.units.qual.C;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    /**
     * 日期转化为指定日期格式类型
     * [url=home.php?mod=space&uid=952169]@Param[/url] date 日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String date_str = sdf.format(date);//日期转化为指定格式
        return date_str;
    }

    /**
     * 日期字符串转化为指定日期格式类型
     * @param date_str 日期字符串
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String date_str,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        Date date = sdf.parse(date_str);//日期转化为指定格式
        return date;
    }

    /**
     * 获得今天日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     */
    public static String getToday(String pattern){
        Date date = new Date();//今天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String today = sdf.format(date);//日期转化为指定格式
        return today;
    }

    /**
     * 获得明天日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     */
    public static String getTomorrow(String pattern){
        Date date = new Date();//今天日期
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往后推一天的日期结果，即明天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String tommorrow = sdf.format(date);//明天日期
        return tommorrow;
    }

    /**
     * 获得昨天日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     */
    public static String getYesterday(String pattern){
        Date date = new Date();//今天日期
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往前推一天的日期结果，即昨天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String yesterday = sdf.format(date);//昨天日期
        return yesterday;
    }

    /**
     * 获得指定日期的后一天
     * @param date 指定日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Date getAfterDay(Date date,String pattern) throws ParseException {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往后推一天的日期结果，即后一天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String next_date_str = sdf.format(date);//后一天日期
        //将日期字符串转化为指定日期格式类型
        Date after_date =  stringToDate(next_date_str,pattern);
        return after_date;
    }

    /**
     * 获得指定日期的后一天
     * @param date_str 指定日期字符串
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static String getAfterDay(String date_str,String pattern) throws ParseException {
        //将日期字符串转化为指定日期格式类型
        Date date = stringToDate(date_str,pattern);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往后推一天的日期结果，即后一天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String after_date_str = sdf.format(date);//后一天日期
        return after_date_str;
    }

    /**
     * 获得指定日期的前一天
     * @param date 指定日期
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Date getBeforetDay(Date date,String pattern) throws ParseException {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往后推一天的日期结果，即前一天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String before_date_str = sdf.format(date);//前一天日期
        //将日期字符串转化为指定日期格式类型
        Date before_date =  stringToDate(before_date_str,pattern);
        return before_date;
    }

    /**
     * 获得指定日期的前一天
     * @param date_str 指定日期字符串
     * @param pattern 日期格式类型，如yyyy-MM-dd，yyyy年MM月dd日 HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static String getBreforeDay(String date_str,String pattern) throws ParseException {
        //将日期字符串转化为指定日期格式类型
        Date date = stringToDate(date_str,pattern);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);//设置时间
        cal.add(Calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date = cal.getTime();//这个时间就是日期往后推一天的日期结果，即前一天日期
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//日期格式
        String before_date_str = sdf.format(date);//前一天日期
        return before_date_str;
    }

    public static Date localDateToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date){
        return LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

    /**
     * 根据年月 例：2020-12  获取某月的最后一天
     *
     */
    public static String getLastDayOfMonth(String yearMonth)
    {
        String[] s = yearMonth.split("-");
        Integer year = Integer.valueOf(s[0]);
        Integer month = Integer.valueOf(s[1]);
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    public static String getFristDateStringOfMonth(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int days = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, days);
        String result = format.format(calendar.getTime());
        return result;
    }

    public static Date getFristDateOfMonth(Date date) throws ParseException{
        String firstDate = getFristDateStringOfMonth(date);
        return stringToDate(firstDate,"yyyy-MM-dd");
    }
}
