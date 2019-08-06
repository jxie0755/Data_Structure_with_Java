import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * P031 Next Permutation
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
public class LC031_Next_Permutation {

    /**
     * Version B
     * 根据排序情况直接推理
     */
    public void nextPermutation(int[] nums) {

        int length = nums.length;
        int cur_i = -1;

        for (int i = length - 2; i >= 0; i -= 1) {
            if (nums[i] < nums[i + 1]) {
                cur_i = i;
                break;
            }
        }

        // reverse if the array is already reversely sorted
        if (cur_i == -1) {
            this.swap_array(nums, 0, nums.length - 1);
        } else {

            for (int rev_i = length - 1; rev_i > cur_i; rev_i -= 1) {
                if (nums[rev_i] > nums[cur_i]) {

                    // Switch
                    int temp = nums[rev_i];
                    nums[rev_i] = nums[cur_i];
                    nums[cur_i] = temp;

                    // reverse the tail back to sorted
                    this.swap_array(nums, cur_i + 1, nums.length - 1);
                    break;
                }
            }
        }
    }

    // Helper - version B
    // Swap an Array from (start, end)
    private void swap_array(int[] nums, int start, int end) {

        if (nums.length > 0 && end > start) {
            for (int i = start; i <= (end - start) / 2 + start; i += 1) {
                int temp = nums[i];
                nums[i] = nums[end - i + start];
                nums[end - i + start] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int[] Q1 = new int[]{};
        new LC031_Next_Permutation().nextPermutation(Q1);
        assert Arrays.equals(Q1, new int[]{}) : "Edge 1";

        int[] Q2 = new int[]{1};
        new LC031_Next_Permutation().nextPermutation(Q2);
        assert Arrays.equals(Q2, new int[]{1}) : "Edge 2";

        int[] Q3 = new int[]{1, 2};
        new LC031_Next_Permutation().nextPermutation(Q3);
        assert Arrays.equals(Q3, new int[]{2, 1}) : "Edge 3";

        int[] Q4 = new int[]{1, 2, 3};
        new LC031_Next_Permutation().nextPermutation(Q4);
        assert Arrays.equals(Q4, new int[]{1, 3, 2}) : "Example 1";

        int[] Q5 = new int[]{3, 2, 1};
        new LC031_Next_Permutation().nextPermutation(Q5);
        assert Arrays.equals(Q5, new int[]{1, 2, 3}) : "Example 2";

        int[] Q6 = new int[]{1, 1, 5};
        new LC031_Next_Permutation().nextPermutation(Q6);
        assert Arrays.equals(Q6, new int[]{1, 5, 1}) : "Example 3";

        int[] Q7 = new int[]{5, 1, 1};
        new LC031_Next_Permutation().nextPermutation(Q7);
        assert Arrays.equals(Q7, new int[]{1, 1, 5}) : "Extra 1";

        int[] Q8 = new int[]{2, 2, 2};
        new LC031_Next_Permutation().nextPermutation(Q8);
        assert Arrays.equals(Q8, new int[]{2, 2, 2}) : "Extra 2";

        int[] Q9 = new int[]{1, 2, 2, 2};
        new LC031_Next_Permutation().nextPermutation(Q9);
        assert Arrays.equals(Q9, new int[]{2, 1, 2, 2}) : "Extra 3";

        int[] Q10 = new int[]{2, 3, 1};
        new LC031_Next_Permutation().nextPermutation(Q10);
        assert Arrays.equals(Q10, new int[]{3, 1, 2}) : "Extra 4";

        System.out.println("all passed");

    }

}

