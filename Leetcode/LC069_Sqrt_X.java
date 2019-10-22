/**
 * https://leetcode.com/problems/sqrtx/
 * p069 Sqrt(x)
 * Easy
 * <p>
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
public class LC069_Sqrt_X {

    /**
     * Version A2
     * Modified binary search
     * Be careful with the long number x
     */
    public int mySqrt(int x) {
        long low = 1;
        long high = x;

        while (true) {
            long mid = (low + high) / 2;
            System.out.println(mid);
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }

    public static void main(String[] args) {
        assert new LC069_Sqrt_X().mySqrt(0) == 0 : "Zero";
        assert new LC069_Sqrt_X().mySqrt(1) == 1 : "One";
        assert new LC069_Sqrt_X().mySqrt(4) == 2 : "Four";
        assert new LC069_Sqrt_X().mySqrt(8) == 2 : "EIGHT";
        assert new LC069_Sqrt_X().mySqrt(36) == 6 : "THIRTY SIX";
        // assert new LC069_Sqrt_X().mySqrt(2147395601) == 46340 : "Long";
        System.out.println("all passed");
    }

}

