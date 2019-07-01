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

		// 创建数值为'A'的Character对象
		Character objChar1 = new Character('A');
		// 从Character对象返回char值
		char ch = objChar1.charValue();

		// 字符串比较
		Character objChar2 = new Character('C');
		int result = objChar1.compareTo(objChar2);
		// result = -2，表示objChar1小于objChar2
		if (result < 0) {
			System.out.println("objChar1小于objChar2");
		}
	}
}
