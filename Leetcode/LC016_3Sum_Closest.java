import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * P016 3Sum Closest
 * Medium
 * <p>
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
class LC016_3Sum_Closest {

    /**
     * Version A
     * Similar structure as 3Sum.
     * Revise by checking the 3Sum with Target, and update the 3sum of lowest diff
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i += 1) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int three_sum = nums[i] + nums[j] + nums[k];
                    int check = Math.abs(three_sum - target);

                    if (check < diff) {
                        diff = check;
                        result = three_sum;
                    }

                    if (nums[i] + nums[j] + nums[k] < target) {
                        j += 1;
                    } else if (nums[i] + nums[j] + nums[k] > target) {
                        k -= 1;
                    } else {
                        return target;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC016_3Sum_Closest testCase = new LC016_3Sum_Closest();

        // No need to test edge as gurantee to have exactly one solution
        int[] q1 = new int[]{1, 1, 1};
        assert testCase.threeSumClosest(q1, 1000) == 3 : "Edge";

        int[] q2 = new int[]{-1, 2, 1, -4};
        assert testCase.threeSumClosest(q2, 1) == 2 : "Example 1";

        int[] q3 = new int[]{-1, 2, 1, -1};
        assert testCase.threeSumClosest(q3, 0) == 0 : "Match";

        System.out.println("all passed");

    }
}

