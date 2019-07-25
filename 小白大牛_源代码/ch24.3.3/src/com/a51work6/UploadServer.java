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


//UploadServer.java文件
package com.a51work6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UploadServer {
    public static void main(String args[]) {

        System.out.println("服务器端运行...");

        // 创建一个子线程
        Thread t = new Thread(() -> {

            try ( // 创建DatagramSocket对象，指定端口8080
                  DatagramSocket socket = new DatagramSocket(8080);
                  FileOutputStream fout = new FileOutputStream("./TestDir/subDir/coco2dxcplus.jpg");
                  BufferedOutputStream out = new BufferedOutputStream(fout)) {

                // 准备一个缓冲区
                byte[] buffer = new byte[1024];

                //循环接收数据报包
                while (true) {

                    // 创建数据报包对象，用来接收数据
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    // 接收数据报包
                    socket.receive(packet);
                    // 接收数据长度
                    int len = packet.getLength();

                    if (len == 3) {
                        // 获得结束标志
                        String flag = new String(buffer, 0, 3);
                        // 判断结束标志，如果是bye结束接收
                        if (flag.equals("bye")) {
                            break;
                        }
                    }
                    // 写入数据到文件输出流
                    out.write(buffer, 0, len);
                }
                System.out.println("接收完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // 启动线程
        t.start();
    }
}
