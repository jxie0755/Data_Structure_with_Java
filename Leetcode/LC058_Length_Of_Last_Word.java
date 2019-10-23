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

    /**
     * Version B
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        int idx = s.length() - 1;
        while (idx >= 0) {
            char x = s.charAt(idx);
            if (x == ' ') {
                idx -= 1;
                if (count != 0) {
                    break;
                }
            } else {
                idx -= 1;
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        assert new LC058_Length_Of_Last_Word().lengthOfLastWord("") == 0 : "Edge 1";
        assert new LC058_Length_Of_Last_Word().lengthOfLastWord(" ") == 0 : "Edge 2";
        assert new LC058_Length_Of_Last_Word().lengthOfLastWord("Hello World") == 5 : "Regular";
        System.out.println("all passed");
    }
}

