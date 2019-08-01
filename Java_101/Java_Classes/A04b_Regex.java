package Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
     * 注意, java给组命名不加P (?<g_name>content)
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
     * splitAsStream​(CharSequence input)     类似split,但是返回成一个Stream<String>类  // TODO learn Stream

     * asMatchPredicate()                    创造一个Predicate实例, 如果match (必须从第一位)
     * asPredicate()                         创造一个Predicate实例, 如果find  (不必从第一位)
     */


    public static void main(String[] args) {

        // static方法演示

        // compile​(String regex)                 编译成Pattern类
        // compile​(String regex, int flags)      重载, 但是带flags
        Pattern p1 = Pattern.compile("\\d+?@\\D+?.com");  // 注意java没有raw string, 所以\d要被转义成\\d
        Pattern pCaseInsensitive = Pattern.compile("aaa", Pattern.CASE_INSENSITIVE);
        System.out.println("case ignored: " + pCaseInsensitive.matcher("aAa").matches());

        Pattern qq_email_pattern = Pattern.compile("[0-9]+?@qq.com");  // 注意java没有raw string, 所以\d要被转义成\\d

        // matches  (必须是要从第一位开始match)
        System.out.println(Pattern.matches("\\d+?@\\D+?.com", "123@qq.com")); // >>> true
        System.out.println(Pattern.matches("\\d+?@\\D+?.com", "a123@qq.com")); // >>> false

        // quote  Returns a literal pattern String for the specified String.
        System.out.println(Pattern.quote("\\d+?@\\D+?.com")); // >>> \Q\d+?@\D+?.com\E


        // instance方法演示

        // flags()
        System.out.println(p1.flags()); // >>> 0   没有flags就是0
        System.out.println(qq_email_pattern.flags()); // >>> 2

        // matcher(CharSequence input)
        Matcher m2 = qq_email_pattern.matcher("a123@qq.com");
        System.out.println(m2);  // >>> 不能match的话,Matcher实例也不会为null

        // split​(CharSequence input)             根据正则pattern分隔字符
        // split​(CharSequence input, int limit)  重载, 限定split数目
        Pattern p3 = Pattern.compile("[\\.]+|[,]+");
        System.out.println(Arrays.toString(p3.split("1,2,,3..4.5")));
        // >>> [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(p3.split("1,2,,3..4.5", 3)));
        // >>> [1, 2, 3..4.5]  // 限定只能分成三份, 后面的就不操作了


        // 此操作略繁琐, 不如用matcher类来的直观
        // asMatchPredicate()  创造一个Predicate实例, 如果match (必须从第一位且需要完整匹配)
        List<String> emails = new ArrayList<>(Arrays.asList("111@q.com", "163@qq.com", "aaa@qq.com", "1a3@qq.com", "125@qq.com"));

        Predicate<String> qq_email_filter_match = qq_email_pattern.asMatchPredicate();
        List<String> filtered_emails_match = emails.stream().filter(qq_email_filter_match).collect(Collectors.toList());
        System.out.println(filtered_emails_match);
        // >>> [163@qq.com, 125@qq.com]

        // asPredicate()  创造一个Predicate实例, 如果find  (不必从第一位)
        Predicate<String> qq_email_filter_find = qq_email_pattern.asPredicate();
        List<String> filtered_emails_find = emails.stream().filter(qq_email_filter_find).collect(Collectors.toList());
        System.out.println(filtered_emails_find); // >>> [163@qq.com, 125@qq.com]
        // >>> [163@qq.com, 1a3@qq.com, 125@qq.com]  # 注意只要满足就返回整个1a3@而不是3@
    }
}


class Regex_Matcher {

    /*
     * Module java.base
     * Package java.util.regex
     * Class Matcher

     * 没有构造方法, Matcher对象必须从Pattern.matcher方法中得到
     */

