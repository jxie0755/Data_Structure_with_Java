import W3C_basic.C05_OOP_Public_A;
import W3C_basic.C05_OOP_Static;

// 提供一个包外环境, 测试修饰符public, private, default, protected

public class OOP_Test_Pubic_Out {

    public static void main(String[] args) {

        // Test public
        C05_OOP_Public_A A = new C05_OOP_Public_A();
        // C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类不能被任何访问
        // C05_OOP_Not_Public_C C = new C05_OOP_Not_Public_C();  // 不是public所以不能被import

        A.pub_test();    // public任何地方都可以
        // A.def_test();    // default不同包就不行行了
        // A.pri_test();  private的方法和变量只能本类中用, 同包类都不行
        // A.prot_test();  // 不同包内, 如果没有继承关系protected相当于private和public



        // Test static // 只要是public都可以
        C05_OOP_Static AA = new C05_OOP_Static();   // 真正原因是因为这里造了一个实例,非static的变量和方法必须被实例使用
        System.out.println(AA.fooo);
        System.out.println(AA.barrr);
        AA.foo();
        AA.fooo_barrr();
        // 直接从类出发:
        System.out.println(C05_OOP_Static.fooo);       // 由于fooo是static所以可以直接被call
        C05_OOP_Static.foo();                          // 同上
        // System.out.println(C05_OOP_Static.barrr);   // 由于barrr不是static所以不行
        // C05_OOP_Static.fooo_barrr();                // 同上



        // 注意, 这里和下面不同是因为这里并不是子类的main,
        // 而是包外非子类的main中建立了一个包外子类的实例, 这里的访问同样限制在public
        C05_OOP_Out_Sub Sub_Out = new C05_OOP_Out_Sub();
        Sub_Out.pub_test();
        // Sub_Out.def_test();
        // Sub_Out.pri_test();
        // Sub_Out.prot_test();
    }
}


// 提供一个包外子类环境, 测试修饰符public, private, default, protected
class C05_OOP_Out_Sub extends C05_OOP_Public_A {

    public static void main(String[] args) {

        // Test 不同包子类环境
        // 子类中建立一个子类的实例
        C05_OOP_Out_Sub Sub_Out = new C05_OOP_Out_Sub();
        Sub_Out.pub_test();
        // Sub_Out.def_test();
        // Sub_Out.pri_test();
        Sub_Out.prot_test();    // 在包外子类的实例中就可以访问protected


        //但是如果在main建立一个父类实例 (只能访问public)
        C05_OOP_Public_A A_special = new C05_OOP_Public_A();
        A_special.pub_test();
        // A_special.def_test();
        // A_special.pri_test();
        // A_special.prot_test();    // 在包外子类的实例中就可以访问protected
    }
}
