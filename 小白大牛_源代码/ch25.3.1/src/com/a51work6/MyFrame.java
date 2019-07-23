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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    // 声明Label
    JLabel label;

    public MyFrame(String title) {
        super(title);

        // 创建标签
        label = new JLabel("Label");
        // 添加标签到内容面板
        getContentPane().add(label, BorderLayout.NORTH);

        // 创建Button1
        JButton button1 = new JButton("Button1");
        // 添加Button1到内容面板
        getContentPane().add(button1, BorderLayout.CENTER);

        // 创建Button2
        JButton button2 = new JButton("Button2");
        // 添加Button2到内容面板
        getContentPane().add(button2, BorderLayout.SOUTH);

        // 设置窗口大小
        setSize(350, 120);
        // 设置窗口可见
        setVisible(true);

        // 注册事件监听器，监听Button2单击事件
        button2.addActionListener(new ActionEventHandler());

        // 注册事件监听器，监听Button1单击事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                label.setText("Hello Swing!");
            }
        });
    }

    // Button2事件处理者
    class ActionEventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Hello World!");
        }
    }
}
