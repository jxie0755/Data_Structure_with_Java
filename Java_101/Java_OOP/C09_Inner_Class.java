package Java_OOP;

public class C09_Inner_Class {

    /*
     * 内部类
     * Java中还有一种内部类技术, 简单说就是在一个类的内部定义一个类。
     * 内部类看起来很简单, 但是当你深入其中, 你会发现它是极其复杂的。
     * 事实上Java应用程序开发过程中内部类使用的地方不是很多，一般在图形用户界面开发中用于事件处理
         * Java语言中允许在一个类(或方法、 代码块) 的内部定义另一个类， 后者称为“内部类”(Inner Classes),
         * 也称为“嵌套类”(Nested Classes)
         * 封装它的类称为“外部类”
         * 内部类与外部类之间存在逻辑上的隶属关系, 内部类一般只用在封装它的外部类或代码块中使用
         * 内部类的作用
            * 封装.             将不想公开的实现细节封装到一个内部类中, 内部类可以声明为私有的, 只能在所在外部类中访问
            * 提供命名空间.      静态内部类和外部类能够提供有别于包的命名空间
            * 便于访问外部类成员. 内部类能够很方便访问所在外部类的成员, 包括私有成员也能访问。

        * 内部类分类
            * 有名内部类
                * 局部内部类
                    * 局部内部类就是在方法体或代码块中定义的内部类, 局部内部类的作用域仅限于方法体或代码块中。
                    * 局部内部类访问级别只能是默认的, 不能是公有的, 私有的和保护的访问级别，
                        * 局部内部类也不能是静态， 即不能使用static修饰。
                        * 局部内部类可以访问外部类所有成员

                * 成员内部类  -- 成员内部类类似于外部类的成员变量， 在外边类的内部， 且方法体和代码块之外定义的内部类
                    * 实例成员内部类  -- 可以访问外部类的各种成员
                    * 静态成员内部类  -- 只能访问外部类的静态成员(方法/属性)

            * 匿名内部类
     */

}



class Outer1 {

    private String x = "OUT";  // Outer1变量
    private static String y = "OUT y";  // Outer1变量y

    void foo() { // Outer1 方法
        System.out.println("foooo");
    }

    static void bar() {
        System.out.println("barrrr");
    }

    // 测试调用内部类
    void test() {
        Inner inner = new Inner();  // 通过外部类方法创建内部类实例
        inner.display();
    }

    // 实例成员内部类
    class Inner {
        private String x = "Inner"; // Inner变量

        void display() { // Inner方法
            Outer1.this.foo();
            Outer1.bar();
            // 在内部类中this是引用当前内部类对象， 见代码第⑤行。 而要引用外部类对象需要使用“外部类名.this
            System.out.println(Outer1.this.x + " " + Outer1.y);  // 如果命名不冲突,可以省略Outer1.this
            System.out.println(this.x);
            System.out.println(x);

        }
    }

    // 测试
    public static void main(String[] args) {

        // 通过外部类实例使用方法来创造内部类实例, 然后访问内部类方法
        Outer1 out1 = new Outer1();
        out1.test();
        // >>>
        // foooo
        // barrrr
        // OUT OUT y
        // Inner
        // Inner

        // 通过外部类实例通过new创建内部类实例, 然后用内部类实例访问内部类方法
        Outer1.Inner inn1 = out1.new Inner();
        inn1.display();
        // >>>
        // foooo
        // barrrr
        // OUT OUT y
        // Inner
        // Inner

        System.out.println(inn1.getClass()); // >>> class Java_OOP.Outer1$Inner
        // 注意这里不会给出Outer1:
        System.out.println(inn1.getClass().getSuperclass());  // >>> class java.lang.Object // 内部类不是继承关系
    }
}



class Outer2 {

    private String x = "OUT";  // Outer2变量
    private static String staticX = "static OUT"; //  Outer2静态变量

    void foo() {
        System.out.println("foooo");
    }

    static void bar() {
        System.out.println("barrrr");
    }

    // 静态成员内部类
    static class Inner {

        void onClick() {
            System.out.println(Outer2.staticX);   // >>> static OUT
            Outer2.bar();                         // >>> barrrr
            // System.out.println(Outer2.this.x)  //不能访问外部类的非静态成员
            // Outer2.foo();                      //不能访问外部类的非静态方法
        }
    }

    public static void main(String[] args) {
        Outer2.Inner inn2 = new Outer2.Inner(); // 在声明静态内部时采用“内部类.静态内部类
        inn2.onClick();  // >>> static OUT

        System.out.println(inn2.getClass()); // >>> class Java_OOP.Outer2$Inner
        System.out.println(inn2.getClass().getSuperclass()); // >>> class java.lang.Object // 内部类不是继承关系
    }
}



class Outer3 {

    private String x = "OUT";  // Outer2变量
    private static String staticX = "static OUT"; //  Outer2静态变量

    void shoot() {
        System.out.println("SHOOT!");
    }

    void foo(int x, int y) {
        int z = 100;

        // 局部内部类
        class Inner {
            void display() {
                int summ = x + y + z;
                Outer3.this.shoot();
                System.out.println(Outer3.this.x);
                System.out.println(Outer3.staticX);
                System.out.println(summ);
            }
        }

        Inner inn3 = new Inner();
        inn3.display();
    }

    static void bar(int x, int y) {

        int z = 100;

        // 局部内部类(静态方法内)  // 只能访问外部类静态成员
        class Inner {  // 可以重名, 因为它被局限在一个方法内部了
            void display() {
                int summ = x + y + z;
                // Outer3.this.shoot();
                // System.out.println(Outer3.this.x);
                System.out.println(Outer3.staticX);
                System.out.println(summ);
            }
        }

        Inner inn3 = new Inner();
        inn3.display();
        // new Inner().display();
        // 实例化Inner对象后马上调用它的方法， 没有为Inner对象分配一个引用变量名，
        // 这种写法称为“匿名对象”。 匿名对象适合只运行一次情况下。
        // 匿名对象写法使代码变得简洁， 但是给初学者阅读代码带来了难度
    }


    public static void main(String[] args) {
        Outer3 out3 = new Outer3();
        out3.foo(1, 2);
        // >>>
        // SHOOT!
        // OUT
        // static OUT
        // 103

        System.out.println();
        Outer3.bar(1, 2);
        // >>>
        // static OUT
        // 103
    }
}