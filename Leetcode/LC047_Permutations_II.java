import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * P047 Permutations II
 * Medium
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class LC047_Permutations_II {

    /**
     * Version D, Pure recursive method
     * Pure recursive method, single and pure recursion from leetcode P046
     * Revised the recursion rule by bypassing the repeated next_list
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        // Prepare nums in List<Integer> form
        List<Integer> nums_list = new ArrayList<>();
        for (int i : nums) {
            nums_list.add(i);
        }
        // prepare result
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            result.add(nums_list);
            return result;
        }

        // add an intermediate step to prevent repeats
        List<List<Integer>> subList_checklist = new ArrayList<>();

        for (int i : nums) {
            List<Integer> sub_list = new ArrayList<>(nums_list);
            sub_list.remove(Integer.valueOf(i));

            if (!subList_checklist.contains(sub_list)) { // # check repeats
                subList_checklist.add(sub_list);

                int[] sub_nums = new int[nums.length - 1];
                for (int k = 0; k < sub_list.size(); k += 1) {
                    sub_nums[k] = sub_list.get(k);
                }

                for (List<Integer> per : this.permuteUnique(sub_nums)) {
                    List<Integer> to_add = new ArrayList<>(Arrays.asList(i));
                    to_add.addAll(per);
                    result.add(to_add);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] q1 = {1};
        List<Integer> a1r1 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList(a1r1));
        assert new LC047_Permutations_II().permuteUnique(q1).equals(a1) : "Edge 1";

        int[] q2 = {1, 2, 3};
        List<Integer> a2r1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> a2r2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> a2r3 = new ArrayList<>(Arrays.asList(2, 1, 3));
        List<Integer> a2r4 = new ArrayList<>(Arrays.asList(2, 3, 1));
        List<Integer> a2r5 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> a2r6 = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList(a2r1, a2r2, a2r3, a2r4, a2r5, a2r6));
        assert new LC047_Permutations_II().permuteUnique(q2).equals(a2) : "Example 1";

        int[] q3 = {1, 1, 2};
        List<Integer> a3r1 = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> a3r2 = new ArrayList<>(Arrays.asList(1, 2, 1));
        List<Integer> a3r3 = new ArrayList<>(Arrays.asList(2, 1, 1));
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList(a3r1, a3r2, a3r3));
        assert new LC047_Permutations_II().permuteUnique(q3).equals(a3) : "Example 2";

        System.out.println("all passed");
    }

}

