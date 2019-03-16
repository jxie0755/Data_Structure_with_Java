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

    }

     void load_quiz() {
        for (List<Integer> key : this.hash_board.keySet()) {
            int x = key.get(0);
            int y = key.get(1);
            String given = this.board[9 - y][x - 1];
            this.hash_board.get(key).get("cur").set(0, given);
        }
    }

    public String toString() {
        String to_print = "";




        return to_print;
    }


}






class sudokuTest {

    public static void main(String[] args) {

        // websudoku hard puzzle 10
        // List<List<String>> hard_data_10_str = new ArrayList<>(Arrays.asList(
        //         new ArrayList<>(Arrays.asList("0", "0", "0", "3", "7", "0", "0", "0", "5")),
        //         new ArrayList<>(Arrays.asList("8", "0", "0", "0", "5", "1", "3", "0", "0")),
        //         new ArrayList<>(Arrays.asList("0", "5", "0", "0", "0", "0", "0", "6", "2")),
        //         new ArrayList<>(Arrays.asList("0", "5", "0", "0", "0", "0", "0", "6", "2")),
        //         new ArrayList<>(Arrays.asList("0", "0", "0", "7", "0", "8", "0", "0", "0")),
        //         new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0", "0", "0", "5", "4")),
        //         new ArrayList<>(Arrays.asList("1", "6", "0", "0", "0", "0", "0", "4", "0")),
        //         new ArrayList<>(Arrays.asList("0", "0", "3", "1", "2", "0", "0", "0", "7")),
        //         new ArrayList<>(Arrays.asList("5", "0", "0", "0", "6", "4", "0", "0", "0"))
        // ));


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

        // q1.load_quiz();
        for (List<Integer> key : q1.hash_board.keySet()) {
            System.out.println(key + " -> " + q1.hash_board.get(key).get("cur"));
        }





    }
}



