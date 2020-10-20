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
class LC047_Permutations_II {

    List<List<Integer>> RESULT = new ArrayList<>();

    /**
     * Version C2, Non-pure recursive method, with helper
     * Sort nums first to avoid sort sub_list check for repeating
     */

    public List<List<Integer>> permuteUnique(int[] nums) {

        // Critical step to sort nums so that checking repeating will be easy
        Arrays.sort(nums);

        // Convert sorted nums into Arraylist for helper functions
        List<Integer> sorted_nums_arraylist = new ArrayList<>(Arrays.asList());
        for (int i : nums) {
            sorted_nums_arraylist.add(i);
        }

        this.permuteUniHelper(sorted_nums_arraylist, new ArrayList<>());

        // pass class attribut to answer and clear it
        List<List<Integer>> ans = new ArrayList<>(this.RESULT);
        this.RESULT.clear();
        return ans;
    }

    /**
     * Helper fucntion like LC047 version C2
     * This avoid sort sub_list every time
     * This also avoid constant type convert between int[] and List<Integer>
     */
    private void permuteUniHelper(List<Integer> lst, List<Integer> permute_list) {
        if (lst.size() == 0) { // all elements got picked
            this.RESULT.add(permute_list);
        } else {
            List<List<Integer>> sub_list_check = new ArrayList<>();
            for (int i = 0; i < lst.size(); i += 1) {
                List<Integer> sub_list = new ArrayList<>(lst);
                int picked = sub_list.remove(i);

                if (!sub_list_check.contains(sub_list)) {
                    sub_list_check.add(sub_list);
                    List<Integer> updated_permute_list = new ArrayList<>(permute_list);
                    updated_permute_list.add(picked);
                    this.permuteUniHelper(sub_list, updated_permute_list);
                }
            }
        }

    }

    public static void main(String[] args) {
        LC047_Permutations_II testCase = new LC047_Permutations_II();
        int[] q1 = {1};
        List<Integer> a1r1 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList(a1r1));
        assert testCase.permuteUnique(q1).equals(a1) : "Edge 1";

        // Q2 and Q2b
        List<Integer> a2r1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> a2r2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> a2r3 = new ArrayList<>(Arrays.asList(2, 1, 3));
        List<Integer> a2r4 = new ArrayList<>(Arrays.asList(2, 3, 1));
        List<Integer> a2r5 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> a2r6 = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList(a2r1, a2r2, a2r3, a2r4, a2r5, a2r6));

        int[] q2 = {1, 2, 3};
        List<List<Integer>> q2_ans = testCase.permuteUnique(q2);
        q2_ans.sort(new IntGridComparator());  // must sort to ensure sequence
        assert q2_ans.equals(a2) : "Example 1";

        int[] q2b = {3, 2, 1};
        List<List<Integer>> q2b_ans = testCase.permuteUnique(q2b);
        q2b_ans.sort(new IntGridComparator());
        assert q2b_ans.equals(a2) : "Example 1 additional";

        // Q3 and Q3b
        List<Integer> a3r1 = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> a3r2 = new ArrayList<>(Arrays.asList(1, 2, 1));
        List<Integer> a3r3 = new ArrayList<>(Arrays.asList(2, 1, 1));
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList(a3r1, a3r2, a3r3));

        int[] q3 = {1, 1, 2};
        List<List<Integer>> q3_ans = testCase.permuteUnique(q3);
        q3_ans.sort(new IntGridComparator());
        assert q3_ans.equals(a3) : "Example 2";

        int[] q3b = {2, 1, 1};
        List<List<Integer>> q3b_ans = testCase.permuteUnique(q3b);
        q3b_ans.sort(new IntGridComparator());
        assert q3b_ans.equals(a3) : "Example 2 additional";

        // Q4
        List<Integer> a4r1 = new ArrayList<>(Arrays.asList(0, 3, 3, 3));
        List<Integer> a4r2 = new ArrayList<>(Arrays.asList(3, 0, 3, 3));
        List<Integer> a4r3 = new ArrayList<>(Arrays.asList(3, 3, 0, 3));
        List<Integer> a4r4 = new ArrayList<>(Arrays.asList(3, 3, 3, 0));
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList(a4r1, a4r2, a4r3, a4r4));

        int[] q4 = {3, 3, 0, 3};
        List<List<Integer>> q4_ans = testCase.permuteUnique(q4);
        q4_ans.sort(new IntGridComparator());
        assert q4_ans.equals(a4) : "Extra 1";

        System.out.println("all passed");
    }
}

