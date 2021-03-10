import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * LC020 Valid Parentheses
 * Easy
 * <p>
 * Given a string containing just the characters "(", ")", "{", "}", "[" and "]", determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
class LC020_Valid_Parenthesis {

    // Static helper
    private static Map<String, Integer> OPEN_BRACKETS = new HashMap<>();
    static {
        OPEN_BRACKETS.put("(", 1);
        OPEN_BRACKETS.put("{", 2);
        OPEN_BRACKETS.put("[", 3);
    }

    private static Map<String, Integer> CLOSE_BRACKETS = new HashMap<>();
    static {
        CLOSE_BRACKETS.put(")", 1);
        CLOSE_BRACKETS.put("}", 2);
        CLOSE_BRACKETS.put("]", 3);
    }

    /**
     * Version A
     */
    public boolean isValid(String s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i += 1) {
            String cur = s.substring(i, i + 1);
            if (OPEN_BRACKETS.containsKey(cur)) {
                result.add(OPEN_BRACKETS.get(cur));
            } else if (CLOSE_BRACKETS.containsKey(cur)) {
                if (result.size() == 0) {
                    return false;
                }
                if (result.remove(result.size() - 1) != CLOSE_BRACKETS.get(cur)) {
                    return false;
                }
            }
        }
        return result.size() == 0;
    }

    public static void main(String[] args) {
        LC020_Valid_Parenthesis testCase = new LC020_Valid_Parenthesis();

        assert testCase.isValid("((5+3)*2+1)") : "simple";
        assert testCase.isValid("{[(3+1)+2]+}") : "Different types";
        assert !testCase.isValid("(3+{1-1)}") : ") is alone inside {}";
        assert testCase.isValid("[1+1]+(2*2)-{3/3}") : "Different operators";
        assert !testCase.isValid("(({[(((1)-2)+3)-3]/3}-3)") : "One is redundant";
        assert testCase.isValid("2+3") : "No brackets, no problem";

        System.out.println("All passed");

    }

}

