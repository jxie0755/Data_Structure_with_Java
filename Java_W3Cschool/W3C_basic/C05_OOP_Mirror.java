package W3C_basic;

// 提供一个包内平行类环境, 测试修饰符public, private, default, protected

public class C05_OOP_Mirror {

    public static void main(String[] args) {

        // Test public, default and private
        C05_OOP_Public_A A = new C05_OOP_Public_A();
        // C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类不能被任何访问
        C05_OOP_Not_Public_C C = new C05_OOP_Not_Public_C();  // 只有同包类的类可以

        A.pub_test();    // public任何地方都可以
        A.def_test();    // default同包可行
        // A.pri_test();  private的方法和变量只能本类中用, 同包类都不行
        A.prot_test();  // 同包内, 不管是不是继承关系都可以使用protected方法和变量
        // 变量和方法同理, 就不再重复测试了



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



        // Test 同包子类环境
        C05_OOP_Sub Sub_In = new C05_OOP_Sub();
        Sub_In.pub_test();
        Sub_In.def_test();
        // Sub_In.pri_test();
        Sub_In.prot_test();
    }
}


// 提供一个包内子类环境, 测试修饰符public, private, default, protected
class C05_OOP_Sub extends C05_OOP_Public_A {   // 继承Public_A

    public static void main(String[] args) {

        // Test 同包子类环境 (子类实例, 由于同包, 只有private不行,其他都行)
        C05_OOP_Sub Sub_In = new C05_OOP_Sub();
        Sub_In.pub_test();
        Sub_In.def_test();
        // Sub_In.pri_test();
        Sub_In.prot_test();


        //但是如果在main建立一个父类实例 (由于同包, 只有private不行,其他都行)
        C05_OOP_Public_A A_special = new C05_OOP_Public_A();
        A_special.pub_test();
        A_special.def_test();
        // A_special.pri_test();
        A_special.prot_test();    // 在包外子类的实例中就可以访问protected
    }
}
