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

        int i = 0;
        int n = 0;
        int L = nums.length;

        while (n < nums.length) {
            if (nums[n] != val) {
                nums[i] = nums[n];
                i += 1;
            } else {
                L -= 1;
            }
            n += 1;
        }
        return L;
    }

    public static void main(String[] args) {

        int[] Q0 = new int[]{};
        assert new LC027_Remove_Element().removeElement(Q0, 3) == 0 : "Edge";
        assert Arrays.equals(Q0, new int[]{}) : "Edge finish list";

        int[] Q1 = new int[]{3, 2, 2, 3};
        assert new LC027_Remove_Element().removeElement(Q1, 3) == 2 : "Example 1";
        assert Arrays.equals(Q1, new int[]{2, 2, 2, 3}) : "Example 1 finish list";

        int[] Q2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assert new LC027_Remove_Element().removeElement(Q2, 2) == 5 : "Example 2";
        assert Arrays.equals(Q2, new int[]{0, 1, 3, 0, 4, 0, 4, 2}) : "Example 2 finish list";

        System.out.println("all passed");
    }
}

