/**
 * https://leetcode.com/problems/multiply-strings/
 * P043 Multiply Strings
 * Medium
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * <p>
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LC043_Multiple_Strings {

    /**
     * Version B
     * HashMap method
     * Calulate string by hand calculation method, can avoid overflow of integer/long numbers
     */
    public String multiply(String num1, String num2) {

    }

    public static void main(String[] args) {
        assert new LC043_Multiple_Strings().multiply("0", "23").equals("0") : "Edge 1";
        assert new LC043_Multiple_Strings().multiply("2", "23").equals("46") : "Edge 2";
        assert new LC043_Multiple_Strings().multiply("2", "3").equals("6") : "Example 1";
        assert new LC043_Multiple_Strings().multiply("123", "457").equals("56088") : "Example 1";
        assert new LC043_Multiple_Strings().multiply("50", "50").equals("2500") : "Extra 1";

    }

}

