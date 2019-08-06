import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/multiply-strings/
 * P043 Multiply Strings
 * Medium
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * <p>
 * Note:
 * The length of both num1 and num2 is < 110. (Direct math calculation will overflow the number 32/64 bit)
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LC043_Multiple_Strings {

    static Map<Character, Integer> hmp_s2n = new HashMap<>();

    static {
        hmp_s2n.put('0', 0);
        hmp_s2n.put('1', 1);
        hmp_s2n.put('2', 2);
        hmp_s2n.put('3', 3);
        hmp_s2n.put('4', 4);
        hmp_s2n.put('5', 5);
        hmp_s2n.put('6', 6);
        hmp_s2n.put('7', 7);
        hmp_s2n.put('8', 8);
        hmp_s2n.put('9', 9);
    }


    /**
     * Version C
     * HashMap method
     * Break down to add with manual method
     * This can completely avoid overflow of integer/long numbers
     */
    public String multiply(String num1, String num2) {

        return "1";

    }

    public static void main(String[] args) {
        // assert new LC043_Multiple_Strings().multiply("0", "23").equals("0") : "Edge 1";
        // assert new LC043_Multiple_Strings().multiply("2", "23").equals("46") : "Edge 2";
        // assert new LC043_Multiple_Strings().multiply("2", "3").equals("6") : "Example 1";
        // assert new LC043_Multiple_Strings().multiply("123", "457").equals("56088") : "Example 1";
        // assert new LC043_Multiple_Strings().multiply("50", "50").equals("2500") : "Extra 1";

        System.out.println(new LC043_Multiple_Strings().multiply("11111111111111", "11111111111"));
    }

}

