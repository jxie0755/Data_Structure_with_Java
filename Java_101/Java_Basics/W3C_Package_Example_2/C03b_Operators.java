package Java_Basics.W3C_Package_Example_2;

public class C03b_Operators {
    public static void main(String[] args) {
        // 一元运算符
        int a = 12;
        System.out.println(-a);  // >>> -12

        int b = a++;  // 先把a赋值给b变量再加一， 即先赋值后++， 因此输出结果还是是12, 但a已经是13了
        System.out.println(b);  // a = 12, b = a, a = 12 + 1 >>> b = 12
        b = ++a;      // a已经是13了,先把a加一， 然后把a赋值给b变量， 即先++后赋值， 因此输出结果是14
        System.out.println(b);  // a = 13, b = a + 1 >>> b = 14

        int a2 = 12;
        int b2 = a2--;
        System.out.println(b2);  // >>> 12  (a = 11)
        b2 = --a2;
        System.out.println(b2);  // >>> 10 (a = 11, a -= 1, b = a)

        //

    }
}


