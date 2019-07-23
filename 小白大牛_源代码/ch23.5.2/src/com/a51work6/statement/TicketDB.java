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


//TicketDB.java文件
package com.a51work6.statement;

//机票数据库
public class TicketDB {

    // 机票的数量
    private int ticketCount = 5;

    // 获得当前机票数量
    public int getTicketCount() {
        return ticketCount;
    }

    // 销售机票
    public void sellTicket() {
        try {
            // 等于用户付款
            // 线程休眠，阻塞当前线程，模拟等待用户付款
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.printf("第%d号票,已经售出\n", ticketCount);
        ticketCount--;
    }
}
