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
     * Additional: set the number of path at the obstacle to be 0
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;

        int[][] pathgrid = new int[row][col];

        for (int row_num = 0; row_num < row; row_num += 1) {
            for (int col_num = 0; col_num < col; col_num += 1) {
                if (obstacleGrid[row_num][col_num] == 1) {
                    pathgrid[row_num][col_num] = 0;
                } else if (row_num == 0 && col_num == 0) {  // 注意这里要把第一个点设定为1, 除非有障碍物
                    pathgrid[row_num][col_num] = 1;
                } else if (row_num == 0) {
                    pathgrid[row_num][col_num] = pathgrid[row_num][col_num - 1];
                } else if (col_num == 0) {
                    pathgrid[row_num][col_num] = pathgrid[row_num - 1][col_num];
                } else {
                    pathgrid[row_num][col_num] = pathgrid[row_num][col_num - 1] + pathgrid[row_num - 1][col_num];
                }
            }
        }

        return pathgrid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        LC063_Unique_Path_II testCase = new LC063_Unique_Path_II();

        int[][] e0 = new int[][]{
                {0}
        };
        assert testCase.uniquePathsWithObstacles(e0) == 1 : "Edge 0";

        int[][] e1 = new int[][]{
                {1}
        };
        assert testCase.uniquePathsWithObstacles(e1) == 0 : "Edge 1";

        int[][] e2 = new int[][]{
                {0, 0},
                {1, 0}
        };
        assert testCase.uniquePathsWithObstacles(e2) == 1 : "Edge 2";

        int[][] e3 = new int[][]{
                {1, 1}
        };
        assert testCase.uniquePathsWithObstacles(e3) == 0 : "Edge 3";

        int[][] e4 = new int[][]{
                {1, 0}
        };
        assert testCase.uniquePathsWithObstacles(e4) == 0 : "Edge 4";

        int[][] e5 = new int[][]{
                {0, 1},
                {0, 0}
        };
        assert testCase.uniquePathsWithObstacles(e5) == 1 : "Edge 5";


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

        System.out.println("all passed");

    }

}

