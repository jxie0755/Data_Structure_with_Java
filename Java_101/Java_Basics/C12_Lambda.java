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

        * 注意, 在使用函数式接口是,往往需要建立一个接口的实例, 但是接口不能被直接实例化? 为什么允许呢?
            * 所以其实lambda表达式可以被理解为这个接口的子类,相当于这个表达式implement了这个接口
     */

    /*
     * Lambda表达式用于一个方法的参数
        * 这需要声明参数的类型声明为函数式接口类型
     * Lambda表达式可以访问所在外层作用域内定义的变量成员变量, 局部变量
        *  实例成员变量和静态成员变量
        *  在Lambda表达式中可以访问这些成员变量， 此时的Lambda表达式与普通方法一样， 可以读取成员变量， 也可以修改成员变量
     * Lambda表达式可以捕获所在外层作用域内定义的变量
     */


    /*
     * Lambda表达式使用总结
     * lambda方法的好处就在于, 在不同的地方用不同的表达式相当于不同的函数,但是不需要单独建立一个函数的名字
     * 只要实现时,符合相同参数数目和类型的, 都可以归纳于这同一个lambda方法

        * 首先一定要建立一个函数式接口 ITF @FunctionalInterface
        * 然后在接口内声明一个lambda方法(抽象,只声明变量数目和类型)

            * 第一种方式A, 在接口内部创造一个static方法(lambda_implement), 把lambda方法实现了
                * 实现时在static方法内生成一个自身接口的实例insta
                * 然后把这个实例通过 insta = 表达式, 指向lambda方法
                * 最后返回这个实例
                    * 在别的地方使用时,直接调用这个接口的静态方法 ITF.lambda_implement.lambda(para1, para2,...)
                    * 这个方案的意义在于, lambda_implement可以根据不同条件, 让lambda方法运行不同的表达式, 达到一个自由的目的

            * 第二种方式B, 接口只负责声明, 然后在别的类中使用这个接口, 同时设计表达式(两种用法)

                * 用法1: 如果是在一个方法(metd)的参数中, 那么把参数设成ITF类的insta实例
                    * 方法定义中使用insta.lambda(para1, para2,...)
                        * 具体使用时, 才把参数替换成表达式 meth.(表达式, para1, para2)
                        * 这里para1, para2可以来自metd的其他参数
                        * 相当这个metd变成一个高阶函数: fn(lam, p1, p2) -> return lam(p1,p2)
                            * // 最优, 最自由, 具体用时才定义方法体, 符合使用匿名函数的初衷


                * 用法2: 如果是在定义一个方法metd时就设计好表达式, 使用时就直接用
                    * 在方法内部声明一个接口实例insta
                    * 然后insta = 表达式
                    * 然后meth直接返回这个insta
                        * 使用时调用lambda方法 insta.lambda(para1, para2,...)
                        * 这个方案的意义在于, 可以定义多个metd, 让它们的insta实现不同的表达式,实现自由的目的
     */


    /*
     * 方法引用
         * Java 8之后增加了双冒号“::”运算符， 该运算符用于“方法引用”
         * 注意不是调用方法
         * “方法引用”虽然没有直接使用Lambda表达式, 但也与Lambda表达式有关, 与函数式接口有关
     * 方法引用分为： 静态方法的方法引用和实例方法的方法引用
        * 类型名::静态方法 // 静态方法的方法引用
        * 实例名::实例方法 // 实例方法的方法引用
        * 被引用方法的参数列表和返回值类型， 必须与函数式接口方法参数列表和方法返回值类型一致

     * 使用方法
        * 首先一定要建立一个函数式接口 ITF @FunctionalInterface
        * 然后在接口内声明一个lambda方法(抽象,只声明变量数目和类型)   // 这里与之前Lambda用法相同

            * 在其他类C中, 直接写出不同的方法(metdA, metdB, metdC)
                * 这些方法有个共同点, 就是参数的数目和类型与lambda方法相同

            * 再写出另一个方法M
                * 把参数设成ITF类的insta实例
                * 其他的参数设为和lambda方法相同数目和类型!

            * 运行M时, 通过使用引用(X::metdA, p1, p2)
                * 如果metdA是静态就是C::metdA
                * 如果metdA不是静态就是C的实例ci::metdA
                * (而不是lambda表达式) 来调用A,B,C方法得到不同的结果:
                    * metdA(p1, p2)
                    * metdB(p1, p2)
                    * metdC(p1, p2)

            * 这个方式和B2的区别是, 这里先声明方法A,B,C,然后引用一个lambda函数取区分它们
            * B2则是没有事先准备好方法A,B,C而是在运行时就地写出方法A,B,C
            * 它的好处就是把现成的方法,能够作为一个参数用到别的方法中, 形成一个函数嵌套的现象, 实践了函数式编程的初衷
     */
}

