/**
 * https://leetcode.com/problems/sqrtx/
 * p069 Sqrt(x)
 * Easy
 * <p>
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
class LC069_Sqrt_X {

    /**
     * Version A2
     * Modified binary search
     * Be careful with the long number x
     */
    public int mySqrt(int x) {
        long lo = 0;
        long hi = x;

        while (true) {
            long mid = (lo + hi) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else {
                if (mid * mid < x) {
                    lo = mid + 1;
                }
                if (mid * mid > x) {
                    hi = mid - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        LC069_Sqrt_X testCase = new LC069_Sqrt_X();
        assert testCase.mySqrt(0) == 0 : "Zero";
        assert testCase.mySqrt(1) == 1 : "One";
        assert testCase.mySqrt(4) == 2 : "Four";
        assert testCase.mySqrt(8) == 2 : "EIGHT";
        assert testCase.mySqrt(36) == 6 : "THIRTY SIX";
        assert testCase.mySqrt(2147395601) == 46340 : "Long";
        System.out.println("all passed");
    }

}

