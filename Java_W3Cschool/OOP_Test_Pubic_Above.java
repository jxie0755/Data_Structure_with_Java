import W3C_basic.C05_OOP_A;
import W3C_basic.C05_OOP_AA;

public class OOP_Test_Pubic_Above {
    public static void main(String[] args) {

        // Test public
        C05_OOP_A AAA = new C05_OOP_A();
        // 05_OOP_B BBB = new C05_OOP_B();  // 内部类不能被任何访问
        // C05_OOP_C CCC = new C05_OOP_C();  // 不是public所以不能被import

        // Test static // 只要是public都可以
        C05_OOP_AA AAAA = new C05_OOP_AA();   // 真正原因是因为这里造了一个实例,非static的变量和方法必须被实例使用
        System.out.println(AAAA.fooo);
        System.out.println(AAAA.barrr);
        AAAA.foo();
        AAAA.fooo_barrr();
        // 直接从类出发:
        System.out.println(C05_OOP_AA.fooo);       // 由于fooo是static所以可以直接被call
        C05_OOP_AA.foo();                          // 同上
        // System.out.println(C05_OOP_AA.barrr);   // 由于barrr不是static所以不行
        // C05_OOP_AA.fooo_barrr();                // 同上
    }
}

