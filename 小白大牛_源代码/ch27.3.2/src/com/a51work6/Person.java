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


//Person.java文件
package com.a51work6;

@MyAnnotation(description = "这是一个测试类")
public class Person {

	@MemberAnnotation(type = String.class, description = "名字")
	private String name;

	@MemberAnnotation(type = int.class, description = "年龄")
	private int age;

	@MemberAnnotation(type = String.class, description = "获得名字")
	public String getName() {
		return name;
	}

	@MemberAnnotation(type = int.class, description = "获得年龄")
	public int getAge() {
		return age;
	}

	@MemberAnnotation(description = "设置姓名和年龄")
	public void setNameAndAge(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
