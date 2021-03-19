import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * LC120 Triangle
 * Medium
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
class LC120_Triangle {
    /**
     * Version B2
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> previous_sum = triangle.get(0);

        for (int R = 1; R < triangle.size(); R += 1) {
            List<Integer> sum_path = new ArrayList<>(triangle.get(R));
            for (int i = 0; i <= R; i += 1) {
                if (i == 0) {
                    sum_path.set(i, previous_sum.get(i) + sum_path.get(i));
                } else if (i == R) {
                    sum_path.set(i, previous_sum.get(i - 1) + sum_path.get(i));
                } else {
                    sum_path.set(i, Math.min(previous_sum.get(i - 1), previous_sum.get(i)) + sum_path.get(i));
                }
            }
            previous_sum = sum_path;
        }
        return this.getMin(previous_sum);
    }

    private int getMin(List<Integer> numList) {
        int min_val = Integer.MAX_VALUE;
        for (int x : numList) {
            if (x < min_val) {
                min_val = x;
            }
        }
        return min_val;
    }

    public static void main(String[] args) {
        LC120_Triangle testCase = new LC120_Triangle();

        assert testCase.minimumTotal(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ))) == 1 : "Edge 1";

        assert testCase.minimumTotal(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(3, 4)),
                new ArrayList<>(Arrays.asList(6, 5, 7)),
                new ArrayList<>(Arrays.asList(4, 1, 8, 3))
        ))) == 11 : "Example 1";

        System.out.println("All passed");
    }
}

