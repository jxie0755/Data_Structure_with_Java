package Java_OOP;

public class C00b_Constructor {
    /*
     * 学习private构造器的用法
        * 单例模式
        * 工具类Utils，里面全是静态方法和变量, 用于对其他类做编辑, 则没有必要实例化, 通过private来保护
            * 例如java.util.Collections,  java.util.Arrays等等
     */
}

class C5 {
    String name;
    private C5(String name) {  // 如果private构造器
        this.name = name;
    }

    public void show() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        C5 c = new C5("c1");
        c.show();
    }
}


// 整个类都不行
// class C6 extends C5{
//     String name;
//     int age;
//
//     // 这样是不行的
//     private C6 (String name, int age) {
//         this.name = name;
//         this.age = age;
//     }
//
//     public static void main(String[] args) {
//         // C5 c5b = new C5("c2");  // 不能被构造
//     }
// }
// https://stackoverflow.com/a/19680673/8435726
// Yes. If your only constructors are private, then you can't create a subclass of that class,
// as there would be no accessible constructors to chain to
// - leaving nested classes aside (where accessibility changes a little).



// 一个最简单的单例模式如下
class Singleton {

    /*
     * 单例模式
     * 如果你了解过设计模式，那你一定会知道单例模式，这是最初级的设计模式之一。
         * 类的内部包括一个类的实例，并且为static类型
         * 构造函数为私有
         * 通过提供一个获取实例的方法，比如getInstance，该方法也为static类型

     * 你也许会问，为什么要用单例模式呢？
        * 这是因为， 很多时候，我们只需要一个对象就可以了，不希望用户来构造对象，
        * 比如线程池，驱动，显示器等。如果把构造函数私有，那么很多程序都可以得到其实例，将会带来混乱
     */


    private static Singleton instance;

    private Singleton() {
        // .......//
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();  // 这样就限制了, 只能制造一个实例,不能同时存在两个
        return instance;
    }

}

class Singleton_visit {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}


// super constructor
class C7 {
    String name;
    public C7(String name) {
        this.name = name;
        System.out.println("!! " + name + " !!");
    }

    void foo(String s) {
        System.out.println(s + " <<<your grandfather");
    }

}


class C8 extends C7 {
    Integer innt;

    public C8(String name) {
        super(name);
    }

    public C8(String name, int x) {
        super(name + " " + x);        // 即使重载也必须先使用super
        this.name = name; // 然后再覆盖?
        this.innt = x;
    }

    void foo(String s) {
        super.foo(s + " <<<your father");  // super用于其他位置, 其实就是代表Parent
    }

}

class C9 extends C8 {

    public C9(String name) {
        super(name);
    }

    void foo(String s) {
        super.foo(s + " <<< yourself");
    }

    public static void main(String[] args) {

        C7 c77 = new C7("c777"); // >>>  !! c777 !!
        C8 c88 = new C8("c888"); // >>>  !! c888 !!
        C8 c888 = new C8("c8888", 10); // >>>  !! c8888 10 !!
        // System.out.println(c888.name); // >>>  c8888???>
        c77.foo("c77");   // >>>  c77 <<<your grandfather
        c88.foo("c88");   // >>>  c88 <<<your father <<<your grandfather
        C9 c99 = new C9("c999");
        c99.foo("c99"); // >>>  c99 <<< yourself our father <<<your grandfather  // 链式继承super方法
    }

}
