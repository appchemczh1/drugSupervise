package org.jeecg.modules.demo.dzzz.homepage.util.zzUtil;

import org.jeecg.modules.demo.dzzz.certStatistics.util.zzUtil.ObjectUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private  static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
    }

    public static Date str2Date(String str, String format) {
        if (null != str && !"".equals(str)) {
            if (null == format || "".equals(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = null;

            try {
                date = sdf.parse(str);
                return date;
            } catch (ParseException var5) {
                var5.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static java.sql.Date date2Sql(Date date) {
        if (date != null) {
            return date instanceof java.sql.Date ? (java.sql.Date)date : new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }

    public static String date2Str(Date date, String format) {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }

    public static String date2Str(Date date) {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
    }

    public static String timestamp2Str(Timestamp time) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }

        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String timestamp2Str(Timestamp time, String format) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }

        return date2Str(date, format);
    }

    public static Timestamp str2Timestamp(String str) {
        Date date = str2Date(str, "yyyy-MM-dd HH:mm:ss");
        return new Timestamp(date.getTime());
    }

    public static Timestamp str2Timestamp(String str, String format) {
        Date date = str2Date(str, format);
        return new Timestamp(date.getTime());
    }

    public static String long2Str(Long longValue) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(parseDate(longValue));
    }

    public static String long2Str(Long longValue, String format) {
        SimpleDateFormat sFormat = new SimpleDateFormat(format);
        return sFormat.format(parseDate(longValue));
    }

    public static Timestamp long2Timestamp(Long longValue) {
        return new Timestamp(longValue);
    }

    public static Date parseDate(long longValue) {
        return new Date(longValue);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        return date1.getDate() == date2.getDate();
    }

    public static int getBetweenDays(long longValue1, long longValue2) {
        long betweenDays = (longValue1 - longValue2) / 1000L / 86400L;
        return Math.abs((int)betweenDays);
    }

    public static int getBetweenDays(String time1, String time2) {
        long betweenDays = 0L;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            betweenDays = date1.getTime() - date2.getTime();
            betweenDays = betweenDays / 1000L / 60L / 60L / 24L;
        } catch (ParseException var7) {
            var7.printStackTrace();
        }

        return Math.abs((int)betweenDays);
    }

    public static Timestamp convertDate2Timestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static Timestamp getNextDay(Timestamp date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return convertDate2Timestamp(calendar.getTime());
    }

    public static int compareDate(String date1, String date2, String format) {
        if (ObjectUtil.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat df = new SimpleDateFormat(format);

        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else {
                return dt1.getTime() < dt2.getTime() ? -1 : 0;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            return 0;
        }
    }

    public static int compareDate(Timestamp t1, Timestamp t2) {
        if (t1 != null && t2 != null) {
            return t1.getTime() > t2.getTime() ? 1 : -1;
        } else {
            return 0;
        }
    }

    public static Date addDay(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static Integer getAgeByBirth(Timestamp birthday, Timestamp nowDay) {
        boolean var2 = false;

        try {
            Calendar now = Calendar.getInstance();
            now.setTime(nowDay);
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            int age;
            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(1) - birth.get(1);
                if (now.get(6) > birth.get(6)) {
                    ++age;
                }
            }

            return age;
        } catch (Exception var5) {
            return 0;
        }
    }

    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        try {
            if (cal.before(birthDay)) {
                return 0;
            } else {
                int yearNow = cal.get(1);
                int monthNow = cal.get(2);
                int dayOfMonthNow = cal.get(5);
                cal.setTime(birthDay);
                int yearBirth = cal.get(1);
                int monthBirth = cal.get(2);
                int dayOfMonthBirth = cal.get(5);
                int age = yearNow - yearBirth;
                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (age > 0 && dayOfMonthNow <= dayOfMonthBirth) {
                            --age;
                        }
                    } else {
                        --age;
                    }
                }

                return age;
            }
        } catch (Exception var9) {
            return 0;
        }
    }
}
