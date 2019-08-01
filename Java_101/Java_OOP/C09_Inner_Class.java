package Java_OOP;

public class C09_Inner_Class {

    /*
     * 内部类
     * Java中还有一种内部类技术, 简单说就是在一个类的内部定义一个类。
     * 内部类看起来很简单, 但是当你深入其中, 你会发现它是极其复杂的。
     * 事实上Java应用程序开发过程中内部类使用的地方不是很多，一般在图形用户界面开发中用于事件处理
     * Java语言中允许在一个类(或方法、 代码块) 的内部定义另一个类， 后者称为“内部类”(Inner3 Classes),
     * 也称为“嵌套类”(Nested Classes)
     * 封装它的类称为“外部类”
     * 内部类与外部类之间存在逻辑上的隶属关系, 内部类一般只用在封装它的外部类或代码块中使用
     * 内部类的作用
     * 封装.             将不想公开的实现细节封装到一个内部类中, 内部类可以声明为私有的, 只能在所在外部类中访问
     * 提供命名空间.      静态内部类和外部类能够提供有别于包的命名空间
     * 便于访问外部类成员. 内部类能够很方便访问所在外部类的成员, 包括私有成员也能访问。


     * 内部类分类

     * 有名内部类
     * 成员内部类  -- 成员内部类类似于外部类的成员变量， 在外边类的内部， 且方法体和代码块之外定义的内部类相对独立
     * 实例成员内部类  -- 可以访问外部类的各种成员
     * 静态成员内部类  -- 只能访问外部类的静态成员(方法/属性)

     * 局部内部类
     * 局部内部类就是在方法体或代码块中定义的内部类, 局部内部类的作用域仅限于方法体或代码块中。
     * 局部内部类访问级别只能是默认的, 不能是公有的, 私有的和保护的访问级别，
     * 局部内部类也不能是静态， 即不能使用static修饰。
     * 局部内部类可以访问外部类所有成员
     * 局部内部类可以出现在静态和费静态方法中, 如果在静态方法中也同样只能访问外部类的静态成员!

     * 匿名内部类
     * 匿名内部类是没有名字的内部类, 本质上是没有名的局部内部类, 具有局部内部类所有特征。
     * 可以访问外部类所有成员。
     * 如果匿名内部类在方法中定义, 它所访问的参数需要声明为final
     * 匿名内部类通常用来实现接口或抽象类的， 很少覆盖具体类
     */

}


// 实例成员内部类实例:
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
        Inner1 inner = new Inner1();  // 通过外部类方法创建内部类实例
        inner.display();
    }

    // 建立实例成员内部类
    class Inner1 {
        private String x = "Inner3"; // Inner变量

        void display() { // Inner方法
            Outer1.this.foo();
            Outer1.bar();
            // 在内部类中this是引用当前内部类对象。 而要引用外部类对象需要使用“外部类名.this
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
        // Inner3
        // Inner3

        // 通过外部类实例通过new创建内部类实例, 然后用内部类实例访问内部类方法
        Inner1 inn1 = out1.new Inner1();
        inn1.display();
        // >>>
        // foooo
        // barrrr
        // OUT OUT y
        // Inner3
        // Inner3

        System.out.println(inn1.getClass()); // >>> class Java_OOP.Outer1$Inner3
        // 注意这里不会给出Outer1:
        System.out.println(inn1.getClass().getSuperclass());  // >>> class java.lang.Object // 内部类不是继承关系
    }
}


// 静态成员内部类实例:
class Outer2 {

    private String x = "OUT";  // Outer2变量
    private static String staticX = "static OUT"; //  Outer2静态变量

    void foo() {
        System.out.println("foooo");
    }

    static void bar() {
        System.out.println("barrrr");
    }

    // 建立静态成员内部类
    static class Inner2 {

        void onClick() {
            System.out.println(Outer2.staticX);   // >>> static OUT
            Outer2.bar();                         // >>> barrrr
            // System.out.println(Outer2.this.x)  //不能访问外部类的非静态成员
            // Outer2.foo();                      //不能访问外部类的非静态方法
        }
    }

    public static void main(String[] args) {
        Inner2 inn2 = new Inner2(); // 在声明静态内部时采用“内部类.静态内部类
        inn2.onClick();  // >>> static OUT

        System.out.println(inn2.getClass()); // >>> class Java_OOP.Outer2$Inner3
        System.out.println(inn2.getClass().getSuperclass()); // >>> class java.lang.Object // 内部类不是继承关系
    }
}


// 局部内部类实例
class Outer3 {

    private String x = "OUT";  // Outer2变量
    private static String staticX = "static OUT"; //  Outer2静态变量

    void shoot3() {
        System.out.println("SHOOT!");
    }

    void foo(int x, int y) {
        int z = 100;

        // 建立局部内部类
        class Inner3 {
            void display3() {
                int summ = x + y + z;
                Outer3.this.shoot3();
                System.out.println(Outer3.this.x);
                System.out.println(Outer3.staticX);
                System.out.println(summ);
            }
        }

        Inner3 inn3 = new Inner3();
        inn3.display3();
    }

    static void bar(int x, int y) {

        int z = 100;

        // 局部内部类(静态方法内)  // 只能访问外部类静态成员
        class Inner {  // 可以重名, 因为它被局限在一个方法内部了
            void display() {
                int summ = x + y + z;
                // Outer3.this.shoot3();
                // System.out.println(Outer3.this.x);
                System.out.println(Outer3.staticX);
                System.out.println(summ);
            }
        }

        Inner inn3 = new Inner();
        inn3.display();
        // new Inner3().display2();
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


interface Inner4 {   // 建立一个inner4 接口 // 也可以是class这里无所谓
    void display4();
}

// 匿名内部类实例
class Outer4 {

    private String x = "OUT";  // Outer2变量
    private static String staticX = "static OUT"; //  Outer2静态变量

    void shoot4(Inner4 inn) { // 参数为Inner4 实例, 但是需要一个子类实例化这个接口
        inn.display4();
    }


    // 运行时使用匿名内部类
    public static void main(String[] args) {

        Outer4 out4 = new Outer4();
        // 方法参数是匿名内部类
        out4.shoot4(new Inner4() {  // 实际上是new了一个Inner4实例在内部, 直接重写其display方法
            // 因为new出来没有给名字所以匿名
            // 匿名类可以直接实例化接口和抽象类,不必在乎接口和抽象类没有具体子类
            // 从这里就可以引出lambda函数的思想
            @Override
            public void display4() {
                System.out.println("来自匿内部类!!");
            }
        });
        // >>> 来自匿内部类!!
        // 使用时直接用这个实例, 所以这个out33的类名不再重要

        // 继承类的匿名内部类(具体类作为内部类)
        Outer3 out33 = new Outer3() {  // 实际上是重写了一个Outer3在这个类的内部
            @Override
            public void shoot3() {
                System.out.println("Shoot from Outer 4!!");
            }

            ;
        };
        out33.shoot3();
        // >>> Shoot from Outer 4!!
        // 使用时直接用这个实例, 所以这个out33的类名不再重要
        // 匿名内部类通常用来实现接口或抽象类的， 很少覆盖具体类
    }
}
