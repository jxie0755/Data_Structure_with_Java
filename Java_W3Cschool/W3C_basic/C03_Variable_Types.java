package W3C_basic;

public class C03_Variable_Types {

    public static void pupAge() {
        int age = 0;
        age += 7;
        System.out.println(age);
    }

    public static void main(String[] args) {

        // 在Java语言中，所有的变量在使用前必须声明:
        // type identifier [ = value][, identifier [= value] ...] ;
        int a, b, c;         // 声明三个int型整数：a、b、c。
        int d = 3, e, f = 5; // 声明三个整数并赋予初值。
        byte z = 22;         // 声明并初始化z。
        double pi = 3.14159; // 声明了pi。
        char x = 'x';        // 变量x的值是字符'x'。

        pupAge(); // >>> 7
    }
}



/*
 * Java语言支持的变量类型

     * 局部变量
        * 局部变量声明在方法、构造方法或者语句块中
        * 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁
        * 访问修饰符不能用于局部变量
        * 局部变量只在声明它的方法、构造方法或者语句块中可见
        * 局部变量是在栈上分配的
        * 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。

     * 实例变量 - 见C03_Variable_Types_Employee


     * 类变量
 */