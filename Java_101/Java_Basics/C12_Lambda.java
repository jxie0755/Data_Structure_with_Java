package Java_Basics;

public class C12_Lambda {

    /*
     * Java 8之后推出的Lambda表达式开启了Java语言支持函数式编程 (Functional Programming) 新时代
     * Lambda表达式, 也称为闭包Closure
     * 现在很多语言都支持Lambda表达式，如C++、C#、Swift、Objective-C和JavaScript等
     * 为什么Lambda表达式这怎么受欢迎，这是因为Lambda表达式是实现支持函数式编程技术基础
        * 与其他语言相比Java语言的Lambda表达式有着明显的区别
     */


    // lambda表达式标准形式:
    //           (参数列表) -> {
    //              Lambda表达式体
    //           }

    /*
     * 函数式接口
         * Lambda表达式实现的接口不是普通的接口， 称为是函数式接口
            * 这种接口只能有一个方法。
            * 如果接口中声明多个抽象方法, 那么Lambda表达式会发生编译错误
         * 为了防止在函数式接口中声明多个抽象方法. Java 8提供了一个声明函数式接口注解@FunctionalInterface
         * Lambda表达式本身也提供了多种简化形式
            * 这些简化形式虽然简化了代码， 但客观上使得代码可读性变差
     */

    /*
     * Lambda表达式用于一个方法的参数
        * 这需要声明参数的类型声明为函数式接口类型
     * Lambda表达式可以访问所在外层作用域内定义的变量成员变量, 局部变量
        *  实例成员变量和静态成员变量
        *  在Lambda表达式中可以访问这些成员变量， 此时的Lambda表达式与普通方法一样， 可以读取成员变量， 也可以修改成员变量
     * Lambda表达式可以捕获所在外层作用域内定义的变量
     */

}


interface Calculable {

    /*
     * 假设有这样的一个需求:
     * 设计一个通用方法, 能够实现两个数值的加法和减法运算。
     * Java中方法不能单独存在, 必须定义在类或接口中
     * 考虑是一个通用方法, 可以设计一个数值计算接口, 其中定义该通用方法
     */

    int calculateInt(int a, int b);


    // 创造一个静态方法, 根据参数的不同, 重写calculateInt方法(通过匿名内部类类)
    static Calculable calculate(char opr) {

        // 这里只声明, 不能实例化,一旦实例化就必须创造内部类
        Calculable result;

        // 根据条件来实例化, 这样可以有不同的匿名类
        if (opr == '+') {
            result = new Calculable() { // 匿名内部类实现Calculable接口
                // 实现加法运算
                @Override
                public int calculateInt(int a, int b) {
                    return a + b;
                }
            };
        } else {
            result = new Calculable() {  // 匿名内部类实现Calculable接口
                // 实现减法运算
                @Override
                public int calculateInt(int a, int b) {
                    return a - b;
                }
            };
        }
        return result;
    }


    // 测试
    public static void main(String[] args) {

        System.out.println(Calculable.calculate('+').calculateInt(1, 2));
        // >>> 3
        System.out.println(Calculable.calculate('-').calculateInt(4, 1));
        // >>> 3
    }
}


@FunctionalInterface
interface lamCalculable {

    // 这里必须是接口,不能是抽象类或者实体类, 可以通过批注确保

    int calculateInt(int a, int b);
    // int calculateInt2(int a, int b); // 有且只能有一个抽象方法

    default void foo() { }  // 默认方法不被限制
    static void bar() {}    // 静态方法不被限制


    //以上匿名内部类的方法显得很臃肿, 使用lambda可以简化
    static lamCalculable lambcalculate (char opr){
        lamCalculable result;
        if (opr == '+') {
            result = (int a, int b) -> {return a + b;};  // Lambda表达式实现Calculable接口
            // 它还是需要找到一个方法对应int a和b (所以前面的calculateInt不能去掉)
            // 简化书写:
            // result = (a, b) -> {return a + b;};   // 省略参数类型
            // result = a -> a*a*a                   // 若只有一个参数,可以省略掉小括号
            // result = (int a, int b) -> a + b;     // 省略大括号和return


        } else {
            result = (int a, int b) -> a - b;  // Lambda表达式实现Calculable接口
        }
        return result;
    }
}



// Lambda接口作为一个参数用于方法
@FunctionalInterface
interface lamCalculable2 {
    // 快速声明一个lambda接口和一个抽象方法
    int lamCalInt(int a, int b);
}


class HelloLambda {

    // 在一个类中的方法使用Lambda接口

     // 使用函数式接口实例为参数
    public static void display(lamCalculable2 calc, int n1, int n2) {
        System.out.println(calc.lamCalInt(n1, n2)); // 使用lambda接口中的方法
    }

    // 或者用已有的定义好方法的接口, 例如lamCalculable中的方法
    public static void display2(char c, int n1, int n2) {
        System.out.println(lamCalculable.lambcalculate(c).calculateInt(n1, n2));
    }

    public static void main(String[] args) {

        // 在一个全新的接口,使用时临时制定lambda函数的方法
        display((a, b) -> a * b, 10, 5); // >>> 50
                 // 此处声明参数类型为函数接口

        display2('+', 10, 5); // >>>  15
    }
}



// Lambda接口访问成员变量
class LambdaDemo {
    // 实例成员变量
    private int value = 10;
    // 静态成员变量
    private static int staticValue = 5;

    // 静态方法， 进行加法运算
    public static lamCalculable2 add() {
        lamCalculable2 func = (int a, int b) -> {
            // 访问静态成员变量， 不能访问实例成员变量
            LambdaDemo.staticValue += 1 ;
            int c = a + b + LambdaDemo.staticValue; // this.value;
            return c;
        };  // 到这里是定义完了lambda函数的内容

        return func;
    }   // 完成add

    // 实例方法， 进行减法运算
    public lamCalculable2 sub() {
        lamCalculable2 func = (int a, int b) -> {
            // 访问静态成员变量和实例成员变量
            staticValue += 1;
            this.value++;
            int c = a - b - staticValue - this.value;
            return c;
        }; // 到这里是定义完了lambda函数的内容

        return func;
    }   // 完成sub

    public static void main(String[] args) {
        System.out.println(add().lamCalInt(1,2)); // >>> 9

        LambdaDemo ld = new LambdaDemo();
        System.out.println(ld.sub().lamCalInt(1,2)); // >>> -19  为(1-2-7-11)
    }
}