package Java_Classes;

class A01_Number {

    /*
     * Module java.base
     * Package java.lang
     * Class Number
     * Java Number类
     * 一般我们可以直接使用基本类型byte, int, long, short, double等等
     * 然而，在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情形。
     * 为了解决这个问题，Java语言为每一个内置数据类型提供了对应的包装类
     * 因此这些包装类型都是Number的子类
     * Byte
     * Integer
     * Double
     * Float
     * Short
     * Long
     * 这种由编译器特别支持的包装称为装箱，所以当内置数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类.
     * 相似的，编译器也可以把一个对象拆箱为内置类型
     * Number类属于java.lang包
     * 大数 (Number的两个子类)
     * BigInteger - 是不可变的任意精度的大整数
     * BigDecimal - 是不可变的任意精度的有符号十进制数
     */

    // https://docs.oracle.com/en/java/javase/11/
    // https://docs.oracle.com/en/java/javase/11/docs/api/index.html

    public static void main(String[] args) {

        // 演示装箱和拆包
        Integer x = 5; // box int to an Integer object
        x = x + 10;    // unboxes the Integer to a int
        // 当x被赋为整型值时，由于x是一个对象，所以编译器要对x进行装箱。
        // 然后，为了使x能进行加运算，所以要对x进行拆箱
    }
}


// Java Math类方法
class Number_zMethods {
    public static void main(String[] args) {
        // 构造方法
        Integer someInt = new Integer(80);
        // 通过字符串也可以:
        Double someDouble = new Double("80.0");


        // Number常用方法
        // 方法都只能用于Number类,不能用于基本类型

        // Number类自带的的Value方法
        Integer x1 = 1000;
        x1.byteValue(); // >>> -24

        // basically within -128 to 127, it return the same value
        // beyound the scope will extend additional -128 to 127 scope
        // 127 to 127
        // 128 to -128
        // 129 to -127
        // 130 to -126

        // -128 to -128
        // -129 to 127
        // -130 to 126
        // -131 to 125

        // 同理还有
        // x1.shortValue();
        // x1.longValue();
        // x1.doubleValue();
        // x1.floatValue();
        // x1.intValue();
        // 用此法来转换成基本类型:
        long longVar = x1.longValue();


        // 另一种转换类型的方法是转型, 如果用的基本类型!  (就像cast)
        double x2 = 12.345;
        int y2 = (int) x2;     // >>> 12
        double x3 = 1000;
        byte y3 = (byte) x3;  // >>> -24 // Same result
        // Double x4 = 12.5;
        // Byte y4 = (Byte) x4;  // 但是Cast只支持基本类型
        // STOF 解释:
        // STOF: https://stackoverflow.com/a/17281946/8435726
        // 由于Double, Byte不是继承关系,所以不行,而基本类型的box/unbox是自动的.


        // parse
        // 也是把字符串变成数字的方法
        Integer x12 = Integer.parseInt("88");
        Double x13 = Double.parseDouble("88.88");
        int intVar3 = Integer.parseInt("ABC", 16);  // 把16进制的数字ABC转换成10进制的数字 (2748)

        // valueOf  (注意, 不能对Character类使用,必须是String!)
        // 一种更省空间的制造实例的方式 (类方法)
        Integer x4 = Integer.valueOf(9);  // >>> 9
        Double x5 = Double.valueOf(5);   // >>> 5.0
        Float x6 = Float.valueOf("80.5");  // >>> 80.5
        Integer x7 = Integer.valueOf("100", 2);   // >>> 4 二进制的100也就是十进制的4
        Boolean boo = Boolean.valueOf(true);
        System.out.println(boo);

        // valueOf 对比 parse方法:
        double x8 = Double.parseDouble("88.88");
        Double x9 = Double.parseDouble("88.88");
        double x10 = Double.valueOf("88.88");
        Double x11 = Double.valueOf("88.88");
        // System.out.println(Double.parseDouble("88.88").getClass());  // >>> 返回 double
        System.out.println(Double.valueOf("88.88").getClass());        // >>>  返回 Double实例


        // toString
        // 把数字翻译成字符串,对标py.__str__
        Float x14 = 123.123f;
        System.out.println(x14.toString().getClass()); // >>> "123"  class java.lang.String
        float fff = 123.123f;
        System.out.println(Float.toString(fff)); // 这样可以work
        // 100转换为10进制字符串
        String str1 = Integer.toString(100);
        // 100转换为16进制字符串结果是64
        String str2 = Integer.toString(100, 16);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        // compareTo
        // return the value 0 if anotherFloat is numerically equal to this Float;
        // a value less than 0 if this Float is numerically less than anotherFloat;
        // and a value greater than 0 if this Float is numerically greater than anotherFloat.
        // 主要用于比较两个值, 用 boolean <, > = 0来判断, 不需要纠结到底返回的值是多少
        Float objFloat1 = new Float(90);
        Float objFloat2 = new Float(100);
        int result = objFloat2.compareTo(objFloat1);
        System.out.println(result);

    }
}
