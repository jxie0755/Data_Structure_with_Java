package W3C_Java_Classes;



public class A05_Boolean {

    public static void main(String[] args) {

    }
}

class Boolean_zMethods {

    public static void main(String[] args) {

        // 两种构造方法
        Boolean b1 = new Boolean(true); // 通过一个boolean值创建Boolean对象。
        Boolean b2 = new Boolean("asdf"); // 通过字符串创建Boolean对象。 s不能为null， s如果是忽略大小写"true"则转换为true对象， 其他字符串都转换为false对象。
        Boolean b3 = true;  // 或者更直接一点

        // compareTo
        // (Boolean包装类对象)方法， 可以进行包装对象的比较。
        // 方法返回值是int， 如果返回值是0， 则相等； 如果返回值小于0， 则此对象小于参数对象； 如果返回值大于0， 则此对象大于参数对象
        Integer bool_equality = b1.compareTo(b2);
        System.out.println(bool_equality); // >>>  1  // 因为true算1,false算0? 所以b1 > b2

        // static boolean parseBoolean(String s)
        System.out.println(Boolean.parseBoolean("True")); // >>> true
        System.out.println(Boolean.parseBoolean("yes"));  // >>> false
        // 与构造方法类似的逻辑:
        // if the string argument is not null and is equal, ignoring case, to the string "true".
        // Otherwise, a false value is returned, including for a null argument.


        // 变成String
        String bool_str = b2.toString();  // false

    }
}

