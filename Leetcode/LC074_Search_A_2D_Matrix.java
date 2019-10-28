/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * P074 Search a 2D Matrix
 * Medium
 * <p>
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
class LC074_Search_A_2D_Matrix {

    /**
     * Version B
     * Direct binary search on the grid, without flatten
     * Need to do two binary search
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row_lo = 0;
        int row_hi = matrix.length - 1;
        int col_lo = 0;
        int col_hi = matrix[0].length - 1;
        int row_mid = 0;

        while (row_lo <= row_hi) {
            row_mid = (row_lo + row_hi) / 2;
            int row_head = matrix[row_mid][0];
            int row_tail = matrix[row_mid][matrix[0].length - 1];

            if (row_head <= target && target <= row_tail) {
                break;
            } else if (target < row_head) {
                row_hi = row_mid - 1;
            } else {
                row_lo = row_mid + 1;
            }
        }

        int[] row = matrix[row_mid];

        while (col_lo <= col_hi) {
            int col_mid = (col_lo + col_hi) / 2;
            int check = row[col_mid];
            if (check == target) {
                return true;
            } else if (target < check) {
                col_hi = col_mid - 1;
            } else {
                col_lo = col_mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC074_Search_A_2D_Matrix testCase = new LC074_Search_A_2D_Matrix();

        int[][] e1 = new int[][]{
                {}
        };
        assert !testCase.searchMatrix(e1, 3) : "Edge 0";

        int[][] e2 = new int[][]{
                {1},
                {3},
                {5},
                {7}
        };
        assert testCase.searchMatrix(e2, 3) : "Edge 1";

        int[][] e3 = new int[][]{
                {1, 3, 5, 7},
        };
        assert testCase.searchMatrix(e3, 3) : "Edge 2";

        int[][] s1 = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assert testCase.searchMatrix(s1, 3) : "Example 1";
        assert !testCase.searchMatrix(s1, 13) : "Example 2";

        System.out.println("all passed");
    }
}

