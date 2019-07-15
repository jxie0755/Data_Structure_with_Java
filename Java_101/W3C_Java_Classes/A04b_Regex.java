package W3C_Java_Classes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A04b_Regex {

    /*
     * Java 正则表达式
     * java.util.regex 包主要包括以下三个类
         * Pattern 类：
             * pattern 对象是一个正则表达式的编译表示。
             * Pattern 类没有公共构造方法。
             * 要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。
             * 该方法接受一个正则表达式作为它的第一个参数。
         * Matcher 类：
             * Matcher 对象是对输入字符串进行解释和匹配操作的引擎。
             * 与Pattern 类一样，Matcher 也没有公共构造方法。
             * 你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
         * PatternSyntaxException：
            * PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
     */

}


class Regex_Pattern {

    /*
     * Module java.base
     * Package java.util.regex
     * Class Pattern
     *
     * A compiled representation of a regular expression.
     * A regular expression, specified as a string, must first be compiled into an instance of this class.
     * (类似python的概念, 可以预编译一个pattern)
     * The resulting pattern can then be used to create a Matcher object that can match arbitrary character sequences against the regular expression.
     */


    /* Flags
     * static int   CANON_EQ          Enables canonical equivalence.
     * static int   CASE_INSENSITIVE  Enables case-insensitive matching.
     * static int   COMMENTS          Permits whitespace and comments in pattern.
     * static int   DOTALL            Enables dotall mode.
     * static int   LITERAL	          Enables literal parsing of the pattern.
     * static int   MULTILINE         Enables multiline mode.
     * static int   UNICODE_CASE      Enables Unicode-aware case folding.
     * static int   UNIX_LINES	      Enables Unix lines mode.
     * static int   UNICODE_CHARACTER_CLASS	 Enables the Unicode version of Predefined character classes
                                            * and POSIX character classes.
     */



    /*
     * Pattern 基本操作
     * (CharSequence包括String, BuefferedString)
     * Static
        * compile​(String regex)                 编译成Pattern类
        * compile​(String regex, int flags)      重载, 但是带flags

        * matches​(String regex, CharSequence)   安徽是否match
        * quote​(String s)                       返回这个正则表达式的字面String

     * Instancem ethod
        * flags()                               返回compile的flags
        * matcher(CharSequence input)           返回一个matcher类实例 (不match也不为null)

        * split​(CharSequence input)             根据正则pattern分隔字符
        * split​(CharSequence input, int limit)  重载, 限定split数目
        * splitAsStream​(CharSequence input)     类似split,但是返回成一个Stream<String>类
     */


    public static void main(String[] args) {

        // static方法演示

        // compile​(String regex)                 编译成Pattern类
        // compile​(String regex, int flags)      重载, 但是带flags
        Pattern p1 = Pattern.compile("\\d+?@\\D+?.com");  // 注意java没有raw string, 所以\d要被转义成\\d
        Pattern p2 = Pattern.compile("[0-9]+?@[a-z]+?.com", Pattern.CASE_INSENSITIVE);  // 注意java没有raw string, 所以\d要被转义成\\d

        // matches  (必须是要从第一位开始match)
        System.out.println(Pattern.matches("\\d+?@\\D+?.com", "123@qq.com")); // >>> true
        System.out.println(Pattern.matches("\\d+?@\\D+?.com", "a123@qq.com")); // >>> false

        // quote  Returns a literal pattern String for the specified String.
        System.out.println(Pattern.quote("\\d+?@\\D+?.com")); // >>> \Q\d+?@\D+?.com\E



        // instance方法演示

        // flags()
        System.out.println(p1.flags()); // >>> 0   没有flags就是0
        System.out.println(p2.flags()); // >>> 2

        // matcher(CharSequence input)
        Matcher m2 = p2.matcher("a123@qq.com");
        System.out.println(m2);  // >>> 不能match的话,Matcher实例也不会为null

        // split​(CharSequence input)             根据正则pattern分隔字符
        // split​(CharSequence input, int limit)  重载, 限定split数目
        Pattern p3 = Pattern.compile("[\\.]+|[,]+");
        System.out.println(Arrays.toString(p3.split("1,2,,3..4.5")));
        // >>> [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(p3.split("1,2,,3..4.5", 3)));
        // >>> [1, 2, 3..4.5]  // 限定只能分成三份, 后面的就不操作了



    }


}



