import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * P008 String to Integer (atoi)
 * Medium
 * <p>
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed. (Example 4)
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 */
class LC008_String_To_Integer {

    /**
     * Version A, string method
     * Unable to pass, even with Long, need to use BigInteger
     */
    // public int myAtoi(String str) {
    //
    //     // Two hashmap to convert char to digit
    //     Character[] digits = new Character[]{
    //             '0', '1', '2', '3',
    //             '4', '5', '6', '7',
    //             '8', '9'};
    //
    //     Character[] prefix = new Character[]{'+', '-'};
    //
    //     // Get the numeric first (before decimal point)
    //     boolean found = false;
    //     StringBuilder extract = new StringBuilder();
    //     for (char i : str.toCharArray()) {
    //
    //         if (i == ' ' && !found) {
    //
    //         } else if (Arrays.asList(prefix).contains(i)
    //         ) {
    //
    //             if (!found) {
    //                 extract.append(i);
    //                 found = true;
    //             } else {
    //                 break;
    //             }
    //         } else if (Arrays.asList(digits).contains(i)) {
    //             extract.append(i);
    //             found = true;
    //         } else if (i == '.') {
    //             break;
    //         } else {
    //             break;
    //         }
    //     }
    //     if (extract.length() == 0) {
    //         return 0;
    //     } else {
    //         Long result = 0L;
    //         Long base = 1L;
    //
    //         for (int i = extract.length() - 1; i >= 0; i -= 1) {
    //             Character cur = extract.charAt(i);  // 注意这里不要用Character
    //             if (cur == '-' || cur == '+') {
    //             } else {
    //                 result += (long) Character.getNumericValue(cur) * base;
    //                 base *= 10;
    //
    //                 if (result > Integer.MAX_VALUE) {
    //                     if (extract.charAt(0) == '-') {
    //                         return Integer.MIN_VALUE;
    //                     } else {
    //                         return Integer.MAX_VALUE;
    //                     }
    //                 }
    //             }
    //
    //         }
    //
    //         if (extract.charAt(0) == '-') {
    //             return result.intValue() * -1;
    //         }
    //         return result.intValue();
    //
    //     }
    // }


    /**
     * Version B, regex
     */
    public int myAtoi(String str) {

        Pattern p = Pattern.compile("^[\\s]*([+\\-]?)([0]*)(\\d+)");
        // 4部分, 可选的非数字的开头部分, 可选的正负号, 前驱0, 有效数字部分, 非数字的中间项可以直接忽略
        Matcher m = p.matcher(str);

        if (m.find()) {  // 注意,matcher必须确认find才可以继续操作
            String pre = m.group(1);
            String true_num = m.group(3);
            // 先确立如果数字长度太长, 超过Interger最大长度就直接判定, 这样可以确保result在Long的范围内
            if (true_num.length() >= 11) {
                if (pre.equals("-")) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            long result = 0L;  // 先建立超出int范围的result
            long base = 1;     // 注意指数增长也可能超过Integer范围

            for (int i = true_num.length(); i > 0; i -= 1) {
                result += Integer.parseInt(true_num.substring(i - 1, i)) * base;
                base *= 10;
            }

            if (pre.equals("-")) {
                result *= -1;
            }

            // 对result是否在Intgers范围内做出判定
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) result;
            }
        } else { // 防止字符中没有数字
            return 0;
        }
    }


    public static void main(String[] args) {
        LC008_String_To_Integer testCase = new LC008_String_To_Integer();
        assert testCase.myAtoi("ABC") == 0 : "Edge 1";

        assert testCase.myAtoi("42") == 42 : "Example 1";
        assert testCase.myAtoi("   -42") == -42 : "Example 2";
        assert testCase.myAtoi("4193 with words") == 4193 : "Example 3";
        assert testCase.myAtoi("words and 987") == 0 : "Example 4";
        assert testCase.myAtoi("-91283472332") == -2147483648 : "Example 5, 32 bit overflow";

        assert testCase.myAtoi("3.14159") == 3 : "Additional 1";
        assert testCase.myAtoi("+1") == 1 : "Additional 2";
        assert testCase.myAtoi("+-2") == 0 : "Additional 3";
        assert testCase.myAtoi("-0012a42") == -12 : "Additional 4";
        assert testCase.myAtoi("+0 123") == 0 : "Additional 5";
        assert testCase.myAtoi("-5-") == -5 : "Additional 6";
        assert testCase.myAtoi("-6147483648") == -2147483648 : "Additional 7, 10 digit length but oversize Integer";
        assert testCase.myAtoi("9223372036854775808") == 2147483647 : "Additional 8";

        assert testCase.myAtoi("10000000000000000000000522545459") == 2147483647 : "Additional 9, Beyong Long";
        // special case, won't find out it is oversized until to the first digit (even oversize than Long)

        System.out.println("All passed");
    }
}
