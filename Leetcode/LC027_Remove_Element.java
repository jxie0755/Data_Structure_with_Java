import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * p027 Remove Element
 * Easy
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class LC027_Remove_Element {

    /**
     * Version C
     */
    public int removeElement(int[] nums, int val) {

        int new_idx = 0;
        int new_len = nums.length;

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != val) {
                nums[new_idx] = nums[i];
                new_idx += 1;
            } else {
                new_len -= 1;
            }
        }
        return new_len;
    }

    public static void main(String[] args) {
        LC027_Remove_Element testCase = new LC027_Remove_Element();

        int[] Q0 = new int[]{};
        assert testCase.removeElement(Q0, 3) == 0 : "Edge";
        assert Arrays.equals(Q0, new int[]{}) : "Edge finish list";

        int[] Q1 = new int[]{3, 2, 2, 3};
        assert testCase.removeElement(Q1, 3) == 2 : "Example 1";
        assert Arrays.equals(Q1, new int[]{2, 2, 2, 3}) : "Example 1 finish list";

        int[] Q2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assert testCase.removeElement(Q2, 2) == 5 : "Example 2";
        assert Arrays.equals(Q2, new int[]{0, 1, 3, 0, 4, 0, 4, 2}) : "Example 2 finish list";

        System.out.println("all passed");
    }
}

