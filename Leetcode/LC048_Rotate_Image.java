import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * LC048 Roate Image
 * Medium
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * Do not return anything, modify matrix in-place instead.
 */
class LC048_Rotate_Image {


    /**
     * Version B
     * Direct change in-place, with circiles shrinking to the center
     */
    public void rotate(int[][] matrix) {

        int N = matrix.length;
        for (int row = 0; row < N / 2; row += 1) {
            for (int col = row; col < N - row - 1; col += 1) {
                int A = matrix[row][col];
                int B = matrix[col][N - row - 1];
                int C = matrix[N - row - 1][N - col - 1];
                int D = matrix[N - col - 1][row];

                matrix[col][N - row - 1] = A;
                matrix[N - row - 1][N - col - 1] = B;
                matrix[N - col - 1][row] = C;
                matrix[row][col] = D;
            }
        }
    }

    public static void main(String[] args) {
        LC048_Rotate_Image testCase = new LC048_Rotate_Image();

        int[][] E0 = {
                {}
        };
        testCase.rotate(E0);
        assert Arrays.deepEquals(E0, new int[][]{
                {}
        }) : "Edge 0";

        int[][] E1 = {
                {1}
        };
        testCase.rotate(E1);
        assert Arrays.deepEquals(E1, new int[][]{
                {1}
        }) : "Edge 1";

        int[][] Q1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        testCase.rotate(Q1);
        assert Arrays.deepEquals(Q1, new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }) : "Example 1";


        int[][] Q2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        testCase.rotate(Q2);
        assert Arrays.deepEquals(Q2, new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        }) : "Example 2";

        System.out.println("All passed");
    }
}

