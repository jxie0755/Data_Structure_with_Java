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

    /**
     * Version C
     * Break down to add with manual method, with string add method
     * This can completely avoid overflow of integer/long numbers
     */
    public String multiply(String num1, String num2) {

        if (num1.equals("0")) {
            return "0";
        }

        String result = "0";

        int idx2 = num2.length() - 1;
        int factor = 0;
        while (idx2 >= 0) {
            String to_add = "0";
            int d2 = Character.getNumericValue(num2.charAt(idx2));

            for (int i = 0; i < d2; i += 1) {
                to_add = this.add(to_add, num1);
            }

            // to add补位0
            to_add += new String(new char[factor]).replace("\0", "0");

            // result相加本次乘法结果
            result = this.add(result, to_add);

            factor += 1;
            idx2 -= 1;
        }

        return result;
    }

    // Helper - version C
    // String "add" function
    private String add(String num1, String num2) {

        StringBuilder result = new StringBuilder();
        int add_on = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        while (idx1 >= 0 || idx2 >= 0) {

            int d1 = 0;
            int d2 = 0;

            if (idx1 >= 0) {
                d1 = Character.getNumericValue(num1.charAt(idx1));
            }

            if (idx2 >= 0) {
                d2 = Character.getNumericValue(num2.charAt(idx2));
            }

            int d_result = d1 + d2 + add_on;
            result.insert(0, d_result % 10);
            add_on = d_result / 10;

            idx1 -= 1;
            idx2 -= 1;
        }

        // 如果最后一次还要进位
        if (add_on != 0) {
            result.insert(0, add_on);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        assert new LC043_Multiple_Strings().multiply("0", "23").equals("0") : "Edge 1";
        assert new LC043_Multiple_Strings().multiply("2", "23").equals("46") : "Edge 2";
        assert new LC043_Multiple_Strings().multiply("2", "3").equals("6") : "Example 1";
        assert new LC043_Multiple_Strings().multiply("123", "456").equals("56088") : "Example 1";
        assert new LC043_Multiple_Strings().multiply("50", "50").equals("2500") : "Extra 1";
        System.out.println("all passed");
    }
}

