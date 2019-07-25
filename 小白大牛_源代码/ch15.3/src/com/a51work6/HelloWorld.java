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

public class HelloWorld {

    public static void main(String[] args) {

        // 返回一个包含全部枚举常量的数组
        WeekDays[] allValues = WeekDays.values();
        // 遍历枚举常量数值
        for (WeekDays value : allValues) {
            System.out.printf("%d - %s\n", value.ordinal(), value);
        }

        // 创建WeekDays对象
        WeekDays day1 = WeekDays.FRIDAY;
        WeekDays day2 = WeekDays.valueOf("FRIDAY");

        System.out.println(day1 == WeekDays.FRIDAY);
        System.out.println(day1.equals(WeekDays.FRIDAY));
        System.out.println(day1 == day2);

    }
}
