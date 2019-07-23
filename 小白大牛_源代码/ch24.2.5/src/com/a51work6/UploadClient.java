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


//UploadClient.java文件
package com.a51work6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class UploadClient {

    public static void main(String[] args) {

        System.out.println("客户端运行...");

        try ( // 向本机的8080端口发出请求
              Socket socket = new Socket("127.0.0.1", 8080);
              // 由Socket获得输出流，并创建缓冲输出流
              BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
              // 创建文件输入流
              FileInputStream fin = new FileInputStream("./TestDir/coco2dxcplus.jpg");
              // 由文件输入流创建缓冲输入流
              BufferedInputStream in = new BufferedInputStream(fin)) {

            // 准备一个缓冲区
            byte[] buffer = new byte[1024];
            // 首次读取文件
            int len = in.read(buffer);
            while (len != -1) {
                // 数据写入Socket
                out.write(buffer, 0, len);
                // 再次读取文件
                len = in.read(buffer);
            }

            System.out.println("上传成功！");

        } catch (ConnectException e) {
            System.out.println("服务器未启动！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
