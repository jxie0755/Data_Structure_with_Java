package W3C_basic;

public class C05_OOP_Private {

    private String Priv = "This is static and private";
    String Def_NotPriv = "This is defualt and not private";        // 缺省就是default, 但是缺省不是static
    public String Pub_NotPriv = "This is public and not private";  // public声明就是彻底public

    public static void main(String[] args) {
        C05_OOP_Private AAA = new C05_OOP_Private();
        System.out.println(AAA.Priv);          // >>>  This is private                      // 本类中什么可以
        System.out.println(AAA.Def_NotPriv);   // >>>  This is defualt and not private
        System.out.println(AAA.Pub_NotPriv);   // >>>  This is public and not private
    }
}

/*
 * 私有的，以private修饰符指定，在同一类内可见
 * 使用默认访问修饰符声明的变量和方法，对同一个包内的类是可见的 (也就是什么都不写)。
    * 接口里的变量都隐式声明为public static final,而接口里的方法默认情况下访问权限为public。
 */