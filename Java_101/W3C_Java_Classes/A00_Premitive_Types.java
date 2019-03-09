package W3C_Java_Classes;

public class A00_Premitive_Types {

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

    // 除此之外其他全是reference types (引用类型) 见 A00_Reference_Types

    public static void main(String[] args) {

        // 数值类型:

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

        // 指数表示
        // 进行数学计算时往往会用到指数表示的数值。 如果采用十进制表示指数， 需要使用大写或小写的e表示幂， e2表示10^2
        double myMoney = 3.36e2;
        double interestRate = 1.56e-2;



        // 字符类型:

        // char 基本类型：char 二进制位数, 包装类：java.lang.Character
        // char数据类型可以储存任何字符
        System.out.println(Character.SIZE);  // >>> 16
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println((int)Character.MIN_VALUE); // >>> 0
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println((int)Character.MAX_VALUE); // >>> 65535 (2^16-1)

        // Java中的字符常量必须用单引号括起来的单个字符
        char ch1 = 'A';
        // 可用十六进制（无符号的） 编码形式表示, 形式是"\"un， 其中n为16位十六进制数
        char ch2 = '\u0041';
        char ch3 = '花';

        // 字符类型也属于是数值类型， 可以与int等数值类型进行数学计算或进行转换。 这是因为字符类型在计算机中保存的是Unicode编码，
        // https://zh.wikipedia.org/wiki/Unicode
        // 双字节Unicode的存储范围在\u0000~\uFFFF， 所以char类型取值范围0~216 -1


        // Premitive types conversion
        /*
         * 基本数据类型中数值类型之间可以互相转换
         * 布尔类型不能与它们之间进行转换。
         * 本节只讨论数值类型的互相转换
         * 自动类型转换就是需要类型之间转换是自动的， 不需要采取其他手段
         * 总的原则是小范围数据类型可以自动转换为大范围数据类型
            * byte
            * short
            * int      <---> *char*
            * long
            * float
            * double

        * *char*类型比较特殊， char自动转换为int、 long、 float和double，
        * 但byte和short不能自动转换为char， 而且char也不能自动转换为byte或short
         */

        // 自动转换:
        // 声明整数变量
        int intNum1;
        int intNum2;
        int intNum3 = 10;

        byte byteNum = 16;
        short shortNum = 160;
        long longNum;
        // byte类型转换为int类型

        intNum1 = byteNum;    // 16
        intNum2 = shortNum;   // 160
        longNum = intNum3;    // 10     // long范围更大, 大的包容小的

        // 声明char变量
        int intNum4;
        int intNumA;
        char charNum1 = '花';
        char charNum2 = 'A';
        // char类型转换为int类型
        intNum4 = charNum1;   // 33457  // '花' unicode to ASCII: '&#33457;'
        intNumA = (int) charNum2;  // >>> 65 // 根据ascii table第65个字符是A

        // 声明浮点变量
        // long类型转换为float类型
        int intNum5 = 5;
        float floatNum = longNum;
        // float类型转换为double类型
        double doubleNum = floatNum;
        //表达式计算后类型是double
        double result = floatNum * intNum5 + doubleNum / shortNum;

        // 强制转换
        // 强制类型转换主要用于大宽度类型转换为小宽度类型情况， 如把int转换为byte
        int intNum6;
        long longNum2 = 1600L;
        // intNum6 = longNum2;   // 不允许,因为int范围比long小
        intNum6 = (int) longNum2;  // 1600 但是注意不要溢出

        // 若是超出范围强制转换怎么办?
        // 是否类似Number中的xxxValue()方法???
        // 是否 int 129 转换成 byte会变成 -127?  (127:127, 128:-128, 129:-127, cycle back)
        int intNum7 = 129;
        byte byteNumX = (byte) intNum7;  // -127   // 与包装类xxxValue()相同逻辑!

        // 浮点数强制转换精度丢失?
        //int型变量
        int intNum8 = 10;
        float floatNum1 = intNum8 / 3;   // 3.0  // 丢失精度 (两int相除只取int结果)
        //把int变量i强制转换为float
        // 为了防止两个整数进行除法等运算导致小数位被截掉问题， 可以先将其中一个操作数强制类型转换为float, 这样结果必然只能是浮点数
        float floatNum2  = (float) intNum8 / 3; // 3.33333


        // boolean 数据类型表示一位的信息
        // 这种类型只作为一种标志来记录true/false情况
        // 而在Java中的布尔类型取值不能用1和0替代， 也不属于数值类型， 不能与int等数值类型之间进行数学计算或类型转化

        // boolean赋值只能是true和false, 默认值是false
        // boolean is_bool = "A";       不允许
        // boolean is_bool2 = "true";   不允许
        boolean is_bool = true;

        // 创建一个boolean数字,长度为3, 这样自动填充了三个false
        boolean[] boo = new boolean[3];
        System.out.println(boo[0] + " " + boo[1] + " " + boo[2]); // >>> false false false

    }
}



