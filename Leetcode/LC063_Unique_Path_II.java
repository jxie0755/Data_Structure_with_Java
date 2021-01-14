/**
 * https://leetcode.com/problems/unique-paths-ii/
 * P063 Unique Paths II
 * Medium
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked "Finish" in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 */
class LC063_Unique_Path_II {

    /**
     * Similar idea from Leetcode 062 iteration method
     * when hitting an obstacle, meansing the path to this point is 0
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid[0].length; // length
        int n = obstacleGrid.length;    // width

        int[][] pathgrid = new int[n][m];

        for (int l = 0; l < n; l += 1) {
            for (int w = 0; w < m; w += 1) {
                if (obstacleGrid[l][w] == 1) {
                    pathgrid[l][w] = 0;
                } else if (l == 0 && w == 0) {  // 注意这里要把第一个点设定为1, 除非有障碍物
                    pathgrid[l][w] = 1;
                } else if (l == 0) {
                    pathgrid[l][w] = pathgrid[l][w - 1];
                } else if (w == 0) {
                    pathgrid[l][w] = pathgrid[l - 1][w];
                } else {
                    pathgrid[l][w] = pathgrid[l][w - 1] + pathgrid[l - 1][w];
                }
            }
        }

        return pathgrid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        LC063_Unique_Path_II testCase = new LC063_Unique_Path_II();

        int[][] e0 = new int[][]{
                {0}
        };
        assert testCase.uniquePathsWithObstacles(e0) == 1 : "Edge 1";

        int[][] e1 = new int[][]{
                {1}
        };
        assert testCase.uniquePathsWithObstacles(e1) == 0 : "Edge 2";

        int[][] e2 = new int[][]{
                {0, 0},
                {1, 0}
        };
        assert testCase.uniquePathsWithObstacles(e2) == 1 : "Edge 3";

        int[][] e3 = new int[][]{
                {1, 1}
        };
        assert testCase.uniquePathsWithObstacles(e3) == 0 : "Edge 4";

        int[][] e4 = new int[][]{
                {1, 0}
        };
        assert testCase.uniquePathsWithObstacles(e4) == 0 : "Edge 5";

        int[][] e5 = new int[][]{
                {0, 1},
                {0, 0}
        };
        assert testCase.uniquePathsWithObstacles(e5) == 1 : "Edge 6";


        int[][] s1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        assert testCase.uniquePathsWithObstacles(s1) == 2 : "Example 1";

        int[][] s2 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };
        assert testCase.uniquePathsWithObstacles(s2) == 7 : "Example 2";

        int[][] s3 = new int[][]{
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        assert testCase.uniquePathsWithObstacles(s3) == 0 : "Additional 1, all blocked";

        int[][] s4 = new int[][]{
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assert testCase.uniquePathsWithObstacles(s4) == 0 : "Additional 2, equal to 3 * 3 with no obstacle";

        System.out.println("All passed");

    }

}

