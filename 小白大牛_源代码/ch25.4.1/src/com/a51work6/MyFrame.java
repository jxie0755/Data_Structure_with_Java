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

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    // 声明标签
    JLabel label;

    public MyFrame(String title) {
        super(title);

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        // 创建标签
        label = new JLabel("Label");
        // 添加标签到内容面板
        getContentPane().add(label);

        // 创建Button1
        JButton button1 = new JButton("Button1");
        // 添加Button1到内容面板
        getContentPane().add(button1);

        // 创建Button2
        JButton button2 = new JButton("Button2");
        // 添加Button2到内容面板
        getContentPane().add(button2);

        // 设置窗口大小
        setSize(350, 120);
        // 设置窗口可见
        setVisible(true);

        // 注册事件监听器，监听Button2单击事件
        button2.addActionListener((event) -> {
            label.setText("Hello Swing!");
        });

        // 注册事件监听器，监听Button1单击事件
        button1.addActionListener((event) -> {
            label.setText("Hello World!");
        });
    }
}
