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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

	// 用于标签切换的图标
	private static Icon images[] = { new ImageIcon("./icon/0.png"), 
			new ImageIcon("./icon/1.png"),
			new ImageIcon("./icon/2.png"), 
			new ImageIcon("./icon/3.png"), 
			new ImageIcon("./icon/4.png"),
			new ImageIcon("./icon/5.png") };
	
	// 当前页索引
	private static int currentPage = 0;

	public MyFrame(String title) {
		super(title);

		// 设置窗口大小不变的
		setResizable(false);

		// 不设置布局管理器
		getContentPane().setLayout(null);

		// 创建标签
		JLabel label = new JLabel(images[0]);
		// 设置标签的位置和大小
		label.setBounds(94, 27, 100, 50);
		// 设置标签文本水平居中
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// 添加标签到内容面板
		getContentPane().add(label);

		// 创建向后翻页按钮
		JButton backButton = new JButton(new ImageIcon("./icon/ic_menu_back.png"));
		// 设置按钮的位置和大小
		backButton.setBounds(77, 90, 47, 30);
		// 添加按钮到内容面板
		getContentPane().add(backButton);

		// 创建向前翻页按钮
		JButton forwardButton = new JButton(new ImageIcon("./icon/ic_menu_forward.png"));
		// 设置按钮的位置和大小
		forwardButton.setBounds(179, 90, 47, 30);
		// 添加按钮到内容面板
		getContentPane().add(forwardButton);

		// 设置窗口大小
		setSize(300, 200);
		// 设置窗口可见
		setVisible(true);

		// 注册事件监听器，监听向后翻页按钮单击事件
		backButton.addActionListener((event) -> {
			if (currentPage < images.length - 1) {
				currentPage++;
			}
			label.setIcon(images[currentPage]);
		});

		// 注册事件监听器，监听向前翻页按钮单击事件
		forwardButton.addActionListener((event) -> {
			if (currentPage > 0) {
				currentPage--;
			}
			label.setIcon(images[currentPage]);
		});

	}
}
