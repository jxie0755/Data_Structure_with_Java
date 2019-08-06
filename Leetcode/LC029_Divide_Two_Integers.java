/**
 * https://leetcode.com/problems/divide-two-integers/
 * P029 Divide Two Integers
 * Medium
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
public class LC029_Divide_Two_Integers {

    /**
     * Version A, integer method
     * 考虑到Integer溢出的问题, 所有数字类型都用long或者转成long,然后最后结果转回int
     */
    public int divide(int dividend, int divisor) {

        long result = 0;
        long son = Math.abs((long) dividend);
        long mom = Math.abs((long) divisor);

        while (son != 0 && son >= mom) {
            long[] temp = this.manual_divide(son, mom);
            long temp_result = temp[0];
            son = temp[1];
            result += temp_result;
        }


        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            result *= -1;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    // Helper - version A
    // To achive log(n) division by doubling mom, before son > mom
    // Mom and Son are both non-negative integers
    private long[] manual_divide(long son, long mom) {
        long ans = 1;
        while (son - mom > mom) {
            mom += mom;
            ans += ans;
        }
        long new_son = son - mom;
        return new long[]{ans, new_son};
    }

    public static void main(String[] args) {

        assert new LC029_Divide_Two_Integers().divide(1, 3) == 0 : "Edge 1";

        assert new LC029_Divide_Two_Integers().divide(10, 3) == 3 : "Example 1";
        assert new LC029_Divide_Two_Integers().divide(7, -3) == -2 : "Example 2";
        assert new LC029_Divide_Two_Integers().divide(1, 1) == 1 : "Example 3";

        assert new LC029_Divide_Two_Integers().divide(-2147483648, 1) == -2147483648 : "Edge 2";
        assert new LC029_Divide_Two_Integers().divide(-2147483648, -1) == 2147483647 : "Edge 3";

        System.out.println("all passed");
    }

}

