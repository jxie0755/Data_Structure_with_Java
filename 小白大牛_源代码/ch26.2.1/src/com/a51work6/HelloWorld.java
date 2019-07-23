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

import java.lang.reflect.Constructor;

public class HelloWorld {

    public static void main(String[] args) {

        try {
            Class clz = Class.forName("java.lang.String");
            // 调用默认构造方法
            String str1 = (String) clz.newInstance();

            // 设置构造方法参数类型
            Class[] params = new Class[1];
            // 第一个参数是String
            params[0] = String.class;

            // 获取与参数对应的构造方法
            Constructor constructor = clz.getConstructor(params);
            // 为构造方法传递参数
            Object[] argObjs = new Object[1];
            // 第一个参数传递"Hello"
            argObjs[0] = "Hello";

            // 调用非默认构造方法，构造方法第一个参数是String类型
            String str2 = (String) constructor.newInstance(argObjs);
            System.out.println(str2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
