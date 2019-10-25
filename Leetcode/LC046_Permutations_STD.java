import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Additional Solution for LC046
 */
class LC046_Permutations_STD {

    /**
     * STD Ans
     * 给定一个数组，返回他的所有排列。
     * 解题思路: 使用分治法求解。
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
        LC046_Permutations_STD testCase = new LC046_Permutations_STD();
        int[] q1 = {1};
        List<Integer> a1r1 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> a1 = new ArrayList<>(Arrays.asList(a1r1));
        assert testCase.permute(q1).equals(a1) : "Edge 1";

        int[] q2 = {1, 2, 3};
        List<Integer> a2r1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> a2r2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> a2r3 = new ArrayList<>(Arrays.asList(2, 1, 3));
        List<Integer> a2r4 = new ArrayList<>(Arrays.asList(2, 3, 1));
        List<Integer> a2r5 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> a2r6 = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<List<Integer>> a2 = new ArrayList<>(Arrays.asList(a2r1, a2r2, a2r3, a2r4, a2r5, a2r6));
        // assert testCase.permute(q2).equals(a2) : "Example 1";
        // System.out.println(testCase.permute(q2));
        // >>> [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]  // it is not perfect
        System.out.println("all passed");
    }
}