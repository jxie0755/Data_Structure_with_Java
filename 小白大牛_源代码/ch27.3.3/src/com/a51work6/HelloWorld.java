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

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {

    public static void main(String[] args) {
        try {
            Class<?> clz = Class.forName("com.a51work6.Person");

            // 读取类注解
            if (clz.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation ann = (MyAnnotation) clz.getAnnotation(MyAnnotation.class);
                System.out.printf("类%s，读取注解描述： %s \n", clz.getName(), ann.description());
            }

            // 读取成员方法的注解信息
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = method.getAnnotation(MemberAnnotation.class);
                    System.out.printf("方法%s，读取注解描述： %s \n", method.getName(), ann.description());
                }
            }

            // 读取成员变量的注解信息
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = field.getAnnotation(MemberAnnotation.class);
                    System.out.printf("成员变量%s，读取注解描述： %s \n", field.getName(), ann.description());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
