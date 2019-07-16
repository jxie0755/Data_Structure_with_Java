package Java_Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class A15_Local_Date_Time {

    /*
     * Java 8之后提供了新的日期时间类有三个, 它们都位于java.time包中:
     * LocalDate       表示一个不可变的日期对象
     * LocalTime       表示一个不可变的时间对象
     * LocalDateTime   表示一个不可变的日期和时间。

     * 这三个类有类似的方法
        * 首先先看看创建日期时间对象相关方法， 这三个类并没有提供公有的构造方法，
            * 创建它们对象可以使用静态工厂方法， 主要有now()和of()方法

        * 日期格式化和解析
         * Java 8提供的日期格式化类是java.time.format.DateTimeFormatter
         * DateTimeFormatter中本身没有提供日期格式化和日期解析方法
         * 这些方法还是由LocalDate、 LocalTime和LocalDateTime提供的

            * 日期格式化方法是format
                * 这三个类每一个都有String format(DateTimeFormatter formatter)
                * 参数formatter是DateTimeFormatter类型, 通过DateTimeFormatter.ofPattern得到

            * 日期解析方法是parse， 这三个类每一个都有两个版本的parse方法
            * 全都是static, 参数为CharSequence类(CS)和DateTimeFormatter(DTF)
                * LocalDateTime parse(CS):        使用默认格式， 从一个文本字符串获取一个LocalDateTime实例， 如2007-12-03T10:15:30。
                * LocalDateTime parse(CS, DTF):   使用指定格式化， 从文本字符串获取LocalDateTime实例。

                * LocalDate parse(CS):            使用默认格式， 从一个文本字符串获取一个LocalDate实例， 如2007-12-03。
                * LocalDate parse(CS, DTF):       使用指定格式化， 从文本字符串获取LocalDate实例。

                * LocalTime parse(cS):            使用默认格式， 从一个文本字符串获取一个LocalTime实例。
                * LocalTime parse(CS, DTF):       使用指定的格式化， 从文本字符串获取LocalTime实例
     */

}


class A15b_LocalDate {

    /*
     * Module java.base
     * Package java.time
     * Class LocalDate
     */

    public static void main(String[] args) {

        // 构造方法
        // 使用now方法获得LocalDate对象
        LocalDate date1 = LocalDate.now();
        System.out.println("date1 = " + date1);  // >>> date1 = 2019-03-21
        // 使用of方法获得LocalDate对象2018-08-18
        LocalDate date2 = LocalDate.of(2018, 8, 18);  // 这里月份的是从1开始的


        // 设置格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date2_str = date2.format(formatter);
        System.out.println(date2);       // >>> 2018-08-18
        System.out.println(date2_str);   // >>> 08/18/2018

        // parse
        LocalDate parsedDte = LocalDate.parse(date2_str, formatter);
        System.out.println(parsedDte);  // >>>  2018-08-18
    }
}


class A15c_LocalTime {

    /*
     * Module java.base
     * Package java.time
     * Class LocalTime
     */

    public static void main(String[] args) {

        // 构造方法
        // 使用now方法获得LocalTime对象
        LocalTime time1 = LocalTime.now();
        System.out.println("time1 = " + time1); // >>> time1 = 13:24:52.942834
        // 使用of方法获得LocalTime对象08:58:18
        LocalTime time2 = LocalTime.of(18, 58, 30);

        // 设置格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");  //hh表示12小时制, HH为24小时
        String time2_str = time2.format(formatter);
        System.out.println(time2);       // >>> 18:58:30
        System.out.println(time2_str);   // >>> 06:58:30 PM

        // parse
        LocalTime parsedTime = LocalTime.parse(time2_str, formatter);
        System.out.println(parsedTime);  // >>>  18:58:30
    }
}


class A15d_LocalDateTime {

    /*
     * Module java.base
     * Package java.time
     * Class LocalDateTime
     */

    public static void main(String[] args) {

        // 构造方法
        // 使用now方法获得LocalDateTime对象
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("dateTime1 = " + dateTime1); // >>> dateTime1 = 2019-03-21T13:14:08.255699900
        // 使用of方法获得LocalDateTime对象2018-08-18T08:58:18
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 8, 18, 18, 58, 30);

        // 设置格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String dateTime2_str = dateTime2.format(formatter);
        System.out.println(dateTime2);                 // >>> 2018-08-18T18:58:30
        System.out.println(dateTime2_str);             // >>> 08/18/2018 06:58:30 PM

        // parse
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime2_str, formatter);
        System.out.println(parsedDateTime);           // >>>  2018-08-18T18:58:30
    }
}
