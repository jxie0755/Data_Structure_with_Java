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

        // 创建线程t1，参数是实现Runnable接口的匿名内部类
        Thread t1 = new Thread(new Runnable() {
            // 编写执行线程代码
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 打印次数和线程的名字
                    System.out.printf("第 %d次执行 - %s\n", i, Thread.currentThread().getName());
                    try {
                        // 随机生成休眠时间
                        long sleepTime = (long) (1000 * Math.random());
                        // 线程休眠
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                    }
                }
                // 线程执行结束
                System.out.println("执行完成! " + Thread.currentThread().getName());
            }

        });
        // 开始线程t1
        t1.start();

        // 创建线程t2，参数是实现Runnable接口的Lambda表达式
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 打印次数和线程的名字
                System.out.printf("第 %d次执行 - %s\n", i, Thread.currentThread().getName());
                try {
                    // 随机生成休眠时间
                    long sleepTime = (long) (1000 * Math.random());
                    // 线程休眠
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
            }
            // 线程执行结束
            System.out.println("执行完成! " + Thread.currentThread().getName());
        }, "MyThread");
        // 开始线程t2
        t2.start();
    }
}
