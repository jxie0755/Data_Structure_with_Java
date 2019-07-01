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


//ChatClient.java文件
package com.a51work6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

import org.json.JSONObject;

public class ChatClient {

	public static void main(String[] args) {

		System.out.println("客户端运行...");

		Thread t = new Thread(() -> {

			try ( // 向127.0.0.1主机8080端口发出连接请求
					Socket socket = new Socket("127.0.0.1", 8080);
					DataInputStream in = new DataInputStream(socket.getInputStream());
					DataOutputStream out = new DataOutputStream(socket.getOutputStream());
					BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))) {

				while (true) {
					/* 发送数据 */
					// 读取键盘输入的字符串
					String keyboardInputString = keyboardIn.readLine();
					// 结束聊天
					if (keyboardInputString.equals("bye")) {
						break;
					}
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("message", keyboardInputString);
					jsonObject.put("userid", "javaee");
					jsonObject.put("username", "关东升");

					// 发送
					out.writeUTF(jsonObject.toString());
					out.flush();

					/* 接收数据 */
					String str = in.readUTF();
					jsonObject = new JSONObject(str);
					// 打印接收的数据
					System.out.printf("从服务器接收的数据：%s \n", str);
				}
			} catch (ConnectException e) {
				System.out.println("服务器未启动！");
			} catch (Exception e) {
			}
			System.out.println("客户端停止！");
		});

		t.start();

	}
}
