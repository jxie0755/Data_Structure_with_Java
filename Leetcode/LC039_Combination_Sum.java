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
        if (candidates.length == 0) {
            return new ArrayList<>(Collections.emptyList());
        }

        int max_n = target / Arrays.stream(candidates).min().getAsInt();;
        List<List<Integer>> result = new ArrayList<>(Collections.emptyList());
        for (int i = 1; i <= max_n; i += 1) {
            for (List<Integer> comb : this.combinationWR(candidates, i)) {
                if (comb.stream().mapToInt(x -> x).sum() == target) { // sum(comb)
                    result.add(comb);
                }
            }
        }
        return result;
    }

    /**
     * self verison of combination algorithm, with repeating
     * almost the same as py.itertools.combinations_with_replacement
     */
    public List<List<Integer>> combinationWR(int[] candidates, int pick) {
        if (pick == 0) {
            return new ArrayList<>(Collections.emptyList());
        }

        int p = 1;
        List<List<Integer>> ans = new ArrayList<>(Collections.emptyList());
        for (int i : candidates) {
            ans.add(new ArrayList<>(Arrays.asList(i)));
        }


        while (p < pick) {
            List<List<Integer>> new_ans = new ArrayList<>(Collections.emptyList());

            for (List<Integer> comb : ans) {
                for (int i : candidates) {
                    if (i >= Collections.max(comb)) {
                        List<Integer> new_comb = new ArrayList<>(comb);
                        new_comb.add(i);
                        new_ans.add(new_comb);
                    }
                }
            }
            ans = new_ans;
            p += 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        LC039_Combination_Sum testCase = new LC039_Combination_Sum();

        int[] q1 = {};
        List<List<Integer>> a1 = new ArrayList<>();
        assert testCase.combinationSum(q1, 1).equals(a1) : "Edge 0";

        int[] q2 = {1};
        List<List<Integer>> a2 = new ArrayList<>();
        a2.add(new ArrayList<>(Arrays.asList(1)));
        assert testCase.combinationSum(q2, 1).equals(a2) : "Edge 1";

        int[] q3 = {1};
        List<List<Integer>> a3 = new ArrayList<>();
        a3.add(new ArrayList<>(Arrays.asList(1, 1)));
        assert testCase.combinationSum(q3, 2).equals(a3) : "Edge 2";

        int[] q4 = {2};
        List<List<Integer>> a4 = new ArrayList<>();
        assert testCase.combinationSum(q4, 1).equals(a4) : "Edge 3";

        int[] q5 = {2};
        List<List<Integer>> a5 = new ArrayList<>();
        assert testCase.combinationSum(q5, 5).equals(a5) : "Edge 4";


        // Answers with more than one combination needs to check after sorted
        int[] q6 = {2, 3, 6, 7};
        List<List<Integer>> sorted_a6 = new ArrayList<>();
        sorted_a6.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        sorted_a6.add(new ArrayList<>(Arrays.asList(7)));

        List<List<Integer>> a6 = testCase.combinationSum(q6, 7); // sort every combination in a6
        for (List<Integer> comb : a6) {
            Collections.sort(comb);
        }
        Collections.sort(a6, new IntGridComparator()); // thenm, sort a6

        assert a6.equals(sorted_a6) : "Example 1";

        int[] q7 = {2, 3, 5};
        List<List<Integer>> sorted_a7 = new ArrayList<>();
        sorted_a7.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2)));
        sorted_a7.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        sorted_a7.add(new ArrayList<>(Arrays.asList(3, 5)));

        List<List<Integer>> a7 = testCase.combinationSum(q7, 8); // sort every combination in a7
        for (List<Integer> comb : a7) {
            Collections.sort(comb);
        }
        Collections.sort(a7, new IntGridComparator()); // thenm, sort a7

        assert a7.equals(sorted_a7) : "Example 2";

        int[] q8 = {2, 4};
        List<List<Integer>> sorted_a8 = new ArrayList<>();
        sorted_a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        sorted_a8.add(new ArrayList<>(Arrays.asList(2, 2, 2, 4)));
        sorted_a8.add(new ArrayList<>(Arrays.asList(2, 4, 4)));

        List<List<Integer>> a8 = testCase.combinationSum(q8, 10); // sort every combination in a8
        for (List<Integer> comb : a8) {
            Collections.sort(comb);
        }
        Collections.sort(a8, new IntGridComparator()); // thenm, sort a8

        assert a8.equals(sorted_a8) : "Extra 1";

        int[] q9 = {7, 3, 2};
        List<List<Integer>> sorted_a9 = new ArrayList<>();
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 3)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 3, 7)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3, 3, 3)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 2, 7, 7)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(2, 3, 3, 3, 7)));
        sorted_a9.add(new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3)));

        List<List<Integer>> a9 = testCase.combinationSum(q9, 18); // sort every combination in a9
        for (List<Integer> comb : a9) {
            Collections.sort(comb);
        }
        Collections.sort(a9, new IntGridComparator()); // thenm, sort a9

        assert a9.equals(sorted_a9) : "Extra 1";

        System.out.println("All passed");
    }

}

