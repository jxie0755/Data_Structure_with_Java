package W3C_Java_Classes;

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


class A14_Date {

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

