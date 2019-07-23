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

public class HelloWorld {

    public static void main(String[] args) {

        int n1 = 10;

        // 实现二次方计算Calculable对象
        Calculable f1 = calculate(2);
        // 实现三次方计算Calculable对象
        Calculable f2 = calculate(3);

        // 调用calculateInt方法进行加法计算
        System.out.printf("%d二次方 = %d \n", n1, f1.calculateInt(n1));
        // 调用calculateInt方法进行减法计算
        System.out.printf("%d三次方 = %d \n", n1, f2.calculateInt(n1));
    }

    /**
     * 通过幂计算
     *
     * @param power 幂
     * @return 实现Calculable接口对象
     */
    public static Calculable calculate(int power) {

        Calculable result;

        if (power == 2) {
            // Lambda表达式实现Calculable接口
            result = (int a) -> {    //标准形式
                return a * a;
            };
        } else {
            // Lambda表达式实现Calculable接口
            result = a -> a * a * a; //省略形式
        }

        return result;
    }
}
