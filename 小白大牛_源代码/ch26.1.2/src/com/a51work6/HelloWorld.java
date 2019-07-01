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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class HelloWorld {

	public static void main(String[] args) {

		try {
			// 动态加载xx类的运行时对象
			Class c = Class.forName("java.lang.String");
			// 获取成员方法集合
			Method[] methods = c.getDeclaredMethods();
			// 遍历成员方法集合
			for (Method method : methods) {
				// 打印权限修饰符，如public、protected、private
				System.out.print(Modifier.toString(method.getModifiers()));
				// 打印返回值类型名称
				System.out.print(" " + method.getReturnType().getName() + " ");
				// 打印方法名称
				System.out.println(method.getName() + "();");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到指定类");
		}
	}
}
