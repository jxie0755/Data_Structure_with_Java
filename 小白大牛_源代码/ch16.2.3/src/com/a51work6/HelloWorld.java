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

        // 创建数值为true的Character对象true
        Boolean obj1 = new Boolean(true);
        // 通过字符串"true"创建Character对象true
        Boolean obj2 = new Boolean("true");
        // 通过字符串"True"创建Character对象true
        Boolean obj3 = new Boolean("True");
        // 通过字符串"TRUE"创建Character对象true
        Boolean obj4 = new Boolean("TRUE");
        // 通过字符串"false"创建Character对象false
        Boolean obj5 = new Boolean("false");
        // 通过字符串"Yes"创建Character对象false
        Boolean obj6 = new Boolean("Yes");
        // 通过字符串"abc"创建Character对象false
        Boolean obj7 = new Boolean("abc");

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);
        System.out.println("obj3 = " + obj3);
        System.out.println("obj4 = " + obj4);
        System.out.println("obj5 = " + obj5);
        System.out.println("obj6 = " + obj6);
        System.out.println("obj7 = " + obj7);
    }
}
