package W3C_Java_Classes;

public class A01_Number {

    public static void main(String[] args) {

        // 演示装箱和拆包
        Integer x = 5; // box int to an Integer object
        x = x + 10;    // unboxes the Integer to a int
        // 当x被赋为整型值时，由于x是一个对象，所以编译器要对x进行装箱。
        // 然后，为了使x能进行加运算，所以要对x进行拆箱
    }

}

// https://docs.oracle.com/en/java/javase/11/
// https://docs.oracle.com/en/java/javase/11/docs/api/index.html

/*
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
 */


// Java Math类方法
class Number_zMethods {
    public static void main (String []args)
    {
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

        // Convert         // 如果用的基本类型!  (就像cast)
        double x2 = 12.345;
        int y2 = (int) x2;     // >>> 12
        double x3 = 1000;
        byte y3 = (byte) x3;  // >>> -24 // Same result
        // Double x4 = 12.5;
        // Byte y4 = (Byte) x4;  // 但是Cast只支持基本类型
        // STOF 解释:
        // https://stackoverflow.com/questions/17281919/why-is-wrapper-integer-to-float-conversion-not-possible-in-java
        // 由于Double, Byte不是继承关系,所以不行,而基本类型的box/unbox是自动的.


        // parse
        // 也是把字符串变成数字的方法
        Integer x12 = Integer.parseInt("88");
        Double x13 = Double.parseDouble("88.88");

        // TODO
        // move to Boolean method
        System.out.println(">>>>> " + (Boolean.parseBoolean("asdf"))); // >>> false
        // only true if string is "true" or "TRUE" or "True" or even "tRuE" (ignore case)


        // valueOf
        // 一种更省空间的制造实例的方式
        Integer x4 = Integer.valueOf(9);  // >>> 9
        Double x5 = Double.valueOf(5);   // >>> 5.0
        Float x6 = Float.valueOf("80.5");  // >>> 80.5
        Integer x7 = Integer.valueOf("100",2);   // >>> 4 二进制的100也就是十进制的4
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
        // 把数字翻译成字符串,相当于python的str()
        Float x14 = 123.123f;
        System.out.println(x12.toString().getClass()); // >>> "123"  class java.lang.String
        float fff = 123.123f;
        System.out.println(Float.toString(fff)); // 这样可以work



    }
}