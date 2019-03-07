package zlearnings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList_grid {

    public static void main(String[] args) {

        // Learn to build an Array List grid
        // 若是多维数组可以吗?
        List<Object> LL1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Object> LL2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Object> LL3 = new ArrayList<>(Arrays.asList(7, 8, 9));

        // List<Object> Lgrid = new ArrayList<>(Arrays.asList(LL1, LL2, LL3));
        // 注意, 这里不应该用List<Object>
        List<List<Integer>> Lgrid = new ArrayList(Arrays.asList(LL1, LL2, LL3));
        List<List<Integer>> Lgrid2 = new ArrayList<>(Lgrid);
        System.out.println(Lgrid.get(1).get(2)); // >>> 6

        // 注意声明时,类型要彻底
        List<List<List<Integer>>> Cube = new ArrayList<>(Arrays.asList(Lgrid, Lgrid2));
        System.out.println(Cube.get(0).get(1).get(1)); // >>> 5
    }
}

