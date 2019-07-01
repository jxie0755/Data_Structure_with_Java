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
	private int value = 10;

	// 外部类方法
	public void add(final int x, int y) {
		//局部变量
		int z = 100;
		
		// 定义内部类
		class Inner {
			// 内部类方法
			void display() {
				int sum = x + z + value;
				System.out.println("sum = " + sum);
			}
		}

		// Inner inner = new Inner();
		// inner.display();
		//声明匿名对象
		new Inner().display();
	}
}
