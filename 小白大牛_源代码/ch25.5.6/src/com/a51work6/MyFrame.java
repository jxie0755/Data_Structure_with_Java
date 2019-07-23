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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

    private String[] data = {"bird1.gif", "bird2.gif", "bird3.gif",
            "bird4.gif", "bird5.gif", "bird6.gif"};

    public MyFrame(String title) {
        super(title);

        // 右边面板
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BorderLayout(0, 0));
        JLabel lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        rightPane.add(lblImage, BorderLayout.CENTER);

        // 左边面板
        JPanel leftPane = new JPanel();
        leftPane.setLayout(new BorderLayout(0, 0));
        JLabel lblTextFieldLabel = new JLabel("选择鸟儿：");
        leftPane.add(lblTextFieldLabel, BorderLayout.NORTH);

        // 列表组件JList
        JList list1 = new JList(data);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 注册项目选择事件侦听器，采用Lambda表达式。
        list1.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                // 获得选择的内容
                String itemString = (String) list1.getSelectedValue();
                String petImage = String.format("/images/%s", itemString);
                Icon icon = new ImageIcon(MyFrame.class.getResource(petImage));
                lblImage.setIcon(icon);
            }
        });
        leftPane.add(list1, BorderLayout.CENTER);

        // 分隔面板
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, rightPane);
        splitPane.setDividerLocation(100);

        getContentPane().add(splitPane, BorderLayout.CENTER);

        // 设置窗口大小
        setSize(300, 200);
        // 设置窗口可见
        setVisible(true);
    }

}
