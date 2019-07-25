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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);

        //设置窗口大小不变的
        setResizable(false);

        // 不设置布局管理器
        getContentPane().setLayout(null);

        // 创建标签
        JLabel label = new JLabel("Label");
        // 设置标签的位置和大小
        label.setBounds(89, 13, 100, 30);
        // 设置标签文本水平居中
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // 添加标签到内容面板
        getContentPane().add(label);

        // 创建Button1
        JButton button1 = new JButton("Button1");
        // 设置Button1的位置和大小
        button1.setBounds(89, 59, 100, 30);
        // 添加Button1到内容面板
        getContentPane().add(button1);

        // 创建Button2
        JButton button2 = new JButton("Button2");
        // 设置Button2的位置
        button2.setLocation(89, 102);
        // 设置Button2的大小
        button2.setSize(100, 30);
        // 添加Button2到内容面板
        getContentPane().add(button2);

        // 设置窗口大小
        setSize(300, 200);
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
