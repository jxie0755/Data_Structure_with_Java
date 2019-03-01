package W3C_Java_Classes;

public class A03_Character {

    public static void main(String[] args) {

    }
}

// Character 类

class Character_zMethods {

    public static void main(String[] args) {

        // 构造法很基本
        Character char1 = new Character('C');

        // 常用方法

        // charCount
        System.out.println(char1.charValue());  // >>> 'C'  // 取值
        System.out.println(Character.digit(char1, 16));  // >>> 12  (A:10, B:11, C:12) 16进制中C表示12

        // ascii table数字 (类似转型成int)
        // 字母AZ的数字值均为10至35.这与Unicode规范无关，其中不会为这些char值分配数值
        System.out.println(Character.getNumericValue(char1)); // >>> 12  (这个12是因为C是ascii中的第12个字符)

    }
}