import java.util.regex.Pattern;

/**
 * https: // leetcode.com / problems / valid - palindrome /
 * LC125 Valid Palindrome
 * Easy
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
class LC125_Valid_Palindrome {

    /**
     * Version B
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        Pattern alnum = Pattern.compile("[A-Za-z0-9]");

        while (left < right) {
            while (left < right && !alnum.matcher("" + s.charAt(left)).matches()) {
                // use "" + char to make CharSequence
                left += 1;
            }
            while (left < right && !alnum.matcher("" + s.charAt(right)).matches()) {
                // use "" + char to make CharSequence
                right -= 1;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // ensure ignore case
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        LC125_Valid_Palindrome testCase = new LC125_Valid_Palindrome();

        assert testCase.isPalindrome("A man, a plan, a canal: Panama") : "Example 1";
        assert !testCase.isPalindrome("race a car") : "Example 2";
        System.out.println("All passed");
    }
}

