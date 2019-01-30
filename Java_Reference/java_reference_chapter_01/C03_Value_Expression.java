package java_reference_chapter_01;

// 1.3.1 - 1.3.4

public class C03_Value_Expression {
    public static void main(String[] args) {

        /* Writing Numbers
         * Ordinary integers in Java, for example, are all in the range −2^31 to 2^31−1, or about ±2 billion
         * To get somewhat larger integers, you must use a distinct type of value, known as a long, whose literals have a trailing ‘L’ on them. These give you a range of −2^63 to 2^63−1.
         * To go even further requires one of the built-in library classes (appropriately called java.math.BigInteger), for which there aren’t any built-in literals.
         */

        System.out.println(42); // Base 10
        System.out.println(052); // Base 8 (starts with 0)
        System.out.println(0x2a); // Base 16 (a=10, b=11, ..., f=15)
        // A. All print 42

        System.out.println(31.45);
        System.out.println(3.145e1); // en or En means ×10n
        System.out.println(3145e-2);
        // B. All print 31.45

        System.out.println(12345678901L);  // C. Prints 12345678901


        /* Arithmetic
         * When the two types are mixed, Java first converts the integer quantities to floating point.
         * Float division on zero is Infinity, not Error! Only trigger Error when in integers
         */
        System.out.println((3 + 7 + 10) * (1000 - 8) / 992 - 17);  // A Prints 3
        System.out.println(2.0 + 1.0 / 2 + 1.0 / 6 + 1.0 / 24 + 1.0 / 120);  // B Prints 2.7166666666666663
        System.out.println(2 + 1 / 2 + 1 / 6 + 1 / 24 + 1 / 120);   // C Prints 2
        System.out.println(1 - 2 - 2);        // D Prints -3
        System.out.println(117 % 20);         // E Prints 17
        System.out.println(1.0 / 0.0);        // F Prints Infinity
        System.out.println(2147483647 + 1);   // G Prints -2147483648
        System.out.println(0.0 / 0.0);        // H Prints NaN  (Not a Number)
        //System.out.println (1/0);            // I Halts the program with an exception

        System.out.println(1 / 2.0);  // >>> 0.5 if float is involved output complete float calculation
        System.out.println(1 / 2);    // >>> 0, as 1 // 2 in python

        System.out.println(Float.POSITIVE_INFINITY);  // >>>   Infinity
        System.out.println(Float.NEGATIVE_INFINITY);  // >>>  -Infinity


        /*
         * Comparison and Logical Operations
         * and and or are both short-circuits
         */
        System.out.println(true);
        System.out.println(3 < 4);
        System.out.println(3 <= 4);
        System.out.println(3 <= 3);
        System.out.println(4 > 3);
        System.out.println(4 >= 3);
        System.out.println(3 >= 3);
        System.out.println(4 != 3);
        System.out.println(3 == 3);
        // A. All print true

        System.out.println(false);
        System.out.println(3 < 3);
        System.out.println(3 != 3);
        // B. All print false

        System.out.println(3 < 4 && 3 < 5);    // and
        System.out.println(3 > 4 || 4 < 5);    // or,
        System.out.println(!(3 < 4 && 4 < 3));  // not
        // C. All print true

        System.out.println(3 < 4 || 1 / 0 == 0);       // (short-circuited, first true then true)
        System.out.println(3 > 4 && 1 / 0 == 0);       // (short-circuited, first false then false)
        // D. All print true


        /*
         * Strings
         * when one of its operands is a string, and the other isn’t, it converts the other operand to a string
         */
        System.out.println("Simple string.");
        System.out.println("");                //  An empty string
        System.out.println("Say \"Hello.\"");  //  \" is double quote
        System.out.println("Name:\tJohn");     //  \t is tab
        System.out.println("\\FOO\\BAR");      //  \\ is \
        System.out.println("One thing\nThe other thing");  // \n is next line same as python

        System.out.println("The value of" + " 17+25 is " + (17 + 25) + ".");
        // >>> The value of 17+25 is 42  // concatenation same as python

        // A few quick string methods
        System.out.println(("19-character string").length());  // >>> 19
        System.out.println(("abcd").charAt(3));                // >>> "d"

        System.out.println(("abcd").equals("abcd"));  // >>> true
        System.out.println(("abcd") == ("abcd"));      // >>> true
        // You might think that == would work, but that is not a reliable way to compare strings

        // slice
        System.out.println(("Hello, world!").substring(4, 9));  // >>> "o, wo" (not include "r" at 9)
        // 0123456789
        System.out.println(("Hello, world!").substring(7));     // >>> "world!"0  (from 7 to the end)
        // 0123456789


        // Additional:
        System.out.println("\nAddtional");
        System.out.println(Math.pow(2, 3));         // >>> 8.0   always float
        System.out.println(Math.pow(49, 0.5));      // >>> 5.0
        System.out.println((int) Math.pow(25, 0.5)); // >>> 5     convert to int

        System.out.println(Math.sqrt(9));  // >>> 3.0
        System.out.println(Math.pow(64, 1 / 3.0));  // >>> 3.9999996
        System.out.println((int) Math.pow(64, 1 / 3.0));  // >>> 3  !!! not right!!
        System.out.println(Math.round(Math.pow(64, 1 / 3.0)));  // >>> 4

        System.out.println(Math.round(2.001));  // >>> 2
        System.out.println(Math.round(2.997));  // >>> 3
        System.out.println(Math.round(1.499));  // >>> 1   // 四舍五入到整数
        System.out.println(Math.round(1.500));  // >>> 2
        System.out.println(Math.round(1.501));  // >>> 2

        // 小数的四舍五入
        double d = 0.6545;
        String s1 = String.format("%.2f", d);
        System.out.println(s1);  // >>> 0.65
        String s2 = String.format("%.3f", d);
        System.out.println(s2);  // >>> 0.655
        System.out.println(s2.getClass().getName());  // >>> java.lang.String

        /*
         * double 和 float 的区别是double精度高，有效数字16位，float精度7位。
         * 但double消耗内存是float的两倍，double的运算速度比float慢得多
         * java语言中数学函数名称double 和 float不同，不要写错
         * 能用单精度时不要用双精度
         */

        // float f0 = 1.0;  报错
        // 或者float f0 = (float)1.0
        float f1 = 1.0f;  //有小数点的话，必须要加f或者F
        float f2 = 1.0F;  //有小数点的话，必须要加f或者F,  1.0f后面的f只是为了区别double，并不代表任何数字上的意义

        float f3 = 1;
        System.out.println(f3);  // >>> 1.0  展示还是带小数点

        double d0 = 1.0;  // 不一定要加f  //java中默认声明的小数是double类型的，如double d=4.0
        double d1 = 1.0f;
        double d2 = 1.0F;
        System.out.println(d0 == d1);  // >>> true
        System.out.println(d1 == d2);  // >>> true
        double d3 = 1;
        System.out.println(d3);  // >>> 1.0  展示还是带小数点

        System.out.println(f1 == d1);  // >>> true  值是相同就行,虽然类型不同


        /*
         * char表示字符，定义时用单引号，只能存储一个字符，如char c='x';而String表示字符串，定义时用双引号，可以存储一个或多个字符，如String name="tom";
         * char是基本数据类型，而String 是一个类，具有面向对象的特征，可以调用方法，如name.length()获取字符串的长度。
         */
        char chr = 'x';
        String str = "YY";
        System.out.print(chr + str);  // >>> xYY   char + String would work
    }
}





