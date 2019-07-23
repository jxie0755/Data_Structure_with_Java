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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MyFrame extends JFrame {

    private String[] s1 = {"Java", "C++", "Objective-C"};

    public MyFrame(String title) {
        super(title);
        // 创建标签
        JLabel lblTextFieldLabel = new JLabel("选择你喜欢的编程语言：");
        getContentPane().add(lblTextFieldLabel, BorderLayout.NORTH);

        // 列表组件JList
        JList list1 = new JList(s1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 注册项目选择事件侦听器，采用Lambda表达式。
        list1.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                // 获得选择的内容
                String itemString = (String) list1.getSelectedValue();
                System.out.println(itemString);
            }
        });
        getContentPane().add(list1, BorderLayout.CENTER);

        // 设置窗口大小
        setSize(300, 200);
        // 设置窗口可见
        setVisible(true);
    }

}
