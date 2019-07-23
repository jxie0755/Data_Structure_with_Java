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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class HelloWorld {

    public static void main(String[] args) {

        try {
            String className = readClassName();
            Class clz = Class.forName(className);
            // 指定参数类型
            Class[] params = new Class[3];
            // 第一个参数是String
            params[0] = String.class;
            // 第二个参数是int
            params[1] = int.class;
            // 第三个参数是String
            params[2] = String.class;

            // 获取对应参数的构造方法
            Constructor constructor = clz.getConstructor(params);
            // 设置传递参数
            Object[] argObjs = new Object[3];
            // 第一个参数传递"Tony"
            argObjs[0] = "Tony";
            // 第二个参数传递18
            argObjs[1] = 18;
            // 第三个参数传递"清华大学"
            argObjs[2] = "清华大学";

            // 调用非默认构造方法
            Object p = constructor.newInstance(argObjs);
            System.out.println(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从Configuration.ini文件中读取类名
    public static String readClassName() {

        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        try {
            readfile = new FileInputStream("Configuration.ini");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            // 读取文件中的一行数据
            String str = in.readLine();
            return str;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        }
        return null;
    }

}
