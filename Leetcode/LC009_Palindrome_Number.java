/**
 * p009 Palindrome Number
 * Easy
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Negative integer will not be a palindrome
 */
public class LC009_Palindrome_Number {

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

        assert new LC009_Palindrome_Number().isPalindrome(21477412) : "Is palindrome even";
        assert new LC009_Palindrome_Number().isPalindrome(12321) : "Is palindrome odd";
        assert !new LC009_Palindrome_Number().isPalindrome(1477412) : "Not palindrome";
        assert new LC009_Palindrome_Number().isPalindrome(1) : "Single 1";
        assert new LC009_Palindrome_Number().isPalindrome(0) : "Single 0";

        System.out.println("all passed");

    }
}

