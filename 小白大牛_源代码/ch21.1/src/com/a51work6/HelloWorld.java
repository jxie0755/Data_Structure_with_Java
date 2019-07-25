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

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {

        List list = new ArrayList();

        // 向集合中添加元素
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // 遍历集合
        for (Object item : list) {
            Integer element = (Integer) item;
            System.out.println("读取集合元素: " + element);
        }
    }
}
