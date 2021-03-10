/**
 * https://leetcode.com/problems/reverse-integer/
 * LC007 Reverse Integer
 * Easy
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * The 32-bit int data type can hold integer values in the range of -2,147,483,648 to 2,147,483,647 ([-2^31, 2^31-1]).
 */
class LC007_Reverse_Integer {

    /**
     * Version A, use string method, time O(logN), takes extra space O(LogN)
     * This is not very fast as it convert types back and forth
     */
    // public int reverse(int x) {  // renamed
    //
    //     StringBuilder str_result = new StringBuilder();
    //     String current = String.valueOf(x);
    //
    //     Long ans;  // Handle the integer overflow by create ans number in Long first
    //
    //     if (x >= 0) {
    //         for (int i = current.length() - 1; i >= 0; i -= 1) {
    //             str_result.append(current.charAt(i));
    //         }
    //         ans = Long.valueOf(str_result.toString());  // Direct convert string to Long
    //
    //     } else {
    //         for (int i = current.length() - 1; i > 0; i -= 1) {
    //             str_result.append(current.charAt(i));
    //         }
    //         ans = Long.valueOf(str_result.toString()); // Direct convert string to Long
    //     }
    //
    //     if (ans <= 2147483647) {  // assure no overlfow integer
    //         if (x >= 0) {
    //             return ans.intValue();  // convert Long value back to int for return
    //         } else {
    //             return -1 * ans.intValue();
    //         }
    //     }
    //     return 0;
    // }


    /**
     * Version B, use math method
     */
    public int reverse(int x) {

        int absX = Math.abs(x);
        Long result = 0L;

        while (absX > 0) {
            result = result * 10 + absX % 10;
            absX /= 10;
        }

        if (x < 0) {
            result *= -1;
        }

        if (-2147483647 < result && result < 2147483647) {
            return result.intValue();
        }
        return 0;
    }


    public static void main(String[] args) {
        LC007_Reverse_Integer testCase = new LC007_Reverse_Integer();

        assert testCase.reverse(123) == 321 : "Regular";
        assert testCase.reverse(-120) == -21 : "Negative jump";
        assert testCase.reverse(1534236469) == 0 : "Exceed";
        assert testCase.reverse(0) == 0 : "Zero";
        System.out.println("All passed");

    }
}

