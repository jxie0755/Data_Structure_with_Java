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

