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
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ItemListener {

    //声明并创建RadioButton对象
    private JRadioButton radioButton1 = new JRadioButton("男");
    private JRadioButton radioButton2 = new JRadioButton("女");

    public MyFrame(String title) {
        super(title);

        // 设置布局管理BorderLayout
        getContentPane().setLayout(new BorderLayout());

        // 创建一个面板panel1放置TextField和Password
        JPanel panel1 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel1.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        // 将面板panel1添加到内容视图
        getContentPane().add(panel1, BorderLayout.NORTH);

        // 创建标签
        JLabel lblTextFieldLabel = new JLabel("选择你喜欢的编程语言：");
        // 添加标签到面板panel1
        panel1.add(lblTextFieldLabel);

        //创建checkBox1对象
        JCheckBox checkBox1 = new JCheckBox("Java");
        //添加checkBox1到面板panel1
        panel1.add(checkBox1);

        JCheckBox checkBox2 = new JCheckBox("C++");
        //添加checkBox2到面板panel1
        panel1.add(checkBox2);

        JCheckBox checkBox3 = new JCheckBox("Objective-C");
        //注册checkBox3对ActionEvent事件监听
        checkBox3.addActionListener((event) -> {
            // 打印checkBox3状态
            System.out.println(checkBox3.isSelected());
        });
        //添加checkBox3到面板panel1
        panel1.add(checkBox3);

        // 创建一个面板panel2放置TextArea
        JPanel panel2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        getContentPane().add(panel2, BorderLayout.SOUTH);

        // 创建标签
        JLabel lblTextAreaLabel = new JLabel("选择性别：");
        // 添加标签到面板panel2
        panel2.add(lblTextAreaLabel);

        //创建ButtonGroup对象
        ButtonGroup buttonGroup = new ButtonGroup();
        //添加RadioButton到ButtonGroup对象
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        //添加RadioButton到面板panel2
        panel2.add(radioButton1);
        panel2.add(radioButton2);

        //注册ItemEvent事件监听器
        radioButton1.addItemListener(this);
        radioButton2.addItemListener(this);

        // 设置窗口大小
        pack(); // 紧凑排列，其作用相当于setSize()

        // 设置窗口可见
        setVisible(true);
    }

    //实现ItemListener接口方法
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JRadioButton button = (JRadioButton) e.getItem();
            System.out.println(button.getText());
        }
    }
}
