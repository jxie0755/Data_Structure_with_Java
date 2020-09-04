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
     * Version A
     * Don't have to use StringBuilder, just to practive
     * Avoid type convert by using Stringfrom the beginning and iteration
     */
    public String countAndSay(int n) {

        String ans = "1";
        if (n == 1) {
            return ans;
        } else {
            for (int i = 0; i < n - 1; i += 1) {
                ans = this.say(ans);
            }
        }
        return ans;
    }


    /**
     * Helper function to say next number based on current number
     */
    public String say(String word) {
        StringBuilder ans = new StringBuilder();
        String cur = "";
        int count = 0;

        for (int i = 0; i < word.length(); i += 1) {
            String letter = word.substring(i, i + 1);
            if (cur.equals("")) {
                cur = letter;
                count += 1;
            } else {
                if (letter.equals(cur)) {
                    count += 1;
                } else {
                    ans.append(count);
                    ans.append(cur);
                    cur = letter;
                    count = 1;
                }
            }
        }
        ans.append(count);
        ans.append(cur);
        return ans.toString();
    }


    public static void main(String[] args) {
        LC038_Count_And_Say testCase = new LC038_Count_And_Say();
        assert testCase.countAndSay(1).equals("1") : "first";
        assert testCase.countAndSay(2).equals("11") : "second";
        assert testCase.countAndSay(3).equals("21") : "third";
        assert testCase.countAndSay(4).equals("1211") : "fourth";
        assert testCase.countAndSay(5).equals("111221") : "fifth";
        assert testCase.countAndSay(6).equals("312211") : "sixth";
        assert testCase.countAndSay(10).equals("13211311123113112211") : "Very Long";
        System.out.println("all passed");
    }
}

