package W3C_basic;

// Learn multi class in one file

public class C05_OOP_A {

    class C05_OOP_B {

    }

}

class C05_OOP_C {

}

/*
 * 这样会产生两个.class文件:
    * C05_OOP_A.class
    * C05_OOP_Multi_C.class
    * B 没有被生成
 */

/*
 * 一个.java最多只能有一个public类, 且public类必须与文件同名
    * 但是.java可以没有public类,这样的话类也不必和文件同名
 * 可以创建内部类,和多个平行类
    * 如果有public类了, 则平行类不能用public, 因为一个.java只能有一个public
    * 非public类,只能被同包内的其他类引用,其他都不行,包括:
        * 同源中另一个包中的类
        * 同源中上一级的包中的类
        * 同源同包中下一级包的类
        * 不同源的类
 */