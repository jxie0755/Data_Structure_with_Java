
/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * LC005 Longest Palindromic String
 * Medium
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
class LC005_Longest_Palindromic_Substring {


    /**
     * Version C, O(N^2)
     * Interate the center points and expand on each, easier to read than version B
     */
    public String longestPalindrome(String s) {

        int L = s.length();
        String result = "";

        for (int i = 0; i < L; i += 1) {

            // first odd length check
            int odd_j = i;
            int odd_k = i;
            while (odd_j >= 0 && odd_k <= L - 1 && s.charAt(odd_j) == s.charAt(odd_k)) {
                String temp = s.substring(odd_j, odd_k + 1);
                if (temp.length() > result.length()) {
                    result = temp;
                }
                odd_j -= 1;
                odd_k += 1;
            }

            // second even length check, only when found two consecutuve identical
            int even_j = i;
            int even_k = i + 1;
            while (even_j >= 0 && even_k <= L - 1 && s.charAt(even_j) == s.charAt(even_k)) {
                String temp = s.substring(even_j, even_k + 1);
                if (temp.length() > result.length()) {
                    result = temp;
                }
                even_j -= 1;
                even_k += 1;
            }
        }
        return result;
    }

    //TODO: Practice Manacher's algorithm (Dynamic Programming)


    public static void main(String[] args) {
        LC005_Longest_Palindromic_Substring testCase = new LC005_Longest_Palindromic_Substring();

        assert testCase.longestPalindrome("").equals("") : "Edge 0";
        assert testCase.longestPalindrome("a").equals("a") : "Edge 2";
        assert testCase.longestPalindrome("aaa").equals("aaa") : "Edge 3";


        assert testCase.longestPalindrome("babad").equals("bab") : "Example 1";

        assert testCase.longestPalindrome("cbbd").equals("bb") : "Example 2";

        assert testCase.longestPalindrome("bababadddddddddddd").equals("dddddddddddd") : "Additional 1";

        assert testCase.longestPalindrome("babababa").equals("bababab") : "Additional 2";

        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        String b = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        assert testCase.longestPalindrome(a).equals(b) : "Long string";

        System.out.println("All passed");
    }
}

