/**
 * p020 Valid Parentheses
 * Easy
 *
 * Given a string containing just the characters "(", ")", "{", "}", "[" and "]", determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class LC020_Valid_Parenthesis {

    /**
     * Version A
     */
    public boolean isValid(String s) {

    }

    public static void main(String[] args) {

        assert new LC020_Valid_Parenthesis().isValid("((5+3)*2+1)") : "simple";
        assert new LC020_Valid_Parenthesis().isValid("{[(3+1)+2]+}") : "Different types";
        assert ! new LC020_Valid_Parenthesis().isValid("(3+{1-1)}"): ") is alone inside {}";
        assert new LC020_Valid_Parenthesis().isValid("[1+1]+(2*2)-{3/3}"): "Different operators";
        assert ! new LC020_Valid_Parenthesis().isValid("(({[(((1)-2)+3)-3]/3}-3)"): "One is redundant";
        assert new LC020_Valid_Parenthesis().isValid("2+3"): "No brackets, no problem";

        System.out.println("all passed");

    }

}

