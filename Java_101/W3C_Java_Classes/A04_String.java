package W3C_Java_Classes;

public class A04_String {

    public static void main(String[] args) {

    }
}


class String_format {

    public static void main(String[] args) {
        // format方法
        Float floatVar = 1.233f;
        Integer intVar = 4;
        String stringVar = "Abc";

        String fs = String.format("%f " + "%d " + "%s", floatVar, intVar, stringVar);
        System.out.println(fs); // >>>  "1.233000 4 Abc"

        System.out.println(String.format("%3.2f", 1.233f));  // "1.23"

        System.out.println(String.format("%7.2f", 1.2f));  // "   1.20"
        // 至少要凑够7位字符长度, 但是又只保留两位小数, 所以不够的话就用0来凑小数位

        System.out.println(String.format("%.2f", 12.2350f));  // "12.23" 保留两位小数, 50舍
        System.out.println(String.format("%.2f", 12.2351f));  // "12.24" 保留两位小数, 51入

    }
}


class String_zMethods {

    public static void main(String[] args) {
        // 构造方法
        String str1 = "hello";  // 最简单方式

        char[] helloArray = { 'h', 'e', 'l', 'l', 'o'};  // 从一个char数组创建
        String str2 = new String(helloArray);

        // String类有11种构造方法，这些方法提供不同的参数来初始化字符串


        // 获取长度
        Integer str1_length = str1.length();  // 5

        // join方法, 连接字符串  string1.concat(string2);
        String str3 = str1.concat(str2).concat(str1);  // hellohellohello
        String str4 = str1 + str2 + str1;              // hellohellohello
    }
}

