package W3C_Java_Classes;

public class A13_Enum {

    /*
     * Module java.base
     * Package java.lang
     * Class Enum<E extends Enum<E>>
     */


    /*
     * 枚举类 (Java5推出)
        * 枚举用来管理一组相关常量的集合，使用枚举可以提高程序的可读性，使代码更清晰且更易于维护。
        * 枚举常量列表是枚举的核心，它由一组相关常量组成。
            * switch语句时， 提到过switch表达式类型和case常量类型只能是int、byte、short和char类型
            * 而Java 5之后还可以是枚举类型。
            * 另外在switch中使用枚举类型时，switch语句中的case分支语句个数应该对应枚举常量个数，不要多也不要少，
            * 当使用default时default应该只表示等于最后一个枚举常量情况。
     */

}


// 在Java 5之前没有提供枚举类型， 可以通过声明静态常量（final static变量） 替代枚举常量
interface WeekDays {
    // 枚举常量列表
    int MONDAY = 1;    //星期一
    int TUESDAY = 2;   //星期二
    int WEDNESDAY = 3; //星期三
    int THURSDAY = 4;  //星期四
    int FRIDAY = 5;    //星期五
}

// 使用枚举类型的interface
class HelloWorld_oldEnum {
    public static void main(String[] args) {
        //day工作日变量
        int day = WeekDays.FRIDAY;

        switch (day) {
            case WeekDays.MONDAY:
                System.out.println("星期一");
                break;
            case WeekDays.TUESDAY:
                System.out.println("星期二");
                break;
            case WeekDays.WEDNESDAY:
                System.out.println("星期三");
                break;
            case WeekDays.THURSDAY:
                System.out.println("星期四");
                break;
            case WeekDays.FRIDAY:
                System.out.println("星期五");
                break;
        }
        // >>> 星期五

        /*
         * 但这种方式还存在一些问题：
         * 类型不安全。
            * 代码第1行是声明工作日变量day，day是整数类型, 根据定义必须是1-5的范围
            * 程序执行过程中很有可能给day变量传入一个任意的整数值，可能导致程序出现错误。
         * 程序不方便调试。
            * 在程序调试时，如果通过日志输出day值，那么只能看到1~5之间的数值，不知道1-5代表了什么
            * 程序员需要比较这些数值代表的含义， 才能知道输出的结果是什么。
         */
    }
}


enum EN_WeekDays {
    // 枚举常量列表
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

class HelloWorld_newEnum {
    public static void main(String[] args) {
        // day工作日变量
        EN_WeekDays day = EN_WeekDays.FRIDAY;
        System.out.println(day);

        switch (day) {  // 原本switch只支持基本类型, java5后支持枚举类对象
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            default: //case FRIDAY:
                System.out.println("星期五");
        }
    }
}