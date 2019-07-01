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


//WeekDays.java文件
package com.a51work6;

public enum WeekDays {
	// 枚举常量列表
	MONDAY("星期一", 0), TUESDAY("星期二", 1), WEDNESDAY("星期三", 2), THURSDAY("星期四", 3), FRIDAY("星期五", 4);

	// 实例变量
	private String name;
	private int index;

	// 静态变量
	private static int staticVar = 100;

	private WeekDays(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 覆盖父类中的toString()方法
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append('-');
		sb.append(index);
		return sb.toString();
	}

	// 实例方法
	public String getInfo() {
		// 调用父类中toString()方法
		return super.toString();
	}

	// 静态方法
	public static int getStaticVar() {
		return staticVar;
	}
}
