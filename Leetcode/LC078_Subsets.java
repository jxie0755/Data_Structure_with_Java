import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * P078 Subsets
 * Medium
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
class LC078_Subsets {

    /**
     * Version A
     * Helper from Combination Solo
     */
    public List<List<Integer>> subsets(int[] nums) {
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
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        } else if (k == nums.size()) {
            result.add(nums);
            return result;
        } else if (k == 1) {
            for (Integer i : nums) {
                result.add(new ArrayList<>(Arrays.asList(i)));
            }
            return result;
        } else {
            List<Integer> next_list = new ArrayList<>(nums);
            int tail = next_list.remove(nums.size() - 1);

            for (List<Integer> com : this.combinationSolo(next_list, k - 1)) {
                com.add(tail);
                result.add(com);
            }

            result.addAll(this.combinationSolo(next_list, k));
            return result;
        }
    }


    public static void main(String[] args) {
        LC078_Subsets testCase = new LC078_Subsets();

        int[] e1 = new int[]{};
        List<List<Integer>> e1_result = testCase.subsets(e1);
        e1_result.sort(new IntGridComparator());
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList());
        a1.add(new ArrayList<>(Arrays.asList()));
        assert e1_result.equals(a1) : "Empty";

        int[] e2 = new int[]{1};
        List<List<Integer>> e2_result = testCase.subsets(e2);
        e2_result.sort(new IntGridComparator());
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList());
        a2.add(new ArrayList<>(Arrays.asList()));
        a2.add(new ArrayList<>(Arrays.asList(1)));
        a2.sort(new IntGridComparator());
        assert e2_result.equals(a2) : "Edge 1";

        int[] s1 = new int[]{1, 2};
        List<List<Integer>> s1_result = testCase.subsets(s1);
        s1_result.sort(new IntGridComparator());
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList());
        a3.add(new ArrayList<>(Arrays.asList()));
        a3.add(new ArrayList<>(Arrays.asList(1)));
        a3.add(new ArrayList<>(Arrays.asList(1, 2)));
        a3.add(new ArrayList<>(Arrays.asList(2)));
        assert s1_result.equals(a3) : "Example 1";

        int[] s2 = new int[]{1, 2, 3};
        List<List<Integer>> s2_result = testCase.subsets(s2);
        s2_result.sort(new IntGridComparator());
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList());
        a4.add(new ArrayList<>(Arrays.asList()));
        a4.add(new ArrayList<>(Arrays.asList(1)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        a4.add(new ArrayList<>(Arrays.asList(1, 3)));
        a4.add(new ArrayList<>(Arrays.asList(2)));
        a4.add(new ArrayList<>(Arrays.asList(2, 3)));
        a4.add(new ArrayList<>(Arrays.asList(3)));
        assert s2_result.equals(a4) : "Example 2";

        System.out.println("All passed");
    }
}

