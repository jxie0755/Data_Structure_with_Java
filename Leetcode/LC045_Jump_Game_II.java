/**
 * https://leetcode.com/problems/jump-game-ii/
 * P045 Jump Game II
 * Hard
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
class LC045_Jump_Game_II {

    /**
     * Version C2
     * Improved Recursion method
     * Based on Version C but removed max() and enumerate
     * it is now very similar to non-recursive method, but still slower.
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return this.jump(nums, 0, 0);
    }

    // Overload
    public int jump(int[] nums, int cur_idx, int count) {
        int jump_range = nums[cur_idx];
        if (cur_idx + jump_range >= nums.length - 1) {
            return count + 1;
        } else {
            int best_next_idx = 0;
            int best_reach = 0;
            for (int jump_distance = 1; jump_distance < jump_range + 1; jump_distance += 1) {
                int can_reach = jump_distance + nums[cur_idx + jump_distance];
                if (can_reach >= best_reach) {
                    best_next_idx = cur_idx + jump_distance;
                    best_reach = can_reach;
                }
            }
            return this.jump(nums, best_next_idx, count + 1);
        }
    }

    public static void main(String[] args) {
        LC045_Jump_Game_II testCase = new LC045_Jump_Game_II();

        int[] q0 = {0};
        assert testCase.jump(q0) == 0 : "Edge 0";

        int[] q1 = {2, 1};
        assert testCase.jump(q1) == 1 : "Edge 1";

        int[] q2 = {2, 3, 1, 1, 4};
        assert testCase.jump(q2) == 2 : "Example 1";

        int[] q3 = {2, 9, 6, 5, 7, 0, 7, 2, 7, 9, 3, 2, 2, 5, 7, 8, 1, 6, 6, 6, 3, 5, 2, 2, 6, 3};
        assert testCase.jump(q3) == 5 : "Long 1";

        int[] q4 = {5, 6, 5, 3, 9, 8, 3, 1, 2, 8, 2, 4, 8, 3, 9, 1, 0, 9, 4, 6, 5, 9, 8, 7, 4, 2, 1, 0, 2};
        assert testCase.jump(q4) == 5 : "Long 2";

        int[] q5 = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1,
                6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        assert testCase.jump(q5) == 5 : "Long 3";

        System.out.println("all passed");
    }
}

