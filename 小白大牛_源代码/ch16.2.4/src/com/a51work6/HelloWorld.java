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
		Integer objInt = new Integer(80);
		Double objDouble = new Double(80.0);
		//自动拆箱
		double sum = objInt + objDouble;
		
		//自动装箱
		//自动装箱'C'转换为Character对象
		Character objChar = 'C';
		//自动装箱true转换为Boolean对象
		Boolean objBoolean = true;
		//自动装箱80.0f转换为Float对象
		Float objFloat = 80.0f;

		//自动装箱100转换为Integer对象
		display(100);
		
		//避免出现下面的情况
		Integer obj = null;
		int intVar = obj;//运行期异常NullPointerException
		
	}
	
	/**
	 * @param objInt Integer对象
	 * @return int数值
	 */
	public static int display(Integer objInt) {
		
		System.out.println(objInt);
		
		//return objInt.intValue();
		//自动拆箱Integer对象转换为int
		return objInt;
	}
}
