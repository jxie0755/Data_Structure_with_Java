import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * p001 Two Sum
 * Easy
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class LC001_Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        Map<Integer, Integer> hmp = new HashMap<>();
        for (int i : nums) {
            if (hmp.containsKey(i)) {
                ans[0] = hmp.get(i);
                ans[1] = i;
            } else {
                hmp.put(9-i, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] Q1 = new int[]{2, 7, 11, 15};
        LC001_Solution A1 = new LC001_Solution();
        assert Arrays.equals(A1.twoSum(Q1, 9), new int[]{2, 7});

        System.out.println("all passed");
    }

}


