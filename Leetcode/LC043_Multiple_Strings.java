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
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LC043_Multiple_Strings {

    static Map<Integer, Character> hmp_n2s = new HashMap<>();

    static {
        hmp_n2s.put(0, '0');
        hmp_n2s.put(1, '1');
        hmp_n2s.put(2, '2');
        hmp_n2s.put(3, '3');
        hmp_n2s.put(4, '4');
        hmp_n2s.put(5, '5');
        hmp_n2s.put(6, '6');
        hmp_n2s.put(7, '7');
        hmp_n2s.put(8, '8');
        hmp_n2s.put(9, '9');
    }

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

    private String int2str(Integer num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, hmp_n2s.get(num % 10));
            num /= 10;
        }

        return result.toString();
    }

    /**
     * Version B2
     * HashMap method
     * Calulate string by hand calculation method, can avoid overflow of integer/long numbers
     * Avoid using integer calculation, direct return the String value
     */
    public String multiply(String num1, String num2) {

        // generate a reversed string of num1 and num2
        StringBuilder num1_r = new StringBuilder(num1);
        num1_r.reverse();
        StringBuilder num2_r = new StringBuilder(num2);
        num2_r.reverse();


        return "1";

    }

    public static void main(String[] args) {
        // assert new LC043_Multiple_Strings().multiply("0", "23").equals("0") : "Edge 1";
        // assert new LC043_Multiple_Strings().multiply("2", "23").equals("46") : "Edge 2";
        // assert new LC043_Multiple_Strings().multiply("2", "3").equals("6") : "Example 1";
        // assert new LC043_Multiple_Strings().multiply("123", "457").equals("56088") : "Example 1";
        // assert new LC043_Multiple_Strings().multiply("50", "50").equals("2500") : "Extra 1";

        new LC043_Multiple_Strings().multiply("123", "456");
    }

}

