/**
 * https://leetcode.com/problems/palindrome-number/
 * p009 Palindrome Number
 * Easy
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Negative integer will not be a palindrome
 */
class LC009_Palindrome_Number {

    /**
     * Version B, divmod method
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int copy = x;
        int reverse = 0;
        while (copy > 0) {
            reverse = reverse * 10 + copy % 10;
            copy /= 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        LC009_Palindrome_Number testCase = new LC009_Palindrome_Number();

        assert testCase.isPalindrome(21477412) : "Is palindrome even";
        assert testCase.isPalindrome(12321) : "Is palindrome odd";
        assert !testCase.isPalindrome(1477412) : "Not palindrome";
        assert testCase.isPalindrome(1) : "Single 1";
        assert testCase.isPalindrome(0) : "Single 0";

        System.out.println("all passed");

    }
}

