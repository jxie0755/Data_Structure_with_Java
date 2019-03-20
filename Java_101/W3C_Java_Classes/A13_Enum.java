package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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


        * 介绍
            * Java枚举类型是一种类， 是引用类型， 具有了面向对象特性， 可以添加方法和成员变量等。
                * 枚举类可以像类一样包含成员变量和成员方法
                    * 成员变量可以是实例变量也可以是静态变量
                    * 成员方法可以是实例方法，也可以是静态方法，但不能是抽象方法
            * Java枚举类型父类是java.lang.Enum，不需要显式声明 (不写extends Enum)
            * Java枚举类型可以实现接口，与类实现接口类似。
            * Java枚举类型不能被继承，不存在子类。
     */

    /*
     * Enum常用方法
        * 注意枚举类的中的构造方法只能是私有访问级别， 构造方法可以省略private关键字， 但它仍然是私有的构造方法。
            * 这也说明了枚举类不允许在外部创建对象

        * values()            static方法, 返回一个数组, 包含全部枚举类常量
        * int ordinal()       返回枚举常量的顺序。 这个顺序根据枚举常量声明的顺序而定， 顺序从零开始
        * valueOf(str)        静态方法， str是枚举常量对应的字符串， 返回一个包含枚举类型实例
        * equals (==)         对比是否相等
        * name()              返回常量名(String)相当于toString

        * getDeclaringClass() 返回这个自定义枚举类的Class


        * hashcode()
        * compareTo           比较(取决于枚举顺序)
        * clone()
        * toString()
     */

    /*
     * Equality
     * 在Java类引用类型进行比较时, 有两种比较方法==和equals
        * ==比较的是两个引用是否指向同一个对象
        * equals是比较对象内容是否相同
     * 但是， 枚举引用类型中==和equals都是一样的,都是比较两个引用是否指向同一个实例
        * 因为枚举类中每个枚举常量无论何时都只有一个对象, 所以是一样的
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
         * 程序不方便调试
            * 在程序调试时，如果通过日志输出day值，那么只能看到1~5之间的数值，不知道1-5代表了什么
            * 程序员需要比较这些数值代表的含义， 才能知道输出的结果是什么。
         */
    }
}


enum EN_WeekDays {
    // 枚举常量列表
    // MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    // 有了构造方法后常量列表就不能用了, 必须要构造常量
    // 每一个枚举常量都是一个实例， 都会调用构造方法进行初始化成员变
    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    WEDNESDAY("星期三", 3),
    THURSDAY("星期四", 4),
    FRIDAY("星期五", 5);

    // 实例变量
    String name;     //默认情况下(如果没有构造方法), name就是列表的中元素的String
    private int index;

    int getIndex() {
        return this.index;
    }

    // 静态变量
    static int staticVar = 100;


    // 构造方法(默认为private)
    private EN_WeekDays(String name, int index) {
        this.name = name;
        this.index = index;
    }


    // 覆盖父类中的toString()方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append('-');
        sb.append(super.toString());
        return sb.toString();
    }

    // 静态方法
    public static int getStaticVar() {
        return staticVar;
    }
}

class HelloWorld_newEnum {
    public static void main(String[] args) {

        // 使用枚举类
        // day工作日变量
        EN_WeekDays day = EN_WeekDays.FRIDAY;

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

        // 学习枚举类的特性
        // 打印da自定义toString()方法
        System.out.println(day); // >>>  星期五-FRIDAY
        System.out.println(EN_WeekDays.getStaticVar()); // >>> 100
    }
}

class A13_Enum_zMethods {

    // 继续使用以上EN_WeekDays来做例子
    public static void main(String[] args) {

        // 构造方法可以略过

        // values()  static方法, 返回一个数组, 包含全部枚举类常量
        EN_WeekDays[] allDays = EN_WeekDays.values();


        // int ordinal()
        // 返回枚举常量的顺序。 这个顺序根据枚举常量声明的顺序而定， 顺序从零开始 (跟自定义的idx无关)
        for (EN_WeekDays value : allDays) {
            System.out.println(value.ordinal() + "->" + value);
        }
        // >>>
        // 0->星期一-MONDAY
        // 1->星期二-TUESDAY
        // 2->星期三-WEDNESDAY
        // 3->星期四-THURSDAY
        // 4->星期五-FRIDA
        EN_WeekDays dayx = EN_WeekDays.THURSDAY;
        System.out.println(dayx.ordinal()); // >>>  3
        System.out.println(dayx.getIndex());     // >>> 4
        System.out.println(dayx.name);     // >>> 星期四


        // valueOf 类似List valueOf, 快速返回一个枚举类常量
        EN_WeekDays day1 = EN_WeekDays.MONDAY;
        EN_WeekDays day2 = EN_WeekDays.valueOf("WEDNESDAY");  // 无关自定义toString
        EN_WeekDays day3 = EN_WeekDays.TUESDAY;
        System.out.println(day1); // >>>  星期一-MONDAY
        System.out.println(day2); // >>>  星期三-WEDNESDAY
        // 也可以强制检查类型,两个参数
        EN_WeekDays day4 = Enum.valueOf(EN_WeekDays.class, "MONDAY");
        System.out.println(day4.getClass());    // class W3C_Java_Classes.EN_WeekDays
        System.out.println(EN_WeekDays.class);  // >>> class W3C_Java_Classes.EN_WeekDays


        // equals
        System.out.println(day2.equals(EN_WeekDays.WEDNESDAY)); // >>> true
        System.out.println(day1.equals(day2));            // >>> false
        System.out.println(day1 == day2);                 // >>>  false


        // comparTo
        System.out.println(day1.compareTo(day3)); // >>>  -1 小于
        System.out.println(Collections.max(new ArrayList<EN_WeekDays>(Arrays.asList(day1, day2, day3))));
        // >>> 星期三-WEDNESDAY


        // 	getDeclaringClass()
        System.out.println(day1.getDeclaringClass()); // >>> class W3C_Java_Classes.EN_WeekDays


        // name()
        System.out.println(day1.name()); // >>>  "MONDAY"
        System.out.println(day1.name().getClass()); // >>>  class java.lang.String
        System.out.println(day1.toString().equals(day1.name())); // >>> false // 如果不自定义toString就应该是相等的

    }
}


enum WorkDays {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
}

class WorkDaysTest {
    public static void main(String[] args) {
        WorkDays day1 = WorkDays.valueOf("MONDAY");
        System.out.println(day1); // >>>  MONDAY
    }
}