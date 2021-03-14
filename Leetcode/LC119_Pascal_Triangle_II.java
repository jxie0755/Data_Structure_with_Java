import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * LC119 Pasical's Trianle II
 * Easy
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * <p>
 * Follow up: Could you optimize your algorithm to use only O(k) extra space?
 */
class LC119_Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Arrays.asList(1));
        } else if (rowIndex == 1) {
            return new ArrayList<>(Arrays.asList(1, 1));
        } else {
            List<Integer> layer = new ArrayList<>(Arrays.asList(1, 1));

            for (int i = 1; i < rowIndex; i += 1) {
                List<Integer> new_layer = new ArrayList<>(Arrays.asList(1));
                for (int j = 0; j < layer.size() - 1; j += 1) {
                    new_layer.add(layer.get(j) + layer.get(j + 1));
                }
                new_layer.add(1);
                layer = new_layer;
            }
            return layer;
        }
    }

    public static void main(String[] args) {
        LC119_Pascal_Triangle_II testCase = new LC119_Pascal_Triangle_II();

        assert testCase.getRow(3).equals(new ArrayList<>(Arrays.asList(
                1, 3, 3, 1
        ))) : "Example 1";

        assert testCase.getRow(0).equals(new ArrayList<>(Arrays.asList(
                1
        ))) : "Example 2";

        assert testCase.getRow(1).equals(new ArrayList<>(Arrays.asList(
                1, 1
        ))) : "Example 3";

        System.out.println("All passed");
    }
}

