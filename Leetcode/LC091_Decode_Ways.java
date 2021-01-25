/**
 * https://leetcode.com/problems/decode-ways/
 * P091 Docde Ways
 * Medium
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * "A" -> 1
 * "B" -> 2
 * ...
 * "Z" -> 26
 * <p>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 由于数字之间没有间断,可能有很多种解读方法, 比如"123"可以是"1" + "2" + "3", 或者"12"+"3", 或者"1" + "23"
 */
class LC091_Decode_Ways {
    /**
     * Version A, Recursive method exceeded time limit
     */
    // public int numDecodings(String s) {
    //     if (s.length() == 0) {
    //         return 1;
    //     } else if (s.charAt(0) == '0') {
    //         return 0;
    //     } else if (s.length() == 1) {
    //         return 1;
    //     } else {
    //         if (s.charAt(0) == '1' || s.charAt(0) == '2' &&
    //                                   s.charAt(1) != '7' &&
    //                                   s.charAt(1) != '8' &&
    //                                   s.charAt(1) != '9'
    //             ) {
    //             return this.numDecodings(s.substring(1)) + this.numDecodings(s.substring(2));
    //         } else {
    //             return this.numDecodings(s.substring(1));
    //         }
    //     }
    // }

    /**
     * Version STD, linear itreration, dynamic programming
     */
    public int numDecodings(String s) {

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev = 1;
        int prev_prev = 0;
        int cur = 0;

        for (int i = 0; i < s.length(); i += 1) {
            cur = 0;

            if (s.charAt(i) != '0') {
                cur = prev;
            }

            if (i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' &&
                    s.charAt(i) != '7' &&
                    s.charAt(i) != '8' &&
                    s.charAt(i) != '9')
            ) {
                cur += prev_prev;
            }

            prev_prev = prev;
            prev = cur;
        }
        return cur;
    }


    public static void main(String[] args) {
        LC091_Decode_Ways testCase = new LC091_Decode_Ways();

        assert testCase.numDecodings("0") == 0 : "Edge 1";
        assert testCase.numDecodings("00") == 0 : "Edge 2";
        assert testCase.numDecodings("230") == 0 : "Edge 3";
        assert testCase.numDecodings("12390123") == 0 : "Edge 4";
        assert testCase.numDecodings("1") == 1 : "Edge 5";

        assert testCase.numDecodings("12") == 2 : "Example 1";
        assert testCase.numDecodings("123") == 3 : "Example 2";
        assert testCase.numDecodings("226") == 3 : "Example 3";

        assert testCase.numDecodings("227") == 2 : "Additional 1";
        assert testCase.numDecodings("611") == 2 : "Additional 2";

        String L = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        assert testCase.numDecodings(L) == 3981312 : "Long";

        System.out.println("All passed");
    }
}

