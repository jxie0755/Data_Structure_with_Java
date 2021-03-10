import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * LC031 Next Permutation
 * Medium
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * Do not return anything, modify nums in-place instead!
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * Means you cannot list out all permutation and sort it, then find the next one.
 * <p>
 * Correct sequence (sorted):
 * (1, 2, 3, 4)
 * (1, 2, 4, 3)
 * (1, 3, 2, 4)
 * (1, 3, 4, 2)
 * (1, 4, 2, 3)
 * (1, 4, 3, 2)
 * (2, 1, 3, 4)
 * (2, 1, 4, 3)
 * (2, 3, 1, 4)
 * (2, 3, 4, 1)
 * (2, 4, 1, 3)
 * (2, 4, 3, 1)
 * (3, 1, 2, 4)
 * (3, 1, 4, 2)
 * (3, 2, 1, 4)
 * (3, 2, 4, 1)
 * (3, 4, 1, 2)
 * (3, 4, 2, 1)
 * (4, 1, 2, 3)
 * (4, 1, 3, 2)
 * (4, 2, 1, 3)
 * (4, 2, 3, 1)
 * (4, 3, 1, 2)
 * (4, 3, 2, 1)
 */
class LC031_Next_Permutation {

    /**
     * Helper
     * Reverse an Array by Swap from (start, end) to mid point
     */
    private void swap_array(int[] nums, int start, int end) {

        if (nums.length > 0 && end > start) {
            for (int i = start; i <= (end - start) / 2 + start; i += 1) {
                int temp = nums[i];
                nums[i] = nums[end - i + start];
                nums[end - i + start] = temp;
            }
        }
    }


    /**
     * Version B
     * 根据排序情况直接推理
     */
    public void nextPermutation(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int first_idx = nums.length - 2;
        int second_idx = nums.length - 1;

        // 先定位first_idx
        while (first_idx >= 0 && nums[first_idx] >= nums[first_idx + 1]) {
            first_idx -= 1;
        }

        // reverse if the array is already reversely sorted
        if (first_idx == -1) {
            this.swap_array(nums, 0, nums.length - 1);
        } else {
            while (nums[second_idx] <= nums[first_idx]) {
                second_idx -= 1;
            }

            // complete the swap
            int temp = nums[second_idx];
            nums[second_idx] = nums[first_idx];
            nums[first_idx] = temp;

            // reverse the tail back to sorted
            this.swap_array(nums, first_idx + 1, nums.length - 1);
        }
    }

    /**
     * This the the oppositve function to find previous permutation
     * Only need to simply modify the two places
     */
    public void prevPermutation(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int first_idx = nums.length - 2;
        int second_idx = nums.length - 1;

        while (first_idx >= 0 && nums[first_idx] <= nums[first_idx + 1]) {
            first_idx -= 1;                      //////// reverse comparison
        }

        // reverse if the array is already reversely sorted
        if (first_idx == -1) {
            this.swap_array(nums, 0, nums.length - 1);
        } else {
            while (nums[second_idx] >= nums[first_idx]) {
                second_idx -= 1;    /////////// reverse comparison
            }

            // complete the swap
            int temp = nums[second_idx];
            nums[second_idx] = nums[first_idx];
            nums[first_idx] = temp;

            // reverse the tail
            this.swap_array(nums, first_idx + 1, nums.length - 1);
        }
    }


    public static void main(String[] args) {
        LC031_Next_Permutation testCase = new LC031_Next_Permutation();

        int[] Q1 = new int[]{};
        testCase.nextPermutation(Q1);
        assert Arrays.equals(Q1, new int[]{}) : "Edge 0";
        testCase.prevPermutation(Q1);
        assert Arrays.equals(Q1, new int[]{}) : "Edge 0 prev";


        int[] Q2 = new int[]{1};
        testCase.nextPermutation(Q2);
        assert Arrays.equals(Q2, new int[]{1}) : "Edge 1";
        testCase.prevPermutation(Q2);
        assert Arrays.equals(Q2, new int[]{1}) : "Edge 1 prev";


        int[] Q3 = new int[]{1, 2};
        testCase.nextPermutation(Q3);
        assert Arrays.equals(Q3, new int[]{2, 1}) : "Edge 2";
        testCase.prevPermutation(Q3);
        assert Arrays.equals(Q3, new int[]{1, 2}) : "Edge 2 prev";


        int[] Q4 = new int[]{1, 2, 3};
        testCase.nextPermutation(Q4);
        assert Arrays.equals(Q4, new int[]{1, 3, 2}) : "Example 1";
        testCase.prevPermutation(Q4);
        assert Arrays.equals(Q4, new int[]{1, 2, 3}) : "Example 1 prev";


        int[] Q5 = new int[]{3, 2, 1};
        testCase.nextPermutation(Q5);
        assert Arrays.equals(Q5, new int[]{1, 2, 3}) : "Example 2";
        testCase.prevPermutation(Q5);
        assert Arrays.equals(Q5, new int[]{3, 2, 1}) : "Example 2 prev";


        int[] Q6 = new int[]{1, 1, 5};
        testCase.nextPermutation(Q6);
        assert Arrays.equals(Q6, new int[]{1, 5, 1}) : "Example 3";
        testCase.prevPermutation(Q6);
        assert Arrays.equals(Q6, new int[]{1, 1, 5}) : "Example 3 prev";


        int[] Q7 = new int[]{5, 1, 1};
        testCase.nextPermutation(Q7);
        assert Arrays.equals(Q7, new int[]{1, 1, 5}) : "Additional 1";
        testCase.prevPermutation(Q7);
        assert Arrays.equals(Q7, new int[]{5, 1, 1}) : "Additional 1 prev";


        int[] Q8 = new int[]{2, 2, 2};
        testCase.nextPermutation(Q8);
        assert Arrays.equals(Q8, new int[]{2, 2, 2}) : "Additional 2";
        testCase.prevPermutation(Q8);
        assert Arrays.equals(Q8, new int[]{2, 2, 2}) : "Additional 2 prev";


        int[] Q9 = new int[]{1, 2, 2, 2};
        testCase.nextPermutation(Q9);
        assert Arrays.equals(Q9, new int[]{2, 1, 2, 2}) : "Additional 3";
        testCase.prevPermutation(Q9);
        assert Arrays.equals(Q9, new int[]{1, 2, 2, 2}) : "Additional 3 prev";


        int[] Q10 = new int[]{2, 3, 1};
        testCase.nextPermutation(Q10);
        assert Arrays.equals(Q10, new int[]{3, 1, 2}) : "Additional 4";
        testCase.prevPermutation(Q10);
        assert Arrays.equals(Q10, new int[]{2, 3, 1}) : "Additional 4 prev";

        System.out.println("All passed");

    }
}

