package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class A04_String {

    /*
     * Module java.base
     * Package java.lang
     * Class String
     */

    /*
     * String 基本操作
     * "+"                             可以相加
     * length()                        长度属性
     * equals                          相等
     * equalsIgnoreCase
     * valueOf                         快速生成一个Object的__str__

     * format                          格式化, 用于四舍五入,保留位数等等
     * compareTo                       比较大小
     * compareToIgnoreCase
     * regionMatches                   测试两个字符串各自一个区域是否相等(同长但不同index)
     * trim()                          返回字符串的副本，忽略前导空白和尾部空python strp

     * split(String X)                 从所有X分割, 并且吞没X
     * split(String X, int N)          同上, 但是限制最后最多分成N份

     * getChars                        从String中找一段insert到char Array的任意位置 (注意长度)
     * toCharArray                     整体变成char Array
     * charAt                          获得一个index的char

     * indexOf(char)                   返回指定char在此字符串中第一次出现处的索引
     * indexOf(String)                 返回指定String在此字符串中第一次出现处的索引

     * replace(oldChar, newChar)       批量替换char为另一个
     * replaceAll(oldStr, newStr)      批量提换String为另一个
     * replaceFirst(oldStr, newStr)    提换第一个String为另一个

     * copyValueOf                     从char Array中提取任意一段变成新String
     * intern                          一个复制,但是与常量池有关, 用于节省空间

     * String substring(idxA)          返回一个新的字符串，从idxA一直到末尾
     * String substring(idxA, idxB)    返回一个新字符串，从[idxA, idxB)

     * startsWith(String)              测试此字符串是否以指定的前缀开始
     * endsWith(String)                测试此字符串是否以指定的前缀结束
     * subSequence(idxA, idxB)         返回一个子序列的CharSequence

     * toLowerCase()                   将此 String 中的所有字符都转换为小写
     * toUpperCase()                   将此 String 中的所有字符都转换为大写

     * hashCode()

     * concat                          连接字符串
     * static String.join(String connecter, String[] or List<String>).  连接string
     */

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

class String_getChars {
    public static void main(String[] args) {
        String str4 = "hellohellohello";

        // public void getChars​(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        char[] charray1 = {'a', 'b', 'c', 'd', 'e', 'f'};
        str4.getChars(2, 4, charray1, 1);
        // str4 is "hellohellohello", str4[2:4]也就是"ll"
        // 把 "ll" 插入到 'a' 之后, 得到 {'a', 'l', 'l', 'd', 'e', 'f'};  // 注意是覆盖
        System.out.println(Arrays.toString(charray1));  // >>> [a, l, l, d, e, f]

        char[] charray2 = {'a', 'b', 'c'};
        // str4.getChars(2, 7, charray2, 1);
        // str4 is "hellohellohello", str4[2:7]也就是"llohe"
        // System.out.println(Arrays.toString(charray2));  // >>> {'a', 'l', 'l'};  超过了array长度是不行的

        // 直接转化:
        String str_x = "ABCCC";
        char[] charray_x = new char[str_x.length()];  // 规定与String等长
        str_x.getChars(0, str_x.length(), charray_x, 0);
        System.out.println(Arrays.toString(charray_x)); // >>>  [A, B, C, C, C]

        // 另一个方法就是利用
        // char[] toCharArray() 将此字符串转换为一个新的字符数组。
        char[] charray_y = str_x.toCharArray();
        System.out.println(Arrays.toString(charray_y)); // >>>  [A, B, C, C, C]
    }
}


class String_intern {
    public static void main(String[] args) {

        String str3 = "hello";
        // String intern() 返回字符串对象的规范化表示形式
        // intern()方法设计的初衷，就是重用String对象，以节省内存消耗。这么说可能有点抽象，那么就用例子来证明
        System.out.println(str3.intern());   // >>>  helloh

        // 它的作用在jdk1.7之后是查看常量池中是否存在和调用方法的字符串内容一样的字符串，如果有的话，就返回该常量池中的字符串，
        // 若没有的话，就在常量池中写入一个堆中该字符串对象的一个引用，指向堆中的该对象，并返回该引用


        String a = new String("abc");  // 第一次，创建了两个对象，一个是堆中的string对象，一个是常量池中的"abc"
        String b = new String("abc");  // 第二次，创建一个对象，堆中的另外一个string对象
        // 总的来说就是一共有两个个"abc", 它们虽然相同,但是互相独立

        System.out.println(a.intern().equals(b.intern()));  // true   // 说明都是指向同一个"abc"
        System.out.println(a.intern().equals(b));           // false
        System.out.println(a.intern().equals(a));           // false

        String poolstr = "abc";  // 注意这里没有新建一个String对象,而是直接指向了堆中已有的那个"abc"
        // 直接从字符串常量池中获取
        System.out.println(a.intern().equals(poolstr));  // true
        System.out.println(b.intern().equals(poolstr));  // true


        // Example 2
        String s0 = "kvill";
        String s1 = "kvill";
        String s2 = "kv" + "ill";
        System.out.println(s0.equals(s1)); // true
        System.out.println(s0.equals(s2)); // true
        // 用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，它们有自己的地址空间
        String s00 = "kvill";
        String s11 = new String("kvill");
        String s22 = "kv" + new String("ill");
        System.out.println(s00.equals(s11));  // false
        System.out.println(s00.equals(s22));  // false
        System.out.println(s11.equals(s22));  // false
        System.out.println(s00.equals(s11));  // true  // 注意equals只关注内容是否相等
    }
}


class String_regionMatches {

    public static void main(String[] args) {

        String aa = "aaxyzkk";
        String bb = "bbbXYZmm";
        // aa从2开始,bb从3开始,长度为3, 都是"xyz",一个是小写,一个是大写

        String cc = "bbbXYZmm";
        // boolean regionMatches(int toffset, String other, int ooffset, int len)                      测试两个字符串区域是否相等。
        System.out.println(aa.regionMatches(2, bb, 3, 3));                 // >>>  false//
        // boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)  测试两个字符串区域是否相等。 (可选忽略大小写)
        System.out.println(aa.regionMatches(true, 2, bb, 3, 3));  // >>>  true  (忽略了xyz的大小写)

    }
}

class String_regexMethods {

    public static void main(String[] args) {

        // boolean matches(String regex)  告知此字符串是否匹配给定的正则表达式
        String SS0 = "ABCDE";
        System.out.println(SS0.matches("CD")); // >>> false
        System.out.println(SS0.matches("NDSFABCDEsdfsd")); // >>> false
        // TODO learn 正则表达式

        // String replaceAll(String regex, String replacement)   使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        // String replaceFirst(String regex, String replacement) 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        String SS1 = "ABACAD";
        String SR1 = SS1.replaceAll("A", " ");
        System.out.println(SR1); // >>>  " B C D"

        // String[] split(String regex)  根据给定正则表达式的匹配拆分此字符串。
        // String[] split(String regex, int limit)  根据匹配给定的正则表达式来拆分此字符串。
        String S1 = "ABCABC";
        String[] SA1 = S1.split("C");
        System.out.println(Arrays.toString(SA1)); // >>>  [AB, AB] // C被吞没, 末尾不留空字符(不像python)

        String S2 = "ABCABCABCABCABC";
        String[] SA2 = S2.split("C", 3);
        System.out.println(Arrays.toString(SA2)); // >>>  [AB, AB, ABCABCABC]  最多只能分成三份
    }

}

class String_zMethods {

    public static void main(String[] args) {
        // 构造方法
        String str1 = "hello";  // 最简单方式

        char[] helloArray = {'h', 'e', 'l', 'l', 'o'};  // 从一个char数组创建
        String[] helloStrArray = {"h", "e", "l", "l", "o"};
        String str2 = new String(helloArray); // 直接convert

        // String类有11种构造方法，这些方法提供不同的参数来初始化字符串


        // 获取长度
        Integer str1_length = str1.length();  // 5

        // concat方法, 连接字符串  string1.concat(string2);
        String str3 = str1.concat(str2).concat(str1);  // hellohellohello
        String str4 = str1 + str2 + str1;              // hellohellohello

        // join方法, 把Array变成String
        // join​(CharSequence delimiter, CharSequence... elements)
        // join​(CharSequence delimiter, Iterable<? extends CharSequence> elements)
        // String str4b = String.join("", helloArray); not working
        String str4c = String.join("", helloStrArray);
        List<String> strList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        String str4d = String.join("", strList);

        // char charAt(int index)
        char c1 = str4.charAt(4);  // 'o'


        // compareTo
        String str5 = "BCK";
        String str6 = "BDK";
        System.out.println(str5.compareTo(str6));  // C < D, 所以 -1
        String str7 = "bdk";
        System.out.println(str5.compareTo(str7));  // B > b, 所以 32  (B排66,b排98) 差32
        System.out.println(str5.compareToIgnoreCase(str7));  // C < d, 所以 -1


        // static String copyValueOf(char[] data)
        String str8 = String.copyValueOf(helloArray);  // { 'h', 'e', 'l', 'l', 'o'}
        // static String copyValueOf(char[] data, int offset, int count)
        String str9 = String.copyValueOf(helloArray, 1, 3);
        System.out.println(str9);  // >>>  "ell"


        // equals
        System.out.println(str2.equals(str8));  // >>> true
        // equalsIgnoreCase(String anotherString)
        System.out.println(str6.equalsIgnoreCase(str7));  // "BDK" and "bdk"  >>> true


        // endsWith(String suffix)
        System.out.println(str9.endsWith("l"));  // >>> true


        //int hashCode()  返回此字符串的哈希码
        System.out.println(str1);  // "hello"
        System.out.println(str1.hashCode());  // >>> 99162322


        // int indexOf(int ch) 返回指定字符在此字符串中第一次出现处的索引
        System.out.println(str3.indexOf('l'));  // >>>  2
        // int indexOf(int ch, int fromIndex) 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
        System.out.println(str3.indexOf('l', 5));  // >>>  7
        // "hellohellohello"
        //    2345678
        // int indexOf(String str) 返回指定子字符串在此字符串中第一次出现处的索引。
        System.out.println(str3.indexOf("lo"));  // >>>  3
        // int indexOf(String str, int fromIndex)  返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
        System.out.println(str3.indexOf("lo", 5));  // >>>  8


        // String replace(char oldChar, char newChar)
        String str_google = "google";
        String str_replace = str_google.replace('o', 'a');
        System.out.println(str_replace); // >>>  gaagle


        // boolean startsWith(String prefix)               测试此字符串是否以指定的前缀开始。
        // boolean startsWith(String prefix, int toffset)  测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
        System.out.println(str_google.startsWith("g"));                   // >>> true
        System.out.println(str_google.startsWith("og", 2));   // >>> true
        // "go og le"
        //  01 23 45


        // CharSequence subSequence(int beginIndex, int endIndex) 返回一个新的字符序列，它是此序列的一个子序列。
        CharSequence cs_new = str_google.subSequence(1, 4);
        System.out.println(cs_new); // >>>  oog


        // String substring(int beginIndex)  返回一个新的字符串，它是此字符串的一个子字符串。
        // String substring(int beginIndex, int endIndex) 返回一个新字符串，它是此字符串的一个子字符串。
        System.out.println(str_google.substring(3)); // >>>  gle
        System.out.println(str_google.substring(3, 5)); // >>>  gl


        //String toLowerCase()  使用默认语言环境的规则将此 String 中的所有字符都转换为小写
        // String toUpperCase() 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
        String str_g2 = "   Google x  ";
        System.out.println(str_g2.toLowerCase()); // >>>  "   google x  "
        System.out.println(str_g2.toUpperCase()); // >>>  "   GOOGLE X  "


        // String toString()  返回此对象本身（它已经是一个字符串！）


        // String trim() 返回字符串的副本，忽略前导空白和尾部空白。
        System.out.println(str_g2.length());        // >>>  13       "   Google x  "
        System.out.println(str_g2.trim().length()); // >>>  8            12345678


        // Iteration of String
        // 3 methods:
        // 1: in char type
        String str = "asdfghjkl";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
        }

        //2: in char type
        char[] c = str.toCharArray();
        for (char cc : c) {
            // use cc
        }

        //3: in String type
        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(i, i + 1);
        }
    }
}
