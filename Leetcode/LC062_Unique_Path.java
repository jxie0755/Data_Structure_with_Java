import java.util.*;

/**
 * https://leetcode.com/problems/unique-paths/
 * LC062 Unique Paths
 * Medium
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked "Start" in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked "Finish" in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */


class LC062_Unique_Path {

    /**
     * Version A, best direct math calculation, FAILED
     * This is the same as ProjectEuler LC015 lattice paths
     * Use combination method: Combination pick r out of n : n! // r! // (n-r)!
     * 无法处理大数问题, 阶乘数大了之后, 溢出了int和long的范围
     * 除非使用string做计算再转换,这样太麻烦
     */
    // public int uniquePaths(int m, int n) {
    //     int total = m + n - 2;
    //     long result = factorial(total) / (factorial(total - (n - 1)) * factorial(n - 1));
    //     return (int) result;
    // }
    //
    // /**
    //  * Helper: factorial calculation
    //  */
    // private long factorial(int x) {
    //     if (x == 0) {
    //         return 1;
    //     } else {
    //         return x * factorial(x - 1);
    //     }
    // }


    /**
     * Version B, recursive method with hashmap memorizaton
     * Apply in java, keep the hashmap as a class attribute
     */
    Map<List<Integer>, Integer> HMP = new HashMap<>();

    public int uniquePaths(int m, int n) {

        List<Integer> pair = new ArrayList<>(Arrays.asList(m, n));
        if (m == 1 || n == 1) {
            return 1;
        } else if (HMP.containsKey(pair)) {
            return HMP.get(pair);
        } else {
            int result = this.uniquePaths(m - 1, n) + this.uniquePaths(m, n - 1);
            HMP.put(pair, result);
            return result;
        }
    }


    /**
     * Version C, use grid iteration
     * Get last grid value by adding the value of the neighbors from up and left
     * This can avoid large number factorial calculation
     */
    // public int uniquePaths(int m, int n) {
    //
    //     int[][] grid = new int[n][m];
    //     for (int i = 0; i < n; i += 1) {
    //         for (int j = 0; j < m; j += 1) {
    //             if (i == 0 || j == 0) {
    //                 grid[i][j] = 1;
    //             } else {
    //                 grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
    //             }
    //         }
    //     }
    //     return grid[n - 1][m - 1];
    // }


    public static void main(String[] args) {
        LC062_Unique_Path testCase = new LC062_Unique_Path();
        assert testCase.uniquePaths(1, 1) == 1 : "Edge 1";
        assert testCase.uniquePaths(4, 1) == 1 : "Edge 2";
        assert testCase.uniquePaths(1, 4) == 1 : "Edge 3";

        assert testCase.uniquePaths(3, 2) == 3 : "Example 1";
        assert testCase.uniquePaths(7, 3) == 28 : "Example 2";
        assert testCase.uniquePaths(23, 12) == 193536720 : "Example 3, large number";

        System.out.println("All passed");
    }
}


