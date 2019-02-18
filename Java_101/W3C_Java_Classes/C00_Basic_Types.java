package W3C_Java_Classes;

public class C00_Basic_Types {
    public static void main(String[] args) {
        // byte 基本类型：byte 二进制位数, 包装类：java.lang.Byte
        // byte类型用在大型数组中节约空间，主要代替整数，因为byte变量占用的空间只有int类型的四分之一. 默认值是0
        System.out.println(Byte.SIZE);        // >>> 8
        System.out.println(Byte.MIN_VALUE);    // >>> -128   (二进制数: -1后面7个0)
        System.out.println(Byte.MAX_VALUE);    // >>> 127    (二进制数: 7个1)
        byte x1 = 127;    // 给10进制数
        System.out.println();

        // short 基本类型：short 二进制位数, 包装类：java.lang.Short
        // short数据类型也可以像byte那样节省空间。一个short变量是int型变量所占空间的二分之一, 默认值是0
        System.out.println(Short.SIZE);      // >>> 16
        System.out.println(Short.MIN_VALUE);  // >>> -32768  (二进制数: -1后面15个0)
        System.out.println(Short.MAX_VALUE);  // >>> 32767   (二进制数: 15个1)
        short x2 = 32767;  // 给10进制数
        System.out.println();

        // int 基本类型：int 二进制位数, 包装类：java.lang.Integer
        // 一般地整型变量默认为int类型, 默认值是0 (也就是直接声明, 例如 1 是int类型而不是byte,short或者long)
        System.out.println(Integer.SIZE);          // >>> 32
        System.out.println(Integer.MIN_VALUE);  // >>> -2147483648  (-1后面31个0)
        System.out.println(Integer.MAX_VALUE);  // >>> 2147483647   (31个1)
        System.out.println();

        // long 基本类型：long 二进制位数, 包装类：java.lang.Long
        // long 这种类型主要使用在需要比较大整数的系统上, 默认值是0L
        System.out.println(Long.SIZE);       // >>> 64
        System.out.println(Long.MIN_VALUE);   // >>> -9223372036854775808   (-1后面63个0)
        System.out.println(Long.MAX_VALUE);   // >>> 9223372036854775807    (63个1)
        System.out.println();

        // float 基本类型：float 二进制位数, 包装类：java.lang.Float
        // float在储存大型浮点数组的时候可节省内存空间, 默认值是0.0f
        // 浮点数不能用来表示精确的值，如货币
        System.out.println(Float.SIZE);     // >>> 32
        System.out.println(Float.MIN_VALUE);  // >>> 1.4E-45
        System.out.println(Float.MAX_VALUE);  // >>> 3.4028235E38
        System.out.println();

        // double 基本类型：double 二进制位数, 包装类：java.lang.Double
        // 浮点数的默认类型为double类型, 默认值是0.0d (也就是直接声明,例如1.234是double而不是float).
        // double类型同样不能表示精确的值，如货币
        System.out.println(Double.SIZE);      // >>> 64
        System.out.println(Double.MIN_VALUE);  // >>> 4.9E-324
        System.out.println(Double.MAX_VALUE);  // >>> 1.7976931348623157E308
        System.out.println();


        // 其他进制数字表示方法
        /*
         * 如果为一个整数变量赋值， 使用二进制数、 八进制数和十六进制数表示， 它们的表示方式分别如下：
             * 二进制数： 以 0b 或0B为前缀， 注意0是阿拉伯数字， 不要误认为是英文字母o。
             * 八进制数： 以0为前缀， 注意0是阿拉伯数字。
             * 十六进制数： 以 0x或0X为前缀， 注意0是阿拉伯数字
         */
        int decimalInt = 28;

        int binaryInt1 = 0b11100;
        int binaryInt2 = 0B11100;

        int octalInt = 034;

        int hexadecimalInt1 = 0x1C;
        int hexadecimalInt2 = 0X1C;


        // char 基本类型：char 二进制位数, 包装类：java.lang.Character
        // char数据类型可以储存任何字符
        System.out.println(Character.SIZE);  // >>> 16
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println((int)Character.MIN_VALUE); // >>> 0
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println((int)Character.MAX_VALUE); // >>> 65535 (2^16-1)

        // boolean 数据类型表示一位的信息
        // 这种类型只作为一种标志来记录true/false情况
        // 默认值是false
        boolean[] boo = new boolean[3];
        System.out.println(boo[0] + " " + boo[1] + " " + boo[2]); // >>> false false false

        // Java常量声明
        final double PI = 3.1415927;
        byte b1 = 68;
        char c1 = 'A';

        //byte、int、long、和short都可以用十进制、16进制以及8进制的方式来表示。
        // 当使用常量的时候，前缀0表明是8进制，而前缀0x代表16进制。例如：
        int decimal = 100;
        int octal = 0144;
        int hexa =  0x64;

        // 字符串常量和字符常量都可以包含任何Unicode字符
        char c2 = '\u0041';
        System.out.println(c2); // >>> A
        String S1 = "\u0042";
        System.out.println(S1); // >>> B
    }
}


/*
 * Java 基本数据类型
 * 变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。
 * 内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。
 * 因此，通过定义不同类型的变量，可以在内存中储存整数、小数或者字符。
 * Java的两大数据类型：
    * 内置数据类型
    * 引用数据类型
        * 引用类型变量由类的构造函数创建，可以使用它们访问所引用的对象。这些变量在声明时被指定为一个特定的类型，比如Employee、Pubby等
        * 变量一旦声明后，类型就不能被改变了。
        * 对象、数组都是引用数据类型。
        * 所有引用类型的默认值都是null。
        * 一个引用变量可以用来引用与任何与之兼容的类型。例子：Animal animal = new Animal(“giraffe”)。
 */
