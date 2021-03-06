package Java_OOP;

// Learn public class in a .java file

public class C00_OOP_Member_Access {

    /*
     * 对于类(外部类), 只有public和default两个概念, 没有private类,因为类就是为了被人引用的才造出来的
     * 对于(内部类) 是可以private的, 甚至可以protected (因为内部类可以被看做一个方法)
     * 而对于方法和变量, 有分public, default, private, protected四种类型, 因为这些东西可以被:
     * public: 任何外部使用
     * default: 同包内使用
     * private: 仅本类使用
     * protected: 关键字所处理的是所谓“继承”的观念。
     * 对于同一包的其他类，protected＝默认，其它类可访问protected.
     * 对于 不同包的类，
     * 如果存在继承关系，则该子类的实例可以用父类的protected方法.
     * 但是子类中创造的父类实例,反而不能使用父类的protected方法。
     * 如果没有继承关系,  则不能访问类的protected属性。
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


    /*
     * final 修饰符，用来修饰类、方法和变量，final修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的
     * 被声明为final的变量必须在声明时给定初值（当然，空白final可以延迟到构造器中赋值），
     * 而且被修饰的变量不能修改值。当修饰类时，该类不能派生出子类
     * 修饰方法时，该方法不能被子类覆盖
     */

    final String fin;
    String notfin;

    public C00_OOP_Member_Access() {
        this.fin = "This is final";
        this.notfin = "This is not final";
    }

    class C05_OOP_Internal_B {

    }

    public void internal_test() {
        C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类只能在外部类中non static时使用
    }


    // public 方法
    public void pub_test() {
        System.out.println("This is pubilc method test");
    }

    // 缺省default方法
    void def_test() {
        System.out.println("This is default method test");
    }

    // private方法
    private void pri_test() {
        System.out.println("This is private method test");
    }

    // protected方法
    protected void prot_test() {
        System.out.println("This is protected method test");
    }

    // final方法
    final String fin_test() {
        return "This is final method test";
    }


    // main必须是public
    public static void main(String[] args) {
        // C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类不能被static main访问, 甚至不能被造实例

        // test final
        C00_OOP_Member_Access A_final = new C00_OOP_Member_Access();

        System.out.println(A_final.fin);  // >>> This is final
        // A_final.fin = "fin Changed";   // can't change final       (set方法同样也是不行)

        System.out.println(A_final.notfin);  // >>> This is not final
        A_final.notfin = "notfin Changed";
        System.out.println(A_final.notfin);        // >>> notfin Changed
    }
}


// default类
class C00_OOP_Not_Public_C {
    // default类，在同一包内可见，不使用任何修饰符。
}

// final类
final class C00_OOP_Not_Public_final_C {
    // class sub_final extends C00_OOP_Not_Public_final_C {} // final类不可继承
}


/*
 * 这样会产生两个.class文件:
 * C00_OOP_Member_Access.class
 * C05_OOP_Multi_C.class
 * B 没有被生成
 */
