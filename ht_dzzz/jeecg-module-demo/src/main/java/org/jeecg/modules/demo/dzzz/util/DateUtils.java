package org.jeecg.modules.demo.dzzz.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * 
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.SSS", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss.SSS", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     * 
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        if (str instanceof Date) return (Date) str;
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str,String dateformat)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
            return sdf.parse(str.toString());
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
    
    
    /**
     * 获取今年的所有月份
     */
    public static List<String> getMonthsThisYear()
    {
        List<String> months=new ArrayList<>();
        try{
            Date date = DateUtils.getNowDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat year = new SimpleDateFormat("yyyy");
            String yyyy = year.format(date);
            String nowdate=format.format(date);//当前月份
            Date d1 = new SimpleDateFormat("yyyy-MM").parse(yyyy + "-01");//定义起始日期 今年一月
            Date d2 = new SimpleDateFormat("yyyy-MM").parse(nowdate);//定义结束日期
            Calendar dd = Calendar.getInstance();//定义日期实例
            dd.setTime(d1);//设置日期起始时间
            while (dd.getTime().before(d2)) {//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String str = sdf.format(dd.getTime());
                months.add(str);
                dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
            }
            months.add(nowdate);
        }catch (Exception e){
            System.out.println("异常"+e.getMessage());
        }
        return months;
    }
    
    public static Integer getThisYear(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(getNowDate());
        return cal.get(Calendar.YEAR);
    }
    
    public static Integer getThisMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(getNowDate());
        return cal.get(Calendar.MONTH)+1;
    }

    /**
     * 得到当前时间格式化后的字符串，格式：yyyy-MM-dd HH:mm:ss(年-月-日 时:分:秒)
     * @return 当前日期格式化后的字符串
     */
    public static String getTodayStr(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) ;
    }

    /**
     * 时间戳，格式:yyyy-MM-dd HH:mm:ss(年-月-日  时：分：秒)
     * @return 简单的时间戳
     */
    public static String getDateTimeStamp(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) ;
    }

}
