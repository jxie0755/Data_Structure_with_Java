import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * P036 Valid Sudoku
 * Medium
 * <p>
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * <p>
 * See reference in Java_ZSnippets/JavaSudokuSolver
 */
public class LC036_Valid_Sudoku {

    /**
     * Verion A
     * 分区推理, 分割成三个helper, 分别检查: 横, 竖, 小九宫
     */
    public boolean isValidSudoku(char[][] board) {
        return this.all_rows(board) && this.all_cols(board) && this.all_blocks(board);
    }

    // Helper 1, 检查所有row是否不发生冲突
    private boolean all_rows(char[][] board) {
        for (char[] row : board) {
            if (!this.correct_line(row)) {
                return false;
            }
        }
        return true;
    }

    // Helper 2, 检查所有column是否不发生冲突
    private boolean all_cols(char[][] board) {
        for (int i = 0; i < 9; i += 1) {
            char[] col = new char[9];
            for (int j = 0; j < 9; j += 1) {
                col[j] = board[j][i];
            }
            if (!this.correct_line(col)) {
                return false;
            }
        }
        return true;
    }

    // Helper 3, 检查所有sub grid是否不发生冲突
    private boolean all_blocks(char[][] board) {
        char[][] blocks = {
                {board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]},
                {board[3][0], board[3][1], board[3][2], board[4][0], board[4][1], board[4][2], board[5][0], board[5][1], board[5][2]},
                {board[6][0], board[6][1], board[6][2], board[7][0], board[7][1], board[7][2], board[8][0], board[8][1], board[8][2]},
                {board[0][3], board[0][4], board[0][5], board[1][3], board[1][4], board[1][5], board[2][3], board[2][4], board[2][5]},
                {board[3][3], board[3][4], board[3][5], board[4][3], board[4][4], board[4][5], board[5][3], board[5][4], board[5][5]},
                {board[6][3], board[6][4], board[6][5], board[7][3], board[7][4], board[7][5], board[8][3], board[8][4], board[8][5]},
                {board[0][6], board[0][7], board[0][8], board[1][6], board[1][7], board[1][8], board[2][6], board[2][7], board[2][8]},
                {board[3][6], board[3][7], board[3][8], board[4][6], board[4][7], board[4][8], board[5][6], board[5][7], board[5][8]},
                {board[6][6], board[6][7], board[6][8], board[7][6], board[7][7], board[7][8], board[8][6], board[8][7], board[8][8]}
        };

        for (char[] blk : blocks) {
            if (!this.correct_line(blk)) {
                return false;
            }
        }
        return true;
    }

    // Helper Level 2
    // 帮助Helper 1,2,3检查冲突
    private boolean correct_line(char[] row) {
        List<Character> written = new ArrayList<>(Arrays.asList());
        for (char i : row) {
            if (i == '.') {
            } else if (!written.contains(i)) {
                written.add(i);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] example_1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        assert new LC036_Valid_Sudoku().isValidSudoku(example_1) : "Example 1";

        char[][] example_2 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        assert !new LC036_Valid_Sudoku().isValidSudoku(example_2) : "Example 2";

        char[][] example_3 = new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        assert !new LC036_Valid_Sudoku().isValidSudoku(example_3) : "Example 3";

        System.out.println("all passed");
    }
}

