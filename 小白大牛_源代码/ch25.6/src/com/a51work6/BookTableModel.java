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


//BookTableModel.java文件
package com.a51work6;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel {

	// 列名数组
	private String[] columnNames = { "书籍编号", "书籍名称", "作者", "出版社", "出版日期", "库存数量" };

	// data保存了表格中数据，data类型是List集合
	private List<Book> data = null;

	public BookTableModel(List<Book> data) {
		this.data = data;
	}

	// 获得列数
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	// 获得行数
	@Override
	public int getRowCount() {
		return data.size();
	}

	// 获得某行某列的数据
	@Override
	public Object getValueAt(int row, int col) {

		Book book = (Book) data.get(row);
		switch (col) {
		case 0:
			return book.getBookid();
		case 1:
			return book.getBookname();
		case 2:
			return book.getAuthor();
		case 3:
			return book.getPublisher();
		case 4:
			return book.getPubtime();
		case 5:
			return new Integer(book.getInventory());
		}
		return null;
	}

	// 获得某列的名字
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
}
