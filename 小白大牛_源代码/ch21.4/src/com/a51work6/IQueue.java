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

//IQueue.java文件
package com.a51work6;

/**
 * 自定义的泛型队列集合
 */
public interface IQueue<T> {

    /**
     * 入队方法
     *
     * @param item 参数需要入队的元素
     */
    public void queue(T item);

    /**
     * 出队方法
     *
     * @return 返回出队元素
     */
    public T dequeue();

}
