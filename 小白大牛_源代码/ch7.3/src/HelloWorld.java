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


public class HelloWorld {

    public static void main(String[] args) {

        int i = 0;
        int a = 10;
        int b = 9;

        if ((a > b) || (i == 1)) {
            System.out.println("或运算为 真");
        } else {
            System.out.println("或运算为 假");
        }

        if ((a < b) && (i == 1)) {
            System.out.println("与运算为 真");
        } else {
            System.out.println("与运算为 假");
        }

        if ((a > b) || (a++ == --b)) {
            System.out.printf("a = %s, b = %s", a, b);
        }
    }
}
