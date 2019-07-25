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


//HelloWorldGen.java文件
package com.a51work6;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HelloWorldGen {

    public static void main(String[] args) {

        // 测试Set泛型集合
        System.out.println("******测试Set泛型集合******");
        testSet();

        // 测试Map泛型集合
        System.out.println("******测试Map泛型集合******");
        testMap();
    }

    // 测试Set泛型集合方法
    private static void testSet() {

        Set<String> set = new HashSet<String>();
        // 向集合中添加元素
        set.add("A");
        set.add("D");
        set.add("E");

        // 1.使用增强for循环遍历
        System.out.println("--1.使用增强for循环遍历--");
        for (String item : set) {
            System.out.println("读取集合元素: " + item);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("读取集合元素: " + item);
        }
    }

    // 测试Map泛型集合方法
    private static void testMap() {

        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");

        // 1.使用增强for循环遍历
        System.out.println("--1.使用增强for循环遍历--");
        // 获得键集合
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            String value = map.get(key);
            System.out.printf("key=%d - value=%s \n", key, value);
        }

        // 2.使用迭代器遍历
        System.out.println("--2.使用迭代器遍历--");
        // 获得值集合
        Collection<String> values = map.values();
        // 遍历值集合
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("值集合元素: " + item);
        }
    }
}
