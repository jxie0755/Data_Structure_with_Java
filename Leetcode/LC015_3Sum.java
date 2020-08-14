import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * P015 3Sum
 * Medium
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 */
class LC015_3Sum {

    /**
     * STD ans, Time:  O(n^2)
     * Sort first, then iterate the first element, and find the 2nd and 3rd in the tail from two ends.
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // sort first
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Iterate the first element, and find the 2nd and 3rd in the tail from two ends
        for (int i = 0; i < nums.length - 2; i += 1) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int three_sum = nums[i] + nums[j] + nums[k];

                    if (three_sum < 0) {
                        j += 1;
                    } else if (three_sum > 0) {
                        k -= 1;
                    } else {
                        List<Integer> cur = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        result.add(cur);
                        j = j + 1;
                        k = k - 1;

                        while (j < k && nums[j] == nums[j - 1]) {
                            j += 1;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k -= 1;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC015_3Sum testCase = new LC015_3Sum();

        List<List<Integer>> a1 = new ArrayList<>();
        assert testCase.threeSum(new int[]{0}).equals(a1) : "Edge 1";

        List<List<Integer>> a2 = new ArrayList<>();
        assert testCase.threeSum(new int[]{1}).equals(a2) : "Edge 2";

        List<List<Integer>> a3 = new ArrayList<>();
        assert testCase.threeSum(new int[]{1, 1}).equals(a3) : "Edge 3";

        List<Integer> a41 = new ArrayList<>(Arrays.asList(-1, -1, 2));
        List<Integer> a42 = new ArrayList<>(Arrays.asList(-1, 0, 1));
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList(a41, a42));
        assert testCase.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).equals(a4) : "Example 1";

        List<Integer> a51 = new ArrayList<>(Arrays.asList(-4, -2, 6));
        List<Integer> a52 = new ArrayList<>(Arrays.asList(-4, 0, 4));
        List<Integer> a53 = new ArrayList<>(Arrays.asList(-4, 1, 3));
        List<Integer> a54 = new ArrayList<>(Arrays.asList(-4, 2, 2));
        List<Integer> a55 = new ArrayList<>(Arrays.asList(-2, -2, 4));
        List<Integer> a56 = new ArrayList<>(Arrays.asList(-2, 0, 2));
        List<List<Integer>> a5 = new ArrayList<>(Arrays.asList(a51, a52, a53, a54, a55, a56));
        assert testCase.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}).equals(a5) : "Example 2";

        List<List<Integer>> a6 = new ArrayList<>();
        assert testCase.threeSum(new int[]{-4, -2, -1}).equals(a6) : "Example 3";

        List<Integer> a71 = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<List<Integer>> a7 = new ArrayList<>(Arrays.asList(a71));
        assert testCase.threeSum(new int[]{0, 0, 0}).equals(a7) : "Example 4";

        System.out.println("all passed");
    }
}

