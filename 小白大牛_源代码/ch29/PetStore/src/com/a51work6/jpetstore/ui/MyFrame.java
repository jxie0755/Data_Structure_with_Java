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
package com.a51work6.jpetstore.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//这是一个屏幕居中的自定义窗口
public class MyFrame extends JFrame {

    // 获得当前屏幕的宽
    private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    // 获得当前屏幕的高
    private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public MyFrame(String title, int width, int height) {
        super(title);

        // 设置窗口大小
        setSize(width, height);
        // 计算窗口位于屏幕中心的坐标
        int x = (int) (screenWidth - width) / 2;
        int y = (int) (screenHeight - height) / 2;
        // 设置窗口位于屏幕中心
        setLocation(x, y);

        // 注册窗口事件
        addWindowListener(new WindowAdapter() {
            // 单击窗口关闭按钮时调用
            public void windowClosing(WindowEvent e) {
                // 退出系统
                System.exit(0);
            }
        });
    }
}
