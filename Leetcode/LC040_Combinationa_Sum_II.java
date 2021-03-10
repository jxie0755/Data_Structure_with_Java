import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * LC040 Combination Sum II
 * Medium
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The difference between the LC039 and LC040 is that the candidates can be duplicated in LC040 but not in LC039
 * The solution set must not contain duplicate combinations.
 */
class LC040_Combinationa_Sum_II {

    /**
     * Version B
     * Same idea of LC039, but revised by removong duplicated items
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        // Build an inner class for helper function
        class Inner {
            void process(int[] candidates, int start, List<Integer> intermediate, int target) {
                if (target == 0 && !result.contains(intermediate)) {
                    result.add(new ArrayList<>(intermediate));  // copy intermediate
                }

                while (start < candidates.length && candidates[start] <= target) { // # 相对于LC039 加一个去重条件
                    intermediate.add(candidates[start]);
                    this.process(candidates, start + 1, intermediate, target - candidates[start]);
                    // 这里与LC039不同,需要跳过, 因为不得重复使用同一个元素
                    intermediate.remove(intermediate.size() - 1);
                    start += 1;
                }
            }
        }

        Inner helper = new Inner();
        helper.process(candidates, 0, new ArrayList<>(), target);

        return result;

    }

    public static void main(String[] args) {
        LC040_Combinationa_Sum_II testCase = new LC040_Combinationa_Sum_II();

        int[] q1 = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<Integer> a1 = new ArrayList<>(Arrays.asList(1, 1, 6));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> a3 = new ArrayList<>(Arrays.asList(1, 7));
        List<Integer> a4 = new ArrayList<>(Arrays.asList(2, 6));
        List<List<Integer>> a = new ArrayList<>(Arrays.asList(a1, a2, a3, a4));
        assert testCase.combinationSum2(q1, 8).equals(a) : "Example 1";


        int[] q2 = new int[]{2, 5, 2, 1, 2};
        List<Integer> b1 = new ArrayList<>(Arrays.asList(1, 2, 2));
        List<Integer> b2 = new ArrayList<>(Arrays.asList(5));
        List<List<Integer>> b = new ArrayList<>(Arrays.asList(b1, b2));
        assert testCase.combinationSum2(q2, 5).equals(b) : "Example 2";

        System.out.println("All passed");
    }

}
