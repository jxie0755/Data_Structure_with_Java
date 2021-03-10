import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * LC022 Generate Parentheses
 * Medium
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class LC022_Generate_Parenthesis {

    /**
     * STD ans, recursive
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        return generateP_Helper("", n, n, result);
    }

    // Helper - std ans
    private static List<String> generateP_Helper(String p, int left, int right, List<String> parens) {
        if (left != 0) {
            generateP_Helper(p + "(", left - 1, right, parens);
        }
        if (right > left) {
            generateP_Helper(p + ")", left, right - 1, parens);
        }
        if (right == 0) {
            parens.add(p);
        }
        return parens;
    }


    public static void main(String[] args) {
        LC022_Generate_Parenthesis testCase = new LC022_Generate_Parenthesis();

        List<String> a1 = new ArrayList<>(Arrays.asList("()"));
        assert testCase.generateParenthesis(1).equals(a1) : "Edge 1";

        List<String> a2 = new ArrayList<>(Arrays.asList("(())", "()()"));
        assert testCase.generateParenthesis(2).equals(a2) : "2 pairs";

        List<String> a3 = new ArrayList<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
        assert testCase.generateParenthesis(3).equals(a3) : "3 pairs";

        List<String> a4 = new ArrayList<>(Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
        assert testCase.generateParenthesis(4).equals(a4) : "4 pairs";

        System.out.println("All passed");
    }

}

