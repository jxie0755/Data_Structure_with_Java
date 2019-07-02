public class LC007_Reverse_Integer {

    /**
     * Version A, use string method, time O(logN), takes extra space O(LogN)
     * This is not very fast as it convert types back and forth
     */
    public int reverse(int x) {

        StringBuilder result = new StringBuilder();
        String current = String.valueOf(x);

        Long ans;  // Handle the integer overflow by create ans number in Long first

        if (x >= 0) {
            for (int i = current.length() - 1; i >= 0; i -= 1) {
                result.append(current.charAt(i));
            }
            ans = Long.valueOf(result.toString());  // Direct convert string to Long

        } else {
            for (int i = current.length() - 1; i > 0; i -= 1) {
                result.append(current.charAt(i));
            }
            ans = Long.valueOf(result.toString()); // Direct convert string to Long
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




    public static void main(String[] args) {

        assert new LC007_Reverse_Integer().reverse(123) == 321: "Regular";
        assert new LC007_Reverse_Integer().reverse(-120) == -21: "Negative jump";
        assert new LC007_Reverse_Integer().reverse(1534236469) == 0: "Exceed";
        assert new LC007_Reverse_Integer().reverse(0) == 0: "Zero";
        System.out.println("all passed");

    }

}

