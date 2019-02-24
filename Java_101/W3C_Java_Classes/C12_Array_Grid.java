package W3C_Java_Classes;// 1.10.3 Multile dimensional Arrays as a grid

public class C12_Array_Grid {
    public static void main(String[] args) {


        // 声明形式:
        int[][] arrayX;
        int arrayY[];
        int[] arrayZ[];

        // two dimentional grid
        int[][] A = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 15},  // 2
                //0  1  2   3
        };

        System.out.println(A[1][2]);  // >>> 8  第1行第2个
    }

    // Build a Pascal Triangle
    // https://stackoverflow.com/questions/54482724/java-pascal-triangle-initialization-question
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


