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
            int head = next_list.remove(0);

            for (List<Integer> com : this.combinationSolo(next_list, k - 1)) {
                List<Integer> head_combination = new ArrayList<>(com);
                head_combination.add(0, head);
                result.add(head_combination);
            }

            result.addAll(this.combinationSolo(nums.subList(1, nums.size()), k));
            return result;
        }
    }

    public static void main(String[] args) {
        LC078_Subsets testCase = new LC078_Subsets();

        int[] e1 = new int[]{};
        List<List<Integer>> sorted_e1 = testCase.subsets(e1);
        sorted_e1.sort(new IntGridComparator());
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList());
        a1.add(new ArrayList<>(Arrays.asList()));
        assert sorted_e1.equals(a1) : "Edge 0";

        int[] e2 = new int[]{1};
        List<List<Integer>> sorted_e2 = testCase.subsets(e2);
        sorted_e2.sort(new IntGridComparator());
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList());
        a2.add(new ArrayList<>(Arrays.asList()));
        a2.add(new ArrayList<>(Arrays.asList(1)));
        a2.sort(new IntGridComparator());
        assert sorted_e2.equals(a2) : "Edge 1";

        int[] s1 = new int[]{1, 2};
        List<List<Integer>> sorted_s1 = testCase.subsets(s1);
        sorted_s1.sort(new IntGridComparator());
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList());
        a3.add(new ArrayList<>(Arrays.asList()));
        a3.add(new ArrayList<>(Arrays.asList(1)));
        a3.add(new ArrayList<>(Arrays.asList(1, 2)));
        a3.add(new ArrayList<>(Arrays.asList(2)));
        assert sorted_s1.equals(a3) : "Example 1";

        int[] s2 = new int[]{1, 2, 3};
        List<List<Integer>> sorted_s2 = testCase.subsets(s2);
        sorted_s2.sort(new IntGridComparator());
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList());
        a4.add(new ArrayList<>(Arrays.asList()));
        a4.add(new ArrayList<>(Arrays.asList(1)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2)));
        a4.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        a4.add(new ArrayList<>(Arrays.asList(1, 3)));
        a4.add(new ArrayList<>(Arrays.asList(2)));
        a4.add(new ArrayList<>(Arrays.asList(2, 3)));
        a4.add(new ArrayList<>(Arrays.asList(3)));
        assert sorted_s2.equals(a4) : "Example 2";
        System.out.println("all passed");
    }
}

