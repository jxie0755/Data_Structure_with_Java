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


//View.java文件
package com.a51work6;

//外部类
public class View {

	// 外部类实例变量
	private int x = 20;
	// 外部类静态变量
	private static int staticX = 10;
	
	// 静态内部类
	static class Button {
		
		// 内部类方法
		void onClick() {
			//访问外部类的静态成员
			System.out.println(staticX);
			//不能访问外部类的非静态成员
			// System.out.println(x); //编译错误
		}
	}
}
