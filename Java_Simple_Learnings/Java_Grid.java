import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java_Grid {

    // learn Array grid and ArrayList grid
}

class ArrayList_Grid {

    public static void main(String[] args) {

        // Learn to build an Array List grid
        // 若是多维数组可以吗?
        List<Integer> LL1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> LL2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> LL3 = new ArrayList<>(Arrays.asList(7, 8, 9));
        // 以上也建议用List<Integer>

        // List<Object> Lgrid = new ArrayList<>(Arrays.asList(LL1, LL2, LL3));
        // 注意, 这里不应该用List<Object>更不该用List
        List<List<Integer>> Lgrid = new ArrayList(Arrays.asList(LL1, LL2, LL3));
        List<List<Integer>> Lgrid2 = new ArrayList<>(Lgrid);

        System.out.println(Lgrid.get(1).get(2)); // >>> 6
        Lgrid.get(0).add(3);
        System.out.println(Lgrid);
        // >>> [
        // [1, 2, 3],
        // [4, 5, 6],
        // [7, 8, 9]
        // ]


        // 注意声明时,类型要彻底 (3D 矩阵)
        List<List<List<Integer>>> Cube = new ArrayList<>(Arrays.asList(Lgrid, Lgrid2));
        System.out.println(Cube.get(0).get(1).get(1)); // >>> 5
    }
}


class Arrays_Grid {
    public static void main(String[] args) {

        // 声明形式:
        int[][] arrayX;
        int arrayY[];
        int[] arrayZ[];

        // 注意
        // int[][] grid = new int[row_number][column_number]
        // int row_number = grid.length
        // int colown_number = grid[0].length

        // two dimentional grid
        int[][] A = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 15},  // 2
                //0  1  2   3
        };

        System.out.println(A[1][2]);  // >>> 8  第1行第2个
        // 修改
        A[1][2] = 99;

        for (int[] i : A) {
            System.out.println(Arrays.toString(i));
        }
        // >>>
        // [1, 3, 5, 7]
        // [2, 5, 99, 11]
        // [3, 7, 11, 15]


    }

    // Build a Pascal Triangle
    // STOF: https://stackoverflow.com/questions/54482724/java-pascal-triangle-initialization-question
    public static int[][] Pascal(int N) {

        // 动态初始化不规则数组比较麻烦， 不能使用new int[X][Y]语句， 而是先初始化高维数组， 然后再分别逐个初始化低维数组
        int[][] result = new int[N][];  // Create array of N initially null rows.
        // Does not need length for sub arrays
        // Because result is an [] of int[], so we only statement one length of the big array

        for (int i = 0; i < N; i += 1) {

            result[i] = new int[i + 1];       // Build an empty row with length
            result[i][0] = result[i][i] = 1;  // The ends of the row are 1.

            for (int j = 1; j < i; j += 1)
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];  // 上一行相邻两数相加
        }
        return result;
    }
}
