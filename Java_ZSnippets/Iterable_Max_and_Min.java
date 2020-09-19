import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is to learn how to get max and min on top of Math.min and Math.max
 */

public class Iterable_Max_and_Min {

    public static void main(String[] args) {

        // first another two example of Math.max and Math.min
        // see more in Java_101/Java_Classes/A02_Math
        double max_0 = Math.max(10, 9);  // 10.0
        double min_0 = Math.min(10, 9);  // 9.0
        System.out.println("max_0 = " + max_0 + ", min_0 = " + min_0);

        // Use stream method for Array
        int[] intArray_1 = new int[]{1,2,3,4,5};
        double max_1 = Arrays.stream(intArray_1).max().getAsInt();
        double min_1 = Arrays.stream(intArray_1).min().getAsInt();
        System.out.println("max_1 = " + max_1 + ", min_1 = " + min_1);

        // Secondary method, convert Array to ArrayList then use Collections
        Integer[] intArray_2 = new Integer[]{1, 2, 3, 4, 5};  // Must be Integer[], not int[]
        double max_1b = Collections.max(Arrays.asList(intArray_2));
        double min_1b = Collections.min(Arrays.asList(intArray_2));
        System.out.println("max_1b = " + max_1b + ", min_1b = " + min_1b);

        // Use Collections.max and Collectins.min for Lists
        // see more in Java_101/Java_Classes/A08b_java_util_Collections
        List<Integer> ArrayList_1 = new ArrayList<>(Arrays.asList(6,7,8,9));
        double max_2 = Collections.max(ArrayList_1);
        double min_2 = Collections.min(ArrayList_1);
        System.out.println("max_2 = " + max_2 + ", min_2 = " + min_2);

    }
}




