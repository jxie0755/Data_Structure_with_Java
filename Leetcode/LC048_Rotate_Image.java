import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * P048 Roate Image
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
        for (int i = 0; i < N / 2; i += 1) {
            for (int j = i; j < N - i - 1; j += 1) {
                int A = matrix[i][j];
                int B = matrix[j][N - i - 1];
                int C = matrix[N - i - 1][N - j - 1];
                int D = matrix[N - j - 1][i];

                matrix[j][N - i - 1] = A;
                matrix[N - i - 1][N - j - 1] = B;
                matrix[N - j - 1][i] = C;
                matrix[i][j] = D;
            }
        }
    }

    public static void main(String[] args) {
        int[][] q1 = {
                {1}
        };
        new LC048_Rotate_Image().rotate(q1);
        assert Arrays.deepEquals(q1, new int[][]{

                {1}
        }) : "Edge 1";


        int[][] q2 = {
                {}
        };
        new LC048_Rotate_Image().rotate(q2);
        assert Arrays.deepEquals(q2, new int[][]{
                {}
        }) : "Edge 2";


        int[][] q3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new LC048_Rotate_Image().rotate(q3);
        assert Arrays.deepEquals(q3, new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }) : "Example 1";


        int[][] q4 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new LC048_Rotate_Image().rotate(q4);
        assert Arrays.deepEquals(q4, new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        }) : "Example 2";

        System.out.println("all passed");

    }

}

