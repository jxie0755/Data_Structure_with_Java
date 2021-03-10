/**
 * https://leetcode.com/problems/add-binary/
 * LC067 Add Binary
 * Easy
 * <p>
 * Given two binary strings, return their sum (also a binary string)
 */
class LC067_Add_Binary {

    /**
     * Version C
     * Use the same logic of binary add calculation
     */
    public String addBinary(String a, String b) {

        int carry = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder muta_a = new StringBuilder(a);
        StringBuilder muta_b = new StringBuilder(b);

        while (muta_a.length() > 0 || muta_b.length() > 0) {
            int a_end;
            int b_end;

            if (muta_a.length() != 0) {
                a_end = Character.getNumericValue(muta_a.charAt(muta_a.length() - 1));
                muta_a.setLength(muta_a.length() - 1); // like .pop(), remove the last character
            } else {
                a_end = 0;
            }

            if (muta_b.length() != 0) {
                b_end = Character.getNumericValue(muta_b.charAt(muta_b.length() - 1));
                muta_b.setLength(muta_b.length() - 1);
            } else {
                b_end = 0;
            }

            int tmp_sum = a_end + b_end + carry;
            carry = tmp_sum / 2;
            int tmp_digit = tmp_sum % 2;
            result.insert(0, String.valueOf(tmp_digit));

        }

        if (carry == 1) {
            result.insert(0, "1");
        }

        return result.toString();
    }


    public static void main(String[] args) {
        LC067_Add_Binary testCase = new LC067_Add_Binary();
        assert testCase.addBinary("0", "0").equals("0") : "Zero";
        assert testCase.addBinary("11", "1").equals("100") : "Example 1";
        assert testCase.addBinary("1010", "1011").equals("10101") : "Example 2";
        assert testCase.addBinary("111", "1").equals("1000") : "Additional 1";
        System.out.println("All passed");
    }
}

