import java.util.HashMap;
import java.util.Map;

/**
 * P003 Longest Substring Without Repeating Characters
 * Medium
 *
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LC003_Longest_Substring_Without_Repeating_Characters {

    private static boolean is_no_repeat(String s) {
        Map<Character, Integer> hmp = new HashMap<>();
        for (Character i : s.toCharArray()) {
            if (hmp.containsKey(i)) {
                return false;
            }
            hmp.put(i, 1);
        }
        return true;
    }

    /**
     * Brutal force, will fail max time limit
     */
    public int lengthOfLongestSubstring_brutal(String s) {
        if (s == null) {
            return 0;
        }

        for (int L = s.length(); L > 0; L -= 1) {
            for (int i = 0; i < s.length() - L + 1; i += 1) {
                String sample = s.substring(i, i + L);
                if (is_no_repeat(sample)) {
                    return sample.length();
                }
            }
        }
        return 0;
    }

    /**
     * Time O(N^2), Space O(N)
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
            String sub = s.substring(i,i+1);
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

    // public int lengthOfLongestSubstring(String s) {
    //
    // }


    public static void main(String[] args) {
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("") == 0: "Edge 1";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(" ") == 1: "Edge 2";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("au") == 2: "Edge 3";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("aab") == 2: "Edge 4";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("dvdf") == 3: "Edge 5";

        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("abcabcbb") == 3: "Example 1: abc";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("bbbbb") == 1: "Example 2: b";
        assert new LC003_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("pwwkew") == 3: "Example 3: wke";

        System.out.println("all passed");


    }
}
