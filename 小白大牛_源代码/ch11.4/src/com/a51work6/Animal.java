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


package com.a51work6;

public class Animal {// extends Object {

    // 类体

    // 动物年龄
    int age = 1;
    // 动物性别
    public boolean sex = false;
    // 动物体重
    private double weight = 0.0;

    public void eat() {
        // 方法体
        return; // 可以省略
    }

    int run() {
        // 方法体
        return 10;
    }

    protected int getMaxNumber(int number1, int number2) {
        // 方法体
        if (number1 > number2) {
            return number1;
        }
        return number2;
    }

}
