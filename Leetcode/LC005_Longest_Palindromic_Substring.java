
/**
 * P005 Longest Palindromic String
 * Medium
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LC005_Longest_Palindromic_Substring {


    /**
     * Version B, O(N^2)
     */
    public String longestPalindrome(String s) {

        int L = s.length();
        String result = "";

        for (int a = 0; a < L; a += 1) {

            int theoretical_length = (Math.min(a - 0, L - a) + 1) * 2;
            if (theoretical_length < result.length()) {
                break;
            }

            for (int b = a + 1; b < a + 3; b += 1) {
                int head = a;
                int tail = b;

                while (head >= 0 && tail <= L && s.charAt(head) == s.charAt(tail - 1)) {
                    String sample = s.substring(head, tail);
                    if (sample.length() > result.length()) {
                        result = sample;
                    }
                    head -= 1;
                    tail += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("").equals("") : "Edge 1";
        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("a").equals("a") : "Edge 2";
        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("aaa").equals("aaa") : "Edge 3";


        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("babad").equals("bab") : "Example 1";

        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("cbbd").equals("bb") : "Example 2";

        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("bababadddddddddddd").equals("dddddddddddd") : "Extra 1";

        assert new LC005_Longest_Palindromic_Substring().longestPalindrome("babababa").equals("bababab") : "Extra 2";

        System.out.println("all passed");
    }

}

