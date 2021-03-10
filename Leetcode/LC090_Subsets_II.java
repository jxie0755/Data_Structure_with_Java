import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * LC090 Subsets II
 * Medium
 * <p>
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
public class LC090_Subsets_II {
    /**
     * Version A, avoid type convert
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList());
        List<Integer> nums_list = new ArrayList<>();
        for (int i : nums) {
            nums_list.add(i);
        }

        for (int i = 0; i <= nums.length; i += 1) {
            result.addAll(this.combinationSolo(nums_list, i));
        }
        return result;
    }

    /**
     * Helper from LC077
     */
    private List<List<Integer>> combinationSolo(List<Integer> nums, int k) {


        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(nums); // sort nums

        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        } else if (k == nums.size()) {
            result.add(nums);
            return result;
        } else if (k == 1) {
            for (Integer i : nums) {
                if (!result.contains(new ArrayList<>(Arrays.asList(i)))) {
                    result.add(new ArrayList<>(Arrays.asList(i)));
                }
            }
            return result;
        } else {
            List<Integer> next_list = new ArrayList<>(nums);
            int tail = next_list.remove(nums.size() - 1);
            result.addAll(this.combinationSolo(next_list, k));

            for (List<Integer> com : this.combinationSolo(next_list, k - 1)) {
                com.add(tail);
                if (!result.contains(com)) {
                    result.add(com);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LC090_Subsets_II testCase = new LC090_Subsets_II();

        int[] q1 = new int[]{};
        List<List<Integer>> a1 = testCase.subsetsWithDup(q1);
        a1.sort(new IntGridComparator());
        assert a1.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList())
        ))) : "Edge 0";

        int[] q2 = new int[]{1};
        List<List<Integer>> a2 = testCase.subsetsWithDup(q2);
        a2.sort(new IntGridComparator());
        assert a2.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1))
        ))) : "Edge 1";

        int[] q3 = new int[]{1, 2};
        List<List<Integer>> a3 = testCase.subsetsWithDup(q3);
        a3.sort(new IntGridComparator());
        assert a3.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(2))
        ))) : "Example 1";

        int[] q4 = new int[]{1, 2, 2};
        List<List<Integer>> a4 = testCase.subsetsWithDup(q4);
        a4.sort(new IntGridComparator());
        assert a4.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 2, 2)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(2, 2))
        ))) : "Example 2";

        int[] q5 = new int[]{1, 2, 3};
        List<List<Integer>> a5 = testCase.subsetsWithDup(q5);
        a5.sort(new IntGridComparator());
        assert a5.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(2, 3)),
                new ArrayList<>(Arrays.asList(3))
        ))) : "Additional 1";

        int[] q6 = new int[]{1, 1, 2, 2};
        List<List<Integer>> a6 = testCase.subsetsWithDup(q6);
        a6.sort(new IntGridComparator());
        assert a6.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 1)),
                new ArrayList<>(Arrays.asList(1, 1, 2)),
                new ArrayList<>(Arrays.asList(1, 1, 2, 2)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 2, 2)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(2, 2))
        ))) : "Additional 2";

        int[] q7 = new int[]{2, 1, 2, 1};
        List<List<Integer>> a7 = testCase.subsetsWithDup(q7);
        a7.sort(new IntGridComparator());
        assert a7.equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 1)),
                new ArrayList<>(Arrays.asList(1, 1, 2)),
                new ArrayList<>(Arrays.asList(1, 1, 2, 2)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 2, 2)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(2, 2))
        ))) : "Additional 2 unsorted";

        System.out.println("All passed");
    }
}

