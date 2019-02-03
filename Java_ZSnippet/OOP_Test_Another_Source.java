import W3C_basic.C05_OOP_A;
import W3C_basic.C05_OOP_AA;

public class OOP_Test_Another_Source {
    public static void main(String[] args) {

        // Test public
        C05_OOP_A AAA = new C05_OOP_A();
        // C05_OOP_B BBB = new C05_OOP_B();  // 内部类不能被任何访问
        // C05_OOP_C CCC = new C05_OOP_C();  不是public所以不能被import

        // Test static // 只要是public都可以,不管是不是static
        C05_OOP_AA AAAA = new C05_OOP_AA();
        System.out.println(AAAA.fooo);
        System.out.println(AAAA.barrr);
        AAAA.foo();
        AAAA.fooo_barrr();
    }
}

