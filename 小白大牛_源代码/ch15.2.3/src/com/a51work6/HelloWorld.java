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
        // day工作日变量
        WeekDays day = WeekDays.FRIDAY;

        //打印day默认调用枚举toString()方法
        System.out.println(day);
        //调用枚举实例方法
        System.out.println(day.getInfo());
        //调用枚举静态方法
        System.out.println(WeekDays.getStaticVar());

    }
}
