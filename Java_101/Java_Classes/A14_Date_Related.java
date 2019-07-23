package Java_Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class A14_Date_Related {
    /*
     * java.util.Date
     * Java 8之前日期类是java.util.Date，Date类比较古老，其中的很多方法现在已经废弃了
     * 但是目前仍然有很多程序还在使用Date类，考虑到还有很多程序使用Date类，因此本节还是介绍一下Date类及日期时间相关类的使用
     * 此外Java 8之前与日期时间相关类还有
     * DateFormat - 用于日期格式化
     * Calendar   - 日历类
     * TimeZone   - 是时区类
     */

    /*
     * Java 8之后提供了新的日期时间类有三个
     * LocalDate
     * LocalTime
     * LocalDateTime
     */
}


class A14b_Date {

    /*
     * Module java.base
     * Package java.util
     * Class Date
     */

    /*
     *  构造方法
     *  Date()            用当前时间创建Date对象, 精确到毫秒
     *  Date(long date)   指定标准基准时间以来的毫秒数创建Date对象. 标准基准时间是格林威治时间1970年1月1日00:00:00

     * boolean after(Date when)     测试此日期是否在when日期之后
     * boolean before(Date when)    测试此日期是否在when日期之前
     * compareTo(Date anotherDate)

     * long getTime()： 返回自1970年1月1日00:00:00以来此Date对象表示的毫秒数
     * setTime(long time)： 用毫秒数time设置日期对象 time是自1970年1月1日00:00:00以来此Date对象表示的毫秒数

     * get and set(省略) all deprecated
     * getDate()
     * getDay()
     * getHours()
     * getMinutes()
     * getMonth()
     * getSeonds()
     * getYear()

     * show as a String all deprecated
     * toGMTString()
     * toInstant()
     * toLocaleString()
     * toString
     */

    public static void main(String[] args) {

        // quick test
        Date now1 = new Date();
        System.out.println(now1);  // >>>  Wed Mar 20 14:18:27 EDT 2019
        System.out.println(now1.getTime()); // >>>  1553106063217
        Date now2 = new Date(now1.getTime());
        System.out.println(now1.equals(now2)); // >>> true

        Date date1 = new Date(1234567890123L);
        System.out.println(date1); // >>>  Fri Feb 13 18:31:30 EST 2009
        date1.setTime(now2.getTime());
        System.out.println(date1.compareTo(now1)); // >>> 0

        System.out.println(now1.before(now2));  // >>> false  // 相等也是false
        System.out.println(now1.after(now2));   // >>> false  // 相等也是false
    }
}


class A14c_DateFormat {
    /*
     * Module java.base
     * Package java.text
     * Class DateFormat (abstract)
     */

    // DateFormat是抽象类， 它的常用具体类是 java.text.SimpleDateFormat

    /*
     * Module java.base
     * Package java.text
     * Class SimpleDateFormat
     */

    /*
     * String format(Date date)   将一个Date格式化为日期/时间字符串。
     * Date parse(String source)  从给定字符串的开始解析文本，以生成一个日期对象. 如果解析失败则抛出ParseException。

     * SimpleDateFormat构造方法
     * SimpleDateFormat()                用默认的模式和默认语言环境的日期格式符号构造SimpleDateFormat。
     * SimpleDateFormat(String pattern)  用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

     * parse                             从StringFormat变成Date对象 (注意处理异常)
     */

    /*
     * G	Era designator	                                  Text	    AD
     * y	Year	                                          Year	    1996; 96
     * Y	Week year	                                      Year	    2009; 09
     * M	Month in year (context sensitive)	              Month	    July; Jul; 07
     * L	Month in year (standalone form)	                  Month	    July; Jul; 07
     * w	Week in year	                                  Number	27
     * W	Week in month	                                  Number	2
     * D	Day in year	                                      Number	189
     * d	Day in month	                                  Number	10
     * F	Day of week in month	                          Number	2
     * E	Day name in week	                              Text	    Tuesday; Tue
     * u	Day number of week (1 = Monday, 7 = Sunday)       Number	1
     * a	Am/pm marker	                                  Text	    PM
     * H	Hour in day (0-23)	                              Number	0
     * k	Hour in day (1-24)	                              Number	24
     * K	Hour in am/pm (0-11)	                          Number	0
     * h	Hour in am/pm (1-12)	                          Number	12
     * m	Minute in hour	                                  Number	30
     * s	Second in minute	                              Number	55
     * S	Millisecond	                                      Number	978

     * z	Time zone	                             General timezone	 Pacific Standard Time; PST; GMT-08:00
     * Z	Time zone	                             RFC 822 timezone	 -0800
     * X	Time zone	                             ISO 8601 timezone -08; -0800; -08:00
     */

    public static void main(String[] args) {

        Date date1 = new Date(1234567890123L);
        System.out.println(date1);               // >>>  Fri Feb 13 18:31:30 EST 2009
        DateFormat df = new SimpleDateFormat();  // 默认是
        System.out.println(df.format(date1));    // >>>  2/13/09, 6:31 PM

        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        System.out.println(df2.format(date1));    // >>>  2009-02-13 18:31:30 PM
        String str = "2018-08-18 08:18:58";
        try {
            Date date2 = df2.parse(df2.format(date1));
        } catch (ParseException ae) {
            System.out.println(ae);
        }
    }
}

class A14d_Calendar {

    /*
     * Module java.base
     * Package java.util
     * Class Calendar (abstract)
     */

    /*
     * 有时为了取得更多的日期时间信息， 或对日期时间进行操作， 可以使用java.util.Calendar类
     * Calendar是一个抽象类， 不能实例化
     * 但是通过静态工厂方法getInstance()获得Calendar实例
     */

    /*
     * 常用方法
     * Calendar.getInstance()                       构造方法
     * set(yyyy, mm, dd)                            设置Calendar时间
     * set(Calendar.YEAR, yyyy)
     * set(Calendar.MONTH, mm)
     * set(Calendar.DATE, dd)

     * getTime                                      转化成Date实例
     * clear                                        清除(重新初始化日历对象)
     *
     */

    public static void main(String[] args) {

        Calendar calA = Calendar.getInstance();
        calA.set(2018, 7, 18);   // 注意月份是从0开始, 7是8月的意思
        System.out.println(calA);  // not printable
        System.out.println(calA.toString());  // not printable

        Date date1 = calA.getTime(); // 转换成Date格式
        System.out.println(date1); // >>>  Sat Aug 18 11:14:53 EDT 2018

        calA.clear();

        Calendar calB = Calendar.getInstance();
        calB.set(Calendar.YEAR, 2019);
        System.out.println(calB.getTime());  // >>>  Tue Jan 01 00:00:00 EST 2019 默认1月1号0点
        calB.set(Calendar.MONTH, 3);
        calB.set(Calendar.DATE, 21);
        System.out.println(calB.getTime());  // >>>  Sun Apr 21 12:54:03 EDT 2019 // 月份是4月

        System.out.println(calA.before(calB)); // >>> true
        System.out.println(calA.after(calB));  // >>> false
        System.out.println(calA.compareTo(calB)); // >>> -1
    }
}
