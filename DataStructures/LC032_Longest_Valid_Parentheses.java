import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * LC020 Longest Valid Parentheses
 * Hard
 *
 * Given a string containing just the characters "(" and ")", find the length of the longest valid (well-formed) parentheses substring.
 */

public class LC032_Longest_Valid_Parentheses {

    /**
     * Version C, stack method
     */
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // translate the brackets into 1 and -1
        List<Integer> trans_data = new ArrayList<>(Arrays.asList());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                trans_data.add(1);
            } else {
                trans_data.add(-1);
            }
        }

        // while loop to merge pairs
        boolean merged = true;
        while (merged) {
            merged = false;
            List<Integer> stack = new ArrayList<>(Arrays.asList());
            List<Integer> new_trans_data = new ArrayList<>(Arrays.asList());

            for (int elem : trans_data) {
                if (elem == 1) {
                    if (stack.isEmpty()) {
                        stack.add(elem);
                    } else {
                        new_trans_data.addAll(stack);
                        stack.clear();
                        stack.add(elem);
                    }
                } else if (elem == -1) {
                    if (!stack.isEmpty() && stack.get(0) == 1) {
                        stack.add(elem);
                        if (stack.size() == 2) {
                            new_trans_data.add(2);
                        } else {
                            new_trans_data.add(stack.get(1) + 2);
                        }
                        stack.clear();
                        merged = true;
                    } else {
                        new_trans_data.addAll(stack);
                        stack.clear();
                        new_trans_data.add(elem);
                    }
                } else {
                    if (!stack.isEmpty() && stack.get(stack.size() - 1) > 1) {
                        stack.set(stack.size() - 1, stack.get(stack.size() - 1) + elem);
                    } else {
                        stack.add(elem);
                    }
                }
            }

            if (!stack.isEmpty()) {
                new_trans_data.addAll(stack);
            }
            trans_data = new_trans_data;

        }

        // return the max value only if max value >= 2, otherwise they are single brackets (-1 or 1)
        int ans = 0;
        for (int i : trans_data) {
            if (i > ans) {
                ans = i;
            }
        }
        if (ans >= 2) {
            return ans;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        LC032_Longest_Valid_Parentheses testCase = new LC032_Longest_Valid_Parentheses();

        assert testCase.longestValidParentheses("(()") == 2 : "Example 1, '()'";
        assert testCase.longestValidParentheses(")()())") == 4 : "Example 2, '()()'";
        assert testCase.longestValidParentheses("") == 0 : "Example 3, Edge 0";
        assert testCase.longestValidParentheses("(") == 0 : "Example 4, Edge 1";
        assert testCase.longestValidParentheses(")") == 0 : "Example 5, Edge 2";

        assert testCase.longestValidParentheses("()(()") == 2 : "Additional 1";
        assert testCase.longestValidParentheses("()(()()") == 4 : "Additional 2";
        assert testCase.longestValidParentheses("(()(((()") == 2 : "Additional 3";
        assert testCase.longestValidParentheses("(()((()))") == 8 : "Additional 4";
        assert testCase.longestValidParentheses("(((()())))") == 10 : "Additional 5";
        assert testCase.longestValidParentheses("))()((()(())())(") == 10 : "Additional 6";

        String long_str = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        assert testCase.longestValidParentheses(long_str) == 132 : "Additional 7, long, )(2(2((132((2(36";

        System.out.println("All passed");
    }
}

