/**
 * https://leetcode.com/problems/powx-n/
 * P050 Pow(x, n)
 * Medium
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (x^n)
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class LC050_Pow_X_N {

    /**
     * Version B
     * 利用n每翻倍一次, 只是原数平方一次
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / this.myPow(x, -n);
        } else {
            double v = this.myPow(x, n / 2);
            if (n % 2 == 0) {
                return v * v;
            } else {
                return v * v * x;
            }
        }
    }

    public static void main(String[] args) {
        assert new LC050_Pow_X_N().myPow(2.00000, 10) == Math.pow(2.00000, 10) : "Example 1";
        assert new LC050_Pow_X_N().myPow(2.10000, 3) == Math.pow(2.10000, 3) : "Example 2";
        assert new LC050_Pow_X_N().myPow(2.00000, -2) == Math.pow(2.00000, -2) : "Example 3";
        assert new LC050_Pow_X_N().myPow(0.00001, 2147483647) == Math.pow(0.00001, 2147483647) : "Large 1";
        assert new LC050_Pow_X_N().myPow(2, -2147483648) == Math.pow(2, -2147483648) : "Large 2";
        System.out.println("all passed");
    }
}

