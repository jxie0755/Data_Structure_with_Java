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
        System.out.println(fooo);
        // System.out.println(barrr);   // not static
        foo();
        // fooo_barrr();                // not static
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
        * 不管类在哪,只要是public类的public方法和public变量就可以用(于那些类中的static main)
        * 跟static毫无关系
 */