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

		double[] nums = { 1.4, 1.5, 1.6 };

		// 测试最大值和最小值
		System.out.printf("min(%.1f, %.1f) = %.1f\n", nums[1], nums[2], Math.min(nums[1], nums[2]));
		System.out.printf("max(%.1f, %.1f) = %.1f\n", nums[1], nums[2], Math.max(nums[1], nums[2]));
		System.out.println();

		// 测试三角函数
		// 1π弧度 = 180°
		System.out.printf("toDegrees(0.5π)	= %f\n", Math.toDegrees(0.5 * Math.PI));
		System.out.printf("toRadians(180/π) = %f\n", Math.toRadians(180 / Math.PI));
		System.out.println();

		// 测试平方根
		System.out.printf("sqrt(%.1f) = %f\n", nums[2], Math.sqrt(nums[2]));
		System.out.println();

		// 测试幂运算
		System.out.printf("pow(8, 3) = %f\n", Math.pow(8, 3));
		System.out.println();

		// 测试计算随机值
		System.out.printf("0.0~1.0之间的随机数 = %f\n", Math.random());
		System.out.println();

		// 测试舍入方法
		for (double num : nums) {
			display(num);
		}

	}

	// 测试舍入方法
	public static void display(double n) {
		System.out.printf("ceil(%.1f)	= %.1f\n", n, Math.ceil(n));
		System.out.printf("floor(%.1f) 	= %.1f\n", n, Math.floor(n));
		System.out.printf("round(%.1f) 	= %d\n", n, Math.round(n));
		System.out.println();
	}
}
