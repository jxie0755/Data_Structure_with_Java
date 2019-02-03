package W3C_basic;

// Learn public class in a .java file

public class C05_OOP_Public_A {

    class C05_OOP_Internal_B {

    }

    public void test() {
        C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类只能在外部类中non static时使用
    }

    public static void main(String[] args) {
        // C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类不能被static main访问, 甚至不能被造实例

    }
}

class C05_OOP_Not_Public_C {
    // default类，在同一包内可见，不使用任何修饰符。
}

/*
 * 这样会产生两个.class文件:
    * C05_OOP_Public_A.class
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

 * import 只能导入包所包含的类，而不能导入包。 为方便起见，我们一般不导入单独的类，而是导入包下所有的类，例如 import java.util.*;。
 */