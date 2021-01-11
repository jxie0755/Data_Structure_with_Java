import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * P060 Permutation Sequence
 * Medium
 * <p>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * <p>
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 */
class LC060_Permutation_Sequence {

    /**
     * Helper to calculate factorial of an integer....
     */
    private Integer factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Version C1
     * Direct generation, digit by digit
     * 这里利用的是每一位数字, 都会因为后面位数的总排列数为循环发生变化, 从小到大发展
     */
    public String getPermutation(int n, int k) {

        // prepare the candidates
        List<Integer> perm = new ArrayList<>();
        for (int i = 1; i <= n; i += 1) {
            perm.add(i);
        }

        String result = "";
        k = k - 1;

        for (int i = n - 1; i >= 0; i -= 1) {
            int fact = this.factorial(i);
            int curr = perm.remove(k / fact);
            result += String.valueOf(curr);
            k %= fact;
        }

        return result;
    }

    public static void main(String[] args) {
        LC060_Permutation_Sequence testCase = new LC060_Permutation_Sequence();
        assert testCase.getPermutation(4, 1).equals("1234") : "Edge 1";
        assert testCase.getPermutation(3, 3).equals("213") : "Example 1";
        assert testCase.getPermutation(4, 9).equals("2314") : "Example 2";
        assert testCase.getPermutation(8, 29805).equals("68327415") : "Long 1";
        assert testCase.getPermutation(9, 62716).equals("265183794") : "Long 2";
        System.out.println("All passed");
    }

}

