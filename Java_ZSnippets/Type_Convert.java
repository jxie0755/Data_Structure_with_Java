import java.util.*;

class Type_Convert {

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
        List<Object> LOXsetList = new ArrayList<>(new HashSet<>(LOX));  // 直接intitate带入另一类Collection
        System.out.println(LOXsetList);  // >>> [1, A, 2, 3]  注意顺序奇怪

        // List to Tupple
        List<Object> tuple = Collections.unmodifiableList(LOX);


        // int[] to Integer[]/List<Integer>
        // 没有直接好的办法,可以考虑用Stream
        // int[] array = {1, 2, 3, 4, 5};
        // List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));


        // Array (Interger[]) to ArrayList (List<Integer>)
        Integer[] X_array = new Integer[]{1, 2, 3, 4};
        // Method 1
        List<Integer> X_arrayList_1 = new ArrayList<>(Arrays.asList(X_array));
        // Mehtod 2
        List<Integer> X_arrayList_1b = new ArrayList<>();
        X_arrayList_1b.addAll(Arrays.asList(X_array));     // 也可以建空列表, 再addAll

        // ArrayList (List<Integer>) to Array (Interger[])
        Integer[] int_array = X_arrayList_1.toArray(new Integer[X_arrayList_1.size()]);  // 利用重载方法

        // 注意这种转换必须是Integer[] to Arraylist,如果是int[]则没有直接方法, 必须遍历.


        // 二维Array (Integer[][]) to 二维ArrayList (List<List<Integer>>)
        Integer[][] X_array_grid = new Integer[][]{
                {1, 2},
                {3, 4}
        };
        // 间接方法,先定义空grid,然后遍历添加
        List<List<Integer>> X_list_grid = new ArrayList<>();
        for (Integer[] array : X_array_grid) {
            X_list_grid.add(new ArrayList<>(Arrays.asList(array)));
        }


        // 二维ArrayList (List<List<Integer>>) to 二维Array (Integer[][])
        // 同样没有直接办法,先定义空grid,然后遍历添加
        Integer[][] x_array_grid_2 = new Integer[X_list_grid.size()][];
        for (int i = 0; i < X_list_grid.size(); i += 1) {
            List<Integer> to_add = X_list_grid.get(0);
            x_array_grid_2[i] = to_add.toArray(new Integer[to_add.size()]);
        }
    }
}
