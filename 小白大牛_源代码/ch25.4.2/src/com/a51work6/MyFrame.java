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

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);

        // 设置BorderLayout布局
        setLayout(new BorderLayout(10, 10));

        // 添加按钮到容器的North区域
        getContentPane().add(new Button("北"), BorderLayout.NORTH);
        // 添加按钮到容器的South区域
        getContentPane().add(new Button("南"), BorderLayout.SOUTH);
        // 添加按钮到容器的East区域
        getContentPane().add(new Button("东"), BorderLayout.EAST);
        // 添加按钮到容器的West区域
        getContentPane().add(new Button("西"), BorderLayout.WEST);
        // 添加按钮到容器的Center区域
        getContentPane().add(new Button("中"), BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }
}
