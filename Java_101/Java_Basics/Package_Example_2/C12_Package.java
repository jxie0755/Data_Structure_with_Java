package Java_Basics.Package_Example_2;

public class C12_Package { }


// 假设fakejava文件夹下有如下文件:
/*
 * fakejava
    * com
        * Car.java       -- 头部标明 package路径, com.car
        * CarTest.java   -- 头部标明 package路径, com.test, 然后import com.car.Car
        * car            -- 路径 (javac后生成)
        * test           -- 路径 (javac后生成)
 */

/*
     * javac 编译命令
     * 在编译一个*.java文件时, 如果直接使用 javac xxx.java的话, 那么将会在java文件同处生成*.class文件.
     * 但是, 在此例中,或者很多地方, *.java文件头部会标明package位置, 那么相应的*.class文件如果需要生成到package位置, 需要使用 -d
        * 使用 -d 时后接 . 直接可以在*.java文件所在目录生成package的目录, 然后把*.class生成在package中:
            * javac -d . *.java (编译当前路径下所有java文件, 不包含子路径)
        * 使用 -d 时也可以强行指定在任何地方生成package目录
            * javac -d ~/Documents *.java
            * 这里会先在当前路径先生成Documents, 然后在其中生成com/car或者test的两层路径, 然后*.class文件在此生成.

        * 还可以使用cat *.java命令来在terminal中显示这个java脚本的文字内容
     */

    /*
     * java 执行
     * 位处于*.class位置执行
        * java ***.class  (注意使用全名: 包名.类名.class)
     * 可以在*.java位置执行, 使用
        * java -cp .:/ com.test.CarTest
            * -cp 是-classpath的意思
            * . 表示从当前位置开始
            * :/ 表示往下
            * 最后 加上类全名
     */


/*
 * Java包
 * 为了更好地组织类，Java提供了包机制，用于区别类名的命名空间
     * 把功能相似或相关的类或接口组织在同一个包中，方便类的查找和使用。
     * 如同文件夹一样，包也采用了树形目录的存储方式。同一个包中的类名字是不同的，不同的包中的类的名字是可以相同的，当同时调用两个不同包中相同类名的类时，应该加上包名加以区别。因此，包可以避免名字冲突。
     * 包也限定了访问权限，拥有包访问权限的类才能访问某个包中的类。
 * Java使用包（package）这种机制是为了防止命名冲突，访问控制，提供搜索和定位类（class）、接口、枚举（enumerations）和注释（annotation）等
 */

// 语法: package pkg1[．pkg2[．pkg3…]]; 如置顶语句


// package net.java.util
// public class Something{
//    ...
// }
// 路径应该是 net/java/util/Something.java


/*
 * 一个包（package）可以定义为一组相互联系的类型（类、接口、枚举和注释），为这些类型提供访问保护和命名空间管理的功能。
 * 以下是一些Java中的包:
    * java.lang-打包基础的类
    * java.io-包含输入输出功能的函数
 */


/*
 开发者可以自己把一组类和接口等打包，并定义自己的package。而且在实际开发中这样做是值得提倡的，当你自己完成类的实现之后，将相关的类分组，可以让其他的编程者更容易地确定哪些类、接口、枚举和注释等是相关的
 */

/*
 * 创建package的时候，你需要为这个package取一个合适的名字。
 * 之后，如果其他的一个源文件包含了这个包提供的类、接口、枚举或者注释类型的时候，都必须将这个package的声明放在这个源文件的开头。
 * 包声明应该在源文件的第一行，每个源文件只能有一个包声明，这个文件中的每个类型都应用于它。
 * 如果一个源文件中没有使用包声明，那么其中的类，函数，枚举，注释等将被放在一个无名的包（unnamed package）中。
 * 通常使用小写的字母来命名避免与类、接口名字的冲突
 */



// import
// 语法: import package1[.package2…].(classname|*);
// 导入所有包下的类: import com.apple.computers.*;



// Package目录结构
/*
 * package的目录结构
 * 类放在包中会有两种主要的结果:
     * 包名成为类名的一部分，正如我们前面讨论的一样
     * 包名必须与相应的字节码所在的目录结构相吻合
     * 下面是管理你自己java中文件的一种简单方式
 * 将类、接口等类型的源码放在一个文件中，这个文件的名字就是这个类型的名字，并以.java作为扩展名
 */



/*
 * 通常，一个公司使用它互联网域名的颠倒形式来作为它的包名.例如：互联网域名是apple.com，所有的包名都以com.apple开头.
 * 包名中的每一个部分对应一个子目录
 */

// 这个公司有一个com.apple.computers的包，这个包包含一个叫做Dell.java的源文件:
// \com\apple\computers\Dell.java


/*
 * 类目录的绝对路径叫做class path。设置在系统变量CLASSPATH中。
 * 编译器和java虚拟机通过将package名字加到class path后来构造.class文件的路径
     * <path- two>\classes是class path，package名字是com.apple.computers,
     * 而编译器和JVM会在 <path-two>\classes\com\apple\compters中找.class文件。
 */
