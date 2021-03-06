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


//Student.java文件
package com.a51work6;

import java.util.Date;

public class Student extends Person {

    // 所在学校
    private String school;

    public Student(String name, int age, Date d, String school) {
        super(name, age, d);
        this.school = school;
    }

    public Student(String name, int age, String school) {
        // this.school = school;//编译错误
        super(name, age);
        this.school = school;
    }

//	public Student(String name, String school) { // 编译错误
//		// super(name, 30);
//		this.school = school;
//	}
}
