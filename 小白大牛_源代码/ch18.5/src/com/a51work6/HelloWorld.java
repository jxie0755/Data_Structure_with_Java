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

		int n1 = 10;
		int n2 = 5;

		// 打印计算结果加法计算结果
		display(LambdaDemo::add, n1, n2);
		
		LambdaDemo d = new LambdaDemo();
		// 打印计算结果减法计算结果
		display(d::sub, n1, n2);

	}

	/**
	 * 打印计算结果
	 * @param calc Lambda表达式
	 * @param n1  操作数1
	 * @param n2 操作数2
	 */
	public static void display(Calculable calc, int n1, int n2) {
		System.out.println(calc.calculateInt(n1, n2));
	}
}
