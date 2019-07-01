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

public class HelloWorld {

	public static void main(String[] args) {

		try {
			Class clz = Class.forName("com.a51work6.Person");
			// 调用默认构造方法
			Person person = (Person) clz.newInstance();
			System.out.println(person);

			// 指定参数类型
			Class[] params = new Class[2];
			// 第一个参数是String
			params[0] = String.class;
			// 第二个参数是int
			params[1] = int.class;

			// 获取setNameAndAge方法对象
			Method method = clz.getMethod("setNameAndAge", params);
			// 设置传递参数
			Object[] argObjs = new Object[2];
			// 第一个参数传递"Tony"
			argObjs[0] = "Tony";
			// 第二个参数传递18
			argObjs[1] = 18;
			//调用setNameAndAge方法
			method.invoke(person, argObjs);
			System.out.println(person);
			
			// 获取getName方法对象
			method = clz.getMethod("getName");
			//调用getName方法
			Object result = method.invoke(person);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
