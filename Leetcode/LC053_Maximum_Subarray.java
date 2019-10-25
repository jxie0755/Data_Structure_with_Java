/**
 * https://leetcode.com/problems/maximum-subarray/
 * p053 Maximum Subarray
 * Easy
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 */
class LC053_Maximum_Subarray {

    /**
     * Version B
     * O(n), using local and global max_value to iterate over the elements
     */
    public int maxSubArray(int[] nums) {

        // 一次遍历, 找两组数据
        // 第一组找当前最大值, 如果发现数组内全都不为正, 那就直接返回最大值
        boolean nonePositive = true;
        int cur_max = Integer.MIN_VALUE;

        // 第二组找Subarray
        int global_max = 0;
        int local_max = 0;

        for (int i : nums) {

            if (i > 0) {
                nonePositive = false;
            }

            if (i > cur_max) {
                cur_max = i;
            }

            local_max = Math.max(0, local_max + i);
            global_max = Math.max(global_max, local_max);
        }

        if (nonePositive) {
            return cur_max;
        } else {
            return global_max;
        }
    }

    public static void main(String[] args) {
        LC053_Maximum_Subarray testCase = new LC053_Maximum_Subarray();

        int[] q1 = {1, 2, 3, 4};
        assert testCase.maxSubArray(q1) == 10 : "All positive";

        int[] q2 = {-1, -2, -3, -4};
        assert testCase.maxSubArray(q2) == -1 : "All negative";

        int[] q3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert testCase.maxSubArray(q3) == 6 : "mixed positive and negative";

        int[] q4 = {2, 2, 0, -1};
        assert testCase.maxSubArray(q4) == 4 : "with zero";

        int[] q5 = {-2, -1, -1, -1, -1, -1, -1, -1, 1};
        assert testCase.maxSubArray(q5) == 1 : "a lot of negative";

        int[] q6 = {0, 0, -3, 1};
        assert testCase.maxSubArray(q6) == 1 : "group of zeros";

        int[] q7 = {1};
        assert testCase.maxSubArray(q7) == 1 : "just 1";

        int[] q8 = {-1};
        assert testCase.maxSubArray(q8) == -1 : "just -1";

        int[] q9 = {0};
        assert testCase.maxSubArray(q9) == 0 : "just 0";

        int[] q10 = {0, -1, -1, 0, 0, 0, -1, -2, -3};
        assert testCase.maxSubArray(q10) == 0 : "onlt one zero";

        int[] q11 = {0, 0, 0, 0, 0, 0};
        assert testCase.maxSubArray(q11) == 0 : "all zeros";

        System.out.println("all passed");
    }
}

