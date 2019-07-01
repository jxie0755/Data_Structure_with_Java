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

		View v = new View();
		// 方法参数是匿名内部类
		v.handler(new OnClickListener() {

			@Override
			public void onClick() {
				System.out.println("实现接口的匿名内部类...");
			}

		});
		
		//继承类的匿名内部类
		Figure f = new Figure() {
			@Override
			public void onDraw() {
				System.out.println("继承类的匿名内部类...");
			}			
		};
		
		//具体类作为内部类
		Person person = new Person("Tony", 18) {
			@Override
			public String toString() {
				return "匿名内部类.实现 "
						+ " Person[name=" + name 
						+ ", age=" + age + "]";
			}
		};
		
		//打印过程自动调用person的 toString()方法
		System.out.println(person);
	}
}
