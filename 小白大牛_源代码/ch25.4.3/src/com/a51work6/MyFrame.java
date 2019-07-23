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


//MyFrame.java文件
package com.a51work6;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);

        // 设置3行3列的GridLayout布局管理器
        setLayout(new GridLayout(3, 3));

        // 添加按钮到第一行的第一格
        getContentPane().add(new Button("1"));
        // 添加按钮到第一行的第二格
        getContentPane().add(new Button("2"));
        // 添加按钮到第一行的第三格
        getContentPane().add(new Button("3"));
        // 添加按钮到第二行的第一格
        getContentPane().add(new Button("4"));
        // 添加按钮到第二行的第二格
        getContentPane().add(new Button("5"));
        // 添加按钮到第二行的第三格
        getContentPane().add(new Button("6"));
        // 添加按钮到第三行的第一格
        getContentPane().add(new Button("7"));
        // 添加按钮到第三行的第二格
        getContentPane().add(new Button("8"));
        // 添加按钮到第三行的第三格
        getContentPane().add(new Button("9"));

        setSize(400, 400);
        setVisible(true);
    }
}
