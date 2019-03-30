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

    // all coors
    List<List<Integer>> all_coors = new ArrayList<>();

    // main data structure
    String[][] board;
    Map<List<Integer>, Map<String, List<String>>> hash_board = new HashMap<>();

    // for derivitation
    List<List<Integer>> guess_history = new ArrayList<>();
    List<List<List<Integer>>> deduct_history = new ArrayList<>();

    // for statistics
    Integer count = 0;
    Integer guess = 0;
    List<Integer> guess_layer = new ArrayList<>();


    public JavaSudokuSolver(String[][] puzzle) {

        // 生成棋盘读题
        this.board = puzzle;

        // 先处理hashboad
        // 这里要注意, python中"cur"对应的是一个String, 而"possible"和"trie"对应的是List<String>
        // 而Java字典中的值类型不同,会比较麻烦,所以"cur"也用List包装, 但是只装一个值
        // 同时准备all_coors
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                Map<String, List<String>> hash_boad_value = new HashMap<>();
                hash_board.put(List.of(x, y), hash_boad_value);
                all_coors.add(List.of(x, y));
            }
        }


        for (List coor : this.all_coors) {
            Map<String, List<String>> hashboard_items = hash_board.get(coor);
            hashboard_items.put("cur", new LinkedList<>(Arrays.asList(blank)));
            hashboard_items.put("tried", new LinkedList<>());
            hashboard_items.put("possible", new LinkedList<>());
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
        for (List<Integer> key : this.all_coors) {
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
        this.hash_board.get(coor).get("cur").set(0,value);
        this.count += 1;
    }

    void cancel_insert(List<Integer> coor) {
        this.hash_board.get(coor).get("cur").set(0,blank);
    }


    // 基础设施
    /**
     * 返回一个行的值
     */
    List<String> row(int n) {
        List<String> row_n = new ArrayList<>();
        for (List<Integer> coor : this.all_coors) {
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
        for (List<Integer> coor : this.all_coors) {
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
     * print current board according to hashboard
     */
    void print_translate() {
        for (Map.Entry<List<Integer>, Map<String, List<String>>> entry : hash_board.entrySet()) {
            List<Integer> coor = entry.getKey();
            Map<String, List<String>> val = entry.getValue();
            int x = coor.get(0);
            int y = coor.get(1);
            board[9 - y][x - 1] = val.get("cur").get(0);
        }
        System.out.println(this);
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
                List<String> can_be = new LinkedList<>(valid);
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
        boolean deduct_added = true;
        List<List<Integer>> all_deduced = new ArrayList<>();

        while (deduct_added) {
            this.analysis();
            List<List<Integer>> coor_operated = new ArrayList<>();
            for (Map.Entry<List<Integer>, Map<String, List<String>>> entry : hash_board.entrySet()) {
                List<Integer> coor = entry.getKey();
                Map<String, List<String>> val = entry.getValue();
                if (val.get("possible").size() == 1 && val.get("cur").get(0).equals(blank)) {
                    this.insert(coor, val.get("possible").get(0));
                    coor_operated.add(coor);
                }
            }
            if (coor_operated.size() == 0) {
                deduct_added = false;
            } else {
                all_deduced.addAll(coor_operated);
            }
        }
        this.deduct_history.add(all_deduced);
    }

    /**
     * 如果无法直接推导, 则优先找出当前可能性最少的一个位置进行猜测
     */
    List<Integer> best_guess() {

        List<List<Integer>> uncertain_coors = new ArrayList<>();

        for (List<Integer> coor : this.all_coors) {
            if (this.hash_board.get(coor).get("cur").get(0).equals(blank)) {
                uncertain_coors.add(coor);
            }
        }

        List<Integer> coor_to_move = Collections.min(uncertain_coors, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return hash_board.get(o1).get("possible").size() - hash_board.get(o2).get("possible").size();
            }
        });
        this.guess_history.add(coor_to_move);
        return coor_to_move;
    }

    /**
     * 从best guess得到的坐标中, 挑一个(最后一个)来进行假设试验
     */
    void hyper_move(List<Integer> coor) {
        List<String> possibles = this.hash_board.get(coor).get("possible");
        String value = possibles.remove(possibles.size()-1);
        this.hash_board.get(coor).get("tried").add(value);
        this.insert(coor, value);
        this.guess += 1;
    }

    /**
     * Undo a hyper_guess, also remove the deduced history follow by the hyper_guess
     */
    void undo() {
        List<List<Integer>> undo_deducted = this.deduct_history.remove(this.deduct_history.size()-1);
        List<Integer> guess_deducted = this.guess_history.get(this.guess_history.size()-1);
        for (List<Integer> coor : undo_deducted) {
            this.cancel_insert(coor);
        }
        this.cancel_insert(guess_deducted);
    }

    /**
     * check if last guess still have possible value
     */
    boolean last_guess_available() {
        return this.hash_board.get(this.guess_history.get(this.guess_history.size()-1)).get("possible").size() > 0;
    }


    /**
     * Final solution
     */
    void solve() {

        int layer = 0;

        while (!this.isSolved()) {
            this.direct_deduce();

            if (this.isSolved()) {
                break;
            } else if (this.feasible() && !this.all_filled()) {
                List<Integer> best_coor = this.best_guess();
                this.hyper_move(best_coor);
                layer += 1;
            } else {
                while (true) {
                    this.undo();
                    if (this.last_guess_available()) {
                        break;
                    } else {
                        this.guess_history.remove(this.guess_history.size()-1);
                        this.guess_layer.add(layer);
                        layer -= 1;
                    }
                }
                this.hyper_move(this.guess_history.get(this.guess_history.size()-1));
            }
        }
        System.out.println("Problem solved!");
    }

    void show_answer() {
        System.out.println("The answer is: ");
        this.print_translate();
        System.out.println('\n');
    }

    void show_statistics() {
        System.out.println("total filled: " + this.count);
        System.out.println("total guess: " + this.guess);
        System.out.println("maximum layer: " + Collections.max(this.guess_layer));
        System.out.println();
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
        q1.solve();
        q1.show_answer();
        q1.show_statistics();


        String[][] ultimate = {
                {"8", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "3", "6", "0", "0", "0", "0", "0"},
                {"0", "7", "0", "0", "9", "0", "2", "0", "0"},
                {"0", "5", "0", "0", "0", "7", "0", "0", "0"},
                {"0", "0", "0", "0", "4", "5", "7", "0", "0"},
                {"0", "0", "0", "1", "0", "0", "0", "3", "0"},
                {"0", "0", "1", "0", "0", "0", "0", "6", "8"},
                {"0", "0", "8", "5", "0", "0", "0", "1", "0"},
                {"0", "9", "0", "0", "0", "0", "4", "0", "0"}
        };

        double startTime=System.currentTimeMillis();   //获取开始时间

        JavaSudokuSolver q2 = new JavaSudokuSolver(ultimate);
        q2.solve();
        q2.show_answer();
        q2.show_statistics();

        double endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("--- "+ (endTime-startTime)/1000  + "s seconds ---");
    }
}
