import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 * LC018 4Sum
 * Medium
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * The solution set must not contain duplicate quadruplets.
 */
class LC018_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        if (length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i += 1) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                for (int ii = i + 1; ii < length - 2; ii += 1) {
                    if (ii == i + 1 || nums[ii] != nums[ii - 1]) {
                        int j = ii + 1;
                        int k = length - 1;

                        while (j < k) {
                            if (nums[i] + nums[ii] + nums[j] + nums[k] < target) {
                                j += 1;
                            } else if (nums[i] + nums[ii] + nums[j] + nums[k] > target) {
                                k -= 1;
                            } else {
                                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[ii], nums[j], nums[k]));
                                result.add(temp);
                                j += 1;
                                k -= 1;

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
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC018_4Sum testCase = new LC018_4Sum();

        List<List<Integer>> a1 = new ArrayList<>();
        assert testCase.fourSum(new int[]{}, 0).equals(a1) : "Edge 0";

        List<List<Integer>> a2 = new ArrayList<>();
        assert testCase.fourSum(new int[]{1}, 0).equals(a2) : "Edge 1";

        List<Integer> a31 = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        List<List<Integer>> a3 = new ArrayList<>(Arrays.asList(a31));
        assert testCase.fourSum(new int[]{0, 0, 0, 0}, 0).equals(a3) : "Edge 2";

        List<Integer> a41 = new ArrayList<>(Arrays.asList(-2, -1, 1, 2));
        List<Integer> a42 = new ArrayList<>(Arrays.asList(-2, 0, 0, 2));
        List<Integer> a43 = new ArrayList<>(Arrays.asList(-1, 0, 0, 1));
        List<List<Integer>> a4 = new ArrayList<>(Arrays.asList(a41, a42, a43));
        assert testCase.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).equals(a4) : "Example 1";

        List<Integer> a51 = new ArrayList<>(Arrays.asList(-3, -2, 2, 3));
        List<Integer> a52 = new ArrayList<>(Arrays.asList(-3, -1, 1, 3));
        List<Integer> a53 = new ArrayList<>(Arrays.asList(-3, 0, 0, 3));
        List<Integer> a54 = new ArrayList<>(Arrays.asList(-3, 0, 1, 2));
        List<Integer> a55 = new ArrayList<>(Arrays.asList(-2, -1, 0, 3));
        List<Integer> a56 = new ArrayList<>(Arrays.asList(-2, -1, 1, 2));
        List<Integer> a57 = new ArrayList<>(Arrays.asList(-2, 0, 0, 2));
        List<Integer> a58 = new ArrayList<>(Arrays.asList(-1, 0, 0, 1));
        List<List<Integer>> a5 = new ArrayList<>(Arrays.asList(a51, a52, a53, a54, a55, a56, a57, a58));
        assert testCase.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0).equals(a5) : "Example 2";

        System.out.println("All passed");

    }

}

