import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * LC046 Permutations
 * Medium
 * <p>
 * Given a collection of distinct (数字不会重复) integers, return all possible permutations.
 */
class LC046_Permutations {

    /**
     * Version D, Pure recursive method
     * <p>
     * 此题与Python Version D相比有两个难点:
     * py中形参为List[int],输出List[List[int]], 本题java形参为int[], 所以需要转换成ArrayList处理,最后要转回int[]用于递归
     * java不得使用list comprehension,所以要扩展开来变成一个for loop
     */
    // public List<List<Integer>> permute(int[] nums) {
    //
    //     // Prepare nums in List<Integer> form
    //     List<Integer> nums_list = new ArrayList<>();
    //     for (int i : nums) {
    //         nums_list.add(i);
    //     }
    //
    //     // prepare result
    //     List<List<Integer>> result = new ArrayList<>();
    //
    //     if (nums.length == 1) {
    //         result.add(nums_list);
    //         return result;
    //     }
    //
    //     for (int i = 0; i < nums.length; i += 1) {
    //         List<Integer> sub_list = new ArrayList<>(nums_list);
    //         int picked = sub_list.remove(i);
    //
    //         // convert sub_list back to Array type
    //         int[] sub_nums = new int[nums.length - 1];
    //         for (int k = 0; k < sub_list.size(); k += 1) {
    //             sub_nums[k] = sub_list.get(k);
    //         }
    //
    //         for (List<Integer> per : this.permute(sub_nums)) {
    //             List<Integer> to_add = new ArrayList<>(Arrays.asList(picked));
    //             to_add.addAll(per);
    //             result.add(to_add);
    //         }
    //     }
    //     return result;
    // }


    /**
     * STD Ans
     * 给定一个数组, 返回他的所有排列.
     * 解题思路: 使用分治法求解.
     */
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {

        result = new LinkedList<>();
        if (nums != null) {
            permute(0, nums);
        }

        return result;
    }

    private void permute(int i, int[] nums) {

        if (i == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int n : nums) {
                l.add(n);
            }
            result.add(l);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, j, i);
                permute(i + 1, nums);
                swap(nums, j, i);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }


    public static void main(String[] args) {
        LC046_Permutations testCase = new LC046_Permutations();

        // Q1
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ));

        int[] q1 = {1};
        assert testCase.permute(q1).equals(a1) : "Edge 1";

        // Q2
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 3, 2)),
                new ArrayList<>(Arrays.asList(2, 1, 3)),
                new ArrayList<>(Arrays.asList(2, 3, 1)),
                new ArrayList<>(Arrays.asList(3, 1, 2)),
                new ArrayList<>(Arrays.asList(3, 2, 1))
        ));

        int[] q2 = {1, 2, 3};
        List<List<Integer>> q2_ans = testCase.permute(q2);
        q2_ans.sort(new IntGridComparator());  // must sort to ensure sequence
        assert q2_ans.equals(a2) : "Example 1";

        System.out.println("All passed");
    }
}
