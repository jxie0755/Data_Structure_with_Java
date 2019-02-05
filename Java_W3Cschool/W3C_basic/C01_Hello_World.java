package W3C_basic;

public class C01_Hello_World {
   /* 第一个Java程序.
    * 它将打印字符串 Hello World
    */
    public static void main(String []args) {
        System.out.println("Hello World"); // 打印 Hello World
    }
    /*
     * public：代表着该函数访问权限是最大的
     * static：代表主函数随着类的加载就已经存在了
     * void：主函数没有具体的返回值
     * main：不是关键字，但是一个特殊的单词，能够被JVM识别
     * （String[] args）：函数的参数，参数类型是一个数组，该数组中的元素师字符串，字符串数组。main(String[] args) 字符串数组的 此时空数组的长度是0，但也可以在 运行的时候向其中传入参数。
     */
}



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
