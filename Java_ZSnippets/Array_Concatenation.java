import java.util.Arrays;
import java.util.stream.Stream;

class Array_Concatenation {

    /*
     * This is to learn how to concatenate two arrays in Java
     * https://stackoverflow.com/a/23188881/8435726
     *
     * https://stackoverflow.com/a/49772469/8435726
     * System.arraycopy
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * src - the source array.
     * srcPos - starting position in the source array.
     * dest - the destination array.
     * destPos - starting position in the destination data.
     * length - the number of array elements to be copied.
     */


    public static void main(String[] args) {

        // Method 1: Use Stream.concat

        String[] A = {"A", "B", "C"};
        String[] B = {"D", "E", "F"};
        String[] AB = Stream.concat(Arrays.stream(A), Arrays.stream(B))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(AB));
        // >>> [A, B, C, D, E, F]

        // 注意! 这里必须不能使用primitive type, 得用包装类型
        Integer[] C = {1, 2, 3};
        Integer[] D = {4, 5, 6};
        Integer[] CD = Stream.concat(Arrays.stream(C), Arrays.stream(D))
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(CD));
        // >>> [1, 2, 3, 4, 5, 6]

        // Method 2: Use Stream.of
        String[] E = {"A", "B", "C"};
        String[] F = {"D", "E", "F"};
        String[] EF = Stream.of(E, F).flatMap(Stream::of)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(EF));
        // >>> [A, B, C, D, E, F]

        // 注意! 这里同样必须不能使用primitive type, 得用包装类型
        Integer[] G = {1, 2, 3};
        Integer[] H = {4, 5, 6};
        Integer[] GH = Stream.of(G, H).flatMap(Stream::of)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(GH));
        // >>> [1, 2, 3, 4, 5, 6]


        // Use Arrays.copyOf method
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};
        int[] both = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, both, first.length, second.length);
        System.out.println(Arrays.toString(both));
        // >>> [1, 2, 3, 4, 5, 6]
    }
}

