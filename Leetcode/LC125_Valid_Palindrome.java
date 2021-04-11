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

    public boolean isPalindrome(String s) {
        return true;
    }

    public static void main(String[] args) {
        LC125_Valid_Palindrome testCase = new LC125_Valid_Palindrome();

        assert testCase.isPalindrome("A man, a plan, a canal: Panama") : "Example 1";
        assert !testCase.isPalindrome("race a car") : "Example 2";
        System.out.println("All passed");
    }
}

