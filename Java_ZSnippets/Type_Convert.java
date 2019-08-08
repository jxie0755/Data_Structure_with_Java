import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Type_Convert {

    public static void main(String[] args) {

        // 这里总结一下各种基本的类型转换

        // 基本类型转换


        // double转int
        double A = 1.5;
        int int_A = (int) A;
        Double d_A = (double) int_A;

        // Long to int
        Long L = 10000L;
        int l = L.intValue();
        // int to Long  # cast
        Long LL = (long) l;

        // int转String
        int B = 1;
        String str_B = String.valueOf(B);

        // String转int (注意, 不能对Character类使用,必须是String!)
        int int_B = Integer.valueOf(str_B);
        int int_B2 = Integer.parseInt(str_B);  // 推荐

        // char转String
        char C = 'X';
        String str_C = String.valueOf(C);

        // char转int
        char N = '5';
        Integer NN = Character.getNumericValue(N);

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

        // String转char[]   (不能转Character[])
        String Sman = "MANUTD";
        char[] Chman = Sman.toCharArray();
        // Character[] Chman2 = Sman.toCharArray();


        // Char[] 转String  // 似乎没有直接方法
        // String hello_2 = new String(helloCArray);  不work
        // 用iteration很容易


        // String和StringBuilder之间的转换

        // String to StringBuilder  // 直接constructor?
        String E = "Denis";
        StringBuilder SB_E = new StringBuilder(E);
        // StringBuilder to String
        String str_E = SB_E.toString();


        // 容器转换

        // Collection转换  (直接通过constructor)
        // List 和 Set的转换 (list去重)
        List<Object> LOX = new ArrayList<>(Arrays.asList(1, 2, "A", 1, 3, "A"));
        List<Object> LOXsetList = new ArrayList<>(new HashSet<>(LOX));
        System.out.println(LOXsetList);  // >>> [1, A, 2, 3]  注意顺序奇怪

        // int[] to Integer[]/List<Integer>
        // 没有直接好的办法
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));


        // 一维Array和一维ArrayList
        // Array to ArrayList
        Integer[] X_array = new Integer[]{1, 2, 3, 4};
        List<Integer> int_L = new ArrayList<>(Arrays.asList(X_array));
        // ArrayList to Array // 注意Array不能用int[]
        Integer[] int_array = int_L.toArray(new Integer[int_L.size()]);  // 利用重载方法


        // 二维Array和而维ArrayList
        // 二维Array to 二维ArrayList
        Integer[][] X_grid = new Integer[][]{
                {1, 2},
                {3, 4}
        };

        List<List<Integer>> list_grid = new ArrayList<>(); // 先定义空表
        for (Integer[] array : X_grid) {
            list_grid.add(new ArrayList<>(Arrays.asList(array)));
        } // 没有直接办法


        // 二维ArrayList to 二维Array
        Integer[][] array_grid = new Integer[list_grid.size()][];
        for (int i = 0; i < list_grid.size(); i += 1) {
            List<Integer> to_add = list_grid.get(0);
            array_grid[i] = to_add.toArray(new Integer[to_add.size()]);
        } // 没有直接办法

        Map<Integer, List<Integer>> gridmap = new HashMap<>(Map.ofEntries(
                Map.entry(1, List.of(1, 2, 3, 4))
        ));

    }
}
