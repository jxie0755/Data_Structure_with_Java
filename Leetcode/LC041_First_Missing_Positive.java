/**
 * https://leetcode.com/problems/first-missing-positive/
 * P041 First Missing Positive
 * Hard
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
class LC041_First_Missing_Positive {


    /**
     * Version STD
     * 桶排序
     * O(N)
     */
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int A = nums[i];
                int B = nums[nums[i] - 1];
                nums[nums[i] - 1] = A;
                nums[i] = B;
            } else {
                i += 1;
            }
        }

        for (int j = 0; j < n; j += 1) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        LC041_First_Missing_Positive testCase = new LC041_First_Missing_Positive();
        int[] q1 = {};
        assert testCase.firstMissingPositive(q1) == 1 : "Edge 0";

        int[] q2 = {1};
        assert testCase.firstMissingPositive(q2) == 2 : "Edge 1";

        int[] q3 = {2};
        assert testCase.firstMissingPositive(q3) == 1 : "Edge 2";

        int[] q4 = {-1};
        assert testCase.firstMissingPositive(q4) == 1 : "Edge 3";

        int[] q5 = {1, 2, 0};
        assert testCase.firstMissingPositive(q5) == 3 : "Example 1";

        int[] q6 = {3, 4, -1, 1};
        assert testCase.firstMissingPositive(q6) == 2 : "Example 2";

        int[] q7 = {7, 8, 99, 11, 12};
        assert testCase.firstMissingPositive(q7) == 1 : "Example 3";

        int[] q8 = {2, 2};
        assert testCase.firstMissingPositive(q8) == 1 : "Extra 1";

        System.out.println("All passed");

    }

}

