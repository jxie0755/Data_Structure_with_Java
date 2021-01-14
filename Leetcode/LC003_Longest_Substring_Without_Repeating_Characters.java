import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * P003 Longest Substring Without Repeating Characters
 * Medium
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
class LC003_Longest_Substring_Without_Repeating_Characters {

    /**
     * Version A
     * Brutal force, will fail max time limit
     */
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null) {
    //         return 0;
    //     }
    //
    //     for (int L = s.length(); L > 0; L -= 1) {
    //         for (int i = 0; i < s.length() - L + 1; i += 1) {
    //             String sample = s.substring(i, i + L);
    //             if (is_no_repeat(sample)) {
    //                 return sample.length();
    //             }
    //         }
    //     }
    //     return 0;
    // }
    //
    // // Helper - version A
    // private static boolean is_no_repeat(String s) {
    //     Map<Character, Integer> hmp = new HashMap<>();
    //     for (Character i : s.toCharArray()) {
    //         if (hmp.containsKey(i)) {
    //             return false;
    //         }
    //         hmp.put(i, 1);
    //     }
    //     return true;
    // }

    /**
     * Version C1, Time O(N^2), Space O(N)
     * Recursive
     * Find repeating element and start again after the first repeating element
     * This wil pass, but may reach maximum recursion depth in long cases
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }

        Map<String, Integer> hmp = new HashMap<>();
        int i = 0;
        while (i != s.length()) {
            String sub = s.substring(i, i + 1);
            if (!hmp.containsKey(sub)) {
                hmp.put(sub, i);
            } else {
                int new_start = hmp.get(sub) + 1;
                return Math.max(i, lengthOfLongestSubstring(s.substring(new_start)));
            }
            i += 1;
        }
        return s.length();
    }


    public static void main(String[] args) {
        LC003_Longest_Substring_Without_Repeating_Characters testCase = new LC003_Longest_Substring_Without_Repeating_Characters();
        assert testCase.lengthOfLongestSubstring("") == 0 : "Edge 0";
        assert testCase.lengthOfLongestSubstring(" ") == 1 : "Edge 2";
        assert testCase.lengthOfLongestSubstring("au") == 2 : "Edge 3";
        assert testCase.lengthOfLongestSubstring("aab") == 2 : "Edge 4";
        assert testCase.lengthOfLongestSubstring("dvdf") == 3 : "Edge 5";

        assert testCase.lengthOfLongestSubstring("abcabcbb") == 3 : "Example 1: abc";
        assert testCase.lengthOfLongestSubstring("bbbbb") == 1 : "Example 2: b";
        assert testCase.lengthOfLongestSubstring("pwwkew") == 3 : "Example 3: wke";

        System.out.println("All passed");
    }
}

