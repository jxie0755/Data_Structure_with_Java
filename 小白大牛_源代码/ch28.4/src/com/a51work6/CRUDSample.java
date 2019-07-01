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


//CRUDSample.java文件
package com.a51work6;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CRUDSample {

	// 连接数据库url
	static String url;
	// 创建Properties对象
	static Properties info = new Properties();

	// 1.驱动程序加载
	static {
		// 获得属性文件输入流
		InputStream input = CRUDSample.class.getClassLoader().getResourceAsStream("config.properties");

		try {
			// 加载属性文件内容到Properties对象
			info.load(input);
			// 从属性文件中取出url
			url = info.getProperty("url");
			// Class.forName("com.mysql.jdbc.Driver");
			// 从属性文件中取出driver
			String driverClassName = info.getProperty("driver");
			Class.forName(driverClassName);
			System.out.println("驱动程序加载成功...");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动程序加载失败...");
		} catch (IOException e) {
			System.out.println("加载属性文件失败...");
		}
	}

	public static void main(String[] args) {

		// 查询数据
		read();

		// 数据插入
		create();

		// 数据更新
		update();

		// 删除删除
		delete();
	}

	// 数据查询操作
	public static void read() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, info);
			// 3. 创建语句对象
			pstmt = conn.prepareStatement("select name,userid from " + "user where userid > ? order by userid");
			// 4. 绑定参数
			pstmt.setInt(1, 0);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
			while (rs.next()) {
				System.out.printf("id: %d	name: %s\n", rs.getInt(2), rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// 查询最大的用户Id
	public static int readMaxUserId() {

		int maxId = 0;
		try (
				// 2.创建数据库连接
				Connection conn = DriverManager.getConnection(url, info);
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement("select max(userid) from user");
				// 4. 绑定参数
				// pstmt.setInt(1, 0);
				// 5. 执行查询（R）
				ResultSet rs = pstmt.executeQuery()) {
			// 6. 遍历结果集
			if (rs.next()) {
				maxId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maxId;
	}

	// 数据插入操作
	public static void create() {

		try ( // 2.创建数据库连接
				Connection conn = DriverManager.getConnection(url, info);
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement("insert into user (userid, name) values (?,?)")) {

			// 查询最大值
			int maxId = readMaxUserId();

			// 4. 绑定参数
			pstmt.setInt(1, ++maxId);
			pstmt.setString(2, "Tony" + maxId);
			// 5. 执行修改（C、U、D）
			int affectedRows = pstmt.executeUpdate();

			System.out.printf("成功插入%d条数据。\n", affectedRows);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 数据更新操作
	public static void update() {

		try ( // 2.创建数据库连接
				Connection conn = DriverManager.getConnection(url, info);
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement("update user set name = ? where userid > ?")) {

			// 4. 绑定参数
			pstmt.setString(1, "Tom");
			pstmt.setInt(2, 30);
			// 5. 执行修改（C、U、D）
			int affectedRows = pstmt.executeUpdate();

			System.out.printf("成功更新%d条数据。\n", affectedRows);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 数据删除操作
	public static void delete() {

		try ( // 2.创建数据库连接
				Connection conn = DriverManager.getConnection(url, info);
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement("delete from user where userid = ?")) {

			// 查询最大值
			int maxId = readMaxUserId();

			// 4. 绑定参数
			pstmt.setInt(1, maxId);
			// 5. 执行修改（C、U、D）
			int affectedRows = pstmt.executeUpdate();

			System.out.printf("成功删除%d条数据。\n", affectedRows);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
