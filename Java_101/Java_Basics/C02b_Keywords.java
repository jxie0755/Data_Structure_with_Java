package Java_Basics;

class C02b_Keywords {
    // java一共有50个keyword

    /*
     * Premitive types
     * byte
     * boolean
     * char
     * double
     * float
     * int
     * long
     * short
     * Return value
     * void
     * return
     * Project structure
     * import
     * package
     * Class publicity
     * default
     * public
     * protected
     * private
     * Class inheritance relationships
     * impletments
     * extends
     * Class types
     * abstract
     * class
     * interface
     * enum      // 枚举类
     * Class methods
     * super
     * instanceof
     * new
     * this
     * Class variables
     * static
     * final   // 常量
     * Assertions
     * assert
     * Exceptions
     * try
     * catch
     * throw
     * throws
     * finally
     * Logic flow control
     * if
     * else
     * for
     * while
     * do
     * switch
     * case
     * break
     * continue
     * Others
     * native           // native是与C++联合开发的时候用的！java自己开发不用的！native是与C++联合开发的时候才使用的,java自己卡法不用
     * strictfp         // strict float point (精确浮点), 保证浮点运算精确, 不受不同平台干扰
     * synchronized     // 多线程编程时使用, 当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码
     * volatile         // 多线程编程时使用, volatile关键字用来修饰变量，作用是使得该变量在多个线程之间可见
     * transient        // 在序列化和反序列化的时候，可以进行关键字的屏蔽，只对需要进行持久化的字段进行序列化
     * Reserved Keywords
     * const
     * goto
     */


    // 注释用词
    /*
     * @author       // 说明类和接口的作者
     * @deprecated   // 说明类,接口,成员已被废弃
     * @param        // 介绍参数值
     * @return       // 介绍return值
     * @see          // 参考另一个主题的链接
     * @exception    // 说明方法会抛出的异常
     * @throws       // 同上
     * @versin       // 类或接口的版本
     */


    // 注释

    /*
     * This is
     * okay.
     */

    // And so
    // is this.

    /* Or you can
     * even do this. */
}


@Deprecated
        // 尽管标注了,但是还是会执行
class DontRun {
    public static void main(String[] args) {
        System.out.println("OKKKKK");
    }
}
