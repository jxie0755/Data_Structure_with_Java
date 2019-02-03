package W3C_basic;

// Learn static
public class C05_OOP_AA {

    //变量
    public static String fooo = "fooo!!";  //变量必须为static才能在static main中运行
    public String barrr = "barrr!!";  //变量必须为static才能在static main中运行

    public static void foo() {   // 必须要static, 不然static main无法运行
        System.out.println("foo");
        System.out.println(fooo);
        // System.out.println(barrr);
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
 * static
    * static修饰符，用来创建类方法和类变量。
    * 本质上static就是区分实例可用还是类可用
        * static就是实例+类均可用
        * 非static就是必须被实例用,不能被类用

    * 本类中:
        * static 的方法 必须运行static的方法和变量
            * (原因很简单, static说明它必须提前加载,所以它用的东西也都是可以提前被加载的,否则会引起冲突)
        * 非static的方法可以运行static或者非static的方法和变量
            * (因为它只能被实例所用,能不能提前加载就无所谓了)
    * 其他类中其实同理:
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
    * 不能以任何形式引用this, super  (实例才有的概念)
 * 非static
    * 如果这是一个非static的变量，则是对每个对象有一份存储空间。
    * 程序跑刚起来的时候，是没有这个变量的。
    * 相当于一个澡堂子里每进来一个人就发一坨肥皂。
    * 如果没有人，也就没有肥皂。
    * 编译器想要用肥皂来做点什么，必须先制造一个人进来。
 */