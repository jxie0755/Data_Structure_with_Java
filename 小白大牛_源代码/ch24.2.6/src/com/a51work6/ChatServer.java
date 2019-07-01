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


//ChatServer.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {

		System.out.println("服务器运行...");

		Thread t = new Thread(() -> {

			try ( // 创建一个ServerSocket监听端口8080客户请求
					ServerSocket server = new ServerSocket(8080);
					// 使用accept()阻塞等待客户端请求
					Socket socket = server.accept();
					DataInputStream in = new DataInputStream(socket.getInputStream());
					DataOutputStream out = new DataOutputStream(socket.getOutputStream());
					BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

				while (true) {
					/* 接收数据 */
					String str = in.readUTF();
					// 打印接收的数据
					System.out.printf("从客户端接收的数据：【%s】\n", str);

					/* 发送数据 */
					// 读取键盘输入的字符串
					String keyboardInputString = keyboardIn.readLine();
					// 结束聊天
					if (keyboardInputString.equals("bye")) {
						break;
					}
					// 发送
					out.writeUTF(keyboardInputString);
					out.flush();
				}
			} catch (Exception e) {
			}
			System.out.println("服务器停止...");
		});

		t.start();
	}
}
