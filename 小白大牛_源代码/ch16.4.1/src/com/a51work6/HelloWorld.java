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

import java.math.BigInteger;

public class HelloWorld {

    public static void main(String[] args) {

        //创建BigInteger，字符串表示10进制数值
        BigInteger number1 = new BigInteger("999999999999");
        //创建BigInteger，字符串表示16进制数值
        BigInteger number2 = new BigInteger("567800000", 16);

        // 加法操作
        System.out.println("加法操作：" + number1.add(number2));
        // 减法操作
        System.out.println("减法操作：" + number1.subtract(number2));
        // 乘法操作
        System.out.println("乘法操作：" + number1.multiply(number2));
        // 除法操作
        System.out.println("除法操作：" + number1.divide(number2));
    }
}
