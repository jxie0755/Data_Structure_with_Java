public class LC007_Reverse_Integer {

    /**
     * Version A, use string method, time O(logN), takes extra space O(LogN)
     * This is not very fast as it convert types back and forth
     */
    public int reverse_string(int x) {  // renamed

        StringBuilder result_string = new StringBuilder();
        String current = String.valueOf(x);

        Long ans;  // Handle the integer overflow by create ans number in Long first

        if (x >= 0) {
            for (int i = current.length() - 1; i >= 0; i -= 1) {
                result_string.append(current.charAt(i));
            }
            ans = Long.valueOf(result_string.toString());  // Direct convert string to Long

        } else {
            for (int i = current.length() - 1; i > 0; i -= 1) {
                result_string.append(current.charAt(i));
            }
            ans = Long.valueOf(result_string.toString()); // Direct convert string to Long
        }

        if (ans <= 2147483647) {  // assure no overlfow integer
            if (x >= 0) {
                return ans.intValue();  // convert Long value back to int for return
            } else {
                return -1 * ans.intValue();
            }
        }
        return 0;
    }


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

        assert new LC007_Reverse_Integer().reverse(123) == 321 : "Regular";
        assert new LC007_Reverse_Integer().reverse(-120) == -21 : "Negative jump";
        assert new LC007_Reverse_Integer().reverse(1534236469) == 0 : "Exceed";
        assert new LC007_Reverse_Integer().reverse(0) == 0 : "Zero";
        System.out.println("all passed");

    }

}

