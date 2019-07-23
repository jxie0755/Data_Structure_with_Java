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


//Stack.java文件
package com.a51work6;

//堆栈类
class Stack {
    // 堆栈指针初始值为0
    private int pointer = 0;
    // 堆栈有5个字符的空间
    private char[] data = new char[5];

    // 压栈方法，加上互斥锁
    public synchronized void push(char c) {
        // 堆栈已满，不能压栈
        while (pointer == data.length) {
            try {
                // 等待，直到有数据出栈
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // 通知其它线程把数据出栈
        this.notify();
        // 数据压栈
        data[pointer] = c;
        // 指针向上移动
        pointer++;
    }

    // 出栈方法，加上互斥锁
    public synchronized char pop() {
        // 堆栈无数据，不能出栈
        while (pointer == 0) {
            try {
                // 等待其它线程把数据压栈
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // 通知其它线程压栈
        this.notify();
        // 指针向下移动
        pointer--;
        // 数据出栈
        return data[pointer];
    }
}
