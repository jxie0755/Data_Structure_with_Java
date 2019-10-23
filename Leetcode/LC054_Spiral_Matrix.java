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

        int top = 0;
        int bot = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bot && left <= right) {

            int a = left;
            while (a <= right) {
                result.add(matrix[top][a]);
                a += 1;
            }
            top += 1;

            int b = top;
            while (b <= bot) {
                result.add(matrix[b][right]);
                b += 1;
            }
            right -= 1;

            int c = right;
            while (c >= left) {
                if (top <= bot) {
                    result.add(matrix[bot][c]);
                }
                c -= 1;
            }
            bot -= 1;

            int d = bot;
            while (d >= top) {
                if (left <= right) {
                    result.add(matrix[d][left]);
                }
                d -= 1;
            }
            left += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] q0 = {};
        List<Integer> a0 = new ArrayList<>(Arrays.asList());
        assert new LC054_Spiral_Matrix().spiralOrder(q0).equals(a0) : "Edge 0";

        int[][] q1 = {{}};
        List<Integer> a1 = new ArrayList<>(Arrays.asList());
        assert new LC054_Spiral_Matrix().spiralOrder(q1).equals(a1) : "Edge 1";

        int[][] q2 = {{1}};
        List<Integer> a2 = new ArrayList<>(Arrays.asList(1));
        assert new LC054_Spiral_Matrix().spiralOrder(q2).equals(a2) : "Edge 2";

        int[][] q3 = {{1}, {2}};
        List<Integer> a3 = new ArrayList<>(Arrays.asList(1, 2));
        assert new LC054_Spiral_Matrix().spiralOrder(q3).equals(a3) : "Edge 3";

        int[][] q4 = {{1, 2}};
        List<Integer> a4 = new ArrayList<>(Arrays.asList(1, 2));
        assert new LC054_Spiral_Matrix().spiralOrder(q4).equals(a4) : "Edge 4";

        int[][] q5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> a5 = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        assert new LC054_Spiral_Matrix().spiralOrder(q5).equals(a5) : "Example 1";

        int[][] q6 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> a6 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        assert new LC054_Spiral_Matrix().spiralOrder(q6).equals(a6) : "Example 2";

        int[][] q7 = {
                {1, 2},
                {3, 4},
        };
        List<Integer> a7 = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
        assert new LC054_Spiral_Matrix().spiralOrder(q7).equals(a7) : "Example 2";

        System.out.println("all passed");


    }
}

