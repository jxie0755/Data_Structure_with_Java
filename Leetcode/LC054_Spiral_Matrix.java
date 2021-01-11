import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * P054 Spiral Matrix
 * Medium
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
class LC054_Spiral_Matrix {

    /**
     * Version B
     * Direct output, no buffer needed
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int top_idx = 0;
        int bot_idx = m - 1;
        int left_idx = 0;
        int right_idx = n - 1;

        while (top_idx <= bot_idx && left_idx <= right_idx) {

            for (int a = left_idx; a <= right_idx; a += 1) {
                result.add(matrix[top_idx][a]);
            }
            top_idx += 1;

            for (int b = top_idx; b <= bot_idx; b += 1) {
                result.add(matrix[b][right_idx]);
            }
            right_idx -= 1;

            if (top_idx <= bot_idx) {
                for (int c = right_idx; c >= left_idx; c -= 1) {
                    result.add(matrix[bot_idx][c]);
                }
            }
            bot_idx -= 1;

            if (left_idx <= right_idx) {
                for (int d = bot_idx; d >= top_idx; d -= 1) {
                    result.add(matrix[d][left_idx]);
                }
            }
            left_idx += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        LC054_Spiral_Matrix testCase = new LC054_Spiral_Matrix();
        int[][] q0 = {};
        List<Integer> a0 = new ArrayList<>(Arrays.asList());
        assert testCase.spiralOrder(q0).equals(a0) : "Edge 0";

        int[][] q1 = {{}};
        List<Integer> a1 = new ArrayList<>(Arrays.asList());
        assert testCase.spiralOrder(q1).equals(a1) : "Edge 1";

        int[][] q2 = {{1}};
        List<Integer> a2 = new ArrayList<>(Arrays.asList(1));
        assert testCase.spiralOrder(q2).equals(a2) : "Edge 2";

        int[][] q3 = {{1}, {2}};
        List<Integer> a3 = new ArrayList<>(Arrays.asList(1, 2));
        assert testCase.spiralOrder(q3).equals(a3) : "Edge 3";

        int[][] q4 = {{1, 2}};
        List<Integer> a4 = new ArrayList<>(Arrays.asList(1, 2));
        assert testCase.spiralOrder(q4).equals(a4) : "Edge 4";

        int[][] q5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> a5 = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assert testCase.spiralOrder(q5).equals(a5) : "Example 1";

        int[][] q6 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> a6 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        assert testCase.spiralOrder(q6).equals(a6) : "Example 2";

        int[][] q7 = {
                {1, 2},
                {3, 4},
        };
        List<Integer> a7 = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
        assert testCase.spiralOrder(q7).equals(a7) : "Example 2";

        int[][] q8 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> a8 = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 8, 7, 5, 3));
        assert testCase.spiralOrder(q8).equals(a8) : "Extra";

        System.out.println("All passed");
    }
}

