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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
	// 声明标签
	JLabel label;

	public MyFrame(String title) {
		super(title);

		// 创建Label
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
		/*
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// 退出系统
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		*/
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// 退出系统
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		label.setText("Hello Swing!");
	}
}
