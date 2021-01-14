import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * P073 Set Matrix Zeroes
 * Medium
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 */
class LC073_Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix[0].length;
        int n = matrix.length;
        List<List<Integer>> coor_list = new ArrayList<>(Arrays.asList());

        for (int nn = 0; nn < n; nn += 1) {
            for (int mm = 0; mm < m; mm += 1) {
                if (matrix[nn][mm] == 0) {
                    coor_list.add(new ArrayList<>(Arrays.asList(nn, mm)));
                }
            }
        }

        for (List<Integer> coor : coor_list) {
            int x = coor.get(0);
            int y = coor.get(1);
            for (int i = 0; i < m; i += 1) {
                matrix[x][i] = 0;
            }
            for (int nn = 0; nn < n; nn += 1) {
                matrix[nn][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LC073_Set_Matrix_Zeroes testCase = new LC073_Set_Matrix_Zeroes();

        int[][] e1 = new int[][]{{}};
        testCase.setZeroes(e1);
        assert Arrays.deepEquals(e1, new int[][]{{}}) : "Edge 0";

        int[][] e2 = new int[][]{{1}};
        testCase.setZeroes(e2);
        assert Arrays.deepEquals(e2, new int[][]{{1}}) : "Edge 2";

        int[][] e3 = new int[][]{{0}};
        testCase.setZeroes(e3);
        assert Arrays.deepEquals(e3, new int[][]{{0}}) : "Edge 3";

        int[][] e4 = new int[][]{{0}, {1}};
        testCase.setZeroes(e4);
        assert Arrays.deepEquals(e4, new int[][]{{0}, {0}}) : "Edge 4";

        int[][] e5 = new int[][]{{0, 1}};
        testCase.setZeroes(e5);
        assert Arrays.deepEquals(e5, new int[][]{{0, 0}}) : "Edge 5";

        int[][] s1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        testCase.setZeroes(s1);
        assert Arrays.deepEquals(s1, new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }) : "Example 1";

        int[][] s2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        testCase.setZeroes(s2);
        assert Arrays.deepEquals(s2, new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        }) : "Example 2";

        System.out.println("All passed");
    }
}

