/**
 * https://leetcode.com/problems/count-and-say/
 * p038 Count and Say
 * Easy
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1. 1
 * 2. 11
 * 3. 21
 * 4. 1211
 *    1 is 11
 *     2 is 12
 *      11 is 21, so next number is: 11 - 12 - 21
 * 5. 111221
 * <p>
 * each number is a read of previous number
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 */
class LC038_Count_And_Say {

    /**
     * Version B1
     * Don't have to use StringBuilder, just to practive
     * Avoid type convert by using Stringfrom the beginning and iteration
     */
    public String countAndSay2(int n) {

        String number = "1";
        for (int i = 1; i < n; i += 1) {
            number += " ";
            int lenth = 1;
            String result = "";
            for (int k = 0; k < number.length() - 1; k += 1) {
                if (number.charAt(k) == number.charAt(k + 1)) {
                    lenth += 1;
                } else {
                    result += String.valueOf(lenth) + number.charAt(k);
                    lenth = 1;
                }
            }
            number = result;
        }
        return number;
    }

    /**
     * Version B2
     * Use StringBuilder, just to practive
     * Avoid type convert by using StringBuilder from the beginning and iteration
     * This is significantly faster than B1
     */
    public String countAndSay(int n) {

        StringBuilder number = new StringBuilder("1");
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < n; i += 1) {
            number.append(" ");
            int lenth = 1;
            result.delete(0, result.length());
            for (int k = 0; k < number.length() - 1; k += 1) {
                if (number.charAt(k) == number.charAt(k + 1)) {
                    lenth += 1;
                } else {
                    result.append(String.valueOf(lenth) + number.charAt(k));  // 注意这里append lenth不能取消String method
                    lenth = 1;
                }
            }
            number.replace(0, number.length(), result.toString());  // 注意这里不能直接number = result, 否则会指向同一个object
        }
        return number.toString();
    }

    public static void main(String[] args) {
        assert new LC038_Count_And_Say().countAndSay(1).equals("1") : "first";
        assert new LC038_Count_And_Say().countAndSay(2).equals("11") : "second";
        assert new LC038_Count_And_Say().countAndSay(3).equals("21") : "third";
        assert new LC038_Count_And_Say().countAndSay(4).equals("1211") : "fourth";
        assert new LC038_Count_And_Say().countAndSay(5).equals("111221") : "fifth";
        assert new LC038_Count_And_Say().countAndSay(6).equals("312211") : "sixth";
        assert new LC038_Count_And_Say().countAndSay(10).equals("13211311123113112211") : "Very Long";
        System.out.println("all passed");
    }
}

