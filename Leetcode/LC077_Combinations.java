import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * P077 Combinations
 * Medium
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
class LC077_Combinations {

    /**
     * Version A1
     * Convert the n into an actual list, then use a helper to recursive run on the list
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i += 1) {
            nums.add(i);
        }
        return this.combinationSolo(nums, k);
    }

    /**
     * Helper
     */
    private List<List<Integer>> combinationSolo(List<Integer> nums, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (k == nums.size()) {
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
        LC077_Combinations testCase = new LC077_Combinations();

        List<List<Integer>> E1 = testCase.combine(1, 1);
        List<List<Integer>> A1 = new ArrayList<>();
        A1.add(new ArrayList<>(Arrays.asList(1)));
        assert E1.equals(A1);

        List<List<Integer>> E2 = testCase.combine(4, 4);
        List<List<Integer>> A2 = new ArrayList<>();
        A2.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        assert E2.equals(A2);

        List<List<Integer>> S1 = testCase.combine(5, 3);
        List<List<Integer>> A3 = new ArrayList<>();
        A3.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A3.add(new ArrayList<>(Arrays.asList(1, 2, 4)));
        A3.add(new ArrayList<>(Arrays.asList(1, 2, 5)));
        A3.add(new ArrayList<>(Arrays.asList(1, 3, 4)));
        A3.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        A3.add(new ArrayList<>(Arrays.asList(1, 4, 5)));
        A3.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        A3.add(new ArrayList<>(Arrays.asList(2, 3, 5)));
        A3.add(new ArrayList<>(Arrays.asList(2, 4, 5)));
        A3.add(new ArrayList<>(Arrays.asList(3, 4, 5)));
        assert S1.equals(A3);

        System.out.println("all passed");
    }
}

