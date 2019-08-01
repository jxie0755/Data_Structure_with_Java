import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * P039 Cobination Sum
 * Medium
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class LC039_Combination_Sum {

    /**
     * Version B
     * This used internal helper method, in java, must be implemented through an internal class.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        // Build an internal class for helper function
        class Inner {
            void process(int[] candidates, int start, List<Integer> intermediate, int target) {
                if (target == 0) {
                    result.add(new ArrayList<>(intermediate));  // copy intermediate
                } else {
                    while (start < candidates.length && candidates[start] <= target) {
                        intermediate.add(candidates[start]);
                        this.process(candidates, start, intermediate, target - candidates[start]);
                        intermediate.remove(intermediate.size() - 1);
                        start += 1;
                    }
                }
            }
        }

        Inner helper = new Inner();
        helper.process(candidates, 0, new ArrayList<>(), target);

        return result;
    }


    public static void main(String[] args) {
        int[] q1 = {};
        List<List<Integer>> a1 = new ArrayList<>();
        assert new LC039_Combination_Sum().combinationSum(q1, 1).equals(a1) : "Edge 1";

        int[] q2 = {1};
        List<List<Integer>> a2 = new ArrayList<>();
        a2.add(new ArrayList<>(Arrays.asList(1)));
        assert new LC039_Combination_Sum().combinationSum(q2, 1).equals(a2) : "Edge 2";

        int[] q3 = {1};
        List<List<Integer>> a3 = new ArrayList<>();
        a3.add(new ArrayList<>(Arrays.asList(1, 1)));
        assert new LC039_Combination_Sum().combinationSum(q3, 2).equals(a3) : "Edge 3";

        int[] q4 = {2};
        List<List<Integer>> a4 = new ArrayList<>();
        assert new LC039_Combination_Sum().combinationSum(q4, 1).equals(a4) : "Edge 4";

        int[] q5 = {2};
        List<List<Integer>> a5 = new ArrayList<>();
        assert new LC039_Combination_Sum().combinationSum(q5, 5).equals(a5) : "Edge 5";

        int[] q6 = {2, 3, 6, 7};
        List<List<Integer>> a6 = new ArrayList<>();
        a6.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        a6.add(new ArrayList<>(Arrays.asList(7)));
        assert new LC039_Combination_Sum().combinationSum(q6, 7).equals(a6) : "Example 1";

        int[] q7 = {2, 3, 5};
        List<List<Integer>> a7 = new ArrayList<>();
        a7.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2)));
        a7.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        a7.add(new ArrayList<>(Arrays.asList(3, 5)));
        assert new LC039_Combination_Sum().combinationSum(q7, 8).equals(a7) : "Example 2";

        int[] q8 = {2, 4};
        List<List<Integer>> a8 = new ArrayList<>();
        a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 4)));
        a8.add(new ArrayList<>(Arrays.asList(2, 4, 4)));
        assert new LC039_Combination_Sum().combinationSum(q8, 10).equals(a8) : "Extra 1";

        System.out.println("all passed");


    }

}

