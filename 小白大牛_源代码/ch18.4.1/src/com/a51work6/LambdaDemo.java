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


//LambdaDemo.java文件
package com.a51work6;

public class LambdaDemo {
	// 实例成员变量
	private int value = 10;
	// 静态成员变量
	private static int staticValue = 5;

	// 静态方法，进行加法运算
	public static Calculable add() {

		Calculable result = (int a, int b) -> {
			// 访问静态成员变量，不能访问实例成员变量
			staticValue++;
			int c = a + b + staticValue; // this.value;
			return c;
		};

		return result;
	}

	// 实例方法，进行减法运算
	public Calculable sub() {

		Calculable result = (int a, int b) -> {
			// 访问静态成员变量和实例成员变量
			staticValue++;
			this.value++;
			int c = a - b - staticValue - this.value;
			return c;
		};
		return result;
	}
}
