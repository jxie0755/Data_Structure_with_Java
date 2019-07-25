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

import java.lang.reflect.Field;

public class HelloWorld {

    public static void main(String[] args) {

        try {
            Class clz = Class.forName("com.a51work6.Person");
            // 调用默认构造方法
            Person person = (Person) clz.newInstance();

            // 返回成员变量名为name的Field对象
            Field name = clz.getDeclaredField("name");
            // 设置成员变量accessible标志为true
            name.setAccessible(true);
            // 为成员变量name赋值
            name.set(person, "Tony");

            // 返回成员变量名为age的Field对象
            Field age = clz.getDeclaredField("age");
            // 设置成员变量accessible标志为true
            age.setAccessible(true);
            // 为成员变量age赋值
            age.set(person, 18);

            // 获取成员变量保存的数据
            System.out.printf("[name:%s, age:%d]",
                    name.get(person), age.get(person));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
