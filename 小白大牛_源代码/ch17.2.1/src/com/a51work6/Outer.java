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


//Outer.java文件
package com.a51work6;

//外部类
public class Outer {

	// 外部类成员变量
	private int x = 10;

	// 外部类方法
	private void print() {
		System.out.println("调用外部方法...");
	}

	// 测试调用内部类
	public void test() {
		Inner inner = new Inner();
		inner.display();
	}

	// 内部类
	class Inner {

		// 内部类成员变量
		private int x = 5;

		// 内部类方法
		void display() {

			// 访问外部类的成员变量x
			System.out.println("外部类成员变量 x = " + Outer.this.x);
			// 访问内部类的成员变量x
			System.out.println("内部类成员变量 x = " + this.x);
			System.out.println("内部类成员变量 x = " + x);

			// 调用外部类的成员方法
			Outer.this.print();
			print();
		}
	}
}
