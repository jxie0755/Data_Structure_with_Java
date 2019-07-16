package Java_Classes;



public class A06_Boolean {

    /*
     * Module java.base
     * Package java.lang
     * Class Boolean
     */

}

class Boolean_zMethods {

    public static void main(String[] args) {

        // 两种构造方法
        Boolean b1 = new Boolean(true); // 通过一个boolean值创建Boolean对象。

        Boolean b2 = new Boolean("asdf"); // 通过字符串创建Boolean对象。 s不能为null， s如果是忽略大小写"true"则转换为true对象， 其他字符串都转换为false对象。
        Boolean default_Bool = new Boolean("Truee");  // false
        Boolean default_Bool2 = new Boolean("True");  // true
        Boolean default_Bool3 = new Boolean("TRUE");  // true
        Boolean default_Bool4 = new Boolean("tRuE");  // true
        // similar to Boolean.parseeBoolean

        Boolean b3 = true;  // 或者更直接一点

        // compareTo
        // (Boolean包装类对象)方法， 可以进行包装对象的比较。
        // 方法返回值是int， 如果返回值是0， 则相等； 如果返回值小于0， 则此对象小于参数对象； 如果返回值大于0， 则此对象大于参数对象
        Integer bool_equality = b1.compareTo(b2);
        System.out.println(bool_equality); // >>>  1  // 因为true算1,false算0? 所以b1 > b2

        // static boolean parseBoolean(String s)
        System.out.println(Boolean.parseBoolean("True")); // >>> true
        System.out.println(Boolean.parseBoolean("yes"));  // >>> false
        System.out.println(">>>>> " + (Boolean.parseBoolean("asdf"))); // >>> false
        // only true if string is "true" or "TRUE" or "True" or even "tRuE" (ignore case)
        // 与构造方法类似的逻辑:
        // if the string argument is not null and is equal, ignoring case, to the string "true".
        // Otherwise, a false value is returned, including for a null argument.


        // 变成String
        String bool_str = b2.toString();  // false

        // logic and or and xor
        Boolean bb1 = Boolean.logicalAnd(b1, b2);  // false
        Boolean bb2 = Boolean.logicalOr(b1, b2);   // true
        Boolean bb3 = Boolean.logicalXor(b1, b2);  // true  // 两个值不相同，则异或结果为1。 如果a、b两个值相同，异或结果为0
    }
}
