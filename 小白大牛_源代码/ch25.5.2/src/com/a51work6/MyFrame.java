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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public MyFrame(String title) {
		super(title);
		
		// 设置布局管理BorderLayout
		getContentPane().setLayout(new BorderLayout());

		// 创建一个面板panel1放置TextField和Password
		JPanel panel1 = new JPanel();
		// 将面板panel1添加到内容视图
		getContentPane().add(panel1, BorderLayout.NORTH);

		// 创建标签
		JLabel lblTextFieldLabel = new JLabel("TextField:");
		// 添加标签到面板panel1
		panel1.add(lblTextFieldLabel);

		// 创建文本框
		textField = new JTextField(12);
		// 添加文本框到面板panel1
		panel1.add(textField);
		

		// 创建标签
		JLabel lblPasswordLabel = new JLabel("Password:");
		// 添加标签面板panel1
		panel1.add(lblPasswordLabel);

		// 创建密码框
		passwordField = new JPasswordField(12);
		// 添加密码框到面板panel1
		panel1.add(passwordField);

		// 创建一个面板panel2放置TextArea
		JPanel panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.SOUTH);

		// 创建标签
		JLabel lblTextAreaLabel = new JLabel("TextArea:");
		// 添加标签到面板panel2
		panel2.add(lblTextAreaLabel);

		// 创建文本区
		JTextArea textArea = new JTextArea(3, 20);
		// 添加文本区到面板panel2
		panel2.add(textArea);

		// 设置窗口大小
		pack();	// 紧凑排列，其作用相当于setSize()
		
		// 设置窗口可见
		setVisible(true);
		
		textField.addActionListener((event)->{
			textArea.setText("在文本框上按下Enter键");
		});
	}
}
