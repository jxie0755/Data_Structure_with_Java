package zsnippets;


import java.util.*;

/**
 * This is to create the same sudoku solver algorithm from python version
 * from: sudoku_solver_v3.py by using HashMap
 **/

public class JavaSudokuSolver {

    String blank = ".";
    List<String> valid = new ArrayList<>(Arrays.asList(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"));

    List<List<String>> board;

    Map<List<Integer>, Map<String, List<String>>> hash_board = new HashMap<>();

    List<List<Integer>> guess_history;
    List<List<List<Integer>>> deduct_history;

    Integer count = 0;
    Integer guess = 0;
    Integer guess_layer = 0;

    public JavaSudokuSolver() {

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



    }

}


class sudokuTest {

    public static void main(String[] args) {

        // websudoku hard puzzle 10
        List<List<String>> hard_data_10_str = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList())
        ));



    }
}



