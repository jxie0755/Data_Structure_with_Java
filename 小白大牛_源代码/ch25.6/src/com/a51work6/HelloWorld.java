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


//HelloWorld.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class HelloWorld {

    public static void main(String[] args) {
        List<Book> data = readData();
        new MyFrameTable("图书库存", data);
    }

    // 从文件中读取数据
    private static List<Book> readData() {
        // 返回的数据列表
        List<Book> list = new ArrayList<Book>();
        // 数据文件
        String dbFile = "./db/Books.json";

        try (FileInputStream fis = new FileInputStream(dbFile);
             InputStreamReader ir = new InputStreamReader(fis);
             BufferedReader in = new BufferedReader(ir)) {

            // 1.读取文件
            StringBuilder sbuilder = new StringBuilder();
            String line = in.readLine();

            while (line != null) {
                sbuilder.append(line);
                line = in.readLine();
            }

            // 2.JSON解码
            // 读取JSON字符完成
            System.out.println("读取JSON字符完成...");
            // JSON解码，解码成功返回JSON数组
            JSONArray jsonArray = new JSONArray(sbuilder.toString());
            System.out.println("JSON解码成功完成...");

            // 3.将JSON数组放到List<Book>集合中
            // 遍历集合
            for (Object item : jsonArray) {

                JSONObject row = (JSONObject) item;

                Book book = new Book();
                book.setBookid((String) row.get("bookid"));
                book.setBookname((String) row.get("bookname"));
                book.setAuthor((String) row.get("author"));
                book.setPublisher((String) row.get("publisher"));
                book.setPubtime((String) row.get("pubtime"));
                book.setInventory((Integer) row.get("inventory"));

                list.add(book);
            }

        } catch (Exception e) {
        }

        return list;
    }
}
