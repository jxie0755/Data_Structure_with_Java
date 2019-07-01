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

		// 获得Class实例
		// 1.通过类型class静态变量
		Class clz1 = String.class;

		String str = "Hello";
		// 2.通过对象的getClass()方法
		Class clz2 = str.getClass();
		
		//获得int类型Class实例
		Class clz3 = int.class;
		//获得Integer类型Class实例
		Class clz4 = Integer.class;
		
		System.out.println("clz2类名称：" + clz2.getName());
		System.out.println("clz2是否为接口：" + clz2.isInterface());
		System.out.println("clz2是否为数组对象：" + clz2.isArray());
		System.out.println("clz2父类名称：" + clz2.getSuperclass().getName());
		
		System.out.println("clz2是否为基本类型：" + clz2.isPrimitive());
		System.out.println("clz3是否为基本类型：" + clz3.isPrimitive());
		System.out.println("clz4是否为基本类型：" + clz4.isPrimitive());

	}
}
