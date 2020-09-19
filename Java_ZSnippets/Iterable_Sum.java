import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is to learn sum() for int[] and List<Integer>
 */

public class Iterable_Sum {

    public static void main(String[] args) {

        // Array (int[])
        int[] array_1 = new int[]{1, 2, 3};
        int sum_1 = Arrays.stream(array_1).sum();
        System.out.println(sum_1);

        // ArrayList (List<Integer)
        List<Integer> list_1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int sum_2 = list_1.stream().mapToInt(x -> x).sum();
        System.out.println(sum_2);
    }
}

