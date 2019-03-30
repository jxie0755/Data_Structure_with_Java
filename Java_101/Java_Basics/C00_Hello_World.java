package Java_Basics;

public class C00_Hello_World {
    /* 第一个Java程序.
     * 它将打印字符串 Hello World
     */


    /*
     * 编写Java程序时，应注意以下几点：
     * 大小写敏感：Java是大小写敏感的，这就意味着标识符Hello与hello是不同的。
     * 类名：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 MyFirstJavaClass 。
     * 方法名：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
     * 源文件名：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存，文件名的后缀为.java。（如果文件名和类名不相同则会导致编译错误）。
     * ]主方法入口：所有的Java 程序由public static void main(String args[])方法开始执行。
     */


    /*
     * Java标识符 - Java所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。
     * 关于Java标识符，有以下几点需要注意：
     * 所有的标识符都应该以字母（A-Z或者a-z）,美元符（$）、或者下划线（_）开始
     * 首字符之后可以是任何字符的组合
     * 关键字不能用作标识符
     * 标识符是大小写敏感的
     * 合法标识符举例：age、$salary、_value、__1_value
     * 非法标识符举例：123abc、-salary
     */


    /*
     * 像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：
     * 访问控制修饰符 : default, public , protected, private
     * 非访问控制修饰符 : final, abstract, static，synchronized 和 volatile
     */


    /*
     * Java变量 - Java中主要有如下几种类型的变量
     * 局部变量
     * 类变量（静态变量）
     * 成员变量（非静态变量）
     */

    public static void main_head(String[] args) {   // this will not be executed
        System.out.println("From main 2");
    }

    public static int larger(int x, int y) {
		if (x > y) {
			return x;
		}
		return y;
	}

    public static void main(String[] args) {  // The main has to be public
                                              // If private, then there is nothing to execute

        System.out.println("Hello World"); // 打印 Hello World

        int x = 5;
        int y = x +3;  // must also claim y's type
        System.out.println("From main():");
        System.out.println(y);
        System.out.println(larger(99, 101));
        System.out.println("From larger_tail:");
        System.out.println(larger_tail(99, 101));  // Actually the method (larger_tail) can be behind main()

        /*
         * Javac会执行main方法在{}内的所有指令
         * 每个Java程序最少都会有一个类以及一个main()
         * 每个应用程序只有一个main()函数
         * 不是每个文件都需要一个main,可能你只是写一个类让其他类去引用
         */


        /*
         * 在java中所有的东西都会属于某个类.
         * 源文件(*.java)会被编译成类文件(*.class)
         * 真正被执行的是类
         * 要执行某个程序就代表要命令java虚拟机(JVM)去加载这个类,开始执行它的main(),直到main()被执行完成
        */

    }

    // Defined after main?

    public static void main_tail(String[] args) {   // this will not be executed
        System.out.println("From main 2");
    }

    public static int larger_tail(int x, int y) {
		if (x > y) {
		    return x;
		}
		return y;
	}

    /*
     * public：代表着该函数访问权限是最大的
     * static：代表主函数随着类的加载就已经存在了
     * void：主函数没有具体的返回值
     * main：不是关键字，但是一个特殊的单词，能够被JVM识别
     * （String[] args）：函数的参数，参数类型是一个数组，该数组中的元素师字符串，字符串数组。main(String[] args) 字符串数组的 此时空数组的长度是0，但也可以在 运行的时候向其中传入参数。
     */
}
