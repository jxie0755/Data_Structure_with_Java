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

import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

	// 声明下拉列表JComboBox
	private JComboBox choice1;
	private JComboBox choice2;

	private String[] s1 = { "Java", "C++", "Objective-C" };
	private String[] s2 = { "男", "女" };

	public MyFrame(String title) {
		super(title);

		getContentPane().setLayout(new GridLayout(2, 2, 0, 0));

		// 创建标签
		JLabel lblTextFieldLabel = new JLabel("选择你喜欢的编程语言：");
		lblTextFieldLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblTextFieldLabel);

		// 实例化JComboBox对象
		choice1 = new JComboBox(s1);
		// 注册Action事件侦听器，采用Lambda表达式
		choice1.addActionListener(e -> {
			JComboBox cb = (JComboBox) e.getSource();
			// 获得选择的项目
			String itemString = (String) cb.getSelectedItem();
			System.out.println(itemString);
		});

		getContentPane().add(choice1);

		// 创建标签
		JLabel lblTextAreaLabel = new JLabel("选择性别：");
		lblTextAreaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblTextAreaLabel);

		// 实例化JComboBox对象，采用Lambda表达式
		choice2 = new JComboBox(s2);
		// 注册项目选择事件侦听器
		choice2.addItemListener(e -> {
			// 项目选择
			if (e.getStateChange() == ItemEvent.SELECTED) {
				// 获得选择的项目
				String itemString = (String) e.getItem();
				System.out.println(itemString);
			}
		});
		getContentPane().add(choice2);

		// 设置窗口大小
		setSize(400, 150);

		// 设置窗口可见
		setVisible(true);
	}

}
