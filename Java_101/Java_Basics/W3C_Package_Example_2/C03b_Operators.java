package Java_Basics.W3C_Package_Example_2;

public class C03b_Operators {
    public static void main(String[] args) {
        // 一元运算符, 意思是只要一个参数
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

        // 二元运算符, 普通+-*/%之类,需要两个参数的, 这些运算符对数值类型数据都有效 (也就是除了boolean以外的基本类型)

        // int和char交互 (参见ascii table)
        char ch1 = '!';   // 33
        char ch2 = '#';   // 35
        int int_char = ch1 + ch2;  // 68
        char ch3 = (char) int_char;
        System.out.println(ch3);  // D

        // 关系运算符
        // ==, !=, >, <, >=, <=
        // 提示 ==和!=可以应用于基本数据类型和引用数据类型。
        // 当用于引用数据类型比较时， 比较的是两个引用是否指向同一个对象， 但在实际开发过程中多数情况下， 只是比较对象的内容是否相当， 不需要比较是否为同一个对象
        // 这样的话, 需要用equals这种方法来做比较,不要直接用==, 否则两个相同的量的引用类, 用==出来是不同的!
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);       // >>>  false
        System.out.println(s1.equals(s2));  // >>>  true
    }
}


