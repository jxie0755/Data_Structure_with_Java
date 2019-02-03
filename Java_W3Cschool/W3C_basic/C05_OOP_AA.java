package W3C_basic;

// Learn Static

public class C05_OOP_AA {

    //变量
    public static String fooo = "fooo!!";  //变量必须为static才能在static main中运行
    public String barrr = "barrr!!";  //变量必须为static才能在static main中运行

    public static void foo() {   // 必须要static, 不然static main无法运行
        System.out.println("foo");
        System.out.println(fooo);
        // System.out.println(fooo);
    }

    public void fooo_barrr() {
        System.out.println(fooo);
        System.out.println(barrr);
        foo();
    }

    public static void main(String[] args) {
        System.out.println(fooo);       // 直接可以出!!!

        // System.out.println(barrr);       // not static 不能出
        C05_OOP_AA bar_out = new C05_OOP_AA();
        System.out.println(bar_out.barrr);  // 怎么办? 造一个实例就可以出

        foo();
        // fooo_barrr();                // not static
        bar_out.fooo_barrr();           // 怎么办? 造一个实例就可以出



    }

}



/*
 * 默认访问修饰符-不使用任何关键字
    * 使用默认访问修饰符声明的变量和方法，对同一个包内的类是可见的。
    * static修饰符，用来创建类方法和类变量。
    * 本类中:
        * static main 必须运行static的方法和变量
        * static 的方法 必须运行static的方法和变量
        * 非static的方法可以运行static或者非static的方法和变量
    * 其他类中:
        * 不管类在哪,只要是public类的public方法和public变量就可以被import但是:
            * static可以直接call类
            * 非static必须要建造一个实例才行
 */

/*
 * 精辟解析static
    * 当一个变量前面有了static这个修饰符，内存会为它分配唯一的一块存储空间。
    * 程序跑起来的时候，变量就存在在内存里了。
    * 谁要用它，就去访问一下它所在的内存。
    * 假如内存是澡堂子，static变量就像一坨肥皂，一整个澡堂子的人都共用之。。
    * 不管澡堂子里有没有人，肥皂总是在这里。
    * 编译器想拿出肥皂来玩一玩，直接吼出肥皂的名字就好了。
 * 非static
    * 如果这是一个非static的变量，则是对每个对象有一份存储空间。
    * 程序跑刚起来的时候，是没有这个变量的。
    * 相当于一个澡堂子里每进来一个人就发一坨肥皂。
    * 如果没有人，也就没有肥皂。
    * 编译器想要用肥皂来做点什么，必须先制造一个人进来。
 */