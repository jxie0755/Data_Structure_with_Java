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

	//共享变量
	static int value = 0;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("主线程 开始...");

		// 创建线程t1，参数是一个线程执行对象Runner
		Thread t1 = new Thread(() -> {
			System.out.println("ThreadA 开始...");
			for (int i = 0; i < 2; i++) {
				System.out.println("ThreadA 执行...");
				value++;
			}
			System.out.println("ThreadA 结束...");

		}, "ThreadA");
		// 开始线程t1
		t1.start();
		// 主线程被阻塞，等待t1线程结束
		t1.join();
		System.out.println("value = " + value);
		System.out.println("主线程 结束...");
	}
}
