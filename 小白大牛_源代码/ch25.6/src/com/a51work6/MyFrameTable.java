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


//MyFrameTable.java文件
package com.a51work6;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

public class MyFrameTable extends JFrame {

	// 获得当前屏幕的宽高
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private JTable table;
	//图书列表
	private List<Book> data;

	public MyFrameTable(String title, List<Book> data) {
		super(title);

		this.data = data;
		TableModel model = new BookTableModel(data);

		table = new JTable(model);
		// 设置表中内容字体
		table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		// 设置表列标题字体
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		// 设置表行高
		table.setRowHeight(40);
		// 设置为单行选中模式
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		// 返回当前行的状态模型
		ListSelectionModel rowSM = table.getSelectionModel();
		// 注册侦听器，选中行发生更改时触发
		rowSM.addListSelectionListener(e -> {
			//只处理鼠标按下
			if (e.getValueIsAdjusting() == false) {
				return;
			}			
			ListSelectionModel lsm = (ListSelectionModel) e.getSource();
			if (lsm.isSelectionEmpty()) {
				System.out.println("没有选中行");
			} else {
				int selectedRow = lsm.getMinSelectionIndex();
				System.out.println("第" + selectedRow + "行被选中");
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// 设置窗口大小
		setSize(960, 640);
		// 计算窗口位于屏幕中心的坐标
		int x = (int) (screenWidth - 960) / 2;
		int y = (int) (screenHeight - 640) / 2;
		// 设置窗口位于屏幕中心
		setLocation(x, y);

		// 设置窗口可见
		setVisible(true);
	}

}
