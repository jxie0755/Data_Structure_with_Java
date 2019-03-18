package zsnippets;


import java.util.*;

/**
 * This is to create the same sudoku solver algorithm from python version
 * from: sudoku_solver_v3.py by using HashMap
 * raw data must be in String[][] type.
 */

public class JavaSudokuSolver {

    // constants
    static String blank = "0";
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
                x.append(".");
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

    /**
     * 得到一个坐标的行,列,九宫格三列的值
     */
    List<String> get_row_col_grid(List<Integer> coor) {
        int x = coor.get(0);
        int y = coor.get(1);

        int grid_n;

        List<Integer> A = List.of(1, 2, 3);
        List<Integer> B = List.of(4, 5, 6);

        if (A.contains(x)) {
            if (A.contains(y)) {
                grid_n = 7;
            } else if (B.contains(y)) {
                grid_n = 4;
            } else {
                grid_n = 1;
            }
        } else if (B.contains(x)) {
            if (A.contains(y)) {
                grid_n = 8;
            } else if (B.contains(y)) {
                grid_n = 5;
            } else {
                grid_n = 2;
            }
        } else {
            if (A.contains(y)) {
                grid_n = 9;
            } else if (B.contains(y)) {
                grid_n = 6;
            } else {
                grid_n = 3;
            }
        }
        List<String> all_used = new ArrayList<>();
        all_used.addAll(this.row(y));
        all_used.addAll(this.col(x));
        all_used.addAll(this.grid(grid_n));
        return new ArrayList<>(new HashSet<>(all_used));
    }

    /**
     * Return if there is a conflict int he board
     * 也就是横,竖,九宫格存在冲突
     */
    boolean no_conflict() {
        List<List<String>> all_subs = new ArrayList<>();
        for (int i = 1; i < 10; i += 1) {
            all_subs.add(this.row(i));
            all_subs.add(this.col(i));
            all_subs.add(this.grid(i));
        }

        for (List<String> line : all_subs) {
            List<String> check_list = new ArrayList<>();
            for (String i : line) {
                if (!i.equals(blank)) {
                    if (!check_list.contains(i)) {
                        check_list.add(i);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 判断棋盘是否已被填满
     */
    boolean all_filled() {
        for (Map<String, List<String>> value : this.hash_board.values()) {
            if (value.get("cur").get(0).equals(blank)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否已得出解
     */
    boolean isSolved() {
        return this.all_filled() && this.no_conflict();
    }


    /**
     * 核心算法: 局面分析
     * update the hashboard value on dict['possible'] for every coor
     */
    void analysis() {
        for (Map.Entry<List<Integer>, Map<String, List<String>>> entry : this.hash_board.entrySet()) {
            List<Integer> coor = entry.getKey();
            Map<String, List<String>> dict_value = entry.getValue();
            if (dict_value.get("cur").get(0).equals(blank)) {
                List<String> cant_be = this.get_row_col_grid(coor);
                List<String> can_be = new ArrayList<>(valid);
                can_be.removeAll(cant_be);
                dict_value.put("possible", can_be);
            }
        }
    }

    /**
     * 判断局面是否可以行, 也就是没有冲突, 每个格子仍然至少有一个数可填
     * 先做analysis
     * 然后基于最新的analysis来判断
     */
    boolean feasible() {
        this.analysis();
        for (Map.Entry<List<Integer>, Map<String, List<String>>> entry : this.hash_board.entrySet()) {
            List<Integer> coor = entry.getKey();
            Map<String, List<String>> dict_value = entry.getValue();
            if (dict_value.get("cur").get(0).equals(blank) && dict_value.get("possible").isEmpty()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 核心算法: 直接推导, 把所有只有一种可能性的地方填满
     * 不止填一次, 如果填完后经过analysis又有新的位置只剩下一种可能性,那么再次填写,直到无法继续
     */
    void direct_deduce() {

    }



}






class sudokuTest {

    public static void main(String[] args) {

        // websudoku hard puzzle 10
        String[][] hard_10 = {
                {"0", "0", "0", "3", "7", "0", "0", "0", "5"},
                {"8", "0", "0", "0", "5", "1", "3", "0", "0"},
                {"0", "5", "0", "0", "0", "0", "0", "6", "2"},
                {"9", "4", "0", "0", "0", "0", "0", "0", "0"},
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