// 没有lambda表达式的时候, java通过匿名内部类来实现这个效果
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

    int lambda(int a, int b);
    // int calculateInt2(int a, int b); // 有且只能有一个抽象方法

    default void foo() { }  // 默认方法不被限制
    static void bar() {}    // 静态方法不被限制


    //以上匿名内部类的方法显得很臃肿, 使用lambda可以简化
    static lamCalculable lamba_implement(char opr){
        lamCalculable insta;
        if (opr == '+') {
            insta = (int a, int b) -> {return a + b;};  // Lambda表达式实现Calculable接口
            // 它还是需要找到一个方法对应int a和b (所以前面的calculateInt不能去掉)
            // 简化书写:
            // insta = (a, b) -> {return a + b;};   // 省略参数类型
            // insta = a -> a*a*a                   // 若只有一个参数,可以省略掉小括号
            // insta = (int a, int b) -> a + b;     // 省略大括号和return


        } else {
            insta = (int a, int b) -> a - b;  // Lambda表达式实现Calculable接口
        }
        return insta; // 返回lambda接口对象,用于访问lamda函数
    }

}



// Lambda接口作为一个参数用于方法
@FunctionalInterface
interface lamCalculable2 {
    // 快速声明一个lambda接口和一个抽象方法
    int lambda2(int a, int b);
}


class HelloLambda {

    // 在一个类中的方法使用Lambda接口

    // 或者用已有的定义好方法的接口, 例如lamCalculable中的方法
    public static void display(char c, int n1, int n2) {
        System.out.println(lamCalculable.lamba_implement(c).lambda(n1, n2));
    }

    // 使用函数式接口实例为参数
    public static void display2(lamCalculable2 insta, int n1, int n2) {
        System.out.println(insta.lambda2(n1, n2)); // 使用lambda接口中的方法
    }


    public static void main(String[] args) {

        display('+', 10, 5); // >>>  15

        // 在一个全新的接口,使用时临时制定lambda函数的方法
        display2((a, b) -> a * b, 10, 5); // >>> 50
                 // 此处声明参数类型为函数接口
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
        lamCalculable2 insta = (int a, int b) -> {
            // 访问静态成员变量， 不能访问实例成员变量
            LambdaDemo.staticValue += 1 ;
            int c = a + b + LambdaDemo.staticValue; // this.value;
            return c;
        };  // 到这里是定义完了lambda函数的内容

        return insta;  // 返回lamcda接口对象,用于访问lamda接口中的函数
    }   // 完成add

    // 实例方法， 进行减法运算
    public lamCalculable2 sub() {
        lamCalculable2 insta = (int a, int b) -> {
            // 访问静态成员变量和实例成员变量
            staticValue += 1;
            this.value++;
            int c = a - b - staticValue - this.value;
            return c;
        }; // 到这里是定义完了lambda函数的内容

        return insta;  // 返回lamcda接口对象,用于访问lamda接口中的函数
    }   // 完成sub

    public static void main(String[] args) {
        System.out.println(add().lambda2(1,2)); // >>> 9

        LambdaDemo ld = new LambdaDemo();
        System.out.println(ld.sub().lambda2(1,2)); // >>> -19  为(1-2-7-11)
    }
}



// Lambda接口作为一个参数用于方法
@FunctionalInterface
interface lamCalculable3 {
    // 快速声明一个lambda接口和一个抽象方法
    int lambda3(int a, int b);
}


// 方法引用
class LambdaDemo2 {
    // 静态方法， 进行加法运算
    // 参数列表要与函数式接口方法calculateInt(int a, int b)兼容
    public static int add(int a, int b) { // 这里add方法参数的数目和类型必须和lambda3一致
        return a + b;
    }
    //实例方法，进行减法运算
    // 参数列表要与函数式接口方法calculateInt(int a, int b)兼容
    public int sub(int a, int b) {  // 这里sub方法参数的数目和类型必须和lambda3一致
        return a - b;
    }

    public static void display3(lamCalculable3 insta, int n1, int n2) {
                                // 使用接口实例作为参数
        System.out.println(insta.lambda3(n1, n2));
                            // 实例调用lambda方法
    }



    public static void main(String[] args) {

        // add 和 sub 这两个方法必须与函数式接口方法参数列表一致， 方法返回值类型也要保持一致
        display3(LambdaDemo2::add, 10, 5); // >>> 15
        LambdaDemo2 ld2 = new LambdaDemo2();
        display3(ld2::sub, 10, 5);         // >>> 5
        // 这里的好处就是一个Display方法, 可以运行显示两个函数的结果, 相当于display自由度很大
        // 可以让不同的方法在其中运行而不必重载
        // 从某种意义上说, 这是把add和sub转型成了lambda方法

        // 同样的display3, 用B2的方案,完全可以实现相同的效果, 所以看情况区分使用引用还是直接写lambda表达式
        display3((a, b) -> a + b, 10, 5); // >>> 15
        display3((a, b) -> a - b, 10, 5); // >>> 5
    }
}