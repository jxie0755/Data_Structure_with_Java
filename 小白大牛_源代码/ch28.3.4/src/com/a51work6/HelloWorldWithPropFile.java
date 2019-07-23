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


//HelloWorldWithPropFile.java文件
package com.a51work6;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class HelloWorldWithPropFile {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            // 退出
            return;
        }

        Properties info = new Properties();
        try {
            InputStream input = HelloWorldWithPropFile.class.getClassLoader().getResourceAsStream("config.properties");

            info.load(input);

        } catch (IOException e) {
            // 退出
            return;
        }

        String url = "jdbc:mysql://localhost:3306/MyDB";

        try ( // 自动资源管理技术释放资源
              Connection conn = DriverManager.getConnection(url, info);
              Statement stmt = conn.createStatement();
              ResultSet rst = stmt.executeQuery("select name,userid from user")) {

            while (rst.next()) {
                System.out.printf("name:%s	id:%d\n", rst.getString("name"), rst.getInt(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
