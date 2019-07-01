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
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UploadClient {

	public static void main(String[] args) {

		System.out.println("客户端运行...");

		try ( 	// 创建DatagramSocket对象，由系统分配可以使用的端口
				DatagramSocket socket = new DatagramSocket();
				FileInputStream fin = new FileInputStream("./TestDir/coco2dxcplus.jpg");
				BufferedInputStream in = new BufferedInputStream(fin)) {

			// 创建远程主机IP地址对象
			InetAddress address = InetAddress.getByName("localhost");

			// 准备一个缓冲区
			byte[] buffer = new byte[1024];
			// 首次从文件流中读取数据
			int len = in.read(buffer);

			while (len != -1) {
				// 创建数据报包对象
				DatagramPacket packet = new DatagramPacket(buffer, len, address, 8080);
				// 发送数据报包
				socket.send(packet);
				// 再次从文件流中读取数据
				len = in.read(buffer);
			}

			// 创建数据报对象
			DatagramPacket packet = new DatagramPacket("bye".getBytes(), 3, address, 8080);
			// 发送结束标志
			socket.send(packet);
			System.out.println("上传完成！");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
