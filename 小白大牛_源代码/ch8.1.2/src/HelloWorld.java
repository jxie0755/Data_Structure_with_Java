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

        int testScore = 75;

        char grade;
        switch (testScore / 10) {
            case 9:
                grade = '优';
                break;
            case 8:
                grade = '良';
                break;
            case 7: //7是贯通的
            case 6:
                grade = '中';
                break;
            default:
                grade = '差';
        }
        System.out.println("Grade = " + grade);

    }
}
