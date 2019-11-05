import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//额外实战比较Grid
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


    public static void main(String[] args) {

        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList());
        a4.add(new ArrayList<>(Arrays.asList()));
        a4.add(new ArrayList<>(Arrays.asList(1)));
        a4.add(new ArrayList<>(Arrays.asList(2)));
        a4.add(new ArrayList<>(Arrays.asList(3)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2)));
        a4.add(new ArrayList<>(Arrays.asList(1, 3)));
        a4.add(new ArrayList<>(Arrays.asList(2, 3)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(a4);

        a4.sort(new IntGridComparator());
        System.out.println(a4);
    }
}
