import java.util.Arrays;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * P059 Spiral Matrix II
 * Medium
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
class LC059_Spiral_Matrix_II {

    /**
     * Version A
     * Generate by keep changing the row and col in clock sequence
     */
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int val = 1;

        int top = 0;
        int bot = n - 1;
        int left = 0;
        int right = n - 1;

        while (val <= n*n) {

            if (val <= n * n) {
                for (int a = left; a <= right; a += 1) {
                    matrix[top][a] = val;
                    val += 1;
                }
                top += 1;
            }

            if (val <= n * n) {
                for (int b = top; b <= bot; b += 1) {
                    matrix[b][right] = val;
                    val += 1;
                }
                right -= 1;
            }

            if (val <= n * n) {
                for (int c = right; c >= left; c -= 1) {
                    matrix[bot][c] = val;
                    val += 1;
                }
                bot -= 1;
            }

            if (val <= n * n) {
                for (int d = bot; d >= top; d -= 1) {
                    matrix[d][left] = val;
                    val += 1;
                }
                left += 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        LC059_Spiral_Matrix_II testCase = new LC059_Spiral_Matrix_II();

        assert Arrays.deepEquals(testCase.generateMatrix(1), new int[][]{{1}}) : "Edge 1";

        assert Arrays.deepEquals(testCase.generateMatrix(3), new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        }) : "Example 1";

        assert Arrays.deepEquals(testCase.generateMatrix(2), new int[][]{
                {1, 2},
                {4, 3},
        }) : "Extra 1";

        assert Arrays.deepEquals(testCase.generateMatrix(4), new int[][]{
                {1,  2,  3,  4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9,  8,  7}

        }) : "Example 1";

        System.out.println("all passed");
    }
}