    /*
     * Matcher基本操作

     * 注意, 只有当matches能成立才能对Macther对象做group, start, end处理
     * 不然必须要执行lookingAt或者find确定为true才能执行group, start, end处理
     * find()           任意包含匹配
     * find​(int start)  重载, 指定开始idx
     * lookingAt()      从头开始, 不一定要到结尾
     * matches()        完整匹配

     * group()                                      返回整个被match的String部分 (相当于group(0)
     * group​(int group)                             按组返回整个被match的String部分 (0组就是整体String)
     * group​(String group_name)                           按group名字返回
     * groupCount()                                 返回被匹配的group的数量

     * start()                                      显示当前被match到的字段在整个字段中的起始idx
     * start​(int group)                             显示当前被match到的字段的group(n)在整个字段中的起始idx
     * start​(String group_name)                     显示当前被match到的字段的group(name)在整个字段中的起始idx

     * end()                                        显示当前被match到的字段在整个字段中的终点idx (跳一位)
     * end​(int group)                               显示当前被match到的字段的group(n)在整个字段中的终点idx
     * end(String group_name)                       显示当前被match到的字段的group(name)在整个字段中的终点idx

     * appendReplacement​(StringBuffer, String)      返回一个修改了的Macther类实例
     * appendReplacement​(StringBuilder, String)     重载

     * appendTail​(StringBuffer sb)                  把最后一个match之后的部分填补上
     * appendTail​(StringBuilder sb)                 重载

     * reset()                                      重置Matcher, 之前被Consume的都清空
     * reset​(CharSequence input)                    重置并对全新字段做匹配

     * hitEnd()                                     只要Matcher检查当前字段到最末,则return True, 无视reset
     * requireEnd()

     * pattern()                                    查看Macther当前匹配的Pattern表达式
     * usePattern​(Pattern newPattern)               修改Macther当前匹配的Pattern表达式

     * * region​(int start, int end)                 调整Matcher字段的范围
     * regionEnd()                                  显示Mactcher当前查看字段的终点
     * regionStart()                                显示Mactcher当前查看字段的起点

     * useTransparentBounds(boolean b)              启用前后查找 (超出region指定范围查看)
     * hasTransparentBounds()                       显示当前是否启用前后查找

     * useAnchoringBounds(boolean b)                启用匹配开头和结尾 (超出region指定范围查看)
     * hasAnchoringBounds()                         显示当前是否启用匹配开头和结尾


     * replaceAll​(String replacement)               相当于py的re.sub, 全部替换, 用$n来表示group名
     * replaceAll​(Function<MatchResult,​String> replacer)     类似py的re.sub接函数范式处理
     * * replaceFirst​(String replacement)             相当于py的re.sub, 但是只替换第一个, 用$n来表示group名
     * replaceFirst​(Function<MatchResult,​String> replacer)   类似py的re.sub接函数范式处理

     * (static) quoteReplacement​(String s)          配合replaceAll使用, 替换字符串字面意思, 没有转移没有正则表达式功能

     * toMatchResult()                              返回一个MatchResult类实例, 也就是之前matches,looingAt和find
     * 确认过后的可以对start,end,group做操作的对象
     * results()                                    返回一系列的MatchResult对象的Steam todo Learn Stream

     * toString()                                   返回Matcher的字符串形式(包含一些信息)
     */

