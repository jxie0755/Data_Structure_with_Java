/**
 * https://leetcode.com/problems/unique-paths/
 * P062 Unique Paths
 * Medium
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked "Start" in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked "Finish" in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */
class LC062_Unique_Path_A {

    /**
     * Version A, best direct math calculation, FAILED
     * This is the same as ProjectEuler p015 lattice paths
     * Use combination method: Combination pick r out of n : n! // r! // (n-r)!
     * 无法处理大数问题, 阶乘数大了之后, 溢出了int和long的范围
     * 除非使用string做计算再转换,这样太麻烦
     */
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        long result = factorial(total) / (factorial(total - (n - 1)) * factorial(n - 1));
        return (int) result;
    }

    /**
     * Helper: factorial calculation
     */
    private long factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }
}


public class LC062_Unique_Path {

    /**
     * Version B, use grid iteration
     * Get last grid value by adding the value of the neighbors from up and left
     * This can avoid large number factorial calculation
     */
    public int uniquePaths(int m, int n) {

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }

        return grid[n - 1][m - 1];
    }


    public static void main(String[] args) {
        assert new LC062_Unique_Path().uniquePaths(1, 1) == 1 : "Edge 1";
        assert new LC062_Unique_Path().uniquePaths(4, 1) == 1 : "Edge 2";
        assert new LC062_Unique_Path().uniquePaths(1, 4) == 1 : "Edge 3";

        assert new LC062_Unique_Path().uniquePaths(3, 2) == 3 : "Example 1";
        assert new LC062_Unique_Path().uniquePaths(7, 3) == 28 : "Example 2";
        assert new LC062_Unique_Path().uniquePaths(23, 12) == 193536720 : "Example 3, large number";
        System.out.println("all passed");
    }

}


