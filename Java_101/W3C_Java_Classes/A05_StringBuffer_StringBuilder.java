package W3C_Java_Classes;

public class A05_StringBuffer_StringBuilder {

}


/*
 * String 字符串常量
 * StringBuffer 字符串变量（线程安全）
 * StringBuilder 字符串变量（非线程安全）
    * StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象
 */

class z_StringBuffer {

    public static void main(String[] args) {

        StringBuffer sBuffer = new StringBuffer("Denis: ");
        sBuffer.append("www");
        sBuffer.append(".helloworld");
        sBuffer.append(".com");
        System.out.println(sBuffer); // >>>  Denis: www.helloworld.com



    }
}


class z_StringBuilder {

    public static void main(String[] args) {

    }
}
