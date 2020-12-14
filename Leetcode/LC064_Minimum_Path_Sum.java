/**
 * https://leetcode.com/problems/minimum-path-sum/
 * P064 Minimum Path Sum
 * Medium
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 */
class LC064_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int mm = 0; mm < m; mm += 1) {
            for (int nn = 0; nn < n; nn += 1) {
                if (nn == 0 && mm == 0) {
                    grid[mm][nn] += 0;
                } else if (mm == 0) {
                    grid[mm][nn] += grid[mm][nn - 1];
                } else if (nn == 0) {
                    grid[mm][nn] += grid[mm - 1][nn];
                } else {
                    grid[mm][nn] += Math.min(grid[mm][nn - 1], grid[mm - 1][nn]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LC064_Minimum_Path_Sum testCase = new LC064_Minimum_Path_Sum();
        int[][] e1 = new int[][]{
                {}
        };
        assert testCase.minPathSum(e1) == 0 : "Edge 1";

        int[][] e2 = new int[][]{
                {1}
        };
        assert testCase.minPathSum(e2) == 1 : "Edge 2";

        int[][] e3 = new int[][]{
                {1, 1}
        };
        assert testCase.minPathSum(e3) == 2 : "Edge 3";

        int[][] e4 = new int[][]{
                {1},
                {1}
        };
        assert testCase.minPathSum(e4) == 2 : "Edge 4";

        int[][] s1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assert testCase.minPathSum(s1) == 7 : "Example 1";

        System.out.println("all passed");
    }

}

