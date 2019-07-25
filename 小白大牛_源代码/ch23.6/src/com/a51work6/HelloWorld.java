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

    public static void main(String args[]) {

        Stack stack = new Stack();

        // 下面的消费者和生产者所操作的是同一个堆栈对象stack

        // 生产者线程
        Thread producer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                // 随机产生10个字符
                c = (char) (Math.random() * 26 + 'A');
                // 把字符压栈
                stack.push(c);
                // 打印字符
                System.out.println("生产: " + c);
                try {
                    // 每产生一个字符线程就睡眠
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
            }

        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                // 从堆栈中读取字符
                c = stack.pop();
                // 打印字符
                System.out.println("消费: " + c);
                try {
                    // 每读取一个字符线程就睡眠
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
            }

        });

        producer.start(); // 启动生产者线程
        consumer.start(); // 启动消费者线程
    }
}
