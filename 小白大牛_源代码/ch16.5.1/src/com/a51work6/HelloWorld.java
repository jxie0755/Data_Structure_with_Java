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

import java.util.Date;

public class HelloWorld {

    public static void main(String[] args) {

        Date now = new Date();
        System.out.println("now = " + now);
        System.out.println("now.getTime() = " + now.getTime());
        System.out.println();

        Date date = new Date(1234567890123L);
        System.out.println("date = " + date);

        // 测试now和date日期
        display(now, date);

        // 重新设置日期time
        date.setTime(9999999999999L);

        System.out.println("修改之后的date = " + date);

        // 重新测试now和date日期
        display(now, date);

    }

    // 测试after、before和compareTo方法
    public static void display(Date now, Date date) {
        System.out.println();
        System.out.println("now.after(date) 	= " + now.after(date));
        System.out.println("now.before(date)	= " + now.before(date));
        System.out.println("now.compareTo(date)	= " + now.compareTo(date));
        System.out.println();
    }
}
