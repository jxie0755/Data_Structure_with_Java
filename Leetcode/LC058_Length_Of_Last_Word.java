import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * p058 Length of Last word
 * Easy
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters " ", return the length of last word in the string.
 * If the last word does not exist, return 0
 * <p>
 * Note:
 * A word is defined as a character sequence consists of non-space characters only.
 */
class LC058_Length_Of_Last_Word {

    // /**
    //  * Version B
    //  */
    // public int lengthOfLastWord(String s) {
    //     int count = 0;
    //     for (int idx = s.length()-1; idx >= 0; idx -=1) {
    //         char x = s.charAt(idx);
    //         if (x == ' ') {
    //             if (count != 0) {
    //                 break;
    //             }
    //         } else {
    //             count += 1;
    //         }
    //     }
    //     return count;
    // }

    /**
     * Version C
     * Regex method
     */
    public int lengthOfLastWord(String s) {
        Pattern p = Pattern.compile("(.*\\s+?|\\s*)([A-Za-z]*\\b)");
        Matcher m = p.matcher(s);

        if (m.find()) {
            String ans = m.group(2);
            return ans.length();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LC058_Length_Of_Last_Word testCase = new LC058_Length_Of_Last_Word();
        assert testCase.lengthOfLastWord("") == 0 : "Edge 1";
        assert testCase.lengthOfLastWord(" ") == 0 : "Edge 2";

        assert testCase.lengthOfLastWord("Hello World") == 5 : "Regular";

        assert testCase.lengthOfLastWord("Today is a nice day") == 3 : "Extra 1";
        assert testCase.lengthOfLastWord("a") == 1 : "Extra 2";
        assert testCase.lengthOfLastWord(" a") == 1 : "Extra 3";
        assert testCase.lengthOfLastWord("  a") == 1 : "Extra 4";
        assert testCase.lengthOfLastWord("  aaaa   ") == 4 : "Extra 5";

        System.out.println("all passed");
    }
}

