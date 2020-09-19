import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
class LC039_Combination_Sum {

    /**
     * Version D
     * 自建组合数然后检查每个组合的sum
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    }

    /**
     * self verison of combination algorithm, with repeating
     * almost the same as py.itertools.combinations_with_replacement
     */
    public List<List<Integer>> combinationWR(List<Integer> candidates, int pick) {
        if (pick == 0) {
            return new ArrayList<>(Collections.emptyList());;
        }

        int p = 1;
        List<List<Integer>> ans = new ArrayList<>(Collections.emptyList());


    }


    public static void main(String[] args) {
        LC039_Combination_Sum testCase = new LC039_Combination_Sum();
        int[] q1 = {};
        List<List<Integer>> a1 = new ArrayList<>();
        assert testCase.combinationSum(q1, 1).equals(a1) : "Edge 1";

        int[] q2 = {1};
        List<List<Integer>> a2 = new ArrayList<>();
        a2.add(new ArrayList<>(Arrays.asList(1)));
        assert testCase.combinationSum(q2, 1).equals(a2) : "Edge 2";

        int[] q3 = {1};
        List<List<Integer>> a3 = new ArrayList<>();
        a3.add(new ArrayList<>(Arrays.asList(1, 1)));
        assert testCase.combinationSum(q3, 2).equals(a3) : "Edge 3";

        int[] q4 = {2};
        List<List<Integer>> a4 = new ArrayList<>();
        assert testCase.combinationSum(q4, 1).equals(a4) : "Edge 4";

        int[] q5 = {2};
        List<List<Integer>> a5 = new ArrayList<>();
        assert testCase.combinationSum(q5, 5).equals(a5) : "Edge 5";

        int[] q6 = {2, 3, 6, 7};
        List<List<Integer>> a6 = new ArrayList<>();
        a6.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        a6.add(new ArrayList<>(Arrays.asList(7)));
        assert testCase.combinationSum(q6, 7).equals(a6) : "Example 1";

        int[] q7 = {2, 3, 5};
        List<List<Integer>> a7 = new ArrayList<>();
        a7.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2)));
        a7.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        a7.add(new ArrayList<>(Arrays.asList(3, 5)));
        assert testCase.combinationSum(q7, 8).equals(a7) : "Example 2";

        int[] q8 = {2, 4};
        List<List<Integer>> a8 = new ArrayList<>();
        a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 4)));
        a8.add(new ArrayList<>(Arrays.asList(2, 4, 4)));
        assert testCase.combinationSum(q8, 10).equals(a8) : "Extra 1";

        System.out.println("all passed");
    }

}

