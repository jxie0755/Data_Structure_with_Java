package zsnippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Type_Convert {

    public static void main(String[] args) {

        // 这里总结一下各种基本的类型转换

        // 基本类型转换


        // double转int
        double A = 1.5;
        int int_A = (int) A;
        double d_A = (double) int_A;

        // int转String
        int B = 1;
        String str_B = String.valueOf(B);

        // String转int
        int int_B = Integer.valueOf(str_B);

        // char转String
        char C = 'X';
        String str_C = String.valueOf(C);

        //String转char? 可能没必要
        char char_c = str_C.charAt(0);

        // Character转String  // 基本同上
        Character D = 'Y';
        String str_D = String.valueOf(D);

        // Character转String
        Character Char_D = str_D.charAt(0);


        // Array 转 String
        // String[] 转 String
        String[] str_array = new String[]{"A", "B", "C"};
        String str_array_STR = String.join("", str_array);
        System.out.println(str_array_STR);

        // char[] 转String
        char[] hellocArray = {'h', 'e', 'l', 'l', 'o'};
        Character[] helloCArray = {'h', 'e', 'l', 'l', 'o'};
        String hello_1 = new String(hellocArray);

        // Char[] 转String  // 似乎没有直接方法
        // String hello_2 = new String(helloCArray);  不work
        // 用iteration很容易




        // 容器转换

        // 一维Array和一维ArrayList
        // Array to ArrayList
        Integer[] E = new Integer[]{1, 2, 3, 4};
        List<Integer> int_L = new ArrayList<>(Arrays.asList(E));
        // ArrayList to Array
        Integer[] int_array = int_L.toArray(new Integer[int_L.size()]);  // 利用重载方法


        // 二维Array和而维ArrayList
        // 二维Array to 二维ArrayList
        Integer[][] F = new Integer[][]{
                {1, 2},
                {3, 4}
        };

        List<List<Integer>> list_grid = new ArrayList<>(); // 先定义空表
        for (Integer[] array : F) {
            list_grid.add(new ArrayList<>(Arrays.asList(array)));
        } // 没有直接办法


        // 二维ArrayList to 二维Array
        Integer[][] array_grid = new Integer[list_grid.size()][];
        for (int i = 0; i < list_grid.size(); i += 1) {
            List<Integer> to_add = list_grid.get(0);
            array_grid[i] = to_add.toArray(new Integer[to_add.size()]);
        } // 没有直接办法
    }
}

