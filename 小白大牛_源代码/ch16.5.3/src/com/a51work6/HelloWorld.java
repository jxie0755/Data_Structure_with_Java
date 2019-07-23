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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloWorld {

    public static void main(String[] args) throws ParseException {

        // 获得默认的日历对象
        Calendar calendar = Calendar.getInstance();
        // 设置日期2018年8月18日
        calendar.set(2018, 7, 18);

        // 通过日历获得Date对象
        Date date = calendar.getTime();
        System.out.println("格式化前date = " + date);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("格式化后date = " + df.format(date));
        System.out.println();

        calendar.clear();
        // 设置日期2018年8月28日
        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE, 28);

        // 通过日历获得Date对象
        date = calendar.getTime();
        System.out.println("格式化前date = " + date);
        System.out.println("格式化后date = " + df.format(date));
    }
}
