import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * LC001 Two Sum
 * Easy
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class LC001_Two_Sum {

    /**
     * Version C
     * The same method in LC167 Two Sum II can be used here
     */
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        Map<Integer, Integer> hmp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!hmp.containsKey(cur)) {
                hmp.put(target - cur, i);
            } else {
                ans[0] = hmp.get(cur);
                ans[1] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC001_Two_Sum testCase = new LC001_Two_Sum();

        int[] Q1 = new int[]{11, 2, 7, 15};
        assert Arrays.equals(testCase.twoSum(Q1, 9), new int[]{1, 2}) : "regular";

        int[] Q2 = new int[]{11, 7, 2, 15};
        assert Arrays.equals(testCase.twoSum(Q2, 9), new int[]{1, 2}) : "regular revert";

        int[] Q3 = new int[]{3, 3};
        assert Arrays.equals(testCase.twoSum(Q3, 6), new int[]{0, 1}) : "two identical";

        int[] Q4 = new int[]{-1, -2, -3, -4, -5};
        assert Arrays.equals(testCase.twoSum(Q4, -8), new int[]{2, 4}) : "negative int";

        int[] Q5 = new int[]{3, 2, 4};
        assert Arrays.equals(testCase.twoSum(Q5, 6), new int[]{1, 2}) : "struggle with 1/2 target";

        System.out.println("All passed");
    }
}


