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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) throws ParseException {

		Date date = new Date(1234567890123L);
		System.out.println("格式化前date = " + date);

		DateFormat df = new SimpleDateFormat();
		System.out.println("格式化后date = " + df.format(date));
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("格式化后date = " + df.format(date));

		String dateString = "2018-08-18 08:18:58";
		Date date1 = df.parse(dateString);
		System.out.println("从字符串获得日期对象 = " + date1);

	}

}
