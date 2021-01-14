/**
 * https://leetcode.com/problems/jump-game/
 * P055 Jump Game
 * Medium
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
class LC055_Jump_Game {

    /**
     * STD ans
     */
    public boolean canJump(int[] nums) {

        int max_reachable_idx = 0;

        for (int idx = 0; idx < nums.length; idx += 1) {
            int jump_range = nums[idx];
            if (idx > max_reachable_idx) {
                return false;
            }
            max_reachable_idx = Math.max(max_reachable_idx, idx + jump_range);
        }
        return true;
    }


    public static void main(String[] args) {
        LC055_Jump_Game testCase = new LC055_Jump_Game();
        int[] q1 = {0};
        assert testCase.canJump(q1) : "Edge 1";

        int[] q2 = {0, 0};
        assert !testCase.canJump(q2) : "Edge 2";

        int[] q3 = {1, 0};
        assert testCase.canJump(q3) : "Edge 3";

        int[] q4 = {1, 0, 0, 0};
        assert !testCase.canJump(q4) : "Edge 4";

        int[] q5 = {2, 3, 1, 1, 4};
        assert testCase.canJump(q5) : "Example 1";

        int[] q6 = {3, 2, 1, 0, 4};
        assert !testCase.canJump(q6) : "Example 2";

        int[] q7 = {3, 2, 5, 0, 1, 0, 0, 0};
        assert testCase.canJump(q7) : "Additional 1";

        int[] q8 = {3, 2, 5, 0, 1, 0, 0, 2, 0, 0, 1};
        assert !testCase.canJump(q8) : "Additional 2";

        System.out.println("All passed");
    }
}

