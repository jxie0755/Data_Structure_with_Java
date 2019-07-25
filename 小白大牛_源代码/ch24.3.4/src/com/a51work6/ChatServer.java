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


// ChatServer.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatServer {

    public static void main(String args[]) {

        System.out.println("服务器运行...");
        // 创建一个子线程
        Thread t = new Thread(() -> {
            try ( // 创建DatagramSocket对象，指定端口8080
                  DatagramSocket socket = new DatagramSocket(8080);
                  BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

                while (true) {
                    /* 接收数据报 */
                    // 准备一个缓冲区
                    byte[] buffer = new byte[128];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    // 接收数据长度
                    int len = packet.getLength();

                    String str = new String(buffer, 0, len);
                    // 打印接收的数据
                    System.out.printf("从客户端接收的数据：【%s】\n", str);

                    /* 发送数据 */
                    // 从客户端传来的数据包中得到客户端地址
                    InetAddress address = packet.getAddress();
                    // 从客户端传来的数据包中得到客户端端口号
                    int port = packet.getPort();

                    // 读取键盘输入的字符串
                    String keyboardInputString = keyboardIn.readLine();
                    // 读取键盘输入的字节数组
                    byte[] b = keyboardInputString.getBytes();
                    // 创建DatagramPacket对象，用于向客户端发送数据
                    packet = new DatagramPacket(b, b.length, address, port);
                    // 向客户端发送数据
                    socket.send(packet);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // 启动线程
        t.start();
    }
}
