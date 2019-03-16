package zsnippets;


import java.util.*;

/**
 * This is to create the same sudoku solver algorithm from python version
 * from: sudoku_solver_v3.py by using HashMap
 **/

public class JavaSudokuSolver {

    // constant
    static String blank = ".";
    static List<String> valid = new ArrayList<>(Arrays.asList(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"));

    // main data structure
    String[][] board;
    Map<List<Integer>, Map<String, List<String>>> hash_board = new HashMap<>();

    // for derivitation
    List<List<Integer>> guess_history;
    List<List<List<Integer>>> deduct_history;

    // for statistics
    Integer count = 0;
    Integer guess = 0;
    Integer guess_layer = 0;

    public JavaSudokuSolver(String[][] puzzle) {

        // 生成棋盘读题
        this.board = puzzle;

        // 先处理hashboad
        for (Integer x = 1; x < 10; x++) {
            for (Integer y = 1; y < 10; y++) {
                Map<String, List<String>> hash_boad_value = new HashMap<>();
                List<Integer> coor = List.of(x, y);
                hash_board.put(coor, hash_boad_value);
            }
        }

        for (List coor : hash_board.keySet()) {
            List<String> L1 =new ArrayList<>(Arrays.asList(blank));
            List<String> L2 =new ArrayList<>();
            List<String> L3 =new ArrayList<>();

            Map<String, List<String>> hashboard_items = hash_board.get(coor);
            hashboard_items.put("cur", L1);
            hashboard_items.put("possible", L2);
            hashboard_items.put("tried", L3);
        }

        // 将题读入hashboard
        this.load_quiz();
        System.out.println("puzzle is generated:");
        System.out.println(this + "\n");
    }

     void load_quiz() {
        for (List<Integer> key : this.hash_board.keySet()) {
            int x = key.get(0);
            int y = key.get(1);
            String given = this.board[9 - y][x - 1];
            this.hash_board.get(key).get("cur").set(0, given);
        }
    }

    String process_raw(String[] row){
        StringBuilder x = new StringBuilder("|");
        for (String i: row){
            if (!JavaSudokuSolver.valid.contains(i)) {
                x.append(JavaSudokuSolver.blank);
            } else {
                x.append(i);
            }
            x.append("  ");
        }

        return x.substring(0, 9) + "  " + x.substring(9, 18) + "  " + x.substring(18);
    }

    public String toString() {
        StringBuilder to_print = new StringBuilder();
        int y_num = 9;
        String separ = "    -----------------------------";
        String x_num = "    1  2  3    4  5  6    7  8  9";

        for (String[] row : this.board) {
            String str_row = process_raw(row);
            to_print.append(String.valueOf(y_num) + "  " + str_row + "\n");
            if (List.of(7, 4).contains(y_num)) {
                to_print.append("\n");
            }
            y_num -= 1;
        }

        to_print.append(separ + "\n" + x_num);
        return to_print.toString();
    }


}






class sudokuTest {

    public static void main(String[] args) {

        // websudoku hard puzzle 10
        String[][] hard_10 = {
                {"0", "0", "0", "3", "7", "0", "0", "0", "5"},
                {"8", "0", "0", "0", "5", "1", "3", "0", "0"},
                {"0", "5", "0", "0", "0", "0", "0", "6", "2"},
                {"0", "5", "0", "0", "0", "0", "0", "6", "2"},
                {"0", "0", "0", "7", "0", "8", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "5", "4"},
                {"1", "6", "0", "0", "0", "0", "0", "4", "0"},
                {"0", "0", "3", "1", "2", "0", "0", "0", "7"},
                {"5", "0", "0", "0", "6", "4", "0", "0", "0"}
        };


        // Test
        JavaSudokuSolver q1 = new JavaSudokuSolver(hard_10);


    }

}