    public static void main(String[] args) {

        // matches, lookingAt, find
        System.out.println("Test matches, lookingAt, find");
        System.out.println(Pattern.compile("ABC").matcher("ABC").matches());  // >>> true
        System.out.println(Pattern.compile("ABC").matcher("ABCd").matches()); // >>> false
        System.out.println(Pattern.compile("ABC").matcher("dABCd").matches()); // >>> false

        System.out.println(Pattern.compile("ABC").matcher("ABC").lookingAt());  // >>> true
        System.out.println(Pattern.compile("ABC").matcher("ABCd").lookingAt()); // >>> true
        System.out.println(Pattern.compile("ABC").matcher("dABCd").matches()); // >>> false

        System.out.println(Pattern.compile("ABC").matcher("ABC").find());  // >>> true
        System.out.println(Pattern.compile("ABC").matcher("ABCd").find()); // >>> true
        System.out.println(Pattern.compile("ABC").matcher("dABCd").find()); // >>> true

        // find可以持续搜索
        // group(), group(int n), group(String grou_name)
        System.out.println("Test group");
        Pattern p1 = Pattern.compile("#(\\d)(?<Letter>\\D)(\\d)");
        Matcher m1 = p1.matcher("#1A2, #2B3, #3C4, #4C5");
        while (m1.find()) {
            System.out.println(m1.group(0) + " g1: " + m1.group(1) + " gL: " + m1.group("Letter") + " g3: " + m1.group(3));
        }
        // >>>
        // 1A2 g1: 1 g2: A g3: 2
        // 2B3 g1: 2 g2: B g3: 3
        // 3C4 g1: 3 g2: C g3: 4
        // 4C5 g1: 4 g2: C g3: 5
        // 注意, find类似iterator, 只能consume一次, 但是lookingAt和matches则不会


        Matcher skipped_1 = Pattern.compile("(a)?(bc)").matcher("bc");
        if (skipped_1.find()) {
            System.out.println(skipped_1.group(1)); // >>> null  # 没有a就是return null
            System.out.println(skipped_1.group(2)); // >>> bc  # 没有a就是return null
        }

        Matcher skipped_2 = Pattern.compile("((a)|(A))(bc)").matcher("Abc");
        if (skipped_2.find()) {
            System.out.println(skipped_2.group(1)); // >>> A   // 第一个大括号包括了a和A,所以返回a
            System.out.println(skipped_2.group(2)); // >>> null  // 第二个大括号只包括了a,所以返回mull
            System.out.println(skipped_2.group(3)); // >>> A  // 第三个大括号只包括了A,所以返回A

        }

        // groupCount()
        // doesn't care if the group exist in the match or not, just counting number of bracketes
        System.out.println(Pattern.compile("((a)|(A))(bc)").matcher("Abc").groupCount()); // >>> 4
        System.out.println(Pattern.compile("(a)?(bc)").matcher("bc").groupCount()); // >>> 2


        // start(), start(int n), start(String grou_name)
        System.out.println("Test Start");
        Matcher m1b = p1.matcher("#1A2, #2B3, #3C4, #4C5");
        // "#1A2 ,  #2B3 ,  #3C4 ,  #4C5"
        //  0123 45 6789 01 2345 67 8901
        while (m1b.find()) {
            System.out.println(m1b.group() + " " + m1b.start() + " " + m1b.start(1) + " " + m1b.start("Letter"));
        }
        // >>>
        // #1A2 0 1 2
        // #2B3 6 7 8
        // #3C4 12 13 14
        // #4C5 18 19 20


        // end(), end(int n), end(String grou_name)   end会跳一位
        System.out.println("Test End");
        Matcher m1c = p1.matcher("#1A2, #2B3, #3C4, #4C5");
        // "#1A2 ,  #2B3 ,  #3C4 ,  #4C5"
        //  0123 45 6789 01 2345 67 8901
        while (m1c.find()) {
            System.out.println(m1c.group() + " " + m1c.end() + " " + m1c.end(1) + " " + m1c.end("Letter"));
        }
        // >>>
        // #1A2 4 2 3
        // #2B3 10 8 9
        // #3C4 16 14 15
        // #4C5 22 20 21

        // appendReplacement​(StringBuffer / StringBuilder, String)
        // 类似python的sub方法
        Pattern p2 = Pattern.compile("(cat)");
        Matcher m2 = p2.matcher("one cat two cats in the yard");
        StringBuilder sb1 = new StringBuilder();
        while (m2.find()) {
            m2.appendReplacement(sb1, "dog");
        }
        // appendTail    // 必须是配合appendReplacement使用
        m2.appendTail(sb1);
        System.out.println(sb1.toString());

        // reset()
        // reset​(CharSequence input)
        System.out.println("Test reset:");
        Matcher m_reset = Pattern.compile("A\\d+").matcher("A123");
        System.out.println(m_reset.find()); // >>> true
        System.out.println(m_reset.find()); // >>> false   // consumed
        System.out.println(m_reset.find()); // >>> false   // consumed
        m_reset.reset();
        System.out.println(m_reset.find()); // >>> true  // reset, reconsume
        m_reset.reset();
        System.out.println(m_reset.find()); // >>> true  // reset, reconsume
        m_reset.reset("A456");
        if (m_reset.matches()) {
            System.out.println(m_reset.group()); // >>> A456
        }


        // region​(int start, int end)
        // regionEnd()
        // regionStart()
        System.out.println("Test regions");
        Matcher m_lookbehind = Pattern.compile("(?<=A)\\d+").matcher("A123");
        Matcher m_anchor = Pattern.compile("^A\\d+A$").matcher("A13A");
        // 初始就是整个String字段
        System.out.println(m_lookbehind.regionStart()); // >>> 0
        System.out.println(m_lookbehind.regionEnd());   // >>> 4
        // 调整字段范围
        m_lookbehind.region(1, 4);
        System.out.println(m_lookbehind.regionStart()); // >>> 1
        System.out.println(m_lookbehind.regionEnd());   // >>> 4


        // useTransparentBounds(boolean b)
        // Invoking this method with an argument of true will set this matcher to use transparent bounds.
        // If the boolean argument is false, then opaque bounds will be used.
        // By default, a matcher uses opaque bounds
        System.out.println("Test Transpareent");
        System.out.println(m_lookbehind.matches()); // >>> false  // 默认为false
        System.out.println(m_lookbehind.useTransparentBounds(false).matches()); // >>> false  // 强制不看前后查找
        System.out.println(m_lookbehind.useTransparentBounds(true).matches()); // >>> true    // 强制看的话就能看到
        // hasTransparentBounds()

        // useAnchoringBounds(boolean b)
        // Invoking this method with an argument of true will set this matcher to use anchoring bounds.
        // If the boolean argument is false, then non-anchoring bounds will be used.
        // By default, a matcher uses anchoring region boundaries.
        System.out.println("Test anchoring");
        m_anchor.region(1, 3);
        System.out.println(m_anchor.matches()); // >>> false
        System.out.println(m_anchor.useAnchoringBounds(false).matches()); // >>> false
        System.out.println(m_anchor.useAnchoringBounds(true).matches());  // >>> false
        // hasAnchoringBounds()

        // pattern()
        // usePattern​(Pattern newPattern)
        System.out.println("Test pattern");
        Matcher m_pp = Pattern.compile("A\\d+").matcher("B123");
        System.out.println(m_pp.pattern()); // >>> A\d+
        System.out.println(m_pp.matches()); // >>> false
        m_pp.usePattern(Pattern.compile("B\\d+"));
        System.out.println(m_pp.matches()); // >>> true

        // hitEnd()
        System.out.println("Test hitEnd");
        Matcher m_hit_end = Pattern.compile("A\\d+").matcher("A123 A456 B789");
        System.out.println(m_hit_end.find());   // >>> true
        System.out.println(m_hit_end.group());  // >>> A123
        System.out.println(m_hit_end.hitEnd()); // >>> false
        System.out.println(m_hit_end.find());   // >>> true
        System.out.println(m_hit_end.group());  // >>> A456
        System.out.println(m_hit_end.hitEnd()); // >>> false  // 注意,这里虽然已经是最后一个,但是没有hitEnd
        System.out.println(m_hit_end.find());   // >>> true   // 这里才是一直找到了末尾也没找到
        System.out.println(m_hit_end.hitEnd()); // >>> true  // 这里已经穷尽
        m_hit_end.reset();
        System.out.println(m_hit_end.hitEnd()); // >>> true  // 这里仍然已经穷尽
        System.out.println(m_hit_end.find());
        System.out.println(m_hit_end.group());  // >>> A123
        // 但是还是可以继续重新查找,但是不能改变之前已经hitEnd这一事实

        // replaceAll​(String replacement)
        System.out.println("Test replaceALl");
        Matcher m_rA_1 = Pattern.compile("(A|a)\\d+").matcher("DDD A123 XXX a456 YYY");
        System.out.println(m_rA_1.replaceAll("WTF"));
        // >>> DDD WTF XXX WTF YYY
        System.out.println(m_rA_1.replaceAll("TH"));
        // >>> DDD TH XXX TH YYY  可重复使用
        System.out.println(m_rA_1.replaceAll("$1-WTF"));
        // >>> DDD A-WTF XXX a-WTF YYY      // 使用$1,$2等等来替代group号
        System.out.println(m_rA_1.replaceAll(mr -> mr.group(1) + mr.group(1).toUpperCase() + "-WTF"));
        // >>> DDD AA-WTF XXX aA-WTF YYY    // 自带一个lambda函数范式, 可以对group做操作, 然后做其他处理

        // replaceAll​(Function<MatchResult,​String> replacer)
        // replaceFirst​(String replacement)
        System.out.println(m_rA_1.replaceFirst("$1-WTF"));
        // >>> DDD A-WTF XXX a456 YYY
        System.out.println("Test replaceFirst");
        // replaceFirst​(Function<MatchResult,​String> replacer)
        System.out.println(m_rA_1.replaceFirst(mr -> mr.group(1) + mr.group(1).toLowerCase() + "-WTF"));
        // >>> DDD Aa-WTF XXX a456 YYY

        // quoteReplacement​(String s)
        System.out.println(m_rA_1.replaceAll(Matcher.quoteReplacement("$1-WTF")));
        // >>> DDD $1-WTF XXX $1-WTF YYY   // 这里$1不代表group1而是就是$1这个字符串

        // toMatchResults()
        // 返回一个MatchResult类实例, 也就是之前matches,looingAt和find确认过后的可以对start,end,group做操作的对象
        // 只是现在将这个对象独立出来
        Matcher m_rA_2 = Pattern.compile("(A|a)\\d+").matcher("DDD A123 XXX a456 YYY");
        if (m_rA_2.find()) {
            MatchResult r1 = m_rA_2.toMatchResult();
            System.out.println(r1.group());            // >>> A123
            System.out.println(m_rA_2.group());        // >>> A123  相同

            // 但是随后可以做其他操作
            System.out.println(r1.start());  // >>> 4
            System.out.println(r1.end());  // >>> 8
            System.out.println(r1.group(1)); // >>> A
        }

        // toString
        System.out.println(m_rA_2.toString());
        // >>> java.util.regex.Matcher[pattern=(A|a)\d+ region=0,21 lastmatch=A123]


    }
}

