import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This is to learn customized sort by creating new Comparator sub-class
 */


// Create a customized sort for absolute value
class absComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a * a - b * b;
    }
}

class IntGridComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
        int min_lenth = Math.min(l1.size(), l2.size());
        if (min_lenth == 0) {
            return 0;
        }

        for (int i = 0; i < min_lenth; i += 1) {
            if (l1.get(i) < l2.get(i)) {
                return -1;
            } else if (l1.get(i) > l2.get(i)) {
                return 1;
            }
        }

        if (l1.size() == l2.size()) {
            return 0;
        } else if (l1.size() < l2.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}
    public class Customized_Sort {

    public static void main(String[] args) {
        List<Integer> list_1 = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2));
        list_1.sort(new absComparator());
        System.out.println(list_1);
        // >>>  [0, -1, 1, -2, 2, -3]

        List<List<Integer>> grid_1 = new ArrayList<>(Arrays.asList());
        grid_1.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        grid_1.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        grid_1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        grid_1.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        grid_1.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        grid_1.add(new ArrayList<>(Arrays.asList(3, 1, 2)));

        System.out.println(grid_1);
        // >>> [[3, 2, 1], [1, 3, 2], [2, 3, 1], [2, 1, 3], [1, 2, 3], [3, 1, 2]]
        grid_1.sort(new IntGridComparator());
        System.out.println(grid_1);
        // >>> [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}


