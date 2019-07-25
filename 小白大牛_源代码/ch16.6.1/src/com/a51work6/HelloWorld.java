/*
 * Created by 智捷课堂
 * 本书网站：http://www.zhijieketang.com/group/5
 * 智捷课堂在线课堂：www.zhijieketang.com
 * 智捷课堂微信公共号：zhijieketang
 * 邮箱：eorient@sina.com
 * Java读者服务QQ群：547370999
 *
 * 买《Java从小白到大牛》纸质版图书，送配套视频
 *
 * 【配套电子书】网址：
 *       图灵社区：
 *       http://www.ituring.com.cn/book/2480
 *       百度阅读：
 *       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00
 */


//HelloWorld.java文件
package com.a51work6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HelloWorld {

    public static void main(String[] args) {

        // 使用now方法获得LocalDate对象
        LocalDate date1 = LocalDate.now();
        System.out.println("date1 = " + date1);

        // 使用of方法获得LocalDate对象2018-08-18
        LocalDate date2 = LocalDate.of(2018, 8, 18);
        System.out.println("date2 = " + date2);

        // 使用now方法获得LocalTime对象
        LocalTime time1 = LocalTime.now();
        System.out.println("time1 = " + time1);

        // 使用of方法获得LocalTime对象08:58:18
        LocalTime time2 = LocalTime.of(8, 58, 18);
        System.out.println("time2 = " + time2);

        // 使用now方法获得LocalDateTime对象
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("dateTime1 = " + dateTime1);

        // 使用of方法获得LocalDateTime对象2018-08-18T08:58:18
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 8, 18, 8, 58, 18);
        System.out.println("dateTime2 = " + dateTime2);
    }

}
