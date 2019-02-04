package java_reference;// 1.10.3 Multile dimensional Arrays as a grid

public class C12_Array_Grid {
    public static void main(String[] args) {

        // two dimentional grid
        int[][] A = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 15}   // 2
                //0  1   2  3
        };

        System.out.println(A[1][2]);  // >>> 8  第1行第2个

    }

    // Build a Pascal Triangle
    // https://stackoverflow.com/questions/54482724/java-pascal-triangle-initialization-question
    public static int[][] Pascal(int N) {

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


