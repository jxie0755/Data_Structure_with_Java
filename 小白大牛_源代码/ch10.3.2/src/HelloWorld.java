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


public class HelloWorld {

	public static void main(String[] args) {

		String s7 = new String("Hello");
		String s8 = new String("Hello");

		String s9 = "Hello";
		String s10 = "Hello";

		System.out.printf("s7 == s8 : %b%n", s7 == s8);
		System.out.printf("s9 == s10: %b%n", s9 == s10);
		System.out.printf("s7 == s9 : %b%n", s7 == s9);
		System.out.printf("s8 == s9 : %b%n", s8 == s9);

	}
}
