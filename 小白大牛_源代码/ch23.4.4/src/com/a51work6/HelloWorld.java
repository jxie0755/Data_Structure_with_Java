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
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {

    private static String command = "";

    public static void main(String[] args) {

        // 创建线程t1，参数是一个线程执行对象Runner
        Thread t1 = new Thread(() -> {

            // 一直循环，直到满足条件在停止线程
            while (!command.equalsIgnoreCase("exit")) {
                // 线程开始工作
                System.out.println("下载中...");
                try {
                    // 线程休眠
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
            // 线程执行结束
            System.out.println("执行完成!");
        });
        // 开始线程t1
        t1.start();

        try (InputStreamReader ir = new InputStreamReader(System.in);
             BufferedReader in = new BufferedReader(ir)) {
            // 从键盘接收了一个字符串的输入
            command = in.readLine();
        } catch (IOException e) {
        }

    }
}
