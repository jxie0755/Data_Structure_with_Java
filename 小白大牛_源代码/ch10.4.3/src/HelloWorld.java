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
		// 原始不可变字符串
		String str1 = "Java C";
		// 从不可变的字符创建可变字符串对象
		StringBuilder mstr = new StringBuilder(str1);

		// 插入字符串
		mstr.insert(4, " C++");
		System.out.println(mstr);

		// 具有追加效果的插入字符串
		mstr.insert(mstr.length(), " Objective-C");
		System.out.println(mstr);
		// 追加字符串
		mstr.append(" and Swift");
		System.out.println(mstr);

		// 删除字符串
		mstr.delete(11, 23);
		System.out.println(mstr);

	}
}
