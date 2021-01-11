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
     * Need to do two binary search:
     *  First search for a row
     *  Then find out if the element is in the row
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row_lo = 0;
        int row_hi = matrix.length - 1;
        int row_idx = 0;  // must initiate a number to be able to locate if while loop is never entered
        while (row_lo <= row_hi) {
            row_idx = (row_lo + row_hi) / 2;
            int row_head = matrix[row_idx][0];
            if (row_head > target) {
                row_hi = row_idx - 1;
            } else if (row_head == target) {
                break;
            } else if (row_head < target){
                if (row_idx == matrix.length - 1) {
                    break;
                } else {
                    if (matrix[row_idx + 1][0] <= target) {
                        row_lo = row_idx + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        int[] row = matrix[row_idx];
        int col_lo = 0;
        int col_hi = matrix[0].length - 1;
        while (col_lo <= col_hi) {
            int cold_idx = (col_lo + col_hi) / 2;
            if (row[cold_idx] == target) {
                return true;
            } else if (target < row[cold_idx]) {
                col_hi = cold_idx - 1;
            } else {
                col_lo = cold_idx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC074_Search_A_2D_Matrix testCase = new LC074_Search_A_2D_Matrix();

        int[][] e0 = new int[][]{
        };
        assert !testCase.searchMatrix(e0, 3) : "Empty";


        int[][] e1 = new int[][]{
                {}
        };
        assert !testCase.searchMatrix(e1, 3) : "Edge 1";

        int[][] e2 = new int[][]{
                {1},
                {3},
                {5},
                {7}
        };
        assert testCase.searchMatrix(e2, 3) : "Edge 2";

        int[][] e3 = new int[][]{
                {1, 3, 5, 7},
        };
        assert testCase.searchMatrix(e3, 3) : "Edge 3";

        int[][] s1 = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assert testCase.searchMatrix(s1, 3) : "Example 1";
        assert !testCase.searchMatrix(s1, 13) : "Example 2";

        System.out.println("All passed");
    }
}

