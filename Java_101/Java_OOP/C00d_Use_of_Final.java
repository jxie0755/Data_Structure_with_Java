package Java_OOP;

public class C00d_Use_of_Final {

    /*
     * final
     * final修饰的变量即成为常量， 只能赋值一次， 但是final所修饰局部变量和成员变量有所不同
     * final修饰的局部变量必须使用之前被赋值一次才能使用
     * final修饰的成员变量在声明时没有赋值的叫“空白final变量”
     * 空白final变量必须在构造方法或静态代码块中初始化。
     * final修饰的类不能被继承。
     * 有时出于设计安全的目的， 不想让自己编写的类被别人继承， 这时可以使用final关键字修饰父类
     * final修饰的方法不能被子类覆盖。
     * 有时也是出于设计安全的目的， 父类中的方法不想被别人覆盖， 这是可以使用final关键字修饰父类中方法
     */

}


class FinalVariable {

    // final修饰变量

    void doSomething() {

        // 局部常量
        // 没有在声明的同时赋值
        final int e;
        // 只能赋值一次
        e = 100;
        System.out.println(e);
        // 声明的同时赋值
        final int f = 200;  //  其实局部常量最好在声明的同时初始化
    }

    // 成员常量 (实例常量)
    final int a = 5; // 直接赋值
    final int b; // 空白final变量  // 需要在构造方法中初始化

    //静态常量
    final static int c = 12;// 直接赋值 ⑥
    final static int d; // 空白final变量 // 需要在静态模块中初始化

    // 静态代码块
    static {
        // 初始化静态变量
        d = 32;   // 只能赋值一次
    } // 构造方法

    FinalVariable() {
        // 初始化实例变量
        b = 3;   // 只能赋值一次
    }
}


final class FinalClass {
    // final修饰类
}

// class SubFinalClass extends FinalClass {
//     //编译错误
// }


class SuperClass {
    final void doSomeThing() {
        System.out.println("WTF?");
    }
}

class SubSuperClass extends SuperClass {
    // @Override
    // void doSomeThing() {
    //     System.out.println("What's up?");  // 编译错误
    // }
}
