package zsnippets;


import java.util.*;

/**
 * This is to create the same sudoku solver algorithm from python version
 * from: sudoku_solver_v3.py by using HashMap
 * raw data must be in String[][] type.
 */

public class JavaSudokuSolver {

    // constants
    static String blank = ".";
    static List<String> valid = new ArrayList<>(Arrays.asList(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"));
    // for read grid
    static Map<Integer, List<Integer>> gridmap = new HashMap<>(Map.ofEntries(
                 Map.entry(1, List.of(7, 10, 1, 4)),
                 Map.entry(2, List.of(7, 10, 4, 7)),
                 Map.entry(3, List.of(7, 10, 7, 10)),
                 Map.entry(4, List.of(4, 7, 1, 4)),
                 Map.entry(5, List.of(4, 7, 4, 7)),
                 Map.entry(6, List.of(4, 7, 7, 10)),
                 Map.entry(7, List.of(1, 4, 1, 4)),
                 Map.entry(8, List.of(1, 4, 4, 7)),
                 Map.entry(9, List.of(1, 4, 7, 10))
     ));

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
        // 这里要注意, python中"cur"对应的是一个String, 而"possible"和"trie"对应的是List<String>
        // 而Java字典中的值类型不同,会比较麻烦,所以"cur"也用List包装, 但是只装一个值
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                Map<String, List<String>> hash_boad_value = new HashMap<>();
                hash_board.put(List.of(x, y), hash_boad_value);
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


    String process_raw(String[] row){
        StringBuilder x = new StringBuilder("|");
        for (String i: row){
            if (!valid.contains(i)) {
                x.append(blank);
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

    void load_quiz() {
        for (List<Integer> key : this.hash_board.keySet()) {
            int x = key.get(0);
            int y = key.get(1);
            String given = this.board[9 - y][x - 1];
            this.hash_board.get(key).get("cur").set(0, given);
        }
    }

    /**
     * define reading of current value at coor location
     */
    String cur_value(List<Integer> coor) {
        return this.hash_board.get(coor).get("cur").get(0);
    }

    /**
     * Define insert movement, by adding value to the baord at coor location
     */
    void insert(List<Integer> coor, String value) {
        this.hash_board.get(coor).get("cur").set(0, value);
        this.count += 1;
    }


    // 基础设施
    /**
     * 返回一个行的值
     */
    List<String> row(int n) {
        List<String> row_n = new ArrayList<>();
        for (List<Integer> coor : this.hash_board.keySet()) {
            if (coor.get(1) == n) {
                row_n.add(this.hash_board.get(coor).get("cur").get(0));
            }
        }
        return row_n;
    }

    /**
     * 返回一个列的值
     */
    List<String> col(int n) {
        List<String> col_n = new ArrayList<>();
        for (List<Integer> coor : this.hash_board.keySet()) {
            if (coor.get(0) == n) {
                col_n.add(this.hash_board.get(coor).get("cur").get(0));
            }
        }
        return col_n;
    }

    /**
     * 返回一个九宫格的值
     */
    List<String> grid(int n) {
        List<String> grid_n = new ArrayList<>();
        int a = gridmap.get(n).get(0);
        int b = gridmap.get(n).get(1);
        int c = gridmap.get(n).get(2);
        int d = gridmap.get(n).get(3);
        for (int y = a; y < b; y += 1) {
            for (int x = c; x < d; x += 1) {
                grid_n.add(this.hash_board.get(List.of(x, y)).get("cur").get(0));
            }
        }
        return grid_n;
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
        System.out.print(q1.grid(7));

    }

}



