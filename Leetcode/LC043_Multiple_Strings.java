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
class LC043_Multiple_Strings {

    /**
     * Version D
     * Manual multiply calculations with two helpers
     * 1. Add: Any two numbers in str
     * 2. Multiply: Two numbers in str, one to be single digit
     */
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int lead = 0;
        String result = "";
        int i = num1.length() - 1;
        while (i >= 0) {
            Character digit = num1.charAt(i);
            String mult = this.str_multiply(num2, digit);
            for (int x = 0; x < lead; x += 1) { // java String can't use "*" like python
                mult += "0";
            }
            result = this.str_add(result, mult);
            lead += 1;
            i -= 1;
        }
        return result;

    }

    /**
     * Helper D1: Add two str numbers
     */
    private String str_add(String num1, String num2) {

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

    /**
     * Helper D2: Any str number * single digit str number
     */
    private String str_multiply(String num1, Character num2) {
        StringBuilder result = new StringBuilder();
        int add_on = 0;
        int i = num1.length() - 1;
        while (i >= 0) {
            char digit = num1.charAt(i);
            int d_result = Character.getNumericValue(digit) * Character.getNumericValue(num2) + add_on;
            result.insert(0, d_result % 10);
            add_on = d_result / 10;
            i -= 1;
        }

        if (add_on != 0) {
            result.insert(0, add_on);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        LC043_Multiple_Strings testCase = new LC043_Multiple_Strings();
        assert testCase.multiply("0", "23").equals("0") : "Edge 1";
        assert testCase.multiply("999", "0").equals("0") : "Extra Edge 1";
        assert testCase.multiply("2", "23").equals("46") : "Edge 2";

        assert testCase.multiply("2", "3").equals("6") : "Example 1";
        assert testCase.multiply("123", "456").equals("56088") : "Example 1";
        assert testCase.multiply("50", "50").equals("2500") : "Extra 1";

        System.out.println("all passed");
    }
}

